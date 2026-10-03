package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class C0456 {
   private C0461 f_898e14b0;
   private String f_cf885c8a;
   private String f_f502455a = null;
   private String f_53cf85f9 = null;
   private BufferedReader f_978c7a0f;
   private BufferedWriter f_3010bf03;
   private Socket f_704984a6;
   private boolean f_1117f3e1;
   private long f_3a540134 = 0L;
   private int f_98884206 = 0;

   public C0456(C0461 var1, String var2, String var3, String var4, long var5, int var7) {
      this.f_898e14b0 = var1;
      this.f_3a540134 = var5;
      this.f_98884206 = var7;
      this.f_cf885c8a = var2;
      this.f_f502455a = var3;
      this.f_53cf85f9 = var4;
      this.f_1117f3e1 = true;
   }

   public C0456(C0461 var1, String var2, Socket var3) throws IOException {
      this.f_898e14b0 = var1;
      this.f_cf885c8a = var2;
      this.f_704984a6 = var3;
      this.f_978c7a0f = new BufferedReader(new InputStreamReader(this.f_704984a6.getInputStream()));
      this.f_3010bf03 = new BufferedWriter(new OutputStreamWriter(this.f_704984a6.getOutputStream()));
      this.f_1117f3e1 = false;
   }

   public synchronized void m_61723a3c() throws IOException {
      if (this.f_1117f3e1) {
         this.f_1117f3e1 = false;
         int[] var1 = this.f_898e14b0.m_45e74680(this.f_3a540134);
         String var2 = var1[0]
            + C0252.bootstrap<"get",8589934650>()
            + var1[1]
            + C0252.bootstrap<"get",8589934650>()
            + var1[2]
            + C0252.bootstrap<"get",8589934650>()
            + var1[3];
         this.f_704984a6 = new Socket(var2, this.f_98884206);
         this.f_978c7a0f = new BufferedReader(new InputStreamReader(this.f_704984a6.getInputStream()));
         this.f_3010bf03 = new BufferedWriter(new OutputStreamWriter(this.f_704984a6.getOutputStream()));
      }
   }

   public String m_d6c96815() throws IOException {
      if (this.f_1117f3e1) {
         throw new IOException(C0252.bootstrap<"get",30064771186>());
      } else {
         return this.f_978c7a0f.readLine();
      }
   }

   public void m_408f4376(String var1) throws IOException {
      if (this.f_1117f3e1) {
         throw new IOException(C0252.bootstrap<"get",30064771186>());
      } else {
         this.f_3010bf03.write(var1 + C0252.bootstrap<"get",69>());
         this.f_3010bf03.flush();
      }
   }

   public void m_883511b0() throws IOException {
      if (this.f_1117f3e1) {
         throw new IOException(C0252.bootstrap<"get",30064771186>());
      } else {
         this.f_704984a6.close();
      }
   }

   public String m_8c087748() {
      return this.f_cf885c8a;
   }

   public String m_26ecf94a() {
      return this.f_f502455a;
   }

   public String m_c6f3ad39() {
      return this.f_53cf85f9;
   }

   public BufferedReader m_efe358f9() {
      return this.f_978c7a0f;
   }

   public BufferedWriter m_a8928fac() {
      return this.f_3010bf03;
   }

   public Socket m_3ee42cc8() {
      return this.f_704984a6;
   }

   public long m_86a0e593() {
      return this.f_3a540134;
   }
}
