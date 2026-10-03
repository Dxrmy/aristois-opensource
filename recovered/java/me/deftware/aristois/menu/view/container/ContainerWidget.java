package me.deftware.aristois.menu.view.container;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import me.deftware.aristois.menu.view.list.ScrollbarWidget;
import me.deftware.aristois.menu.widgets.TitleWidget;
import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0153;
import me.deftware.aristois.recovered.C0163;
import me.deftware.aristois.recovered.C0232;
import me.deftware.aristois.recovered.C0425;
import me.deftware.aristois.recovered.C0426;
import me.deftware.aristois.recovered.C0427;
import me.deftware.aristois.recovered.C0437;
import me.deftware.aristois.recovered.C0438;
import me.deftware.aristois.recovered.C0440;
import me.deftware.aristois.recovered.C0441;
import me.deftware.aristois.recovered.C0442;
import me.deftware.aristois.recovered.C0444;
import me.deftware.aristois.recovered.C0445;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public class ContainerWidget extends ModifiableWidget implements C0440, C0438 {
   protected final QuadRenderStack quadRenderStack = new QuadRenderStack();
   protected final List<C0163> children = new CopyOnWriteArrayList<>();
   protected boolean stencil = false;
   protected boolean scissor = false;
   protected boolean renderBackground = true;
   protected boolean renderShadow = false;
   protected final C0232 stencilBuffer = new C0232();
   protected TitleWidget title;
   protected double shadowSize = 1.5;

   public ContainerWidget(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
   }

   public void m_6b141cfc(C0163... var1) {
      this.children.addAll(C0114.bootstrap<"call",0,1>(var1));
   }

   public void m_6d38cbba(boolean var1) {
      this.quadRenderStack.setScaled(var1);
      this.title.m_f584ec52(var1);
   }

   public void addTitle(Message var1, final Consumer<Integer> var2) {
      this.title = new TitleWidget(var1, this.f_32061256) {
         @Override
         protected void onClick(int var1) {
            var2.accept(C0114.bootstrap<"call",0,1>(var1));
         }

         @Override
         public boolean isMouseOver(double var1, double var3, boolean var5) {
            return super.isMouseOver(var1, var3, var5) || ContainerWidget.this.isDragging();
         }

         @Override
         protected void onExitPress() {
            ContainerWidget.this.close();
         }
      };
      this.title.setDrawArrowButton(false);
      this.title.m_6936247c(new C0426[]{C0426.f_974a55e6});
      this.m_6b141cfc(this.title);
      this.title.setTextAlign(C0427.f_2db8c19a);
      this.setDraggableBorder(this.title.m_cb4e693c().m_fc7f45bc());
   }

   public void close() {
   }

   public double getChildrenHeight(int var1, List<C0163> var2) {
      if (var2 == null) {
         var2 = this.children;
      }

      boolean var3 = var2.get(0) instanceof ScrollbarWidget;
      double var4 = 0.0;

      for (int var6 = var3 ? 1 : 0; var6 <= var1 + (var3 ? 1 : 0) && var2.size() > var6; var6++) {
         var4 += ((C0163)var2.get(var6)).m_fd6ca281().m_fc7f45bc();
      }

      return var4;
   }

   public void center() {
      this.f_e873bee8
         .m_1e49f000(
            (double)((float)C0114.bootstrap<"call",0,1>() / C0114.bootstrap<"call",1,1>() / 2.0F) - this.f_e873bee8.m_830cb294() / 2.0,
            (double)((float)C0114.bootstrap<"call",2,1>() / C0114.bootstrap<"call",1,1>() / 2.0F) - this.f_e873bee8.m_fc7f45bc() / 2.0
         );
   }

   public void m_1a604be5() {
      this.children.forEach(C0163::m_6b155392);
   }

   public boolean m_0812cc67(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_c50ec0f2(var1, var3, var5, var6);
      this.drawBackground();
      if (this.stencil) {
         this.stencilBuffer.m_0396ff8d().m_315ef949(this.f_e873bee8).m_31bf50f2();
      } else if (this.scissor) {
         this.f_e873bee8.m_c58b2081(true);
         C0114.bootstrap<"call",1,1>(3089);
      }

      var6 = this.drawChildren(var1, var3, var5, var6 || !this.f_e873bee8.m_263d91ea(var1, var3));
      if (this.stencil) {
         this.stencilBuffer.m_e56713e3();
      } else if (this.scissor) {
         C0114.bootstrap<"call",2,1>(3089);
      }

      return var6;
   }

   public C0153 m_a421f996() {
      if (this.f_e873bee8.m_263d91ea(this.mouseX, this.mouseY)) {
         for (C0163 var2 : this.children) {
            if (var2.m_fd6ca281().m_263d91ea(this.mouseX, this.mouseY)) {
               return var2.m_bb20fb08();
            }
         }
      }

      return null;
   }

   public <T extends C0163> T getSpecificWidget(Class<T> var1) {
      for (C0163 var3 : this.children) {
         if (var3.getClass().isAssignableFrom(var1)) {
            return (T)var3;
         }
      }

      return null;
   }

   protected Color getBackgroundColor() {
      return this.f_32061256.m_dee103ad();
   }

   protected void drawBackground() {
      if (this.f_32061256 != null && this.renderBackground) {
         this.quadRenderStack.begin();
         this.drawOverlay();
         if (this.renderShadow) {
            this.f_e873bee8.m_40710a35((QuadRenderStack)this.quadRenderStack.glColor(this.f_32061256.m_dee103ad().darker(), 180.0F), this.shadowSize);
         }

         ((QuadRenderStack)this.quadRenderStack.glColor(this.getBackgroundColor()))
            .drawRect(
               this.f_e873bee8.m_14f8bc2c(),
               this.f_e873bee8.m_5a998971(),
               this.f_e873bee8.m_14f8bc2c() + this.f_e873bee8.m_830cb294(),
               this.f_e873bee8.m_5a998971() + this.f_e873bee8.m_fc7f45bc()
            )
            .end();
      }
   }

   protected void drawOverlay() {
   }

   protected boolean drawChildren(double var1, double var3, float var5, boolean var6) {
      for (C0163 var8 : this.children) {
         if (!this.shouldDrawChild(var8)) {
            var8.m_fd6ca281().m_1e49f000((double)C0114.bootstrap<"call",0,1>(), (double)C0114.bootstrap<"call",1,1>());
         } else {
            this.applyBoundsUpdates(var8);
            if (!(var8 instanceof ScrollbarWidget)) {
               if (var8 instanceof C0445) {
                  ((C0445)var8).m_67a0b4b8(this);
               }

               var6 = var8.m_2f338522(var1, var3, var5, var6);
            }
         }
      }

      return var6;
   }

   protected boolean shouldDrawChild(C0163 var1) {
      return true;
   }

   protected void applyBoundsUpdates(C0163 var1) {
      if (var1 instanceof C0445) {
         if (var1 instanceof C0442) {
            C0425[] var2 = ((C0442)var1).m_1e7caea3();
            if (var2 != null) {
               C0114.bootstrap<"call",0,1>(var2).forEach(var2x -> var2x.m_ed790320(var1, this));
            }
         }

         if (var1 instanceof C0444) {
            C0426[] var3 = ((C0444)var1).m_184b09a4();
            if (var3 != null) {
               C0114.bootstrap<"call",0,1>(var3).forEach(var2x -> var2x.m_365f77b3(var1, this));
            }
         }
      }
   }

   public int m_6b4f6f2e(double var1, double var3) {
      int var5 = super.m_ba20b599(var1, var3);
      if (var5 != -1) {
         return var5;
      } else {
         for (int var6 = this.children.size() - 1; var6 >= 0; var6--) {
            C0163 var7 = this.children.get(var6);
            if (var7 instanceof C0437) {
               int var8 = ((C0437)var7).m_5227a122(var1, var3);
               if (var8 != -1) {
                  var5 = var8;
               }
            }
         }

         if (var5 == -1 && this.f_e873bee8.m_263d91ea(var1, var3)) {
            var5 = 221185;
         }

         return var5;
      }
   }

   public void m_15d8ac14(double var1, double var3) {
      this.children.stream().filter(var1x -> var1x.m_fd6ca281().m_263d91ea(this.mouseX, this.mouseY)).forEach(var4 -> var4.m_9357ee29(var1, var3));
   }

   public boolean m_c8af97e4(double var1, double var3, int var5) {
      super.m_07141b75(var1, var3, var5);

      for (C0163 var7 : this.children) {
         if (var7.m_73c37f1a(var1, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   public boolean m_00a883b1(double var1, double var3, int var5) {
      boolean var6 = false;
      boolean var7 = this.f_e873bee8.m_504764e1(this.border).m_263d91ea(var1, var3);

      for (C0163 var9 : this.children) {
         if (var7 || var9 instanceof ScrollbarWidget) {
            if (var9 instanceof C0445) {
               ((C0445)var9).m_67a0b4b8(this);
            }

            if (var6 = var9.m_7e41b969(var1, var3, var5)) {
               break;
            }
         }
      }

      return var6 || super.m_0099f3c3(var1, var3, var5) || this.m_908f7f94().m_263d91ea(var1, var3);
   }

   public boolean m_480a8f0c(int var1, int var2, int var3) {
      for (C0163 var5 : this.children) {
         if (var5.m_fd40ceb2(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   public void m_5af6401b() {
      this.children.forEach(C0163::m_e103589e);
   }

   public void m_eaab259a(int var1) {
      this.children.stream().filter(var0 -> var0 instanceof C0438).map(var0 -> (C0438)var0).forEach(var1x -> var1x.m_1f87a876(var1));
   }

   public void setStencil(boolean var1) {
      this.stencil = var1;
   }

   public void setScissor(boolean var1) {
      this.scissor = var1;
   }

   public void setRenderBackground(boolean var1) {
      this.renderBackground = var1;
   }

   public void setRenderShadow(boolean var1) {
      this.renderShadow = var1;
   }

   public void setTitle(TitleWidget var1) {
      this.title = var1;
   }

   public void setShadowSize(double var1) {
      this.shadowSize = var1;
   }

   public QuadRenderStack getQuadRenderStack() {
      return this.quadRenderStack;
   }

   public List<C0163> m_243f7d75() {
      return this.children;
   }

   public boolean isStencil() {
      return this.stencil;
   }

   public boolean isScissor() {
      return this.scissor;
   }

   public boolean isRenderBackground() {
      return this.renderBackground;
   }

   public boolean isRenderShadow() {
      return this.renderShadow;
   }

   public C0232 getStencilBuffer() {
      return this.stencilBuffer;
   }

   public TitleWidget getTitle() {
      return this.title;
   }

   public double getShadowSize() {
      return this.shadowSize;
   }
}
