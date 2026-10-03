package me.deftware.aristois.recovered;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.enchantment.Enchantment;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.util.types.Pair;

public class C0294 {
   private float f_83cc56c4 = 0.5F;
   private float f_19ecc692 = 10.0F;
   private int f_f9824ac5 = (int)(16.0F / (this.f_83cc56c4 * (float)C0114.bootstrap<"call",0,1>()));
   private static Message f_110e3d58 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967393>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GOLD));

   public void m_2b39d85d(float var1) {
      this.f_83cc56c4 = var1;
      this.f_f9824ac5 = (int)(16.0F / (var1 * (float)C0114.bootstrap<"call",0,1>()));
   }

   public void m_b84e05f2(int var1, int var2, ItemStack var3, Pair<Boolean, Boolean> var4) {
      this.m_077c1e62(
         var1,
         var2,
         var3,
         (var2x, var3x) -> {
            if ((Boolean)var4.getLeft()) {
               for (Pair var5 : var2x.getEnchantments()) {
                  Message var6 = C0114.bootstrap<"call",6,1>(((Enchantment)var5.getLeft()).getName((Integer)var5.getRight()).string());
                  C0114.bootstrap<"call",7,1>(var6, 0, var3x, 255);
                  var3x = C0114.bootstrap<"call",2,1>(var3x - C0114.bootstrap<"call",0,1>());
               }
            } else {
               List var11 = var2x.getEnchantments();
               LinkedList var12 = new LinkedList();
               int var13 = -1;
               int var7 = (int)C0114.bootstrap<"call",10,1>(
                  1.0, C0114.bootstrap<"call",9,1>((double)var11.size() / (double)C0114.bootstrap<"call",8,1>(this.f_f9824ac5, 1))
               );

               for (Pair var9 : var11) {
                  Message var10 = C0114.bootstrap<"call",6,1>(((Enchantment)var9.getLeft()).getName((Integer)var9.getRight()).string());
                  if (++var13 % var7 == 0) {
                     var12.add(var10);
                  } else {
                     ((Message)var12.get(var13 / var7)).append(f_110e3d58).append(var10);
                  }
               }

               for (Message var15 : var12) {
                  C0114.bootstrap<"call",7,1>(var15, var4.getRight() ? 16 - C0114.bootstrap<"call",11,1>(var15) : 0, var3x, 255);
                  var3x = C0114.bootstrap<"call",2,1>(var3x - C0114.bootstrap<"call",0,1>());
               }
            }
         }
      );
   }

   public void m_077c1e62(int var1, int var2, ItemStack var3, BiConsumer<ItemStack, Integer> var4) {
      GLX.INSTANCE.push();
      C0114.bootstrap<"call",1,1>(-151.0F);
      var3.renderItemAndEffectIntoGUI(var1, var2);
      C0114.bootstrap<"call",1,1>(-187.0F);
      var3.renderItemOverlays(var1, var2);
      C0114.bootstrap<"call",1,1>(0.0F);
      GLX.INSTANCE.translate((float)var1, (float)var2, 0.0F);
      GLX.INSTANCE.scale(this.f_83cc56c4, this.f_83cc56c4, 0.0F);
      var2 = (int)this.f_19ecc692;
      if (var4 != null) {
         var4.accept(var3, C0114.bootstrap<"call",2,1>((int)((float)var2 / this.f_83cc56c4)));
      }

      C0114.bootstrap<"call",1,1>(0.0F);
      GLX.INSTANCE.pop();
   }

   public static Message m_d3a854b1(String var0) {
      String[] var1 = var0.split(C0252.bootstrap<"get",70>());
      String var2 = var1[var1.length - 1];
      StringBuilder var3 = new StringBuilder();

      for (int var4 = 0; var4 < var1.length - 1; var4++) {
         String var5 = var1[var4];
         if (var5.length() > 6 && var4 == 0) {
            var5 = var5.substring(0, 6);
         } else if (var5.length() > 4) {
            var5 = var5.substring(0, 4);
         }

         var3.append(var5).append(C0252.bootstrap<"get",42949672967>());
      }

      var0 = var3.toString();
      return C0114.bootstrap<"call",4,1>(var0 + var2.substring(0, C0114.bootstrap<"call",3,1>(var2.length(), 5)))
         .style(C0114.bootstrap<"call",5,1>(DefaultColors.GOLD));
   }

   public C0294() {
   }

   public float m_ca0a73da() {
      return this.f_83cc56c4;
   }

   public float m_e3bd8938() {
      return this.f_19ecc692;
   }

   public int m_e8f4491c() {
      return this.f_f9824ac5;
   }

   public void m_85d8cf80(float var1) {
      this.f_19ecc692 = var1;
   }

   public void m_8d1297ba(int var1) {
      this.f_f9824ac5 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0294)) {
         return false;
      } else {
         C0294 var2 = (C0294)var1;
         if (!var2.m_e7a815cb(this)) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_ca0a73da(), var2.m_ca0a73da()) != 0) {
            return false;
         } else {
            return C0114.bootstrap<"call",0,1>(this.m_e3bd8938(), var2.m_e3bd8938()) != 0 ? false : this.m_e8f4491c() == var2.m_e8f4491c();
         }
      }
   }

   protected boolean m_e7a815cb(Object var1) {
      return var1 instanceof C0294;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + C0114.bootstrap<"call",0,1>(this.m_ca0a73da());
      var2 = var2 * 59 + C0114.bootstrap<"call",0,1>(this.m_e3bd8938());
      return var2 * 59 + this.m_e8f4491c();
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",42949672968>()
         + this.m_ca0a73da()
         + C0252.bootstrap<"get",42949672969>()
         + this.m_e3bd8938()
         + C0252.bootstrap<"get",42949672970>()
         + this.m_e8f4491c()
         + C0252.bootstrap<"get",59>();
   }
}
