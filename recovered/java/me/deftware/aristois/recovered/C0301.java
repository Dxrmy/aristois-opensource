package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0301 {
   protected double f_aa18c6ab;
   protected double f_12278995;
   protected double f_df0ee8a3;
   protected double f_b5304270;
   protected LivingEntity f_7b179fc1;
   protected final MainEntityPlayer f_650d53f0 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
   protected final double f_e8aa784d;
   protected final double f_0a1b3fed;
   protected final double f_620935d2;
   protected final double f_4470427e;
   protected final boolean f_ab13a75e;

   public C0301(double var1, double var3, double var5, double var7, boolean var9) {
      this.f_e8aa784d = var1;
      this.f_0a1b3fed = var3;
      this.f_620935d2 = var5;
      this.f_4470427e = var7;
      this.f_ab13a75e = var9;
   }

   public void m_76e16abf(LivingEntity var1) {
      this.f_7b179fc1 = var1;
      if (var1 != null) {
         this.m_1058ed9a();
      }
   }

   public void m_1058ed9a() {
      double var1 = this.f_7b179fc1.getPosX() - this.f_650d53f0.getPosX();
      double var3 = this.f_7b179fc1.getPosY() + (double)this.f_7b179fc1.getHeight() / 2.0 - (this.f_650d53f0.getPosY() + this.f_650d53f0.getEyeHeight());
      double var5 = this.f_7b179fc1.getPosZ() - this.f_650d53f0.getPosZ();
      double var7 = Math.toDegrees(Math.atan2(var5, var1)) - 90.0;
      this.f_df0ee8a3 = this.m_d945de47(var7 - (double)this.f_650d53f0.getRotationYaw());
      double var9 = Math.sqrt(var1 * var1 + var5 * var5);
      double var11 = -Math.toDegrees(Math.atan2(var3, var9));
      this.f_12278995 = this.m_d945de47(var11 - (double)this.f_650d53f0.getRotationPitch());
      this.f_b5304270 = (double)this.f_650d53f0.distanceToEntity(this.f_7b179fc1);
      this.f_aa18c6ab = Math.sqrt(this.f_df0ee8a3 * this.f_df0ee8a3 + this.f_12278995 * this.f_12278995);
   }

   public void m_b728afce() {
      if (this.f_aa18c6ab > this.f_e8aa784d) {
         double var1 = 18.0 - this.f_0a1b3fed;
         double var3 = Math.abs(this.f_df0ee8a3 / var1);
         double var5 = var3 * (double)(this.f_df0ee8a3 >= 0.0 ? 1 : -1);
         double var7 = Math.abs(this.f_12278995 / var1);
         double var9 = var7 * (double)(this.f_12278995 >= 0.0 ? 1 : -1);
         if (this.f_ab13a75e) {
            this.f_650d53f0.setRotationYaw(this.f_650d53f0.getRotationYaw() + (float)var5);
            this.f_650d53f0.setRotationPitch(this.f_650d53f0.getRotationPitch() + (float)var9);
         } else {
            this.f_650d53f0.setRotationYaw(this.f_650d53f0.getRotationYaw() + (float)this.f_df0ee8a3);
            this.f_650d53f0.setRotationPitch(this.f_650d53f0.getRotationPitch() + (float)this.f_12278995);
         }
      }
   }

   public boolean m_89e0519f() {
      return this.f_aa18c6ab < this.f_620935d2 && this.f_b5304270 <= this.f_4470427e && this.f_7b179fc1.isAlive();
   }

   protected double m_d945de47(double var1) {
      double var3 = var1 % 360.0;
      if (var3 >= 180.0) {
         var3 -= 360.0;
      }

      if (var3 < -180.0) {
         var3 += 360.0;
      }

      return var3;
   }

   public double m_d42f3372() {
      return this.f_aa18c6ab;
   }

   public double m_b94b5d9f() {
      return this.f_12278995;
   }

   public double m_0b5864b1() {
      return this.f_df0ee8a3;
   }

   public double m_0b83410d() {
      return this.f_b5304270;
   }

   public LivingEntity m_aa8edb9c() {
      return this.f_7b179fc1;
   }
}
