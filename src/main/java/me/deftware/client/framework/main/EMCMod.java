/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  lombok.Generated
 */
package me.deftware.client.framework.main;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.net.URLClassLoader;
import lombok.Generated;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.main.ModMeta;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.resource.ModResourceManager;
import me.deftware.client.framework.util.path.LocationUtil;

public abstract class EMCMod {
    protected ModResourceManager resourceManager;
    protected ModMeta meta;
    public URLClassLoader classLoader;
    private Settings settings;
    public File physicalFile;

    public void init(JsonObject json) {
        this.meta = (ModMeta)new Gson().fromJson((JsonElement)json, ModMeta.class);
        this.settings = new Settings(this.meta.getName());
        this.settings.setupShutdownHook();
        this.physicalFile = LocationUtil.getClassPhysicalLocation(this.getClass()).toFile();
        try {
            this.resourceManager = new ModResourceManager(this, "assets");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        Bootstrap.logger.debug("Physical jar of {} is {}", (Object)this.meta.getName(), (Object)this.physicalFile.getAbsolutePath());
        this.initialize();
    }

    public abstract void initialize();

    public void disable() {
        Bootstrap.getMods().remove(this.meta.getName());
    }

    public Settings getSettings() {
        return this.settings;
    }

    public void onUnload() {
    }

    public void callMethod(String method, String caller, Object object) {
    }

    public void postInit() {
    }

    @Generated
    public ModResourceManager getResourceManager() {
        return this.resourceManager;
    }

    @Generated
    public ModMeta getMeta() {
        return this.meta;
    }
}

