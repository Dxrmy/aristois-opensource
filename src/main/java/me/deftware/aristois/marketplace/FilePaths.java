/*
 * Decompiled with CFR 0.152.
 */
package me.deftware.aristois.marketplace;

import java.io.File;
import java.nio.file.Path;
import me.deftware.aristois.marketplace.MarketplaceMod;

public enum FilePaths {
    fabric(MarketplaceMod.fabricModPath),
    mods(MarketplaceMod.modPath),
    emc(MarketplaceMod.emcModPath),
    libraries(MarketplaceMod.libraries);

    final private Path path;

    public File resolve(String name) {
        return this.path.resolve(name).toFile();
    }

    private FilePaths(Path path) {
        this.path = path;
    }
}

