package me.deftware.aristois.recovered;

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
import me.deftware.client.framework.network.packets.CPacketRotation;
import me.deftware.client.framework.registry.StatusEffectRegistry;

public class C0406 extends AbstractMod {
   @C0098(
      value = "Health min.",
      description = {"Minimum health to trigger at"}
   )
   private float f_8e15879a = 10.0F;
   @C0098(
      value = "Throw delay",
      description = {"Delay between each thrown pot"}
   )
   private int f_bc2dd9be = 10;
   private final StatusEffect f_f9e44e63;
   private int f_c9ea3d61 = 0;

   public C0406() {
      super(C0252.bootstrap<"get",38654705713>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705714>());
      Optional var1 = StatusEffectRegistry.INSTANCE.find(C0252.bootstrap<"get",38654705715>());
      this.f_f9e44e63 = (StatusEffect)var1.orElseThrow(() -> new NullPointerException(C0252.bootstrap<"get",38654705716>()));
   }

   @EventHandler
   public void m_afe770dd(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!var2.isCreative() && !(C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen)) {
         int var3 = this.m_ca0da104(0, 9, var2);
         if (var3 != -1) {
            if (this.f_c9ea3d61 > 0) {
               this.f_c9ea3d61--;
               return;
            }

            if (var2.getHealth() > this.f_8e15879a) {
               return;
            }

            int var5 = var2.getInventory().getCurrentItem();
            var2.getInventory().setCurrentItem(var3);
            new CPacketRotation(var2.getRotationYaw(), 90.0F, var2.isOnGround()).sendPacket();
            var2.processRightClick(false);
            var2.getInventory().setCurrentItem(var5);
            new CPacketRotation(var2.getRotationYaw(), var2.getRotationPitch(), var2.isOnGround()).sendPacket();
            this.f_c9ea3d61 = this.f_bc2dd9be;
            return;
         }

         int var4 = this.m_ca0da104(9, 36, var2);
         if (var4 != -1) {
            var2.windowClick(var4, 0, WindowClickAction.QUICK_MOVE);
         }
      }
   }

   @Override
   public void onDisable() {
      this.f_c9ea3d61 = 0;
   }

   private int m_ca0da104(int var1, int var2, EntityPlayer var3) {
      for (int var4 = var1; var4 < var2; var4++) {
         ItemStack var5 = var3.getInventory().getStackInSlot(var4);
         if (var5.getItem().instanceOf(ItemType.SplashPotion) && var5.hasStatusEffect(this.f_f9e44e63)) {
            return var4;
         }
      }

      return -1;
   }
}
