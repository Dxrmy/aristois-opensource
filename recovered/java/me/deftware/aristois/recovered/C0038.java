package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.item.enchantment.Enchantment;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.registry.EnchantmentRegistry;

public class C0038 extends C0001 {
   public C0038() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_7f74d855())
                  .then(
                     ((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_d32ebe65())
                           .then(
                              RequiredArgumentBuilder.argument(C0266.m_b89b7876(), new C0002())
                                 .then(
                                    RequiredArgumentBuilder.argument(C0266.m_a33fab52(), IntegerArgumentType.integer(-32767, 32767))
                                       .executes(
                                          var1 -> {
                                             this.m_17c046ec(
                                                (Enchantment)var1.getArgument(C0266.m_b89b7876(), Enchantment.class),
                                                IntegerArgumentType.getInteger(var1, C0266.m_a33fab52()),
                                                true,
                                                false
                                             );
                                             return 1;
                                          }
                                       )
                                 )
                           ))
                        .then(
                           LiteralArgumentBuilder.literal(C0253.m_d32ebe65())
                              .then(RequiredArgumentBuilder.argument(C0266.m_a33fab52(), IntegerArgumentType.integer(-32767, 32767)).executes(var1 -> {
                                 this.m_17c046ec(null, IntegerArgumentType.getInteger(var1, C0266.m_a33fab52()), true, true);
                                 return 1;
                              }))
                        )
                  ))
               .then(
                  ((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_73708dd3())
                        .then(
                           RequiredArgumentBuilder.argument(C0266.m_b89b7876(), new C0002())
                              .then(
                                 RequiredArgumentBuilder.argument(C0266.m_a33fab52(), IntegerArgumentType.integer(-32767, 32767))
                                    .executes(
                                       var1 -> {
                                          this.m_17c046ec(
                                             (Enchantment)var1.getArgument(C0266.m_b89b7876(), Enchantment.class),
                                             IntegerArgumentType.getInteger(var1, C0266.m_a33fab52()),
                                             false,
                                             false
                                          );
                                          return 1;
                                       }
                                    )
                              )
                        ))
                     .then(
                        LiteralArgumentBuilder.literal(C0253.m_d32ebe65())
                           .then(RequiredArgumentBuilder.argument(C0266.m_a33fab52(), IntegerArgumentType.integer(-32767, 32767)).executes(var1 -> {
                              this.m_17c046ec(null, IntegerArgumentType.getInteger(var1, C0266.m_a33fab52()), false, true);
                              return 1;
                           }))
                     )
               )
         );
   }

   private void m_65bbd62e(ItemStack var1, Collection<Enchantment> var2, int var3) {
      var2.forEach(var2x -> var1.addEnchantment(var2x, var3));
   }

   private boolean m_0ef10883(ItemStack var1) {
      boolean var2 = var1.getItem().getIdentifierKey().toLowerCase().contains(C0266.m_96ba50d4())
         || var1.getItem().getIdentifierKey().toLowerCase().contains(C0266.m_88726494());
      return var2 && var1.getItem().instanceOf(ItemType.ItemBlock);
   }

   private void m_17c046ec(Enchantment var1, int var2, boolean var3, boolean var4) {
      EntityPlayer var5 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!var5.isCreative()) {
         C0064.m_7853c016().m_ee04ba1b(C0266.m_27479cfa()).m_1058ed9a();
      } else {
         int var6 = 0;
         Object var7 = var4 ? (Collection)EnchantmentRegistry.INSTANCE.stream().collect(Collectors.toList()) : Collections.singletonList(var1);
         if (var3) {
            for (int var10 = 0; var10 < 40; var10++) {
               ItemStack var9 = var5.getInventory().getStackInSlot(var10);
               if (!var9.isEmpty() && !this.m_0ef10883(var9)) {
                  this.m_65bbd62e(var9, (Collection<Enchantment>)var7, var2);
                  var6++;
               }
            }
         } else {
            ItemStack var8 = var5.getInventory().getHeldItem(false);
            if (!var8.isEmpty() && !this.m_0ef10883(var8)) {
               this.m_65bbd62e(var8, (Collection<Enchantment>)var7, var2);
               var6++;
            }
         }

         if (var6 == 0) {
            C0064.m_b79f2e94().m_ee04ba1b(C0266.m_23f794da()).m_1058ed9a();
         } else {
            C0064.m_13c9ffeb().m_ecf8e7ae(C0266.m_cc27b633(), var6).m_1058ed9a();
         }
      }
   }
}
