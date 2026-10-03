package me.deftware.aristois.recovered;

import java.io.BufferedWriter;

public class C0467 extends Thread {
   private C0461 f_a726f79f = null;
   private C0455 f_c5114e0b = null;

   public C0467(C0461 var1, C0455 var2) {
      this.f_a726f79f = var1;
      this.f_c5114e0b = var2;
      this.setName(this.getClass() + C0252.bootstrap<"get",30064771197>());
   }

   public static void m_a5e3c7c0(C0461 var0, BufferedWriter var1, String var2) {
      if (var2.length() > var0.m_ee3300f9() - 2) {
         var2 = var2.substring(0, var0.m_ee3300f9() - 2);
      }

      synchronized (var1) {
         try {
            var1.write(var2 + C0252.bootstrap<"get",69>());
            var1.flush();
            var0.m_bcb5e24a(C0252.bootstrap<"get",34359738375>() + var2);
         } catch (Exception var6) {
         }
      }
   }

   @Override
   public void run() {
      try {
         boolean var1 = true;

         while (var1) {
            C0114.bootstrap<"call",0,1>(this.f_a726f79f.m_280a22b3());
            String var2 = (String)this.f_c5114e0b.m_788048f7();
            if (var2 != null) {
               this.f_a726f79f.m_e767097e(var2);
            } else {
               var1 = false;
            }
         }
      } catch (InterruptedException var3) {
      }
   }
}
