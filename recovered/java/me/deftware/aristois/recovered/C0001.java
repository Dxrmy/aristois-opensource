package me.deftware.aristois.recovered;

import java.util.function.Consumer;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;

public abstract class C0001 extends EMCModCommand {
   public C0001() {
   }

   public static Builder m_3a1611f6(String var0) {
      return new Builder()
         .append(var0 + C0252.bootstrap<"get",70>(), C0114.bootstrap<"call",0,1>(2, DefaultColors.AQUA))
         .append(Message.CHEVRON + C0252.bootstrap<"get",70>(), C0114.bootstrap<"call",0,1>(2, DefaultColors.GRAY));
   }

   public static void m_87926db2(Message var0, FormattingColor var1) {
      C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967324>()).append(var0, C0114.bootstrap<"call",2,1>(var1)).build().print();
   }

   public static void m_71f9f90c(Message var0) {
      C0114.bootstrap<"call",3,1>(var0, DefaultColors.GRAY);
   }

   public static void m_e4740c2a(Message var0) {
      C0114.bootstrap<"call",0,1>(var0, DefaultColors.YELLOW);
   }

   public static void m_2b1d05e5(Message var0) {
      C0114.bootstrap<"call",0,1>(var0, DefaultColors.RED);
   }

   public static void m_07d36d22(String var0) {
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var0));
   }

   public static void m_a0e5bdda(String var0) {
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var0));
   }

   public static void error(String var0) {
      C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var0));
   }

   public static void m_9e1cd68e(Consumer<Message> var0, String var1, Object... var2) {
      var0.accept(C0114.bootstrap<"call",5,1>(C0114.bootstrap<"call",4,1>(var1, var2)));
   }
}
