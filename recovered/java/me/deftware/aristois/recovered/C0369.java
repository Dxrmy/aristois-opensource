package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Collection;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.LineRenderStack;

public class C0369 extends AbstractMod {
   @C0098("Mode")
   private C0102<C0369.anonymousconst> f_007be751 = new C0102<>(C0369.anonymousconst.f_9634bc4e);
   @C0098("Tracers")
   private boolean f_c84e120e = true;
   @C0098(
      value = "Outline",
      description = {"Render ESP boxes around props"}
   )
   private boolean f_0535131e = true;
   @C0098(
      value = "Overlay",
      description = {"View props held items and health (overrides BetterNameTags - entities, if enabled)"}
   )
   private boolean f_dd1bbbf2 = false;
   @C0098(
      value = "Max prop health",
      description = {"Maximum prop health to trigger upon (for health mode)"}
   )
   private C0106<Float> f_5707175e = new C0106<>(C0114.bootstrap<"call",0,1>(20.0F)).m_10caee7d(this.f_007be751, C0369.anonymousconst.f_9634bc4e);
   private boolean f_19bdf6cd = false;
   private boolean f_5723e840 = false;
   private final LineRenderStack f_d762ff42 = new LineRenderStack();
   private final CubeRenderStack f_1d64e0a0 = new CubeRenderStack();
   private Collection<Entity> f_606a6dcd;

   public C0369() {
      super(C0252.bootstrap<"get",42949673013>(), C0290.f_d6bd3b90, C0252.bootstrap<"get",42949673014>());
      this.setMode(this.f_007be751);
   }

   @Override
   public void onDisable() {
      if (this.f_5723e840) {
         C0292 var1 = (C0292)C0114.bootstrap<"call",0,1>(C0292.class);
         if (var1 != null) {
            var1.f_4719d731 = this.f_19bdf6cd;
         }

         this.f_5723e840 = false;
      }
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (this.f_5723e840 && !this.f_dd1bbbf2) {
         C0292 var2 = (C0292)C0114.bootstrap<"call",0,1>(C0292.class);
         if (var2 != null) {
            var2.f_4719d731 = this.f_19bdf6cd;
         }

         this.f_5723e840 = false;
      }
   }

   @EventHandler
   private void m_a4770983(EventUpdate var1) {
      this.f_606a6dcd = C0114.bootstrap<"call",0,1>()
         .getLoadedEntities()
         .filter(
            var0 -> var0 instanceof LivingEntity
                  && !(var0 instanceof EntityPlayer)
                  && (double)var0.distanceToEntity((Entity)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())) > 0.25
         )
         .filter(
            var1x -> this.f_007be751.m_e2691446() == C0369.anonymousconst.f_9634bc4e && ((LivingEntity)var1x).getMaxHealth() == this.f_5707175e.get()
                  ? true
                  : var1x.isInvisible()
                     || ((LivingEntity)var1x).getHealth() < ((LivingEntity)var1x).getMaxHealth()
                     || (this.m_0a670550(var1x.getPosX(), 5) || this.m_0a670550(var1x.getPosZ(), 5))
                        && (this.m_0a670550((double)var1x.getRotationYaw(), 5) || this.m_0a670550((double)var1x.getRotationPitch(), 5))
                     || !var1x.getEntityHeldItem(false).isEmpty()
                     || !var1x.getEntityHeldItem(true).isEmpty()
         )
         .collect(C0114.bootstrap<"call",1,1>());
   }

   @EventHandler
   private void m_9a984a4f(EventRender3DNoBobbing var1) {
      if (this.f_606a6dcd != null && !this.f_606a6dcd.isEmpty() && this.f_c84e120e) {
         C0114.bootstrap<"call",2,1>();
         this.f_d762ff42.begin().glColor(Color.BLUE, 200.0F);
         this.f_606a6dcd.forEach(this.f_d762ff42::lineToEntity);
         this.f_d762ff42.end();
         C0114.bootstrap<"call",3,1>();
      }
   }

   @EventHandler
   public void m_9bea75bd(EventRender3D var1) {
      if (this.f_606a6dcd != null) {
         C0114.bootstrap<"call",2,1>();
         C0292 var2 = (C0292)C0114.bootstrap<"call",4,1>(C0292.class);
         Entity var3 = C0114.bootstrap<"call",5,1>()._getCameraEntity();
         this.f_606a6dcd.forEach(var4 -> {
            if (var2.isEnabled()) {
               var2.m_38927d23(var4, var1, var3);
            }

            if (this.f_0535131e) {
               ((CubeRenderStack)this.f_1d64e0a0.begin().glColor(Color.magenta, 60.0F)).draw(var4.getBoundingBox()).end();
            }
         });
         C0114.bootstrap<"call",3,1>();
      }
   }

   public boolean m_0a670550(double var1, int var3) {
      return C0114.bootstrap<"call",6,1>(var1).scale() > var3;
   }

   public static enum anonymousconst {
      f_9634bc4e,
      f_617bbbef;

      private anonymousconst() {
      }
   }
}
