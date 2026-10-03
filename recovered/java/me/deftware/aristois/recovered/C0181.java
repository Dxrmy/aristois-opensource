package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0181 implements C0441 {
   private final FontRenderStack f_01e7ff53 = new FontRenderStack(C0231.f_eda958c4);
   private Color f_c795f452 = Color.cyan;
   private Color f_868c6db2 = Color.WHITE;
   private Color f_8a5fa9a3 = Color.white;
   private Color f_c5a209ea = new Color(44, 44, 47, 77);
   private Color f_8802a5a7 = new Color(45, 62, 80, 245).darker().darker();
   private Color f_376a778c = this.f_c5a209ea.brighter();
   private Color f_589ec801 = new Color(65, 192, 121);
   private Color f_4beba848 = this.f_c5a209ea.brighter().brighter();
   private double f_dfc9a267 = 15.0;
   private double f_52be0529 = 10.0;
   private boolean f_a9839c21 = true;
   private int f_fc0ab9dc = 5;
   private String f_a0bc8623 = C0252.bootstrap<"get",17179869254>();
   private C0102<C0427> f_74917f57 = new C0102<>(C0427.f_f7cee513);
   private long f_fdc28ae1 = 170L;

   public C0181() {
   }

   public FontRenderStack m_ec813d70() {
      return this.f_01e7ff53;
   }

   public Color m_bb9f7063() {
      return this.f_c795f452;
   }

   public Color m_afb27d6b() {
      return this.f_868c6db2;
   }

   public Color m_5d3143f7() {
      return this.f_8a5fa9a3;
   }

   public Color m_b18f94a6() {
      return this.f_c5a209ea;
   }

   public Color m_452e329b() {
      return this.f_8802a5a7;
   }

   public Color m_289e2a26() {
      return this.f_376a778c;
   }

   public Color m_b35883a0() {
      return this.f_589ec801;
   }

   public Color m_9b9582c1() {
      return this.f_4beba848;
   }

   public double m_df314099() {
      return this.f_dfc9a267;
   }

   public double m_c2eb1dc6() {
      return this.f_52be0529;
   }

   public boolean m_3bf6ac5e() {
      return this.f_a9839c21;
   }

   public int m_b74d752b() {
      return this.f_fc0ab9dc;
   }

   public String m_5e6820e6() {
      return this.f_a0bc8623;
   }

   public C0102<C0427> m_0895cef6() {
      return this.f_74917f57;
   }

   public long m_d092d211() {
      return this.f_fdc28ae1;
   }

   public void m_c75d5d5e(Color var1) {
      this.f_c795f452 = var1;
   }

   public void m_a499addd(Color var1) {
      this.f_868c6db2 = var1;
   }

   public void m_a52de668(Color var1) {
      this.f_8a5fa9a3 = var1;
   }

   public void m_46f2ed0f(Color var1) {
      this.f_c5a209ea = var1;
   }

   public void m_34ea2b83(Color var1) {
      this.f_8802a5a7 = var1;
   }

   public void m_7674062b(Color var1) {
      this.f_376a778c = var1;
   }

   public void m_36309caf(Color var1) {
      this.f_589ec801 = var1;
   }

   public void m_b9a5fbee(Color var1) {
      this.f_4beba848 = var1;
   }

   public void m_7f579100(double var1) {
      this.f_dfc9a267 = var1;
   }

   public void m_63640eef(double var1) {
      this.f_52be0529 = var1;
   }

   public void m_d1462ee5(boolean var1) {
      this.f_a9839c21 = var1;
   }

   public void m_6a43642a(int var1) {
      this.f_fc0ab9dc = var1;
   }

   public void m_37b5ad55(String var1) {
      this.f_a0bc8623 = var1;
   }

   public void m_68d28724(C0102<C0427> var1) {
      this.f_74917f57 = var1;
   }

   public void m_04d9fa82(long var1) {
      this.f_fdc28ae1 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0181)) {
         return false;
      } else {
         C0181 var2 = (C0181)var1;
         if (!var2.m_016367ec(this)) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_df314099(), var2.m_df314099()) != 0) {
            return false;
         } else if (C0114.bootstrap<"call",0,1>(this.m_c2eb1dc6(), var2.m_c2eb1dc6()) != 0) {
            return false;
         } else if (this.m_3bf6ac5e() != var2.m_3bf6ac5e()) {
            return false;
         } else if (this.m_b74d752b() != var2.m_b74d752b()) {
            return false;
         } else if (this.m_d092d211() != var2.m_d092d211()) {
            return false;
         } else {
            FontRenderStack var3 = this.m_ec813d70();
            FontRenderStack var4 = var2.m_ec813d70();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               Color var5 = this.m_bb9f7063();
               Color var6 = var2.m_bb9f7063();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  Color var7 = this.m_afb27d6b();
                  Color var8 = var2.m_afb27d6b();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     Color var9 = this.m_5d3143f7();
                     Color var10 = var2.m_5d3143f7();
                     if (var9 == null ? var10 == null : var9.equals(var10)) {
                        Color var11 = this.m_b18f94a6();
                        Color var12 = var2.m_b18f94a6();
                        if (var11 == null ? var12 == null : var11.equals(var12)) {
                           Color var13 = this.m_452e329b();
                           Color var14 = var2.m_452e329b();
                           if (var13 == null ? var14 == null : var13.equals(var14)) {
                              Color var15 = this.m_289e2a26();
                              Color var16 = var2.m_289e2a26();
                              if (var15 == null ? var16 == null : var15.equals(var16)) {
                                 Color var17 = this.m_b35883a0();
                                 Color var18 = var2.m_b35883a0();
                                 if (var17 == null ? var18 == null : var17.equals(var18)) {
                                    Color var19 = this.m_9b9582c1();
                                    Color var20 = var2.m_9b9582c1();
                                    if (var19 == null ? var20 == null : var19.equals(var20)) {
                                       String var21 = this.m_5e6820e6();
                                       String var22 = var2.m_5e6820e6();
                                       if (var21 == null ? var22 == null : var21.equals(var22)) {
                                          C0102 var23 = this.m_0895cef6();
                                          C0102 var24 = var2.m_0895cef6();
                                          return var23 == null ? var24 == null : var23.equals(var24);
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_016367ec(Object var1) {
      return var1 instanceof C0181;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      long var3 = C0114.bootstrap<"call",0,1>(this.m_df314099());
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = C0114.bootstrap<"call",0,1>(this.m_c2eb1dc6());
      var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
      var2 = var2 * 59 + (this.m_3bf6ac5e() ? 79 : 97);
      var2 = var2 * 59 + this.m_b74d752b();
      long var7 = this.m_d092d211();
      var2 = var2 * 59 + (int)(var7 >>> 32 ^ var7);
      FontRenderStack var9 = this.m_ec813d70();
      var2 = var2 * 59 + (var9 == null ? 43 : var9.hashCode());
      Color var10 = this.m_bb9f7063();
      var2 = var2 * 59 + (var10 == null ? 43 : var10.hashCode());
      Color var11 = this.m_afb27d6b();
      var2 = var2 * 59 + (var11 == null ? 43 : var11.hashCode());
      Color var12 = this.m_5d3143f7();
      var2 = var2 * 59 + (var12 == null ? 43 : var12.hashCode());
      Color var13 = this.m_b18f94a6();
      var2 = var2 * 59 + (var13 == null ? 43 : var13.hashCode());
      Color var14 = this.m_452e329b();
      var2 = var2 * 59 + (var14 == null ? 43 : var14.hashCode());
      Color var15 = this.m_289e2a26();
      var2 = var2 * 59 + (var15 == null ? 43 : var15.hashCode());
      Color var16 = this.m_b35883a0();
      var2 = var2 * 59 + (var16 == null ? 43 : var16.hashCode());
      Color var17 = this.m_9b9582c1();
      var2 = var2 * 59 + (var17 == null ? 43 : var17.hashCode());
      String var18 = this.m_5e6820e6();
      var2 = var2 * 59 + (var18 == null ? 43 : var18.hashCode());
      C0102 var19 = this.m_0895cef6();
      return var2 * 59 + (var19 == null ? 43 : var19.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",21474836521>()
         + this.m_ec813d70()
         + C0252.bootstrap<"get",21474836522>()
         + this.m_bb9f7063()
         + C0252.bootstrap<"get",21474836523>()
         + this.m_afb27d6b()
         + C0252.bootstrap<"get",21474836524>()
         + this.m_5d3143f7()
         + C0252.bootstrap<"get",21474836525>()
         + this.m_b18f94a6()
         + C0252.bootstrap<"get",21474836526>()
         + this.m_452e329b()
         + C0252.bootstrap<"get",21474836527>()
         + this.m_289e2a26()
         + C0252.bootstrap<"get",21474836528>()
         + this.m_b35883a0()
         + C0252.bootstrap<"get",21474836529>()
         + this.m_9b9582c1()
         + C0252.bootstrap<"get",21474836530>()
         + this.m_df314099()
         + C0252.bootstrap<"get",21474836531>()
         + this.m_c2eb1dc6()
         + C0252.bootstrap<"get",21474836532>()
         + this.m_3bf6ac5e()
         + C0252.bootstrap<"get",21474836533>()
         + this.m_b74d752b()
         + C0252.bootstrap<"get",21474836534>()
         + this.m_5e6820e6()
         + C0252.bootstrap<"get",21474836535>()
         + this.m_0895cef6()
         + C0252.bootstrap<"get",21474836536>()
         + this.m_d092d211()
         + C0252.bootstrap<"get",59>();
   }
}
