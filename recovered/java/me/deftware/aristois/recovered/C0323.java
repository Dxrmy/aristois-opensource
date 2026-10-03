package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;

@C0421
public class C0323 extends AbstractMod {
   private final List<double[]> f_38871c6d = new LinkedList<>();
   private double f_c41e1bbe = 0.0;
   private double f_6c465479 = 0.0;
   private double f_dbc253c7 = 0.0;
   @C0098(
      value = "RGB mode",
      description = {"Render the breadcrumbs in RGB"}
   )
   public boolean f_4a5c2e66 = true;
   @C0098(
      value = "Color",
      description = {"Color of the trail"}
   )
   private Color f_9fc22b63 = Color.WHITE;
   @C0098(
      value = "Append",
      description = {"Appends crumbs to the trail when walking"}
   )
   private boolean f_e2c13894 = true;
   private final LineRenderStack f_372d5073 = new LineRenderStack();

   public C0323() {
      super(C0260.m_d0e43f69(), C0290.f_3210deb7, C0260.m_812ab029());
   }

   @Override
   public void onEnable() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1 == null) {
         this.toggle();
      } else {
         this.f_c41e1bbe = var1.getPosX();
         this.f_6c465479 = var1.getPosY();
         this.f_dbc253c7 = var1.getPosZ();
         this.f_38871c6d.clear();
         this.f_e2c13894 = true;
      }
   }

   @EventHandler
   public void m_4f06bdb8(EventRender3DNoBobbing var1) {
      RenderStack.setupGl();
      ((LineRenderStack)this.f_372d5073.glColor(this.f_4a5c2e66 ? C0045.f_8f480fc4.m_f6c8a26c() : this.f_9fc22b63)).begin();

      for (double[] var3 : this.f_38871c6d) {
         double var4 = 1.5;
         double var6 = Minecraft.getMinecraftGame().getCamera()._getRenderPosX() - var3[0];
         double var8 = Minecraft.getMinecraftGame().getCamera()._getRenderPosY() - var3[1] - var4;
         double var10 = Minecraft.getMinecraftGame().getCamera()._getRenderPosZ() - var3[2];
         double var12 = Minecraft.getMinecraftGame().getCamera()._getRenderPosX() - var3[3];
         double var14 = Minecraft.getMinecraftGame().getCamera()._getRenderPosY() - var3[4] - var4;
         double var16 = Minecraft.getMinecraftGame().getCamera()._getRenderPosZ() - var3[5];
         this.f_372d5073.drawPoint(-var6, -var8, -var10);
         this.f_372d5073.drawPoint(-var12, -var14, -var16);
      }

      this.f_372d5073.end();
      RenderStack.restoreGl();
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (this.f_e2c13894) {
         MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
         if (this.f_c41e1bbe == var2.getPosX() && this.f_6c465479 == var2.getPosY() && this.f_dbc253c7 == var2.getPosZ()) {
            return;
         }

         this.f_38871c6d
            .add(
               new double[]{
                  this.f_c41e1bbe, this.f_6c465479 - var2.getEyeHeight(), this.f_dbc253c7, var2.getPosX(), var2.getPosY() - var2.getEyeHeight(), var2.getPosZ()
               }
            );
         this.f_c41e1bbe = var2.getPosX();
         this.f_6c465479 = var2.getPosY();
         this.f_dbc253c7 = var2.getPosZ();
      }
   }
}
