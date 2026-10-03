package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.menu.view.dialog.ColorDialogWidget;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;

public class C0185 extends C0150 {
   protected C0157 f_069ab5b9;
   protected C0157 f_9160ab3f;
   protected C0157 f_a74fb56c;
   protected C0157 f_e44a6836;
   protected C0436 f_928d78c2;
   protected C0167 f_d90c3bcc;
   protected String f_64f4a2c5 = C0254.m_ec329d2e();
   protected String f_9de1b0db = C0254.m_16315846();

   public C0185(C0186 var1) {
      super(var1);
   }

   @Override
   protected void m_1058ed9a() {
      this.addCenteredText(getScaledWidth() / 2, 30, Message.of(this.f_64f4a2c5));
      short var1 = 250;
      byte var2 = 75;
      this.m_4f7d4126(
         new C0163[]{
            this.f_069ab5b9 = this.m_c1f9f0d3(getScaledWidth() / 2 - var1 / 2, 60, var1, Message.of(C0254.m_edf5fb69())),
            new C0155(getScaledWidth() / 2, 120, (float)var1, (float)var2, this)
               .m_2ee4da8d(
                  this.f_9160ab3f = this.m_c1f9f0d3(0, 0, var2, Message.of(C0253.m_b0896de7())).m_35587e93(),
                  this.f_a74fb56c = this.m_c1f9f0d3(0, 0, var2, Message.of(C0253.m_593ecbab())).m_35587e93(),
                  this.f_e44a6836 = this.m_c1f9f0d3(0, 0, var2, Message.of(C0253.m_17d51275())).m_35587e93()
               )
         }
      );
      final Message var3 = Message.of(C0254.m_8ccfdf29());
      this.m_4f7d4126(
         new C0163[]{
            this.f_d90c3bcc = new C0167(
               (double)getScaledWidth() / 2.0 + (double)var1 / 2.0 - 20.0,
               150.0,
               20.0,
               20.0,
               this.f_928d78c2 = (new C0436(
                     20.0, 20.0, 200.0, 100.0, Color.pink, ColorDialogWidget.brightness, ColorDialogWidget.hue, ColorDialogWidget.opacity
                  ) {
                     @Override
                     public void m_e4529f30(Color var1, boolean var2) {
                     }
                  })
                  .m_006ec697(false),
               C0167.anonymousimplements.f_544b0734
            ) {
               @Override
               protected void m_9d486ef7(double var1, double var3x, float var5) {
                  RenderStack.blend();
                  ((QuadRenderStack)this.f_4cf19435.begin().glColor(((C0436)this.f_344c71c7).m_ac758c94()))
                     .drawRect(
                        this.f_454f8a85.m_a005efae(),
                        this.f_454f8a85.m_84808068(),
                        this.f_454f8a85.m_a005efae() + this.f_454f8a85.m_4388ac29(),
                        this.f_454f8a85.m_84808068() + this.f_454f8a85.m_d42f3372()
                     )
                     .end();
                  RenderStack.noBlend();
                  FontRenderer.drawStringWithShadow(
                     var3,
                     (int)(this.f_454f8a85.m_a005efae() - (double)FontRenderer.getStringWidth(var3) - 5.0),
                     (int)(this.f_454f8a85.m_84808068() + (this.f_454f8a85.m_d42f3372() / 2.0 - (double)(FontRenderer.getFontHeight() / 2))),
                     16777215
                  );
               }
            }
         }
      );
      this.f_d90c3bcc.m_c7a3618c(new C0153(this.f_d90c3bcc, Message.of(C0254.m_0223faff())));
      var2 = 115;
      this.m_4f7d4126(
         new C0163[]{
            new C0155(getScaledWidth() / 2, getScaledHeight() - 50, (float)var1, (float)var2, this)
               .m_2ee4da8d(
                  this.m_79273652(0, 0, (float)var2, Message.of(this.f_9de1b0db), this::m_0e265701)
                     .m_798462fc(() -> this.m_8407423a(new C0157[]{this.f_069ab5b9, this.f_9160ab3f, this.f_a74fb56c, this.f_e44a6836})),
                  this.m_79273652(0, 0, (float)var2, Message.of(C0261.m_56c1229f()), this::goBack)
               )
         }
      );
      this.m_f1ec3ae8();
   }

   protected void m_f1ec3ae8() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1 != null) {
         this.f_9160ab3f.m_333019c8(String.valueOf(Math.round(var1.getPosX())));
         this.f_a74fb56c.m_333019c8(String.valueOf(Math.round(var1.getPosY())));
         this.f_e44a6836.m_333019c8(String.valueOf(Math.round(var1.getPosZ())));
      }
   }

   protected void m_1c2178b4(C0244 var1) {
      var1.m_46938bdb(this.f_9160ab3f.m_2ac34870());
      var1.m_7c7fe86a(this.f_a74fb56c.m_2ac34870());
      var1.m_8b037516(this.f_e44a6836.m_2ac34870());
      var1.m_256015fc(this.f_069ab5b9.m_e9914bd3());
      var1.m_0e76b397(this.f_928d78c2.m_ac758c94().getRGB());
   }

   protected void m_0e265701() {
      C0244 var1 = new C0244();
      this.m_1c2178b4(var1);
      var1.m_d6ac7420(true);
      C0244.m_a492b2a7().add(var1);
      this.goBack();
   }
}
