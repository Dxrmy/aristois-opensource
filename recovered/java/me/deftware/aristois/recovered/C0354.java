package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatSend;
import me.deftware.client.framework.event.events.EventChatSend.Type;

public class C0354 extends AbstractMod {
   public C0354() {
      super(C0260.m_2e834348(), C0290.f_99d080af, C0260.m_e07cee76());
   }

   @EventHandler
   public void m_7161a1f8(EventChatSend var1) {
      String var2 = var1.getMessage();
      if (var1.getType() != Type.Command && !var2.startsWith(CommandRegister.getCommandTrigger()) && !var2.startsWith(C0266.m_f599ae93())) {
         String var3 = C0260.m_7b0db73e();
         StringBuilder var4 = new StringBuilder();

         for (char var8 : var2.toCharArray()) {
            if (var8 >= '!' && var8 <= 128 && !var3.contains(Character.toString(var8))) {
               var4.append(new String(Character.toChars(var8 + '\ufee0')));
            } else {
               var4.append(var8);
            }
         }

         var1.setMessage(var4.toString());
      }
   }
}
