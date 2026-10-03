package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.Message;

public class C0036 extends C0001 {
   public C0036() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901950>())
               .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",12884901951>(), C0114.bootstrap<"call",1,1>()).executes(var0 -> {
                  EntityPlayer var1 = (EntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
                  if (!var1.isCreative()) {
                     C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",12884901952>()).m_66e721c0();
                  } else {
                     Message var2 = C0114.bootstrap<"call",4,1>(
                        C0114.bootstrap<"call",3,1>(var0, C0252.bootstrap<"get",12884901951>()), C0252.bootstrap<"get",73>()
                     );
                     ItemStack var3 = var1.getInventory().getHeldItem(false);
                     if (var3 != null && !var3.isEmpty()) {
                        var3.setStackDisplayName(var2);
                        C0114.bootstrap<"call",5,1>().m_5de8d0b8(C0252.bootstrap<"get",12884901954>(), var2).m_66e721c0();
                     } else {
                        C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",12884901953>()).m_66e721c0();
                     }
                  }

                  return 1;
               }))
         );
   }
}
