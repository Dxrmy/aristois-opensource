package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.minecraft.Minecraft;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_11
)
public class C0415 extends AbstractMod {
   @C0098("Selected Item")
   private Item f_59a200a5 = C0070.f_b8953e39;

   public C0415() {
      super(C0263.m_760db7bb(), C0290.f_dbc16475, C0263.m_68957b31());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (!C0073.m_376d1241(this.f_59a200a5) && Minecraft.getMinecraftGame().getScreen() == null) {
         C0073.anonymousdefault var2 = C0073.m_f76a4979().m_887f6e69(this.f_59a200a5);
         if (var2.m_d612baa8() != -1) {
            var2.m_6a5ac614().m_ac6eac3b();
         }
      }
   }
}
