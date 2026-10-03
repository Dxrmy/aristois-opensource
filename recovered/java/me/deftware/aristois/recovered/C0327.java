package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0327 extends AbstractMod {
   public C0327() {
      super(C0252.bootstrap<"get",47244640331>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640332>());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.FULL_BARRIER_TEXTURE, C0114.bootstrap<"call",0,1>(true));
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.FULL_BARRIER_TEXTURE);
   }
}
