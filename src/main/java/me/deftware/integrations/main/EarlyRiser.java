/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 *  net.fabricmc.loader.api.ModContainer
 *  org.spongepowered.asm.mixin.Mixins
 */
package me.deftware.integrations.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.spongepowered.asm.mixin.Mixins;

public class EarlyRiser
implements Runnable {
    public static final Map<String, String> MIXIN_CONFIGS = new HashMap<String, String>();
    public static final List<String> APPLIED_PATCHES = new ArrayList<String>();

    @Override
    public void run() {
        for (ModContainer modContainer : FabricLoader.getInstance().getAllMods()) {
            String id = modContainer.getMetadata().getId();
            if (!MIXIN_CONFIGS.containsKey(id)) continue;
            Mixins.addConfiguration((String)MIXIN_CONFIGS.get(id));
            APPLIED_PATCHES.add(id);
        }
    }

    static {
        MIXIN_CONFIGS.put("fabric-renderer-indigo", "mixins.fapi.json");
        MIXIN_CONFIGS.put("optifabric", "mixins.optifine.json");
        MIXIN_CONFIGS.put("optifine", "mixins.optifine.json");
        MIXIN_CONFIGS.put("sodium", "mixins.sodium.json");
        MIXIN_CONFIGS.put("rubidium", "mixins.sodium.json");
    }
}

