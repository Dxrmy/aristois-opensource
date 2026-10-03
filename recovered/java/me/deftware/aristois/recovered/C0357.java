package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventEntityUpdated;
import me.deftware.client.framework.event.events.EventEntityUpdated.Change;

public class C0357 extends AbstractMod {
   @C0098("Removed")
   private String f_8c634636 = C0252.bootstrap<"get",51539607605>();
   @C0098("Added")
   private String f_5ac24b1f = C0252.bootstrap<"get",51539607606>();

   public C0357() {
      super(C0252.bootstrap<"get",51539607603>(), C0290.f_faada303, C0252.bootstrap<"get",51539607604>());
   }

   @EventHandler
   public void m_c59f765c(EventEntityUpdated var1) {
      if (C0114.bootstrap<"call",0,1>() != null) {
         Entity var2 = var1.getEntity();
         if (var2 instanceof EntityPlayer && !var2.isSelf()) {
            C0114.bootstrap<"call",1,1>()
               .m_5de8d0b8(var1.getChange() == Change.Added ? this.f_5ac24b1f : this.f_8c634636, var2.getName().string())
               .m_66e721c0();
         }
      }
   }
}
