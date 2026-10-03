package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;

public class C0301 {
   protected double f_daf27fbf;
   protected double f_1b637644;
   protected double f_7c2238d8;
   protected double f_dacae237;
   protected LivingEntity f_3d68e2d2;
   protected final MainEntityPlayer f_1c46fe08 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
   protected final double f_7b9eb80f;
   protected final double f_24338b58;
   protected final double f_0c211dbb;
   protected final double f_96c92fec;
   protected final boolean f_5fae4de6;

   public C0301(double var1, double var3, double var5, double var7, boolean var9) {
      this.f_7b9eb80f = var1;
      this.f_24338b58 = var3;
      this.f_0c211dbb = var5;
      this.f_96c92fec = var7;
      this.f_5fae4de6 = var9;
   }

   public void m_cdb42d6f(LivingEntity var1) {
      this.f_3d68e2d2 = var1;
      if (var1 != null) {
         this.m_5169054f();
      }
   }

   public void m_5169054f() {
      double var1 = this.f_3d68e2d2.getPosX() - this.f_1c46fe08.getPosX();
      double var3 = this.f_3d68e2d2.getPosY() + (double)this.f_3d68e2d2.getHeight() / 2.0 - (this.f_1c46fe08.getPosY() + this.f_1c46fe08.getEyeHeight());
      double var5 = this.f_3d68e2d2.getPosZ() - this.f_1c46fe08.getPosZ();
      double var7 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var5, var1)) - 90.0;
      this.f_7c2238d8 = this.m_e5b36f9d(var7 - (double)this.f_1c46fe08.getRotationYaw());
      double var9 = C0114.bootstrap<"call",2,1>(var1 * var1 + var5 * var5);
      double var11 = -C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var3, var9));
      this.f_1b637644 = this.m_e5b36f9d(var11 - (double)this.f_1c46fe08.getRotationPitch());
      this.f_dacae237 = (double)this.f_1c46fe08.distanceToEntity(this.f_3d68e2d2);
      this.f_daf27fbf = C0114.bootstrap<"call",2,1>(this.f_7c2238d8 * this.f_7c2238d8 + this.f_1b637644 * this.f_1b637644);
   }

   public void m_0e2773ce() {
      if (this.f_daf27fbf > this.f_7b9eb80f) {
         double var1 = 18.0 - this.f_24338b58;
         double var3 = C0114.bootstrap<"call",0,1>(this.f_7c2238d8 / var1);
         double var5 = var3 * (double)(this.f_7c2238d8 >= 0.0 ? 1 : -1);
         double var7 = C0114.bootstrap<"call",0,1>(this.f_1b637644 / var1);
         double var9 = var7 * (double)(this.f_1b637644 >= 0.0 ? 1 : -1);
         if (this.f_5fae4de6) {
            this.f_1c46fe08.setRotationYaw(this.f_1c46fe08.getRotationYaw() + (float)var5);
            this.f_1c46fe08.setRotationPitch(this.f_1c46fe08.getRotationPitch() + (float)var9);
         } else {
            this.f_1c46fe08.setRotationYaw(this.f_1c46fe08.getRotationYaw() + (float)this.f_7c2238d8);
            this.f_1c46fe08.setRotationPitch(this.f_1c46fe08.getRotationPitch() + (float)this.f_1b637644);
         }
      }
   }

   public boolean m_abaf9b26() {
      return this.f_daf27fbf < this.f_0c211dbb && this.f_dacae237 <= this.f_96c92fec && this.f_3d68e2d2.isAlive();
   }

   protected double m_e5b36f9d(double var1) {
      double var3 = var1 % 360.0;
      if (var3 >= 180.0) {
         var3 -= 360.0;
      }

      if (var3 < -180.0) {
         var3 += 360.0;
      }

      return var3;
   }

   public double m_1dcda4b1() {
      return this.f_daf27fbf;
   }

   public double m_63900b29() {
      return this.f_1b637644;
   }

   public double m_fcc1c9b7() {
      return this.f_7c2238d8;
   }

   public double m_eb68d979() {
      return this.f_dacae237;
   }

   public LivingEntity m_cfbd0f4e() {
      return this.f_3d68e2d2;
   }
}
