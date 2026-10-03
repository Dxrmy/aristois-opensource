package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventFovModifier;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;
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
   private float f_b9819f88 = 0.85F;
   @C0098(
      value = "Damage mode",
      description = {"Applies damage to you before enabling flight, bypasses AC on some servers"}
   )
   private boolean f_efcb9c79 = false;
   @C0098(
      value = "No fov",
      description = {"Disables fov change when flight is enabled"}
   )
   private boolean f_5914b1f0 = true;
   @C0098(
      value = "Stationary Delay",
      description = {"Delay for anti-kick packets in ms when stationary"},
      number = @C0096(
         min = 10.0,
         max = 1000.0
      )
   )
   private int f_7e7efb7b = 500;
   @C0098(
      value = "Moving Delay",
      description = {"Delay for anti-kick packets in ms when moving"},
      number = @C0096(
         min = 10.0,
         max = 1000.0
      )
   )
   private int f_8f84e36d = 400;
   private final double f_d0df4ab4 = 0.0313;
   private volatile long f_71fee5d0 = 0L;
   private double f_478fa8cf = 0.1;
   private double f_e6b25473 = 1.7976931348623157E308;

   public C0375() {
      super(C0259.m_e8fd0250(), C0290.f_829d9b20, C0259.m_d0da63e8());
   }

   @EventHandler
   public void m_b7b03f1f(EventFovModifier var1) {
      if (this.f_5914b1f0) {
         var1.setFov(1.0F);
      }
   }

   @Override
   public void onEnable() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1 != null && this.f_efcb9c79) {
         C0033.m_1521b1fa(1);
      }
   }

   @Override
   public void onDisable() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1 != null) {
         var1.setFlying(false);
         var1.setFlySpeed(0.05F);
      }
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      var2.setFlying(true);
      var2.setFlySpeed(this.f_b9819f88 / 10.0F);
      long var3 = System.currentTimeMillis();
      long var5 = var3 - this.f_71fee5d0;
      if (var5 >= (long)this.f_7e7efb7b && !this.m_0d32d890(var2)) {
         this.f_71fee5d0 = var3;
         CPacketPositionRotation var7 = new CPacketPositionRotation(
            var2.getPosX(), var2.getPosY() - 0.0313, var2.getPosZ(), var2.getRotationYaw(), var2.getRotationPitch(), var2.isOnGround()
         );
         var7.sendImmediately();
      }
   }

   @EventHandler
   private void m_2af6dda6(EventPacketSend var1) {
      MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1.getIPacket() instanceof CPacketPlayer && var2 != null) {
         CPacketPlayer var3 = (CPacketPlayer)var1.getIPacket();
         long var4 = System.currentTimeMillis();
         double var6 = var3.getY(1.7976931348623157E308);
         if (var6 != 1.7976931348623157E308) {
            if (var4 - this.f_71fee5d0 >= (long)this.f_8f84e36d && this.f_e6b25473 != 1.7976931348623157E308 && this.m_0d32d890(var2)) {
               var3.setY(this.f_e6b25473 - 0.0313);
               this.f_71fee5d0 = var4;
               var1.setPacket(var3);
            } else {
               this.f_e6b25473 = var6;
            }
         }
      }
   }

   private boolean m_0d32d890(MainEntityPlayer var1) {
      Vector3d var2 = var1.getVelocity();
      double var3 = Math.abs(var2.getX()) + Math.abs(var2.getY()) + Math.abs(var2.getZ());
      return var3 >= this.f_478fa8cf;
   }
}
