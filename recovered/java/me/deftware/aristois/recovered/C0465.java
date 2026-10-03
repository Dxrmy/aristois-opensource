package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class C0465 extends Thread {
   private C0461 f_2137e18c;
   private String f_b09e96ca;
   private ServerSocket f_62347cf6 = null;

   public C0465(C0461 var1, String var2) {
      this.f_2137e18c = var1;
      this.f_b09e96ca = var2;

      try {
         this.f_62347cf6 = new ServerSocket(113);
         this.f_62347cf6.setSoTimeout(60000);
      } catch (Exception var4) {
         this.f_2137e18c.m_bcb5e24a(C0252.bootstrap<"get",30064771195>());
         return;
      }

      this.f_2137e18c.m_bcb5e24a(C0252.bootstrap<"get",30064771196>());
      this.setName(this.getClass() + C0252.bootstrap<"get",30064771197>());
      this.start();
   }

   @Override
   public void run() {
      try {
         Socket var1 = this.f_62347cf6.accept();
         var1.setSoTimeout(60000);
         BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));
         BufferedWriter var3 = new BufferedWriter(new OutputStreamWriter(var1.getOutputStream()));
         String var4 = var2.readLine();
         if (var4 != null) {
            this.f_2137e18c.m_bcb5e24a(C0252.bootstrap<"get",30064771198>() + var4);
            var4 = var4 + C0252.bootstrap<"get",30064771199>() + this.f_b09e96ca;
            var3.write(var4 + C0252.bootstrap<"get",69>());
            var3.flush();
            this.f_2137e18c.m_bcb5e24a(C0252.bootstrap<"get",30064771200>() + var4);
            var3.close();
         }
      } catch (Exception var6) {
      }

      try {
         this.f_62347cf6.close();
      } catch (Exception var5) {
      }

      this.f_2137e18c.m_bcb5e24a(C0252.bootstrap<"get",30064771201>());
   }
}
