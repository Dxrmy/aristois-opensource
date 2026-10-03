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
   private final HashMap<String, List<ItemStack>> f_10c03888 = new HashMap<>();
   private boolean f_f90f841e = false;

   public C0352() {
      super(C0252.bootstrap<"get",47244640276>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640277>(), C0252.bootstrap<"get",47244640278>());
   }

   @EventHandler
   public void m_e111a10e(EventScreen var1) {
      if (var1.getScreen() instanceof ContainerScreen && var1.getType() == Type.PostDraw) {
         ContainerScreen var2 = (ContainerScreen)var1.getScreen();
         if (var2.getInventoryName().toString().toLowerCase().contains(C0252.bootstrap<"get",47244640279>())) {
            Inventory var3 = var2.getContainerInventory();
            ArrayList var4 = new ArrayList();

            for (int var5 = 0; var5 < var3.getSize(); var5++) {
               ItemStack var6 = var3.getStackInSlot(var5);
               if (!var6.isEmpty()) {
                  var4.add(var6);
               }
            }

            this.f_10c03888.put(C0114.bootstrap<"call",0,1>(), var4);
         } else if (var2.isHovered()) {
            List var7 = this.f_10c03888.get(C0114.bootstrap<"call",0,1>());
            ItemStack var8 = var2.getHoveredItemStack();
            if (var7 != null && var8.getItem().getIdentifierKey().contains(C0252.bootstrap<"get",30064771125>())) {
               C0114.bootstrap<"call",1,1>(var7, var1.getMouseX() + 8, this.f_f90f841e ? var1.getMouseY() + 24 : var1.getMouseY() + 8);
            }
         }
      }
   }

   @EventHandler
   public void m_c7e039ed(EventGetItemToolTip var1) {
      this.f_f90f841e = var1.isAdvanced();
   }
}
