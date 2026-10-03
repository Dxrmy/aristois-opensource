package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0389 extends AbstractMod {
   @C0098(
      value = "Riding speed",
      number = @C0096(
         min = 0.5
      )
   )
   public float f_071bc97d = 5.0F;
   @C0098(
      value = "Walk speed",
      number = @C0096(
         min = 0.5,
         max = 2.0
      )
   )
   private float f_d376cc8b = 0.4F;
   @C0098("Apply for entities")
   private boolean f_58a96425 = true;
   @C0098(
      value = "AutoDisable",
      description = {"Automatically pause speed while sneaking"}
   )
   private boolean f_a9ea00eb = true;

   public C0389() {
      super(C0265.m_35cdaa1a(), C0290.f_829d9b20, C0259.m_83f6dd00());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!MinecraftKeyBind.SNEAK.isPressed() || this.f_a9ea00eb) {
         if (this.f_58a96425) {
            Entity var3 = var2.getVehicle();
            if (var3 != null) {
               this.m_256bea62(var3, var2, this.f_071bc97d / 2.0F);
            }
         }

         if (!var2.isRiding()) {
            this.m_256bea62(var2, var2, this.f_d376cc8b);
         }
      }
   }

   private void m_256bea62(Entity var1, MainEntityPlayer var2, float var3) {
      float var4 = var2.getRotationYaw();
      double var5 = var2.getForward();
      double var7 = var2.getStrafe();
      if (var5 == 0.0 && var7 == 0.0) {
         var1.setVelocity(0.0, var1.getVelocity().getY(), 0.0);
      } else {
         if (var5 != 0.0) {
            if (var7 > 0.0) {
               var4 += (float)(var5 > 0.0 ? -45 : 45);
            } else if (var7 < 0.0) {
               var4 += (float)(var5 > 0.0 ? 45 : -45);
            }

            var7 = 0.0;
            if (var5 > 0.0) {
               var5 = 1.0;
            } else if (var5 < 0.0) {
               var5 = -1.0;
            }
         }

         var1.setVelocity(
            var5 * (double)var3 * Math.cos((double)((float)Math.toRadians((double)(var4 + 90.0F))))
               + var7 * (double)var3 * Math.sin((double)((float)Math.toRadians((double)(var4 + 90.0F)))),
            var1.getVelocity().getY(),
            var5 * (double)var3 * Math.sin((double)((float)Math.toRadians((double)(var4 + 90.0F))))
               - var7 * (double)var3 * Math.cos((double)((float)Math.toRadians((double)(var4 + 90.0F))))
         );
      }
   }
}
