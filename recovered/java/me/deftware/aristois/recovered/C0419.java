package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Optional;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.render.batching.CircleRenderStack;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.gl.GLX;

public class C0419 extends AbstractMod {
   private static final C0201 f_f55037b1 = new C0201(C0252.bootstrap<"get",42949673000>());
   @C0098(
      value = "Range",
      description = {"The range to show entities within"},
      number = @C0096(
         min = 10.0,
         max = 70.0
      )
   )
   private int f_141064ef = 50;
   @C0098(
      value = "Scale",
      description = {"The scale of things on the radar"},
      number = @C0096(
         min = 1.0,
         max = 1.5
      )
   )
   private float f_ab676652 = 1.15F;
   @C0098(
      value = "Radius",
      description = {"The size of the radar"},
      number = @C0096(
         min = 30.0,
         max = 70.0
      )
   )
   private float f_86bbef36 = 50.0F;
   @C0098(
      value = "Delta Range",
      description = {"The delta range to calculate opacity from"},
      number = @C0096(
         min = 4.0,
         max = 20.0
      )
   )
   private double f_119f465a = 10.0;
   @C0098(
      value = "Players",
      description = {"Show players on the radar"}
   )
   private boolean f_0e20366b = true;
   @C0098(
      value = "Direction",
      description = {"Render directions on the radar"}
   )
   private C0102<C0419.anonymousconst> f_4ab0a460 = new C0102<>(C0419.anonymousconst.f_7f948daa);
   @C0098(
      value = "Y-Lock",
      description = {"Only show entities on the Y level within the delta range"}
   )
   private boolean f_ba98e688 = true;
   @C0098(
      value = "Render",
      description = {"Render all entities, or those selected"}
   )
   private C0102<C0419.anonymousclass> f_e79f48b7 = new C0102<>(C0419.anonymousclass.f_fe309689);
   @C0098(
      value = "Offset",
      description = {"Offset from the corner"},
      number = @C0096(
         min = 0.0,
         max = 200.0
      )
   )
   private float f_810a7585 = 0.0F;
   @C0098("Entities")
   private final GuiScreen f_2079a9dd = C0114.bootstrap<"call",0,1>(null, f_f55037b1);
   private float f_613b9843 = 2.7F;
   private final LineRenderStack f_d8ee580d = (LineRenderStack)new LineRenderStack().setScaled(false);
   private final CircleRenderStack f_87992645 = (CircleRenderStack)new CircleRenderStack().setScaled(false);
   private final C0232 f_bf2d0282 = new C0232(this.f_87992645);

   public C0419() {
      super(C0252.bootstrap<"get",42949672991>(), C0290.f_4792a25c, C0252.bootstrap<"get",42949672992>());
   }

   @EventHandler
   public void m_ac6ea70e(EventRender2D var1) {
      if (!((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_7458b21f()) {
         Entity var2 = (Entity)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()._getCameraEntity());
         float var3 = 10.0F;
         float var4 = (float)C0114.bootstrap<"call",3,1>() - this.f_86bbef36 - var3 - this.f_810a7585;
         float var5 = (float)C0114.bootstrap<"call",4,1>() - this.f_86bbef36 - var3 - this.f_810a7585;
         C0114.bootstrap<"call",5,1>();
         this.f_bf2d0282.m_0396ff8d();
         this.f_87992645.drawFilledCircle(var4, var5, this.f_86bbef36);
         this.f_bf2d0282.m_31bf50f2();
         this.f_87992645.begin();
         ((CircleRenderStack)this.f_87992645.glColor(Color.black, 150.0F)).drawFilledCircle(var4, var5, this.f_86bbef36).end();
         C0114.bootstrap<"call",6,1>();
         C0114.bootstrap<"call",7,1>()
            .getLoadedEntities()
            .filter(var2x -> this.m_5ced4fb0(var2, var2x) < (double)this.f_141064ef)
            .filter(var2x -> !this.f_ba98e688 || C0114.bootstrap<"call",0,1>(var2x.getPosY() - var2.getPosY()) <= this.f_119f465a)
            .filter(var0 -> !var0.isSelf())
            .forEach(var4x -> this.m_b29bebfc(var4x, var2, (double)var2.getRotationYaw(), (double)var4, (double)var5));
         C0114.bootstrap<"call",8,1>();
         this.f_bf2d0282.m_e56713e3();
         this.f_d8ee580d.begin().glColor(Color.white);
         this.f_d8ee580d.vertex((double)var4, (double)(var5 - this.f_86bbef36));
         this.f_d8ee580d.vertex((double)var4, (double)(var5 + this.f_86bbef36));
         this.f_d8ee580d.vertex((double)(var4 - this.f_86bbef36), (double)var5);
         this.f_d8ee580d.vertex((double)(var4 + this.f_86bbef36), (double)var5);
         this.f_d8ee580d.end();
         C0114.bootstrap<"call",6,1>();
         if (this.f_4ab0a460.m_e2691446() == C0419.anonymousconst.f_0139a7f3 || this.f_4ab0a460.m_e2691446() == C0419.anonymousconst.f_7f948daa) {
            this.m_6a62c5d2(var2, (double)var4, (double)var5);
         }

         C0114.bootstrap<"call",8,1>();
         C0114.bootstrap<"call",9,1>();
      }
   }

   private void m_6a62c5d2(Entity var1, double var2, double var4) {
      double var6 = C0114.bootstrap<"call",10,1>((double)var1.getRotationYaw());
      double var8 = 1.5707963267948966;
      double var10 = var8 / 2.0;
      this.m_4cb22134(var6 + var8, C0252.bootstrap<"get",42949672993>(), var2, var4, 1.0F);
      this.m_4cb22134(var6 - var8, C0252.bootstrap<"get",17179869308>(), var2, var4, 1.0F);
      this.m_4cb22134(var6 + var8 * 2.0, C0252.bootstrap<"get",42949672994>(), var2, var4, 1.0F);
      this.m_4cb22134(var6, C0252.bootstrap<"get",42949672995>(), var2, var4, 1.0F);
      if (this.f_4ab0a460.m_e2691446() == C0419.anonymousconst.f_0139a7f3) {
         float var12 = 0.65F;
         this.m_4cb22134(var6 + var10, C0252.bootstrap<"get",42949672996>(), var2, var4, var12);
         this.m_4cb22134(var6 + var8 * 2.0 - var10, C0252.bootstrap<"get",42949672997>(), var2, var4, var12);
         this.m_4cb22134(var6 + var8 * 2.0 + var10, C0252.bootstrap<"get",42949672998>(), var2, var4, var12);
         this.m_4cb22134(var6 - var10, C0252.bootstrap<"get",42949672999>(), var2, var4, var12);
      }
   }

   private double m_5ced4fb0(Entity var1, Entity var2) {
      double var3 = var1.getPosX() - var2.getPosX();
      double var5 = var1.getPosZ() - var2.getPosZ();
      return C0114.bootstrap<"call",11,1>(var3 * var3 + var5 * var5);
   }

   private void m_4cb22134(double var1, String var3, double var4, double var6, float var8) {
      GLX.INSTANCE.push();
      double var9 = (double)C0114.bootstrap<"call",12,1>() / 2.0;
      double var11 = (double)C0114.bootstrap<"call",13,1>(var3) / 2.0;
      double var13 = (double)this.f_86bbef36;
      double var15 = C0114.bootstrap<"call",14,1>(var1);
      double var17 = C0114.bootstrap<"call",15,1>(var1);
      var17 *= var13;
      var15 *= var13;
      GLX.INSTANCE.translate(var4 + var15, var6 + var17, 1.0);
      GLX.INSTANCE.scale(var8, var8, 1.0F);
      C0114.bootstrap<"call",17,1>(C0114.bootstrap<"call",16,1>(var3), (int)(-var11), (int)(-var9), 16777215);
      GLX.INSTANCE.pop();
   }

   public static double m_ef075858(double var0, double var2, double var4) {
      return C0114.bootstrap<"call",19,1>(C0114.bootstrap<"call",18,1>(var0, var4), var2);
   }

   private void m_b29bebfc(Entity var1, Entity var2, double var3, double var5, double var7) {
      double var9 = var2.getPosX() - var1.getPosX();
      double var11 = var2.getPosZ() - var1.getPosZ();
      double var13 = this.m_5ced4fb0(var2, var1) / (double)this.f_141064ef * (double)this.f_86bbef36;
      double var15 = C0114.bootstrap<"call",10,1>(var3) - C0114.bootstrap<"call",20,1>(var11, var9);
      var9 = var5 + C0114.bootstrap<"call",14,1>(var15) * var13;
      var11 = var7 - C0114.bootstrap<"call",15,1>(var15) * var13;
      double var17 = C0114.bootstrap<"call",21,1>(
         0.2,
         1.0,
         (C0114.bootstrap<"call",21,1>(-this.f_119f465a, this.f_119f465a, var1.getPosY() - var2.getPosY()) + this.f_119f465a) / (this.f_119f465a * 2.0) + 0.2
      );
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, (float)var17);
      if (var1 instanceof EntityPlayer) {
         if (this.f_0e20366b) {
            GLX.INSTANCE.push();
            GLX.INSTANCE.translate(var9, var11, 1.0);
            GLX.INSTANCE.scale(this.f_ab676652 / this.f_613b9843, this.f_ab676652 / this.f_613b9843, 1.0F);
            byte var19 = 24;
            C0114.bootstrap<"call",22,1>(((EntityPlayer)var1).getUUID(), -(var19 / 2), -(var19 / 2), var19, var19);
            GLX.INSTANCE.pop();
         }
      } else {
         Optional var22 = C0227.f_8791eb78.m_6e45aa74(var1);
         if (var22.isPresent() && (f_f55037b1.m_cf9d272b(var1.getEntityTypeName()) || this.f_e79f48b7.m_e2691446() == C0419.anonymousclass.f_fe309689)) {
            ((C0225)var22.get()).m_c6b9da21((int)var9, (int)var11, this.f_ab676652);
         }
      }

      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static C0201 m_f3c5fe29() {
      return f_f55037b1;
   }

   public static enum anonymousclass {
      f_fe309689,
      f_c89c04a5;

      private anonymousclass() {
      }
   }

   public static enum anonymousconst {
      f_dd8ee029,
      f_7f948daa,
      f_0139a7f3;

      private anonymousconst() {
      }
   }
}
