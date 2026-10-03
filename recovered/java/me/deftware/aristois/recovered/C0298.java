package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.types.ArmourItem;

@C0101(
   minimumProtocol = C0213.MINECRAFT_1_9
)
public class C0298 extends AbstractMod {
   @C0098(
      value = "Priority",
      description = {"Choose chest priority"}
   )
   private C0102<C0298.anonymousconst> f_d3988f4c = new C0102<>(C0298.anonymousconst.f_3840ec42);
   @C0098(
      value = "Creative",
      description = {"Allow AutoArmour to run in creative mode"}
   )
   private boolean f_78f0c8c6 = false;

   public C0298() {
      super(C0252.bootstrap<"get",38654705766>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705767>());
      this.setMode(this.f_d3988f4c);
   }

   @EventHandler
   public void m_cd2e43fe(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if ((!var2.isCreative() || this.f_78f0c8c6) && !(C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen)) {
         for (int var3 = 0; var3 < 4; var3++) {
            int var4 = this.m_c570ea7e(var2, var3);
            C0072 var5 = C0114.bootstrap<"call",2,1>().m_d5fce8ed(var3);
            if (this.f_d3988f4c.m_e2691446() == C0298.anonymousconst.f_77442ee8 && var3 == 2) {
               var5.m_82117449(C0070.f_a049faba, 999.0F);
            }

            int var6 = var5.m_a0aa8556();
            if (var6 != -1) {
               ItemStack var7 = var2.getInventory().getStackInSlot(var6);
               if (this.m_7e4ff373(var7) > var4) {
                  ((C0073.anonymousdefault)((C0073.anonymousdefault)C0114.bootstrap<"call",3,1>().m_44d897bb(var6)).m_aa5e9f8b(var3)).m_08fa2bad();
               }
            }
         }
      }
   }

   private int m_7e4ff373(ItemStack var1) {
      return this.f_d3988f4c.m_e2691446() == C0298.anonymousconst.f_77442ee8 && var1.getItem().equals(C0070.f_a049faba) ? 999 : var1.getStackProtectionAmount();
   }

   private int m_c570ea7e(MainEntityPlayer var1, int var2) {
      ItemStack var3 = var1.getInventory().getStackInArmourSlot(var2);
      if (!var3.isEmpty()) {
         if (var3.getItem() instanceof ArmourItem) {
            return var3.getStackProtectionAmount();
         }

         if (var3.getItem().equals(C0070.f_a049faba) && this.f_d3988f4c.m_e2691446() == C0298.anonymousconst.f_77442ee8) {
            return 999;
         }
      }

      return -1;
   }

   private static enum anonymousconst {
      f_77442ee8,
      f_3840ec42;

      private anonymousconst() {
      }
   }
}
