package me.deftware.aristois.recovered;

import java.util.concurrent.Executors;

public class C0285 extends C0288<C0285> {
   protected boolean f_0e95c81f = false;
   protected boolean f_a0e8c1bc = false;

   public C0285(Runnable var1) {
      if (var1 != null) {
         this.m_c162d659(var1);
      }
   }

   protected void m_c162d659(Runnable var1) {
      Executors.newSingleThreadExecutor().submit(() -> {
         var1.run();
         this.f_a0e8c1bc = true;
      });
   }

   public C0285 m_49509d4b() {
      this.f_a0e8c1bc = true;
      return this;
   }

   public C0285 m_d0dcca5b() {
      this.f_ae2cc37b = System.currentTimeMillis();
      this.f_0e95c81f = true;
      return this;
   }

   public C0285 m_767c05e5() {
      return this;
   }

   @Override
   public boolean m_9362a920() {
      return this.f_0e95c81f;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_a0e8c1bc;
   }
}
