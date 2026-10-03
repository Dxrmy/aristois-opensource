package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Random;
import java.util.stream.IntStream;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.nbt.NbtList;
import me.deftware.client.framework.network.packets.CPacketEditBook;

public class C0017 extends C0001 {
   private boolean f_482892d2 = false;

   public C0017() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967411>())
                     .then(
                        ((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967412>())
                              .then(
                                 ((RequiredArgumentBuilder)C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967413>(), C0114.bootstrap<"call",1,1>())
                                       .then(
                                          C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967414>(), C0114.bootstrap<"call",3,1>())
                                             .executes(
                                                var1 -> this.m_2c15e70c(
                                                      C0252.bootstrap<"get",4294967412>(),
                                                      C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",4294967413>()),
                                                      C0114.bootstrap<"call",1,1>(var1, C0252.bootstrap<"get",4294967414>())
                                                   )
                                             )
                                       ))
                                    .executes(
                                       var1 -> this.m_2c15e70c(
                                             C0252.bootstrap<"get",4294967412>(), C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",4294967413>()), ""
                                          )
                                    )
                              ))
                           .executes(var1 -> this.m_2c15e70c(C0252.bootstrap<"get",4294967412>(), 0, ""))
                     ))
                  .then(
                     ((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967415>())
                           .then(
                              ((RequiredArgumentBuilder)C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967413>(), C0114.bootstrap<"call",1,1>())
                                    .then(
                                       C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967414>(), C0114.bootstrap<"call",3,1>())
                                          .executes(
                                             var1 -> this.m_2c15e70c(
                                                   C0252.bootstrap<"get",4294967415>(),
                                                   C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",4294967413>()),
                                                   C0114.bootstrap<"call",1,1>(var1, C0252.bootstrap<"get",4294967414>())
                                                )
                                          )
                                    ))
                                 .executes(
                                    var1 -> this.m_2c15e70c(
                                          C0252.bootstrap<"get",4294967415>(), C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",4294967413>()), ""
                                       )
                                 )
                           ))
                        .executes(var1 -> this.m_2c15e70c(C0252.bootstrap<"get",4294967415>(), 0, ""))
                  ))
               .then(
                  ((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967416>())
                        .then(
                           ((RequiredArgumentBuilder)C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967413>(), C0114.bootstrap<"call",1,1>())
                                 .then(
                                    C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967414>(), C0114.bootstrap<"call",3,1>())
                                       .executes(
                                          var1 -> this.m_2c15e70c(
                                                C0252.bootstrap<"get",4294967416>(),
                                                C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",4294967413>()),
                                                C0114.bootstrap<"call",1,1>(var1, C0252.bootstrap<"get",4294967414>())
                                             )
                                       )
                                 ))
                              .executes(
                                 var1 -> this.m_2c15e70c(
                                       C0252.bootstrap<"get",4294967416>(), C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",4294967413>()), ""
                                    )
                              )
                        ))
                     .executes(var1 -> this.m_2c15e70c(C0252.bootstrap<"get",4294967416>(), 0, ""))
               )
         );
   }

   private int m_2c15e70c(String var1, int var2, String var3) {
      if (C0114.bootstrap<"call",0,1>() > 498 && !this.f_482892d2) {
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967417>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967418>());
         this.f_482892d2 = true;
         return -1;
      } else {
         EntityPlayer var4 = (EntityPlayer)C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>()._getPlayer());
         Random var5 = var3.equals("") ? new Random() : new Random(C0114.bootstrap<"call",4,1>(var3));
         int var6 = var2 == 0 ? 50 : var2;
         ItemStack var7 = var4.getInventory().getHeldItem(false);
         if (!var7.getItem().instanceOf(ItemType.WritableBook)) {
            C0114.bootstrap<"call",5,1>().m_77a7bc18(C0252.bootstrap<"get",4294967419>()).m_66e721c0();
            return -1;
         } else {
            IntStream var8 = null;
            switch (var1) {
               case C0252.bootstrap<"get",4294967412>():
                  var8 = C0114.bootstrap<"call",6,1>(() -> 1114111);
                  break;
               case C0252.bootstrap<"get",4294967415>():
                  var8 = var5.ints(128, 1112063).map(var0 -> var0 < 55296 ? var0 : var0 + 2048);
                  break;
               case C0252.bootstrap<"get",4294967416>():
                  var8 = var5.ints(32, 127);
            }

            if (var8 != null) {
               String var9 = var8.limit(10500L).mapToObj(var0 -> C0114.bootstrap<"call",9,1>((char)var0)).collect(C0114.bootstrap<"call",7,1>());
               NbtList var12 = new NbtList();

               for (int var11 = 0; var11 < var6; var11++) {
                  var12.appendTag(var9.substring(var11 * 210, (var11 + 1) * 210));
               }

               if (var7.hasNbt()) {
                  var7.getNbt().setTagInfo(C0252.bootstrap<"get",4294967413>(), var12);
               } else {
                  var7.setNbtList(C0252.bootstrap<"get",4294967413>(), var12);
               }
            }

            new CPacketEditBook(var7).sendPacket();
            C0114.bootstrap<"call",8,1>().m_77a7bc18(C0252.bootstrap<"get",4294967420>()).m_66e721c0();
            return 1;
         }
      }
   }
}
