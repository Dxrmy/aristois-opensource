package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0364 extends AbstractMod {
   public C0364() {
      super(C0255.m_2e834348(), C0290.f_516f3c47, C0255.m_e07cee76());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.FULL_CACTUS_VOXEL, true);
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.FULL_CACTUS_VOXEL);
   }
}
