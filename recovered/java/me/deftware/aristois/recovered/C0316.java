package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.function.Supplier;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.ItemEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.shader.EntityShader;
import me.deftware.client.framework.world.ClientWorld;

public class C0316 extends C0319<Entity> {
   @C0098(
      value = "Distance",
      description = {"Maximum distance to render ESP"},
      number = @C0096(
         min = 5.0,
         max = 300.0
      )
   )
   private C0106<Integer> f_c764e4a6 = new C0106<>(50).m_cb9291a5(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Color",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_0c0a14ad = new C0106<>(new Color(255, 100, 0, 30)).m_cb9291a5(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Line thickness",
      description = {"Thickness of the BoundaryBox line thickness"},
      number = @C0096(
         max = 8.0
      )
   )
   private C0106<Integer> f_cf1f2a4b = new C0106<>(2).m_2d6ca2bd(this.f_e1d988aa, C0319.anonymousabstract.f_cf065721);
   private final CubeRenderStack f_42a76a9d = new CubeRenderStack();

   public C0316() {
      super(C0260.m_0223faff(), C0290.f_3210deb7, C0260.m_bdbd5e40());
      this.f_c7894f51 = new C0319.anonymousnew<Entity>() {
         @Override
         public Supplier<EntityShader> m_5219c421() {
            return C0242.m_fc1b642c()::m_b0a87172;
         }

         @Override
         public Class<Entity> m_6305e767() {
            return Entity.class;
         }

         public boolean m_97a0a4cb(Entity var1) {
            return var1 instanceof ItemEntity;
         }
      };
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
      if (var2 != null && !this.m_297cfef6()) {
         RenderStack.setupGl();
         ((CubeRenderStack)this.f_42a76a9d.lineWidth((float)this.f_cf1f2a4b.get().intValue()))
            .begin(this.f_e1d988aa.m_284992ec() == C0319.anonymousabstract.f_cf065721)
            .glColor(this.f_0c0a14ad.get());
         ClientWorld.getClientWorld()
            .getLoadedEntities()
            .filter(var0 -> var0 instanceof ItemEntity)
            .filter(var2x -> var2x.distanceToEntity(var2) < (float)this.f_c764e4a6.get().intValue())
            .forEach(var1x -> this.f_42a76a9d.draw(var1x.getBoundingBox()));
         this.f_42a76a9d.end();
         RenderStack.restoreGl();
      }
   }

   public C0106<Integer> m_a90174f5() {
      return this.f_c764e4a6;
   }

   public C0106<Color> m_2d3b19b0() {
      return this.f_0c0a14ad;
   }

   public C0106<Integer> m_d9b52e21() {
      return this.f_cf1f2a4b;
   }

   public CubeRenderStack m_c7f7164e() {
      return this.f_42a76a9d;
   }
}
