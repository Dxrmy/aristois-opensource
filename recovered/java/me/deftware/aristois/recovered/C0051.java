package me.deftware.aristois.recovered;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;

public class C0051 extends C0052 {
   private Message f_15fd37d8 = Message.of(C0257.m_8d7dbe31()).style(Appearance.of(DefaultColors.GOLD));
   private Message f_def606a5 = Message.of(C0257.m_1d87ef21()).style(Appearance.of(DefaultColors.GOLD));
   private final Future<Void> f_bb5ceef5 = CompletableFuture.runAsync(() -> {
      Thread.currentThread().setName(C0257.m_9793dfe2());

      try {
         C0050 var1x = new C0050();
         if (!var1x.m_297cfef6()) {
            throw new Exception(C0257.m_1635bc47());
         }

         this.m_8b50f69c(C0257.m_d597c122(), DefaultColors.GREEN);
         this.m_256015fc(C0257.m_18204724());
         var1x.m_1058ed9a();
         this.m_256015fc(C0257.m_cf4f91f1());
         var1x.m_b728afce();
         this.m_256015fc(C0257.m_b251ca51());
         var1x.m_0e265701();
         this.m_256015fc(C0257.m_b48a8bc4());
         var1x.m_41e83f88();
         this.m_d5a35a11(C0257.m_b886ae1c(), DefaultColors.GREEN);
         this.f_00455875 = new C0053(var1x);
         this.f_00455875.m_f1ec3ae8();
         this.m_8b50f69c(C0257.m_bec91365(), DefaultColors.DARK_GREEN);
         this.m_d5a35a11(C0257.m_79bfaec2() + SessionHelper.getPlayerUsername() + C0257.m_2e834348(), DefaultColors.GREEN);
         this.onInitGui();
      } catch (Exception var2) {
         var2.printStackTrace();
         this.m_8b50f69c(C0257.m_e07cee76(), DefaultColors.RED);
         this.m_d5a35a11(var2.getMessage(), DefaultColors.RED);
      }
   });
   private C0053 f_00455875;

   public C0051(GenericScreen var1) {
      super(var1);
   }

   protected void onGuiClose() {
      if (this.f_bb5ceef5 != null && !this.f_bb5ceef5.isDone()) {
         this.f_bb5ceef5.cancel(true);
      }
   }

   private void m_256015fc(String var1) {
      this.m_d5a35a11(var1, DefaultColors.GOLD);
   }

   private void m_d5a35a11(String var1, FormattingColor var2) {
      this.f_def606a5 = Message.of(var1).style(Appearance.of(var2));
   }

   private void m_8b50f69c(String var1, FormattingColor var2) {
      this.f_15fd37d8 = Message.of(var1).style(Appearance.of(var2));
   }

   @Override
   protected void m_1058ed9a() {
      this.m_4f7d4126(new C0163[]{this.m_79273652(10, 10, 60.0F, Message.of(C0257.m_c42f1c7e()), this::goBack)});
      if (this.f_00455875 != null) {
         byte var1 = 90;
         int var2 = getScaledHeight() - 100;
         List var3 = C0053.m_110abc4e();
         this.m_4f7d4126(
            new C0163[]{
               this.m_79273652(
                  getScaledWidth() / 2 - var1 - 2,
                  var2,
                  (float)var1,
                  Message.of(C0257.m_6f1f396d()),
                  () -> ScreenRegistry.Multiplayer.open(new Object[]{new C0193()})
               ),
               this.m_5a1fbc03(getScaledWidth() / 2 + 2, var2, (float)var1, Message.of(C0257.m_8ced16bd()), var2x -> {
                  if (C0241.f_f6e3d33b) {
                     if (!var3.contains(this.f_00455875)) {
                        C0053.m_110abc4e().add(this.f_00455875);
                        C0053.m_a4e18580(this.parent);
                     } else {
                        var2x.m_b1b94a23().setComponentLabel(Message.of(C0257.m_15ef1a0d()));
                     }
                  } else {
                     var2x.m_b1b94a23().setComponentLabel(Message.of(C0257.m_624b40d8()).style(Appearance.of(DefaultColors.RED)));
                  }
               })
            }
         );
      }
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      super.onDraw(var1, var2, var3);
      FontRenderer.drawCenteredString(this.f_15fd37d8, getScaledWidth() / 2, getScaledHeight() - 60, 16777215);
      FontRenderer.drawCenteredString(this.f_def606a5, getScaledWidth() / 2, getScaledHeight() - 60 + 15, 16777215);
   }
}
