package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;

public class C0028 extends C0001 {
   public C0028() {
   }

   public C0005 m_9fb7fd90() {
      return new C0005(new C0005.anonymouscatch() {
         @Override
         public int m_79bbc2da() {
            return C0250.m_a13a31bc().size();
         }

         @Override
         public String m_5fe4c734(int var1) {
            return C0250.m_a13a31bc().get(var1).m_3d3a8736();
         }
      });
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_6e2d03c3())
                     .then(
                        LiteralArgumentBuilder.literal(C0253.m_56d4c1c7())
                           .then(RequiredArgumentBuilder.argument(C0257.m_85cd13b4(), StringArgumentType.string()).executes(var1 -> {
                              this.m_e9e19dbb(true, StringArgumentType.getString(var1, C0257.m_85cd13b4()));
                              return 1;
                           }))
                     ))
                  .then(
                     LiteralArgumentBuilder.literal(C0257.m_0223faff())
                        .then(RequiredArgumentBuilder.argument(C0257.m_85cd13b4(), this.m_9fb7fd90()).executes(var1 -> {
                           this.m_e9e19dbb(false, StringArgumentType.getString(var1, C0257.m_85cd13b4()));
                           return 1;
                        }))
                  ))
               .then(LiteralArgumentBuilder.literal(C0253.m_afb31f66()).executes(var0 -> {
                  m_a11708c5(C0253.m_4e02e7a9());
                  C0250.m_a13a31bc().forEach(var0x -> m_a11708c5(var0x.m_3d3a8736()));
                  return 1;
               }))
         );
   }

   public void m_e9e19dbb(boolean var1, String var2) {
      C0250 var3 = new C0250();
      var3.m_a11708c5(var2);
      if (var1) {
         C0250.m_a13a31bc().add(var3);
         C0064.m_13c9ffeb().m_ecf8e7ae(C0253.m_760db7bb(), var2).m_1058ed9a();
      } else {
         C0250.m_a13a31bc().remove(var3);
         C0064.m_13c9ffeb().m_ecf8e7ae(C0253.m_68957b31(), var2).m_1058ed9a();
      }
   }
}
