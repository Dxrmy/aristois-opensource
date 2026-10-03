package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.CommandRegister;

public class C0042 extends C0001 {
   public C0042() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_fac478b2())
                  .then(LiteralArgumentBuilder.literal(C0253.m_9bf0a29a()).executes(var0 -> {
                     C0241.f_1344324d = true;
                     C0289.f_85a7343f.m_918b7b9e().forEach(var0x -> {
                        if (var0x.isEnabled()) {
                           var0x.toggle();
                        }
                     });
                     C0242.m_fc1b642c().m_a88b18cc().m_1058ed9a();
                     C0041.m_1058ed9a();
                     C0064.m_13c9ffeb().m_2c2620fc(C0253.m_a19a564f()).m_ee04ba1b(C0253.m_03430357()).m_1058ed9a();
                     return 1;
                  })))
               .executes(var0 -> {
                  m_a11708c5(C0253.m_85cd13b4() + CommandRegister.getCommandTrigger() + C0253.m_65c7e6e6());
                  return 1;
               })
         );
   }
}
