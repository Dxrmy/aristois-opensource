package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventGetItemToolTip;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.nbt.NbtCompound;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0343 extends AbstractMod {
   private static final MinecraftIdentifier f_6c919dda = new MinecraftIdentifier(C0252.bootstrap<"get",47244640310>());
   @C0098(
      value = "Compact",
      description = {"Stack items above 64 to save space"}
   )
   private boolean f_6d7fd38f = false;
   private boolean f_55ad1291 = false;

   public C0343() {
      super(C0252.bootstrap<"get",47244640304>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640305>());
   }

   @EventHandler
   public void m_f117412b(EventScreen var1) {
      if (var1.getScreen() instanceof ContainerScreen && var1.getType() == Type.PostDraw) {
         ContainerScreen var2 = (ContainerScreen)var1.getScreen();
         if (var2.isHovered()) {
            ItemStack var3 = var2.getHoveredItemStack();
            if (var3.getItem().instanceOf(ItemType.ItemShulkerBox)) {
               C0114.bootstrap<"call",1,1>(
                  C0114.bootstrap<"call",0,1>(var3), var1.getMouseX() + 8, this.f_55ad1291 ? var1.getMouseY() + 24 : var1.getMouseY() + 8
               );
            }
         }
      }
   }

   @EventHandler
   public void m_0771382e(EventGetItemToolTip var1) {
      this.f_55ad1291 = var1.isAdvanced();
      if (var1.getItem().instanceOf(ItemType.ItemShulkerBox)) {
         var1.remove(var0 -> {
            String var1x = var0.string();
            return C0114.bootstrap<"call",7,1>(var1x.matches(C0252.bootstrap<"get",47244640308>()) || var1x.matches(C0252.bootstrap<"get",47244640309>()));
         });
      }
   }

   public static void m_6575d582(List<ItemStack> var0, int var1, int var2) {
      if (!var0.isEmpty()) {
         int var3 = var0.size();
         int var4 = var3 / 9 + (var3 % 9 == 0 ? 0 : 1);
         C0114.bootstrap<"call",2,1>(var0, var1 + 7, var2 - 110 - 18 + 42 + var4 * 18);
      }

      List var5 = C0114.bootstrap<"call",0,1>(ItemStack.EMPTY);
      if (!var5.isEmpty()) {
         C0114.bootstrap<"call",2,1>(var5, var1 + 7, var2 - 100);
      }
   }

   public static List<ItemStack> m_1b7cbe3a(ItemStack var0) {
      ArrayList var1 = new ArrayList();
      NbtCompound var2 = var0.getNbt();
      if (var2.isValid() && var2.contains(C0252.bootstrap<"get",47244640306>(), 10)) {
         NbtCompound var3 = var2.get(C0252.bootstrap<"get",47244640306>());
         if (var3.contains(C0252.bootstrap<"get",47244640307>(), 9)) {
            for (ItemStack var5 : C0114.bootstrap<"call",3,1>(var3, 27)) {
               if (!var5.isEmpty()) {
                  boolean var6 = true;
                  if (((C0343)C0114.bootstrap<"call",4,1>(C0343.class)).m_6197acc1()) {
                     for (ItemStack var8 : var1) {
                        if (var5.isEqualItems(var8, true) && var8.equals(var5)) {
                           var8.setCount(var5.getCount() + var8.getCount());
                           var6 = false;
                        }
                     }
                  }

                  if (var6) {
                     var1.add(var5);
                  }
               }
            }
         }
      }

      return var1;
   }

   public static void m_bd513307(List<ItemStack> var0, int var1, int var2) {
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      C0114.bootstrap<"call",0,1>();
      int var3 = var0.size() / 9 + (var0.size() % 9 == 0 ? 0 : 1);
      int var4 = var3;
      if (var3 == 3) {
         var3 = 1;
      } else if (var3 == 1) {
         var3 = 3;
      }

      C0114.bootstrap<"call",1,1>(f_6c919dda);
      C0114.bootstrap<"call",2,1>();
      C0114.bootstrap<"call",3,1>();
      C0114.bootstrap<"call",4,1>(var1 - 8, var2 + 12 + var3 * 18, 176, 5, 0, 0, 256, 256);
      C0114.bootstrap<"call",4,1>(var1 - 8, var2 + 12 + var3 * 18 + 5, 176, var4 * 18, 0, 16, 256, 256);
      C0114.bootstrap<"call",4,1>(var1 - 8, var2 + 17 + var3 * 18 + var4 * 18, 176, 6, 0, 160, 256, 256);
      C0114.bootstrap<"call",5,1>();
      GLX.INSTANCE.translate(0.0F, 0.0F, 32.0F);
      int var5 = var0.size();

      for (int var6 = 0; var6 < var5; var6++) {
         C0114.bootstrap<"call",6,1>((ItemStack)var0.get(var6), var6 % 9 * 18 + var1, var3 * 18 + (var6 / 9 + 1) * 18 + var2 + 1);
      }

      C0114.bootstrap<"call",3,1>();
      C0114.bootstrap<"call",7,1>(0.0F);
   }

   public static void m_9d5d6cb6(ItemStack var0, int var1, int var2) {
      C0114.bootstrap<"call",5,1>(120.0F);
      var0.renderItemAndEffectIntoGUI(var1, var2);
      String var3 = var0.getCount() == 1 ? "" : C0114.bootstrap<"call",6,1>(var0.getCount());
      String var4 = C0252.bootstrap<"get",34359738442>() + var0.getCount() % var0.getMaxSize();
      String var5 = var0.getCount() / var0.getMaxSize() + C0252.bootstrap<"get",17179869308>() + var4;
      var0.renderItemOverlayIntoGUI(var1, var2, var3);
      C0114.bootstrap<"call",5,1>(0.0F);
   }

   public boolean m_6197acc1() {
      return this.f_6d7fd38f;
   }
}
