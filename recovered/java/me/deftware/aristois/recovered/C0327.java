package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0327 extends AbstractMod {
   public C0327() {
      super(C0260.m_b2dd5137(), C0290.f_3210deb7, C0260.m_91e95cb4());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.FULL_BARRIER_TEXTURE, true);
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.FULL_BARRIER_TEXTURE);
   }
}
