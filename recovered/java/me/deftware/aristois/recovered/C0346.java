package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;

public class C0346 extends AbstractMod {
   @C0098("Delay")
   private float f_af1e5126 = 1.0F;
   private float f_679ad5f5 = 0.0F;

   public C0346() {
      super(C0252.bootstrap<"get",47244640325>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640326>());
   }

   @EventHandler
   public void m_27bed80f(EventUpdate var1) {
      if (this.f_679ad5f5 < this.f_af1e5126) {
         this.f_679ad5f5++;
      } else {
         this.f_679ad5f5 = 0.0F;
         MinecraftKeyBind.SNEAK.setPressed(!MinecraftKeyBind.SNEAK.isPressed());
      }
   }

   @Override
   public void onDisable() {
      MinecraftKeyBind.SNEAK.setPressed(false);
   }
}
