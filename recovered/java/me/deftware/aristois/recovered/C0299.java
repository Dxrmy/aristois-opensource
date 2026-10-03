package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.types.BowItem;
import me.deftware.client.framework.item.types.CrossbowItem;
import me.deftware.client.framework.math.vector.Vector3d;

public class C0299 extends C0300 {
   public C0299() {
      super(C0252.bootstrap<"get",38654705750>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705751>(), C0252.bootstrap<"get",38654705752>());
      this.f_d9a7a050 = 7.0;
      this.f_da646ff1 = 50.0;
   }

   protected void m_4bf4cc95(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      boolean var3 = C0114.bootstrap<"call",2,1>(var2);
      if (this.m_2c470c0a() && var3) {
         if (this.f_029f8d1f == null) {
            Vector3d var4 = var2.getRotationVector();
            Vector3d var5 = C0114.bootstrap<"call",0,1>().getCamera().getCameraPosition();
            Vector3d var6 = C0114.bootstrap<"call",3,1>(var5, var4, this.f_da646ff1);
            Entity var7 = C0114.bootstrap<"call",4,1>(var5, var6, var4, var2, (float)this.f_da646ff1);
            if (var7 instanceof LivingEntity && !var7.isSelf()) {
               this.f_029f8d1f = new C0299.anonymousabstract(this.f_12b3850d, this.f_d9a7a050, this.f_fe657b71, this.f_da646ff1, this.f_1943733f);
               this.f_029f8d1f.m_cdb42d6f((LivingEntity)var7);
            }
         }
      } else if (!C0114.bootstrap<"call",5,1>()) {
         this.f_029f8d1f = null;
      }
   }

   public static boolean m_2579020e(MainEntityPlayer var0) {
      ItemStack var1 = var0.getInventory().getHeldItem(EntityHand.MainHand);
      Item var2 = var1.getItem();
      int var3 = var0.getItemInUseMaxCount();
      if (var2 instanceof CrossbowItem) {
         return C0114.bootstrap<"call",0,1>(var1);
      } else {
         return var2 instanceof BowItem ? var3 > 1 : false;
      }
   }

   private static class anonymousabstract extends C0301 {
      private static final double f_2ee5c57e = 0.006;

      public anonymousabstract(double var1, double var3, double var5, double var7, boolean var9) {
         super(var1, var3, var5, var7, var9);
      }

      public void m_d154c581() {
         double var1 = this.m_0d992556(this.f_bfe4a86c);
         double var3 = this.f_de53b6e1.getPosX() - this.f_bfe4a86c.getPosX();
         double var5 = this.f_de53b6e1.getPosY() + (double)this.f_de53b6e1.getHeight() / 2.0 - (this.f_bfe4a86c.getPosY() + this.f_bfe4a86c.getEyeHeight());
         double var7 = this.f_de53b6e1.getPosZ() - this.f_bfe4a86c.getPosZ();
         double var9 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var7, var3)) - 90.0;
         this.f_7137f62b = this.m_e3502fe7(var9 - (double)this.f_bfe4a86c.getRotationYaw());
         double var11 = C0114.bootstrap<"call",2,1>(var3 * var3 + var7 * var7);
         double var13 = var1 * var1 * var1 * var1 - 0.006 * (0.006 * var11 * var11 + 2.0 * var5 * var1 * var1);
         double var15 = -C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",3,1>((var1 * var1 - C0114.bootstrap<"call",2,1>(var13)) / (0.006 * var11)));
         this.f_72904054 = this.m_e3502fe7(var15 - (double)this.f_bfe4a86c.getRotationPitch());
         this.f_7729034d = (double)this.f_bfe4a86c.distanceToEntity(this.f_de53b6e1);
         this.f_bb8a413d = C0114.bootstrap<"call",2,1>(this.f_7137f62b * this.f_7137f62b + this.f_72904054 * this.f_72904054);
      }

      private double m_0d992556(MainEntityPlayer var1) {
         int var2 = var1.getItemInUseMaxCount();
         double var3 = (double)var2 / 20.0;
         var3 = (var3 * var3 + var3 * 2.0) / 3.0;
         if (var3 < 0.1) {
            var3 = 1.0;
         } else if (var3 > 1.0) {
            var3 = 1.0;
         }

         return var3;
      }
   }
}
