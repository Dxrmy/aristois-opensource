package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0405 extends AbstractMod {
   private static final C0219<Item> f_7d5cbbd4 = new C0219<>(Item.class, C0263.m_28b2c020());
   @C0098("Items")
   private static final GuiScreen f_ca8578e8 = C0217.m_81b76da4(null, f_7d5cbbd4);

   public C0405() {
      super(C0263.m_5fa6dd07(), C0290.f_dbc16475, C0263.m_5f1ab561());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!(Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen)) {
         C0072.m_1c5da965()
            .m_b3d23b7d()
            .filter(var0 -> f_7d5cbbd4.contains(var0.m_7b08e12a().getItem()))
            .forEach(var1x -> C0073.m_3907084c(var2, var1x.m_5b3d3148()));
      }
   }

   public static C0219<Item> m_001ab21f() {
      return f_7d5cbbd4;
   }

   public static GuiScreen m_1ebb9a23() {
      return f_ca8578e8;
   }
}
