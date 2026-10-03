package me.deftware.aristois.recovered;

import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.network.packets.CPacketPosition;

public class C0033 extends C0001 {
   public C0033() {
   }

   public static boolean m_208a83c8(int var0) {
      MainEntityPlayer var1 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (var1.isCreative()) {
         C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",8589934620>()).m_66e721c0();
         return false;
      } else if (C0114.bootstrap<"call",3,1>(C0382.class)) {
         C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",8589934621>()).m_66e721c0();
         return false;
      } else {
         double var2 = var1.getPosX();
         double var4 = var1.getPosY();
         double var6 = var1.getPosZ();

         for (int var8 = 0; var8 < 80; var8++) {
            new CPacketPosition(var2, var4 + (double)var0 + 2.1, var6, false).sendImmediately();
            new CPacketPosition(var2, var4 + 0.05, var6, false).sendImmediately();
         }

         new CPacketPosition(var2, var4, var6, true).sendImmediately();
         return true;
      }
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().addCommand(C0252.bootstrap<"get",8589934622>(), var0 -> {
         if (C0114.bootstrap<"call",4,1>(1)) {
            C0114.bootstrap<"call",5,1>().m_77a7bc18(C0252.bootstrap<"get",8589934623>()).m_66e721c0();
         }
      });
   }
}
