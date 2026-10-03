package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.ray.BlockRayTrace;
import me.deftware.client.framework.world.ray.RayProfile;

public class C0363 extends AbstractMod {
   @C0098(
      value = "Fall distance",
      description = {"Fall distance needed to trigger the mod"}
   )
   private float f_3d4142e0 = 8.0F;
   @C0098(
      value = "Toasts",
      description = {"Display toasts when BucketLand executes an action"}
   )
   private boolean f_d96d9a84 = true;
   private boolean f_68a7f9c0 = false;

   public C0363() {
      super(C0252.bootstrap<"get",51539607578>(), C0290.f_faada303, C0252.bootstrap<"get",51539607579>());
   }

   private void m_27f65ce1(boolean var1) {
      this.f_68a7f9c0 = var1;
      if (this.f_d96d9a84) {
         C0114.bootstrap<"call",0,1>()
            .m_6b4e8235(C0252.bootstrap<"get",51539607578>())
            .m_5de8d0b8(C0252.bootstrap<"get",51539607580>(), var1 ? C0252.bootstrap<"get",51539607581>() : C0252.bootstrap<"get",51539607582>())
            .m_66e721c0();
      }
   }

   @EventHandler
   private void m_59d4fa65(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!C0114.bootstrap<"call",2,1>(C0382.class)
         && !var2.isCreative()
         && C0114.bootstrap<"call",3,1>()._getDimension() == 0
         && !this.f_68a7f9c0
         && var2.getFallDistance() > this.f_3d4142e0) {
         int var3 = C0114.bootstrap<"call",4,1>(C0070.f_4a80234a).m_a0aa8556();
         if (!C0114.bootstrap<"call",5,1>(var3)) {
            var3 = ((C0073.anonymousdefault)((C0073.anonymousdefault)((C0073.anonymousdefault)C0114.bootstrap<"call",6,1>().m_44d897bb(var3)).m_6a6e19f6())
                  .m_08fa2bad())
               .m_514a3e72();
         }

         if (var3 != -1 && this.m_117fb329(var2, -5.0F) != null) {
            this.m_27f65ce1(true);
            int var4 = var3;
            C0271.f_e53f9422
               .m_13afcfef(
                  var2.getRotationYaw(),
                  90.0F,
                  10,
                  () -> {
                     this.m_59ad5e60(var2, var4);
                     C0202.f_b9f4c1a2
                        .m_32fb977f(
                           C0114.bootstrap<"call",0,1>(this.f_3d4142e0),
                           var2::getFallDistance,
                           () -> C0271.f_e53f9422.m_13afcfef(var2.getRotationYaw(), 90.0F, 10, () -> {
                                 this.m_59ad5e60(var2, var4);
                                 this.m_27f65ce1(false);
                              })
                        );
                  }
               );
         }
      }
   }

   private BlockSwingResult m_117fb329(MainEntityPlayer var1, float var2) {
      return new BlockRayTrace(var1.getBlockPosition().getVector(), var1.getBlockPosition().offset(0.0, (double)var2, 0.0).getVector(), RayProfile.Block)
         .run(var1);
   }

   private void m_59ad5e60(MainEntityPlayer var1, int var2) {
      C0073.anonymousboolean var3 = (C0073.anonymousboolean)((C0073.anonymousboolean)C0114.bootstrap<"call",7,1>().m_b5be4463(var2)).m_eebb0db7();
      var1.processRightClick(var2 == 45);
      var3.m_3eefd8bd();
   }
}
