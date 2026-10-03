package me.deftware.aristois.recovered;

import java.util.function.Consumer;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;

public abstract class C0001 extends EMCModCommand {
   public C0001() {
   }

   public static Builder m_3ce42128(String var0) {
      return new Builder()
         .append(var0 + C0257.m_593ecbab(), Appearance.of(2, DefaultColors.AQUA))
         .append(Message.CHEVRON + C0257.m_593ecbab(), Appearance.of(2, DefaultColors.GRAY));
   }

   public static void m_d8b513bd(Message var0, FormattingColor var1) {
      m_3ce42128(C0264.m_5fa6dd07()).append(var0, Appearance.of(var1)).build().print();
   }

   public static void m_8d564dc2(Message var0) {
      m_d8b513bd(var0, DefaultColors.GRAY);
   }

   public static void m_efb6bb0d(Message var0) {
      m_d8b513bd(var0, DefaultColors.YELLOW);
   }

   public static void m_3a455556(Message var0) {
      m_d8b513bd(var0, DefaultColors.RED);
   }

   public static void m_a11708c5(String var0) {
      m_8d564dc2(Message.of(var0));
   }

   public static void m_333019c8(String var0) {
      m_efb6bb0d(Message.of(var0));
   }

   public static void error(String var0) {
      m_3a455556(Message.of(var0));
   }

   public static void m_8befc5f8(Consumer<Message> var0, String var1, Object... var2) {
      var0.accept(Message.of(String.format(var1, var2)));
   }
}
