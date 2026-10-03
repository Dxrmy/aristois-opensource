package me.deftware.aristois.recovered;

import java.util.Optional;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatReceive;
import me.deftware.client.framework.message.Message.Builder;

public class C0348 extends AbstractMod {
   private static final String f_e988881f = C0257.m_d1f7b79f();

   public C0348() {
      super(C0260.m_35cdaa1a(), C0290.f_99d080af, C0260.m_624b40d8());
   }

   @EventHandler
   public void m_f84326ec(EventChatReceive var1) {
      Builder var2 = new Builder();
      var1.getMessage().visit((var1x, var2x) -> {
         if (var2x.contains(C0257.m_d1f7b79f())) {
            var2.append(C0197.m_2130da9b(var2x, C0257.m_d1f7b79f(), var1x));
         } else {
            var2.append(var2x, var1x);
         }

         return Optional.empty();
      });
      var1.setMessage(var2.build());
   }
}
