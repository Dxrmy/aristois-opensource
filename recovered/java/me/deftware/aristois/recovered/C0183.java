package me.deftware.aristois.recovered;

import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.session.AccountSession;

public class C0183 extends C0150 {
   private C0157 f_aa71d2b8;

   public C0183(GenericScreen var1) {
      super(var1);
   }

   @Override
   protected void m_1058ed9a() {
      short var1 = 300;
      this.f_aa71d2b8 = new C0157(getScaledWidth() / 2 - var1 / 2, 80, var1, 20);
      this.f_aa71d2b8.m_efb6bb0d(Message.of(C0254.m_6cf615ba()));
      this.m_4f7d4126(new C0163[]{this.f_aa71d2b8});
      short var2 = 160;
      byte var3 = 120;
      this.m_4f7d4126(new C0163[]{new C0154(getScaledWidth() / 2 - var3 - 2, var2, var3, 20, Message.of(C0261.m_56c1229f())) {
         @Override
         public boolean m_1521b1fa(int var1) {
            C0183.this.goBack();
            return true;
         }
      }});
      this.m_4f7d4126(new C0163[]{(new C0154(getScaledWidth() / 2 + 2, var2, var3, 20, Message.of(C0257.m_4626ac74())) {
         @Override
         public boolean m_1521b1fa(int var1) {
            AccountSession var2 = new AccountSession(null);
            var2.withOfflineUsername(C0183.this.f_aa71d2b8.m_e9914bd3());
            var2.setSession();
            C0183.this.goBack();
            return true;
         }
      }).m_798462fc(() -> !this.f_aa71d2b8.m_e9914bd3().isEmpty())});
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      int var4 = getScaledWidth() / 2;
      FontRenderer.drawCenteredString(Message.of(C0254.m_ecb46027()), var4, 40, 16777215);
      FontRenderer.drawCenteredString(Message.of(C0254.m_b526dd3b()), var4, 50, 16777215);
      FontRenderer.drawCenteredString(Message.of(C0254.m_9d6ca6d0()), var4, 120, 16777215);
      FontRenderer.drawCenteredString(Message.of(C0254.m_87c16989()), var4, 130, 16777215);
   }
}
