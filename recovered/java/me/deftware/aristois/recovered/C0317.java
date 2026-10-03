package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.function.Supplier;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.ItemEntity;
import me.deftware.client.framework.entity.types.objects.ProjectileEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.shader.EntityShader;
import me.deftware.client.framework.world.ClientWorld;

public class C0317 extends C0319<Entity> {
   private static final C0201 f_12e9322c = new C0201(C0260.m_8ccfdf29());
   @C0098("Players")
   private boolean f_e563bf49 = true;
   @C0098(
      value = "Distance",
      description = {"Maximum distance to render ESP"},
      number = @C0096(
         min = 5.0,
         max = 300.0
      )
   )
   private C0106<Integer> f_cc265ae1 = new C0106<>(50).m_cb9291a5(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Line thickness",
      description = {"Thickness of the BoundaryBox line thickness"},
      number = @C0096(
         max = 8.0
      )
   )
   private C0106<Integer> f_f1546682 = new C0106<>(2).m_2d6ca2bd(this.f_e1d988aa, C0319.anonymousabstract.f_cf065721);
   @C0098(
      value = "Render",
      description = {"Render all entities, or those selected"}
   )
   private C0102<C0317.anonymousnew> f_98effef8 = new C0102<>(C0317.anonymousnew.f_060276c3);
   @C0098("Entities")
   private final GuiScreen f_0b79434d = C0217.m_c1fb6c03(null, f_12e9322c);
   @C0098(
      value = "Friend",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_54049685 = new C0106<>(new Color(255, 215, 20, 30)).m_cb9291a5(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Player",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_e368d712 = new C0106<>(new Color(0, 0, 255, 30)).m_cb9291a5(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Hostile",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_fa6a4577 = new C0106<>(new Color(255, 0, 0, 30)).m_cb9291a5(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Neutral",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_fb4c1b4a = new C0106<>(new Color(0, 255, 0, 30)).m_cb9291a5(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   private final CubeRenderStack f_31438dd9 = new CubeRenderStack();

   public C0317() {
      super(C0260.m_ec329d2e(), C0290.f_3210deb7, C0260.m_edf5fb69());
      this.f_c7894f51 = new C0319.anonymousnew<Entity>() {
         @Override
         public Supplier<EntityShader> m_5219c421() {
            return C0242.m_fc1b642c()::m_5100ce60;
         }

         @Override
         public Class<Entity> m_6305e767() {
            return Entity.class;
         }

         public boolean m_97a0a4cb(Entity var1) {
            if (var1 instanceof ItemEntity || var1 instanceof ProjectileEntity) {
               return false;
            } else {
               return var1 instanceof EntityPlayer
                  ? C0317.this.f_e563bf49 && !var1.isSelf()
                  : C0317.f_12e9322c.m_97a0a4cb(var1) || C0317.this.f_98effef8.m_284992ec() == C0317.anonymousnew.f_060276c3;
            }
         }
      };
   }

   private void m_18f145ad(Entity var1) {
      Color var2 = var1.isHostile() ? this.f_fa6a4577.get() : this.f_fb4c1b4a.get();
      if (var1 instanceof EntityPlayer) {
         EntityPlayer var3 = (EntityPlayer)var1;
         if (C0247.m_ee0ef813().stream().anyMatch(var1x -> var1x.m_3d3a8736().equalsIgnoreCase(var3.getUsername()))) {
            var2 = this.f_54049685.get();
         } else {
            var2 = this.f_e368d712.get();
         }
      }

      ((CubeRenderStack)this.f_31438dd9.glColor(var2)).draw(var1.getBoundingBox());
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
      if (var2 != null && !this.m_297cfef6()) {
         RenderStack.setupGl();
         ((CubeRenderStack)this.f_31438dd9.lineWidth((float)this.f_f1546682.get().intValue()))
            .begin(this.f_e1d988aa.m_284992ec() == C0319.anonymousabstract.f_cf065721);
         ClientWorld.getClientWorld()
            .getLoadedEntities()
            .filter(var0 -> !var0.isSelf())
            .filter(var2x -> var2x.distanceToEntity(var2) < (float)this.f_cc265ae1.get().intValue())
            .filter(var1x -> {
               if (var1x instanceof LivingEntity && !(var1x instanceof EntityPlayer)) {
                  return this.f_98effef8.m_284992ec() == C0317.anonymousnew.f_cf9521f8 ? f_12e9322c.m_97a0a4cb(var1x) : true;
               } else {
                  return var1x instanceof EntityPlayer && this.f_e563bf49;
               }
            })
            .forEach(this::m_18f145ad);
         this.f_31438dd9.end();
         RenderStack.restoreGl();
      }
   }

   public static C0201 m_95db1db3() {
      return f_12e9322c;
   }

   public static enum anonymousnew {
      f_060276c3,
      f_cf9521f8;

      private anonymousnew() {
      }
   }
}
