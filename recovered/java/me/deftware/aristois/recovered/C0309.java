package me.deftware.aristois.recovered;

import java.util.Objects;
import java.util.function.Supplier;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketPosition;
import me.deftware.client.framework.network.packets.CPacketUseEntity;
import me.deftware.client.framework.network.packets.CPacketUseEntity.Type;

public class C0309 extends AbstractMod {
   public static final double f_ae094000 = 0.0625;
   public Supplier<Vector3d> f_83f5db4a = m_ea501eb7();

   public C0309() {
      super(C0263.m_a9b6ecd9(), C0290.f_4b7b2d37, C0263.m_09052c0b());
   }

   @EventHandler
   public void m_2af6dda6(EventPacketSend var1) {
      if (var1.getIPacket() instanceof CPacketUseEntity) {
         CPacketUseEntity var2 = (CPacketUseEntity)var1.getIPacket();
         if (var2.getType() == Type.ATTACK) {
            Vector3d var3 = this.f_83f5db4a.get();
            if (var3 != null) {
               m_ec5cd955(var3);
            }
         }
      }
   }

   public static Supplier<Vector3d> m_ea501eb7() {
      return () -> Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer()).getPosition();
   }

   public static void m_ec5cd955(Vector3d var0) {
      double var1 = var0.getX();
      double var3 = var0.getY();
      double var5 = var0.getZ();
      new CPacketPosition(var1, var3 + 0.0625, var5, false).sendImmediately();
      new CPacketPosition(var1, var3, var5, false).sendImmediately();
   }

   public void m_62395d67(Supplier<Vector3d> var1) {
      this.f_83f5db4a = var1;
   }
}
