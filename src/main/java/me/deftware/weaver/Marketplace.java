/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  org.apache.commons.lang3.StringUtils
 */
package me.deftware.weaver;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.deftware.weaver.Download;
import me.deftware.weaver.Logger;
import me.deftware.weaver.Main;
import me.deftware.weaver.Module;
import me.deftware.weaver.Version;
import org.apache.commons.lang3.StringUtils;

public class Marketplace {
    public static Marketplace INSTANCE;
    private final Logger logger = new Logger("Marketplace");
    private final Map<String, Path> paths = new HashMap<String, Path>();
    private final Version version;
    private final Map<String, Module> modules = new HashMap<String, Module>();

    public Marketplace(Version version) {
        this.version = version;
        this.paths.put("fabric", Main.emc);
        this.paths.put("mods", Main.mods);
        this.paths.put("emc", Main.emcMods);
        this.paths.put("libraries", Main.libraries);
    }

    public void init() throws Exception {
        this.logger.info("Fetching marketplace index", new Object[0]);
        URL url = new URL("https://gitlab.com/EMC-Framework/maven/-/raw/master/marketplace/index.json");
        try (InputStream stream = url.openStream();
             InputStreamReader reader = new InputStreamReader(stream);){
            Module[] modules;
            JsonObject json = (JsonObject)new Gson().fromJson((Reader)reader, JsonObject.class);
            for (Module m : modules = (Module[])new Gson().fromJson((JsonElement)json.getAsJsonArray("mods"), Module[].class)) {
                m.run();
                if (!m.isCompatible()) continue;
                this.logger.info("Found compatible mod %s", m.id);
                if (m.isMarkedUninstall()) {
                    this.logger.warn("Mod %s is marked for deletion", m.id);
                    m.uninstall();
                    continue;
                }
                this.modules.put(m.id, m);
            }
        }
    }

    public void deduplicate() {
        for (Module module : this.modules.values()) {
            if (!module.isInstalled()) continue;
            for (Download download : module.getCompatibleDownloads()) {
                Path parent = download.path.getParent();
                String name = download.path.getName().toLowerCase();
                String noExtension = name.substring(0, name.length() - ".jar".length());
                try {
                    Stream<Path> stream = Files.list(parent);
                    try {
                        List files = stream.collect(Collectors.toList());
                        for (Path path : files) {
                            String fileName = path.getFileName().toString().toLowerCase();
                            if (!fileName.contains(noExtension) || fileName.equalsIgnoreCase(name)) continue;
                            this.logger.warn("Removing duplicate jar file %s (from %s)", fileName, name);
                            Files.delete(path);
                        }
                    }
                    finally {
                        if (stream == null) continue;
                        stream.close();
                    }
                }
                catch (Exception ex) {
                    this.logger.error("Unable to deduplicate files", ex);
                }
            }
        }
    }

    public void repair() throws Exception {
        for (Module module : this.modules.values()) {
            if (!module.isInstalled()) continue;
            this.logger.info("Verifying installed mod %s", module.id);
            for (Download download : module.getCompatibleDownloads()) {
                Path file = download.path.getPath();
                String name = file.getFileName().toString();
                if (StringUtils.isEmpty((CharSequence)download.sha1)) {
                    this.logger.warn("Missing SHA1 for %s", name);
                    continue;
                }
                if (Files.exists(file, new LinkOption[0])) {
                    String checksum = this.SHA1(file);
                    if (checksum.equalsIgnoreCase(download.sha1)) {
                        this.logger.info("%s up to date", name);
                        continue;
                    }
                    this.logger.warn("Invalid checksum for local file %s", name);
                    this.logger.warn("Expected %s but found %s", download.sha1, checksum);
                    try {
                        Files.delete(file);
                    }
                    catch (Exception ex) {
                        this.logger.warn("Unable to delete file", ex);
                    }
                } else {
                    this.logger.warn("Missing file %s", name);
                    if (!download.regenerate) {
                        this.logger.warn("Download is marked not to regenerate, skipping", new Object[0]);
                        continue;
                    }
                }
                this.logger.info("Downloading %s", download.url);
                download.download();
            }
        }
    }

    private String SHA1(Path path) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] bytes = Files.readAllBytes(path);
        byte[] digested = messageDigest.digest(bytes);
        StringBuilder builder = new StringBuilder();
        for (byte b : digested) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public Map<String, Path> getPaths() {
        return this.paths;
    }

    public Version getVersion() {
        return this.version;
    }

    public Map<String, Module> getModules() {
        return this.modules;
    }
}

