package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.SelectableList;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.ClickAction;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.util.ResourceUtils;

public class C0189 extends C0150 {
   private final List<C0189.anonymousimplements> f_f9c98f95;
   private final Message f_5b532a1d;
   private final Message f_7d2fa70a;
   private static final Pattern f_e862e800 = Pattern.compile(C0267.m_7b0db73e());

   public C0189(GenericScreen var1, List<C0189.anonymousimplements> var2, Message var3, Message var4) {
      super(var1);
      this.f_5b532a1d = var3;
      this.f_7d2fa70a = var4;
      this.f_f9c98f95 = var2;
   }

   @Override
   protected void m_1058ed9a() {
      SelectableList var1 = new SelectableList(
         this.f_f9c98f95, this.getGuiScreenWidth(), this.getGuiScreenHeight(), 43, this.getGuiScreenHeight(), FontRenderer.getFontHeight() + 2
      );
      var1.setExtended(true);
      this.addComponent(var1);
      Message var2 = Message.of(C0257.m_4626ac74());
      this.m_4f7d4126(
         new C0163[]{
            this.m_79273652(
               this.getGuiScreenWidth() - FontRenderer.getStringWidth(var2) - 25, 10, (float)(FontRenderer.getStringWidth(var2) + 15), var2, this::goBack
            )
         }
      );
      this.addCenteredText(this.getGuiScreenWidth() / 2, 15, this.f_5b532a1d);
      this.addCenteredText(this.getGuiScreenWidth() / 2, 15 + FontRenderer.getFontHeight() + 2, this.f_7d2fa70a);
   }

   private static C0189.anonymousimplements m_bc9ff2bf(String var0) {
      Builder var1 = new Builder();
      String[] var2 = var0.split(C0257.m_593ecbab());
      String var3 = null;

      for (String var7 : var2) {
         Matcher var8 = f_e862e800.matcher(var7);
         if (var8.matches()) {
            Appearance var10000 = Appearance.of(8, DefaultColors.GRAY);
            var3 = var7;
            Appearance var9 = var10000.withClickEvent(ClickAction.OPEN_URL, var7).withTextHoverEvent(Message.of(C0267.m_b886ae1c()));
            var1.append(Message.of(var7).style(var9));
         } else {
            var1.append(var7);
         }

         var1.append(C0257.m_593ecbab());
      }

      return new C0189.anonymousimplements(var1.build(), var3);
   }

   public static C0189 m_e842fe9d(GenericScreen var0) throws IOException {
      int var1 = Main.getInstance().getMeta().getVersion();

      C0189 var9;
      try (InputStream var2 = ResourceUtils.getStreamFromModResources(Main.getInstance(), C0267.m_bec91365())) {
         if (var2 == null) {
            throw new IOException(C0267.m_79bfaec2());
         }

         try (
            InputStreamReader var4 = new InputStreamReader(var2);
            BufferedReader var6 = new BufferedReader(var4);
         ) {
            List var8 = var6.lines().map(C0189::m_bc9ff2bf).collect(Collectors.toList());
            var9 = new C0189(var0, var8, Message.of(C0267.m_2e834348() + var1 + C0257.m_2e834348()), Message.of(C0267.m_e07cee76())) {
               @Override
               protected void m_1058ed9a() {
                  super.m_1058ed9a();
                  if (!C0241.f_f6e3d33b) {
                     Message var1 = Message.of(C0267.m_9793dfe2());
                     this.m_4f7d4126(
                        new C0163[]{
                           this.m_79273652(
                              10, 10, (float)(FontRenderer.getStringWidth(var1) + 15), var1, () -> Keyboard.openLink(C0146.f_36f829be + C0267.m_15ef1a0d())
                           )
                        }
                     );
                  }
               }
            };
         }
      }

      return var9;
   }

   private static class anonymousimplements implements ListItem {
      private final Message f_96d17a04;
      private final String f_7c91a33e;

      public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
         FontRenderer.drawString(C0197.m_3e1df413(this.f_96d17a04, var1x -> FontRenderer.getStringWidth(var1x) > var4 - 6), var2, var3, 16777215);
      }

      public boolean onMouseClicked(double var1, double var3, int var5) {
         if (this.f_7c91a33e != null) {
            Keyboard.openLink(this.f_7c91a33e);
         }

         return false;
      }

      public anonymousimplements(Message var1, String var2) {
         this.f_96d17a04 = var1;
         this.f_7c91a33e = var2;
      }
   }
}
