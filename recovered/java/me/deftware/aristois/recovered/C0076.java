package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.render.gl.GLX;

@C0099
public class C0076 extends C0082 {
   public static final double f_f4fd4ccd = 0.525;
   public static final double f_cf36628f = 1.875;
   @C0098(
      value = "Size",
      number = @C0096(
         min = 50.0,
         max = 150.0,
         percentage = true
      )
   )
   private double f_74ba2eee = 80.0;
   private double f_4a02aba6;
   private double f_a478f3b6;
   private double f_e2ed15f2 = 5.0;

   public C0076() {
      super(C0252.bootstrap<"get",25769803905>(), C0087.f_0ff82a38, C0252.bootstrap<"get",30064771072>());
      this.f_029a4b85 = 20;
   }

   public void m_7f83758a(double var1, double var3) {
      double var5 = this.f_74ba2eee;
      this.f_4a02aba6 = var5 * 0.525 * 2.0;
      this.f_a478f3b6 = var5 * 1.875;
      C0114.bootstrap<"call",0,1>().end();
      C0114.bootstrap<"call",1,1>();
      var1 += this.f_e2ed15f2;
      var3 += this.f_e2ed15f2;
      MainEntityPlayer var7 = (MainEntityPlayer)C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>()._getPlayer());
      var7.drawPlayer((int)(var1 + this.f_4a02aba6 / 2.0), (int)(var3 + this.f_a478f3b6), (int)var5);
      this.f_4a02aba6 = this.f_4a02aba6 + this.f_e2ed15f2 * 2.0;
      this.f_a478f3b6 = this.f_a478f3b6 + this.f_e2ed15f2 * 2.0;
      C0114.bootstrap<"call",4,1>();
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      C0114.bootstrap<"call",5,1>();
      C0114.bootstrap<"call",0,1>().begin();
   }

   public double m_3d0dfc90() {
      return this.f_4a02aba6;
   }

   public double m_737209cf() {
      return this.f_a478f3b6;
   }

   public double m_0e129074() {
      return this.f_e2ed15f2;
   }
}
