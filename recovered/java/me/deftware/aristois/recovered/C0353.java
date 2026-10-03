package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0353 extends AbstractMod {
   @C0098(
      value = "Delay",
      number = @C0096(
         min = 10.0,
         max = 200.0
      )
   )
   private float f_eaf5582a = 40.0F;
   private float f_b94e0020 = 0.0F;

   public C0353() {
      super(C0252.bootstrap<"get",47244640311>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640312>());
   }

   @EventHandler
   public void m_d09fdfd5(EventUpdate var1) {
      if (this.f_b94e0020 < this.f_eaf5582a * 2.0F) {
         this.f_b94e0020++;
      } else {
         this.f_b94e0020 = 0.0F;
         ((MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer())).toggleSkinLayers();
      }
   }
}
