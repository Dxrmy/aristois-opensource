package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0225 {
   @SerializedName("texture")
   protected String f_6009a9f7;
   @SerializedName("entityId")
   protected String f_cd1bb51e;
   @SerializedName("textureWidth")
   protected int f_44ac9805 = 64;
   @SerializedName("textureHeight")
   protected int f_81984b25 = 32;
   @SerializedName("width")
   protected int f_d6891a93 = 8;
   @SerializedName("height")
   protected int f_2747e19d = 8;
   @SerializedName("u")
   protected int f_32b80dcf;
   @SerializedName("v")
   protected int f_f61ff1b1;
   private MinecraftIdentifier f_e0c7dfcf;

   public C0225() {
   }

   public void m_c6b9da21(int var1, int var2, float var3) {
      if (this.f_e0c7dfcf == null) {
         this.f_e0c7dfcf = new MinecraftIdentifier(this.f_6009a9f7);
      }

      GLX.INSTANCE.push();
      GLX.INSTANCE.translate((float)var1, (float)var2, 1.0F);
      GLX.INSTANCE.scale(var3, var3, 1.0F);
      C0114.bootstrap<"call",0,1>(this.f_e0c7dfcf);
      C0114.bootstrap<"call",1,1>(
         -(this.m_fb47ead9() / 2),
         -(this.m_6220e5e2() / 2),
         this.f_d6891a93,
         this.f_2747e19d,
         this.f_32b80dcf,
         this.f_f61ff1b1,
         this.f_44ac9805,
         this.f_81984b25
      );
      GLX.INSTANCE.pop();
   }

   public static void m_16749781(UUID var0, int var1, int var2, int var3, int var4) {
      C0224 var5 = C0114.bootstrap<"call",2,1>(var0);
      if (var5.m_d737e9da(C0230.anonymouscatch.f_b4b41867)) {
         C0114.bootstrap<"call",3,1>();
         var5.m_f3bb274c(var1, var2, var3, var4, C0230.anonymouscatch.f_b4b41867);
         C0114.bootstrap<"call",4,1>();
      }
   }

   public String m_4a017052() {
      return this.f_6009a9f7;
   }

   public String m_9b1475ad() {
      return this.f_cd1bb51e;
   }

   public int m_bf9f869a() {
      return this.f_44ac9805;
   }

   public int m_36203955() {
      return this.f_81984b25;
   }

   public int m_fb47ead9() {
      return this.f_d6891a93;
   }

   public int m_6220e5e2() {
      return this.f_2747e19d;
   }

   public int m_9c87463e() {
      return this.f_32b80dcf;
   }

   public int m_e7f015ba() {
      return this.f_f61ff1b1;
   }

   public MinecraftIdentifier m_55ccaedc() {
      return this.f_e0c7dfcf;
   }
}
