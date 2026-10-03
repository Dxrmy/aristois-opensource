package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.EntityPlayer;

public class C0278 extends C0277 {
   private final float f_b48c3aea;
   private final float f_77718cfb;

   public C0278(int var1, EntityPlayer var2, float var3) {
      super(var1, var2);
      this.f_b48c3aea = var3;
      this.f_77718cfb = var2.getRotationPitch();
      this.f_45f14763.add(var2x -> var2.setRotationPitch(this.f_77718cfb));
   }

   @Override
   public C0279 m_e3ec0ce5() {
      this.f_35114e14.setRotationPitch(this.f_b48c3aea);
      return super.m_e3ec0ce5();
   }
}
