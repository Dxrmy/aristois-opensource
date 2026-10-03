package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.render.batching.CircleRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.util.types.Pair;

public abstract class C0436 implements C0163 {
   private final C0228.anonymouscatch<C0436> f_d32f89e6;
   private final C0228.anonymouscatch<C0436> f_bb9e1487;
   private final C0228.anonymouscatch<C0436> f_c4237003;
   private final double f_60ccd867;
   private final C0165 f_23ed6fa7;
   private final C0165 f_5d46089b;
   private final C0165 f_d6e4ab59;
   private final C0165 f_d6841adb;
   private Pair<C0228.anonymouscatch<C0436>, C0165> f_2ac4c28d;
   public int f_fdb582bf = 255;
   public final float[] f_1b6ae1d0 = new float[3];
   private boolean f_3e9145e0 = false;
   private double f_6ffcac53;
   private double f_513b1582;
   private final QuadRenderStack f_95780059 = new QuadRenderStack();
   private final CircleRenderStack f_c6f34120 = new CircleRenderStack();
   private boolean f_1de9a7e2 = true;
   private boolean f_d6708eb5 = false;

   public <T extends C0228.anonymouscatch<C0436>> C0436(double var1, double var3, double var5, double var7, Color var9, T var10, T var11, T var12) {
      this.f_60ccd867 = var7 * 0.15;
      this.f_23ed6fa7 = new C0165(var1, var3, var5, var7);
      this.f_5d46089b = new C0165(0.0, 0.0, var5 - this.f_60ccd867, var7 - this.f_60ccd867).m_8d8487f4(this.f_23ed6fa7);
      this.f_d6e4ab59 = new C0165(0.0, this.f_5d46089b.m_d42f3372(), this.f_5d46089b.m_4388ac29(), this.f_60ccd867).m_8d8487f4(this.f_23ed6fa7);
      this.f_d6841adb = new C0165(this.f_5d46089b.m_4388ac29(), 0.0, this.f_60ccd867, var7).m_8d8487f4(this.f_23ed6fa7);
      this.f_d32f89e6 = var10;
      this.f_bb9e1487 = var11;
      this.f_c4237003 = var12;
      this.m_6e0baed2(var9);
   }

   public C0436 m_006ec697(boolean var1) {
      this.f_1de9a7e2 = var1;
      this.f_95780059.setScaled(var1);
      this.f_c6f34120.setScaled(var1);
      return this;
   }

   public void m_b728afce() {
      this.f_d32f89e6.m_009d0825((var1x, var2, var3, var4, var5) -> new Color(Color.HSBtoRGB(this.f_1b6ae1d0[0], var2 / var4, var3 / var5)));
      int var1 = Color.HSBtoRGB(this.f_1b6ae1d0[0], this.f_1b6ae1d0[1], this.f_1b6ae1d0[2]);
      this.f_c4237003.m_009d0825((var1x, var2, var3, var4, var5) -> {
         double var6 = Math.max((double)(var3 / var5), 0.13);
         int var8 = (int)(255.0 * var6);
         return new Color(var1 & 16777215 | var8 << 24, true);
      });
      if (!this.f_3e9145e0) {
         this.f_bb9e1487.m_009d0825((var0, var1x, var2, var3, var4) -> new Color(Color.HSBtoRGB(var1x / var3, 1.0F, 1.0F)));
      }
   }

   public void m_6e0baed2(Color var1) {
      this.f_fdb582bf = var1.getAlpha();
      Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), this.f_1b6ae1d0);
   }

   public Color m_ac758c94() {
      int var1 = Color.HSBtoRGB(this.f_1b6ae1d0[0], this.f_1b6ae1d0[1], this.f_1b6ae1d0[2]);
      return new Color(var1 & 16777215 | this.f_fdb582bf << 24, true);
   }

   public void m_394ecb95(boolean var1) {
      this.m_e4529f30(this.m_ac758c94(), var1);
   }

   @Override
   public boolean m_8407b1bf(double var1, double var3, int var5) {
      if (this.f_d6708eb5 = this.f_23ed6fa7.m_a58797d6(var1, var3)) {
         if (this.f_5d46089b.m_a58797d6(var1, var3)) {
            this.f_2ac4c28d = new Pair(this.f_d32f89e6, this.f_5d46089b);
         } else if (this.f_d6e4ab59.m_a58797d6(var1, var3)) {
            this.f_2ac4c28d = new Pair(this.f_bb9e1487, this.f_d6e4ab59);
         } else if (this.f_d6841adb.m_a58797d6(var1, var3)) {
            this.f_2ac4c28d = new Pair(this.f_c4237003, this.f_d6841adb);
         }
      }

      return this.f_d6708eb5;
   }

   @Override
   public boolean m_a2722fba(double var1, double var3, int var5) {
      this.f_2ac4c28d = null;
      this.m_394ecb95(false);
      return this.f_d6708eb5 = false;
   }

   private void m_a172f6fe(double var1, double var3) {
      C0165 var5 = (C0165)this.f_2ac4c28d.getRight();
      double var6 = (var5.m_d945de47(var1) - var5.m_a005efae()) / var5.m_4388ac29();
      double var8 = (var5.m_461db524(var3) - var5.m_84808068()) / var5.m_d42f3372();
      ((C0228.anonymouscatch)this.f_2ac4c28d.getLeft()).m_09d6907b(this, var6, var8);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      if (!this.f_3e9145e0) {
         this.m_b728afce();
         this.f_3e9145e0 = true;
      }

      if (this.f_d6708eb5 && (this.f_6ffcac53 != var1 || this.f_513b1582 != var3)) {
         this.f_6ffcac53 = var1;
         this.f_513b1582 = var3;
         this.m_a172f6fe(var1, var3);
      }

      double var7 = 1.0;
      if (this.f_1de9a7e2) {
         var7 = (double)RenderStack.getScale();
      }

      RenderStack.blend();
      GlStateHelper.enableTexture2D();
      this.f_d32f89e6
         .bind()
         .draw(
            (int)(this.f_5d46089b.m_a005efae() * var7),
            (int)(this.f_5d46089b.m_84808068() * var7),
            (int)(this.f_5d46089b.m_4388ac29() * var7),
            (int)(this.f_5d46089b.m_d42f3372() * var7)
         )
         .unbind();
      this.f_bb9e1487
         .bind()
         .draw(
            (int)(this.f_d6e4ab59.m_a005efae() * var7),
            (int)(this.f_d6e4ab59.m_84808068() * var7),
            (int)(this.f_d6e4ab59.m_4388ac29() * var7),
            (int)(this.f_d6e4ab59.m_d42f3372() * var7)
         )
         .unbind();
      this.f_c4237003
         .bind()
         .draw(
            (int)(this.f_d6841adb.m_a005efae() * var7),
            (int)(this.f_d6841adb.m_84808068() * var7),
            (int)(this.f_d6841adb.m_4388ac29() * var7),
            (int)(this.f_d6841adb.m_d42f3372() * var7)
         )
         .unbind();
      GlStateHelper.disableTexture2D();
      this.f_95780059.begin().glColor(Color.white);
      double var9 = 2.0;
      this.f_95780059
         .drawRect(
            this.f_23ed6fa7.m_a005efae() + this.f_d6e4ab59.m_4388ac29() * (double)this.f_1b6ae1d0[0],
            this.f_23ed6fa7.m_84808068() + this.f_5d46089b.m_d42f3372(),
            this.f_23ed6fa7.m_a005efae() + this.f_d6e4ab59.m_4388ac29() * (double)this.f_1b6ae1d0[0] + var9,
            this.f_23ed6fa7.m_84808068() + this.f_23ed6fa7.m_d42f3372()
         );
      double var11 = this.f_23ed6fa7.m_d42f3372() * ((double)this.f_fdb582bf / 255.0);
      this.f_95780059
         .drawRect(
            this.f_23ed6fa7.m_a005efae() + this.f_23ed6fa7.m_4388ac29() - this.f_60ccd867,
            this.f_23ed6fa7.m_84808068() + var11,
            this.f_23ed6fa7.m_a005efae() + this.f_23ed6fa7.m_4388ac29(),
            this.f_23ed6fa7.m_84808068() + var11 + var9
         );
      this.f_95780059.end();
      this.f_c6f34120.begin().glColor(Color.white);
      this.f_c6f34120
         .drawFilledCircle(
            (float)(this.f_5d46089b.m_a005efae() + this.f_5d46089b.m_4388ac29() * (double)this.f_1b6ae1d0[1]),
            (float)(this.f_5d46089b.m_84808068() + this.f_5d46089b.m_d42f3372() * (double)this.f_1b6ae1d0[2]),
            this.f_d6708eb5 && this.f_2ac4c28d != null && this.f_2ac4c28d.getLeft() == this.f_d32f89e6 ? 5.0F : 3.0F
         );
      this.f_c6f34120.end();
      return var6;
   }

   protected abstract void m_e4529f30(Color var1, boolean var2);

   public C0228.anonymouscatch<C0436> m_ad95f99d() {
      return this.f_d32f89e6;
   }

   public C0228.anonymouscatch<C0436> m_2765a11f() {
      return this.f_bb9e1487;
   }

   public C0228.anonymouscatch<C0436> m_b4c2d220() {
      return this.f_c4237003;
   }

   public double m_b2213d56() {
      return this.f_60ccd867;
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_23ed6fa7;
   }

   public C0165 m_98430fd2() {
      return this.f_5d46089b;
   }

   public C0165 m_3d36812a() {
      return this.f_d6e4ab59;
   }

   public C0165 m_20dced6a() {
      return this.f_d6841adb;
   }

   public Pair<C0228.anonymouscatch<C0436>, C0165> m_917eac53() {
      return this.f_2ac4c28d;
   }

   public int m_197b2fc8() {
      return this.f_fdb582bf;
   }

   public float[] m_dcf7d51e() {
      return this.f_1b6ae1d0;
   }

   public boolean m_ab90d2cd() {
      return this.f_3e9145e0;
   }

   public double m_8aacb726() {
      return this.f_6ffcac53;
   }

   public double m_44e4959f() {
      return this.f_513b1582;
   }

   public QuadRenderStack m_8a81074e() {
      return this.f_95780059;
   }

   public CircleRenderStack m_0c329109() {
      return this.f_c6f34120;
   }

   public boolean m_5b3b8fdb() {
      return this.f_1de9a7e2;
   }

   public boolean m_35baf102() {
      return this.f_d6708eb5;
   }
}
