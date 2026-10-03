package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0334 extends AbstractMod {
   public C0334() {
      super(C0252.bootstrap<"get",47244640384>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640385>());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.RAINBOW_ITEM_GLINT, C0114.bootstrap<"call",0,1>(true));
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.put(GameKeys.RAINBOW_ITEM_GLINT, C0114.bootstrap<"call",0,1>(false));
   }
}
