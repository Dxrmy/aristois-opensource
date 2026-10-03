package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;

public class C0015 extends C0001 {
   public C0015() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_3d3a8736())
                  .then(RequiredArgumentBuilder.argument(C0266.m_818e6498(), new C0004(false)).executes(var0 -> {
                     AbstractMod var1 = (AbstractMod)var0.getArgument(C0266.m_818e6498(), AbstractMod.class);
                     C0064.m_13c9ffeb().m_ecf8e7ae(C0266.m_022da1b4(), var1.m_6f1f396d()).m_2c2620fc(C0266.m_6e2d03c3()).m_1058ed9a();
                     var1.getKeybind().m_1058ed9a();
                     return 1;
                  })))
               .then(LiteralArgumentBuilder.literal(C0253.m_d32ebe65()).executes(var0 -> {
                  C0289.f_85a7343f.m_918b7b9e().filter(var0x -> !(var0x instanceof C0297)).forEach(var0x -> var0x.getKeybind().m_1058ed9a());
                  C0064.m_13c9ffeb().m_ee04ba1b(C0266.m_94acbdac()).m_1058ed9a();
                  return 1;
               }))
         );
   }
}
