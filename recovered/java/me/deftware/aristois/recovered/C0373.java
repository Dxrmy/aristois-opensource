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
   private float f_1041614b = 0.25F;

   public C0373() {
      super(C0259.m_0425f2ec(), C0290.f_829d9b20, C0259.m_1b17f04f());
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      CameraEntityMan.speed = this.f_1041614b;
   }

   @Override
   public void onPostLoad() {
      CameraEntityMan.speed = this.f_1041614b;
   }

   @Override
   public void onDisable() {
      CameraEntityMan.disable();
   }

   @Override
   public void onEnable() {
      CameraEntityMan.enable();
   }
}
