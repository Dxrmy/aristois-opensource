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
   private boolean f_87646d84 = true;
   @C0098(
      value = "Fire",
      description = {"Disable the fire overlay animation"}
   )
   private boolean f_5e373322 = true;
   @C0098(
      value = "Fog",
      description = {"Disable fog overlay animation(s)"}
   )
   private boolean f_1970c8ab = true;
   @C0098(
      value = "Wall",
      description = {"Disable the in-wall suffocation overlay animation"}
   )
   private boolean f_29a6a846 = false;
   @C0098(
      value = "Underwater",
      description = {"Disable the underwater effect animation(s)"}
   )
   private boolean f_2e7415bb = false;
   @C0098(
      value = "Pumpkin",
      description = {"Disable overlay from wearing a carved pumpkin"}
   )
   private boolean f_20f3d354 = true;
   @C0098(
      value = "Hurtcam",
      description = {"Disable the hurtcam animation"}
   )
   private boolean f_3ae3f534 = true;
   @C0098(
      value = "Potions",
      description = {"Disable visibility for potion effects such as nausea and confusion"}
   )
   private boolean f_a3a7c98b = true;

   public C0315() {
      super(C0260.m_d1f7b79f(), C0290.f_3210deb7, C0260.m_a29090eb());
   }

   @EventHandler
   public void m_d344df6a(EventAnimation var1) {
      boolean var2 = var1.getAnimationType() == AnimationType.Totem && this.f_87646d84;
      boolean var3 = var1.getAnimationType() == AnimationType.Fire && this.f_5e373322;
      boolean var4 = var1.getAnimationType() == AnimationType.Wall && this.f_29a6a846;
      boolean var5 = var1.getAnimationType() == AnimationType.Pumpkin && this.f_20f3d354;
      boolean var6 = false;
      boolean var7 = var1.getAnimationType() == AnimationType.Underwater && this.f_2e7415bb;
      var1.setCanceled(var2 || var3 || var4 || var5 || var6 || var7);
   }

   @EventHandler
   public void m_5ab13396(EventIsPotionActive var1) {
      if (this.f_a3a7c98b) {
         var1.setActive(false);
      }
   }

   @EventHandler
   public void m_acb8435a(EventFogRender var1) {
      var1.setCanceled(this.f_1970c8ab);
   }

   @EventHandler
   public void m_5a26da3f(EventHurtcam var1) {
      var1.setCanceled(this.f_3ae3f534);
   }
}
