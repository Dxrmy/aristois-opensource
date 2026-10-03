package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;

public class C0024 extends C0001 {
   public C0024() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934624>())
               .then(
                  C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934625>(), C0114.bootstrap<"call",1,1>())
                     .executes(
                        var0 -> {
                           C0114.bootstrap<"call",2,1>(
                              C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934625>()), C0252.bootstrap<"get",73>())
                           );
                           return 1;
                        }
                     )
               )
         );
   }
}
