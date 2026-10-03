package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.minecraft.GameSetting;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.gl.GLX;

public class C0291 extends AbstractMod {
   @C0098(
      value = "Distance",
      description = {"Distance between lines"}
   )
   public float f_31cece0d = 1.3F;
   @C0098(
      value = "Thickness",
      description = {"Thickness of the lines"},
      number = @C0096(
         min = 1.4500000476837158,
         max = 5.0
      )
   )
   public float f_e6a0e37f = 1.45F;
   @C0098(
      value = "Length",
      description = {"Length of the lines"},
      number = @C0096(
         max = 50.0
      )
   )
   public float f_836da502 = 3.5F;
   @C0098(
      value = "RGB mode",
      description = {"Render the crosshair in RGB"}
   )
   public boolean f_111ffcec = true;
   @C0098(
      value = "Cooldown",
      description = {"Draw the cooldown"},
      protocol = @C0101(
         minimumProtocol = C0213.MINECRAFT_1_9
      )
   )
   public boolean f_77118e02 = true;
   @C0098(
      value = "Color",
      description = {"Color of the crosshair"}
   )
   private Color f_331f7a60 = ((C0432)C0114.bootstrap<"call",0,1>(C0432.class)).m_604f8702();
   private double f_387bb4e1 = 0.0;
   private final LineRenderStack f_888337f8 = new LineRenderStack();

   public C0291() {
      super(C0252.bootstrap<"get",38654705784>(), C0290.f_5fe5d165, C0252.bootstrap<"get",38654705785>());
   }

   @EventHandler
   public void m_ae8b8632(EventRender2D var1) {
      if (!(Boolean)GameSetting.DEBUG_INFO.get()) {
         MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
         Color var3 = this.f_111ffcec ? C0045.f_d228694b.m_86ca0a09() : this.f_331f7a60;
         float var4 = (float)C0114.bootstrap<"call",2,1>() / 2.0F;
         float var5 = (float)C0114.bootstrap<"call",3,1>() / 2.0F;
         float var6 = var2.getCooldown();
         C0114.bootstrap<"call",4,1>();
         GLX.INSTANCE.push();
         this.f_888337f8.glColor(var3);
         this.f_888337f8.lineWidth(this.f_e6a0e37f);
         GLX.INSTANCE.translate(var5, var4, 1.0F);
         this.f_888337f8.begin();
         float var7 = this.f_31cece0d + (float)this.f_387bb4e1;
         this.f_888337f8.vertex((double)(-var7 - this.f_836da502), 0.0);
         this.f_888337f8.vertex((double)(-var7), 0.0);
         this.f_888337f8.vertex((double)var7, 0.0);
         this.f_888337f8.vertex((double)(var7 + this.f_836da502), 0.0);
         this.f_888337f8.vertex(0.0, (double)(-var7 - this.f_836da502));
         this.f_888337f8.vertex(0.0, (double)(-var7));
         this.f_888337f8.vertex(0.0, (double)var7);
         this.f_888337f8.vertex(0.0, (double)(var7 + this.f_836da502));
         if (var6 != 1.0F && this.f_77118e02 && C0213.f_2ea70082.m_093ae25a()) {
            float var8 = this.f_836da502 * 2.0F + var7 * 2.0F;
            float var9 = -(var8 / 2.0F);
            float var10 = var7 * 2.0F + this.f_836da502;
            this.f_888337f8.vertex((double)var9, (double)var10);
            this.f_888337f8.vertex((double)(var9 + var8 * var6), (double)var10);
         }

         this.f_888337f8.end();
         GLX.INSTANCE.pop();
         C0114.bootstrap<"call",5,1>();
      }
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.CROSSHAIR, C0114.bootstrap<"call",0,1>(false));
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.put(GameKeys.CROSSHAIR, C0114.bootstrap<"call",0,1>(true));
   }

   public void m_0da56a1a(double var1) {
      this.f_387bb4e1 = var1;
   }
}
