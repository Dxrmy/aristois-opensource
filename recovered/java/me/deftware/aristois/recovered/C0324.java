package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventDisconnected;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.world.ClientWorld;

@C0421
public class C0324 extends AbstractMod {
   @C0098(
      value = "Scan radius",
      description = {"Radius to scan for Obsidian/Bedrock holes"},
      number = @C0096(
         max = 50.0
      )
   )
   private int f_a320fe1f = 5;
   @C0098(
      value = "Cautious Score",
      description = {"Min number of Blocks.BEDROCK blocks to be categorized as safe instead of cautious"},
      number = @C0096(
         max = 5.0
      )
   )
   private int f_0bd2d4c7 = 5;
   @C0098("Dubious Color")
   private Color f_be13a483 = new Color(255, 0, 0);
   @C0098("Cautious Color")
   private Color f_598286c5 = new Color(255, 255, 0);
   @C0098("Safe Color")
   private Color f_58bb71b9 = new Color(0, 255, 0);
   private C0275<Integer> f_623e41a0;
   private final CubeRenderStack f_d4bc902e = new CubeRenderStack();

   public C0324() {
      super(C0260.m_76700429(), C0290.f_3210deb7, C0260.m_8870d2c1());
   }

   @Override
   public synchronized void onEnable() {
      if (ClientWorld.getClientWorld() != null && Minecraft.getMinecraftGame()._getPlayer() != null) {
         this.f_623e41a0 = new C0275<>(
               var0 -> var0.m_268de4b2().equals(C0071.f_ab96dc62) || var0.m_268de4b2().equals(C0071.f_95072491),
               this.f_a320fe1f,
               (var1, var2) -> {
                  BlockPosition var3 = var1.m_82942af9();
                  if (ClientWorld.getClientWorld()._getBlockFromPosition(var3.offset(0.0, 1.0, 0.0)).isAir()
                     && ClientWorld.getClientWorld()._getBlockFromPosition(var3.offset(0.0, 2.0, 0.0)).isAir()) {
                     int var4 = 6;
                     if (var1.m_268de4b2().equals(C0071.f_ab96dc62)) {
                        var4--;
                     }

                     BlockPosition var5 = var3.offset(1.0, 1.0, 0.0);
                     if (!var2.containsKey(var5.toString())) {
                        return 0;
                     } else {
                        if (var2.get(var5.toString()).equals(C0071.f_ab96dc62)) {
                           var4--;
                        }

                        var5 = var3.offset(-1.0, 1.0, 0.0);
                        if (!var2.containsKey(var5.toString())) {
                           return 0;
                        } else {
                           if (var2.get(var5.toString()).equals(C0071.f_ab96dc62)) {
                              var4--;
                           }

                           var5 = var3.offset(0.0, 1.0, 1.0);
                           if (!var2.containsKey(var5.toString())) {
                              return 0;
                           } else {
                              if (var2.get(var5.toString()).equals(C0071.f_ab96dc62)) {
                                 var4--;
                              }

                              var5 = var3.offset(0.0, 1.0, -1.0);
                              if (!var2.containsKey(var5.toString())) {
                                 return 0;
                              } else {
                                 if (var2.get(var5.toString()).equals(C0071.f_ab96dc62)) {
                                    var4--;
                                 }

                                 if (var4 > this.f_0bd2d4c7) {
                                    return 3;
                                 } else {
                                    return var4 == 1 ? 1 : 2;
                                 }
                              }
                           }
                        }
                     }
                  } else {
                     return 0;
                  }
               }
            )
            .m_0bdfa3f3();
      }
   }

   @EventHandler
   public void m_e87e680b(EventDisconnected var1) {
      if (this.f_623e41a0 != null) {
         this.toggle();
      }
   }

   @Override
   public synchronized void onDisable() {
      if (this.f_623e41a0 != null) {
         this.f_623e41a0.m_49509d4b();
      }

      this.f_623e41a0 = null;
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      Map var2 = this.f_623e41a0.m_b4f914e1();
      RenderStack.setupGl();
      ((CubeRenderStack)this.f_d4bc902e.glColor(this.f_be13a483, 30.0F)).begin();
      List var3 = var2.getOrDefault(1, new LinkedList());
      var3.stream().map(var0 -> var0.m_82942af9().getBoundingBox()).forEach(this.f_d4bc902e::draw);
      this.f_d4bc902e.glColor(this.f_598286c5, 30.0F);
      List var4 = var2.getOrDefault(2, new LinkedList());
      var4.stream().map(var0 -> var0.m_82942af9().getBoundingBox()).forEach(this.f_d4bc902e::draw);
      this.f_d4bc902e.glColor(this.f_58bb71b9, 30.0F);
      List var5 = var2.getOrDefault(3, new LinkedList());
      var5.stream().map(var0 -> var0.m_82942af9().getBoundingBox()).forEach(this.f_d4bc902e::draw);
      this.f_d4bc902e.end();
      RenderStack.restoreGl();
   }
}
