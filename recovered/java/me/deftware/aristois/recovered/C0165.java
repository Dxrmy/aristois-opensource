package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.util.StringJoiner;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public class C0165 {
   @SerializedName("x")
   public double f_31d7dff4;
   @SerializedName("y")
   public double f_20f8315b;
   @SerializedName("width")
   public double f_a632ea7e;
   @SerializedName("height")
   public double f_d814624c;
   private C0165 f_42016b1f;

   public C0165() {
      this.f_31d7dff4 = this.f_20f8315b = this.f_a632ea7e = this.f_d814624c = 0.0;
   }

   public C0165(double var1, double var3, double var5, double var7) {
      this.f_31d7dff4 = var1;
      this.f_20f8315b = var3;
      this.f_a632ea7e = var5;
      this.f_d814624c = var7;
   }

   public C0165 m_0ebf2e75(double var1, double var3, double var5, double var7) {
      this.f_31d7dff4 = var1;
      this.f_20f8315b = var3;
      this.f_a632ea7e = var5;
      this.f_d814624c = var7;
      return this;
   }

   public C0165 m_1e49f000(double var1, double var3) {
      this.f_31d7dff4 = var1;
      this.f_20f8315b = var3;
      return this;
   }

   public C0165 m_d4d3794a(double var1, double var3) {
      this.m_b9e3750e(var1);
      this.m_5078410c(var3);
      return this;
   }

   public void m_62dcf6b9(C0165 var1) {
      this.f_31d7dff4 = var1.f_31d7dff4;
      this.f_20f8315b = var1.f_20f8315b;
      this.f_a632ea7e = var1.f_a632ea7e;
      this.f_d814624c = var1.f_d814624c;
   }

   public boolean m_263d91ea(double var1, double var3) {
      return var1 > this.m_14f8bc2c()
         && var1 < this.m_14f8bc2c() + this.m_830cb294()
         && var3 > this.m_5a998971()
         && var3 < this.m_5a998971() + this.m_fc7f45bc();
   }

   public double m_0b988540(double var1) {
      return var1 < this.m_14f8bc2c() ? this.m_14f8bc2c() : C0114.bootstrap<"call",0,1>(var1, this.m_14f8bc2c() + this.m_830cb294());
   }

   public double m_dba2f125(double var1) {
      return var1 < this.m_5a998971() ? this.m_5a998971() : C0114.bootstrap<"call",0,1>(var1, this.m_5a998971() + this.m_fc7f45bc());
   }

   public C0165 m_504764e1(double var1) {
      return new C0165(this.m_14f8bc2c() + var1, this.m_5a998971() + var1, this.m_830cb294() - var1, this.m_fc7f45bc() - var1);
   }

   public C0165 m_fea02e63(double var1) {
      return new C0165(this.f_31d7dff4 - var1, this.f_20f8315b - var1, this.f_a632ea7e + var1, this.f_d814624c + var1);
   }

   public C0165 m_25a0ff0c(double var1) {
      return new C0165(this.f_31d7dff4, this.f_20f8315b, this.f_a632ea7e, var1);
   }

   public C0165 m_6e88c212(double var1) {
      return new C0165(this.f_31d7dff4, this.f_20f8315b + this.f_d814624c - var1, this.f_a632ea7e, var1 * 2.0);
   }

   public C0165 m_4469d4c1(double var1) {
      return new C0165(this.f_31d7dff4 - var1, this.f_20f8315b, var1 * 2.0, this.f_d814624c);
   }

   public C0165 m_2880a42d(double var1) {
      return new C0165(this.f_31d7dff4 + this.f_a632ea7e, this.f_20f8315b, var1, this.f_d814624c);
   }

   public C0165 m_b772f454(C0165 var1) {
      this.f_42016b1f = var1;
      return this;
   }

   public double m_14f8bc2c() {
      return this.f_31d7dff4 + (this.f_42016b1f != null ? this.f_42016b1f.m_14f8bc2c() : 0.0);
   }

   public double m_5a998971() {
      return this.f_20f8315b + (this.f_42016b1f != null ? this.f_42016b1f.m_5a998971() : 0.0);
   }

   public double m_830cb294() {
      return this.f_a632ea7e;
   }

   public double m_fc7f45bc() {
      return this.f_d814624c;
   }

   public void m_c58b2081(boolean var1) {
      double var2 = (double)C0114.bootstrap<"call",1,1>();
      double var4 = this.m_14f8bc2c();
      double var6 = (double)C0114.bootstrap<"call",2,1>() - this.m_5a998971() - this.m_fc7f45bc();
      double var8 = this.m_830cb294();
      double var10 = this.m_fc7f45bc();
      if (var1) {
         var4 *= var2;
         var6 = (double)C0114.bootstrap<"call",2,1>() - this.m_5a998971() * var2 - this.m_fc7f45bc() * var2;
         var8 *= var2;
         var10 *= var2;
      }

      C0114.bootstrap<"call",3,1>((int)var4, (int)var6, (int)var8, (int)var10);
   }

   public QuadRenderStack m_79e11f68(QuadRenderStack var1) {
      return var1.drawRect(this.m_14f8bc2c(), this.m_5a998971(), this.m_14f8bc2c() + this.m_830cb294(), this.m_5a998971() + this.m_fc7f45bc());
   }

   public QuadRenderStack m_40710a35(QuadRenderStack var1, double var2) {
      return var1.drawRect(
            this.m_14f8bc2c() + this.m_830cb294(), this.m_5a998971(), this.m_14f8bc2c() + this.m_830cb294() + var2, this.m_5a998971() + this.m_fc7f45bc()
         )
         .drawRect(this.m_14f8bc2c() - var2, this.m_5a998971(), this.m_14f8bc2c(), this.m_5a998971() + this.m_fc7f45bc())
         .drawRect(
            this.m_14f8bc2c() - var2,
            this.m_5a998971() + this.m_fc7f45bc(),
            this.m_14f8bc2c() + this.m_830cb294() + var2,
            this.m_5a998971() + this.m_fc7f45bc() + var2
         )
         .drawRect(this.m_14f8bc2c() - var2, this.m_5a998971() - var2, this.m_14f8bc2c() + this.m_830cb294() + var2, this.m_5a998971());
   }

   @Override
   public String toString() {
      return new StringJoiner(C0252.bootstrap<"get",4294967393>())
         .add(C0114.bootstrap<"call",0,1>(this.f_31d7dff4))
         .add(C0114.bootstrap<"call",0,1>(this.f_20f8315b))
         .add(C0114.bootstrap<"call",0,1>(this.f_a632ea7e))
         .add(C0114.bootstrap<"call",0,1>(this.f_d814624c))
         .toString();
   }

   public C0165 m_dd1a13d4() {
      return this.f_42016b1f;
   }

   public void m_6894765d(double var1) {
      this.f_31d7dff4 = var1;
   }

   public void m_7e0ab7c8(double var1) {
      this.f_20f8315b = var1;
   }

   public void m_b9e3750e(double var1) {
      this.f_a632ea7e = var1;
   }

   public void m_5078410c(double var1) {
      this.f_d814624c = var1;
   }

   public void m_90df0c96(C0165 var1) {
      this.f_42016b1f = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0165)) {
         return false;
      } else {
         C0165 var2 = (C0165)var1;
         if (!var2.m_92455db4(this)) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_14f8bc2c(), var2.m_14f8bc2c()) != 0) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_5a998971(), var2.m_5a998971()) != 0) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_830cb294(), var2.m_830cb294()) != 0) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_fc7f45bc(), var2.m_fc7f45bc()) != 0) {
            return false;
         } else {
            C0165 var3 = this.m_dd1a13d4();
            C0165 var4 = var2.m_dd1a13d4();
            return var3 == null ? var4 == null : var3.equals(var4);
         }
      }
   }

   protected boolean m_92455db4(Object var1) {
      return var1 instanceof C0165;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      long var3 = C0114.bootstrap<"call",0,1>(this.m_14f8bc2c());
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = C0114.bootstrap<"call",0,1>(this.m_5a998971());
      var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
      long var7 = C0114.bootstrap<"call",0,1>(this.m_830cb294());
      var2 = var2 * 59 + (int)(var7 >>> 32 ^ var7);
      long var9 = C0114.bootstrap<"call",0,1>(this.m_fc7f45bc());
      var2 = var2 * 59 + (int)(var9 >>> 32 ^ var9);
      C0165 var11 = this.m_dd1a13d4();
      return var2 * 59 + (var11 == null ? 43 : var11.hashCode());
   }
}
