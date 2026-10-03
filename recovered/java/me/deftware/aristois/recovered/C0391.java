package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.math.vector.Vector3d;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_9
)
public class C0391 extends AbstractMod {
   @C0098(
      value = "Dampen",
      description = {"Dampen movement when movement key is not pressed"}
   )
   private boolean f_448e54ed = false;
   @C0098("Limit speed")
   private boolean f_b1a974ab = false;
   @C0098(
      value = "LimitSpeed",
      description = {"Set a max elytra speed"},
      number = @C0096(
         min = 0.0,
         max = 100.0
      )
   )
   private float f_b67dabc4 = 33.5F;

   public C0391() {
      super(C0252.bootstrap<"get",42949673035>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673036>());
   }

   @EventHandler
   public void m_9de8a019(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (var2.getInventory().hasElytra() && var2.getFlag(7)) {
         Vector3d var3 = var2.getVelocity();
         if (MinecraftKeyBind.JUMP.isPressed() && !C0114.bootstrap<"call",2,1>()) {
            var3 = var3.add(0.0, 0.08, 0.0);
         } else if (MinecraftKeyBind.SNEAK.isPressed() && !C0114.bootstrap<"call",2,1>()) {
            var3 = var3.subtract(0.0, 0.04, 0.0);
         } else if (this.f_448e54ed) {
            var3 = var3.subtract(0.0, var3.getY(), 0.0);
         }

         float var4 = (float)C0114.bootstrap<"call",3,1>((double)var2.getRotationYaw());
         if (MinecraftKeyBind.FORWARD.isPressed() && var2.getPosY() < 256.0 && !C0114.bootstrap<"call",2,1>()) {
            var3 = var3.add(
               -(C0114.bootstrap<"call",4,1>((double)var4) * 0.05000000074505806), 0.0, C0114.bootstrap<"call",5,1>((double)var4) * 0.05000000074505806
            );
         } else if (MinecraftKeyBind.BACK.isPressed() && var2.getPosY() < 256.0 && !C0114.bootstrap<"call",2,1>()) {
            var3 = var3.add(
               C0114.bootstrap<"call",4,1>((double)var4) * 0.05000000074505806, 0.0, -(C0114.bootstrap<"call",5,1>((double)var4) * 0.05000000074505806)
            );
         } else if (this.f_448e54ed && (!MinecraftKeyBind.FORWARD.isPressed() && !MinecraftKeyBind.BACK.isPressed() || C0114.bootstrap<"call",2,1>())) {
            var3 = var3.subtract(var3.getX(), 0.0, var3.getZ());
         }

         if (MinecraftKeyBind.RIGHT.isPressed() && var2.getPosY() < 256.0 && !C0114.bootstrap<"call",2,1>()) {
            var3 = var3.add(
               -C0114.bootstrap<"call",5,1>((double)var4) * 0.11999999731779099, 0.0, -C0114.bootstrap<"call",4,1>((double)var4) * 0.11999999731779099
            );
         } else if (MinecraftKeyBind.LEFT.isPressed() && var2.getPosY() < 256.0 && !C0114.bootstrap<"call",2,1>()) {
            var3 = var3.add(
               C0114.bootstrap<"call",5,1>((double)var4) * 0.11999999731779099, 0.0, C0114.bootstrap<"call",4,1>((double)var4) * 0.11999999731779099
            );
         }

         if (this.f_b1a974ab) {
            double var5 = (double)this.f_b67dabc4 / (var3.getMagnitude() * 20.0);
            if (var5 < 1.0) {
               var3 = var3.multiply(var5);
            }
         }

         var2.setVelocity(var3);
      }
   }
}
