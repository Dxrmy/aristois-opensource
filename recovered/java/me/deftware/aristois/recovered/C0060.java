package me.deftware.aristois.recovered;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventAttackEntity;
import me.deftware.client.framework.event.events.EventEntityUpdated;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.event.events.EventEntityUpdated.Change;

public class C0060 {
   public static final C0060 f_4818213b = new C0060();
   private final List<Entity> f_67728d95 = new CopyOnWriteArrayList<>();

   public C0060() {
   }

   @EventHandler
   private void m_270a7d18(EventWorldLoad var1) {
      this.f_67728d95.clear();
   }

   @EventHandler
   private void m_161560b1(EventEntityUpdated var1) {
      if (var1.getChange() == Change.Removed) {
         this.f_67728d95.remove(var1.getEntity());
      }
   }

   @EventHandler
   private void m_1cf877ff(EventAttackEntity var1) {
      Entity var2 = var1.getTarget();
      if (var2 != null && !this.f_67728d95.contains(var2)) {
         this.f_67728d95.add(var2);
      }
   }

   public List<Entity> m_350b5ae0() {
      return this.f_67728d95;
   }
}
