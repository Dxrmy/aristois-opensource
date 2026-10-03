package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventMouseClick;

public class C0350 extends AbstractMod {
   private long f_39f9aed6 = C0114.bootstrap<"call",0,1>();
   private long f_fc5a0795 = 1000L;

   public C0350() {
      super(C0252.bootstrap<"get",47244640300>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640301>());
   }

   @EventHandler
   public void m_f85bbeef(EventMouseClick var1) {
      if (var1.getButton() == 2 && this.f_39f9aed6 + this.f_fc5a0795 < C0114.bootstrap<"call",0,1>()) {
         Entity var2 = C0114.bootstrap<"call",1,1>().getHitEntity();
         if (var2 instanceof EntityPlayer) {
            C0247 var3 = new C0247();
            var3.m_bc6e3984(((EntityPlayer)var2).getUsername());
            if (!C0114.bootstrap<"call",2,1>().contains(var3)) {
               C0114.bootstrap<"call",2,1>().add(var3);
               C0114.bootstrap<"call",3,1>().m_5de8d0b8(C0252.bootstrap<"get",47244640302>(), var3.m_cd751ed2()).m_66e721c0();
            } else {
               C0114.bootstrap<"call",2,1>().remove(var3);
               C0114.bootstrap<"call",3,1>().m_5de8d0b8(C0252.bootstrap<"get",47244640303>(), var3.m_cd751ed2()).m_66e721c0();
            }

            this.f_39f9aed6 = C0114.bootstrap<"call",0,1>();
         }
      }
   }
}
