package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventGetItemToolTip;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.ItemStack;

public class C0352 extends AbstractMod {
   private final HashMap<String, List<ItemStack>> f_2de8a7a8 = new HashMap<>();
   private boolean f_4f44061f = false;

   public C0352() {
      super(C0260.m_b48a8bc4(), C0290.f_99d080af, C0260.m_b886ae1c(), C0260.m_bec91365());
   }

   @EventHandler
   public void m_65c92cfe(EventScreen var1) {
      if (var1.getScreen() instanceof ContainerScreen && var1.getType() == Type.PostDraw) {
         ContainerScreen var2 = (ContainerScreen)var1.getScreen();
         if (var2.getInventoryName().toString().toLowerCase().contains(C0260.m_79bfaec2())) {
            Inventory var3 = var2.getContainerInventory();
            ArrayList var4 = new ArrayList();

            for (int var5 = 0; var5 < var3.getSize(); var5++) {
               ItemStack var6 = var3.getStackInSlot(var5);
               if (!var6.isEmpty()) {
                  var4.add(var6);
               }
            }

            this.f_2de8a7a8.put(C0451.m_3855be80(), var4);
         } else if (var2.isHovered()) {
            List var7 = this.f_2de8a7a8.get(C0451.m_3855be80());
            ItemStack var8 = var2.getHoveredItemStack();
            if (var7 != null && var8.getItem().getIdentifierKey().contains(C0265.m_88726494())) {
               C0343.m_9aa22aba(var7, var1.getMouseX() + 8, this.f_4f44061f ? var1.getMouseY() + 24 : var1.getMouseY() + 8);
            }
         }
      }
   }

   @EventHandler
   public void m_2b90e041(EventGetItemToolTip var1) {
      this.f_4f44061f = var1.isAdvanced();
   }
}
