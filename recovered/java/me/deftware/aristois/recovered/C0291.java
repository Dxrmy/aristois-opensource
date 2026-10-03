package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender2D;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.minecraft.GameSetting;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;

public class C0291 extends AbstractMod {
   @C0098(
      value = "Distance",
      description = {"Distance between lines"}
   )
   public float f_fbd4f657 = 1.3F;
   @C0098(
      value = "Thickness",
      description = {"Thickness of the lines"},
      number = @C0096(
         min = 1.4500000476837158,
         max = 5.0
      )
   )
   public float f_3e4d47fc = 1.45F;
   @C0098(
      value = "Length",
      description = {"Length of the lines"},
      number = @C0096(
         max = 50.0
      )
   )
   public float f_b6eb0ba2 = 3.5F;
   @C0098(
      value = "RGB mode",
      description = {"Render the crosshair in RGB"}
   )
   public boolean f_ecf7c4d2 = true;
   @C0098(
      value = "Cooldown",
      description = {"Draw the cooldown"},
      protocol = @C0101(
         minimumProtocol = C0213.MINECRAFT_1_9
      )
   )
   public boolean f_e77ad92e = true;
   @C0098(
      value = "Color",
      description = {"Color of the crosshair"}
   )
   private Color f_fead88fe = C0289.m_c3a8b502(C0432.class).m_e1729432();
   private double f_8d15defc = 0.0;
   private final LineRenderStack f_05148f19 = new LineRenderStack();

   public C0291() {
      super(C0263.m_f599ae93(), C0290.f_020f9141, C0263.m_5b2d5cb2());
   }

   @EventHandler
   public void m_84072c65(EventRender2D var1) {
      if (!(Boolean)GameSetting.DEBUG_INFO.get()) {
         MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
         Color var3 = this.f_ecf7c4d2 ? C0045.f_8f480fc4.m_f6c8a26c() : this.f_fead88fe;
         float var4 = (float)GuiScreen.getScaledHeight() / 2.0F;
         float var5 = (float)GuiScreen.getScaledWidth() / 2.0F;
         float var6 = var2.getCooldown();
         RenderStack.setupGl();
         GLX.INSTANCE.push();
         this.f_05148f19.glColor(var3);
         this.f_05148f19.lineWidth(this.f_3e4d47fc);
         GLX.INSTANCE.translate(var5, var4, 1.0F);
         this.f_05148f19.begin();
         float var7 = this.f_fbd4f657 + (float)this.f_8d15defc;
         this.f_05148f19.vertex((double)(-var7 - this.f_b6eb0ba2), 0.0);
         this.f_05148f19.vertex((double)(-var7), 0.0);
         this.f_05148f19.vertex((double)var7, 0.0);
         this.f_05148f19.vertex((double)(var7 + this.f_b6eb0ba2), 0.0);
         this.f_05148f19.vertex(0.0, (double)(-var7 - this.f_b6eb0ba2));
         this.f_05148f19.vertex(0.0, (double)(-var7));
         this.f_05148f19.vertex(0.0, (double)var7);
         this.f_05148f19.vertex(0.0, (double)(var7 + this.f_b6eb0ba2));
         if (var6 != 1.0F && this.f_e77ad92e && C0213.f_3c75609d.m_efa7610e()) {
            float var8 = this.f_b6eb0ba2 * 2.0F + var7 * 2.0F;
            float var9 = -(var8 / 2.0F);
            float var10 = var7 * 2.0F + this.f_b6eb0ba2;
            this.f_05148f19.vertex((double)var9, (double)var10);
            this.f_05148f19.vertex((double)(var9 + var8 * var6), (double)var10);
         }

         this.f_05148f19.end();
         GLX.INSTANCE.pop();
         RenderStack.restoreGl();
      }
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.CROSSHAIR, false);
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.put(GameKeys.CROSSHAIR, true);
   }

   public void m_4b04f920(double var1) {
      this.f_8d15defc = var1;
   }
}
