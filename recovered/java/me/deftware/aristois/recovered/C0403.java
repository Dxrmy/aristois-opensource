package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.block.Block;

public class C0403 extends AbstractMod {
   @C0098(
      value = "Revert",
      description = {"Automatically revert to the old slot"}
   )
   private boolean f_0f4177cb = true;
   @C0098(
      value = "Swap",
      description = {"Swap tools to the hotbar when there is none"}
   )
   private boolean f_d762092e = false;
   private Block f_2a809ae9;
   private int f_53d536e6 = -1;
   private C0073.anonymousboolean f_a9eb00c8;
   private final C0072.anonymousboolean f_55539270 = C0072.m_48cf3e49();

   public C0403() {
      super(C0263.m_91e95cb4(), C0290.f_dbc16475, C0263.m_1616e137());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (!var2.isCreative() && MinecraftKeyBind.ATTACK.isPressed() && !(Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen)) {
         BlockSwingResult var3 = Minecraft.getMinecraftGame().getHitBlock();
         if (var3 != null) {
            if (var3.getBlock().isAir()
               || this.f_2a809ae9 != null && this.f_2a809ae9.equals(var3.getBlock()) && this.f_53d536e6 == var2.getInventory().getCurrentItem()) {
               return;
            }

            int var4 = this.m_11c6c075(var2, var3.getBlock());
            if (var4 != -1) {
               this.f_2a809ae9 = var3.getBlock();
               this.f_53d536e6 = var4 - 36;
               if (!this.m_275ab222()) {
                  this.f_a9eb00c8 = C0073.m_72cafc8a().m_8c218980(this).m_7c42e94f(var4).m_ac6eac3b();
                  if (this.f_0f4177cb) {
                     this.f_a9eb00c8.m_924c66cb(() -> {
                        BlockSwingResult var1x = Minecraft.getMinecraftGame().getHitBlock();
                        return var1x == null || !var1x.getBlock().equals(var3.getBlock()) && !var3.getBlock().isAir() || !MinecraftKeyBind.ATTACK.isPressed();
                     });
                  }
               } else {
                  C0073.m_72cafc8a().m_7c42e94f(var4).m_ac6eac3b();
               }
            }
         }
      }
   }

   private boolean m_275ab222() {
      return this.f_a9eb00c8 != null && this.f_a9eb00c8.m_e0f7c666();
   }

   private int m_11c6c075(MainEntityPlayer var1, Block var2) {
      this.f_55539270.m_ef8c78c7(var2);
      int var3 = this.f_55539270.m_ceb42ce2(0, var1.getInventory().getSize(), -1, 1.0F);
      if (!C0073.m_aa45d95d(var3) && !this.f_d762092e) {
         var3 = this.f_55539270.m_ceb42ce2(0, 8, -1, 1.0F);
      }

      if (var3 != -1) {
         if (var3 == var1.getInventory().getCurrentItem()) {
            return -1;
         }

         if (!C0073.m_aa45d95d(var3)) {
            C0073.anonymousdefault var4 = C0073.m_f76a4979().m_e1463257(var3).m_b252dc95();
            var3 = var4.m_eb304949();
            var4.m_ac6eac3b();
         }
      }

      return var3;
   }
}
