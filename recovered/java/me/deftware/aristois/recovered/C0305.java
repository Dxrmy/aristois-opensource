package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.Mouse;

public class C0305 extends AbstractMod {
   @C0098(
      value = "CPS",
      description = {"Clicks per second"}
   )
   private int f_b20f3f56 = 5;
   @C0098(
      value = "Right click",
      description = {"Right click mouse"}
   )
   private boolean f_aaa92578 = false;
   private boolean f_b400f618 = false;
   private int f_a3757ad4 = 0;

   public C0305() {
      super(C0263.m_2dc36b02(), C0290.f_4b7b2d37, C0263.m_4cbaf16f());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (!Mouse.isButtonDown(0)) {
         this.f_b400f618 = false;
      } else {
         if (!this.f_b400f618) {
            this.f_b400f618 = true;
            this.f_a3757ad4 = 0;
         }

         if (this.f_a3757ad4 < 20 / this.f_b20f3f56) {
            this.f_a3757ad4++;
         } else {
            if (this.f_aaa92578) {
               Mouse.clickMouse(1);
            } else {
               Mouse.clickMouse(0);
            }

            this.f_a3757ad4 = 0;
         }
      }
   }
}
