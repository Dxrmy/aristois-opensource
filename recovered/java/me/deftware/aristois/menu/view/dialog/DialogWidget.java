package me.deftware.aristois.menu.view.dialog;

import java.awt.Color;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.recovered.C0441;
import me.deftware.aristois.recovered.C0446;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;

public class DialogWidget extends ContainerWidget {
   private C0446 parent;
   protected boolean darkOverlay = true;

   public DialogWidget(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.setDraggable(true);
      this.setRenderShadow(true);
   }

   public DialogWidget setupComponents(Message var1) {
      this.addTitle(var1, var0 -> {
      });
      this.title.setDrawExitButton(true);
      this.title.setDrawArrowButton(false);
      return this;
   }

   @Override
   public void m_1058ed9a() {
      super.m_1058ed9a();
      this.center();
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_572d14e6(var1, var3, var5, var6);
      return this.darkOverlay || var6;
   }

   @Override
   protected void drawOverlay() {
      if (this.darkOverlay) {
         ((QuadRenderStack)this.quadRenderStack.glColor(Color.black, 150.0F))
            .drawRect(0.0F, 0.0F, (float)GuiScreen.getDisplayWidth() / RenderStack.getScale(), (float)GuiScreen.getDisplayHeight() / RenderStack.getScale());
      }
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      boolean var6 = super.m_8407b1bf(var1, var3, var5);
      return this.darkOverlay || var6;
   }

   public boolean isOpen() {
      return this.parent != null ? this.parent.m_ed46fa58().contains(this) : false;
   }

   public void open(C0446 var1) {
      this.parent = var1;
      if (!this.isOpen()) {
         this.m_1058ed9a();
         this.parent.m_ed46fa58().add(this);
      }
   }

   @Override
   public void close() {
      if (this.isOpen() && this.parent != null) {
         this.parent.m_ed46fa58().remove(this);
      }
   }

   public boolean isDarkOverlay() {
      return this.darkOverlay;
   }

   public void setDarkOverlay(boolean var1) {
      this.darkOverlay = var1;
   }
}
