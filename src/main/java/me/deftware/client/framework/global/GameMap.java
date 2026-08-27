/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.global;

import java.util.concurrent.ConcurrentHashMap;
import me.deftware.client.framework.global.GameCategory;
import me.deftware.client.framework.global.IGameKey;

public class GameMap {
    public static final GameMap INSTANCE = new GameMap();
    private final ConcurrentHashMap<GameCategory, ConcurrentHashMap<String, Object>> keys = new ConcurrentHashMap();

    private GameMap() {
        this.reset();
    }

    public int size() {
        return this.keys.values().stream().mapToInt(ConcurrentHashMap::size).sum();
    }

    public void reset() {
        this.keys.clear();
        for (GameCategory category : GameCategory.values()) {
            this.keys.put(category, new ConcurrentHashMap());
        }
    }

    public boolean contains(IGameKey key) {
        return this.contains(key.getCategory(), key.getKey());
    }

    public boolean contains(GameCategory category, String key) {
        return this.keys.get((Object)category).containsKey(key);
    }

    public <T> T put(IGameKey key, T value) {
        return this.put(key.getCategory(), key.getKey(), value);
    }

    public <T> T put(GameCategory category, String key, T value) {
        return (T)this.keys.get((Object)category).put(key, value);
    }

    public <T> T get(IGameKey key, T value) {
        return this.get(key.getCategory(), key.getKey(), value);
    }

    public <T> T get(GameCategory category, String key, T value) {
        return (T)this.keys.get((Object)category).getOrDefault(key, value);
    }

    public <T> T remove(IGameKey key) {
        return this.remove(key.getCategory(), key.getKey());
    }

    public <T> T remove(GameCategory category, String key) {
        return (T)this.keys.get((Object)category).remove(key);
    }
}

