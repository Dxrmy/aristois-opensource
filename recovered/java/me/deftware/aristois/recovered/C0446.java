package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Collections;
import me.deftware.aristois.menu.view.container.ContextMenu;
import me.deftware.aristois.menu.view.container.ModifiableWidget;
import me.deftware.aristois.menu.view.dialog.DialogWidget;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.GuiScreen.BackgroundType;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.input.Mouse;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;
import org.lwjgl.glfw.GLFW;

public abstract class C0446 extends C0150 {
   protected C0441 f_b48b1555;
   protected double f_bda96e4b;
   protected double f_78fb3fbb;
   protected int f_4622f81d = -1;
   private C0153 f_b8bd3bea = null;
   protected final QuadRenderStack f_5cd8cdfe = (QuadRenderStack)new QuadRenderStack().setScaled(false);

   public C0446(GenericScreen var1) {
      super(var1);
      this.setBackgroundType(BackgroundType.None);
      this.m_c037c5e2(new C0170(C0170.anonymousthis.f_8f6bc807));
      Mouse.registerScrollHook((var1x, var2) -> {
         this.m_0eebc025(var1x, var2);
         C0163 var3 = this.m_5be6bae4(this.f_bda96e4b, this.f_78fb3fbb);
         if (var3 != null) {
            var3.m_0eebc025(var1x, var2);
         }
      });
   }

   protected void m_0eebc025(double var1, double var3) {
   }

   @Override
   protected void onInitGui() {
      this.f_3a3757f5.removeIf(var0 -> var0 instanceof DialogWidget);
      super.onInitGui();
   }

   protected boolean goBack() {
      return !this.f_3a3757f5.removeIf(var0 -> var0 instanceof DialogWidget) && !this.f_3a3757f5.removeIf(var0 -> var0 instanceof ContextMenu)
         ? super.goBack()
         : true;
   }

   @Override
   protected boolean onMouseClicked(int var1, int var2, int var3) {
      var1 = (int)this.m_d945de47((double)var1);
      var2 = (int)this.m_461db524((double)var2);

      for (int var4 = this.f_3a3757f5.size() - 1; var4 >= 0; var4--) {
         C0163 var5 = this.f_3a3757f5.get(var4);
         boolean var6 = var5.m_8407b1bf((double)var1, (double)var2, var3);
         if (var6 && this.m_17a413dc(var5, (double)var1, (double)var2)) {
            if (!(var5 instanceof ContextMenu)) {
               this.m_885a0920(var1, var2);
            }

            Collections.swap(this.f_3a3757f5, var4, this.f_3a3757f5.size() - 1);
            return true;
         }
      }

      return false;
   }

   protected void m_885a0920(int var1, int var2) {
      C0163 var3 = this.f_3a3757f5.get(this.f_3a3757f5.size() - 1);
      if (var3 instanceof ContextMenu && !var3.m_44bb072f().m_a58797d6((double)var1, (double)var2)) {
         this.f_3a3757f5.remove(var3);
      }
   }

   protected boolean m_f79ec8c5(C0163 var1) {
      if (!(var1 instanceof ModifiableWidget)) {
         return false;
      } else {
         ModifiableWidget var2 = (ModifiableWidget)var1;
         return var2.isResizeBottom() || var2.isResizeRight() || var2.isResizeLeft();
      }
   }

   public C0163 m_5be6bae4(double var1, double var3) {
      C0163 var5 = null;

      for (C0163 var7 : this.f_3a3757f5) {
         if (this.m_17a413dc(var7, var1, var3)) {
            var5 = var7;
         }
      }

      return var5;
   }

   protected boolean m_17a413dc(C0163 var1, double var2, double var4) {
      return var1.m_44bb072f().m_a58797d6(var2, var4) || this.m_f79ec8c5(var1) || var1 instanceof DialogWidget && ((DialogWidget)var1).isDarkOverlay();
   }

   public void m_ddfd9367(double var1) {
      for (int var3 = 0; var3 < this.f_3a3757f5.size(); var3++) {
         C0163 var4 = this.f_3a3757f5.get(var3);
         boolean var5 = var3 % 2 != 0;
         C0165 var6 = var3 < 2 ? null : this.f_3a3757f5.get(var3 - (var5 ? 2 : 1)).m_44bb072f();
         C0165 var7 = var5 ? this.f_3a3757f5.get(var3 - 1).m_44bb072f() : null;
         var4.m_44bb072f()
            .m_f8b16cfb(
               var1 + (var6 == null ? 0.0 : var6.m_a005efae() + var6.m_4388ac29()), var1 + (var7 != null ? var7.m_84808068() + var7.m_d42f3372() : 0.0)
            );
      }
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      GLX.INSTANCE.push();
      RenderStack.setupGl();
      this.f_1676ce40.m_1058ed9a();
      var1 = (int)this.m_d945de47((double)var1);
      var2 = (int)this.m_461db524((double)var2);
      ((QuadRenderStack)this.f_5cd8cdfe.glColor(Color.black, 100.0F))
         .begin()
         .drawRect(0.0F, 0.0F, (float)GuiScreen.getDisplayWidth(), (float)GuiScreen.getDisplayHeight())
         .end();
      this.f_bda96e4b = (double)var1;
      this.f_78fb3fbb = (double)var2;
      C0163 var4 = this.m_5be6bae4((double)var1, (double)var2);
      int var5 = 221185;

      for (C0163 var7 : this.f_3a3757f5) {
         boolean var8 = false;
         if (var4 != null) {
            var8 = !var4.equals(var7);
         } else if (!var7.m_44bb072f().m_a58797d6((double)var1, (double)var2)) {
            var8 = true;
         }

         if (var7 instanceof C0437) {
            int var9 = ((C0437)var7).m_3abf02d1((double)var1, (double)var2);
            if (var9 != -1) {
               var5 = var9;
            }
         }

         var7.m_572d14e6((double)var1, (double)var2, var3, var8);
      }

      if (this.f_4622f81d != var5) {
         this.f_4622f81d = var5;
         GLFW.glfwSetCursor(WindowHelper.getWindowHandle(), GLFW.glfwCreateStandardCursor(var5));
      }

      if (var4 != null && this.f_b48b1555.m_f7b07982()) {
         C0153 var12 = var4.m_75885561();
         if (var12 != null) {
            if (this.f_b8bd3bea == null || this.f_b8bd3bea != var12) {
               this.f_b8bd3bea = var12;
               var12.m_1058ed9a();
            }

            var12.m_572d14e6((double)var1, (double)var2, var3, false);
         }
      }

      this.f_1676ce40.m_b728afce();
      RenderStack.restoreGl();
      GLX.INSTANCE.pop();
   }

   protected void onGuiClose() {
      GLFW.glfwSetCursor(WindowHelper.getWindowHandle(), GLFW.glfwCreateStandardCursor(221185));
   }

   @Override
   protected void onPostDraw(int var1, int var2, float var3) {
   }

   public C0441 m_2ea807fd() {
      return this.f_b48b1555;
   }

   public void m_3dcead2b(C0441 var1) {
      this.f_b48b1555 = var1;
   }

   public void m_c7a3618c(C0153 var1) {
      this.f_b8bd3bea = var1;
   }
}
