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
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_733bff3d())
               .then(
                  ((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_76700429())
                           .then(LiteralArgumentBuilder.literal(C0253.m_8870d2c1()).executes(var0 -> {
                              C0289.m_c3a8b502(C0296.class).m_1acc8b38(new File(""));
                              C0223.f_a04019fa.m_1058ed9a();
                              C0064.m_13c9ffeb().m_ee04ba1b(C0253.m_56cd5284()).m_1058ed9a();
                              return 1;
                           })))
                        .then(LiteralArgumentBuilder.literal(C0253.m_a004d745()).executes(var0 -> {
                           C0289.m_c3a8b502(C0432.class).m_6fc98322();
                           C0064.m_13c9ffeb().m_ee04ba1b(C0253.m_5b2d5cb2()).m_1058ed9a();
                           return 1;
                        })))
                     .then(LiteralArgumentBuilder.literal(C0253.m_3c19a819()).executes(var0 -> {
                        C0289.m_c3a8b502(C0297.class).m_c7e6be95().m_ac6eac3b().m_f1ec3ae8();
                        C0064.m_13c9ffeb().m_ee04ba1b(C0253.m_f599ae93()).m_1058ed9a();
                        return 1;
                     }))
               )
         );
   }
}
