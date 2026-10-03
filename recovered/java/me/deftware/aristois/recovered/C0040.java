package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Objects;
import java.util.Optional;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;

public class C0040 extends C0001 {
   public C0040() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_7f74d855())
               .then(
                  RequiredArgumentBuilder.argument(C0257.m_85cd13b4(), StringArgumentType.string())
                     .executes(
                        var0 -> {
                           EntityPlayer var1 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
                           if (var1.isCreative()) {
                              C0064.m_7853c016().m_ee04ba1b(C0253.m_b89b7876()).m_1058ed9a();
                           } else {
                              C0064.m_13c9ffeb().m_ee04ba1b(C0253.m_a33fab52()).m_1058ed9a();
                              Minecraft.getMinecraftGame()
                                 .runOnRenderThread(
                                    () -> {
                                       String var1x = StringArgumentType.getString(var0, C0257.m_85cd13b4());
                                       Optional var2 = ClientWorld.getClientWorld()
                                          .getLoadedEntities()
                                          .filter(var0xx -> var0xx instanceof EntityPlayer)
                                          .filter(var1xx -> ((EntityPlayer)var1xx).getUsername().equalsIgnoreCase(var1x))
                                          .findFirst();
                                       if (var2.isPresent()) {
                                          C0064.m_13c9ffeb().m_ecf8e7ae(C0253.m_73708dd3(), var1x).m_1058ed9a();
                                          ((EntityPlayer)var2.get()).openInventory();
                                       } else {
                                          C0064.m_7853c016().m_ecf8e7ae(C0253.m_96ba50d4(), var1x).m_1058ed9a();
                                       }
                                    }
                                 );
                           }

                           return 1;
                        }
                     )
               )
         );
   }
}
