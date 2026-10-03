package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_9
)
public class C0391 extends AbstractMod {
   @C0098(
      value = "Dampen",
      description = {"Dampen movement when movement key is not pressed"}
   )
   private boolean f_867e871f = false;
   @C0098("Limit speed")
   private boolean f_0d79a5fb = false;
   @C0098(
      value = "LimitSpeed",
      description = {"Set a max elytra speed"},
      number = @C0096(
         min = 0.0,
         max = 100.0
      )
   )
   private float f_214230d0 = 33.5F;

   public C0391() {
      super(C0259.m_b2dd5137(), C0290.f_829d9b20, C0259.m_91e95cb4());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var2.getInventory().hasElytra() && var2.getFlag(7)) {
         Vector3d var3 = var2.getVelocity();
         if (MinecraftKeyBind.JUMP.isPressed() && !CameraEntityMan.isActive()) {
            var3 = var3.add(0.0, 0.08, 0.0);
         } else if (MinecraftKeyBind.SNEAK.isPressed() && !CameraEntityMan.isActive()) {
            var3 = var3.subtract(0.0, 0.04, 0.0);
         } else if (this.f_867e871f) {
            var3 = var3.subtract(0.0, var3.getY(), 0.0);
         }

         float var4 = (float)Math.toRadians((double)var2.getRotationYaw());
         if (MinecraftKeyBind.FORWARD.isPressed() && var2.getPosY() < 256.0 && !CameraEntityMan.isActive()) {
            var3 = var3.add(-(Math.sin((double)var4) * 0.05000000074505806), 0.0, Math.cos((double)var4) * 0.05000000074505806);
         } else if (MinecraftKeyBind.BACK.isPressed() && var2.getPosY() < 256.0 && !CameraEntityMan.isActive()) {
            var3 = var3.add(Math.sin((double)var4) * 0.05000000074505806, 0.0, -(Math.cos((double)var4) * 0.05000000074505806));
         } else if (this.f_867e871f && (!MinecraftKeyBind.FORWARD.isPressed() && !MinecraftKeyBind.BACK.isPressed() || CameraEntityMan.isActive())) {
            var3 = var3.subtract(var3.getX(), 0.0, var3.getZ());
         }

         if (MinecraftKeyBind.RIGHT.isPressed() && var2.getPosY() < 256.0 && !CameraEntityMan.isActive()) {
            var3 = var3.add(-Math.cos((double)var4) * 0.11999999731779099, 0.0, -Math.sin((double)var4) * 0.11999999731779099);
         } else if (MinecraftKeyBind.LEFT.isPressed() && var2.getPosY() < 256.0 && !CameraEntityMan.isActive()) {
            var3 = var3.add(Math.cos((double)var4) * 0.11999999731779099, 0.0, Math.sin((double)var4) * 0.11999999731779099);
         }

         if (this.f_0d79a5fb) {
            double var5 = (double)this.f_214230d0 / (var3.getMagnitude() * 20.0);
            if (var5 < 1.0) {
               var3 = var3.multiply(var5);
            }
         }

         var2.setVelocity(var3);
      }
   }
}
