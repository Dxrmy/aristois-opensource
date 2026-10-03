package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;

@C0421
public class C0373 extends AbstractMod {
   @C0098(
      value = "Speed",
      number = @C0096(
         min = 0.25,
         max = 4.0
      )
   )
   private float f_afb8c29b = 0.25F;

   public C0373() {
      super(C0252.bootstrap<"get",42949673048>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673049>());
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      CameraEntityMan.speed = this.f_afb8c29b;
   }

   @Override
   public void onPostLoad() {
      CameraEntityMan.speed = this.f_afb8c29b;
   }

   @Override
   public void onDisable() {
      C0114.bootstrap<"call",0,1>();
   }

   @Override
   public void onEnable() {
      C0114.bootstrap<"call",0,1>();
   }
}
