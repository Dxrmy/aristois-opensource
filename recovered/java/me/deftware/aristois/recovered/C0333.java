package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;

public class C0333 extends AbstractMod {
   @C0098(
      value = "Death waypoints",
      description = {"Automatically creates a waypoint when you die"}
   )
   private boolean f_f809a61c = true;
   @C0098(
      value = "Show tracer",
      description = {"Whether to render a line towards waypoints"}
   )
   private boolean f_a7b72f2c = true;
   @C0098("Waypoints")
   private final GuiScreen f_588bab87 = new C0186(null);
   private final LineRenderStack f_5f7c3cd1 = new LineRenderStack();
   private Collection<C0244> f_e91e7f51;

   public C0333() {
      super(C0254.m_91e95cb4(), C0290.f_3210deb7, C0255.m_cf4f91f1());
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      C0292 var2 = Objects.requireNonNull(C0289.m_c3a8b502(C0292.class));
      this.f_e91e7f51 = C0244.m_a492b2a7().stream().filter(C0244::m_f0e7dcaa).filter(C0244::m_89e0519f).collect(Collectors.toList());
      this.f_e91e7f51.forEach(var1x -> var2.m_26b1e5f1(var1x, Objects.requireNonNull(Minecraft.getMinecraftGame()._getCameraEntity())));
   }

   @EventHandler
   public void m_4f06bdb8(EventRender3DNoBobbing var1) {
      if (this.f_a7b72f2c) {
         RenderStack.setupGl();
         this.f_5f7c3cd1.begin();
         this.f_e91e7f51.forEach(var1x -> {
            int var2 = var1x.m_8b15b5f4();
            this.f_5f7c3cd1.glColor(new Color(var2 >>> 16 & 0xFF, var2 >>> 8 & 0xFF, var2 & 0xFF));
            this.f_5f7c3cd1.lineToBlockPosition(var1x.m_e8f7735c());
         });
         this.f_5f7c3cd1.end();
         RenderStack.restoreGl();
      }
   }

   public boolean m_e0f7c666() {
      return this.f_f809a61c;
   }

   public boolean m_297cfef6() {
      return this.f_a7b72f2c;
   }
}
