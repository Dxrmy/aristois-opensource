package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.Collection;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.item.enchantment.Enchantment;
import me.deftware.client.framework.registry.EnchantmentRegistry;

public class C0038 extends C0001 {
   public C0038() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901936>())
                  .then(
                     ((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934630>())
                           .then(
                              C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901937>(), new C0002())
                                 .then(
                                    C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901938>(), C0114.bootstrap<"call",2,1>(-32767, 32767))
                                       .executes(
                                          var1 -> {
                                             this.m_818921c8(
                                                (Enchantment)var1.getArgument(C0252.bootstrap<"get",12884901937>(), Enchantment.class),
                                                C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",12884901938>()),
                                                true,
                                                false
                                             );
                                             return 1;
                                          }
                                       )
                                 )
                           ))
                        .then(
                           C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934630>())
                              .then(
                                 C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901938>(), C0114.bootstrap<"call",2,1>(-32767, 32767))
                                    .executes(var1 -> {
                                       this.m_818921c8(null, C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",12884901938>()), true, true);
                                       return 1;
                                    })
                              )
                        )
                  ))
               .then(
                  ((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901939>())
                        .then(
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901937>(), new C0002())
                              .then(
                                 C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901938>(), C0114.bootstrap<"call",2,1>(-32767, 32767))
                                    .executes(
                                       var1 -> {
                                          this.m_818921c8(
                                             (Enchantment)var1.getArgument(C0252.bootstrap<"get",12884901937>(), Enchantment.class),
                                             C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",12884901938>()),
                                             false,
                                             false
                                          );
                                          return 1;
                                       }
                                    )
                              )
                        ))
                     .then(
                        C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934630>())
                           .then(
                              C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901938>(), C0114.bootstrap<"call",2,1>(-32767, 32767)).executes(var1 -> {
                                 this.m_818921c8(null, C0114.bootstrap<"call",8,1>(var1, C0252.bootstrap<"get",12884901938>()), false, true);
                                 return 1;
                              })
                           )
                     )
               )
         );
   }

   private void m_ff15c818(ItemStack var1, Collection<Enchantment> var2, int var3) {
      var2.forEach(var2x -> var1.addEnchantment(var2x, var3));
   }

   private boolean m_8d1411f8(ItemStack var1) {
      boolean var2 = var1.getItem().getIdentifierKey().toLowerCase().contains(C0252.bootstrap<"get",12884901940>())
         || var1.getItem().getIdentifierKey().toLowerCase().contains(C0252.bootstrap<"get",12884901941>());
      return var2 && var1.getItem().instanceOf(ItemType.ItemBlock);
   }

   private void m_818921c8(Enchantment var1, int var2, boolean var3, boolean var4) {
      EntityPlayer var5 = (EntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!var5.isCreative()) {
         C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",12884901942>()).m_66e721c0();
      } else {
         int var6 = 0;
         Object var7 = var4 ? (Collection)EnchantmentRegistry.INSTANCE.stream().collect(C0114.bootstrap<"call",3,1>()) : C0114.bootstrap<"call",4,1>(var1);
         if (var3) {
            for (int var10 = 0; var10 < 40; var10++) {
               ItemStack var9 = var5.getInventory().getStackInSlot(var10);
               if (!var9.isEmpty() && !this.m_8d1411f8(var9)) {
                  this.m_ff15c818(var9, (Collection<Enchantment>)var7, var2);
                  var6++;
               }
            }
         } else {
            ItemStack var8 = var5.getInventory().getHeldItem(false);
            if (!var8.isEmpty() && !this.m_8d1411f8(var8)) {
               this.m_ff15c818(var8, (Collection<Enchantment>)var7, var2);
               var6++;
            }
         }

         if (var6 == 0) {
            C0114.bootstrap<"call",5,1>().m_77a7bc18(C0252.bootstrap<"get",12884901943>()).m_66e721c0();
         } else {
            C0114.bootstrap<"call",6,1>().m_5de8d0b8(C0252.bootstrap<"get",12884901944>(), C0114.bootstrap<"call",7,1>(var6)).m_66e721c0();
         }
      }
   }
}
