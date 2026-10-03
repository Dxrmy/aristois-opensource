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
   private C0104<Float> f_3516a579 = new C0104<>(GameKeys.BLOCK_REACH_DISTANCE, C0114.bootstrap<"call",0,1>(5.0F)).m_958520b0(this);

   public C0310() {
      super(C0252.bootstrap<"get",38654705780>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705781>());
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameKeys.EXTENDED_REACH);
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameKeys.EXTENDED_REACH, C0114.bootstrap<"call",0,1>(true));
   }
}
