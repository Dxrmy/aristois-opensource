package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0225 {
   @SerializedName("texture")
   protected String f_8eddeaa0;
   @SerializedName("entityId")
   protected String f_7cc0324f;
   @SerializedName("textureWidth")
   protected int f_3c4f079b = 64;
   @SerializedName("textureHeight")
   protected int f_b601b756 = 32;
   @SerializedName("width")
   protected int f_7664ed2a = 8;
   @SerializedName("height")
   protected int f_113336af = 8;
   @SerializedName("u")
   protected int f_0a5d9e45;
   @SerializedName("v")
   protected int f_41c98245;
   private MinecraftIdentifier f_fe1ba719;

   public C0225() {
   }

   public void m_4f0b4685(int var1, int var2, float var3) {
      if (this.f_fe1ba719 == null) {
         this.f_fe1ba719 = new MinecraftIdentifier(this.f_8eddeaa0);
      }

      GLX.INSTANCE.push();
      GLX.INSTANCE.translate((float)var1, (float)var2, 1.0F);
      GLX.INSTANCE.scale(var3, var3, 1.0F);
      GlTexture.bindTexture(this.f_fe1ba719);
      GlTexture.drawTexture(
         -(this.m_a135e825() / 2),
         -(this.m_f34ec3cf() / 2),
         this.f_7664ed2a,
         this.f_113336af,
         this.f_0a5d9e45,
         this.f_41c98245,
         this.f_3c4f079b,
         this.f_b601b756
      );
      GLX.INSTANCE.pop();
   }

   public static void m_6ea855ff(UUID var0, int var1, int var2, int var3, int var4) {
      C0224 var5 = C0224.m_3d9368ca(var0);
      if (var5.m_c0b2fa8c(C0230.anonymouscatch.f_bce9cc23)) {
         RenderStack.blend();
         var5.m_d4d15bd2(var1, var2, var3, var4, C0230.anonymouscatch.f_bce9cc23);
         RenderStack.noBlend();
      }
   }

   public String m_8d7dbe31() {
      return this.f_8eddeaa0;
   }

   public String m_3d3a8736() {
      return this.f_7cc0324f;
   }

   public int m_037208cc() {
      return this.f_3c4f079b;
   }

   public int m_36ffc578() {
      return this.f_b601b756;
   }

   public int m_a135e825() {
      return this.f_7664ed2a;
   }

   public int m_f34ec3cf() {
      return this.f_113336af;
   }

   public int m_8b15b5f4() {
      return this.f_0a5d9e45;
   }

   public int m_2ac34870() {
      return this.f_41c98245;
   }

   public MinecraftIdentifier m_59b03166() {
      return this.f_fe1ba719;
   }
}
