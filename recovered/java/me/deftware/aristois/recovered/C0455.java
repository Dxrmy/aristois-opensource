package me.deftware.aristois.recovered;

import java.util.Vector;

public class C0455 {
   private Vector<Object> f_5a13096d = new Vector<>();

   public C0455() {
   }

   public void m_360c09fa(Object var1) {
      synchronized (this.f_5a13096d) {
         this.f_5a13096d.addElement(var1);
         this.f_5a13096d.notify();
      }
   }

   public void m_a32b61ee(Object var1) {
      synchronized (this.f_5a13096d) {
         this.f_5a13096d.insertElementAt(var1, 0);
         this.f_5a13096d.notify();
      }
   }

   public Object m_ac6eac3b() {
      Object var1 = null;
      synchronized (this.f_5a13096d) {
         if (this.f_5a13096d.size() == 0) {
            try {
               this.f_5a13096d.wait();
            } catch (InterruptedException var6) {
               return null;
            }
         }

         try {
            var1 = this.f_5a13096d.firstElement();
            this.f_5a13096d.removeElementAt(0);
         } catch (ArrayIndexOutOfBoundsException var5) {
            throw new InternalError(C0262.m_bcef2112());
         }

         return var1;
      }
   }

   public boolean m_9362a920() {
      return this.m_36ffc578() != 0;
   }

   public void m_0e265701() {
      synchronized (this.f_5a13096d) {
         this.f_5a13096d.removeAllElements();
      }
   }

   public int m_36ffc578() {
      return this.f_5a13096d.size();
   }
}
