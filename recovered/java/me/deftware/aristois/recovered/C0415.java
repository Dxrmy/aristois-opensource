package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.item.Item;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_11
)
public class C0415 extends AbstractMod {
   @C0098("Selected Item")
   private Item f_035a64f1 = C0070.f_dae9c6e7;

   public C0415() {
      super(C0252.bootstrap<"get",38654705709>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705710>());
   }

   @EventHandler
   public void m_ed14c699(EventUpdate var1) {
      if (!C0114.bootstrap<"call",0,1>(this.f_035a64f1) && C0114.bootstrap<"call",1,1>().getScreen() == null) {
         C0073.anonymousdefault var2 = (C0073.anonymousdefault)C0114.bootstrap<"call",2,1>().m_0a06a528(this.f_035a64f1);
         if (var2.m_40a6d055() != -1) {
            ((C0073.anonymousdefault)var2.m_adda4fb4()).m_08fa2bad();
         }
      }
   }
}
