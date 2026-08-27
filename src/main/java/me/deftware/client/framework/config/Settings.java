/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.google.gson.JsonPrimitive
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package me.deftware.client.framework.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import me.deftware.client.framework.minecraft.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Settings {
    public static final Path configDir = Paths.get(Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath(), "libraries", "EMC", Minecraft.getMinecraftVersion(), "configs");
    public static final double revision = 4.0;
    private final Queue<Runnable> shutdownQueue = new ConcurrentLinkedQueue<Runnable>();
    private JsonObject config = this.empty();
    private final Logger logger;
    private final File configFile;

    public Settings(String name) {
        this(name, "_config");
    }

    public Settings(String name, String suffix) {
        this.logger = LoggerFactory.getLogger((String)(name + "/" + this.getClass().getSimpleName()));
        this.configFile = configDir.resolve(name + suffix + ".json").toFile();
        this.load();
        this.save();
    }

    private void load() {
        try {
            if (this.configFile.exists()) {
                this.logger.debug("Loading {}", (Object)this.configFile.getAbsolutePath());
                String contents = this.getConfigFileContents().trim();
                if (contents.isEmpty()) {
                    throw new Exception("Empty config file");
                }
                this.config = (JsonObject)new Gson().fromJson(contents, JsonObject.class);
            }
        }
        catch (Exception ex) {
            this.logger.error("Failed to read mod config, resetting...", (Throwable)ex);
            this.config = this.empty();
        }
    }

    private JsonObject empty() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("version", (Number)4.0);
        return jsonObject;
    }

    public JsonObject getConfig() {
        return this.config;
    }

    public void setupShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            this.logger.info("Saving {}", (Object)this.configFile.getName());
            for (Runnable consumer : this.shutdownQueue) {
                consumer.run();
            }
            this.save();
        }));
    }

    public File getConfigFile() {
        return this.configFile;
    }

    public synchronized void setConfig(JsonObject json) {
        this.config = json;
    }

    public Queue<Runnable> getShutdownQueue() {
        return this.shutdownQueue;
    }

    private synchronized String getConfigFileContents() throws IOException {
        return String.join((CharSequence)"\n", Files.readAllLines(Paths.get(this.configFile.getAbsolutePath(), new String[0]), StandardCharsets.UTF_8));
    }

    public synchronized void save() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(this.config.toString());
            String jsonContent = gson.toJson(je);
            PrintWriter writer = new PrintWriter(this.configFile.getAbsolutePath(), "UTF-8");
            writer.println(jsonContent);
            writer.close();
        }
        catch (Exception ex) {
            this.logger.error("Failed to save config", (Throwable)ex);
        }
    }

    public synchronized boolean hasKey(String key) {
        return this.config.has(key);
    }

    public synchronized int getPrimitive(String key, int defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsInt() : defaultValue;
    }

    public synchronized float getPrimitive(String key, float defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsFloat() : defaultValue;
    }

    public synchronized double getPrimitive(String key, double defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsDouble() : defaultValue;
    }

    public synchronized long getPrimitive(String key, long defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsLong() : defaultValue;
    }

    public synchronized short getPrimitive(String key, short defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsShort() : defaultValue;
    }

    public synchronized byte getPrimitive(String key, byte defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsByte() : defaultValue;
    }

    public synchronized boolean getPrimitive(String key, boolean defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsBoolean() : defaultValue;
    }

    public synchronized char getPrimitive(String key, char defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsCharacter() : defaultValue;
    }

    public synchronized String getPrimitive(String key, String defaultValue) {
        return this.config.has(key) ? this.config.getAsJsonPrimitive(key).getAsString() : defaultValue;
    }

    public synchronized Settings putPrimitive(String key, int value) {
        this.config.add(key, (JsonElement)new JsonPrimitive((Number)value));
        return this;
    }

    public synchronized Settings putPrimitive(String key, float value) {
        this.config.add(key, (JsonElement)new JsonPrimitive((Number)Float.valueOf(value)));
        return this;
    }

    public synchronized Settings putPrimitive(String key, double value) {
        this.config.add(key, (JsonElement)new JsonPrimitive((Number)value));
        return this;
    }

    public synchronized Settings putPrimitive(String key, long value) {
        this.config.add(key, (JsonElement)new JsonPrimitive((Number)value));
        return this;
    }

    public synchronized Settings putPrimitive(String key, short value) {
        this.config.add(key, (JsonElement)new JsonPrimitive((Number)value));
        return this;
    }

    public synchronized Settings putPrimitive(String key, byte value) {
        this.config.add(key, (JsonElement)new JsonPrimitive((Number)value));
        return this;
    }

    public synchronized Settings putPrimitive(String key, boolean value) {
        this.config.add(key, (JsonElement)new JsonPrimitive(Boolean.valueOf(value)));
        return this;
    }

    public synchronized Settings putPrimitive(String key, char value) {
        this.config.add(key, (JsonElement)new JsonPrimitive(Character.valueOf(value)));
        return this;
    }

    public synchronized Settings putPrimitive(String key, String value) {
        this.config.add(key, (JsonElement)new JsonPrimitive(value));
        return this;
    }

    public synchronized Settings remove(String key) {
        if (this.config.has(key)) {
            this.config.remove(key);
        }
        return this;
    }

    public static <T> T deepCopy(T object, Class<T> type) {
        try {
            Gson gson = new Gson();
            return (T)gson.fromJson(gson.toJson(object, type), type);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public synchronized JsonObject deepCopy() {
        return Settings.deepCopy(this.config, JsonObject.class);
    }

    public synchronized JsonObject getObject(String key) {
        return this.config.has(key) ? Settings.deepCopy(this.config.getAsJsonObject(key), JsonObject.class) : null;
    }

    public synchronized JsonArray getArray(String key) {
        return this.config.has(key) ? Settings.deepCopy(this.config.getAsJsonArray(key), JsonArray.class) : null;
    }

    public synchronized Settings putObject(String key, JsonObject object) {
        this.config.add(key, (JsonElement)Settings.deepCopy(object, JsonObject.class));
        return this;
    }

    public synchronized Settings putArray(String key, JsonArray object) {
        this.config.add(key, (JsonElement)Settings.deepCopy(object, JsonArray.class));
        return this;
    }
}

