package me.deftware.aristois.recovered;

import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0221 extends GlTexture {
   private final MinecraftIdentifier f_eff6f06c;

   public GlTexture bind() {
      C0114.bootstrap<"call",0,1>(this.f_eff6f06c);
      return this;
   }

   public boolean isReady() {
      return true;
   }

   public C0221(MinecraftIdentifier var1) {
      this.f_eff6f06c = var1;
   }
}
