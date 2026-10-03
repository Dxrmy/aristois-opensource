package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0334 extends AbstractMod {
   public C0334() {
      super(C0260.m_65d43991(), C0290.f_3210deb7, C0260.m_c6614274());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.RAINBOW_ITEM_GLINT, true);
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.put(GameKeys.RAINBOW_ITEM_GLINT, false);
   }
}
