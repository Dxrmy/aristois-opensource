package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_18
)
public class C0358 extends AbstractMod {
   public C0358() {
      super(C0252.bootstrap<"get",51539607609>(), C0290.f_faada303, C0252.bootstrap<"get",51539607610>());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.IGNORE_WORLD_BORDER, C0114.bootstrap<"call",0,1>(true));
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.IGNORE_WORLD_BORDER);
   }
}
