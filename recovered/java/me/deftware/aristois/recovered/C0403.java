package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.block.Block;

public class C0403 extends AbstractMod {
   @C0098(
      value = "Revert",
      description = {"Automatically revert to the old slot"}
   )
   private boolean f_b1019137 = true;
   @C0098(
      value = "Swap",
      description = {"Swap tools to the hotbar when there is none"}
   )
   private boolean f_0c8419ce = false;
   private Block f_b2f2c1b8;
   private int f_6dd63185 = -1;
   private C0073.anonymousboolean f_57786021;
   private final C0072.anonymousboolean f_7e00437a = C0114.bootstrap<"call",0,1>();

   public C0403() {
      super(C0252.bootstrap<"get",38654705740>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705741>());
   }

   @EventHandler
   public void m_aaa895af(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (!var2.isCreative() && MinecraftKeyBind.ATTACK.isPressed() && !(C0114.bootstrap<"call",0,1>().getScreen() instanceof ContainerScreen)) {
         BlockSwingResult var3 = C0114.bootstrap<"call",0,1>().getHitBlock();
         if (var3 != null) {
            if (var3.getBlock().isAir()
               || this.f_b2f2c1b8 != null && this.f_b2f2c1b8.equals(var3.getBlock()) && this.f_6dd63185 == var2.getInventory().getCurrentItem()) {
               return;
            }

            int var4 = this.m_ddd4641b(var2, var3.getBlock());
            if (var4 != -1) {
               this.f_b2f2c1b8 = var3.getBlock();
               this.f_6dd63185 = var4 - 36;
               if (!this.m_3fc84db5()) {
                  this.f_57786021 = (C0073.anonymousboolean)((C0073.anonymousboolean)((C0073.anonymousboolean)C0114.bootstrap<"call",2,1>().m_af118271(this))
                        .m_b5be4463(var4))
                     .m_eebb0db7();
                  if (this.f_b1019137) {
                     this.f_57786021
                        .m_f83aeac8(
                           () -> {
                              BlockSwingResult var1x = C0114.bootstrap<"call",0,1>().getHitBlock();
                              return C0114.bootstrap<"call",5,1>(
                                 var1x == null || !var1x.getBlock().equals(var3.getBlock()) && !var3.getBlock().isAir() || !MinecraftKeyBind.ATTACK.isPressed()
                              );
                           }
                        );
                  }
               } else {
                  ((C0073.anonymousboolean)C0114.bootstrap<"call",2,1>().m_b5be4463(var4)).m_eebb0db7();
               }
            }
         }
      }
   }

   private boolean m_3fc84db5() {
      return this.f_57786021 != null && this.f_57786021.m_854ff3ba();
   }

   private int m_ddd4641b(MainEntityPlayer var1, Block var2) {
      this.f_7e00437a.m_586dbaa6(var2);
      int var3 = this.f_7e00437a.m_5220349c(0, var1.getInventory().getSize(), -1, 1.0F);
      if (!C0114.bootstrap<"call",3,1>(var3) && !this.f_0c8419ce) {
         var3 = this.f_7e00437a.m_5220349c(0, 8, -1, 1.0F);
      }

      if (var3 != -1) {
         if (var3 == var1.getInventory().getCurrentItem()) {
            return -1;
         }

         if (!C0114.bootstrap<"call",3,1>(var3)) {
            C0073.anonymousdefault var4 = (C0073.anonymousdefault)((C0073.anonymousdefault)C0114.bootstrap<"call",4,1>().m_44d897bb(var3)).m_6a6e19f6();
            var3 = var4.m_514a3e72();
            var4.m_08fa2bad();
         }
      }

      return var3;
   }
}
