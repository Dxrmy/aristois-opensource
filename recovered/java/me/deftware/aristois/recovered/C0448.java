package me.deftware.aristois.recovered;

import java.util.function.Consumer;

public class C0448 {
   public static final int f_cd879041 = 32;
   private final C0450[][] f_a6d3cde9 = new C0450[32][32];
   private final int f_a7b5dcd5;
   private final int f_0a950b09;
   private final int f_fe64da40;

   public C0448(int var1, int var2, int var3) {
      this.f_a7b5dcd5 = var1;
      this.f_0a950b09 = var2;
      this.f_fe64da40 = var3;
   }

   public boolean m_d7db8b4a(int var1, int var2) {
      return this.m_fad6b1b2(var1, var2) != null;
   }

   public C0450 m_fad6b1b2(int var1, int var2) {
      return this.f_a6d3cde9[var1][var2];
   }

   public void m_80da0d1a(int var1, int var2, C0450 var3) {
      this.f_a6d3cde9[var1][var2] = var3;
   }

   public C0450 m_c046bc68(int var1, int var2) {
      C0450 var3 = this.m_fad6b1b2(var1, var2);
      if (var3 == null) {
         return null;
      } else {
         this.m_80da0d1a(var1, var2, null);
         return var3;
      }
   }

   public void m_ed2a80e1(Consumer<C0450> var1) {
      for (int var2 = 0; var2 < 32; var2++) {
         for (int var3 = 0; var3 < 32; var3++) {
            if (this.f_a6d3cde9[var2][var3] != null) {
               var1.accept(this.f_a6d3cde9[var2][var3]);
            }
         }
      }
   }

   public boolean m_efa7610e() {
      for (int var1 = 0; var1 < 32; var1++) {
         for (int var2 = 0; var2 < 32; var2++) {
            if (this.f_a6d3cde9[var1][var2] != null) {
               return false;
            }
         }
      }

      return true;
   }

   public long m_9d4d8e71() {
      return m_e4655c68(this.f_a7b5dcd5, this.f_0a950b09);
   }

   public static long m_e4655c68(int var0, int var1) {
      return (long)var0 & 4294967295L | ((long)var1 & 4294967295L) << 32;
   }

   public int m_037208cc() {
      return this.f_a7b5dcd5;
   }

   public int m_36ffc578() {
      return this.f_0a950b09;
   }

   public int m_a135e825() {
      return this.f_fe64da40;
   }
}
