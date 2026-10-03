package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class C0288<T> {
   protected final List<Consumer<Long>> f_bdab3098 = new ArrayList<>();
   protected int f_81df9b55 = 0;
   protected int f_cfea9234 = 0;
   protected boolean f_53bc5fe8 = false;
   protected long f_80f0a697;
   protected long f_87e4da20;

   public C0288() {
   }

   public abstract boolean m_4babc701();

   public abstract boolean m_3494bce5();

   public void m_ea5f0462() {
      if (this.f_bdab3098.size() > this.f_cfea9234) {
         if (this.f_80f0a697 + (long)this.f_81df9b55 < C0114.bootstrap<"call",0,1>()) {
            this.m_860b8f71();
         }
      } else {
         this.f_53bc5fe8 = true;
      }
   }

   private void m_860b8f71() {
      this.f_bdab3098.get(this.f_cfea9234).accept(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>() - this.f_87e4da20));
      this.f_80f0a697 = C0114.bootstrap<"call",0,1>();
      this.f_cfea9234++;
   }

   protected void m_588d7d73() {
      if (this.f_bdab3098.isEmpty()) {
         this.f_53bc5fe8 = true;
      } else {
         this.m_860b8f71();
      }
   }

   public abstract T m_2c3ee7a1();

   public abstract T m_9bdc4dbf();

   public abstract T m_07cc3ee6();

   public T m_aab9e66a(Consumer<Long> var1) {
      this.f_bdab3098.add(var1);
      return (T)this;
   }

   public T m_e1118411(Consumer<Long> var1) {
      this.f_bdab3098.add(0, var1);
      return (T)this;
   }

   public void m_0a515c36(int var1) {
      this.f_81df9b55 = var1;
   }

   public void m_7a37774b(int var1) {
      this.f_cfea9234 = var1;
   }

   public boolean m_d0c3020f() {
      return this.f_53bc5fe8;
   }
}
