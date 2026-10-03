package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0346 extends AbstractMod {
   @C0098("Delay")
   private float f_9044857a = 1.0F;
   private float f_ed6b8777 = 0.0F;

   public C0346() {
      super(C0260.m_b0896de7(), C0290.f_99d080af, C0260.m_593ecbab());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (this.f_ed6b8777 < this.f_9044857a) {
         this.f_ed6b8777++;
      } else {
         this.f_ed6b8777 = 0.0F;
         MinecraftKeyBind.SNEAK.setPressed(!MinecraftKeyBind.SNEAK.isPressed());
      }
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.SNEAK.setPressed(false);
   }
}
