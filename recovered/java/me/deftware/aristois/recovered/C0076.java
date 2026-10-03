package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.gl.GLX;

@C0099
public class C0076 extends C0082 {
   public static final double f_83f40c96 = 0.525;
   public static final double f_aabff45e = 1.875;
   @C0098(
      value = "Size",
      number = @C0096(
         min = 50.0,
         max = 150.0,
         percentage = true
      )
   )
   private double f_3174b82a = 80.0;
   private double f_b5a91fed;
   private double f_1893dd81;
   private double f_5aeb22fd = 5.0;

   public C0076() {
      super(C0267.m_c6614274(), C0087.f_80a06470, C0265.m_44418b5d());
      this.f_fd8e2fcd = 20;
   }

   @Override
   public void m_a172f6fe(double var1, double var3) {
      double var5 = this.f_3174b82a;
      this.f_b5a91fed = var5 * 0.525 * 2.0;
      this.f_1893dd81 = var5 * 1.875;
      C0074.m_d996e5c5().end();
      RenderStack.restoreGl();
      var1 += this.f_5aeb22fd;
      var3 += this.f_5aeb22fd;
      MainEntityPlayer var7 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      var7.drawPlayer((int)(var1 + this.f_b5a91fed / 2.0), (int)(var3 + this.f_1893dd81), (int)var5);
      this.f_b5a91fed = this.f_b5a91fed + this.f_5aeb22fd * 2.0;
      this.f_1893dd81 = this.f_1893dd81 + this.f_5aeb22fd * 2.0;
      RenderStack.setupGl();
      GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateHelper.enableTexture2D();
      C0074.m_d996e5c5().begin();
   }

   @Override
   public double m_b199d4ff() {
      return this.f_b5a91fed;
   }

   @Override
   public double m_a005efae() {
      return this.f_1893dd81;
   }

   public double m_84808068() {
      return this.f_5aeb22fd;
   }
}
