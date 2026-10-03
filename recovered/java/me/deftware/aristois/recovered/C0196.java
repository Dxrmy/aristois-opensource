package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.ArgumentType;
import java.util.function.Function;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.registry.IRegistry;
import me.deftware.client.framework.render.gl.GLX;

public class C0196<T extends ListItem> extends C0188<T> {
   private final C0219<T> f_9711e849;
   private C0157 f_c34aa33c;
   private ArgumentType<T> f_d59365f4;

   public C0196(GenericScreen var1, C0219<T> var2, IRegistry<T, ?> var3, String var4, Function<T, String> var5) {
      this(var1, var2.m_87bd75a8(), var2, var3, var4, var5);
   }

   public C0196(GenericScreen var1, Class<T> var2, C0219<T> var3, IRegistry<T, ?> var4, String var5, Function<T, String> var6) {
      this(var1, var2, var3, new C0205<>(var2, var4, var6), var5);
   }

   public C0196(GenericScreen var1, Class<T> var2, C0219<T> var3, C0205<T> var4, String var5) {
      super(var1, var4);
      ((C0205)this.m_fe629718()).m_af068cf6(this.f_9711e849 = var3);
      this.f_cca5019f = this.f_9711e849 != null;
      this.f_e3a35e7b = var5;
   }

   protected void m_2463b2f6() {
      ((C0205)this.m_fe629718()).m_a457816d(false);
      this.m_9ee882d0();
   }

   public C0196<T> m_7124dbac(ArgumentType<T> var1) {
      this.f_d59365f4 = var1;
      return this;
   }

   protected C0219<T> m_56933e09() {
      return this.f_9711e849;
   }

   @Override
   protected boolean onMouseClicked(int var1, int var2, int var3) {
      ListItem var4 = this.f_b98dbdc4.getHoveredItem(var1, var2);
      if (var4 != null && var1 > this.getGuiScreenWidth() - 100) {
         if (this.f_9711e849.contains(var4)) {
            this.f_9711e849.remove(var4);
         } else {
            this.f_9711e849.add((T)var4);
         }
      }

      return super.onMouseClicked(var1, var2, var3);
   }

   protected void m_22ec7a0a(T var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {
      if (this.f_9711e849 != null) {
         byte var10 = 20;
         int var11 = this.getGuiScreenWidth() - 100;
         int var12 = var4 + (this.f_3f208907 / 2 - var10 / 2) - 2;
         boolean var13 = var7 > var11 && var7 < var11 + var10 && var8 > var12 && var8 < var12 + var10;
         GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
         C0228.f_13f0edde.bind().draw(var11, var12, var10, var10, var13 ? 20 : 0, this.f_9711e849.contains(var1) ? 20 : 0, 64, 64).unbind();
      }
   }

   protected void m_04421533() {
      super.m_295487ee();
      this.f_b98dbdc4.setExtended(true);
      this.m_d6b8b136(new C0163[]{this.f_c34aa33c = (new C0164(40, 10, 120, 20, this.f_d59365f4) {
         protected void m_8724cecc() {
            C0196.this.m_9ee882d0();
         }
      }).m_db1dbe71(C0252.bootstrap<"get",17179869307>())});
      if (this.f_cca5019f) {
         C0154 var1 = this.m_966c3900(
            C0114.bootstrap<"call",0,1>() - (this.f_9711e849 != null && this.f_9711e849.m_c831055d().isEmpty() ? 55 : 80),
            10,
            20.0F,
            C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",17179869308>()),
            () -> {
               ((C0205)this.m_fe629718()).m_a457816d(!((C0205)this.m_fe629718()).m_841de62f());
               this.m_9ee882d0();
            }
         );
         var1.m_ca06ea23(new C0153(var1, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",17179869309>())));
         this.m_d6b8b136(new C0163[]{var1});
      }

      this.m_9ee882d0();
   }

   public void m_5ddfebf8() {
      ((C0205)this.m_fe629718()).m_252ea052();
   }

   protected void m_9ee882d0() {
      ((C0205)this.m_fe629718()).m_f6813196(this.f_c34aa33c.m_55cc55cf());
      this.f_b98dbdc4.setScrollbarPosition(0);
   }

   public C0219<T> m_d3f5a3db() {
      return this.f_9711e849;
   }

   public C0157 m_9df79e77() {
      return this.f_c34aa33c;
   }

   public ArgumentType<T> m_ef8e971b() {
      return this.f_d59365f4;
   }
}
