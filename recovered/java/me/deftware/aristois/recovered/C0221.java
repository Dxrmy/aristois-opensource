package me.deftware.aristois.recovered;

import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0221 extends GlTexture {
   private final MinecraftIdentifier f_0186e283;

   public GlTexture bind() {
      bindTexture(this.f_0186e283);
      return this;
   }

   public boolean isReady() {
      return true;
   }

   public C0221(MinecraftIdentifier var1) {
      this.f_0186e283 = var1;
   }
}
