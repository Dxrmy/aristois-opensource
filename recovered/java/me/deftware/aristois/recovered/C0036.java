package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Objects;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0036 extends C0001 {
   public C0036() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_d9b37a36())
               .then(RequiredArgumentBuilder.argument(C0266.m_15737526(), StringArgumentType.greedyString()).executes(var0 -> {
                  EntityPlayer var1 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
                  if (!var1.isCreative()) {
                     C0064.m_7853c016().m_ee04ba1b(C0266.m_6cf615ba()).m_1058ed9a();
                  } else {
                     Message var2 = C0197.m_683b6390(StringArgumentType.getString(var0, C0266.m_15737526()), C0257.m_d1f7b79f());
                     ItemStack var3 = var1.getInventory().getHeldItem(false);
                     if (var3 != null && !var3.isEmpty()) {
                        var3.setStackDisplayName(var2);
                        C0064.m_13c9ffeb().m_ecf8e7ae(C0266.m_b526dd3b(), var2).m_1058ed9a();
                     } else {
                        C0064.m_7853c016().m_ee04ba1b(C0266.m_ecb46027()).m_1058ed9a();
                     }
                  }

                  return 1;
               }))
         );
   }
}
