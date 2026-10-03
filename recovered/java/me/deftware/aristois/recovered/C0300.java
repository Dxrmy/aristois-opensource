package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0300 extends AbstractMod {
   private static final long f_6c51dd15 = 16L;
   @C0098(
      value = "Persistence",
      description = {"How strongly it should nudge your aim"},
      number = @C0096(
         min = 0.0,
         max = 15.0,
         percentage = true
      )
   )
   protected double f_7435adea = 5.0;
   @C0098(
      value = "Min Angle",
      description = {"Min angle from your target to nudge"},
      number = @C0096(
         min = 0.1,
         max = 2.0
      )
   )
   protected double f_bed4bacb = 0.25;
   @C0098(
      value = "Lock Angle",
      description = {"Angle from target required to lock on"},
      number = @C0096(
         min = 5.0,
         max = 30.0
      )
   )
   protected double f_09e99f04 = 10.0;
   @C0098(
      value = "Drop Distance",
      description = {"Distance from target to drop them"},
      number = @C0096(
         min = 5.0,
         max = 30.0
      )
   )
   protected double f_29aeb72c = 8.0;
   @C0098(
      value = "Drop Angle",
      description = {"Angle from target to drop them"},
      number = @C0096(
         min = 10.0,
         max = 45.0
      )
   )
   protected double f_f0c58836 = 30.0;
   @C0098(
      value = "Smooth",
      description = {"Smooth aiming"}
   )
   protected boolean f_6b321567 = true;
   @C0098(
      value = "Held Key",
      description = {"Require holding a key to trigger"}
   )
   protected C0245 f_7740f847 = new C0245();
   private long f_6b494e12;
   protected C0301 f_31ab51b7;

   public C0300(String var1, C0290 var2, String... var3) {
      super(var1, var2, var3);
   }

   public C0300() {
      super(C0252.bootstrap<"get",38654705746>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705747>());
   }

   @EventHandler
   protected void m_550e6fbc(EventUpdate var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (this.f_31ab51b7 == null && this.m_d89e54e9()) {
         float var3 = (Float)GameMap.INSTANCE.get(GameKeys.BLOCK_REACH_DISTANCE, C0114.bootstrap<"call",1,1>(5.0F));
         List var4 = C0114.bootstrap<"call",2,1>()
            .getLoadedEntities()
            .filter(var0 -> var0 instanceof LivingEntity)
            .filter(var0 -> !var0.isSelf())
            .filter(var2x -> var2x.distanceToEntity(var2) < var3)
            .collect(C0114.bootstrap<"call",3,1>());
         C0301 var5 = new C0301(this.f_bed4bacb, this.f_7435adea, this.f_f0c58836, this.f_29aeb72c, this.f_6b321567);

         for (Entity var7 : var4) {
            var5.m_cdb42d6f((LivingEntity)var7);
            if (var5.m_1dcda4b1() < this.f_09e99f04) {
               this.f_31ab51b7 = var5;
               break;
            }
         }
      }
   }

   @EventHandler
   private void m_a7d26809(EventRender3D var1) {
      long var2 = C0114.bootstrap<"call",0,1>() - this.f_6b494e12;
      if (var2 > 16L && this.f_31ab51b7 != null) {
         this.f_6b494e12 = C0114.bootstrap<"call",0,1>();
         this.f_31ab51b7.m_5169054f();
         if (this.f_31ab51b7.m_abaf9b26()) {
            this.f_31ab51b7.m_0e2773ce();
         } else {
            this.f_31ab51b7 = null;
         }
      }
   }

   protected boolean m_d89e54e9() {
      return this.f_7740f847.m_9bec5cd2() ? this.f_7740f847.m_a3b35090(C0114.bootstrap<"call",0,1>()) : true;
   }

   @Override
   public String getDisplayMode() {
      if (this.f_31ab51b7 == null) {
         return C0252.bootstrap<"get",38654705748>();
      } else {
         String var1 = this.f_31ab51b7.m_cfbd0f4e().getName().string();
         if (this.f_31ab51b7.m_cfbd0f4e() instanceof EntityPlayer) {
            var1 = ((EntityPlayer)this.f_31ab51b7.m_cfbd0f4e()).getUsername();
         }

         return C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",38654705749>(), new Object[]{var1, C0114.bootstrap<"call",0,1>(this.f_31ab51b7.m_1dcda4b1())});
      }
   }
}
