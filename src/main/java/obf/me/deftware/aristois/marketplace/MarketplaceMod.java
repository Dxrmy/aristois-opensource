/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.annotations.SerializedName
 *  me.deftware.client.framework.fonts.FontRenderer
 *  me.deftware.client.framework.gui.widgets.SelectableList$ListItem
 *  me.deftware.client.framework.message.Appearance
 *  me.deftware.client.framework.message.Appearance$FormattingColor
 *  me.deftware.client.framework.message.DefaultColors
 *  me.deftware.client.framework.message.Message
 *  me.deftware.client.framework.minecraft.Minecraft
 *  me.deftware.client.framework.render.texture.GlTexture
 *  me.deftware.client.framework.util.path.LocationUtil
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package me.deftware.aristois.marketplace;

import \u0000nunyaboolean.catch.for.for.try;
import \u0000nunyaboolean.catch.for.implements.break;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import me.deftware.aristois.marketplace.Download;
import me.deftware.aristois.marketplace.Marketplace;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.path.LocationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MarketplaceMod
implements Runnable,
SelectableList.ListItem {
    final public static Path minecraftPath = Paths.get(Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath(), new String[0]);
    final public static Path fabricModPath = Paths.get(System.getProperty("EMCDir", Objects.requireNonNull(LocationUtil.getEMC().toFile()).getParentFile().getAbsolutePath()), new String[0]);
    final public static Path modPath = minecraftPath.resolve("mods");
    final public static Path emcModPath = minecraftPath.resolve("libraries").resolve("EMC").resolve(Minecraft.getMinecraftVersion());
    final public static Path libraries = minecraftPath.resolve("libraries").resolve("downloads");
    @SerializedName(value="beta")
    public boolean beta;
    @SerializedName(value="maintenance")
    public boolean maintenance;
    @SerializedName(value="id")
    public String id;
    @SerializedName(value="name")
    public String name;
    @SerializedName(value="platform")
    public String platform = "(.*?)";
    @SerializedName(value="java")
    public String java = "(.*?)";
    @SerializedName(value="author")
    public String author;
    @SerializedName(value="version")
    public String version;
    @SerializedName(value="sha1")
    public String sha1;
    @SerializedName(value="icon")
    public String icon;
    @SerializedName(value="summary")
    public String summary;
    @SerializedName(value="downloads")
    public Map<String, List<Download>> downloadsMap;
    @SerializedName(value="depends")
    public ArrayList<String> depends;
    @SerializedName(value="description")
    public ArrayList<String> description;
    @SerializedName(value="conflicts")
    public ArrayList<String> conflicts;
    private Logger logger;
    private boolean supported = false;
    private boolean markedForDeletion = false;
    private GlTexture iconTexture;
    final private List<Download> downloads = new ArrayList<Download>();
    final private List<File> files = new ArrayList<File>();

    public static String format(String input) {
        return input.replace("%mc%", Minecraft.getMinecraftVersion());
    }

    public boolean isInstalled() {
        return this.files.stream().filter(File::exists).count() == (long)this.files.size();
    }

    @Override
    public void run() {
        this.logger = LogManager.getLogger((String)(this.id + "/Marketplace"));
        if (!System.getProperty("os.name").matches(this.platform) || !System.getProperty("java.version").matches(this.java)) {
            this.logger.info("{} requires Java {} and platform {}, ignoring mod", new Object[]{this.id, this.java, this.platform});
            return;
        }
        if (this.icon != null && !this.icon.isEmpty()) {
            this.iconTexture = new try(this.icon);
        }
        if (this.downloadsMap != null) {
            for (Map.Entry<String, List<Download>> entry : this.downloadsMap.entrySet()) {
                if (!Minecraft.getMinecraftVersion().matches(entry.getKey())) continue;
                this.downloads.addAll((Collection<Download>)entry.getValue());
            }
            boolean bl = this.supported = !this.downloads.isEmpty() && this.downloads.stream().anyMatch(Download::isCompatible);
            if (this.supported) {
                this.iterate(download -> this.files.add(download.getPath().toFile()));
            }
        }
    }

    private void dependencies() throws Exception {
        for (MarketplaceMod dependency : Marketplace.INSTANCE.getModMap()) {
            if (!this.depends.contains(dependency.getId()) || dependency.isInstalled()) continue;
            dependency.install();
        }
    }

    public void install() throws Exception {
        if (this.markedForDeletion || this.isInstalled() || !this.isSupported()) {
            throw new Exception("Cannot install mod that is already installed or marked for deletion, or is unsupported");
        }
        if (this.conflicts != null) {
            for (String conflict : this.conflicts) {
                if (!Marketplace.INSTANCE.isInstalled(conflict)) continue;
                throw new Exception("Unable to install due to conflicting mod " + conflict);
            }
        }
        if (this.depends != null) {
            this.dependencies();
        }
        this.logger.info("Installing {} version {} by {}", new Object[]{this.id, this.version, this.author});
        this.download();
    }

    private void iterate(Catchable<Download> consumer) throws Exception {
        for (Download download : this.downloads) {
            if (download.isCompatible() && !consumer.accept(download)) break;
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
                if (file.delete()) continue;
                this.markedForDeletion = true;
                if (file.getParent().equals(fabricModPath.toString())) {
                    this.logger.warn("Unable to delete {}, marking jar for deletion on next startup", new Object[]{file.getName()});
                    try {
                        break.implements((JsonElement)new JsonObject(), new File(file.getAbsolutePath() + ".delete"));
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    continue;
                }
                this.logger.warn("Unable to delete {}, marking for deletion by JVM", new Object[]{file.getName()});
                file.deleteOnExit();
            }
            if (this.markedForDeletion) {
                Marketplace.INSTANCE.getModMap().remove(this);
            }
            return true;
        }
        this.logger.error("Cannot uninstall a mod that is not installed or marked for deletion");
        return false;
    }

    public void render(int index, int x, int y, int entryWidth, int entryHeight, int mouseX, int mouseY, float tickDelta) {
        int textureX = x - 8;
        int textureY = y + 1;
        Message details = Message.of((String)("By " + this.getAuthor())).style(Appearance.of(16, (Appearance.FormattingColor)DefaultColors.GRAY));
        FontRenderer.drawString((Message)details, (int)(entryWidth - FontRenderer.getStringWidth((Message)details)), (int)(y += 3), 0xFFFFFF);
        FontRenderer.drawString((Message)Message.of((String)(this.getName() + (this.isBeta() ? " (Beta)" : ""))).style(Appearance.of((Appearance.FormattingColor)(this.isInstalled() ? DefaultColors.GREEN : DefaultColors.WHITE))), (int)(x += 20), (int)y, 0xFFFFFF);
        FontRenderer.drawString((Message)Message.of((String)this.getSummary()).style(Appearance.of((Appearance.FormattingColor)DefaultColors.GRAY)), (int)x, (int)(y += FontRenderer.getFontHeight() + 2), 0xFFFFFF);
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
    private static interface Catchable<T> {
        public boolean accept(T var1) throws Exception;
    }
}

