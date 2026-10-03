package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_14
)
public class C0359 extends AbstractMod {
   public C0359() {
      super(C0255.m_bec91365(), C0290.f_516f3c47, C0255.m_79bfaec2());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.FULL_BERRY_VOXEL, true);
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.FULL_BERRY_VOXEL);
   }
}
