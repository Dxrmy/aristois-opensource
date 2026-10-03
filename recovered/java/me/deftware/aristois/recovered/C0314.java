package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameCategory;
import me.deftware.client.framework.global.GameMap;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_17
)
public class C0314 extends AbstractMod {
   public C0314() {
      super(C0252.bootstrap<"get",47244640374>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640375>());
   }

   @Override
   public void onEnable() {
      GameMap.INSTANCE.put(GameCategory.Default, C0252.bootstrap<"get",47244640376>(), C0114.bootstrap<"call",0,1>(true));
   }

   @Override
   public void onDisable() {
      GameMap.INSTANCE.remove(GameCategory.Default, C0252.bootstrap<"get",47244640376>());
   }
}
