package me.deftware.aristois.recovered;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.enchantment.Enchantment;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.util.types.Pair;

public class C0294 {
   private float f_193cdd10 = 0.5F;
   private float f_21f684af = 10.0F;
   private int f_8667717e = (int)(16.0F / (this.f_193cdd10 * (float)FontRenderer.getFontHeight()));
   private static Message f_e0bfd9d2 = Message.of(C0264.m_03430357()).style(Appearance.of(DefaultColors.GOLD));

   public void m_d881d3e3(float var1) {
      this.f_193cdd10 = var1;
      this.f_8667717e = (int)(16.0F / (var1 * (float)FontRenderer.getFontHeight()));
   }

   public void m_9e369680(int var1, int var2, ItemStack var3, Pair<Boolean, Boolean> var4) {
      this.m_ad57b8bb(var1, var2, var3, (var2x, var3x) -> {
         if ((Boolean)var4.getLeft()) {
            for (Pair var5 : var2x.getEnchantments()) {
               Message var6 = m_3c709072(((Enchantment)var5.getLeft()).getName((Integer)var5.getRight()).string());
               FontRenderer.drawString(var6, 0, var3x, 255);
               var3x = var3x - FontRenderer.getFontHeight();
            }
         } else {
            List var11 = var2x.getEnchantments();
            LinkedList var12 = new LinkedList();
            int var13 = -1;
            int var7 = (int)Math.max(1.0, Math.ceil((double)var11.size() / (double)Math.max(this.f_8667717e, 1)));

            for (Pair var9 : var11) {
               Message var10 = m_3c709072(((Enchantment)var9.getLeft()).getName((Integer)var9.getRight()).string());
               if (++var13 % var7 == 0) {
                  var12.add(var10);
               } else {
                  ((Message)var12.get(var13 / var7)).append(f_e0bfd9d2).append(var10);
               }
            }

            for (Message var15 : var12) {
               FontRenderer.drawString(var15, var4.getRight() ? 16 - FontRenderer.getStringWidth(var15) : 0, var3x, 255);
               var3x = var3x - FontRenderer.getFontHeight();
            }
         }
      });
   }

   public void m_ad57b8bb(int var1, int var2, ItemStack var3, BiConsumer<ItemStack, Integer> var4) {
      GLX.INSTANCE.push();
      ItemStack.setRenderZLevel(-151.0F);
      var3.renderItemAndEffectIntoGUI(var1, var2);
      ItemStack.setRenderZLevel(-187.0F);
      var3.renderItemOverlays(var1, var2);
      ItemStack.setRenderZLevel(0.0F);
      GLX.INSTANCE.translate((float)var1, (float)var2, 0.0F);
      GLX.INSTANCE.scale(this.f_193cdd10, this.f_193cdd10, 0.0F);
      var2 = (int)this.f_21f684af;
      if (var4 != null) {
         var4.accept(var3, (int)((float)var2 / this.f_193cdd10));
      }

      ItemStack.setRenderZLevel(0.0F);
      GLX.INSTANCE.pop();
   }

   public static Message m_3c709072(String var0) {
      String[] var1 = var0.split(C0257.m_593ecbab());
      String var2 = var1[var1.length - 1];
      StringBuilder var3 = new StringBuilder();

      for (int var4 = 0; var4 < var1.length - 1; var4++) {
         String var5 = var1[var4];
         if (var5.length() > 6 && var4 == 0) {
            var5 = var5.substring(0, 6);
         } else if (var5.length() > 4) {
            var5 = var5.substring(0, 4);
         }

         var3.append(var5).append(C0259.m_624b40d8());
      }

      var0 = var3.toString();
      return Message.of(var0 + var2.substring(0, Math.min(var2.length(), 5))).style(Appearance.of(DefaultColors.GOLD));
   }

   public C0294() {
   }

   public float m_796256b9() {
      return this.f_193cdd10;
   }

   public float m_b7fbb877() {
      return this.f_21f684af;
   }

   public int m_037208cc() {
      return this.f_8667717e;
   }

   public void m_35bea3d9(float var1) {
      this.f_21f684af = var1;
   }

   public void m_46938bdb(int var1) {
      this.f_8667717e = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0294)) {
         return false;
      } else {
         C0294 var2 = (C0294)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (Float.compare(this.m_796256b9(), var2.m_796256b9()) != 0) {
            return false;
         } else {
            return Float.compare(this.m_b7fbb877(), var2.m_b7fbb877()) != 0 ? false : this.m_037208cc() == var2.m_037208cc();
         }
      }
   }

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0294;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.m_796256b9());
      var2 = var2 * 59 + Float.floatToIntBits(this.m_b7fbb877());
      return var2 * 59 + this.m_037208cc();
   }

   @Override
   public String toString() {
      return C0259.m_8d7dbe31() + this.m_796256b9() + C0259.m_1d87ef21() + this.m_b7fbb877() + C0259.m_c42f1c7e() + this.m_037208cc() + C0257.m_9e27f038();
   }
}
