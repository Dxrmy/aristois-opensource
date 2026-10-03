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
      double var6 = this.f_544fe4da.m_b419df18();
      double var8 = this.f_96c08c03.m_fc7f45bc() - var6 * 2.0;
      C0165 var10 = new C0165(this.f_96c08c03.m_14f8bc2c() + this.f_96c08c03.m_830cb294() - var8 - var6 - 5.0, this.f_96c08c03.m_5a998971() + var6, var8, var8);
      var10.m_79e11f68((QuadRenderStack)this.quadRenderStack.glColor(this.getColor()));
      var10.m_40710a35((QuadRenderStack)this.quadRenderStack.glColor(Color.gray, 120.0F), 2.0);
   }

   protected abstract Color getColor();
}
