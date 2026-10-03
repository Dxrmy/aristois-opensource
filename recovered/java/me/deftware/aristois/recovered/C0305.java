package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0305 extends AbstractMod {
   @C0098(
      value = "CPS",
      description = {"Clicks per second"}
   )
   private int f_66a4f5c9 = 5;
   @C0098(
      value = "Right click",
      description = {"Right click mouse"}
   )
   private boolean f_5f1752b4 = false;
   private boolean f_64727f64 = false;
   private int f_4301fcc7 = 0;

   public C0305() {
      super(C0252.bootstrap<"get",38654705768>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705769>());
   }

   @EventHandler
   public void m_ea0912a2(EventUpdate var1) {
      if (!C0114.bootstrap<"call",0,1>(0)) {
         this.f_64727f64 = false;
      } else {
         if (!this.f_64727f64) {
            this.f_64727f64 = true;
            this.f_4301fcc7 = 0;
         }

         if (this.f_4301fcc7 < 20 / this.f_66a4f5c9) {
            this.f_4301fcc7++;
         } else {
            if (this.f_5f1752b4) {
               C0114.bootstrap<"call",1,1>(1);
            } else {
               C0114.bootstrap<"call",1,1>(0);
            }

            this.f_4301fcc7 = 0;
         }
      }
   }
}
