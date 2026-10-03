package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.ray.BlockRayTrace;
import me.deftware.client.framework.world.ray.RayProfile;

public class C0363 extends AbstractMod {
   @C0098(
      value = "Fall distance",
      description = {"Fall distance needed to trigger the mod"}
   )
   private float f_731b52f2 = 8.0F;
   @C0098(
      value = "Toasts",
      description = {"Display toasts when BucketLand executes an action"}
   )
   private boolean f_0974b6d4 = true;
   private boolean f_e8340fa1 = false;

   public C0363() {
      super(C0255.m_7b0db73e(), C0290.f_516f3c47, C0255.m_056a389d());
   }

   private void m_35150f14(boolean var1) {
      this.f_e8340fa1 = var1;
      if (this.f_0974b6d4) {
         C0064.m_13c9ffeb().m_2c2620fc(C0255.m_7b0db73e()).m_ecf8e7ae(C0255.m_5fa6dd07(), var1 ? C0255.m_5f1ab561() : C0255.m_28b2c020()).m_1058ed9a();
      }
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!C0289.m_5caae0c3(C0382.class)
         && !var2.isCreative()
         && ClientWorld.getClientWorld()._getDimension() == 0
         && !this.f_e8340fa1
         && var2.getFallDistance() > this.f_731b52f2) {
         int var3 = C0072.m_17e298ea(C0070.f_f73a314b).m_eb304949();
         if (!C0073.m_aa45d95d(var3)) {
            var3 = C0073.m_f76a4979().m_e1463257(var3).m_b252dc95().m_ac6eac3b().m_eb304949();
         }

         if (var3 != -1 && this.m_09d0a292(var2, -5.0F) != null) {
            this.m_35150f14(true);
            int var4 = var3;
            C0271.f_15eacd20.m_6696523b(var2.getRotationYaw(), 90.0F, 10, () -> {
               this.m_3907084c(var2, var4);
               C0202.f_75b1ba31.m_fde31326(this.f_731b52f2, var2::getFallDistance, () -> C0271.f_15eacd20.m_6696523b(var2.getRotationYaw(), 90.0F, 10, () -> {
                     this.m_3907084c(var2, var4);
                     this.m_35150f14(false);
                  }));
            });
         }
      }
   }

   private BlockSwingResult m_09d0a292(MainEntityPlayer var1, float var2) {
      return new BlockRayTrace(var1.getBlockPosition().getVector(), var1.getBlockPosition().offset(0.0, (double)var2, 0.0).getVector(), RayProfile.Block)
         .run(var1);
   }

   private void m_3907084c(MainEntityPlayer var1, int var2) {
      C0073.anonymousboolean var3 = C0073.m_72cafc8a().m_7c42e94f(var2).m_ac6eac3b();
      var1.processRightClick(var2 == 45);
      var3.m_743d7fa3();
   }
}
