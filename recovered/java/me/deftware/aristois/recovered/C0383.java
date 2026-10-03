package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0383 extends AbstractMod {
   public C0383() {
      super(C0259.m_9e27f038(), C0290.f_829d9b20, C0259.m_af41331f());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.LEVITATION, false);
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.put(GameKeys.LEVITATION, true);
   }
}
