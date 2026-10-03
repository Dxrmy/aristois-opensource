package me.deftware.aristois.recovered;

import java.util.EnumSet;
import me.deftware.client.framework.render.batching.RenderStack;

public class C0220 extends RenderStack<C0220> {
   private static final double f_7b767a8c = 1.5707963267948966;
   private static final double f_429e402b = 1.5707963267948966;
   private static final double f_ff5232a2 = 6.0;
   private static final int f_a0cc87e9 = 30;
   private final EnumSet<C0220.anonymousthis> f_344abb99 = C0114.bootstrap<"call",0,1>(C0220.anonymousthis.class);

   public C0220() {
   }

   public C0220 m_d4c00e1d() {
      return (C0220)this.begin(5);
   }

   public C0220 m_34787be2(C0220.anonymousthis... var1) {
      C0114.bootstrap<"call",0,1>(var1).forEach(this.f_344abb99::remove);
      return this;
   }

   public C0220 m_f4ceecc4(C0220.anonymousthis... var1) {
      this.f_344abb99.addAll(C0114.bootstrap<"call",0,1>(var1));
      return this;
   }

   public C0220 m_16a8d022(double var1, double var3, double var5, double var7) {
      return this.m_1105634c(var1, var3, var5, var7, 6.0);
   }

   public C0220 m_356241e7(double var1, double var3, double var5, double var7) {
      return this.m_d0344986(var1, var3, var5, var7, 6.0);
   }

   public C0220 m_1105634c(double var1, double var3, double var5, double var7, double var9) {
      this.vertex(var5 - var9, var7 - var9, 1.0).next();
      this.m_492bef45(var1, var3, var5, var7, var9, true);
      this.vertex(var1 + var9, var3 + var9, 1.0).next();
      this.vertex(var5, var7 - var9, 1.0).next();
      this.vertex(var1 + var9, var7 - var9, 1.0).next();
      this.vertex(var1 + var9, var3 + var9, 1.0).next();
      return this;
   }

   public C0220 m_d0344986(double var1, double var3, double var5, double var7, double var9) {
      this.m_492bef45(var1, var3, var5, var7, var9, false);
      return this;
   }

   private void m_492bef45(double var1, double var3, double var5, double var7, double var9, boolean var11) {
      if (this.f_344abb99.contains(C0220.anonymousthis.f_bec92f99)) {
         this.m_45641994(var5 - var9, var7 - var9, var9, 0.0, 1.5707963267948966, var11);
      } else {
         if (var11) {
            this.vertex(var5, var7 - var9, 1.0).next();
         }

         this.vertex(var5, var7, 1.0).next();
      }

      if (this.f_344abb99.contains(C0220.anonymousthis.f_59b1a078)) {
         this.m_45641994(var1 + var9, var7 - var9, var9, 1.5707963267948966, 1.5707963267948966, var11);
      } else {
         if (var11) {
            this.vertex(var1 + var9, var7 - var9, 1.0).next();
         }

         this.vertex(var1, var7, 1.0).next();
      }

      if (this.f_344abb99.contains(C0220.anonymousthis.f_ec68d360)) {
         this.m_45641994(var1 + var9, var3 + var9, var9, 3.141592653589793, 1.5707963267948966, var11);
      } else {
         if (var11) {
            this.vertex(var1 + var9, var3 + var9, 1.0).next();
         }

         this.vertex(var1, var3, 1.0).next();
      }

      if (this.f_344abb99.contains(C0220.anonymousthis.f_b48e8b17)) {
         this.m_45641994(var5 - var9, var3 + var9, var9, 4.71238898038469, 1.5707963267948966, var11);
      } else {
         if (var11) {
            this.vertex(var5 - var9, var3 + var9, 1.0).next();
         }

         this.vertex(var5, var3, 1.0).next();
      }
   }

   private void m_45641994(double var1, double var3, double var5, double var7, double var9, boolean var11) {
      for (int var12 = 0; var12 < 30; var12++) {
         double var13 = var9 * (double)var12 / 30.0 + var7;
         double var15 = var5 * C0114.bootstrap<"call",1,1>(var13);
         double var17 = var5 * C0114.bootstrap<"call",2,1>(var13);
         if (var11) {
            this.vertex(var1, var3, 1.0).next();
         }

         this.vertex(var1 + var15, var3 + var17, 1.0).next();
      }
   }

   public EnumSet<C0220.anonymousthis> m_c27f0b1b() {
      return this.f_344abb99;
   }

   public static enum anonymousthis {
      f_ec68d360,
      f_b48e8b17,
      f_59b1a078,
      f_bec92f99;

      private anonymousthis() {
      }
   }
}
