package me.deftware.aristois.recovered;

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

public class C0414 extends AbstractMod {
   @C0098(
      value = "Food lvl.",
      description = {"At what hunger level to trigger"}
   )
   private float f_4e1ac306 = 10.0F;
   @C0098(
      value = "Health mode",
      description = {"Sort items by health mode"}
   )
   private boolean f_2ca355c7 = false;
   private int f_c390f1e2 = -1;

   public C0414() {
      super(C0252.bootstrap<"get",38654705736>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705737>());
   }

   @EventHandler
   public void m_9fe489b1(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!var2.isCreative() && !(C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen)) {
         int var3 = this.m_c4146ca5(0, 9, var2);
         if (var3 != -1) {
            if ((float)var2.getFoodLevel() > this.f_4e1ac306 && !this.f_2ca355c7 || var2.getHealth() > this.f_4e1ac306 && this.f_2ca355c7) {
               this.m_db4b5f61(var2);
               return;
            }

            if (this.f_c390f1e2 == -1) {
               this.f_c390f1e2 = var2.getInventory().getCurrentItem();
            }

            var2.getInventory().setCurrentItem(var3);
            MinecraftKeyBind.USE_ITEM.setPressed(true);
            var2.processRightClick(false);
         }

         int var4 = this.m_c4146ca5(9, 36, var2);
         if (var4 != -1) {
            var2.windowClick(var4, 0, WindowClickAction.QUICK_MOVE);
         }
      }
   }

   private void m_db4b5f61(EntityPlayer var1) {
      if (this.f_c390f1e2 != -1) {
         MinecraftKeyBind.USE_ITEM.setPressed(false);
         var1.getInventory().setCurrentItem(this.f_c390f1e2);
         this.f_c390f1e2 = -1;
      }
   }

   private int m_c4146ca5(int var1, int var2, EntityPlayer var3) {
      for (int var4 = var1; var4 < var2; var4++) {
         ItemStack var5 = var3.getInventory().getStackInSlot(var4);
         if (var5 != null && var5.getItem().instanceOf(ItemType.ItemSoup)) {
            return var4;
         }
      }

      return -1;
   }
}
