/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.client.main.Main
 */
package me.deftware.client.framework.main.bootstrap.discovery;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.main.bootstrap.discovery.AbstractModDiscovery;
import me.deftware.client.framework.minecraft.Minecraft;
import net.minecraft.client.main.Main;

public class ClasspathModDiscovery
extends AbstractModDiscovery {
    @Override
    public void discover() {
        try {
            int start = 25;
            List<JsonObject> classpathMods = this.getClasspathMods();
            for (JsonObject data : classpathMods) {
                System.setProperty("emcMod" + start, data.get("id").getAsString() + "," + data.get("name").getAsString().replace("%mc%", Minecraft.getMinecraftVersion()) + "," + data.get("maven").getAsString());
                ++start;
            }
            Bootstrap.logger.info("ClasspathModDiscovery found {} entries", (Object)classpathMods.size());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<JsonObject> getClasspathMods() {
        ArrayList<JsonObject> entries = new ArrayList<JsonObject>();
        try {
            for (URL url : Collections.list(Main.class.getClassLoader().getResources("emc-mod-data.json"))) {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
                JsonArray json = (JsonArray)new Gson().fromJson(buffer.lines().collect(Collectors.joining("\n")), JsonArray.class);
                for (JsonElement element : json) {
                    entries.add(element.getAsJsonObject());
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return entries;
    }
}

