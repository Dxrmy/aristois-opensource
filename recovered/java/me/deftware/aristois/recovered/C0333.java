package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Collection;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.render.batching.LineRenderStack;

public class C0333 extends AbstractMod {
   @C0098(
      value = "Death waypoints",
      description = {"Automatically creates a waypoint when you die"}
   )
   private boolean f_370c1f9b = true;
   @C0098(
      value = "Show tracer",
      description = {"Whether to render a line towards waypoints"}
   )
   private boolean f_4ff9cd67 = true;
   @C0098("Waypoints")
   private final GuiScreen f_55bea296 = new C0186(null);
   private final LineRenderStack f_1fe12757 = new LineRenderStack();
   private Collection<C0244> f_593d7d63;

   public C0333() {
      super(C0252.bootstrap<"get",21474836556>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",51539607570>());
   }

   @EventHandler
   public void m_a905a17c(EventRender3D var1) {
      C0292 var2 = (C0292)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0292.class));
      this.f_593d7d63 = C0114.bootstrap<"call",2,1>().stream().filter(C0244::m_1cfee894).filter(C0244::m_7efa5db3).collect(C0114.bootstrap<"call",3,1>());
      this.f_593d7d63.forEach(var1x -> var2.m_79c7e6e7(var1x, (Entity)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",6,1>()._getCameraEntity())));
   }

   @EventHandler
   public void m_4a742436(EventRender3DNoBobbing var1) {
      if (this.f_4ff9cd67) {
         C0114.bootstrap<"call",4,1>();
         this.f_1fe12757.begin();
         this.f_593d7d63.forEach(var1x -> {
            int var2 = var1x.m_d8367831();
            this.f_1fe12757.glColor(new Color(var2 >>> 16 & 0xFF, var2 >>> 8 & 0xFF, var2 & 0xFF));
            this.f_1fe12757.lineToBlockPosition(var1x.m_a2e39655());
         });
         this.f_1fe12757.end();
         C0114.bootstrap<"call",5,1>();
      }
   }

   public boolean m_398ba9a1() {
      return this.f_370c1f9b;
   }

   public boolean m_29794679() {
      return this.f_4ff9cd67;
   }
}
