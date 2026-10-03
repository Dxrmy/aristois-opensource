package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockUpdate;
import me.deftware.client.framework.event.events.EventItemUse;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.event.events.EventBlockUpdate.State;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.inventory.EntityInventory;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.world.block.Block;

public class C0416 extends AbstractMod {
   @C0098(
      value = "Threshold",
      description = {"At which item durability percentage it should", "be swapped out for a better item"},
      number = @C0096(
         min = 0.01,
         max = 0.9,
         percentage = true
      )
   )
   private float f_adba8e68 = 0.15F;
   @C0098(
      value = "Hotbar",
      description = {"Consider items in the hotbar, not just in the inventory"}
   )
   private boolean f_63080da0 = false;
   @C0098(
      value = "Durability",
      description = {"Replace low durability", "items with better ones", "from your inventory"}
   )
   private boolean f_6b111372 = true;
   @C0098(
      value = "Swap empty",
      description = {"Replace items that run out of", "with new ones from your", "inventory"}
   )
   private boolean f_e19ce61a = true;

   public C0416() {
      super(C0252.bootstrap<"get",38654705724>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705725>(), C0252.bootstrap<"get",38654705726>());
   }

   public static float m_b5646b7c(ItemStack var0) {
      if (!var0.isDamageable()) {
         return 1.0F;
      } else {
         float var1 = (float)(var0.getMaxDamage() - var0.getDamage());
         return var1 / (float)var0.getMaxDamage();
      }
   }

   @EventHandler
   private void m_d15eb604(EventItemUse var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (this.f_e19ce61a) {
         this.m_392c00d8(var2.getInventory(), var1.getItem(), var1.getHand(), true);
      }
   }

   @EventHandler
   private void m_af813639(EventBlockUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (this.f_e19ce61a && var1.getState() == State.Place) {
         Block var3 = var1.getBlock();
         ItemStack var4 = new ItemStack(var3, 1);
         this.m_392c00d8(var2.getInventory(), var4.getItem(), var1.getHand(), false);
      }
   }

   private void m_392c00d8(EntityInventory var1, Item var2, EntityHand var3, boolean var4) {
      ItemStack var5 = var1.getHeldItem(var3);
      int var6 = var5.getCount();
      if (var4) {
         var6--;
      }

      if (var6 <= 0) {
         int var7 = C0114.bootstrap<"call",2,1>(var2).m_a0aa8556();
         if (var7 != -1) {
            int var8 = var1.getCurrentItem();
            if (var3 == EntityHand.OffHand) {
               var8 = 45;
            }

            ((C0073.anonymousdefault)((C0073.anonymousdefault)C0114.bootstrap<"call",3,1>().m_44d897bb(var7)).m_7dabe54f(C0114.bootstrap<"call",4,1>(var8)))
               .m_08fa2bad();
         }
      }
   }

   @EventHandler
   private void m_7a4399ac(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      EntityInventory var3 = var2.getInventory();
      ItemStack var4 = var3.getStackInSlot(var3.getCurrentItem());
      if (this.f_6b111372 && !var4.isEmpty() && !(C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen)) {
         float var5 = C0114.bootstrap<"call",5,1>(var4);
         if (var5 <= this.f_adba8e68) {
            int var6 = C0114.bootstrap<"call",6,1>(var4.getItem())
               .m_c809d082()
               .m_b359a24a(this.f_63080da0 ? 0 : 9, var2.getInventory().getSize(), -1, (float)var4.getDamage());
            if (var6 != -1) {
               if (C0114.bootstrap<"call",7,1>(var6)) {
                  ((C0073.anonymousboolean)C0114.bootstrap<"call",8,1>().m_b5be4463(var6)).m_eebb0db7();
               } else {
                  ((C0073.anonymousdefault)((C0073.anonymousdefault)C0114.bootstrap<"call",3,1>().m_44d897bb(var6))
                        .m_7dabe54f(C0114.bootstrap<"call",4,1>(var2.getInventory().getCurrentItem())))
                     .m_08fa2bad();
               }

               C0114.bootstrap<"call",9,1>()
                  .m_6b4e8235(C0252.bootstrap<"get",38654705727>())
                  .m_77a7bc18(C0252.bootstrap<"get",38654705728>(), C0252.bootstrap<"get",38654705729>())
                  .m_66e721c0();
            }
         }
      }
   }
}
