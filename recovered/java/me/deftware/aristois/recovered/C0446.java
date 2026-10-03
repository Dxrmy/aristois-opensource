package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.menu.view.container.ContextMenu;
import me.deftware.aristois.menu.view.container.ModifiableWidget;
import me.deftware.aristois.menu.view.dialog.DialogWidget;
import me.deftware.client.framework.gui.GuiScreen.BackgroundType;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.gl.GLX;

public abstract class C0446 extends C0150 {
   protected C0441 f_c3908204;
   protected double f_862c35f9;
   protected double f_6ffd9430;
   protected int f_258a51d0 = -1;
   private C0153 f_8a7be2ae = null;
   protected final QuadRenderStack f_65418f48 = (QuadRenderStack)new QuadRenderStack().setScaled(false);

   public C0446(GenericScreen var1) {
      super(var1);
      this.setBackgroundType(BackgroundType.None);
      this.m_8a07cc27(new C0170(C0170.anonymousthis.f_146b6ee0));
      C0114.bootstrap<"call",0,1>((var1x, var2) -> {
         this.m_69b91328(var1x, var2);
         C0163 var3 = this.m_910d92d3(this.f_862c35f9, this.f_6ffd9430);
         if (var3 != null) {
            var3.m_9357ee29(var1x, var2);
         }
      });
   }

   protected void m_69b91328(double var1, double var3) {
   }

   @Override
   protected void onInitGui() {
      this.f_70ce9296.removeIf(var0 -> var0 instanceof DialogWidget);
      super.onInitGui();
   }

   protected boolean goBack() {
      return !this.f_70ce9296.removeIf(var0 -> var0 instanceof DialogWidget) && !this.f_70ce9296.removeIf(var0 -> var0 instanceof ContextMenu)
         ? super.goBack()
         : true;
   }

   @Override
   protected boolean onMouseClicked(int var1, int var2, int var3) {
      var1 = (int)this.m_dd3897ca((double)var1);
      var2 = (int)this.m_0fb4a58b((double)var2);

      for (int var4 = this.f_70ce9296.size() - 1; var4 >= 0; var4--) {
         C0163 var5 = (C0163)this.f_70ce9296.get(var4);
         boolean var6 = var5.m_7e41b969((double)var1, (double)var2, var3);
         if (var6 && this.m_ca249047(var5, (double)var1, (double)var2)) {
            if (!(var5 instanceof ContextMenu)) {
               this.m_d988b758(var1, var2);
            }

            C0114.bootstrap<"call",0,1>(this.f_70ce9296, var4, this.f_70ce9296.size() - 1);
            return true;
         }
      }

      return false;
   }

   protected void m_d988b758(int var1, int var2) {
      C0163 var3 = (C0163)this.f_70ce9296.get(this.f_70ce9296.size() - 1);
      if (var3 instanceof ContextMenu && !var3.m_fd6ca281().m_263d91ea((double)var1, (double)var2)) {
         this.f_70ce9296.remove(var3);
      }
   }

   protected boolean m_f14aabda(C0163 var1) {
      if (!(var1 instanceof ModifiableWidget)) {
         return false;
      } else {
         ModifiableWidget var2 = (ModifiableWidget)var1;
         return var2.isResizeBottom() || var2.isResizeRight() || var2.isResizeLeft();
      }
   }

   public C0163 m_910d92d3(double var1, double var3) {
      C0163 var5 = null;

      for (C0163 var7 : this.f_70ce9296) {
         if (this.m_ca249047(var7, var1, var3)) {
            var5 = var7;
         }
      }

      return var5;
   }

   protected boolean m_ca249047(C0163 var1, double var2, double var4) {
      return var1.m_fd6ca281().m_263d91ea(var2, var4) || this.m_f14aabda(var1) || var1 instanceof DialogWidget && ((DialogWidget)var1).isDarkOverlay();
   }

   public void m_9fcd5c03(double var1) {
      for (int var3 = 0; var3 < this.f_70ce9296.size(); var3++) {
         C0163 var4 = (C0163)this.f_70ce9296.get(var3);
         boolean var5 = var3 % 2 != 0;
         C0165 var6 = var3 < 2 ? null : ((C0163)this.f_70ce9296.get(var3 - (var5 ? 2 : 1))).m_fd6ca281();
         C0165 var7 = var5 ? ((C0163)this.f_70ce9296.get(var3 - 1)).m_fd6ca281() : null;
         var4.m_fd6ca281()
            .m_1e49f000(
               var1 + (var6 == null ? 0.0 : var6.m_14f8bc2c() + var6.m_830cb294()), var1 + (var7 != null ? var7.m_5a998971() + var7.m_fc7f45bc() : 0.0)
            );
      }
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      GLX.INSTANCE.push();
      C0114.bootstrap<"call",0,1>();
      this.f_ad5998f0.m_80718ecc();
      var1 = (int)this.m_dd3897ca((double)var1);
      var2 = (int)this.m_0fb4a58b((double)var2);
      ((QuadRenderStack)this.f_65418f48.glColor(Color.black, 100.0F))
         .begin()
         .drawRect(0.0F, 0.0F, (float)C0114.bootstrap<"call",1,1>(), (float)C0114.bootstrap<"call",2,1>())
         .end();
      this.f_862c35f9 = (double)var1;
      this.f_6ffd9430 = (double)var2;
      C0163 var4 = this.m_910d92d3((double)var1, (double)var2);
      int var5 = 221185;

      for (C0163 var7 : this.f_70ce9296) {
         boolean var8 = false;
         if (var4 != null) {
            var8 = !var4.equals(var7);
         } else if (!var7.m_fd6ca281().m_263d91ea((double)var1, (double)var2)) {
            var8 = true;
         }

         if (var7 instanceof C0437) {
            int var9 = ((C0437)var7).m_5227a122((double)var1, (double)var2);
            if (var9 != -1) {
               var5 = var9;
            }
         }

         var7.m_2f338522((double)var1, (double)var2, var3, var8);
      }

      if (this.f_258a51d0 != var5) {
         this.f_258a51d0 = var5;
         C0114.bootstrap<"call",5,1>(C0114.bootstrap<"call",3,1>(), C0114.bootstrap<"call",4,1>(var5));
      }

      if (var4 != null && this.f_c3908204.m_6e5853a8()) {
         C0153 var12 = var4.m_bb20fb08();
         if (var12 != null) {
            if (this.f_8a7be2ae == null || this.f_8a7be2ae != var12) {
               this.f_8a7be2ae = var12;
               var12.m_4f39a897();
            }

            var12.m_92696976((double)var1, (double)var2, var3, false);
         }
      }

      this.f_ad5998f0.m_04aec35b();
      C0114.bootstrap<"call",6,1>();
      GLX.INSTANCE.pop();
   }

   protected void onGuiClose() {
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>(), C0114.bootstrap<"call",1,1>(221185));
   }

   @Override
   protected void onPostDraw(int var1, int var2, float var3) {
   }

   public C0441 m_f5556892() {
      return this.f_c3908204;
   }

   public void m_09faea97(C0441 var1) {
      this.f_c3908204 = var1;
   }

   public void m_ff2cab60(C0153 var1) {
      this.f_8a7be2ae = var1;
   }
}
