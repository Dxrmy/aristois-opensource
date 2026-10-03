package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class C0288<T> {
   protected final List<Consumer<Long>> f_45f14763 = new ArrayList<>();
   protected int f_671a49fc = 0;
   protected int f_f89a85bd = 0;
   protected boolean f_2febc829 = false;
   protected long f_915721a7;
   protected long f_ae2cc37b;

   public C0288() {
   }

   public abstract boolean m_f7b07982();

   public abstract boolean m_9362a920();

   public void m_41e83f88() {
      if (this.f_45f14763.size() > this.f_f89a85bd) {
         if (this.f_915721a7 + (long)this.f_671a49fc < System.currentTimeMillis()) {
            this.m_fd4438d8();
         }
      } else {
         this.f_2febc829 = true;
      }
   }

   private void m_fd4438d8() {
      this.f_45f14763.get(this.f_f89a85bd).accept(System.currentTimeMillis() - this.f_ae2cc37b);
      this.f_915721a7 = System.currentTimeMillis();
      this.f_f89a85bd++;
   }

   protected void m_23674f64() {
      if (this.f_45f14763.isEmpty()) {
         this.f_2febc829 = true;
      } else {
         this.m_fd4438d8();
      }
   }

   public abstract T m_7fca7b89();

   public abstract T m_65556734();

   public abstract T m_ac6eac3b();

   public T m_79dad534(Consumer<Long> var1) {
      this.f_45f14763.add(var1);
      return (T)this;
   }

   public T m_dbd72d79(Consumer<Long> var1) {
      this.f_45f14763.add(0, var1);
      return (T)this;
   }

   public void m_46938bdb(int var1) {
      this.f_671a49fc = var1;
   }

   public void m_7c7fe86a(int var1) {
      this.f_f89a85bd = var1;
   }

   public boolean m_f21a055b() {
      return this.f_2febc829;
   }
}
