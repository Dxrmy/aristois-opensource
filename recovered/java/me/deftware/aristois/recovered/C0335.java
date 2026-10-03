package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0335 extends AbstractMod {
   public C0335() {
      super(C0252.bootstrap<"get",47244640352>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640353>());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.FLIP_USERNAMES, C0114.bootstrap<"call",0,1>());
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.FLIP_USERNAMES);
   }
}
