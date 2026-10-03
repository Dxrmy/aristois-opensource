package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class C0465 extends Thread {
   private C0461 f_52de80c6;
   private String f_21751ac6;
   private ServerSocket f_be23b6fd = null;

   public C0465(C0461 var1, String var2) {
      this.f_52de80c6 = var1;
      this.f_21751ac6 = var2;

      try {
         this.f_be23b6fd = new ServerSocket(113);
         this.f_be23b6fd.setSoTimeout(60000);
      } catch (Exception var4) {
         this.f_52de80c6.m_e648c663(C0265.m_62895921());
         return;
      }

      this.f_52de80c6.m_e648c663(C0265.m_ec4ef19a());
      this.setName(this.getClass() + C0265.m_83f6dd00());
      this.start();
   }

   @Override
   public void run() {
      try {
         Socket var1 = this.f_be23b6fd.accept();
         var1.setSoTimeout(60000);
         BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));
         BufferedWriter var3 = new BufferedWriter(new OutputStreamWriter(var1.getOutputStream()));
         String var4 = var2.readLine();
         if (var4 != null) {
            this.f_52de80c6.m_e648c663(C0265.m_56c1229f() + var4);
            var4 = var4 + C0265.m_0d6ae39b() + this.f_21751ac6;
            var3.write(var4 + C0257.m_b0896de7());
            var3.flush();
            this.f_52de80c6.m_e648c663(C0265.m_65d43991() + var4);
            var3.close();
         }
      } catch (Exception var6) {
      }

      try {
         this.f_be23b6fd.close();
      } catch (Exception var5) {
      }

      this.f_52de80c6.m_e648c663(C0265.m_c6614274());
   }
}
