package me.deftware.aristois.recovered;

import java.util.function.Consumer;

public class C0448 {
   public static final int f_d00aad45 = 32;
   private final C0450[][] f_4e7c1ceb = new C0450[32][32];
   private final int f_92e55e45;
   private final int f_48f29d5d;
   private final int f_9e7135c9;

   public C0448(int var1, int var2, int var3) {
      this.f_92e55e45 = var1;
      this.f_48f29d5d = var2;
      this.f_9e7135c9 = var3;
   }

   public boolean m_1f76242d(int var1, int var2) {
      return this.m_a8d5b6e2(var1, var2) != null;
   }

   public C0450 m_a8d5b6e2(int var1, int var2) {
      return this.f_4e7c1ceb[var1][var2];
   }

   public void m_2bed9e55(int var1, int var2, C0450 var3) {
      this.f_4e7c1ceb[var1][var2] = var3;
   }

   public C0450 m_c795fea3(int var1, int var2) {
      C0450 var3 = this.m_a8d5b6e2(var1, var2);
      if (var3 == null) {
         return null;
      } else {
         this.m_2bed9e55(var1, var2, null);
         return var3;
      }
   }

   public void m_faf9729c(Consumer<C0450> var1) {
      for (int var2 = 0; var2 < 32; var2++) {
         for (int var3 = 0; var3 < 32; var3++) {
            if (this.f_4e7c1ceb[var2][var3] != null) {
               var1.accept(this.f_4e7c1ceb[var2][var3]);
            }
         }
      }
   }

   public boolean m_c8ed677a() {
      for (int var1 = 0; var1 < 32; var1++) {
         for (int var2 = 0; var2 < 32; var2++) {
            if (this.f_4e7c1ceb[var1][var2] != null) {
               return false;
            }
         }
      }

      return true;
   }

   public long m_5a8d81cf() {
      return C0114.bootstrap<"call",0,1>(this.f_92e55e45, this.f_48f29d5d);
   }

   public static long m_35da980a(int var0, int var1) {
      return (long)var0 & 4294967295L | ((long)var1 & 4294967295L) << 32;
   }

   public int m_0d336558() {
      return this.f_92e55e45;
   }

   public int m_79d986a0() {
      return this.f_48f29d5d;
   }

   public int m_69f67332() {
      return this.f_9e7135c9;
   }
}
