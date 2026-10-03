package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventGetItemToolTip;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.nbt.NbtCompound;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.minecraft.MinecraftIdentifier;

public class C0343 extends AbstractMod {
   private static final MinecraftIdentifier f_1de134ea = new MinecraftIdentifier(C0260.m_27479cfa());
   @C0098(
      value = "Compact",
      description = {"Stack items above 64 to save space"}
   )
   private boolean f_81b9102d = false;
   private boolean f_06a1a4c3 = false;

   public C0343() {
      super(C0260.m_7f74d855(), C0290.f_99d080af, C0260.m_b89b7876());
   }

   @EventHandler
   public void m_65c92cfe(EventScreen var1) {
      if (var1.getScreen() instanceof ContainerScreen && var1.getType() == Type.PostDraw) {
         ContainerScreen var2 = (ContainerScreen)var1.getScreen();
         if (var2.isHovered()) {
            ItemStack var3 = var2.getHoveredItemStack();
            if (var3.getItem().instanceOf(ItemType.ItemShulkerBox)) {
               m_9aa22aba(m_9afc34bd(var3), var1.getMouseX() + 8, this.f_06a1a4c3 ? var1.getMouseY() + 24 : var1.getMouseY() + 8);
            }
         }
      }
   }

   @EventHandler
   public void m_2b90e041(EventGetItemToolTip var1) {
      this.f_06a1a4c3 = var1.isAdvanced();
      if (var1.getItem().instanceOf(ItemType.ItemShulkerBox)) {
         var1.remove(var0 -> {
            String var1x = var0.string();
            return var1x.matches(C0260.m_96ba50d4()) || var1x.matches(C0260.m_88726494());
         });
      }
   }

   public static void m_9aa22aba(List<ItemStack> var0, int var1, int var2) {
      if (!var0.isEmpty()) {
         int var3 = var0.size();
         int var4 = var3 / 9 + (var3 % 9 == 0 ? 0 : 1);
         m_2818e24e(var0, var1 + 7, var2 - 110 - 18 + 42 + var4 * 18);
      }

      List var5 = m_9afc34bd(ItemStack.EMPTY);
      if (!var5.isEmpty()) {
         m_2818e24e(var5, var1 + 7, var2 - 100);
      }
   }

   public static List<ItemStack> m_9afc34bd(ItemStack var0) {
      ArrayList var1 = new ArrayList();
      NbtCompound var2 = var0.getNbt();
      if (var2.isValid() && var2.contains(C0260.m_a33fab52(), 10)) {
         NbtCompound var3 = var2.get(C0260.m_a33fab52());
         if (var3.contains(C0260.m_73708dd3(), 9)) {
            for (ItemStack var5 : ItemStack.loadAllItems(var3, 27)) {
               if (!var5.isEmpty()) {
                  boolean var6 = true;
                  if (C0289.m_c3a8b502(C0343.class).m_e0f7c666()) {
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

   public static void m_2818e24e(List<ItemStack> var0, int var1, int var2) {
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateHelper.disableBlend();
      int var3 = var0.size() / 9 + (var0.size() % 9 == 0 ? 0 : 1);
      int var4 = var3;
      if (var3 == 3) {
         var3 = 1;
      } else if (var3 == 1) {
         var3 = 3;
      }

      GlTexture.bindTexture(f_1de134ea);
      GlStateHelper.disableDepth();
      GlStateHelper.disableLighting();
      GlTexture.drawTexture(var1 - 8, var2 + 12 + var3 * 18, 176, 5, 0, 0, 256, 256);
      GlTexture.drawTexture(var1 - 8, var2 + 12 + var3 * 18 + 5, 176, var4 * 18, 0, 16, 256, 256);
      GlTexture.drawTexture(var1 - 8, var2 + 17 + var3 * 18 + var4 * 18, 176, 6, 0, 160, 256, 256);
      GlStateHelper.enableDepth();
      GLX.INSTANCE.translate(0.0F, 0.0F, 32.0F);
      int var5 = var0.size();

      for (int var6 = 0; var6 < var5; var6++) {
         m_9e0bb460((ItemStack)var0.get(var6), var6 % 9 * 18 + var1, var3 * 18 + (var6 / 9 + 1) * 18 + var2 + 1);
      }

      GlStateHelper.disableLighting();
      ItemStack.setRenderZLevel(0.0F);
   }

   public static void m_9e0bb460(ItemStack var0, int var1, int var2) {
      ItemStack.setRenderZLevel(120.0F);
      var0.renderItemAndEffectIntoGUI(var1, var2);
      String var3 = var0.getCount() == 1 ? "" : String.valueOf(var0.getCount());
      String var4 = C0262.m_a29090eb() + var0.getCount() % var0.getMaxSize();
      String var5 = var0.getCount() / var0.getMaxSize() + C0261.m_ec4ef19a() + var4;
      var0.renderItemOverlayIntoGUI(var1, var2, var3);
      ItemStack.setRenderZLevel(0.0F);
   }

   public boolean m_e0f7c666() {
      return this.f_81b9102d;
   }
}
