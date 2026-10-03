package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventAnimation;
import me.deftware.client.framework.event.events.EventFogRender;
import me.deftware.client.framework.event.events.EventHurtcam;
import me.deftware.client.framework.event.events.EventIsPotionActive;
import me.deftware.client.framework.event.events.EventAnimation.AnimationType;

public class C0315 extends AbstractMod {
   @C0098(
      value = "Totem",
      description = {"Disable the totem animation"}
   )
   private boolean f_25ae92ea = true;
   @C0098(
      value = "Fire",
      description = {"Disable the fire overlay animation"}
   )
   private boolean f_af285d59 = true;
   @C0098(
      value = "Fog",
      description = {"Disable fog overlay animation(s)"}
   )
   private boolean f_a7698916 = true;
   @C0098(
      value = "Wall",
      description = {"Disable the in-wall suffocation overlay animation"}
   )
   private boolean f_eaf6db00 = false;
   @C0098(
      value = "Underwater",
      description = {"Disable the underwater effect animation(s)"}
   )
   private boolean f_b7583c55 = false;
   @C0098(
      value = "Pumpkin",
      description = {"Disable overlay from wearing a carved pumpkin"}
   )
   private boolean f_df8492a0 = true;
   @C0098(
      value = "Hurtcam",
      description = {"Disable the hurtcam animation"}
   )
   private boolean f_1b5de3c8 = true;
   @C0098(
      value = "Potions",
      description = {"Disable visibility for potion effects such as nausea and confusion"}
   )
   private boolean f_0896c18c = true;

   public C0315() {
      super(C0252.bootstrap<"get",47244640329>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640330>());
   }

   @EventHandler
   public void m_431d485f(EventAnimation var1) {
      boolean var2 = var1.getAnimationType() == AnimationType.Totem && this.f_25ae92ea;
      boolean var3 = var1.getAnimationType() == AnimationType.Fire && this.f_af285d59;
      boolean var4 = var1.getAnimationType() == AnimationType.Wall && this.f_eaf6db00;
      boolean var5 = var1.getAnimationType() == AnimationType.Pumpkin && this.f_df8492a0;
      boolean var6 = false;
      boolean var7 = var1.getAnimationType() == AnimationType.Underwater && this.f_b7583c55;
      var1.setCanceled(var2 || var3 || var4 || var5 || var6 || var7);
   }

   @EventHandler
   public void m_77d3c31d(EventIsPotionActive var1) {
      if (this.f_0896c18c) {
         var1.setActive(false);
      }
   }

   @EventHandler
   public void m_aceb203a(EventFogRender var1) {
      var1.setCanceled(this.f_a7698916);
   }

   @EventHandler
   public void m_59690cde(EventHurtcam var1) {
      var1.setCanceled(this.f_1b5de3c8);
   }
}
