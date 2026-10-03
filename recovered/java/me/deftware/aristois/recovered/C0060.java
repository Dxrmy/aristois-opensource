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
   public static final C0060 f_49cf413c = new C0060();
   private final List<Entity> f_1ad4694c = new CopyOnWriteArrayList<>();

   public C0060() {
   }

   @EventHandler
   private void m_5e8001ba(EventWorldLoad var1) {
      this.f_1ad4694c.clear();
   }

   @EventHandler
   private void m_33fc17f9(EventEntityUpdated var1) {
      if (var1.getChange() == Change.Removed) {
         this.f_1ad4694c.remove(var1.getEntity());
      }
   }

   @EventHandler
   private void m_b6d4de10(EventAttackEntity var1) {
      Entity var2 = var1.getTarget();
      if (var2 != null && !this.f_1ad4694c.contains(var2)) {
         this.f_1ad4694c.add(var2);
      }
   }

   public List<Entity> m_fa5df726() {
      return this.f_1ad4694c;
   }
}
