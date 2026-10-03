package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.util.StringJoiner;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import org.lwjgl.opengl.GL11;

public class C0165 {
   @SerializedName("x")
   public double f_50220b21;
   @SerializedName("y")
   public double f_dca1c6b9;
   @SerializedName("width")
   public double f_c6255b76;
   @SerializedName("height")
   public double f_56d42661;
   private C0165 f_8d58d73d;

   public C0165() {
      this.f_50220b21 = this.f_dca1c6b9 = this.f_c6255b76 = this.f_56d42661 = 0.0;
   }

   public C0165(double var1, double var3, double var5, double var7) {
      this.f_50220b21 = var1;
      this.f_dca1c6b9 = var3;
      this.f_c6255b76 = var5;
      this.f_56d42661 = var7;
   }

   public C0165 m_edcdee0d(double var1, double var3, double var5, double var7) {
      this.f_50220b21 = var1;
      this.f_dca1c6b9 = var3;
      this.f_c6255b76 = var5;
      this.f_56d42661 = var7;
      return this;
   }

   public C0165 m_f8b16cfb(double var1, double var3) {
      this.f_50220b21 = var1;
      this.f_dca1c6b9 = var3;
      return this;
   }

   public C0165 m_3ad45185(double var1, double var3) {
      this.m_6fd9bdae(var1);
      this.m_61ade8f3(var3);
      return this;
   }

   public void m_9ee17df4(C0165 var1) {
      this.f_50220b21 = var1.f_50220b21;
      this.f_dca1c6b9 = var1.f_dca1c6b9;
      this.f_c6255b76 = var1.f_c6255b76;
      this.f_56d42661 = var1.f_56d42661;
   }

   public boolean m_a58797d6(double var1, double var3) {
      return var1 > this.m_a005efae()
         && var1 < this.m_a005efae() + this.m_4388ac29()
         && var3 > this.m_84808068()
         && var3 < this.m_84808068() + this.m_d42f3372();
   }

   public double m_d945de47(double var1) {
      return var1 < this.m_a005efae() ? this.m_a005efae() : Math.min(var1, this.m_a005efae() + this.m_4388ac29());
   }

   public double m_461db524(double var1) {
      return var1 < this.m_84808068() ? this.m_84808068() : Math.min(var1, this.m_84808068() + this.m_d42f3372());
   }

   public C0165 m_5de46360(double var1) {
      return new C0165(this.m_a005efae() + var1, this.m_84808068() + var1, this.m_4388ac29() - var1, this.m_d42f3372() - var1);
   }

   public C0165 m_ba7159b4(double var1) {
      return new C0165(this.f_50220b21 - var1, this.f_dca1c6b9 - var1, this.f_c6255b76 + var1, this.f_56d42661 + var1);
   }

   public C0165 m_4b9c6d2e(double var1) {
      return new C0165(this.f_50220b21, this.f_dca1c6b9, this.f_c6255b76, var1);
   }

   public C0165 m_95fe5030(double var1) {
      return new C0165(this.f_50220b21, this.f_dca1c6b9 + this.f_56d42661 - var1, this.f_c6255b76, var1 * 2.0);
   }

   public C0165 m_f516a783(double var1) {
      return new C0165(this.f_50220b21 - var1, this.f_dca1c6b9, var1 * 2.0, this.f_56d42661);
   }

   public C0165 m_c3f845f3(double var1) {
      return new C0165(this.f_50220b21 + this.f_c6255b76, this.f_dca1c6b9, var1, this.f_56d42661);
   }

   public C0165 m_8d8487f4(C0165 var1) {
      this.f_8d58d73d = var1;
      return this;
   }

   public double m_a005efae() {
      return this.f_50220b21 + (this.f_8d58d73d != null ? this.f_8d58d73d.m_a005efae() : 0.0);
   }

   public double m_84808068() {
      return this.f_dca1c6b9 + (this.f_8d58d73d != null ? this.f_8d58d73d.m_84808068() : 0.0);
   }

   public double m_4388ac29() {
      return this.f_c6255b76;
   }

   public double m_d42f3372() {
      return this.f_56d42661;
   }

   public void m_d6ac7420(boolean var1) {
      double var2 = (double)RenderStack.getScale();
      double var4 = this.m_a005efae();
      double var6 = (double)GuiScreen.getDisplayHeight() - this.m_84808068() - this.m_d42f3372();
      double var8 = this.m_4388ac29();
      double var10 = this.m_d42f3372();
      if (var1) {
         var4 *= var2;
         var6 = (double)GuiScreen.getDisplayHeight() - this.m_84808068() * var2 - this.m_d42f3372() * var2;
         var8 *= var2;
         var10 *= var2;
      }

      GL11.glScissor((int)var4, (int)var6, (int)var8, (int)var10);
   }

   public QuadRenderStack m_4bc1a596(QuadRenderStack var1) {
      return var1.drawRect(this.m_a005efae(), this.m_84808068(), this.m_a005efae() + this.m_4388ac29(), this.m_84808068() + this.m_d42f3372());
   }

   public QuadRenderStack m_d4bfedfc(QuadRenderStack var1, double var2) {
      return var1.drawRect(
            this.m_a005efae() + this.m_4388ac29(), this.m_84808068(), this.m_a005efae() + this.m_4388ac29() + var2, this.m_84808068() + this.m_d42f3372()
         )
         .drawRect(this.m_a005efae() - var2, this.m_84808068(), this.m_a005efae(), this.m_84808068() + this.m_d42f3372())
         .drawRect(
            this.m_a005efae() - var2,
            this.m_84808068() + this.m_d42f3372(),
            this.m_a005efae() + this.m_4388ac29() + var2,
            this.m_84808068() + this.m_d42f3372() + var2
         )
         .drawRect(this.m_a005efae() - var2, this.m_84808068() - var2, this.m_a005efae() + this.m_4388ac29() + var2, this.m_84808068());
   }

   @Override
   public String toString() {
      return new StringJoiner(C0264.m_03430357())
         .add(String.valueOf(this.f_50220b21))
         .add(String.valueOf(this.f_dca1c6b9))
         .add(String.valueOf(this.f_c6255b76))
         .add(String.valueOf(this.f_56d42661))
         .toString();
   }

   public C0165 m_b6fbce20() {
      return this.f_8d58d73d;
   }

   public void m_dadc1f5d(double var1) {
      this.f_50220b21 = var1;
   }

   public void m_01fed791(double var1) {
      this.f_dca1c6b9 = var1;
   }

   public void m_6fd9bdae(double var1) {
      this.f_c6255b76 = var1;
   }

   public void m_61ade8f3(double var1) {
      this.f_56d42661 = var1;
   }

   public void m_84c65dd3(C0165 var1) {
      this.f_8d58d73d = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0165)) {
         return false;
      } else {
         C0165 var2 = (C0165)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (Double.compare(this.m_a005efae(), var2.m_a005efae()) != 0) {
            return false;
         } else if (Double.compare(this.m_84808068(), var2.m_84808068()) != 0) {
            return false;
         } else if (Double.compare(this.m_4388ac29(), var2.m_4388ac29()) != 0) {
            return false;
         } else if (Double.compare(this.m_d42f3372(), var2.m_d42f3372()) != 0) {
            return false;
         } else {
            C0165 var3 = this.m_b6fbce20();
            C0165 var4 = var2.m_b6fbce20();
            return var3 == null ? var4 == null : var3.equals(var4);
         }
      }
   }

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0165;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      long var3 = Double.doubleToLongBits(this.m_a005efae());
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = Double.doubleToLongBits(this.m_84808068());
      var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
      long var7 = Double.doubleToLongBits(this.m_4388ac29());
      var2 = var2 * 59 + (int)(var7 >>> 32 ^ var7);
      long var9 = Double.doubleToLongBits(this.m_d42f3372());
      var2 = var2 * 59 + (int)(var9 >>> 32 ^ var9);
      C0165 var11 = this.m_b6fbce20();
      return var2 * 59 + (var11 == null ? 43 : var11.hashCode());
   }
}
