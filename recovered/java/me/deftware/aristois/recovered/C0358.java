package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_18
)
public class C0358 extends AbstractMod {
   public C0358() {
      super(C0255.m_df6e621c(), C0290.f_516f3c47, C0255.m_56242a84());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.IGNORE_WORLD_BORDER, true);
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.IGNORE_WORLD_BORDER);
   }
}
