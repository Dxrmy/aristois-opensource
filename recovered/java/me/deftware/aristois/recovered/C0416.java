package me.deftware.aristois.recovered;

import java.util.Objects;
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
import me.deftware.client.framework.minecraft.Minecraft;
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
   private float f_7c943105 = 0.15F;
   @C0098(
      value = "Hotbar",
      description = {"Consider items in the hotbar, not just in the inventory"}
   )
   private boolean f_1d0c8733 = false;
   @C0098(
      value = "Durability",
      description = {"Replace low durability", "items with better ones", "from your inventory"}
   )
   private boolean f_973ba876 = true;
   @C0098(
      value = "Swap empty",
      description = {"Replace items that run out of", "with new ones from your", "inventory"}
   )
   private boolean f_d7991bba = true;

   public C0416() {
      super(C0263.m_af41331f(), C0290.f_dbc16475, C0263.m_f257bcca(), C0263.m_d9b37a36());
   }

   public static float m_2f2b24b9(ItemStack var0) {
      if (!var0.isDamageable()) {
         return 1.0F;
      } else {
         float var1 = (float)(var0.getMaxDamage() - var0.getDamage());
         return var1 / (float)var0.getMaxDamage();
      }
   }

   @EventHandler
   private void m_6a43da6f(EventItemUse var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (this.f_d7991bba) {
         this.m_ecde085e(var2.getInventory(), var1.getItem(), var1.getHand(), true);
      }
   }

   @EventHandler
   private void m_243b8b08(EventBlockUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (this.f_d7991bba && var1.getState() == State.Place) {
         Block var3 = var1.getBlock();
         ItemStack var4 = new ItemStack(var3, 1);
         this.m_ecde085e(var2.getInventory(), var4.getItem(), var1.getHand(), false);
      }
   }

   private void m_ecde085e(EntityInventory var1, Item var2, EntityHand var3, boolean var4) {
      ItemStack var5 = var1.getHeldItem(var3);
      int var6 = var5.getCount();
      if (var4) {
         var6--;
      }

      if (var6 <= 0) {
         int var7 = C0072.m_17e298ea(var2).m_eb304949();
         if (var7 != -1) {
            int var8 = var1.getCurrentItem();
            if (var3 == EntityHand.OffHand) {
               var8 = 45;
            }

            C0073.m_f76a4979().m_e1463257(var7).m_7c42e94f(C0073.m_a73ee2be(var8)).m_ac6eac3b();
         }
      }
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      EntityInventory var3 = var2.getInventory();
      ItemStack var4 = var3.getStackInSlot(var3.getCurrentItem());
      if (this.f_973ba876 && !var4.isEmpty() && !(Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen)) {
         float var5 = m_2f2b24b9(var4);
         if (var5 <= this.f_7c943105) {
            int var6 = C0072.m_5143fd15(var4.getItem())
               .m_8391f334()
               .m_ceb42ce2(this.f_1d0c8733 ? 0 : 9, var2.getInventory().getSize(), -1, (float)var4.getDamage());
            if (var6 != -1) {
               if (C0073.m_aa45d95d(var6)) {
                  C0073.m_72cafc8a().m_7c42e94f(var6).m_ac6eac3b();
               } else {
                  C0073.m_f76a4979().m_e1463257(var6).m_7c42e94f(C0073.m_a73ee2be(var2.getInventory().getCurrentItem())).m_ac6eac3b();
               }

               C0064.m_13c9ffeb().m_2c2620fc(C0263.m_15737526()).m_ee04ba1b(C0263.m_6cf615ba(), C0263.m_ecb46027()).m_1058ed9a();
            }
         }
      }
   }
}
