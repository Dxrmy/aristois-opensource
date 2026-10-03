package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.main.bootstrap.Bootstrap;

public class C0023 extends C0001 {
   public C0023() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934645>())
                  .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934646>()).executes(var0 -> {
                     C0454 var1 = C0114.bootstrap<"call",0,1>().m_1ad98e94();
                     if (var1 != null && var1.m_cd9f89c5()) {
                        try {
                           var1.f_d1230043.close();
                        } catch (Throwable var3) {
                        }
                     } else {
                        C0114.bootstrap<"call",1,1>().m_77a7bc18(C0252.bootstrap<"get",8589934654>()).m_66e721c0();
                     }

                     return 1;
                  })))
               .then(
                  C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934647>())
                     .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934648>(), C0114.bootstrap<"call",1,1>()).executes(var0 -> {
                        String var1 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934648>()));
                        String var2 = Bootstrap.EMCSettings.getPrimitive(C0252.bootstrap<"get",8589934649>(), C0252.bootstrap<"get",8589934650>());
                        if (var1.equals(var2)) {
                           C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934651>(), new Object[]{var1}));
                        } else {
                           C0114.bootstrap<"call",4,1>().putPrimitive(C0252.bootstrap<"get",8589934652>(), var1);
                           C0114.bootstrap<"call",4,1>().save();
                           C0114.bootstrap<"call",5,1>(C0252.bootstrap<"get",8589934653>() + var1);
                        }

                        return 1;
                     }))
               )
         );
   }

   protected static String m_99314c13(String var0) {
      if (var0.startsWith(C0252.bootstrap<"get",4294967399>()) && var0.endsWith(C0252.bootstrap<"get",4294967399>())) {
         var0 = var0.substring(1, var0.length() - 1);
      }

      return var0;
   }
}
