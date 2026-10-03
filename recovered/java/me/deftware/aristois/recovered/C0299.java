package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.types.BowItem;
import me.deftware.client.framework.item.types.CrossbowItem;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0299 extends C0300 {
   public C0299() {
      super(C0263.m_e8fd0250(), C0290.f_4b7b2d37, C0263.m_d0da63e8(), C0263.m_0425f2ec());
      this.f_5e0bc193 = 7.0;
      this.f_389c95dc = 50.0;
   }

   @Override
   protected void m_61059d72(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      boolean var3 = m_0d32d890(var2);
      if (this.m_275ab222() && var3) {
         if (this.f_2f814197 == null) {
            Vector3d var4 = var2.getRotationVector();
            Vector3d var5 = Minecraft.getMinecraftGame().getCamera().getCameraPosition();
            Vector3d var6 = C0423.m_710c5c50(var5, var4, this.f_389c95dc);
            Entity var7 = C0212.m_a89ff977(var5, var6, var4, var2, (float)this.f_389c95dc);
            if (var7 instanceof LivingEntity && !var7.isSelf()) {
               this.f_2f814197 = new C0299.anonymousabstract(this.f_2fc6cb2d, this.f_5e0bc193, this.f_f04b882b, this.f_389c95dc, this.f_556833a6);
               this.f_2f814197.m_76e16abf((LivingEntity)var7);
            }
         }
      } else if (!Keyboard.isCtrlPressed()) {
         this.f_2f814197 = null;
      }
   }

   public static boolean m_0d32d890(MainEntityPlayer var0) {
      ItemStack var1 = var0.getInventory().getHeldItem(EntityHand.MainHand);
      Item var2 = var1.getItem();
      int var3 = var0.getItemInUseMaxCount();
      if (var2 instanceof CrossbowItem) {
         return CrossbowItem.isCharged(var1);
      } else {
         return var2 instanceof BowItem ? var3 > 1 : false;
      }
   }

   private static class anonymousabstract extends C0301 {
      private static final double f_d6401923 = 0.006;

      public anonymousabstract(double var1, double var3, double var5, double var7, boolean var9) {
         super(var1, var3, var5, var7, var9);
      }

      @Override
      public void m_1058ed9a() {
         double var1 = this.m_d3f59540(this.f_650d53f0);
         double var3 = this.f_7b179fc1.getPosX() - this.f_650d53f0.getPosX();
         double var5 = this.f_7b179fc1.getPosY() + (double)this.f_7b179fc1.getHeight() / 2.0 - (this.f_650d53f0.getPosY() + this.f_650d53f0.getEyeHeight());
         double var7 = this.f_7b179fc1.getPosZ() - this.f_650d53f0.getPosZ();
         double var9 = Math.toDegrees(Math.atan2(var7, var3)) - 90.0;
         this.f_df0ee8a3 = this.m_d945de47(var9 - (double)this.f_650d53f0.getRotationYaw());
         double var11 = Math.sqrt(var3 * var3 + var7 * var7);
         double var13 = var1 * var1 * var1 * var1 - 0.006 * (0.006 * var11 * var11 + 2.0 * var5 * var1 * var1);
         double var15 = -Math.toDegrees(Math.atan((var1 * var1 - Math.sqrt(var13)) / (0.006 * var11)));
         this.f_12278995 = this.m_d945de47(var15 - (double)this.f_650d53f0.getRotationPitch());
         this.f_b5304270 = (double)this.f_650d53f0.distanceToEntity(this.f_7b179fc1);
         this.f_aa18c6ab = Math.sqrt(this.f_df0ee8a3 * this.f_df0ee8a3 + this.f_12278995 * this.f_12278995);
      }

      private double m_d3f59540(MainEntityPlayer var1) {
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
