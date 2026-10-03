package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0364 extends AbstractMod {
   public C0364() {
      super(C0252.bootstrap<"get",51539607576>(), C0290.f_faada303, C0252.bootstrap<"get",51539607577>());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.FULL_CACTUS_VOXEL, C0114.bootstrap<"call",0,1>(true));
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.FULL_CACTUS_VOXEL);
   }
}
