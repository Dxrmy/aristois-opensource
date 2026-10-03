package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;

public class C0041 extends C0001 {
   public C0041() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967421>())
               .then(
                  ((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967422>())
                        .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967423>(), C0114.bootstrap<"call",1,1>()).executes(var0 -> {
                           int var1 = C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",4294967423>());
                           C0114.bootstrap<"call",1,1>().getGameChat().remove(var1);
                           return 1;
                        })))
                     .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967424>()).executes(var0 -> {
                        C0114.bootstrap<"call",1,1>();
                        return 1;
                     }))
               )
         );
   }

   public static void m_83121775() {
      C0114.bootstrap<"call",0,1>()
         .getGameChat()
         .remove(
            var0 -> C0114.bootstrap<"call",0,1>(
                  var0.startsWith(C0252.bootstrap<"get",4294967324>())
                     || var0.startsWith(C0252.bootstrap<"get",4294967321>())
                     || var0.startsWith(C0252.bootstrap<"get",4294967425>())
                     || var0.startsWith(C0252.bootstrap<"get",8589934592>())
                     || var0.startsWith(C0252.bootstrap<"get",8589934593>())
               )
         );
   }
}
