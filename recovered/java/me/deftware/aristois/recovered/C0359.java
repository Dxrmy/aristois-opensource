package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_14
)
public class C0359 extends AbstractMod {
   public C0359() {
      super(C0252.bootstrap<"get",51539607574>(), C0290.f_faada303, C0252.bootstrap<"get",51539607575>());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.FULL_BERRY_VOXEL, C0114.bootstrap<"call",0,1>(true));
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.FULL_BERRY_VOXEL);
   }
}
