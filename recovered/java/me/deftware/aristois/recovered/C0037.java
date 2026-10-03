package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.item.IItem;
import me.deftware.client.framework.item.ItemStack;

public class C0037 extends C0001 {
   public C0037() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901945>())
               .then(
                  C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901946>(), new C0008())
                     .then(
                        C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901947>(), C0114.bootstrap<"call",2,1>(1, 64))
                           .executes(
                              var1 -> {
                                 this.m_7253704c(
                                    (IItem)var1.getArgument(C0252.bootstrap<"get",12884901946>(), IItem.class),
                                    C0114.bootstrap<"call",5,1>(var1, C0252.bootstrap<"get",12884901947>())
                                 );
                                 return 1;
                              }
                           )
                     )
               )
         );
   }

   private void m_7253704c(IItem var1, int var2) {
      MainEntityPlayer var3 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!var3.isCreative()) {
         C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",12884901948>()).m_66e721c0();
      } else {
         ItemStack var4 = new ItemStack(var1, var2);
         var3.placeStackInHotbar(var4);
         C0114.bootstrap<"call",3,1>().m_5de8d0b8(C0252.bootstrap<"get",12884901949>(), C0114.bootstrap<"call",4,1>(var2)).m_66e721c0();
      }
   }
}
