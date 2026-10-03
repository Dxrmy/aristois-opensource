package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0322 extends AbstractMod {
   public C0322() {
      super(C0252.bootstrap<"get",47244640382>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640383>());
   }

   @EventHandler
   public void m_2d7a913f(EventUpdate var1) {
      this.m_b24df4c9();
   }

   private void m_b24df4c9() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1 != null) {
         var1.setInPortal(false);
      }
   }
}
