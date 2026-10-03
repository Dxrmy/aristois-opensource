package me.deftware.aristois.marketplace;

import java.io.File;
import java.nio.file.Path;

public enum FilePaths {
   fabric(MarketplaceMod.fabricModPath),
   mods(MarketplaceMod.modPath),
   emc(MarketplaceMod.emcModPath),
   libraries(MarketplaceMod.libraries);

   private final Path path;

   public File resolve(String name) {
      return this.path.resolve(name).toFile();
   }

   private FilePaths(Path path) {
      this.path = path;
   }
}
