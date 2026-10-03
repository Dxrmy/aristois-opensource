package me.deftware.aristois.recovered;

import me.deftware.aristois.main.Main;
import me.deftware.client.framework.command.CommandBuilder;

public class C0032 extends C0001 {
   public C0032() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().addCommand(C0253.m_62895921(), var0 -> {
         m_a11708c5(C0253.m_ec4ef19a());
         m_333019c8(C0253.m_83f6dd00());
         m_333019c8(C0253.m_56c1229f());
         m_333019c8(C0253.m_0d6ae39b());
         m_333019c8(C0253.m_65d43991());
         m_333019c8(C0253.m_c6614274());
         m_333019c8(C0266.m_44418b5d());
         m_333019c8(C0266.m_813e3509());
         m_333019c8(C0266.m_3855be80());
         m_333019c8(C0266.m_a9247108());
         m_333019c8(C0266.m_4626ac74());
         m_333019c8(C0266.m_c688f8ca());
         Main.getConfig().putPrimitive(C0266.m_35cdaa1a(), true);
         Main.getConfig().save();
         m_a11708c5(C0266.m_624b40d8());
      });
   }
}
