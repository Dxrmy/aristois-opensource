package me.deftware.aristois.recovered;

import java.util.function.Predicate;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.registry.ItemRegistry;

public class C0401 extends AbstractMod {
   private C0219<Item> f_d82574fc = new C0219<>(Item.class, C0252.bootstrap<"get",38654705677>());
   @C0098(
      value = "Mode",
      description = {"Manual mode will show buttons, Steal/Dump automatically steals/dumps for you respectively"}
   )
   private C0102<C0401.anonymousif> f_31433eb2 = new C0102<>(C0401.anonymousif.f_e07638e0);
   @C0098(
      value = "Filter mode",
      description = {"Item filter mode"}
   )
   private C0102<C0121> f_91f8f4bf = new C0102<>(C0121.f_46c8b4fe);
   @C0098(
      value = "Filter",
      description = {"Which items to steal/dump"}
   )
   private final C0106<GuiScreen> f_fbef68f4 = new C0106<>(
         new C0196(null, this.f_d82574fc, ItemRegistry.INSTANCE, C0252.bootstrap<"get",38654705678>(), var0 -> var0.getName().string())
      )
      .m_6da46a9c(this.f_91f8f4bf, C0121.f_46c8b4fe);
   private Runnable f_3cf6933e;

   public C0401() {
      super(C0252.bootstrap<"get",38654705675>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705676>());
      this.setMode(this.f_31433eb2);
   }

   @EventHandler
   public void m_92ef7995(EventScreen var1) {
      if (var1.getScreen() instanceof ContainerScreen) {
         final MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
         final ContainerScreen var3 = (ContainerScreen)var1.getScreen();
         final Inventory var4 = var3.getContainerInventory();
         if (var4 == null) {
            return;
         }

         if (!var3.isPlayerInventory()) {
            if (var1.getType() == Type.Setup) {
               if (this.f_31433eb2.m_e2691446() == C0401.anonymousif.f_e07638e0) {
                  var3.addScreenComponent(
                     new C0154(
                        C0114.bootstrap<"call",2,1>() / 2 + 100,
                        C0114.bootstrap<"call",3,1>() / 2 - 50,
                        50,
                        20,
                        C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",38654705679>())
                     ) {
                        public boolean m_b27bce0b(int var1) {
                           C0114.bootstrap<"call",0,1>(C0401.this, var2, var4, var3, var0 -> !var0.isEmpty());
                           return true;
                        }
                     }
                  );
                  var3.addScreenComponent(
                     new C0154(
                        C0114.bootstrap<"call",2,1>() / 2 + 100,
                        C0114.bootstrap<"call",3,1>() / 2 - 72,
                        50,
                        20,
                        C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",38654705680>())
                     ) {
                        public boolean m_0d54b2cf(int var1) {
                           C0114.bootstrap<"call",0,1>(C0401.this, var2, var4, var3, ItemStack::isEmpty);
                           return true;
                        }
                     }
                  );
               } else {
                  this.f_3cf6933e = () -> {
                     if (this.f_31433eb2.m_4c8d9085(C0401.anonymousif.f_6827d79c)) {
                        this.m_fc15da3d(var2, var4, var3, ItemStack::isEmpty);
                     } else {
                        this.m_fc15da3d(var2, var4, var3, var0 -> !var0.isEmpty());
                     }
                  };
               }
            } else if (var1.getType() == Type.PostDraw && this.f_3cf6933e != null) {
               this.f_3cf6933e.run();
               this.f_3cf6933e = null;
            }
         }
      }
   }

   private void m_fc15da3d(MainEntityPlayer var1, Inventory var2, ContainerScreen var3, Predicate<ItemStack> var4) {
      for (int var5 = 0; var5 < var3.getMaxSlots(); var5++) {
         ItemStack var6 = var2.getStackInSlot(var5);
         if (var4.test(var6)) {
            boolean var7 = this.f_d82574fc.contains(var6.getItem());
            if (this.f_91f8f4bf.m_e2691446().m_be55acd0(var6.getItem(), this.f_d82574fc)) {
               var1.windowClick(var3.getContainerID(), var5, 0, WindowClickAction.QUICK_MOVE);
            }
         }
      }
   }

   public static enum anonymousif {
      f_f2118c68,
      f_6827d79c,
      f_e07638e0;

      private anonymousif() {
      }
   }
}
