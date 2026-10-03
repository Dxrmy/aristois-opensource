package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.gui.screens.ConnectingScreen;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.minecraft.ServerDetails;
import me.deftware.client.framework.world.ClientWorld;

public class C0031 extends C0001 {
   public C0031() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(
                           C0266.m_c42f1c7e()
                        )
                        .executes(var1 -> {
                           this.m_1058ed9a();
                           return 1;
                        }))
                     .then(LiteralArgumentBuilder.literal(C0266.m_6f1f396d()).executes(var0 -> {
                        ClientWorld.getClientWorld()._disconnect();
                        return 1;
                     })))
                  .then(LiteralArgumentBuilder.literal(C0266.m_8ced16bd()).executes(var0 -> {
                     if (Minecraft.getMinecraftGame().getLastConnectedServer() != null) {
                        ClientWorld.getClientWorld()._disconnect();
                        ConnectingScreen._connect(Minecraft.getMinecraftGame().getLastConnectedServer());
                     } else {
                        m_333019c8(C0266.m_b251ca51());
                     }

                     return 1;
                  })))
               .then(LiteralArgumentBuilder.literal(C0264.m_44418b5d()).executes(var1 -> {
                  this.m_1058ed9a();
                  return 1;
               }))
         );
   }

   private void m_1058ed9a() {
      if (Minecraft.getMinecraftGame()._isSinglePlayer()) {
         C0064.m_13c9ffeb().m_ee04ba1b(C0266.m_15ef1a0d()).m_1058ed9a();
      } else {
         try {
            ServerDetails var1 = Minecraft.getMinecraftGame().getConnectedServer();
            if (var1 == null) {
               throw new Exception(C0266.m_9793dfe2());
            }

            m_a11708c5(C0266.m_1635bc47() + Minecraft.getMinecraftProtocolVersion());
            m_a11708c5(C0266.m_d597c122() + var1._getAddress());
            m_a11708c5(C0266.m_18204724() + var1._getMotd());
         } catch (Exception var2) {
            C0064.m_7853c016().m_ee04ba1b(C0266.m_cf4f91f1()).m_1058ed9a();
         }
      }
   }
}
