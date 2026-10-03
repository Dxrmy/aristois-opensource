package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.EntityPlayer;

public enum C0215 {
   f_0e18c9b2(C0252.bootstrap<"get",55834574959>(), 247.5F, 292.5F),
   f_f26fb985(C0252.bootstrap<"get",55834574961>(), 292.5F, 337.5F),
   f_a3529769(C0252.bootstrap<"get",55834574963>(), 202.5F, 247.5F),
   f_c4e10650(C0252.bootstrap<"get",55834574965>(), 337.5F, 360.0F, 0.0F, 22.5F),
   f_7ed71fd2(C0252.bootstrap<"get",55834574967>(), 22.5F, 67.5F),
   f_664159a0(C0252.bootstrap<"get",55834574969>(), 67.5F, 112.5F),
   f_2b6ebab8(C0252.bootstrap<"get",55834574971>(), 112.5F, 157.5F),
   f_1538e231(C0252.bootstrap<"get",55834574973>(), 157.5F, 202.5F);

   private final float f_46d7f312;
   private final float f_e37403d9;
   private final float f_87c873aa;
   private final float f_6fc77080;
   private final String f_90ff487c;
   private static final C0215[] f_46851acd = C0114.bootstrap<"call",0,1>();

   private C0215(String var3, float var4, float var5) {
      this.f_46d7f312 = var4;
      this.f_e37403d9 = var5;
      this.f_87c873aa = var4;
      this.f_6fc77080 = var5;
      this.f_90ff487c = var3;
   }

   private C0215(String var3, float var4, float var5, float var6, float var7) {
      this.f_46d7f312 = var4;
      this.f_e37403d9 = var5;
      this.f_87c873aa = var6;
      this.f_6fc77080 = var7;
      this.f_90ff487c = var3;
   }

   public float m_f0708555() {
      return (this.f_46d7f312 + this.f_e37403d9) / 2.0F;
   }

   public float m_10c31318() {
      return this.f_46d7f312;
   }

   public float m_e3823b3e() {
      return this.f_e37403d9;
   }

   public float m_26f47f89() {
      return this.f_87c873aa;
   }

   public float m_35743847() {
      return this.f_6fc77080;
   }

   public String m_b1cbbc00() {
      return this.f_90ff487c;
   }

   public static C0215 m_43598fa6(float var0) {
      for (C0215 var4 : f_46851acd) {
         if (var0 > var4.f_46d7f312 && var0 < var4.f_e37403d9 || var0 > var4.f_87c873aa && var0 < var4.f_6fc77080) {
            return var4;
         }
      }

      return f_0e18c9b2;
   }

   public static C0215 m_e95d1fa5(EntityPlayer var0) {
      float var1 = (var0.getRotationYaw() + 90.0F) % 360.0F;
      if (var1 < 0.0F) {
         var1 += 360.0F;
      }

      return C0114.bootstrap<"call",0,1>(var1);
   }
}
