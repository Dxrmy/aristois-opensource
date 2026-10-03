package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class C0462 extends Thread {
   public static int f_d7c459a1 = 512;
   private C0461 f_9d505961;
   private Socket f_919d3fb2 = null;
   private BufferedReader f_c9d3012a = null;
   private BufferedWriter f_c614c74a = null;
   private boolean f_f12f51a9 = true;
   private boolean f_8cba328a = false;

   public C0462(C0461 var1, Socket var2, BufferedReader var3, BufferedWriter var4) {
      this.f_9d505961 = var1;
      this.f_919d3fb2 = var2;
      this.f_c9d3012a = var3;
      this.f_c614c74a = var4;
      this.setName(this.getClass() + C0252.bootstrap<"get",30064771197>());
   }

   public void m_ed2d6353(String var1) {
      C0114.bootstrap<"call",0,1>(this.f_9d505961, this.f_c614c74a, var1);
   }

   public boolean m_f82663c6() {
      return this.f_f12f51a9;
   }

   @Override
   public void run() {
      try {
         boolean var1 = true;

         while (var1) {
            try {
               Object var2 = null;

               while ((var2 = this.f_c9d3012a.readLine()) != null) {
                  try {
                     this.f_9d505961.m_3fcc5bc1((String)var2);
                  } catch (Throwable var11) {
                     StringWriter var4 = new StringWriter();
                     PrintWriter var5 = new PrintWriter(var4);
                     var11.printStackTrace(var5);
                     var5.flush();
                     StringTokenizer var6 = new StringTokenizer(var4.toString(), C0252.bootstrap<"get",69>());
                     synchronized (this.f_9d505961) {
                        this.f_9d505961.m_bcb5e24a(C0252.bootstrap<"get",34359738368>());
                        this.f_9d505961.m_bcb5e24a(C0252.bootstrap<"get",34359738369>());
                        this.f_9d505961.m_bcb5e24a(C0252.bootstrap<"get",34359738370>());
                        this.f_9d505961.m_bcb5e24a(C0252.bootstrap<"get",34359738371>());
                        this.f_9d505961.m_bcb5e24a(C0252.bootstrap<"get",34359738372>());

                        while (var6.hasMoreTokens()) {
                           this.f_9d505961.m_bcb5e24a(C0252.bootstrap<"get",34359738372>() + var6.nextToken());
                        }
                     }
                  }
               }

               if (var2 == null) {
                  var1 = false;
               }
            } catch (InterruptedIOException var12) {
               this.m_ed2d6353(C0252.bootstrap<"get",34359738373>() + C0114.bootstrap<"call",0,1>() / 1000L);
            }
         }
      } catch (Exception var13) {
      }

      try {
         this.f_919d3fb2.close();
      } catch (Exception var9) {
      }

      if (!this.f_8cba328a) {
         this.f_9d505961.m_bcb5e24a(C0252.bootstrap<"get",34359738374>());
         this.f_f12f51a9 = false;
         this.f_9d505961.m_4738ed33();
      }
   }

   public void m_104491ac() {
      try {
         this.f_8cba328a = true;
         this.f_919d3fb2.close();
      } catch (Exception var2) {
      }
   }
}
