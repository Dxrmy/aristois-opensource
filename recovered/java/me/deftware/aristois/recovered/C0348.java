package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatReceive;
import me.deftware.client.framework.message.Message.Builder;

public class C0348 extends AbstractMod {
   private static final String f_73de76c9 = C0252.bootstrap<"get",73>();

   public C0348() {
      super(C0252.bootstrap<"get",47244640262>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640263>());
   }

   @EventHandler
   public void m_dc7426e9(EventChatReceive var1) {
      Builder var2 = new Builder();
      var1.getMessage().visit((var1x, var2x) -> {
         if (var2x.contains(C0252.bootstrap<"get",73>())) {
            var2.append(C0114.bootstrap<"call",0,1>(var2x, C0252.bootstrap<"get",73>(), var1x));
         } else {
            var2.append(var2x, var1x);
         }

         return C0114.bootstrap<"call",1,1>();
      });
      var1.setMessage(var2.build());
   }
}
