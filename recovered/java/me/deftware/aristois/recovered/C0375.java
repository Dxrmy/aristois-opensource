package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventFovModifier;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.network.packets.CPacketPlayer;
import me.deftware.client.framework.network.packets.CPacketPositionRotation;

@C0421
public class C0375 extends AbstractMod {
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 0.1,
         max = 5.0
      )
   )
   private float f_e1295805 = 0.85F;
   @C0098(
      value = "Damage mode",
      description = {"Applies damage to you before enabling flight, bypasses AC on some servers"}
   )
   private boolean f_a2d2ce6b = false;
   @C0098(
      value = "No fov",
      description = {"Disables fov change when flight is enabled"}
   )
   private boolean f_c74c3ca9 = true;
   @C0098(
      value = "Stationary Delay",
      description = {"Delay for anti-kick packets in ms when stationary"},
      number = @C0096(
         min = 10.0,
         max = 1000.0
      )
   )
   private int f_16d80b2f = 500;
   @C0098(
      value = "Moving Delay",
      description = {"Delay for anti-kick packets in ms when moving"},
      number = @C0096(
         min = 10.0,
         max = 1000.0
      )
   )
   private int f_a089495d = 400;
   private final double f_26a38b01 = 0.0313;
   private volatile long f_6bb33740 = 0L;
   private double f_d1cc201b = 0.1;
   private double f_b92c6747 = 1.7976931348623157E308;

   public C0375() {
      super(C0252.bootstrap<"get",42949673046>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673047>());
   }

   @EventHandler
   public void m_2f23a743(EventFovModifier var1) {
      if (this.f_c74c3ca9) {
         var1.setFov(1.0F);
      }
   }

   @Override
   public void onEnable() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1 != null && this.f_a2d2ce6b) {
         C0114.bootstrap<"call",1,1>(1);
      }
   }

   @Override
   public void onDisable() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1 != null) {
         var1.setFlying(false);
         var1.setFlySpeed(0.05F);
      }
   }

   @EventHandler
   public void m_dbfb6e9b(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      var2.setFlying(true);
      var2.setFlySpeed(this.f_e1295805 / 10.0F);
      long var3 = C0114.bootstrap<"call",2,1>();
      long var5 = var3 - this.f_6bb33740;
      if (var5 >= (long)this.f_16d80b2f && !this.m_0c68aabb(var2)) {
         this.f_6bb33740 = var3;
         CPacketPositionRotation var7 = new CPacketPositionRotation(
            var2.getPosX(), var2.getPosY() - 0.0313, var2.getPosZ(), var2.getRotationYaw(), var2.getRotationPitch(), var2.isOnGround()
         );
         var7.sendImmediately();
      }
   }

   @EventHandler
   private void m_4a5b293e(EventPacketSend var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1.getIPacket() instanceof CPacketPlayer && var2 != null) {
         CPacketPlayer var3 = (CPacketPlayer)var1.getIPacket();
         long var4 = C0114.bootstrap<"call",2,1>();
         double var6 = var3.getY(1.7976931348623157E308);
         if (var6 != 1.7976931348623157E308) {
            if (var4 - this.f_6bb33740 >= (long)this.f_a089495d && this.f_b92c6747 != 1.7976931348623157E308 && this.m_0c68aabb(var2)) {
               var3.setY(this.f_b92c6747 - 0.0313);
               this.f_6bb33740 = var4;
               var1.setPacket(var3);
            } else {
               this.f_b92c6747 = var6;
            }
         }
      }
   }

   private boolean m_0c68aabb(MainEntityPlayer var1) {
      Vector3d var2 = var1.getVelocity();
      double var3 = C0114.bootstrap<"call",3,1>(var2.getX()) + C0114.bootstrap<"call",3,1>(var2.getY()) + C0114.bootstrap<"call",3,1>(var2.getZ());
      return var3 >= this.f_d1cc201b;
   }
}
