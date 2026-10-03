package me.deftware.aristois.menu.view.container;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import me.deftware.aristois.menu.view.list.ScrollbarWidget;
import me.deftware.aristois.menu.widgets.TitleWidget;
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
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import org.lwjgl.opengl.GL11;

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

   @Override
   public void m_cb54a800(C0163... var1) {
      this.children.addAll(Arrays.asList(var1));
   }

   @Override
   public void m_394ecb95(boolean var1) {
      this.quadRenderStack.setScaled(var1);
      this.title.m_394ecb95(var1);
   }

   public void addTitle(Message var1, final Consumer<Integer> var2) {
      this.title = new TitleWidget(var1, this.f_02ea293d) {
         @Override
         protected void onClick(int var1) {
            var2.accept(var1);
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
      this.title.m_ec141b95(new C0426[]{C0426.f_c285454f});
      this.m_cb54a800(this.title);
      this.title.setTextAlign(C0427.f_b1ff7fe9);
      this.setDraggableBorder(this.title.m_44bb072f().m_d42f3372());
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
         var4 += ((C0163)var2.get(var6)).m_44bb072f().m_d42f3372();
      }

      return var4;
   }

   public void center() {
      this.f_7fd3d7b7
         .m_f8b16cfb(
            (double)((float)GuiScreen.getDisplayWidth() / RenderStack.getScale() / 2.0F) - this.f_7fd3d7b7.m_4388ac29() / 2.0,
            (double)((float)GuiScreen.getDisplayHeight() / RenderStack.getScale() / 2.0F) - this.f_7fd3d7b7.m_d42f3372() / 2.0
         );
   }

   @Override
   public void m_1058ed9a() {
      this.children.forEach(C0163::m_1058ed9a);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_572d14e6(var1, var3, var5, var6);
      this.drawBackground();
      if (this.stencil) {
         this.stencilBuffer.m_3327f4f8().m_382cb6e3(this.f_7fd3d7b7).m_80099ca4();
      } else if (this.scissor) {
         this.f_7fd3d7b7.m_d6ac7420(true);
         GL11.glEnable(3089);
      }

      var6 = this.drawChildren(var1, var3, var5, var6 || !this.f_7fd3d7b7.m_a58797d6(var1, var3));
      if (this.stencil) {
         this.stencilBuffer.m_0e265701();
      } else if (this.scissor) {
         GL11.glDisable(3089);
      }

      return var6;
   }

   @Override
   public C0153 m_75885561() {
      if (this.f_7fd3d7b7.m_a58797d6(this.mouseX, this.mouseY)) {
         for (C0163 var2 : this.children) {
            if (var2.m_44bb072f().m_a58797d6(this.mouseX, this.mouseY)) {
               return var2.m_75885561();
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
      return this.f_02ea293d.m_d812cfb6();
   }

   protected void drawBackground() {
      if (this.f_02ea293d != null && this.renderBackground) {
         this.quadRenderStack.begin();
         this.drawOverlay();
         if (this.renderShadow) {
            this.f_7fd3d7b7.m_d4bfedfc((QuadRenderStack)this.quadRenderStack.glColor(this.f_02ea293d.m_d812cfb6().darker(), 180.0F), this.shadowSize);
         }

         ((QuadRenderStack)this.quadRenderStack.glColor(this.getBackgroundColor()))
            .drawRect(
               this.f_7fd3d7b7.m_a005efae(),
               this.f_7fd3d7b7.m_84808068(),
               this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29(),
               this.f_7fd3d7b7.m_84808068() + this.f_7fd3d7b7.m_d42f3372()
            )
            .end();
      }
   }

   protected void drawOverlay() {
   }

   protected boolean drawChildren(double var1, double var3, float var5, boolean var6) {
      for (C0163 var8 : this.children) {
         if (!this.shouldDrawChild(var8)) {
            var8.m_44bb072f().m_f8b16cfb((double)GuiScreen.getScaledWidth(), (double)GuiScreen.getDisplayHeight());
         } else {
            this.applyBoundsUpdates(var8);
            if (!(var8 instanceof ScrollbarWidget)) {
               if (var8 instanceof C0445) {
                  ((C0445)var8).m_facdcfcf(this);
               }

               var6 = var8.m_572d14e6(var1, var3, var5, var6);
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
            C0425[] var2 = ((C0442)var1).m_47e0d826();
            if (var2 != null) {
               Arrays.stream(var2).forEach(var2x -> var2x.m_28c3e3ec(var1, this));
            }
         }

         if (var1 instanceof C0444) {
            C0426[] var3 = ((C0444)var1).m_15a3a860();
            if (var3 != null) {
               Arrays.stream(var3).forEach(var2x -> var2x.m_28c3e3ec(var1, this));
            }
         }
      }
   }

   @Override
   public int m_3abf02d1(double var1, double var3) {
      int var5 = super.m_3abf02d1(var1, var3);
      if (var5 != -1) {
         return var5;
      } else {
         for (int var6 = this.children.size() - 1; var6 >= 0; var6--) {
            C0163 var7 = this.children.get(var6);
            if (var7 instanceof C0437) {
               int var8 = ((C0437)var7).m_3abf02d1(var1, var3);
               if (var8 != -1) {
                  var5 = var8;
               }
            }
         }

         if (var5 == -1 && this.f_7fd3d7b7.m_a58797d6(var1, var3)) {
            var5 = 221185;
         }

         return var5;
      }
   }

   @Override
   public void m_0eebc025(double var1, double var3) {
      this.children.stream().filter(var1x -> var1x.m_44bb072f().m_a58797d6(this.mouseX, this.mouseY)).forEach(var4 -> var4.m_0eebc025(var1, var3));
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      super.m_a2722fba(var1, var3, var5);

      for (C0163 var7 : this.children) {
         if (var7.m_a2722fba(var1, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      boolean var6 = false;
      boolean var7 = this.f_7fd3d7b7.m_5de46360(this.border).m_a58797d6(var1, var3);

      for (C0163 var9 : this.children) {
         if (var7 || var9 instanceof ScrollbarWidget) {
            if (var9 instanceof C0445) {
               ((C0445)var9).m_facdcfcf(this);
            }

            if (var6 = var9.m_8407b1bf(var1, var3, var5)) {
               break;
            }
         }
      }

      return var6 || super.m_8407b1bf(var1, var3, var5) || this.m_44bb072f().m_a58797d6(var1, var3);
   }

   @Override
   public boolean m_82e0832a(int var1, int var2, int var3) {
      for (C0163 var5 : this.children) {
         if (var5.m_82e0832a(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public void m_0e265701() {
      this.children.forEach(C0163::m_0e265701);
   }

   @Override
   public void m_7c7fe86a(int var1) {
      this.children.stream().filter(var0 -> var0 instanceof C0438).map(var0 -> (C0438)var0).forEach(var1x -> var1x.m_7c7fe86a(var1));
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

   @Override
   public List<C0163> m_98dc1191() {
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
