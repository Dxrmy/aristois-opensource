package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.EnumSet;
import me.deftware.client.framework.render.batching.RenderStack;

public class C0220 extends RenderStack<C0220> {
   private static final double f_a309b93b = 1.5707963267948966;
   private static final double f_ed77ff6d = 1.5707963267948966;
   private static final double f_b92e26b7 = 6.0;
   private static final int f_a0c06e2a = 30;
   private final EnumSet<C0220.anonymousthis> f_6019a96c = EnumSet.allOf(C0220.anonymousthis.class);

   public C0220() {
   }

   public C0220 m_b7d79023() {
      return (C0220)this.begin(5);
   }

   public C0220 m_8dd06694(C0220.anonymousthis... var1) {
      Arrays.asList(var1).forEach(this.f_6019a96c::remove);
      return this;
   }

   public C0220 m_6e5d2edb(C0220.anonymousthis... var1) {
      this.f_6019a96c.addAll(Arrays.asList(var1));
      return this;
   }

   public C0220 m_b2eadcbd(double var1, double var3, double var5, double var7) {
      return this.m_65dee9a3(var1, var3, var5, var7, 6.0);
   }

   public C0220 m_d1f62d31(double var1, double var3, double var5, double var7) {
      return this.m_8905fac3(var1, var3, var5, var7, 6.0);
   }

   public C0220 m_65dee9a3(double var1, double var3, double var5, double var7, double var9) {
      this.vertex(var5 - var9, var7 - var9, 1.0).next();
      this.m_7ceb6c25(var1, var3, var5, var7, var9, true);
      this.vertex(var1 + var9, var3 + var9, 1.0).next();
      this.vertex(var5, var7 - var9, 1.0).next();
      this.vertex(var1 + var9, var7 - var9, 1.0).next();
      this.vertex(var1 + var9, var3 + var9, 1.0).next();
      return this;
   }

   public C0220 m_8905fac3(double var1, double var3, double var5, double var7, double var9) {
      this.m_7ceb6c25(var1, var3, var5, var7, var9, false);
      return this;
   }

   private void m_7ceb6c25(double var1, double var3, double var5, double var7, double var9, boolean var11) {
      if (this.f_6019a96c.contains(C0220.anonymousthis.f_f29579b5)) {
         this.m_ce1c5d95(var5 - var9, var7 - var9, var9, 0.0, 1.5707963267948966, var11);
      } else {
         if (var11) {
            this.vertex(var5, var7 - var9, 1.0).next();
         }

         this.vertex(var5, var7, 1.0).next();
      }

      if (this.f_6019a96c.contains(C0220.anonymousthis.f_bfda36ed)) {
         this.m_ce1c5d95(var1 + var9, var7 - var9, var9, 1.5707963267948966, 1.5707963267948966, var11);
      } else {
         if (var11) {
            this.vertex(var1 + var9, var7 - var9, 1.0).next();
         }

         this.vertex(var1, var7, 1.0).next();
      }

      if (this.f_6019a96c.contains(C0220.anonymousthis.f_ea59afdd)) {
         this.m_ce1c5d95(var1 + var9, var3 + var9, var9, 3.141592653589793, 1.5707963267948966, var11);
      } else {
         if (var11) {
            this.vertex(var1 + var9, var3 + var9, 1.0).next();
         }

         this.vertex(var1, var3, 1.0).next();
      }

      if (this.f_6019a96c.contains(C0220.anonymousthis.f_3f0782ff)) {
         this.m_ce1c5d95(var5 - var9, var3 + var9, var9, 4.71238898038469, 1.5707963267948966, var11);
      } else {
         if (var11) {
            this.vertex(var5 - var9, var3 + var9, 1.0).next();
         }

         this.vertex(var5, var3, 1.0).next();
      }
   }

   private void m_ce1c5d95(double var1, double var3, double var5, double var7, double var9, boolean var11) {
      for (int var12 = 0; var12 < 30; var12++) {
         double var13 = var9 * (double)var12 / 30.0 + var7;
         double var15 = var5 * Math.cos(var13);
         double var17 = var5 * Math.sin(var13);
         if (var11) {
            this.vertex(var1, var3, 1.0).next();
         }

         this.vertex(var1 + var15, var3 + var17, 1.0).next();
      }
   }

   public EnumSet<C0220.anonymousthis> m_0bfa612f() {
      return this.f_6019a96c;
   }

   public static enum anonymousthis {
      f_ea59afdd,
      f_3f0782ff,
      f_bfda36ed,
      f_f29579b5;

      private anonymousthis() {
      }
   }
}
