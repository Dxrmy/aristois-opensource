package me.deftware.aristois.recovered;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.network.PacketWrapper;

public class C0273<T extends C0273.anonymouscatch<?>> extends EventListener {
   protected final Queue<T> f_62a020a0 = new LinkedBlockingQueue<>();
   protected int f_e5b1f1d0 = 0;
   protected int f_c67bb039 = 0;

   public C0273() {
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      this.f_e5b1f1d0++;
   }

   public void m_0a42d7e5(T var1) {
      this.f_62a020a0.add((T)var1);
   }

   public T m_cec3adc2() {
      return this.f_62a020a0.poll();
   }

   public void m_b728afce() {
      if (this.m_51ce03a5()) {
         C0273.anonymouscatch var1 = this.m_cec3adc2();
         if (var1 != null) {
            var1.m_0e265701();
            var1.run();
            if (var1.m_8b15b5f4() == -1) {
               this.m_b728afce();
            } else {
               this.f_c67bb039 = var1.m_8b15b5f4();
            }
         } else {
            this.f_c67bb039 = 0;
         }

         this.f_e5b1f1d0 = 0;
      }
   }

   public int m_037208cc() {
      return this.f_62a020a0.size();
   }

   public boolean m_51ce03a5() {
      return this.f_e5b1f1d0 >= this.f_c67bb039;
   }

   public boolean m_e606d819() {
      return this.m_51ce03a5() && this.f_62a020a0.isEmpty();
   }

   public int m_f34ec3cf() {
      return this.f_e5b1f1d0;
   }

   public int m_8b15b5f4() {
      return this.f_c67bb039;
   }

   public interface anonymouscatch<T extends PacketWrapper> extends Runnable {
      void m_0e265701();

      int m_8b15b5f4();
   }
}
