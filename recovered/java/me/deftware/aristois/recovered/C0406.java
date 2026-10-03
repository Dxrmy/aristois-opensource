package me.deftware.aristois.recovered;

import java.util.Objects;
import java.util.Optional;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.main.WindowClickAction;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.ItemType;
import me.deftware.client.framework.item.effect.StatusEffect;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketRotation;
import me.deftware.client.framework.registry.StatusEffectRegistry;

public class C0406 extends AbstractMod {
   @C0098(
      value = "Health min.",
      description = {"Minimum health to trigger at"}
   )
   private float f_c7c44737 = 10.0F;
   @C0098(
      value = "Throw delay",
      description = {"Delay between each thrown pot"}
   )
   private int f_77ce4827 = 10;
   private final StatusEffect f_0279fe6e;
   private int f_257a3501 = 0;

   public C0406() {
      super(C0263.m_b89b7876(), C0290.f_dbc16475, C0263.m_a33fab52());
      Optional var1 = StatusEffectRegistry.INSTANCE.find(C0263.m_73708dd3());
      this.f_0279fe6e = (StatusEffect)var1.orElseThrow(() -> new NullPointerException(C0263.m_96ba50d4()));
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!var2.isCreative() && !(Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen)) {
         int var3 = this.m_8ffe9620(0, 9, var2);
         if (var3 != -1) {
            if (this.f_257a3501 > 0) {
               this.f_257a3501--;
               return;
            }

            if (var2.getHealth() > this.f_c7c44737) {
               return;
            }

            int var5 = var2.getInventory().getCurrentItem();
            var2.getInventory().setCurrentItem(var3);
            new CPacketRotation(var2.getRotationYaw(), 90.0F, var2.isOnGround()).sendPacket();
            var2.processRightClick(false);
            var2.getInventory().setCurrentItem(var5);
            new CPacketRotation(var2.getRotationYaw(), var2.getRotationPitch(), var2.isOnGround()).sendPacket();
            this.f_257a3501 = this.f_77ce4827;
            return;
         }

         int var4 = this.m_8ffe9620(9, 36, var2);
         if (var4 != -1) {
            var2.windowClick(var4, 0, WindowClickAction.QUICK_MOVE);
         }
      }
   }

   @Override
   public void onDisable() {
      this.f_257a3501 = 0;
   }

   private int m_8ffe9620(int var1, int var2, EntityPlayer var3) {
      for (int var4 = var1; var4 < var2; var4++) {
         ItemStack var5 = var3.getInventory().getStackInSlot(var4);
         if (var5.getItem().instanceOf(ItemType.SplashPotion) && var5.hasStatusEffect(this.f_0279fe6e)) {
            return var4;
         }
      }

      return -1;
   }
}
