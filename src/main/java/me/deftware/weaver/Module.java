/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package me.deftware.weaver;

import com.google.gson.annotations.SerializedName;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.deftware.weaver.Download;
import me.deftware.weaver.Logger;
import me.deftware.weaver.Main;
import me.deftware.weaver.Marketplace;

public class Module {
    @SerializedName(value="id")
    public String id;
    @SerializedName(value="downloads")
    private Map<String, List<Download>> downloadsMap;
    @SerializedName(value="depends")
    public List<String> depends;
    private final List<Download> compatibleDownloads = new ArrayList<Download>();
    private Logger logger;

    public void run() {
        this.logger = new Logger("Mod/" + this.id);
        if (this.downloadsMap != null) {
            for (Map.Entry<String, List<Download>> entry : this.downloadsMap.entrySet()) {
                if (!Main.version.getId().matches(entry.getKey())) continue;
                for (Download download : entry.getValue()) {
                    if (!download.isCompatible()) continue;
                    this.compatibleDownloads.add(download);
                }
            }
        }
    }

    private void delete(Path path) throws Exception {
        if (Files.deleteIfExists(path)) {
            this.logger.info("Deleting %s", path.getFileName().toString());
        }
    }

    public void uninstall() {
        this.logger.info("Uninstalling...", new Object[0]);
        for (Download download : this.compatibleDownloads) {
            if (!download.isInstalled()) continue;
            Path path = download.path.getParent();
            String name = download.path.getName();
            try {
                this.delete(path.resolve(name));
                this.delete(path.resolve(name + ".delete"));
            }
            catch (Exception ex) {
                this.logger.error("Unable to delete file(s)", ex);
            }
        }
        Marketplace.INSTANCE.getModules().remove(this.id);
    }

    public boolean isInstalled() {
        return this.compatibleDownloads.stream().anyMatch(Download::isInstalled);
    }

    public boolean isMarkedUninstall() {
        return this.compatibleDownloads.stream().anyMatch(download -> {
            Path path = download.path.getParent();
            String name = download.path.getName();
            Path uninstallFile = path.resolve(name + ".delete");
            return Files.exists(uninstallFile, new LinkOption[0]);
        });
    }

    public boolean isCompatible() {
        return !this.compatibleDownloads.isEmpty();
    }

    public List<Download> getCompatibleDownloads() {
        return this.compatibleDownloads;
    }
}

