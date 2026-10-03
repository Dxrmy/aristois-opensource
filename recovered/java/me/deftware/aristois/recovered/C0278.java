package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.EntityPlayer;

public class C0278 extends C0277 {
   private final float f_123f8d48;
   private final float f_413ccf1e;

   public C0278(int var1, EntityPlayer var2, float var3) {
      super(var1, var2);
      this.f_123f8d48 = var3;
      this.f_413ccf1e = var2.getRotationPitch();
      this.f_80112c51.add(var2x -> var2.setRotationPitch(this.f_413ccf1e));
   }

   public C0279 m_3309d605() {
      this.f_826194c7.setRotationPitch(this.f_123f8d48);
      return super.m_3a250deb();
   }
}
