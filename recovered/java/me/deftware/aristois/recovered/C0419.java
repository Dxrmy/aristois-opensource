package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Objects;
import java.util.Optional;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CircleRenderStack;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.world.ClientWorld;

public class C0419 extends AbstractMod {
   private static final C0201 f_6b9321e4 = new C0201(C0259.m_c254a253());
   @C0098(
      value = "Range",
      description = {"The range to show entities within"},
      number = @C0096(
         min = 10.0,
         max = 70.0
      )
   )
   private int f_f19bf0f5 = 50;
   @C0098(
      value = "Scale",
      description = {"The scale of things on the radar"},
      number = @C0096(
         min = 1.0,
         max = 1.5
      )
   )
   private float f_7eb6b933 = 1.15F;
   @C0098(
      value = "Radius",
      description = {"The size of the radar"},
      number = @C0096(
         min = 30.0,
         max = 70.0
      )
   )
   private float f_d10274f1 = 50.0F;
   @C0098(
      value = "Delta Range",
      description = {"The delta range to calculate opacity from"},
      number = @C0096(
         min = 4.0,
         max = 20.0
      )
   )
   private double f_994143dd = 10.0;
   @C0098(
      value = "Players",
      description = {"Show players on the radar"}
   )
   private boolean f_32b90290 = true;
   @C0098(
      value = "Direction",
      description = {"Render directions on the radar"}
   )
   private C0102<C0419.anonymousconst> f_6c07e294 = new C0102<>(C0419.anonymousconst.f_58a8c824);
   @C0098(
      value = "Y-Lock",
      description = {"Only show entities on the Y level within the delta range"}
   )
   private boolean f_f4002798 = true;
   @C0098(
      value = "Render",
      description = {"Render all entities, or those selected"}
   )
   private C0102<C0419.anonymousclass> f_d45a45ab = new C0102<>(C0419.anonymousclass.f_2191fc6b);
   @C0098(
      value = "Offset",
      description = {"Offset from the corner"},
      number = @C0096(
         min = 0.0,
         max = 200.0
      )
   )
   private float f_19b011f3 = 0.0F;
   @C0098("Entities")
   private final GuiScreen f_57519198 = C0217.m_c1fb6c03(null, f_6b9321e4);
   private float f_b87da5f0 = 2.7F;
   private final LineRenderStack f_c0b888b9 = (LineRenderStack)new LineRenderStack().setScaled(false);
   private final CircleRenderStack f_61d13939 = (CircleRenderStack)new CircleRenderStack().setScaled(false);
   private final C0232 f_e1c7dfbd = new C0232(this.f_61d13939);

   public C0419() {
      super(C0259.m_45aaaba8(), C0290.f_43c13687, C0259.m_88937f2b());
   }

   @EventHandler
   public void m_84072c65(EventRender2D var1) {
      if (!C0289.m_c3a8b502(C0297.class).m_275ab222()) {
         Entity var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getCameraEntity());
         float var3 = 10.0F;
         float var4 = (float)GuiScreen.getScaledWidth() - this.f_d10274f1 - var3 - this.f_19b011f3;
         float var5 = (float)GuiScreen.getScaledHeight() - this.f_d10274f1 - var3 - this.f_19b011f3;
         RenderStack.setupGl();
         this.f_e1c7dfbd.m_3327f4f8();
         this.f_61d13939.drawFilledCircle(var4, var5, this.f_d10274f1);
         this.f_e1c7dfbd.m_80099ca4();
         this.f_61d13939.begin();
         ((CircleRenderStack)this.f_61d13939.glColor(Color.black, 150.0F)).drawFilledCircle(var4, var5, this.f_d10274f1).end();
         GlStateHelper.enableTexture2D();
         ClientWorld.getClientWorld()
            .getLoadedEntities()
            .filter(var2x -> this.m_080164a5(var2, var2x) < (double)this.f_f19bf0f5)
            .filter(var2x -> !this.f_f4002798 || Math.abs(var2x.getPosY() - var2.getPosY()) <= this.f_994143dd)
            .filter(var0 -> !var0.isSelf())
            .forEach(var4x -> this.m_41cd8c53(var4x, var2, (double)var2.getRotationYaw(), (double)var4, (double)var5));
         GlStateHelper.disableTexture2D();
         this.f_e1c7dfbd.m_0e265701();
         this.f_c0b888b9.begin().glColor(Color.white);
         this.f_c0b888b9.vertex((double)var4, (double)(var5 - this.f_d10274f1));
         this.f_c0b888b9.vertex((double)var4, (double)(var5 + this.f_d10274f1));
         this.f_c0b888b9.vertex((double)(var4 - this.f_d10274f1), (double)var5);
         this.f_c0b888b9.vertex((double)(var4 + this.f_d10274f1), (double)var5);
         this.f_c0b888b9.end();
         GlStateHelper.enableTexture2D();
         if (this.f_6c07e294.m_284992ec() == C0419.anonymousconst.f_cddb667d || this.f_6c07e294.m_284992ec() == C0419.anonymousconst.f_58a8c824) {
            this.m_b948fb3a(var2, (double)var4, (double)var5);
         }

         GlStateHelper.disableTexture2D();
         RenderStack.restoreGl();
      }
   }

   private void m_b948fb3a(Entity var1, double var2, double var4) {
      double var6 = Math.toRadians((double)var1.getRotationYaw());
      double var8 = 1.5707963267948966;
      double var10 = var8 / 2.0;
      this.m_cd880b0c(var6 + var8, C0259.m_396f9431(), var2, var4, 1.0F);
      this.m_cd880b0c(var6 - var8, C0261.m_ec4ef19a(), var2, var4, 1.0F);
      this.m_cd880b0c(var6 + var8 * 2.0, C0259.m_e9914bd3(), var2, var4, 1.0F);
      this.m_cd880b0c(var6, C0259.m_8631f87f(), var2, var4, 1.0F);
      if (this.f_6c07e294.m_284992ec() == C0419.anonymousconst.f_cddb667d) {
         float var12 = 0.65F;
         this.m_cd880b0c(var6 + var10, C0259.m_818e6498(), var2, var4, var12);
         this.m_cd880b0c(var6 + var8 * 2.0 - var10, C0259.m_56d4c1c7(), var2, var4, var12);
         this.m_cd880b0c(var6 + var8 * 2.0 + var10, C0259.m_d32ebe65(), var2, var4, var12);
         this.m_cd880b0c(var6 - var10, C0259.m_afb31f66(), var2, var4, var12);
      }
   }

   private double m_080164a5(Entity var1, Entity var2) {
      double var3 = var1.getPosX() - var2.getPosX();
      double var5 = var1.getPosZ() - var2.getPosZ();
      return Math.sqrt(var3 * var3 + var5 * var5);
   }

   private void m_cd880b0c(double var1, String var3, double var4, double var6, float var8) {
      GLX.INSTANCE.push();
      double var9 = (double)FontRenderer.getFontHeight() / 2.0;
      double var11 = (double)FontRenderer.getStringWidth(var3) / 2.0;
      double var13 = (double)this.f_d10274f1;
      double var15 = Math.cos(var1);
      double var17 = Math.sin(var1);
      var17 *= var13;
      var15 *= var13;
      GLX.INSTANCE.translate(var4 + var15, var6 + var17, 1.0);
      GLX.INSTANCE.scale(var8, var8, 1.0F);
      FontRenderer.drawStringWithShadow(Message.of(var3), (int)(-var11), (int)(-var9), 16777215);
      GLX.INSTANCE.pop();
   }

   public static double m_1e69e97a(double var0, double var2, double var4) {
      return Math.min(Math.max(var0, var4), var2);
   }

   private void m_41cd8c53(Entity var1, Entity var2, double var3, double var5, double var7) {
      double var9 = var2.getPosX() - var1.getPosX();
      double var11 = var2.getPosZ() - var1.getPosZ();
      double var13 = this.m_080164a5(var2, var1) / (double)this.f_f19bf0f5 * (double)this.f_d10274f1;
      double var15 = Math.toRadians(var3) - Math.atan2(var11, var9);
      var9 = var5 + Math.cos(var15) * var13;
      var11 = var7 - Math.sin(var15) * var13;
      double var17 = m_1e69e97a(
         0.2, 1.0, (m_1e69e97a(-this.f_994143dd, this.f_994143dd, var1.getPosY() - var2.getPosY()) + this.f_994143dd) / (this.f_994143dd * 2.0) + 0.2
      );
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, (float)var17);
      if (var1 instanceof EntityPlayer) {
         if (this.f_32b90290) {
            GLX.INSTANCE.push();
            GLX.INSTANCE.translate(var9, var11, 1.0);
            GLX.INSTANCE.scale(this.f_7eb6b933 / this.f_b87da5f0, this.f_7eb6b933 / this.f_b87da5f0, 1.0F);
            byte var19 = 24;
            C0225.m_6ea855ff(((EntityPlayer)var1).getUUID(), -(var19 / 2), -(var19 / 2), var19, var19);
            GLX.INSTANCE.pop();
         }
      } else {
         Optional var22 = C0227.f_51234e0c.m_34db4d3b(var1);
         if (var22.isPresent() && (f_6b9321e4.m_828a75ae(var1.getEntityTypeName()) || this.f_d45a45ab.m_284992ec() == C0419.anonymousclass.f_2191fc6b)) {
            ((C0225)var22.get()).m_4f0b4685((int)var9, (int)var11, this.f_7eb6b933);
         }
      }

      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static C0201 m_95db1db3() {
      return f_6b9321e4;
   }

   public static enum anonymousclass {
      f_2191fc6b,
      f_e18fd5bc;

      private anonymousclass() {
      }
   }

   public static enum anonymousconst {
      f_7bacd7b0,
      f_58a8c824,
      f_cddb667d;

      private anonymousconst() {
      }
   }
}
