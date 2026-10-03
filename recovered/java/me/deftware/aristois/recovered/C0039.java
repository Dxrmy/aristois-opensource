package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.io.File;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0039 extends C0001 {
   private static final List<Class<?>> f_a24b322f = C0114.bootstrap<"call",0,1>(new Class[]{File.class, Runnable.class, C0245.class});

   public C0039() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901912>())
               .then(
                  ((RequiredArgumentBuilder)((RequiredArgumentBuilder)C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967384>(), new C0004(true))
                           .then(
                              ((RequiredArgumentBuilder)((RequiredArgumentBuilder)C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967383>(), new C0011())
                                       .then(
                                          C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901913>(), new C0010())
                                             .executes(
                                                var1 -> this.m_778a4761(
                                                      (C0217.anonymousthis)var1.getArgument(C0252.bootstrap<"get",4294967384>(), AbstractMod.class),
                                                      (C0094<?>)var1.getArgument(C0252.bootstrap<"get",4294967383>(), C0094.class),
                                                      C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",12884901913>())
                                                   )
                                             )
                                       ))
                                    .executes(
                                       var0 -> {
                                          C0094 var1 = (C0094)var0.getArgument(C0252.bootstrap<"get",4294967383>(), C0094.class);
                                          if (!var1.m_d1f323bd() && !f_a24b322f.contains(var1.m_3ed0dd7b())) {
                                             C0114.bootstrap<"call",0,1>()
                                                .m_6b4e8235(C0252.bootstrap<"get",12884901920>())
                                                .m_77a7bc18(C0252.bootstrap<"get",12884901922>())
                                                .m_66e721c0();
                                          } else {
                                             var1.m_fb21cd76().m_6ed4f004(var1);
                                          }

                                          return 1;
                                       }
                                    ))
                                 .then(
                                    C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934707>())
                                       .executes(var1 -> this.m_157734aa((C0092)var1.getArgument(C0252.bootstrap<"get",4294967383>(), C0094.class)))
                                 )
                           ))
                        .then(
                           C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934707>())
                              .executes(var1 -> this.m_157734aa((C0092)var1.getArgument(C0252.bootstrap<"get",4294967384>(), AbstractMod.class)))
                        ))
                     .executes(var0 -> {
                        C0114.bootstrap<"call",4,1>()
                           .m_6b4e8235(C0252.bootstrap<"get",12884901920>())
                           .m_77a7bc18(C0252.bootstrap<"get",12884901921>())
                           .m_66e721c0();
                        return 1;
                     })
               )
         )
         .registerAlias(C0252.bootstrap<"get",12884901914>());
   }

   private <T extends C0092 & C0217.anonymousthis> int m_157734aa(T var1) {
      C0114.bootstrap<"call",0,1>()
         .m_6b4e8235(C0252.bootstrap<"get",12884901915>() + ((C0217.anonymousthis)var1).m_35ba7118())
         .m_b7d6d46c(var1.m_11cd7733())
         .m_66e721c0();
      return 1;
   }

   private int m_778a4761(C0217.anonymousthis var1, C0094<?> var2, String var3) {
      return C0114.bootstrap<"call",1,1>(
         () -> {
            if (!var2.m_027da45d(var3)) {
               throw new Exception(C0252.bootstrap<"get",12884901916>());
            } else {
               Message var2x = new Builder()
                  .append(C0252.bootstrap<"get",12884901917>(), C0114.bootstrap<"call",2,1>(DefaultColors.GRAY))
                  .append(var2.m_b5ae4ee3(), C0114.bootstrap<"call",2,1>(DefaultColors.YELLOW))
                  .append(C0252.bootstrap<"get",12884901918>(), C0114.bootstrap<"call",2,1>(DefaultColors.GRAY))
                  .append(var3, C0114.bootstrap<"call",2,1>(DefaultColors.GREEN))
                  .build();
               C0114.bootstrap<"call",0,1>().m_6b4e8235(C0252.bootstrap<"get",12884901919>()).m_b7d6d46c(var2x).m_66e721c0();
               return C0114.bootstrap<"call",3,1>(1);
            }
         }
      );
   }
}
