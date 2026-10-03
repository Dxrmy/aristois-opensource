package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Objects;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.item.IItem;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0037 extends C0001 {
   public C0037() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_df6e621c())
               .then(
                  RequiredArgumentBuilder.argument(C0266.m_56242a84(), new C0008())
                     .then(RequiredArgumentBuilder.argument(C0266.m_9e27f038(), IntegerArgumentType.integer(1, 64)).executes(var1 -> {
                        this.m_b23f7997((IItem)var1.getArgument(C0266.m_56242a84(), IItem.class), IntegerArgumentType.getInteger(var1, C0266.m_9e27f038()));
                        return 1;
                     }))
               )
         );
   }

   private void m_b23f7997(IItem var1, int var2) {
      MainEntityPlayer var3 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!var3.isCreative()) {
         C0064.m_7853c016().m_ee04ba1b(C0266.m_af41331f()).m_1058ed9a();
      } else {
         ItemStack var4 = new ItemStack(var1, var2);
         var3.placeStackInHotbar(var4);
         C0064.m_13c9ffeb().m_ecf8e7ae(C0266.m_f257bcca(), var2).m_1058ed9a();
      }
   }
}
