package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.Optional;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.entity.types.EntityPlayer;

public class C0040 extends C0001 {
   public C0040() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934640>())
               .then(
                  C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",94>(), C0114.bootstrap<"call",1,1>())
                     .executes(
                        var0 -> {
                           EntityPlayer var1 = (EntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
                           if (var1.isCreative()) {
                              C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",8589934641>()).m_66e721c0();
                           } else {
                              C0114.bootstrap<"call",3,1>().m_77a7bc18(C0252.bootstrap<"get",8589934642>()).m_66e721c0();
                              C0114.bootstrap<"call",0,1>()
                                 .runOnRenderThread(
                                    () -> {
                                       String var1x = C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",94>());
                                       Optional var2 = C0114.bootstrap<"call",1,1>()
                                          .getLoadedEntities()
                                          .filter(var0xx -> var0xx instanceof EntityPlayer)
                                          .filter(var1xx -> ((EntityPlayer)var1xx).getUsername().equalsIgnoreCase(var1x))
                                          .findFirst();
                                       if (var2.isPresent()) {
                                          C0114.bootstrap<"call",2,1>().m_5de8d0b8(C0252.bootstrap<"get",8589934643>(), var1x).m_66e721c0();
                                          ((EntityPlayer)var2.get()).openInventory();
                                       } else {
                                          C0114.bootstrap<"call",3,1>().m_5de8d0b8(C0252.bootstrap<"get",8589934644>(), var1x).m_66e721c0();
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
