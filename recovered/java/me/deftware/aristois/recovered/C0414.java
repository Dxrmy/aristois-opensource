package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0414 extends AbstractMod {
   @C0098(
      value = "Food lvl.",
      description = {"At what hunger level to trigger"}
   )
   private float f_41ed4e26 = 10.0F;
   @C0098(
      value = "Health mode",
      description = {"Sort items by health mode"}
   )
   private boolean f_0a7742b4 = false;
   private int f_83a30326 = -1;

   public C0414() {
      super(C0263.m_00ba16c2(), C0290.f_dbc16475, C0263.m_d1f7b79f());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!var2.isCreative() && !(Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen)) {
         int var3 = this.m_8ffe9620(0, 9, var2);
         if (var3 != -1) {
            if ((float)var2.getFoodLevel() > this.f_41ed4e26 && !this.f_0a7742b4 || var2.getHealth() > this.f_41ed4e26 && this.f_0a7742b4) {
               this.m_a1d81f92(var2);
               return;
            }

            if (this.f_83a30326 == -1) {
               this.f_83a30326 = var2.getInventory().getCurrentItem();
            }

            var2.getInventory().setCurrentItem(var3);
            MinecraftKeyBind.USE_ITEM.setPressed(true);
            var2.processRightClick(false);
         }

         int var4 = this.m_8ffe9620(9, 36, var2);
         if (var4 != -1) {
            var2.windowClick(var4, 0, WindowClickAction.QUICK_MOVE);
         }
      }
   }

   private void m_a1d81f92(EntityPlayer var1) {
      if (this.f_83a30326 != -1) {
         MinecraftKeyBind.USE_ITEM.setPressed(false);
         var1.getInventory().setCurrentItem(this.f_83a30326);
         this.f_83a30326 = -1;
      }
   }

   private int m_8ffe9620(int var1, int var2, EntityPlayer var3) {
      for (int var4 = var1; var4 < var2; var4++) {
         ItemStack var5 = var3.getInventory().getStackInSlot(var4);
         if (var5 != null && var5.getItem().instanceOf(ItemType.ItemSoup)) {
            return var4;
         }
      }

      return -1;
   }
}
