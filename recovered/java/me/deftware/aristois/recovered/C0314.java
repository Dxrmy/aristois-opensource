package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameCategory;
import me.deftware.client.framework.global.GameMap;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_17
)
public class C0314 extends AbstractMod {
   public C0314() {
      super(C0260.m_a004d745(), C0290.f_3210deb7, C0260.m_3c19a819());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameCategory.Default, C0260.m_f599ae93(), true);
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameCategory.Default, C0260.m_f599ae93());
   }
}
