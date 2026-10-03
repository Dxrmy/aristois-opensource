package me.deftware.aristois.recovered;

import java.util.List;
import java.util.stream.Collectors;
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
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;

public class C0300 extends AbstractMod {
   private static final long f_dbeadfdd = 16L;
   @C0098(
      value = "Persistence",
      description = {"How strongly it should nudge your aim"},
      number = @C0096(
         min = 0.0,
         max = 15.0,
         percentage = true
      )
   )
   protected double f_5e0bc193 = 5.0;
   @C0098(
      value = "Min Angle",
      description = {"Min angle from your target to nudge"},
      number = @C0096(
         min = 0.1,
         max = 2.0
      )
   )
   protected double f_2fc6cb2d = 0.25;
   @C0098(
      value = "Lock Angle",
      description = {"Angle from target required to lock on"},
      number = @C0096(
         min = 5.0,
         max = 30.0
      )
   )
   protected double f_02a73ab0 = 10.0;
   @C0098(
      value = "Drop Distance",
      description = {"Distance from target to drop them"},
      number = @C0096(
         min = 5.0,
         max = 30.0
      )
   )
   protected double f_389c95dc = 8.0;
   @C0098(
      value = "Drop Angle",
      description = {"Angle from target to drop them"},
      number = @C0096(
         min = 10.0,
         max = 45.0
      )
   )
   protected double f_f04b882b = 30.0;
   @C0098(
      value = "Smooth",
      description = {"Smooth aiming"}
   )
   protected boolean f_556833a6 = true;
   @C0098(
      value = "Held Key",
      description = {"Require holding a key to trigger"}
   )
   protected C0245 f_6d436bb5 = new C0245();
   private long f_892f1eac;
   protected C0301 f_2f814197;

   public C0300(String var1, C0290 var2, String... var3) {
      super(var1, var2, var3);
   }

   public C0300() {
      super(C0263.m_11f0c704(), C0290.f_4b7b2d37, C0263.m_19faa493());
   }

   @EventHandler
   protected void m_61059d72(EventUpdate var1) {
      MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
      if (this.f_2f814197 == null && this.m_275ab222()) {
         float var3 = (Float)GameMap.INSTANCE.get(GameKeys.BLOCK_REACH_DISTANCE, 5.0F);
         List var4 = ClientWorld.getClientWorld()
            .getLoadedEntities()
            .filter(var0 -> var0 instanceof LivingEntity)
            .filter(var0 -> !var0.isSelf())
            .filter(var2x -> var2x.distanceToEntity(var2) < var3)
            .collect(Collectors.toList());
         C0301 var5 = new C0301(this.f_2fc6cb2d, this.f_5e0bc193, this.f_f04b882b, this.f_389c95dc, this.f_556833a6);

         for (Entity var7 : var4) {
            var5.m_76e16abf((LivingEntity)var7);
            if (var5.m_d42f3372() < this.f_02a73ab0) {
               this.f_2f814197 = var5;
               break;
            }
         }
      }
   }

   @EventHandler
   private void m_c738343e(EventRender3D var1) {
      long var2 = System.currentTimeMillis() - this.f_892f1eac;
      if (var2 > 16L && this.f_2f814197 != null) {
         this.f_892f1eac = System.currentTimeMillis();
         this.f_2f814197.m_1058ed9a();
         if (this.f_2f814197.m_89e0519f()) {
            this.f_2f814197.m_b728afce();
         } else {
            this.f_2f814197 = null;
         }
      }
   }

   protected boolean m_275ab222() {
      return this.f_6d436bb5.m_9362a920() ? this.f_6d436bb5.m_aa45d95d(C0190.m_5b3d3148()) : true;
   }

   @Override
   public String getDisplayMode() {
      if (this.f_2f814197 == null) {
         return C0263.m_a55b07ff();
      } else {
         String var1 = this.f_2f814197.m_aa8edb9c().getName().string();
         if (this.f_2f814197.m_aa8edb9c() instanceof EntityPlayer) {
            var1 = ((EntityPlayer)this.f_2f814197.m_aa8edb9c()).getUsername();
         }

         return String.format(C0263.m_16315846(), var1, this.f_2f814197.m_d42f3372());
      }
   }
}
