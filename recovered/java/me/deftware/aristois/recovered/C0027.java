package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;

public class C0027 extends C0001 {
   public C0027() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901923>())
               .then(
                  C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901924>(), new C0004(false))
                     .executes(
                        var0 -> {
                           AbstractMod var1 = ((AbstractMod)var0.getArgument(C0252.bootstrap<"get",12884901924>(), AbstractMod.class)).toggle();
                           C0114.bootstrap<"call",0,1>()
                              .m_5de8d0b8(
                                 C0252.bootstrap<"get",12884901926>(),
                                 var1.isEnabled() ? C0252.bootstrap<"get",12884901927>() : C0252.bootstrap<"get",12884901928>(),
                                 var1.m_5aac041f()
                              )
                              .m_66e721c0();
                           return 1;
                        }
                     )
               )
         )
         .registerAlias(C0252.bootstrap<"get",12884901925>());
   }
}
