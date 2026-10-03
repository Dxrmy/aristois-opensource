package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketPosition;

public class C0033 extends C0001 {
   public C0033() {
   }

   public static boolean m_1521b1fa(int var0) {
      MainEntityPlayer var1 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (var1.isCreative()) {
         C0064.m_7853c016().m_ee04ba1b(C0253.m_5fa6dd07()).m_1058ed9a();
         return false;
      } else if (C0289.m_5caae0c3(C0382.class)) {
         C0064.m_7853c016().m_ee04ba1b(C0253.m_5f1ab561()).m_1058ed9a();
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
      return new CommandBuilder().addCommand(C0253.m_28b2c020(), var0 -> {
         if (m_1521b1fa(1)) {
            C0064.m_13c9ffeb().m_ee04ba1b(C0253.m_45aaaba8()).m_1058ed9a();
         }
      });
   }
}
