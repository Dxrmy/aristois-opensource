package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventMouseClick;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0350 extends AbstractMod {
   private long f_e2cc8e16 = System.currentTimeMillis();
   private long f_f7667a8a = 1000L;

   public C0350() {
      super(C0260.m_6e2d03c3(), C0290.f_99d080af, C0260.m_760db7bb());
   }

   @EventHandler
   public void m_992be57a(EventMouseClick var1) {
      if (var1.getButton() == 2 && this.f_e2cc8e16 + this.f_f7667a8a < System.currentTimeMillis()) {
         Entity var2 = Minecraft.getMinecraftGame().getHitEntity();
         if (var2 instanceof EntityPlayer) {
            C0247 var3 = new C0247();
            var3.m_a11708c5(((EntityPlayer)var2).getUsername());
            if (!C0247.m_ee0ef813().contains(var3)) {
               C0247.m_ee0ef813().add(var3);
               C0064.m_13c9ffeb().m_ecf8e7ae(C0260.m_68957b31(), var3.m_3d3a8736()).m_1058ed9a();
            } else {
               C0247.m_ee0ef813().remove(var3);
               C0064.m_13c9ffeb().m_ecf8e7ae(C0260.m_4e02e7a9(), var3.m_3d3a8736()).m_1058ed9a();
            }

            this.f_e2cc8e16 = System.currentTimeMillis();
         }
      }
   }
}
