package me.deftware.aristois.recovered;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.world.ClientWorld;

public class C0369 extends AbstractMod {
   @C0098("Mode")
   private C0102<C0369.anonymousconst> f_fa7c6fff = new C0102<>(C0369.anonymousconst.f_725aa803);
   @C0098("Tracers")
   private boolean f_7790addb = true;
   @C0098(
      value = "Outline",
      description = {"Render ESP boxes around props"}
   )
   private boolean f_a4128dc6 = true;
   @C0098(
      value = "Overlay",
      description = {"View props held items and health (overrides BetterNameTags - entities, if enabled)"}
   )
   private boolean f_e5813656 = false;
   @C0098(
      value = "Max prop health",
      description = {"Maximum prop health to trigger upon (for health mode)"}
   )
   private C0106<Float> f_0252b8be = new C0106<>(20.0F).m_2d6ca2bd(this.f_fa7c6fff, C0369.anonymousconst.f_725aa803);
   private boolean f_12cc08d8 = false;
   private boolean f_959d7333 = false;
   private final LineRenderStack f_a7338d5a = new LineRenderStack();
   private final CubeRenderStack f_33a4e743 = new CubeRenderStack();
   private Collection<Entity> f_b9357764;

   public C0369() {
      super(C0259.m_88726494(), C0290.f_b895465e, C0259.m_27479cfa());
      this.setMode(this.f_fa7c6fff);
   }

   @Override
   public void onDisable() {
      if (this.f_959d7333) {
         C0292 var1 = C0289.m_c3a8b502(C0292.class);
         if (var1 != null) {
            var1.f_de4af376 = this.f_12cc08d8;
         }

         this.f_959d7333 = false;
      }
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (this.f_959d7333 && !this.f_e5813656) {
         C0292 var2 = C0289.m_c3a8b502(C0292.class);
         if (var2 != null) {
            var2.f_de4af376 = this.f_12cc08d8;
         }

         this.f_959d7333 = false;
      }
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      this.f_b9357764 = ClientWorld.getClientWorld()
         .getLoadedEntities()
         .filter(
            var0 -> var0 instanceof LivingEntity
                  && !(var0 instanceof EntityPlayer)
                  && (double)var0.distanceToEntity(Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer())) > 0.25
         )
         .filter(
            var1x -> this.f_fa7c6fff.m_284992ec() == C0369.anonymousconst.f_725aa803 && ((LivingEntity)var1x).getMaxHealth() == this.f_0252b8be.get()
                  ? true
                  : var1x.isInvisible()
                     || ((LivingEntity)var1x).getHealth() < ((LivingEntity)var1x).getMaxHealth()
                     || (this.m_c9f8b9c8(var1x.getPosX(), 5) || this.m_c9f8b9c8(var1x.getPosZ(), 5))
                        && (this.m_c9f8b9c8((double)var1x.getRotationYaw(), 5) || this.m_c9f8b9c8((double)var1x.getRotationPitch(), 5))
                     || !var1x.getEntityHeldItem(false).isEmpty()
                     || !var1x.getEntityHeldItem(true).isEmpty()
         )
         .collect(Collectors.toList());
   }

   @EventHandler
   private void m_4f06bdb8(EventRender3DNoBobbing var1) {
      if (this.f_b9357764 != null && !this.f_b9357764.isEmpty() && this.f_7790addb) {
         RenderStack.setupGl();
         this.f_a7338d5a.begin().glColor(Color.BLUE, 200.0F);
         this.f_b9357764.forEach(this.f_a7338d5a::lineToEntity);
         this.f_a7338d5a.end();
         RenderStack.restoreGl();
      }
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      if (this.f_b9357764 != null) {
         RenderStack.setupGl();
         C0292 var2 = C0289.m_c3a8b502(C0292.class);
         Entity var3 = Minecraft.getMinecraftGame()._getCameraEntity();
         this.f_b9357764.forEach(var4 -> {
            if (var2.isEnabled()) {
               var2.m_9792de99(var4, var1, var3);
            }

            if (this.f_a4128dc6) {
               ((CubeRenderStack)this.f_33a4e743.begin().glColor(Color.magenta, 60.0F)).draw(var4.getBoundingBox()).end();
            }
         });
         RenderStack.restoreGl();
      }
   }

   public boolean m_c9f8b9c8(double var1, int var3) {
      return BigDecimal.valueOf(var1).scale() > var3;
   }

   public static enum anonymousconst {
      f_725aa803,
      f_3c868fcd;

      private anonymousconst() {
      }
   }
}
