package me.deftware.aristois.recovered;

import java.util.function.Predicate;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRayTrace;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0308 extends C0307<C0308> {
   public C0308() {
      super(C0252.bootstrap<"get",38654705762>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705763>());
   }

   @EventHandler
   public void m_425707c8(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (var2.getCooldown() >= this.f_d8270f1b && C0114.bootstrap<"call",0,1>().isMouseOver()) {
         Entity var3 = C0114.bootstrap<"call",0,1>().getHitEntity();
         Predicate var4 = this.f_b6b74f56.m_3f02d942();
         if (var3 instanceof LivingEntity) {
            LivingEntity var5 = (LivingEntity)var3;
            if (var4.test(var5) && this.f_b6b74f56.m_7507811b(var2, var5)) {
               this.f_a693ca6d = C0114.bootstrap<"call",2,1>();
               var2.attackEntity(var3);
            }
         }
      }
   }

   @EventHandler
   public void m_595e28cb(EventRayTrace var1) {
      if (var1.getEntity().canBeSeenBy((EntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer()))) {
         var1.setCanceled(true);
      }
   }
}
