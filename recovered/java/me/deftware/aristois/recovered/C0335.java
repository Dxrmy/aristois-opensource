package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.helper.SessionHelper;

public class C0335 extends AbstractMod {
   public C0335() {
      super(C0260.m_a19a564f(), C0290.f_3210deb7, C0260.m_03430357());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.FLIP_USERNAMES, SessionHelper.getPlayerUsername());
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.FLIP_USERNAMES);
   }
}
