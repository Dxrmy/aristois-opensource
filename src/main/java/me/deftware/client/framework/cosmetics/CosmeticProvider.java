/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.client.framework.cosmetics;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import me.deftware.client.framework.cosmetics.PlayerTexture;

public interface CosmeticProvider {
    public static final List<CosmeticProvider> PROVIDERS = new ArrayList<CosmeticProvider>();

    public void load(UUID var1, Runnable var2);

    public PlayerTexture getPlayerTexture(UUID var1);
}

