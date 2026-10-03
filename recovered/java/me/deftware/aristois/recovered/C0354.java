package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatSend;
import me.deftware.client.framework.event.events.EventChatSend.Type;

public class C0354 extends AbstractMod {
   public C0354() {
      super(C0252.bootstrap<"get",47244640280>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640281>());
   }

   @EventHandler
   public void m_08150d0a(EventChatSend var1) {
      String var2 = var1.getMessage();
      if (var1.getType() != Type.Command && !var2.startsWith(C0114.bootstrap<"call",0,1>()) && !var2.startsWith(C0252.bootstrap<"get",12884902008>())) {
         String var3 = C0252.bootstrap<"get",47244640282>();
         StringBuilder var4 = new StringBuilder();

         for (char var8 : var2.toCharArray()) {
            if (var8 >= '!' && var8 <= 128 && !var3.contains(C0114.bootstrap<"call",1,1>(var8))) {
               var4.append(new String(C0114.bootstrap<"call",2,1>(var8 + '\ufee0')));
            } else {
               var4.append(var8);
            }
         }

         var1.setMessage(var4.toString());
      }
   }
}
