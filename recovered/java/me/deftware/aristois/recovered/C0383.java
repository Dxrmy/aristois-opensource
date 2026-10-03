package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0383 extends AbstractMod {
   public C0383() {
      super(C0252.bootstrap<"get",42949673019>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673020>());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.LEVITATION, C0114.bootstrap<"call",0,1>(false));
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.put(GameKeys.LEVITATION, C0114.bootstrap<"call",0,1>(true));
   }
}
