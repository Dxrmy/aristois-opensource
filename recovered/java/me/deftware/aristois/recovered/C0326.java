package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventChunk.Action;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.world.block.Block;

public class C0326 extends AbstractMod {
   private static final C0219<Block> f_b231ec8a = new C0219<Block>(Block.class, C0260.m_e7934778()) {
      protected void m_63a72a13(Block var1, boolean var2) {
         super.m_cef1a7b6(var1, var2);
         C0289.m_24841a60(C0326.class, C0326::m_23674f64);
      }
   };
   @C0098("Blocks")
   private static final GuiScreen f_c35d079a = C0217.m_20baf8c9(null, f_b231ec8a);
   @C0098(
      value = "Render Distance",
      description = {"Render distance in chunks"},
      number = @C0096(
         min = 2.0,
         max = 32.0
      )
   )
   private int f_8a2549b6 = 5;
   private final CubeRenderStack f_da6a4c9d = new CubeRenderStack();
   private final C0068 f_02c9fbbd = new C0068();
   private final ExecutorService f_ec0c2e6f = Executors.newFixedThreadPool(16);

   public C0326() {
      super(C0260.m_1616e137(), C0290.f_3210deb7, C0260.m_6dc2a812());
      C0451.f_3c37bf88.m_ee5d3d0f(this::m_43d03c69);
      C0451.f_3c37bf88.f_6f32d742.add(this::m_1793329a);
   }

   @Override
   public void onEnable() {
      this.m_23674f64();
   }

   @Override
   public void onDisable() {
      this.f_02c9fbbd.m_41e83f88();
   }

   public void m_23674f64() {
      this.f_02c9fbbd.m_41e83f88();
      C0451.f_3c37bf88.m_918b7b9e().forEach(var1 -> this.m_43d03c69(var1, Action.LOAD));
   }

   private void m_1793329a(List<C0066> var1) {
      if (this.isEnabled()) {
         for (C0066 var3 : var1) {
            if (!var3.m_268de4b2().isAir()) {
               if (!f_b231ec8a.contains(var3.m_268de4b2())) {
                  continue;
               }

               this.f_02c9fbbd.m_6f674dd3(var3);
            } else {
               this.f_02c9fbbd.m_2405ca7d(var3.m_82942af9());
            }

            this.f_02c9fbbd.m_f87f5317(var3.m_82942af9());
         }
      }
   }

   private void m_43d03c69(C0450 var1, Action var2) {
      long var3 = var1.m_b580fe58();
      if (var2 == Action.LOAD && this.isEnabled() && !this.f_02c9fbbd.m_ba0de549(var3)) {
         this.f_ec0c2e6f.submit(() -> {
            ArrayList var2x = new ArrayList();
            f_b231ec8a.forEach(var2xx -> var1.m_94900ef2(var2xx).forEach(var2xxx -> var2x.add(new C0066(var2xxx, var2xx))));
            if (!var2x.isEmpty()) {
               this.f_02c9fbbd.m_e764c4eb(var2x);
            }
         });
      } else if (var2 == Action.UNLOAD) {
         this.f_02c9fbbd.m_ad6c7e6f(var3);
      }
   }

   @EventHandler
   private void m_c738343e(EventRender3D var1) {
      RenderStack.setupGl();
      this.f_da6a4c9d.begin();
      this.f_02c9fbbd.m_97f09f9d(this.f_da6a4c9d, this.f_8a2549b6);
      this.f_da6a4c9d.end();
      RenderStack.restoreGl();
   }

   public static C0219<Block> m_3e9a41cb() {
      return f_b231ec8a;
   }

   public static GuiScreen m_0d5f1fc3() {
      return f_c35d079a;
   }
}
