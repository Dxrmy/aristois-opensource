package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatReceive;

public class C0340 extends AbstractMod {
   @C0098(
      value = "Username",
      description = {"Repeat messages sent by this user"}
   )
   private String f_a595727e = C0260.m_c688f8ca();
   @C0098(
      value = "Splitter",
      description = {"Message splitter, default \">\", name is supposedly on the left of this character"}
   )
   private String f_14ce8a90 = C0267.m_b2dd5137();

   public C0340() {
      super(C0260.m_a9247108(), C0290.f_99d080af, C0260.m_4626ac74());
   }

   @EventHandler
   public void m_f84326ec(EventChatReceive var1) {
      String var2 = var1.getMessage().string();
      if (var2.contains(this.f_a595727e + this.f_14ce8a90)) {
         C0064.m_13c9ffeb().m_ee04ba1b(var2.split(this.f_a595727e + this.f_14ce8a90)[1]).m_0e265701();
      }
   }
}
