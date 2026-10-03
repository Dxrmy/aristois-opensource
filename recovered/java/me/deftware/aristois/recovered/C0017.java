package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.nbt.NbtList;
import me.deftware.client.framework.network.packets.CPacketEditBook;

public class C0017 extends C0001 {
   private boolean f_a57bd513 = false;

   public C0017() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0264.m_733bff3d())
                     .then(
                        ((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0264.m_76700429())
                              .then(
                                 ((RequiredArgumentBuilder)RequiredArgumentBuilder.argument(C0264.m_8870d2c1(), IntegerArgumentType.integer())
                                       .then(
                                          RequiredArgumentBuilder.argument(C0264.m_a004d745(), StringArgumentType.string())
                                             .executes(
                                                var1 -> this.m_e40ef766(
                                                      C0264.m_76700429(),
                                                      IntegerArgumentType.getInteger(var1, C0264.m_8870d2c1()),
                                                      StringArgumentType.getString(var1, C0264.m_a004d745())
                                                   )
                                             )
                                       ))
                                    .executes(var1 -> this.m_e40ef766(C0264.m_76700429(), IntegerArgumentType.getInteger(var1, C0264.m_8870d2c1()), ""))
                              ))
                           .executes(var1 -> this.m_e40ef766(C0264.m_76700429(), 0, ""))
                     ))
                  .then(
                     ((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0264.m_3c19a819())
                           .then(
                              ((RequiredArgumentBuilder)RequiredArgumentBuilder.argument(C0264.m_8870d2c1(), IntegerArgumentType.integer())
                                    .then(
                                       RequiredArgumentBuilder.argument(C0264.m_a004d745(), StringArgumentType.string())
                                          .executes(
                                             var1 -> this.m_e40ef766(
                                                   C0264.m_3c19a819(),
                                                   IntegerArgumentType.getInteger(var1, C0264.m_8870d2c1()),
                                                   StringArgumentType.getString(var1, C0264.m_a004d745())
                                                )
                                          )
                                    ))
                                 .executes(var1 -> this.m_e40ef766(C0264.m_3c19a819(), IntegerArgumentType.getInteger(var1, C0264.m_8870d2c1()), ""))
                           ))
                        .executes(var1 -> this.m_e40ef766(C0264.m_3c19a819(), 0, ""))
                  ))
               .then(
                  ((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0264.m_f599ae93())
                        .then(
                           ((RequiredArgumentBuilder)RequiredArgumentBuilder.argument(C0264.m_8870d2c1(), IntegerArgumentType.integer())
                                 .then(
                                    RequiredArgumentBuilder.argument(C0264.m_a004d745(), StringArgumentType.string())
                                       .executes(
                                          var1 -> this.m_e40ef766(
                                                C0264.m_f599ae93(),
                                                IntegerArgumentType.getInteger(var1, C0264.m_8870d2c1()),
                                                StringArgumentType.getString(var1, C0264.m_a004d745())
                                             )
                                       )
                                 ))
                              .executes(var1 -> this.m_e40ef766(C0264.m_f599ae93(), IntegerArgumentType.getInteger(var1, C0264.m_8870d2c1()), ""))
                        ))
                     .executes(var1 -> this.m_e40ef766(C0264.m_f599ae93(), 0, ""))
               )
         );
   }

   private int m_e40ef766(String var1, int var2, String var3) {
      if (Minecraft.getMinecraftProtocolVersion() > 498 && !this.f_a57bd513) {
         m_333019c8(C0264.m_5b2d5cb2());
         m_333019c8(C0264.m_56cd5284());
         this.f_a57bd513 = true;
         return -1;
      } else {
         EntityPlayer var4 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
         Random var5 = var3.equals("") ? new Random() : new Random(Long.parseLong(var3));
         int var6 = var2 == 0 ? 50 : var2;
         ItemStack var7 = var4.getInventory().getHeldItem(false);
         if (!var7.getItem().instanceOf(ItemType.WritableBook)) {
            C0064.m_7853c016().m_ee04ba1b(C0264.m_62895921()).m_1058ed9a();
            return -1;
         } else {
            IntStream var8 = null;
            switch (var1) {
               case C0264.m_76700429():
                  var8 = IntStream.generate(() -> 1114111);
                  break;
               case C0264.m_3c19a819():
                  var8 = var5.ints(128, 1112063).map(var0 -> var0 < 55296 ? var0 : var0 + 2048);
                  break;
               case C0264.m_f599ae93():
                  var8 = var5.ints(32, 127);
            }

            if (var8 != null) {
               String var9 = var8.limit(10500L).mapToObj(var0 -> String.valueOf((char)var0)).collect(Collectors.joining());
               NbtList var12 = new NbtList();

               for (int var11 = 0; var11 < var6; var11++) {
                  var12.appendTag(var9.substring(var11 * 210, (var11 + 1) * 210));
               }

               if (var7.hasNbt()) {
                  var7.getNbt().setTagInfo(C0264.m_8870d2c1(), var12);
               } else {
                  var7.setNbtList(C0264.m_8870d2c1(), var12);
               }
            }

            new CPacketEditBook(var7).sendPacket();
            C0064.m_13c9ffeb().m_ee04ba1b(C0264.m_ec4ef19a()).m_1058ed9a();
            return 1;
         }
      }
   }
}
