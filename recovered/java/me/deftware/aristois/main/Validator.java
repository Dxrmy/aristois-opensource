package me.deftware.aristois.main;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import me.deftware.aristois.recovered.C0139;
import me.deftware.aristois.recovered.C0203;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.FrameworkConstants.MappingSystem;
import me.deftware.client.framework.FrameworkConstants.MappingsLoader;
import me.deftware.client.framework.helper.Logger;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.path.LocationUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class Validator {
   private static final Logger LOGGER = new Logger("Validator");
   private static final String MAVEN_REPO = "https://gitlab.com/EMC-Framework/maven/-/raw/master";
   private static final C0203<String> remoteChecksum = new C0203<>(() -> {
      String group = "me.deftware";
      String name = "EMC";
      String version = "latest-" + Minecraft.getMinecraftVersion();
      if (FrameworkConstants.MAPPING_LOADER == MappingsLoader.Forge) {
         name = name + "-Forge";
      } else if (FrameworkConstants.MAPPING_LOADER == MappingsLoader.Fabric) {
         name = name + "-F";
         if (FrameworkConstants.MAPPING_SYSTEM == MappingSystem.YarnV2) {
            name = name + "-v2";
         }
      }

      String artifact = name + "-" + version + ".jar";
      String path = group.replaceAll("\\.", "/") + "/" + name + "/" + version + "/" + artifact;

      try {
         URL url = new URL("https://gitlab.com/EMC-Framework/maven/-/raw/master/" + path + ".sha1");

         String var10;
         try (
            InputStream stream = url.openStream();
            BufferedInputStream buffer = new BufferedInputStream(stream);
         ) {
            var10 = IOUtils.toString(buffer, StandardCharsets.UTF_8).trim();
         }

         return var10;
      } catch (Exception var39) {
         LOGGER.error("Unable to retrieve remote checksum for EMC jar", new Object[0]);
         return null;
      }
   });
   private static final C0203<String> localChecksum = new C0203<>(() -> {
      try {
         Path path;
         if (FrameworkConstants.MAPPING_LOADER == MappingsLoader.Forge) {
            Path gameDir = Paths.get(Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath());
            Path mods = gameDir.resolve("mods");
            if (Minecraft.getMinecraftProtocolVersion() <= 340) {
               mods = mods.resolve(Minecraft.getMinecraftVersion());
            }

            path = mods.resolve("EMC.jar");
         } else {
            path = Paths.get(LocationUtil.getEMC().toFile().getAbsolutePath());
         }

         if (!Files.exists(path)) {
            throw new IOException("Unable to find EMC jar file");
         } else {
            return SHA1(path);
         }
      } catch (Exception var3) {
         LOGGER.error("Unable to retrieve local checksum of EMC jar", new Object[0]);
         LOGGER.debug("Caused by {}", new Object[]{var3.getMessage()});
         return null;
      }
   });

   public Validator() {
   }

   public static boolean isRuntimeValid() {
      return StringUtils.equalsIgnoreCase(getRemoteChecksum(), getLocalChecksum());
   }

   public static synchronized String getRemoteChecksum() {
      return remoteChecksum.m_ac6eac3b();
   }

   public static synchronized String getLocalChecksum() {
      return localChecksum.m_ac6eac3b();
   }

   private static String SHA1(Path path) throws Exception {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      byte[] bytes = Files.readAllBytes(path);
      byte[] digested = messageDigest.digest(bytes);
      StringBuilder builder = new StringBuilder();

      for (byte b : digested) {
         builder.append(String.format("%02x", b));
      }

      return builder.toString();
   }

   public static Validator.Version[] getVersions() throws IOException {
      Gson gson = new Gson();
      URL url = new URL("https://maven.aristois.net/manifest");
      URLConnection connection = url.openConnection();
      connection.setRequestProperty("User-Agent", C0139.f_a07ec47b);
      connection.setConnectTimeout(3000);

      Validator.Version[] var9;
      try (
         InputStream stream = connection.getInputStream();
         Reader reader = new InputStreamReader(stream);
      ) {
         JsonObject json = (JsonObject)gson.fromJson(reader, JsonObject.class);
         JsonArray versions = json.getAsJsonArray("versions");
         var9 = (Validator.Version[])gson.fromJson(versions, Validator.Version[].class);
      }

      return var9;
   }

   public static class Version {
      @SerializedName("id")
      public String id;
      @SerializedName("protocol")
      public int protocol;

      public Version() {
      }
   }
}
