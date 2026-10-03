package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.network.packets.CPacketUseEntity;
import me.deftware.client.framework.network.packets.CPacketUseEntity.Type;

public class C0417 extends AbstractMod {
   @C0098(
      value = "Swap",
      description = {"Swap weapons from your inventory to your hotbar"}
   )
   private boolean f_18132b99 = false;
   @C0098(
      value = "Cancel",
      description = {"Cancel first hit when switching weapon", "and automatically hit when the cooldown is complete"}
   )
   private boolean f_76da5d27 = false;
   private Entity f_132e28b6;
   private final C0072 f_f2280c2f = C0114.bootstrap<"call",0,1>();

   public C0417() {
      super(C0252.bootstrap<"get",38654705744>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705745>());
   }

   @EventHandler
   private void m_1825d611(EventPacketSend var1) {
      if (var1.getIPacket() instanceof CPacketUseEntity) {
         CPacketUseEntity var2 = (CPacketUseEntity)var1.getIPacket();
         if (var2.getType() == Type.ATTACK && this.m_2d7ed8a8() && this.f_76da5d27) {
            this.f_132e28b6 = C0114.bootstrap<"call",0,1>().getHitEntity();
            var1.setCanceled(true);
         }
      }
   }

   @EventHandler
   private void m_5f2c75d0(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (this.f_132e28b6 != null && (double)var2.getCooldown() >= 0.8) {
         C0114.bootstrap<"call",2,1>(var2, this.f_132e28b6, () -> {
            var2.attackEntity(this.f_132e28b6);
            this.f_132e28b6 = null;
         });
      }
   }

   public boolean m_2d7ed8a8() {
      MainEntityPlayer var1 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      int var2 = this.f_f2280c2f.m_a0aa8556();
      if (!C0114.bootstrap<"call",2,1>(var2) && !this.f_18132b99) {
         var2 = this.f_f2280c2f.m_e05ba629();
      }

      if (var2 != -1) {
         if (!C0114.bootstrap<"call",2,1>(var2)) {
            if (C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen) {
               return false;
            }

            C0073.anonymousdefault var3 = (C0073.anonymousdefault)((C0073.anonymousdefault)C0114.bootstrap<"call",3,1>().m_44d897bb(var2)).m_6a6e19f6();
            var2 = var3.m_514a3e72();
            var3.m_08fa2bad();
         }

         if (!C0114.bootstrap<"call",4,1>(var1, var2)) {
            ((C0073.anonymousboolean)C0114.bootstrap<"call",5,1>().m_b5be4463(var2)).m_eebb0db7();
            return true;
         }
      }

      return false;
   }
}
