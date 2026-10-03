package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.render.batching.LineRenderStack;

@C0421
public class C0323 extends AbstractMod {
   private final List<double[]> f_21c6e359 = new LinkedList<>();
   private double f_ad4527f9 = 0.0;
   private double f_b01ce564 = 0.0;
   private double f_4e9a6681 = 0.0;
   @C0098(
      value = "RGB mode",
      description = {"Render the breadcrumbs in RGB"}
   )
   public boolean f_690293cc = true;
   @C0098(
      value = "Color",
      description = {"Color of the trail"}
   )
   private Color f_b89b09f9 = Color.WHITE;
   @C0098(
      value = "Append",
      description = {"Appends crumbs to the trail when walking"}
   )
   private boolean f_1564c1b9 = true;
   private final LineRenderStack f_9b4cd66f = new LineRenderStack();

   public C0323() {
      super(C0252.bootstrap<"get",47244640336>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640337>());
   }

   @Override
   public void onEnable() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1 == null) {
         this.toggle();
      } else {
         this.f_ad4527f9 = var1.getPosX();
         this.f_b01ce564 = var1.getPosY();
         this.f_4e9a6681 = var1.getPosZ();
         this.f_21c6e359.clear();
         this.f_1564c1b9 = true;
      }
   }

   @EventHandler
   public void m_dc4389a4(EventRender3DNoBobbing var1) {
      C0114.bootstrap<"call",0,1>();
      ((LineRenderStack)this.f_9b4cd66f.glColor(this.f_690293cc ? C0045.f_d228694b.m_86ca0a09() : this.f_b89b09f9)).begin();

      for (double[] var3 : this.f_21c6e359) {
         double var4 = 1.5;
         double var6 = C0114.bootstrap<"call",1,1>().getCamera()._getRenderPosX() - var3[0];
         double var8 = C0114.bootstrap<"call",1,1>().getCamera()._getRenderPosY() - var3[1] - var4;
         double var10 = C0114.bootstrap<"call",1,1>().getCamera()._getRenderPosZ() - var3[2];
         double var12 = C0114.bootstrap<"call",1,1>().getCamera()._getRenderPosX() - var3[3];
         double var14 = C0114.bootstrap<"call",1,1>().getCamera()._getRenderPosY() - var3[4] - var4;
         double var16 = C0114.bootstrap<"call",1,1>().getCamera()._getRenderPosZ() - var3[5];
         this.f_9b4cd66f.drawPoint(-var6, -var8, -var10);
         this.f_9b4cd66f.drawPoint(-var12, -var14, -var16);
      }

      this.f_9b4cd66f.end();
      C0114.bootstrap<"call",2,1>();
   }

   @EventHandler
   public void m_0ffe2272(EventUpdate var1) {
      if (this.f_1564c1b9) {
         MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",1,1>()._getPlayer());
         if (this.f_ad4527f9 == var2.getPosX() && this.f_b01ce564 == var2.getPosY() && this.f_4e9a6681 == var2.getPosZ()) {
            return;
         }

         this.f_21c6e359
            .add(
               new double[]{
                  this.f_ad4527f9, this.f_b01ce564 - var2.getEyeHeight(), this.f_4e9a6681, var2.getPosX(), var2.getPosY() - var2.getEyeHeight(), var2.getPosZ()
               }
            );
         this.f_ad4527f9 = var2.getPosX();
         this.f_b01ce564 = var2.getPosY();
         this.f_4e9a6681 = var2.getPosZ();
      }
   }
}
