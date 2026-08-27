/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 */
package me.deftware.client.framework.main.preprocessor;

import com.google.gson.JsonObject;
import java.io.File;
import java.util.HashMap;
import me.deftware.client.framework.main.bootstrap.discovery.ClasspathModDiscovery;
import me.deftware.client.framework.main.preprocessor.ModPreProcessor;

public class PreProcessorMan
implements Runnable {
    private final File runDir;
    private final File emcJar;
    private final ClasspathModDiscovery classpathModDiscovery;
    private final HashMap<String, ModPreProcessor> preProcessorHashMap = new HashMap();

    public PreProcessorMan(File runDir, File emcJar) {
        this.runDir = runDir;
        this.emcJar = emcJar;
        this.classpathModDiscovery = new ClasspathModDiscovery();
        for (JsonObject entry : this.classpathModDiscovery.getClasspathMods()) {
            if (!entry.has("preprocessor")) continue;
            try {
                ModPreProcessor instance = (ModPreProcessor)PreProcessorMan.class.getClassLoader().loadClass(entry.get("preprocessor").getAsString()).newInstance();
                instance.preProcessor = this;
                this.preProcessorHashMap.put(entry.get("id").getAsString(), instance);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        for (ModPreProcessor preProcessor : this.preProcessorHashMap.values()) {
            preProcessor.run();
        }
    }

    public File getEmcJar() {
        return this.emcJar;
    }

    public File getRunDir() {
        return this.runDir;
    }

    public File getEMCModsDir() {
        return new File(this.runDir, "libraries" + File.separator + "EMC" + File.separator + this.getMinecraftVersion() + File.separator);
    }

    public String getMinecraftVersion() {
        return this.emcJar.getName().split("-")[this.emcJar.getName().split("-").length - 1].replace(".jar", "");
    }
}

