package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.function.Supplier;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.ItemEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.shader.EntityShader;

public class C0316 extends C0319<Entity> {
   @C0098(
      value = "Distance",
      description = {"Maximum distance to render ESP"},
      number = @C0096(
         min = 5.0,
         max = 300.0
      )
   )
   private C0106<Integer> f_4dfbde9c = new C0106<>(C0114.bootstrap<"call",0,1>(50)).m_6da46a9c(this.f_094b9fa5, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Color",
      description = {"Requires mode to be BoundaryBoxFull or BoundaryBox"}
   )
   private C0106<Color> f_60a6d094 = new C0106<>(new Color(255, 100, 0, 30)).m_6da46a9c(this.f_094b9fa5, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Line thickness",
      description = {"Thickness of the BoundaryBox line thickness"},
      number = @C0096(
         max = 8.0
      )
   )
   private C0106<Integer> f_8d379e5f = new C0106<>(C0114.bootstrap<"call",0,1>(2)).m_10caee7d(this.f_094b9fa5, C0319.anonymousabstract.f_5ab2c155);
   private final CubeRenderStack f_59ee716d = new CubeRenderStack();

   public C0316() {
      super(C0252.bootstrap<"get",47244640357>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640358>());
      this.f_1e081d4e = new C0319.anonymousnew<Entity>() {
         public Supplier<EntityShader> m_fa98e4ae() {
            return C0114.bootstrap<"call",0,1>()::m_373a3102;
         }

         public Class<Entity> m_f64754be() {
            return Entity.class;
         }

         public boolean m_0f2fd439(Entity var1) {
            return var1 instanceof ItemEntity;
         }
      };
   }

   @EventHandler
   public void m_506517ac(EventRender3D var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var2 != null && !this.m_0cea6d97()) {
         C0114.bootstrap<"call",1,1>();
         ((CubeRenderStack)this.f_59ee716d.lineWidth((float)this.f_8d379e5f.get().intValue()))
            .begin(this.f_094b9fa5.m_e2691446() == C0319.anonymousabstract.f_5ab2c155)
            .glColor(this.f_60a6d094.get());
         C0114.bootstrap<"call",2,1>()
            .getLoadedEntities()
            .filter(var0 -> var0 instanceof ItemEntity)
            .filter(var2x -> var2x.distanceToEntity(var2) < (float)this.f_4dfbde9c.get().intValue())
            .forEach(var1x -> this.f_59ee716d.draw(var1x.getBoundingBox()));
         this.f_59ee716d.end();
         C0114.bootstrap<"call",3,1>();
      }
   }

   public C0106<Integer> m_ac4405db() {
      return this.f_4dfbde9c;
   }

   public C0106<Color> m_3347462a() {
      return this.f_60a6d094;
   }

   public C0106<Integer> m_9d0f6d99() {
      return this.f_8d379e5f;
   }

   public CubeRenderStack m_ddb2c6a1() {
      return this.f_59ee716d;
   }
}
