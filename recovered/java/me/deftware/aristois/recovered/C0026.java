package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.io.File;
import me.deftware.client.framework.command.CommandBuilder;

public class C0026 extends C0001 {
   public C0026() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934707>())
               .then(
                  ((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934708>())
                           .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934709>()).executes(var0 -> {
                              ((C0296)C0114.bootstrap<"call",0,1>(C0296.class)).m_a6cf6621(new File(""));
                              C0223.f_7c6d0315.m_b8fdf5b9();
                              C0114.bootstrap<"call",1,1>().m_77a7bc18(C0252.bootstrap<"get",8589934714>()).m_66e721c0();
                              return 1;
                           })))
                        .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934710>()).executes(var0 -> {
                           ((C0432)C0114.bootstrap<"call",0,1>(C0432.class)).m_acdf166b();
                           C0114.bootstrap<"call",1,1>().m_77a7bc18(C0252.bootstrap<"get",8589934713>()).m_66e721c0();
                           return 1;
                        })))
                     .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934711>()).executes(var0 -> {
                        ((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_bd86fc72().m_1c30b0a8().m_b66ba0ac();
                        C0114.bootstrap<"call",1,1>().m_77a7bc18(C0252.bootstrap<"get",8589934712>()).m_66e721c0();
                        return 1;
                     }))
               )
         );
   }
}
