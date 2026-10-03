package me.deftware.aristois.menu.widgets;

import java.awt.Color;
import me.deftware.aristois.recovered.C0165;
import me.deftware.aristois.recovered.C0441;
import me.deftware.aristois.recovered.C0445;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public abstract class ColorSelectionButton extends ButtonWidget implements C0445.anonymouscatch {
   public ColorSelectionButton(Message var1, C0441 var2) {
      super(var1, var2);
   }

   @Override
   protected void drawBackground(double var1, double var3, float var5) {
      super.drawBackground(var1, var3, var5);
      double var6 = this.f_02ea293d.m_036bd5c5();
      double var8 = this.f_7fd3d7b7.m_d42f3372() - var6 * 2.0;
      C0165 var10 = new C0165(this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29() - var8 - var6 - 5.0, this.f_7fd3d7b7.m_84808068() + var6, var8, var8);
      var10.m_4bc1a596((QuadRenderStack)this.quadRenderStack.glColor(this.getColor()));
      var10.m_d4bfedfc((QuadRenderStack)this.quadRenderStack.glColor(Color.gray, 120.0F), 2.0);
   }

   protected abstract Color getColor();
}
