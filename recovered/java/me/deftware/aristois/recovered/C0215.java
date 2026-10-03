package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.EntityPlayer;

public enum C0215 {
   f_6eb9252e(C0256.m_a5b24d28(), 247.5F, 292.5F),
   f_57482be4(C0256.m_09052c0b(), 292.5F, 337.5F),
   f_acfe15ce(C0256.m_733bff3d(), 202.5F, 247.5F),
   f_08ddf818(C0256.m_8870d2c1(), 337.5F, 360.0F, 0.0F, 22.5F),
   f_7a64b3de(C0256.m_3c19a819(), 22.5F, 67.5F),
   f_91e62fdd(C0256.m_5b2d5cb2(), 67.5F, 112.5F),
   f_3c4a1b12(C0256.m_62895921(), 112.5F, 157.5F),
   f_980a027c(C0256.m_83f6dd00(), 157.5F, 202.5F);

   private final float f_44aecd42;
   private final float f_f2a4b159;
   private final float f_ee95bde6;
   private final float f_5efe1b48;
   private final String f_748a38b5;
   private static final C0215[] f_4d41bd13 = values();

   private C0215(String var3, float var4, float var5) {
      this.f_44aecd42 = var4;
      this.f_f2a4b159 = var5;
      this.f_ee95bde6 = var4;
      this.f_5efe1b48 = var5;
      this.f_748a38b5 = var3;
   }

   private C0215(String var3, float var4, float var5, float var6, float var7) {
      this.f_44aecd42 = var4;
      this.f_f2a4b159 = var5;
      this.f_ee95bde6 = var6;
      this.f_5efe1b48 = var7;
      this.f_748a38b5 = var3;
   }

   public float m_796256b9() {
      return (this.f_44aecd42 + this.f_f2a4b159) / 2.0F;
   }

   public float m_b7fbb877() {
      return this.f_44aecd42;
   }

   public float m_f3107a2c() {
      return this.f_f2a4b159;
   }

   public float m_ec7fb983() {
      return this.f_ee95bde6;
   }

   public float m_4fa7ddfe() {
      return this.f_5efe1b48;
   }

   public String m_8ced16bd() {
      return this.f_748a38b5;
   }

   public static C0215 m_923238c5(float var0) {
      for (C0215 var4 : f_4d41bd13) {
         if (var0 > var4.f_44aecd42 && var0 < var4.f_f2a4b159 || var0 > var4.f_ee95bde6 && var0 < var4.f_5efe1b48) {
            return var4;
         }
      }

      return f_6eb9252e;
   }

   public static C0215 m_a3f5650c(EntityPlayer var0) {
      float var1 = (var0.getRotationYaw() + 90.0F) % 360.0F;
      if (var1 < 0.0F) {
         var1 += 360.0F;
      }

      return m_923238c5(var1);
   }
}
