package me.deftware.aristois.recovered;

import java.util.concurrent.Callable;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.network.PacketRegistry;
import me.deftware.client.framework.network.SocksProxy;

public abstract class C0144 implements SocksProxy, ListItem {
   private C0144.anonymouscatch f_03a99b50 = C0144.anonymouscatch.f_c8c15b48;
   protected Message f_ea13adf7 = Message.of(C0255.m_bdbd5e40()).style(Appearance.of(DefaultColors.GRAY));
   private boolean f_87ca682e;
   private boolean f_0b4e307b;
   private long f_85a454c8;
   private Message[] f_879a6301;

   public C0144() {
   }

   public synchronized void m_b728afce() {
      if (!this.f_87ca682e) {
         this.f_87ca682e = true;
         if (C0213.f_17e12451.m_efa7610e()) {
            C0217.m_c162d659(
               () -> {
                  try {
                     this.m_e1c70890(
                        () -> this.getSocketAddress().getAddress().isReachable(1000), Message.of(C0255.m_1472ab32()).style(Appearance.of(DefaultColors.RED))
                     );
                  } catch (Exception var2) {
                     this.f_ea13adf7 = Message.of(C0255.m_a5b24d28()).style(Appearance.of(DefaultColors.RED));
                  }
               }
            );
         } else {
            this.f_0b4e307b = true;
            this.f_ea13adf7 = Message.of(C0255.m_c04d8f6e()).style(Appearance.of(DefaultColors.LIGHT_PURPLE));
         }
      }
   }

   public FormattingColor m_4de4a42d(int var1) {
      DefaultColors var2;
      if (var1 <= 75) {
         var2 = DefaultColors.DARK_GREEN;
      } else if (var1 <= 120) {
         var2 = DefaultColors.GREEN;
      } else if (var1 <= 200) {
         var2 = DefaultColors.YELLOW;
      } else {
         var2 = DefaultColors.GOLD;
      }

      return var2;
   }

   public boolean m_89e0519f() {
      SocksProxy var1 = PacketRegistry.INSTANCE.getProxy();
      return var1 != null && var1.equals(this);
   }

   public FormattingColor m_43cd70a2() {
      return this.m_89e0519f() ? DefaultColors.GREEN : DefaultColors.WHITE;
   }

   public boolean m_e606d819() {
      try {
         if (this.m_f21a055b()) {
            if (Keyboard.isShiftPressed()) {
               this.f_03a99b50 = C0144.anonymouscatch.f_1442a648;
            }

            if (this.f_03a99b50 == C0144.anonymouscatch.f_c8c15b48) {
               this.f_ea13adf7 = Message.of(C0254.m_7b0db73e()).style(Appearance.of(DefaultColors.YELLOW));
               this.m_e1c70890(() -> {
                  C0140 var1 = new C0139(C0255.m_1672ac4d()).m_4ac4bce5(this).m_0017133f();
                  if (var1.m_9362a920()) {
                     this.f_03a99b50 = C0144.anonymouscatch.f_1442a648;
                     return true;
                  } else {
                     this.f_03a99b50 = C0144.anonymouscatch.f_a2f15feb;
                     this.f_879a6301 = new Message[]{Message.of(C0255.m_e9a52709()), Message.of(C0255.m_37c08c9d())};
                     return false;
                  }
               }, Message.of(C0255.m_2dc36b02()).style(Appearance.of(DefaultColors.RED)));
            }

            if (this.f_03a99b50 == C0144.anonymouscatch.f_1442a648) {
               PacketRegistry.INSTANCE.setProxy(this);
               return true;
            }
         }

         return false;
      } catch (Throwable var2) {
         throw var2;
      }
   }

   private void m_e1c70890(Callable<Boolean> var1, Message var2) throws Exception {
      long var3 = System.currentTimeMillis();
      boolean var5 = (Boolean)var1.call();
      this.f_85a454c8 = System.currentTimeMillis() - var3;
      if (var5) {
         this.f_ea13adf7 = Message.of(String.format(C0255.m_4cbaf16f(), this.f_85a454c8)).style(Appearance.of(this.m_4de4a42d((int)this.f_85a454c8)));
         this.f_0b4e307b = true;
      } else {
         this.f_ea13adf7 = var2;
      }
   }

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      var3 += 4;
      this.m_ad28fb7c(
         true, var2 + var4 - 18, var3, this.f_ea13adf7, Message.of(C0255.m_678c4ddb() + this.getVersion()).style(Appearance.of(DefaultColors.GRAY))
      );
      this.m_ad28fb7c(false, var2 - 4, var3, this.m_91be39c9());
   }

   protected void m_ad28fb7c(boolean var1, int var2, int var3, Message... var4) {
      for (Message var8 : var4) {
         int var9 = var2;
         if (var1) {
            var9 = var2 - FontRenderer.getStringWidth(var8);
         }

         FontRenderer.drawString(var8, var9, var3, 16777215);
         var3 += FontRenderer.getFontHeight();
      }
   }

   public Message[] getTooltip() {
      return this.f_879a6301;
   }

   protected Message[] m_91be39c9() {
      return new Message[]{Message.of(this.getAddress())};
   }

   public C0144.anonymouscatch m_d8f4b1f5() {
      return this.f_03a99b50;
   }

   public Message m_2d348094() {
      return this.f_ea13adf7;
   }

   public boolean m_275ab222() {
      return this.f_87ca682e;
   }

   public boolean m_f21a055b() {
      return this.f_0b4e307b;
   }

   public long m_c495d695() {
      return this.f_85a454c8;
   }

   public void m_c93f373e(C0144.anonymouscatch var1) {
      this.f_03a99b50 = var1;
   }

   public void m_8d564dc2(Message var1) {
      this.f_ea13adf7 = var1;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_87ca682e = var1;
   }

   public void m_394ecb95(boolean var1) {
      this.f_0b4e307b = var1;
   }

   public void m_ad6c7e6f(long var1) {
      this.f_85a454c8 = var1;
   }

   public void m_eb5ceeb6(Message[] var1) {
      this.f_879a6301 = var1;
   }

   public static enum anonymouscatch {
      f_c8c15b48,
      f_a2f15feb,
      f_1442a648;

      private anonymouscatch() {
      }
   }
}
