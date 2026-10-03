package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.types.ArmourItem;
import me.deftware.client.framework.minecraft.Minecraft;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_9
)
public class C0298 extends AbstractMod {
   @C0098(
      value = "Priority",
      description = {"Choose chest priority"}
   )
   private C0102<C0298.anonymousconst> f_dafd543e = new C0102<>(C0298.anonymousconst.f_e354db16);
   @C0098(
      value = "Creative",
      description = {"Allow AutoArmour to run in creative mode"}
   )
   private boolean f_7e5581a6 = false;

   public C0298() {
      super(C0263.m_bdbd5e40(), C0290.f_4b7b2d37, C0263.m_c04d8f6e());
      this.setMode(this.f_dafd543e);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if ((!var2.isCreative() || this.f_7e5581a6) && !(Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen)) {
         for (int var3 = 0; var3 < 4; var3++) {
            int var4 = this.m_8d984962(var2, var3);
            C0072 var5 = C0072.m_9a0150ee().m_f26b74b3(var3);
            if (this.f_dafd543e.m_284992ec() == C0298.anonymousconst.f_019ee630 && var3 == 2) {
               var5.m_6b100e6c(C0070.f_88717b71, 999.0F);
            }

            int var6 = var5.m_eb304949();
            if (var6 != -1) {
               ItemStack var7 = var2.getInventory().getStackInSlot(var6);
               if (this.m_016cf39b(var7) > var4) {
                  C0073.m_f76a4979().m_e1463257(var6).m_68351bcd(var3).m_ac6eac3b();
               }
            }
         }
      }
   }

   private int m_016cf39b(ItemStack var1) {
      return this.f_dafd543e.m_284992ec() == C0298.anonymousconst.f_019ee630 && var1.getItem().equals(C0070.f_88717b71) ? 999 : var1.getStackProtectionAmount();
   }

   private int m_8d984962(MainEntityPlayer var1, int var2) {
      ItemStack var3 = var1.getInventory().getStackInArmourSlot(var2);
      if (!var3.isEmpty()) {
         if (var3.getItem() instanceof ArmourItem) {
            return var3.getStackProtectionAmount();
         }

         if (var3.getItem().equals(C0070.f_88717b71) && this.f_dafd543e.m_284992ec() == C0298.anonymousconst.f_019ee630) {
            return 999;
         }
      }

      return -1;
   }

   private static enum anonymousconst {
      f_019ee630,
      f_e354db16;

      private anonymousconst() {
      }
   }
}
