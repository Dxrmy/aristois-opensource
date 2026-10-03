package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.render.batching.CircleRenderStack;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.util.types.Pair;

public abstract class C0436 implements C0163 {
   private final C0228.anonymouscatch<C0436> f_3f61fe54;
   private final C0228.anonymouscatch<C0436> f_841f9d98;
   private final C0228.anonymouscatch<C0436> f_8a523b4e;
   private final double f_605f4d2b;
   private final C0165 f_ef4abe07;
   private final C0165 f_fb243205;
   private final C0165 f_56b6639d;
   private final C0165 f_60e1f853;
   private Pair<C0228.anonymouscatch<C0436>, C0165> f_b3c7223e;
   public int f_c4c9313f = 255;
   public final float[] f_9da0be27 = new float[3];
   private boolean f_c95fbd0c = false;
   private double f_333a4784;
   private double f_5c364858;
   private final QuadRenderStack f_4631165b = new QuadRenderStack();
   private final CircleRenderStack f_c9f03a41 = new CircleRenderStack();
   private boolean f_817fc5a1 = true;
   private boolean f_05a04bba = false;

   public <T extends C0228.anonymouscatch<C0436>> C0436(double var1, double var3, double var5, double var7, Color var9, T var10, T var11, T var12) {
      this.f_605f4d2b = var7 * 0.15;
      this.f_ef4abe07 = new C0165(var1, var3, var5, var7);
      this.f_fb243205 = new C0165(0.0, 0.0, var5 - this.f_605f4d2b, var7 - this.f_605f4d2b).m_b772f454(this.f_ef4abe07);
      this.f_56b6639d = new C0165(0.0, this.f_fb243205.m_fc7f45bc(), this.f_fb243205.m_830cb294(), this.f_605f4d2b).m_b772f454(this.f_ef4abe07);
      this.f_60e1f853 = new C0165(this.f_fb243205.m_830cb294(), 0.0, this.f_605f4d2b, var7).m_b772f454(this.f_ef4abe07);
      this.f_3f61fe54 = var10;
      this.f_841f9d98 = var11;
      this.f_8a523b4e = var12;
      this.m_994d92a8(var9);
   }

   public C0436 m_db07df63(boolean var1) {
      this.f_817fc5a1 = var1;
      this.f_4631165b.setScaled(var1);
      this.f_c9f03a41.setScaled(var1);
      return this;
   }

   public void m_69f94f95() {
      this.f_3f61fe54.m_774394be((var1x, var2, var3, var4, var5) -> new Color(C0114.bootstrap<"call",0,1>(this.f_9da0be27[0], var2 / var4, var3 / var5)));
      int var1 = C0114.bootstrap<"call",0,1>(this.f_9da0be27[0], this.f_9da0be27[1], this.f_9da0be27[2]);
      this.f_8a523b4e.m_774394be((var1x, var2, var3, var4, var5) -> {
         double var6 = C0114.bootstrap<"call",6,1>((double)(var3 / var5), 0.13);
         int var8 = (int)(255.0 * var6);
         return new Color(var1 & 16777215 | var8 << 24, true);
      });
      if (!this.f_c95fbd0c) {
         this.f_841f9d98.m_774394be((var0, var1x, var2, var3, var4) -> new Color(C0114.bootstrap<"call",5,1>(var1x / var3, 1.0F, 1.0F)));
      }
   }

   public void m_994d92a8(Color var1) {
      this.f_c4c9313f = var1.getAlpha();
      C0114.bootstrap<"call",0,1>(var1.getRed(), var1.getGreen(), var1.getBlue(), this.f_9da0be27);
   }

   public Color m_6af97ed1() {
      int var1 = C0114.bootstrap<"call",0,1>(this.f_9da0be27[0], this.f_9da0be27[1], this.f_9da0be27[2]);
      return new Color(var1 & 16777215 | this.f_c4c9313f << 24, true);
   }

   public void m_4ffcde4c(boolean var1) {
      this.m_be9b0e8d(this.m_6af97ed1(), var1);
   }

   public boolean m_3d5393f2(double var1, double var3, int var5) {
      if (this.f_05a04bba = this.f_ef4abe07.m_263d91ea(var1, var3)) {
         if (this.f_fb243205.m_263d91ea(var1, var3)) {
            this.f_b3c7223e = new Pair(this.f_3f61fe54, this.f_fb243205);
         } else if (this.f_56b6639d.m_263d91ea(var1, var3)) {
            this.f_b3c7223e = new Pair(this.f_841f9d98, this.f_56b6639d);
         } else if (this.f_60e1f853.m_263d91ea(var1, var3)) {
            this.f_b3c7223e = new Pair(this.f_8a523b4e, this.f_60e1f853);
         }
      }

      return this.f_05a04bba;
   }

   public boolean m_1ab1f7bc(double var1, double var3, int var5) {
      this.f_b3c7223e = null;
      this.m_4ffcde4c(false);
      return this.f_05a04bba = false;
   }

   private void m_1288adba(double var1, double var3) {
      C0165 var5 = (C0165)this.f_b3c7223e.getRight();
      double var6 = (var5.m_0b988540(var1) - var5.m_14f8bc2c()) / var5.m_830cb294();
      double var8 = (var5.m_dba2f125(var3) - var5.m_5a998971()) / var5.m_fc7f45bc();
      ((C0228.anonymouscatch)this.f_b3c7223e.getLeft()).m_f7eedf56(this, var6, var8);
   }

   public boolean m_259aec8e(double var1, double var3, float var5, boolean var6) {
      if (!this.f_c95fbd0c) {
         this.m_69f94f95();
         this.f_c95fbd0c = true;
      }

      if (this.f_05a04bba && (this.f_333a4784 != var1 || this.f_5c364858 != var3)) {
         this.f_333a4784 = var1;
         this.f_5c364858 = var3;
         this.m_1288adba(var1, var3);
      }

      double var7 = 1.0;
      if (this.f_817fc5a1) {
         var7 = (double)C0114.bootstrap<"call",1,1>();
      }

      C0114.bootstrap<"call",2,1>();
      C0114.bootstrap<"call",3,1>();
      this.f_3f61fe54
         .bind()
         .draw(
            (int)(this.f_fb243205.m_14f8bc2c() * var7),
            (int)(this.f_fb243205.m_5a998971() * var7),
            (int)(this.f_fb243205.m_830cb294() * var7),
            (int)(this.f_fb243205.m_fc7f45bc() * var7)
         )
         .unbind();
      this.f_841f9d98
         .bind()
         .draw(
            (int)(this.f_56b6639d.m_14f8bc2c() * var7),
            (int)(this.f_56b6639d.m_5a998971() * var7),
            (int)(this.f_56b6639d.m_830cb294() * var7),
            (int)(this.f_56b6639d.m_fc7f45bc() * var7)
         )
         .unbind();
      this.f_8a523b4e
         .bind()
         .draw(
            (int)(this.f_60e1f853.m_14f8bc2c() * var7),
            (int)(this.f_60e1f853.m_5a998971() * var7),
            (int)(this.f_60e1f853.m_830cb294() * var7),
            (int)(this.f_60e1f853.m_fc7f45bc() * var7)
         )
         .unbind();
      C0114.bootstrap<"call",4,1>();
      this.f_4631165b.begin().glColor(Color.white);
      double var9 = 2.0;
      this.f_4631165b
         .drawRect(
            this.f_ef4abe07.m_14f8bc2c() + this.f_56b6639d.m_830cb294() * (double)this.f_9da0be27[0],
            this.f_ef4abe07.m_5a998971() + this.f_fb243205.m_fc7f45bc(),
            this.f_ef4abe07.m_14f8bc2c() + this.f_56b6639d.m_830cb294() * (double)this.f_9da0be27[0] + var9,
            this.f_ef4abe07.m_5a998971() + this.f_ef4abe07.m_fc7f45bc()
         );
      double var11 = this.f_ef4abe07.m_fc7f45bc() * ((double)this.f_c4c9313f / 255.0);
      this.f_4631165b
         .drawRect(
            this.f_ef4abe07.m_14f8bc2c() + this.f_ef4abe07.m_830cb294() - this.f_605f4d2b,
            this.f_ef4abe07.m_5a998971() + var11,
            this.f_ef4abe07.m_14f8bc2c() + this.f_ef4abe07.m_830cb294(),
            this.f_ef4abe07.m_5a998971() + var11 + var9
         );
      this.f_4631165b.end();
      this.f_c9f03a41.begin().glColor(Color.white);
      this.f_c9f03a41
         .drawFilledCircle(
            (float)(this.f_fb243205.m_14f8bc2c() + this.f_fb243205.m_830cb294() * (double)this.f_9da0be27[1]),
            (float)(this.f_fb243205.m_5a998971() + this.f_fb243205.m_fc7f45bc() * (double)this.f_9da0be27[2]),
            this.f_05a04bba && this.f_b3c7223e != null && this.f_b3c7223e.getLeft() == this.f_3f61fe54 ? 5.0F : 3.0F
         );
      this.f_c9f03a41.end();
      return var6;
   }

   protected abstract void m_be9b0e8d(Color var1, boolean var2);

   public C0228.anonymouscatch<C0436> m_b7c15833() {
      return this.f_3f61fe54;
   }

   public C0228.anonymouscatch<C0436> m_ab0187e0() {
      return this.f_841f9d98;
   }

   public C0228.anonymouscatch<C0436> m_32bc2abb() {
      return this.f_8a523b4e;
   }

   public double m_ebcccfbe() {
      return this.f_605f4d2b;
   }

   public C0165 m_abf2d8ea() {
      return this.f_ef4abe07;
   }

   public C0165 m_995c45fc() {
      return this.f_fb243205;
   }

   public C0165 m_1239c57f() {
      return this.f_56b6639d;
   }

   public C0165 m_38371df5() {
      return this.f_60e1f853;
   }

   public Pair<C0228.anonymouscatch<C0436>, C0165> m_5c184c52() {
      return this.f_b3c7223e;
   }

   public int m_fb8ad3fd() {
      return this.f_c4c9313f;
   }

   public float[] m_b283f3c8() {
      return this.f_9da0be27;
   }

   public boolean m_f7f17988() {
      return this.f_c95fbd0c;
   }

   public double m_0664669b() {
      return this.f_333a4784;
   }

   public double m_d33f034a() {
      return this.f_5c364858;
   }

   public QuadRenderStack m_838c2d47() {
      return this.f_4631165b;
   }

   public CircleRenderStack m_77eaa8bd() {
      return this.f_c9f03a41;
   }

   public boolean m_2b2dffe7() {
      return this.f_817fc5a1;
   }

   public boolean m_732a604d() {
      return this.f_05a04bba;
   }
}
