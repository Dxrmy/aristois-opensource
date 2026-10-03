package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventChunk.Action;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.world.block.Block;

public class C0326 extends AbstractMod {
   private static final C0219<Block> f_7c0f1d06 = new C0219<Block>(Block.class, C0252.bootstrap<"get",47244640335>()) {
      protected void m_8bf13441(Block var1, boolean var2) {
         super.m_2bf95354(var1, var2);
         C0114.bootstrap<"call",0,1>(C0326.class, C0326::m_b0438069);
      }
   };
   @C0098("Blocks")
   private static final GuiScreen f_e686ba9f = C0114.bootstrap<"call",0,1>(null, f_7c0f1d06);
   @C0098(
      value = "Render Distance",
      description = {"Render distance in chunks"},
      number = @C0096(
         min = 2.0,
         max = 32.0
      )
   )
   private int f_6cbf7112 = 5;
   private final CubeRenderStack f_44cc4a87 = new CubeRenderStack();
   private final C0068 f_abbfc154 = new C0068();
   private final ExecutorService f_e12e497d = C0114.bootstrap<"call",0,1>(16);

   public C0326() {
      super(C0252.bootstrap<"get",47244640333>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640334>());
      C0451.f_6cf0f98d.m_b3695757(this::m_63987d2d);
      C0451.f_6cf0f98d.f_66f03ed1.add(this::m_c03a16e1);
   }

   @Override
   public void onEnable() {
      this.m_b0438069();
   }

   @Override
   public void onDisable() {
      this.f_abbfc154.m_3b275439();
   }

   public void m_b0438069() {
      this.f_abbfc154.m_3b275439();
      C0451.f_6cf0f98d.m_9cfb0115().forEach(var1 -> this.m_63987d2d(var1, Action.LOAD));
   }

   private void m_c03a16e1(List<C0066> var1) {
      if (this.isEnabled()) {
         for (C0066 var3 : var1) {
            if (!var3.m_1dfdacd7().isAir()) {
               if (!f_7c0f1d06.contains(var3.m_1dfdacd7())) {
                  continue;
               }

               this.f_abbfc154.m_48bea716(var3);
            } else {
               this.f_abbfc154.m_09798ad6(var3.m_aed54967());
            }

            this.f_abbfc154.m_8828e4fd(var3.m_aed54967());
         }
      }
   }

   private void m_63987d2d(C0450 var1, Action var2) {
      long var3 = var1.m_f5501f1c();
      if (var2 == Action.LOAD && this.isEnabled() && !this.f_abbfc154.m_0243c826(var3)) {
         this.f_e12e497d.submit(() -> {
            ArrayList var2x = new ArrayList();
            f_7c0f1d06.forEach(var2xx -> var1.m_cc5fafd4(var2xx).forEach(var2xxx -> var2x.add(new C0066(var2xxx, var2xx))));
            if (!var2x.isEmpty()) {
               this.f_abbfc154.m_7d4bb95a(var2x);
            }
         });
      } else if (var2 == Action.UNLOAD) {
         this.f_abbfc154.m_487d86d4(var3);
      }
   }

   @EventHandler
   private void m_dbe5b837(EventRender3D var1) {
      C0114.bootstrap<"call",0,1>();
      this.f_44cc4a87.begin();
      this.f_abbfc154.m_77f3f922(this.f_44cc4a87, this.f_6cbf7112);
      this.f_44cc4a87.end();
      C0114.bootstrap<"call",1,1>();
   }

   public static C0219<Block> m_92d23cf8() {
      return f_7c0f1d06;
   }

   public static GuiScreen m_f5f63278() {
      return f_e686ba9f;
   }
}
