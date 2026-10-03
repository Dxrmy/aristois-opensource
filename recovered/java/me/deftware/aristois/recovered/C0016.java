package me.deftware.aristois.recovered;

import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.input.Keyboard;

public class C0016 extends C0001 {
   public C0016() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().addCommand(C0253.m_15737526(), var0 -> {
         C0064.m_13c9ffeb().m_ee04ba1b(C0257.m_ec329d2e()).m_1058ed9a();
         CompletableFuture.runAsync(() -> {
            try {
               C0034.anonymouscatch var0x = C0034.m_48333368();
               C0064.m_13c9ffeb().m_ee04ba1b(C0253.m_6cf615ba()).m_1058ed9a();
               Keyboard.openLink(C0146.f_36f829be.m_8d7dbe31() + C0253.m_ecb46027() + var0x.f_85b673d8);
            } catch (Exception var1) {
               var1.printStackTrace();
               C0064.m_b79f2e94().m_ee04ba1b(C0253.m_b526dd3b()).m_1058ed9a();
            }
         });
      });
   }
}
