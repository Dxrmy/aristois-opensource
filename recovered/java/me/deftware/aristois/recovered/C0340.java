package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatReceive;

public class C0340 extends AbstractMod {
   @C0098(
      value = "Username",
      description = {"Repeat messages sent by this user"}
   )
   private String f_ea07690a = C0252.bootstrap<"get",47244640261>();
   @C0098(
      value = "Splitter",
      description = {"Message splitter, default \">\", name is supposedly on the left of this character"}
   )
   private String f_739e9956 = C0252.bootstrap<"get",25769803851>();

   public C0340() {
      super(C0252.bootstrap<"get",47244640259>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640260>());
   }

   @EventHandler
   public void m_6db7bd48(EventChatReceive var1) {
      String var2 = var1.getMessage().string();
      if (var2.contains(this.f_ea07690a + this.f_739e9956)) {
         C0114.bootstrap<"call",0,1>().m_77a7bc18(var2.split(this.f_ea07690a + this.f_739e9956)[1]).m_f0402f6b();
      }
   }
}
