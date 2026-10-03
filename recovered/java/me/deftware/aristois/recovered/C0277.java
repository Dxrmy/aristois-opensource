package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.input.Mouse;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.block.InteractableBlock;

public abstract class C0277 extends C0279 {
   private boolean f_cca0ba88 = false;
   private boolean f_da6bcb83 = false;

   public C0277(int var1, EntityPlayer var2) {
      super(var1, var2);
   }

   @Override
   public C0279 m_30bfe4e5() {
      super.m_30bfe4e5();
      MinecraftKeyBind.USE_ITEM.setPressed(true);
      return this;
   }

   @Override
   public C0279 m_e3ec0ce5() {
      if (!this.m_5d7ada2f()) {
         MinecraftKeyBind.USE_ITEM.setPressed(false);
         this.m_476256a8();
         return this;
      } else {
         if ((this.f_06024348.test(this.f_35114e14) || !this.f_cca0ba88) && !this.f_d5801aab) {
            this.m_e4dddc57();
            if (this.m_5d7ada2f()) {
               this.f_da6bcb83 = false;
               this.m_ae2c9744();
               if (ScreenRegistry.Chat.isOpen()) {
                  Mouse.clickMouse(1);
               }
            } else if (!this.f_da6bcb83) {
               this.f_da6bcb83 = true;
               MinecraftKeyBind.USE_ITEM.setPressed(false);
            }
         } else {
            MinecraftKeyBind.USE_ITEM.setPressed(false);
            super.m_e3ec0ce5();
         }

         return this;
      }
   }

   protected void m_ae2c9744() {
      MinecraftKeyBind.USE_ITEM.setPressed(this.f_cca0ba88 = true);
   }

   private boolean m_5d7ada2f() {
      BlockSwingResult var1 = Minecraft.getMinecraftGame().getHitBlock();
      return var1 == null || !(var1.getBlock() instanceof InteractableBlock) && !this.f_3baca66d;
   }
}
