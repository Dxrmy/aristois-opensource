package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class C0456 {
   private C0461 f_b5635c7c;
   private String f_2e479274;
   private String f_3e9dd46f = null;
   private String f_0d1b6c9e = null;
   private BufferedReader f_e8e87dc7;
   private BufferedWriter f_1d76fa3a;
   private Socket f_85a693e0;
   private boolean f_5ff2c351;
   private long f_9f208267 = 0L;
   private int f_6bc7c309 = 0;

   public C0456(C0461 var1, String var2, String var3, String var4, long var5, int var7) {
      this.f_b5635c7c = var1;
      this.f_9f208267 = var5;
      this.f_6bc7c309 = var7;
      this.f_2e479274 = var2;
      this.f_3e9dd46f = var3;
      this.f_0d1b6c9e = var4;
      this.f_5ff2c351 = true;
   }

   public C0456(C0461 var1, String var2, Socket var3) throws IOException {
      this.f_b5635c7c = var1;
      this.f_2e479274 = var2;
      this.f_85a693e0 = var3;
      this.f_e8e87dc7 = new BufferedReader(new InputStreamReader(this.f_85a693e0.getInputStream()));
      this.f_1d76fa3a = new BufferedWriter(new OutputStreamWriter(this.f_85a693e0.getOutputStream()));
      this.f_5ff2c351 = false;
   }

   public synchronized void m_1058ed9a() throws IOException {
      if (this.f_5ff2c351) {
         this.f_5ff2c351 = false;
         int[] var1 = this.f_b5635c7c.m_729d3cd6(this.f_9f208267);
         String var2 = var1[0] + C0253.m_56242a84() + var1[1] + C0253.m_56242a84() + var1[2] + C0253.m_56242a84() + var1[3];
         this.f_85a693e0 = new Socket(var2, this.f_6bc7c309);
         this.f_e8e87dc7 = new BufferedReader(new InputStreamReader(this.f_85a693e0.getInputStream()));
         this.f_1d76fa3a = new BufferedWriter(new OutputStreamWriter(this.f_85a693e0.getOutputStream()));
      }
   }

   public String m_3d3a8736() throws IOException {
      if (this.f_5ff2c351) {
         throw new IOException(C0265.m_023b99d9());
      } else {
         return this.f_e8e87dc7.readLine();
      }
   }

   public void m_256015fc(String var1) throws IOException {
      if (this.f_5ff2c351) {
         throw new IOException(C0265.m_023b99d9());
      } else {
         this.f_1d76fa3a.write(var1 + C0257.m_b0896de7());
         this.f_1d76fa3a.flush();
      }
   }

   public void m_0e265701() throws IOException {
      if (this.f_5ff2c351) {
         throw new IOException(C0265.m_023b99d9());
      } else {
         this.f_85a693e0.close();
      }
   }

   public String m_d32ebe65() {
      return this.f_2e479274;
   }

   public String m_3855be80() {
      return this.f_3e9dd46f;
   }

   public String m_8ced16bd() {
      return this.f_0d1b6c9e;
   }

   public BufferedReader m_769fc085() {
      return this.f_e8e87dc7;
   }

   public BufferedWriter m_0dfae712() {
      return this.f_1d76fa3a;
   }

   public Socket m_7ce3909f() {
      return this.f_85a693e0;
   }

   public long m_c495d695() {
      return this.f_9f208267;
   }
}
