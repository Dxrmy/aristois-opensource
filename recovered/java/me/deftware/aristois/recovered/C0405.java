package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.item.Item;

public class C0405 extends AbstractMod {
   private static final C0219<Item> f_21bd6125 = new C0219<>(Item.class, C0252.bootstrap<"get",38654705694>());
   @C0098("Items")
   private static final GuiScreen f_6a33ee38 = C0114.bootstrap<"call",0,1>(null, f_21bd6125);

   public C0405() {
      super(C0252.bootstrap<"get",38654705692>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705693>());
   }

   @EventHandler
   public void m_97853f91(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!(C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen)) {
         C0114.bootstrap<"call",2,1>()
            .m_ad163406()
            .filter(var0 -> f_21bd6125.contains(var0.m_17485ebf().getItem()))
            .forEach(var1x -> C0114.bootstrap<"call",3,1>(var2, var1x.m_0ea37aad()));
      }
   }

   public static C0219<Item> m_6cc21dd8() {
      return f_21bd6125;
   }

   public static GuiScreen m_6b370dd0() {
      return f_6a33ee38;
   }
}
