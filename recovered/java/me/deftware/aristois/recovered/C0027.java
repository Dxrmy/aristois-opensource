package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;

public class C0027 extends C0001 {
   public C0027() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_8631f87f())
               .then(RequiredArgumentBuilder.argument(C0266.m_818e6498(), new C0004(false)).executes(var0 -> {
                  AbstractMod var1 = ((AbstractMod)var0.getArgument(C0266.m_818e6498(), AbstractMod.class)).toggle();
                  C0064.m_13c9ffeb().m_ecf8e7ae(C0266.m_d32ebe65(), var1.isEnabled() ? C0266.m_afb31f66() : C0266.m_c254a253(), var1.m_6f1f396d()).m_1058ed9a();
                  return 1;
               }))
         )
         .registerAlias(C0266.m_56d4c1c7());
   }
}
