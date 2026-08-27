/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonObject
 */
package me.deftware.client.framework.main.bootstrap.discovery;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import me.deftware.client.framework.main.EMCMod;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.main.bootstrap.discovery.AbstractModDiscovery;

public class DirectoryModDiscovery
extends AbstractModDiscovery {
    @Override
    public void discover() {
        Arrays.stream(Objects.requireNonNull(Bootstrap.EMC_ROOT.listFiles())).forEach(file -> {
            File deleteFile = new File(file.getAbsolutePath() + ".delete");
            File updateFile = new File(file.getAbsolutePath() + ".update");
            if (!file.isDirectory() && file.getName().endsWith(".jar")) {
                if (deleteFile.exists()) {
                    Bootstrap.logger.info("Deleting {}", (Object)file.getName());
                    if (!deleteFile.delete() || !file.delete()) {
                        Bootstrap.logger.error("Failed to delete {}", (Object)file.getName());
                    }
                } else {
                    if (updateFile.exists()) {
                        if (!file.delete() || !updateFile.renameTo((File)file)) {
                            Bootstrap.logger.error("Failed to update {}", (Object)file.getName());
                        } else {
                            Bootstrap.logger.info("Updated {}", (Object)file.getName());
                        }
                    }
                    Bootstrap.logger.debug("Discovered {} with DirectoryModDiscovery", (Object)file.getName());
                    try {
                        DirectoryModEntry modEntry = new DirectoryModEntry((File)file);
                        this.entries.add(modEntry);
                    }
                    catch (Exception ex) {
                        Bootstrap.logger.warn("Failed to load mod {}, is it an EMC mod?", (Object)file.getName());
                    }
                }
            }
        });
    }

    public static class DirectoryModEntry
    extends AbstractModDiscovery.AbstractModEntry {
        private final URLClassLoader classLoader;

        DirectoryModEntry(File file) throws Exception {
            super(file, null);
            String path = this.getFile().toURI().toURL().getFile();
            JarURLConnection connection = (JarURLConnection)new URL("jar", "", "file:" + path + "!/client.json").openConnection();
            this.classLoader = URLClassLoader.newInstance(new URL[]{new URL("jar", "", "file:" + path + "!/")}, Bootstrap.class.getClassLoader());
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            this.json = (JsonObject)new Gson().fromJson(buffer.lines().collect(Collectors.joining("\n")), JsonObject.class);
            buffer.close();
        }

        @Override
        public void init() {
        }

        @Override
        public EMCMod toInstance() throws Exception {
            EMCMod instance = (EMCMod)this.classLoader.loadClass(this.getJson().get("main").getAsString()).newInstance();
            instance.classLoader = this.classLoader;
            return instance;
        }
    }
}

