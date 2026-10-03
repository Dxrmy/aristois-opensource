package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;

public class C0015 extends C0001 {
   public C0015() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901929>())
                  .then(
                     C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901924>(), new C0004(false))
                        .executes(
                           var0 -> {
                              AbstractMod var1 = (AbstractMod)var0.getArgument(C0252.bootstrap<"get",12884901924>(), AbstractMod.class);
                              C0114.bootstrap<"call",0,1>()
                                 .m_5de8d0b8(C0252.bootstrap<"get",12884901931>(), var1.m_5aac041f())
                                 .m_6b4e8235(C0252.bootstrap<"get",12884901932>())
                                 .m_66e721c0();
                              var1.getKeybind().m_fce13178();
                              return 1;
                           }
                        )
                  ))
               .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934630>()).executes(var0 -> {
                  C0289.f_c22b8d7e.m_ea73e1f0().filter(var0x -> !(var0x instanceof C0297)).forEach(var0x -> var0x.getKeybind().m_fce13178());
                  C0114.bootstrap<"call",0,1>().m_77a7bc18(C0252.bootstrap<"get",12884901930>()).m_66e721c0();
                  return 1;
               }))
         );
   }
}
