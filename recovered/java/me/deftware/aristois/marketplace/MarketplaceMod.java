package me.deftware.aristois.marketplace;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import me.deftware.aristois.recovered.C0148;
import me.deftware.aristois.recovered.C0198;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.path.LocationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MarketplaceMod implements Runnable, ListItem {
   public static final Path minecraftPath = Paths.get(Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath());
   public static final Path fabricModPath = Paths.get(
      System.getProperty("EMCDir", Objects.requireNonNull(LocationUtil.getEMC().toFile()).getParentFile().getAbsolutePath())
   );
   public static final Path modPath = minecraftPath.resolve("mods");
   public static final Path emcModPath = minecraftPath.resolve("libraries").resolve("EMC").resolve(Minecraft.getMinecraftVersion());
   public static final Path libraries = minecraftPath.resolve("libraries").resolve("downloads");
   @SerializedName("beta")
   public boolean beta;
   @SerializedName("maintenance")
   public boolean maintenance;
   @SerializedName("id")
   public String id;
   @SerializedName("name")
   public String name;
   @SerializedName("platform")
   public String platform = "(.*?)";
   @SerializedName("java")
   public String java = "(.*?)";
   @SerializedName("author")
   public String author;
   @SerializedName("version")
   public String version;
   @SerializedName("sha1")
   public String sha1;
   @SerializedName("icon")
   public String icon;
   @SerializedName("summary")
   public String summary;
   @SerializedName("downloads")
   public Map<String, List<Download>> downloadsMap;
   @SerializedName("depends")
   public ArrayList<String> depends;
   @SerializedName("description")
   public ArrayList<String> description;
   @SerializedName("conflicts")
   public ArrayList<String> conflicts;
   private Logger logger;
   private boolean supported = false;
   private boolean markedForDeletion = false;
   private GlTexture iconTexture;
   private final List<Download> downloads = new ArrayList<>();
   private final List<File> files = new ArrayList<>();

   public MarketplaceMod() {
   }

   public static String format(String input) {
      return input.replace("%mc%", Minecraft.getMinecraftVersion());
   }

   public boolean isInstalled() {
      return this.files.stream().filter(File::exists).count() == (long)this.files.size();
   }

   @Override
   public void run() {
      try {
         this.logger = LogManager.getLogger(this.id + "/Marketplace");
         if (System.getProperty("os.name").matches(this.platform) && System.getProperty("java.version").matches(this.java)) {
            if (this.icon != null && !this.icon.isEmpty()) {
               this.iconTexture = new C0148(this.icon);
            }

            if (this.downloadsMap != null) {
               for (Entry<String, List<Download>> entry : this.downloadsMap.entrySet()) {
                  if (Minecraft.getMinecraftVersion().matches(entry.getKey())) {
                     this.downloads.addAll(entry.getValue());
                  }
               }

               this.supported = !this.downloads.isEmpty() && this.downloads.stream().anyMatch(Download::isCompatible);
               if (this.supported) {
                  this.iterate(download -> this.files.add(download.getPath().toFile()));
               }
            }
         } else {
            this.logger.info("{} requires Java {} and platform {}, ignoring mod", new Object[]{this.id, this.java, this.platform});
         }
      } catch (Throwable var3) {
         throw var3;
      }
   }

   private void dependencies() throws Exception {
      for (MarketplaceMod dependency : Marketplace.INSTANCE.getModMap()) {
         if (this.depends.contains(dependency.getId()) && !dependency.isInstalled()) {
            dependency.install();
         }
      }
   }

   public void install() throws Exception {
      if (!this.markedForDeletion && !this.isInstalled() && this.isSupported()) {
         if (this.conflicts != null) {
            for (String conflict : this.conflicts) {
               if (Marketplace.INSTANCE.isInstalled(conflict)) {
                  throw new Exception("Unable to install due to conflicting mod " + conflict);
               }
            }
         }

         if (this.depends != null) {
            this.dependencies();
         }

         this.logger.info("Installing {} version {} by {}", new Object[]{this.id, this.version, this.author});
         this.download();
      } else {
         throw new Exception("Cannot install mod that is already installed or marked for deletion, or is unsupported");
      }
   }

   private void iterate(MarketplaceMod.Catchable<Download> consumer) throws Exception {
      for (Download download : this.downloads) {
         if (download.isCompatible() && !consumer.accept(download)) {
            break;
         }
      }
   }

   private void download() throws Exception {
      if (!this.downloads.isEmpty()) {
         this.iterate(download -> {
            this.logger.info("Downloading {}", new Object[]{download.getUrl()});
            download.run();
            this.logger.info("Installed to {}", new Object[]{download.getPath().toFile().getAbsolutePath()});
            return true;
         });
      }
   }

   public boolean uninstall() {
      if (this.isInstalled() && !this.markedForDeletion) {
         for (File file : this.getFiles()) {
            this.logger.info("Deleting {}", new Object[]{file.getName()});
            if (!file.delete()) {
               this.markedForDeletion = true;
               if (file.getParent().equals(fabricModPath.toString())) {
                  this.logger.warn("Unable to delete {}, marking jar for deletion on next startup", new Object[]{file.getName()});

                  try {
                     C0198.m_6efd6053(new JsonObject(), new File(file.getAbsolutePath() + ".delete"));
                  } catch (Exception var4) {
                     var4.printStackTrace();
                  }
               } else {
                  this.logger.warn("Unable to delete {}, marking for deletion by JVM", new Object[]{file.getName()});
                  file.deleteOnExit();
               }
            }
         }

         if (this.markedForDeletion) {
            Marketplace.INSTANCE.getModMap().remove(this);
         }

         return true;
      } else {
         this.logger.error("Cannot uninstall a mod that is not installed or marked for deletion");
         return false;
      }
   }

   public void render(int index, int x, int y, int entryWidth, int entryHeight, int mouseX, int mouseY, float tickDelta) {
      int textureX = x - 8;
      int textureY = y + 1;
      x += 20;
      y += 3;
      Message details = Message.of("By " + this.getAuthor()).style(Appearance.of(16, DefaultColors.GRAY));
      FontRenderer.drawString(details, entryWidth - FontRenderer.getStringWidth(details), y, 16777215);
      FontRenderer.drawString(
         Message.of(this.getName() + (this.isBeta() ? " (Beta)" : "")).style(Appearance.of(this.isInstalled() ? DefaultColors.GREEN : DefaultColors.WHITE)),
         x,
         y,
         16777215
      );
      int var15;
      FontRenderer.drawString(Message.of(this.getSummary()).style(Appearance.of(DefaultColors.GRAY)), x, var15 = y + FontRenderer.getFontHeight() + 2, 16777215);
      GlTexture texture = this.getIconTexture();
      if (texture != null && texture.isReady()) {
         texture.bind().draw(textureX, textureY, 24, 24).unbind();
      }
   }

   public boolean isBeta() {
      return this.beta;
   }

   public boolean isMaintenance() {
      return this.maintenance;
   }

   public String getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getPlatform() {
      return this.platform;
   }

   public String getJava() {
      return this.java;
   }

   public String getAuthor() {
      return this.author;
   }

   public String getVersion() {
      return this.version;
   }

   public String getSha1() {
      return this.sha1;
   }

   public String getIcon() {
      return this.icon;
   }

   public String getSummary() {
      return this.summary;
   }

   public Map<String, List<Download>> getDownloadsMap() {
      return this.downloadsMap;
   }

   public ArrayList<String> getDepends() {
      return this.depends;
   }

   public ArrayList<String> getDescription() {
      return this.description;
   }

   public ArrayList<String> getConflicts() {
      return this.conflicts;
   }

   public Logger getLogger() {
      return this.logger;
   }

   public boolean isSupported() {
      return this.supported;
   }

   public boolean isMarkedForDeletion() {
      return this.markedForDeletion;
   }

   public GlTexture getIconTexture() {
      return this.iconTexture;
   }

   public List<Download> getDownloads() {
      return this.downloads;
   }

   public List<File> getFiles() {
      return this.files;
   }

   @FunctionalInterface
   private interface Catchable<T> {
      boolean accept(T var1) throws Exception;
   }
}
