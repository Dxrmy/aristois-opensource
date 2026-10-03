package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;

public class C0042 extends C0001 {
   public C0042() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934684>())
                  .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934685>()).executes(var0 -> {
                     C0241.f_a7469a4f = true;
                     C0289.f_c22b8d7e.m_ea73e1f0().forEach(var0x -> {
                        if (var0x.isEnabled()) {
                           var0x.toggle();
                        }
                     });
                     C0114.bootstrap<"call",0,1>().m_1ad98e94().m_f378a521();
                     C0114.bootstrap<"call",1,1>();
                     C0114.bootstrap<"call",2,1>().m_6b4e8235(C0252.bootstrap<"get",8589934688>()).m_77a7bc18(C0252.bootstrap<"get",8589934689>()).m_66e721c0();
                     return 1;
                  })))
               .executes(var0 -> {
                  C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934686>() + C0114.bootstrap<"call",0,1>() + C0252.bootstrap<"get",8589934687>());
                  return 1;
               })
         );
   }
}
