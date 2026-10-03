package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class C0462 extends Thread {
   public static int f_f359619d = 512;
   private C0461 f_67b8c502;
   private Socket f_5c5266cf = null;
   private BufferedReader f_2024937e = null;
   private BufferedWriter f_3b96ddcf = null;
   private boolean f_6faec1a6 = true;
   private boolean f_6853c152 = false;

   public C0462(C0461 var1, Socket var2, BufferedReader var3, BufferedWriter var4) {
      this.f_67b8c502 = var1;
      this.f_5c5266cf = var2;
      this.f_2024937e = var3;
      this.f_3b96ddcf = var4;
      this.setName(this.getClass() + C0265.m_83f6dd00());
   }

   public void m_256015fc(String var1) {
      C0467.m_9ca91702(this.f_67b8c502, this.f_3b96ddcf, var1);
   }

   public boolean m_efa7610e() {
      return this.f_6faec1a6;
   }

   @Override
   public void run() {
      try {
         boolean var1 = true;

         while (var1) {
            try {
               Object var2 = null;

               while ((var2 = this.f_2024937e.readLine()) != null) {
                  try {
                     this.f_67b8c502.m_ede76c21((String)var2);
                  } catch (Throwable var11) {
                     StringWriter var4 = new StringWriter();
                     PrintWriter var5 = new PrintWriter(var4);
                     var11.printStackTrace(var5);
                     var5.flush();
                     StringTokenizer var6 = new StringTokenizer(var4.toString(), C0257.m_b0896de7());
                     synchronized (this.f_67b8c502) {
                        this.f_67b8c502.m_e648c663(C0262.m_44418b5d());
                        this.f_67b8c502.m_e648c663(C0262.m_813e3509());
                        this.f_67b8c502.m_e648c663(C0262.m_3855be80());
                        this.f_67b8c502.m_e648c663(C0262.m_a9247108());
                        this.f_67b8c502.m_e648c663(C0262.m_4626ac74());

                        while (var6.hasMoreTokens()) {
                           this.f_67b8c502.m_e648c663(C0262.m_4626ac74() + var6.nextToken());
                        }
                     }
                  }
               }

               if (var2 == null) {
                  var1 = false;
               }
            } catch (InterruptedIOException var12) {
               this.m_256015fc(C0262.m_c688f8ca() + System.currentTimeMillis() / 1000L);
            }
         }
      } catch (Exception var13) {
      }

      try {
         this.f_5c5266cf.close();
      } catch (Exception var9) {
      }

      if (!this.f_6853c152) {
         this.f_67b8c502.m_e648c663(C0262.m_35cdaa1a());
         this.f_6faec1a6 = false;
         this.f_67b8c502.m_0e265701();
      }
   }

   public void m_b728afce() {
      try {
         this.f_6853c152 = true;
         this.f_5c5266cf.close();
      } catch (Exception var2) {
      }
   }
}
