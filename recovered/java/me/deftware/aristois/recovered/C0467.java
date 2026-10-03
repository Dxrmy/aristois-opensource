package me.deftware.aristois.recovered;

import java.io.BufferedWriter;

public class C0467 extends Thread {
   private C0461 f_28f6af19 = null;
   private C0455 f_3ad66f73 = null;

   public C0467(C0461 var1, C0455 var2) {
      this.f_28f6af19 = var1;
      this.f_3ad66f73 = var2;
      this.setName(this.getClass() + C0265.m_83f6dd00());
   }

   public static void m_9ca91702(C0461 var0, BufferedWriter var1, String var2) {
      if (var2.length() > var0.m_d1e531af() - 2) {
         var2 = var2.substring(0, var0.m_d1e531af() - 2);
      }

      synchronized (var1) {
         try {
            var1.write(var2 + C0257.m_b0896de7());
            var1.flush();
            var0.m_e648c663(C0262.m_624b40d8() + var2);
         } catch (Exception var6) {
         }
      }
   }

   @Override
   public void run() {
      try {
         boolean var1 = true;

         while (var1) {
            Thread.sleep(this.f_28f6af19.m_c7c6e660());
            String var2 = (String)this.f_3ad66f73.m_ac6eac3b();
            if (var2 != null) {
               this.f_28f6af19.m_4f03e646(var2);
            } else {
               var1 = false;
            }
         }
      } catch (InterruptedException var3) {
      }
   }
}
