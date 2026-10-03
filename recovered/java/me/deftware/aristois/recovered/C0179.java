package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0179 extends C0150 {
   public static final String f_7600c9da = C0254.m_e07cee76();

   public C0179(GenericScreen var1) {
      super(var1);
   }

   @Override
   protected void m_1058ed9a() {
      List var1 = Arrays.asList(
         Message.of(C0254.m_d597c122()),
         Message.of(C0254.m_18204724()),
         Message.of(C0254.m_cf4f91f1()),
         Message.of(C0254.m_b251ca51()),
         C0197.f_9607505d,
         Message.of(C0254.m_b48a8bc4()),
         Message.of(C0254.m_b886ae1c()),
         Message.of(C0254.m_bec91365())
      );
      int var2 = getScaledWidth() / 2;
      int var3 = 65;

      for (Message var5 : var1) {
         this.addCenteredText(var2, var3, var5);
         var3 += FontRenderer.getFontHeight();
      }

      this.addCenteredText(var2, 30, Message.of(C0254.m_79bfaec2()).style(Appearance.of(DefaultColors.RED)));
      Message var9 = Message.of(C0254.m_2e834348());
      C0152 var10 = new C0152(var2, var3 + 15, 20, 20, false);
      var10.m_8d564dc2(var9);
      int var6 = 25 + FontRenderer.getStringWidth(var9);
      var10.m_44bb072f().m_dadc1f5d((double)var2 - (double)var6 / 2.0);
      this.m_4f7d4126(new C0163[]{var10});
      byte var7 = 90;
      int var8 = var3 + 40;
      this.m_4f7d4126(
         new C0163[]{
            this.m_79273652(var2 - var7 - 2, var8, (float)var7, Message.of(C0261.m_56c1229f()), this::goBack),
            this.m_79273652(var2 + 2, var8, (float)var7, Message.of(C0257.m_4626ac74()), () -> {
               Settings var1x = Main.getConfig();
               var1x.putPrimitive(C0254.m_e07cee76(), true);
               var1x.save();
               Minecraft.getMinecraftGame().openScreen(new C0180(this.parent));
            }).m_798462fc(var10::m_e0f7c666)
         }
      );
   }
}
