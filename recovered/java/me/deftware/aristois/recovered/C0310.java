package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;
import me.deftware.client.framework.global.GameMap;

public class C0310 extends AbstractMod {
   @C0098(
      value = "Reach",
      description = {"Default reach distance in Minecraft is 4.5 blocks"},
      number = @C0096(
         min = 3.0,
         max = 6.0
      )
   )
   private C0104<Float> f_103d716f = new C0104<>(GameKeys.BLOCK_REACH_DISTANCE, 5.0F).m_43d84283(this);

   public C0310() {
      super(C0263.m_76700429(), C0290.f_4b7b2d37, C0263.m_8870d2c1());
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.EXTENDED_REACH);
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.EXTENDED_REACH, true);
   }
}
