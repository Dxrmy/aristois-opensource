package me.deftware.aristois.recovered;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.network.PacketWrapper;

public class C0273<T extends C0273.anonymouscatch<?>> extends EventListener {
   protected final Queue<T> f_0cb89766 = new LinkedBlockingQueue<>();
   protected int f_f31fe77a = 0;
   protected int f_ba342814 = 0;

   public C0273() {
   }

   @EventHandler
   public void m_2cc0cd15(EventUpdate var1) {
      this.f_f31fe77a++;
   }

   public void m_0ee479e0(T var1) {
      this.f_0cb89766.add((T)var1);
   }

   public T m_d8b68e94() {
      return this.f_0cb89766.poll();
   }

   public void m_59b9aae8() {
      if (this.m_047fbb1d()) {
         C0273.anonymouscatch var1 = this.m_d8b68e94();
         if (var1 != null) {
            var1.m_91465ff7();
            var1.run();
            if (var1.m_fc69e37a() == -1) {
               this.m_59b9aae8();
            } else {
               this.f_ba342814 = var1.m_fc69e37a();
            }
         } else {
            this.f_ba342814 = 0;
         }

         this.f_f31fe77a = 0;
      }
   }

   public int m_a149fd85() {
      return this.f_0cb89766.size();
   }

   public boolean m_047fbb1d() {
      return this.f_f31fe77a >= this.f_ba342814;
   }

   public boolean m_34ee7431() {
      return this.m_047fbb1d() && this.f_0cb89766.isEmpty();
   }

   public int m_9348f2a3() {
      return this.f_f31fe77a;
   }

   public int m_a0e62b2e() {
      return this.f_ba342814;
   }

   public interface anonymouscatch<T extends PacketWrapper> extends Runnable {
      void m_91465ff7();

      int m_fc69e37a();
   }
}
