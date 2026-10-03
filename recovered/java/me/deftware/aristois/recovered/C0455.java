package me.deftware.aristois.recovered;

import java.util.Vector;

public class C0455 {
   private Vector<Object> f_075d3c6c = new Vector<>();

   public C0455() {
   }

   public void m_bd4aa2cc(Object var1) {
      synchronized (this.f_075d3c6c) {
         this.f_075d3c6c.addElement(var1);
         this.f_075d3c6c.notify();
      }
   }

   public void m_141db2f2(Object var1) {
      synchronized (this.f_075d3c6c) {
         this.f_075d3c6c.insertElementAt(var1, 0);
         this.f_075d3c6c.notify();
      }
   }

   public Object m_788048f7() {
      Object var1 = null;
      synchronized (this.f_075d3c6c) {
         if (this.f_075d3c6c.size() == 0) {
            try {
               this.f_075d3c6c.wait();
            } catch (InterruptedException var6) {
               return null;
            }
         }

         try {
            var1 = this.f_075d3c6c.firstElement();
            this.f_075d3c6c.removeElementAt(0);
         } catch (ArrayIndexOutOfBoundsException var5) {
            throw new InternalError(C0252.bootstrap<"get",34359738458>());
         }

         return var1;
      }
   }

   public boolean m_d2ce00a9() {
      return this.m_f3b1fb04() != 0;
   }

   public void m_c5a9a757() {
      synchronized (this.f_075d3c6c) {
         this.f_075d3c6c.removeAllElements();
      }
   }

   public int m_f3b1fb04() {
      return this.f_075d3c6c.size();
   }
}
