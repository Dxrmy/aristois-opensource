package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketUseEntity;
import me.deftware.client.framework.network.packets.CPacketUseEntity.Type;

public class C0417 extends AbstractMod {
   @C0098(
      value = "Swap",
      description = {"Swap weapons from your inventory to your hotbar"}
   )
   private boolean f_995eae11 = false;
   @C0098(
      value = "Cancel",
      description = {"Cancel first hit when switching weapon", "and automatically hit when the cooldown is complete"}
   )
   private boolean f_a50d982d = false;
   private Entity f_cf954d5d;
   private final C0072 f_7b42267c = C0072.m_c6050a72();

   public C0417() {
      super(C0263.m_d0e43f69(), C0290.f_4b7b2d37, C0263.m_812ab029());
   }

   @EventHandler
   private void m_2af6dda6(EventPacketSend var1) {
      if (var1.getIPacket() instanceof CPacketUseEntity) {
         CPacketUseEntity var2 = (CPacketUseEntity)var1.getIPacket();
         if (var2.getType() == Type.ATTACK && this.m_275ab222() && this.f_a50d982d) {
            this.f_cf954d5d = Minecraft.getMinecraftGame().getHitEntity();
            var1.setCanceled(true);
         }
      }
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (this.f_cf954d5d != null && (double)var2.getCooldown() >= 0.8) {
         C0218.m_1878c38f(var2, this.f_cf954d5d, () -> {
            var2.attackEntity(this.f_cf954d5d);
            this.f_cf954d5d = null;
         });
      }
   }

   public boolean m_275ab222() {
      MainEntityPlayer var1 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      int var2 = this.f_7b42267c.m_eb304949();
      if (!C0073.m_aa45d95d(var2) && !this.f_995eae11) {
         var2 = this.f_7b42267c.m_b8bdb7ac();
      }

      if (var2 != -1) {
         if (!C0073.m_aa45d95d(var2)) {
            if (Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen) {
               return false;
            }

            C0073.anonymousdefault var3 = C0073.m_f76a4979().m_e1463257(var2).m_b252dc95();
            var2 = var3.m_eb304949();
            var3.m_ac6eac3b();
         }

         if (!C0073.m_9c54ac1f(var1, var2)) {
            C0073.m_72cafc8a().m_7c42e94f(var2).m_ac6eac3b();
            return true;
         }
      }

      return false;
   }
}
