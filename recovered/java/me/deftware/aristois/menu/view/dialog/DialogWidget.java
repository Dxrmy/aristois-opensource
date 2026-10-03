package me.deftware.aristois.menu.view.dialog;

import java.awt.Color;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.recovered.C0114;
import me.deftware.aristois.recovered.C0441;
import me.deftware.aristois.recovered.C0446;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

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

   public void m_a926328b() {
      super.m_1a604be5();
      this.center();
   }

   public boolean m_83090461(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_0812cc67(var1, var3, var5, var6);
      return this.darkOverlay || var6;
   }

   @Override
   protected void drawOverlay() {
      if (this.darkOverlay) {
         ((QuadRenderStack)this.quadRenderStack.glColor(Color.black, 150.0F))
            .drawRect(
               0.0F,
               0.0F,
               (float)C0114.bootstrap<"call",0,1>() / C0114.bootstrap<"call",1,1>(),
               (float)C0114.bootstrap<"call",2,1>() / C0114.bootstrap<"call",1,1>()
            );
      }
   }

   public boolean m_8d413c51(double var1, double var3, int var5) {
      boolean var6 = super.m_00a883b1(var1, var3, var5);
      return this.darkOverlay || var6;
   }

   public boolean isOpen() {
      return this.parent != null ? this.parent.m_b63ca3f1().contains(this) : false;
   }

   public void open(C0446 var1) {
      this.parent = var1;
      if (!this.isOpen()) {
         this.m_a926328b();
         this.parent.m_b63ca3f1().add(this);
      }
   }

   @Override
   public void close() {
      if (this.isOpen() && this.parent != null) {
         this.parent.m_b63ca3f1().remove(this);
      }
   }

   public boolean isDarkOverlay() {
      return this.darkOverlay;
   }

   public void setDarkOverlay(boolean var1) {
      this.darkOverlay = var1;
   }
}
