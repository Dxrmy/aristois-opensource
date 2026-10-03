package me.deftware.aristois.recovered;

import java.util.Objects;
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
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.registry.ItemRegistry;

public class C0401 extends AbstractMod {
   private C0219<Item> f_d911ab3c = new C0219<>(Item.class, C0263.m_15ef1a0d());
   @C0098(
      value = "Mode",
      description = {"Manual mode will show buttons, Steal/Dump automatically steals/dumps for you respectively"}
   )
   private C0102<C0401.anonymousif> f_60a33a4a = new C0102<>(C0401.anonymousif.f_7c3fc029);
   @C0098(
      value = "Filter mode",
      description = {"Item filter mode"}
   )
   private C0102<C0121> f_cb2e4885 = new C0102<>(C0121.f_56c93dc6);
   @C0098(
      value = "Filter",
      description = {"Which items to steal/dump"}
   )
   private final C0106<GuiScreen> f_678879fd = new C0106<>(
         new C0196(null, this.f_d911ab3c, ItemRegistry.INSTANCE, C0263.m_9793dfe2(), var0 -> var0.getName().string())
      )
      .m_cb9291a5(this.f_cb2e4885, C0121.f_56c93dc6);
   private Runnable f_ce743daa;

   public C0401() {
      super(C0263.m_6f1f396d(), C0290.f_dbc16475, C0263.m_8ced16bd());
      this.setMode(this.f_60a33a4a);
   }

   @EventHandler
   public void m_65c92cfe(EventScreen var1) {
      if (var1.getScreen() instanceof ContainerScreen) {
         final MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
         final ContainerScreen var3 = (ContainerScreen)var1.getScreen();
         final Inventory var4 = var3.getContainerInventory();
         if (var4 == null) {
            return;
         }

         if (!var3.isPlayerInventory()) {
            if (var1.getType() == Type.Setup) {
               if (this.f_60a33a4a.m_284992ec() == C0401.anonymousif.f_7c3fc029) {
                  var3.addScreenComponent(
                     new C0154(GuiScreen.getScaledWidth() / 2 + 100, GuiScreen.getScaledHeight() / 2 - 50, 50, 20, Message.of(C0263.m_1635bc47())) {
                        @Override
                        public boolean m_1521b1fa(int var1) {
                           C0401.this.m_d4c58706(var2, var4, var3, var0 -> !var0.isEmpty());
                           return true;
                        }
                     }
                  );
                  var3.addScreenComponent(
                     new C0154(GuiScreen.getScaledWidth() / 2 + 100, GuiScreen.getScaledHeight() / 2 - 72, 50, 20, Message.of(C0263.m_d597c122())) {
                        @Override
                        public boolean m_1521b1fa(int var1) {
                           C0401.this.m_d4c58706(var2, var4, var3, ItemStack::isEmpty);
                           return true;
                        }
                     }
                  );
               } else {
                  this.f_ce743daa = () -> {
                     if (this.f_60a33a4a.m_d161e31b(C0401.anonymousif.f_54f2e758)) {
                        this.m_d4c58706(var2, var4, var3, ItemStack::isEmpty);
                     } else {
                        this.m_d4c58706(var2, var4, var3, var0 -> !var0.isEmpty());
                     }
                  };
               }
            } else if (var1.getType() == Type.PostDraw && this.f_ce743daa != null) {
               this.f_ce743daa.run();
               this.f_ce743daa = null;
            }
         }
      }
   }

   private void m_d4c58706(MainEntityPlayer var1, Inventory var2, ContainerScreen var3, Predicate<ItemStack> var4) {
      for (int var5 = 0; var5 < var3.getMaxSlots(); var5++) {
         ItemStack var6 = var2.getStackInSlot(var5);
         if (var4.test(var6)) {
            boolean var7 = this.f_d911ab3c.contains(var6.getItem());
            if (this.f_cb2e4885.m_284992ec().m_d65a9459(var6.getItem(), this.f_d911ab3c)) {
               var1.windowClick(var3.getContainerID(), var5, 0, WindowClickAction.QUICK_MOVE);
            }
         }
      }
   }

   public static enum anonymousif {
      f_31de0d39,
      f_54f2e758,
      f_7c3fc029;

      private anonymousif() {
      }
   }
}
