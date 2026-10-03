package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventEntityUpdated;
import me.deftware.client.framework.event.events.EventEntityUpdated.Change;
import me.deftware.client.framework.world.ClientWorld;

public class C0357 extends AbstractMod {
   @C0098("Removed")
   private String f_fbd27063 = C0255.m_88726494();
   @C0098("Added")
   private String f_0af27121 = C0255.m_27479cfa();

   public C0357() {
      super(C0255.m_73708dd3(), C0290.f_516f3c47, C0255.m_96ba50d4());
   }

   @EventHandler
   public void m_161560b1(EventEntityUpdated var1) {
      if (ClientWorld.getClientWorld() != null) {
         Entity var2 = var1.getEntity();
         if (var2 instanceof EntityPlayer && !var2.isSelf()) {
            C0064.m_13c9ffeb().m_ecf8e7ae(var1.getChange() == Change.Added ? this.f_0af27121 : this.f_fbd27063, var2.getName().string()).m_1058ed9a();
         }
      }
   }
}
