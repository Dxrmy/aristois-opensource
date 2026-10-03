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
import me.deftware.client.framework.render.batching.CubeRenderStack;

@C0421
public class C0324 extends AbstractMod {
   @C0098(
      value = "Scan radius",
      description = {"Radius to scan for Obsidian/Bedrock holes"},
      number = @C0096(
         max = 50.0
      )
   )
   private int f_c35f4e5d = 5;
   @C0098(
      value = "Cautious Score",
      description = {"Min number of Blocks.BEDROCK blocks to be categorized as safe instead of cautious"},
      number = @C0096(
         max = 5.0
      )
   )
   private int f_870bdfbc = 5;
   @C0098("Dubious Color")
   private Color f_4f7af12e = new Color(255, 0, 0);
   @C0098("Cautious Color")
   private Color f_5e025a4d = new Color(255, 255, 0);
   @C0098("Safe Color")
   private Color f_a9c2e268 = new Color(0, 255, 0);
   private C0275<Integer> f_73780e0c;
   private final CubeRenderStack f_8a275d3f = new CubeRenderStack();

   public C0324() {
      super(C0252.bootstrap<"get",47244640372>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640373>());
   }

   @Override
   public synchronized void onEnable() {
      if (C0114.bootstrap<"call",0,1>() != null && C0114.bootstrap<"call",1,1>()._getPlayer() != null) {
         this.f_73780e0c = new C0275<>(
               var0 -> var0.m_5d9fe07a().equals(C0071.f_5c7ed30b) || var0.m_5d9fe07a().equals(C0071.f_c7c6621d),
               this.f_c35f4e5d,
               (var1, var2) -> {
                  BlockPosition var3 = var1.m_8ac0e23f();
                  if (C0114.bootstrap<"call",3,1>()._getBlockFromPosition(var3.offset(0.0, 1.0, 0.0)).isAir()
                     && C0114.bootstrap<"call",3,1>()._getBlockFromPosition(var3.offset(0.0, 2.0, 0.0)).isAir()) {
                     int var4 = 6;
                     if (var1.m_5d9fe07a().equals(C0071.f_5c7ed30b)) {
                        var4--;
                     }

                     BlockPosition var5 = var3.offset(1.0, 1.0, 0.0);
                     if (!var2.containsKey(var5.toString())) {
                        return C0114.bootstrap<"call",1,1>(0);
                     } else {
                        if (var2.get(var5.toString()).equals(C0071.f_5c7ed30b)) {
                           var4--;
                        }

                        var5 = var3.offset(-1.0, 1.0, 0.0);
                        if (!var2.containsKey(var5.toString())) {
                           return C0114.bootstrap<"call",1,1>(0);
                        } else {
                           if (var2.get(var5.toString()).equals(C0071.f_5c7ed30b)) {
                              var4--;
                           }

                           var5 = var3.offset(0.0, 1.0, 1.0);
                           if (!var2.containsKey(var5.toString())) {
                              return C0114.bootstrap<"call",1,1>(0);
                           } else {
                              if (var2.get(var5.toString()).equals(C0071.f_5c7ed30b)) {
                                 var4--;
                              }

                              var5 = var3.offset(0.0, 1.0, -1.0);
                              if (!var2.containsKey(var5.toString())) {
                                 return C0114.bootstrap<"call",1,1>(0);
                              } else {
                                 if (var2.get(var5.toString()).equals(C0071.f_5c7ed30b)) {
                                    var4--;
                                 }

                                 if (var4 > this.f_870bdfbc) {
                                    return C0114.bootstrap<"call",1,1>(3);
                                 } else {
                                    return var4 == 1 ? C0114.bootstrap<"call",1,1>(1) : C0114.bootstrap<"call",1,1>(2);
                                 }
                              }
                           }
                        }
                     }
                  } else {
                     return C0114.bootstrap<"call",1,1>(0);
                  }
               }
            )
            .m_0e0e46fe();
      }
   }

   @EventHandler
   public void m_033415be(EventDisconnected var1) {
      if (this.f_73780e0c != null) {
         this.toggle();
      }
   }

   @Override
   public synchronized void onDisable() {
      if (this.f_73780e0c != null) {
         this.f_73780e0c.m_e32342c1();
      }

      this.f_73780e0c = null;
   }

   @EventHandler
   public void m_93a7f44d(EventRender3D var1) {
      Map var2 = this.f_73780e0c.m_deb0b934();
      C0114.bootstrap<"call",0,1>();
      ((CubeRenderStack)this.f_8a275d3f.glColor(this.f_4f7af12e, 30.0F)).begin();
      List var3 = var2.getOrDefault(C0114.bootstrap<"call",1,1>(1), new LinkedList());
      var3.stream().map(var0 -> var0.m_8ac0e23f().getBoundingBox()).forEach(this.f_8a275d3f::draw);
      this.f_8a275d3f.glColor(this.f_5e025a4d, 30.0F);
      List var4 = var2.getOrDefault(C0114.bootstrap<"call",1,1>(2), new LinkedList());
      var4.stream().map(var0 -> var0.m_8ac0e23f().getBoundingBox()).forEach(this.f_8a275d3f::draw);
      this.f_8a275d3f.glColor(this.f_a9c2e268, 30.0F);
      List var5 = var2.getOrDefault(C0114.bootstrap<"call",1,1>(3), new LinkedList());
      var5.stream().map(var0 -> var0.m_8ac0e23f().getBoundingBox()).forEach(this.f_8a275d3f::draw);
      this.f_8a275d3f.end();
      C0114.bootstrap<"call",2,1>();
   }
}
