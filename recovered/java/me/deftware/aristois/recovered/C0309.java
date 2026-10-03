package me.deftware.aristois.recovered;

import java.util.function.Supplier;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.network.packets.CPacketPosition;
import me.deftware.client.framework.network.packets.CPacketUseEntity;
import me.deftware.client.framework.network.packets.CPacketUseEntity.Type;

public class C0309 extends AbstractMod {
   public static final double f_d1886cfd = 0.0625;
   public Supplier<Vector3d> f_e132cd6e = C0114.bootstrap<"call",0,1>();

   public C0309() {
      super(C0252.bootstrap<"get",38654705776>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705777>());
   }

   @EventHandler
   public void m_5eedf171(EventPacketSend var1) {
      if (var1.getIPacket() instanceof CPacketUseEntity) {
         CPacketUseEntity var2 = (CPacketUseEntity)var1.getIPacket();
         if (var2.getType() == Type.ATTACK) {
            Vector3d var3 = this.f_e132cd6e.get();
            if (var3 != null) {
               C0114.bootstrap<"call",0,1>(var3);
            }
         }
      }
   }

   public static Supplier<Vector3d> m_895c987c() {
      return () -> ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).getPosition();
   }

   public static void m_bedb5a0d(Vector3d var0) {
      double var1 = var0.getX();
      double var3 = var0.getY();
      double var5 = var0.getZ();
      new CPacketPosition(var1, var3 + 0.0625, var5, false).sendImmediately();
      new CPacketPosition(var1, var3, var5, false).sendImmediately();
   }

   public void m_53820f72(Supplier<Vector3d> var1) {
      this.f_e132cd6e = var1;
   }
}
