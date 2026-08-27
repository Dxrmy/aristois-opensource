/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.global;

import me.deftware.client.framework.global.GameCategory;
import me.deftware.client.framework.global.IGameKey;

public enum GameKeys implements IGameKey
{
    WORLD_DEPTH,
    CROSSHAIR,
    EFFECT_OVERLAY,
    RAINBOW_ITEM_GLINT,
    NOCLIP,
    LEVITATION,
    JUMP_HEIGHT,
    EMC_MAIN_MENU_OVERLAY,
    FLIP_USERNAMES,
    DEADMAU_EARS,
    BYPASS_REACH_LIMIT,
    BLOCK_REACH_DISTANCE,
    EXTENDED_REACH,
    FULL_BERRY_VOXEL,
    FULL_CACTUS_VOXEL,
    IGNORE_WORLD_BORDER,
    FULL_BARRIER_TEXTURE,
    FULL_LIGHT_TEXTURE,
    RENDER_FLUIDS,
    MARKETPLACE_ESC_BUTTON(GameCategory.External);

    private final String key;
    private final GameCategory category;

    private GameKeys() {
        this(GameCategory.Default, null);
    }

    private GameKeys(GameCategory category) {
        this(category, null);
    }

    private GameKeys(GameCategory category, String key) {
        this.key = key == null ? this.name() : key;
        this.category = category;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public GameCategory getCategory() {
        return this.category;
    }
}

