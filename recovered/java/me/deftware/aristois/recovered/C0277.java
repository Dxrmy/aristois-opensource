package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.block.InteractableBlock;

public abstract class C0277 extends C0279 {
   private boolean f_32ef1cfe = false;
   private boolean f_0417440c = false;

   public C0277(int var1, EntityPlayer var2) {
      super(var1, var2);
   }

   public C0279 m_859b8950() {
      super.m_fb884086();
      MinecraftKeyBind.USE_ITEM.setPressed(true);
      return this;
   }

   public C0279 m_3a250deb() {
      if (!this.m_b6f0782c()) {
         MinecraftKeyBind.USE_ITEM.setPressed(false);
         this.m_298f9c49();
         return this;
      } else {
         if ((this.f_3437aab2.test(this.f_bc3b0c5c) || !this.f_32ef1cfe) && !this.f_dead560b) {
            this.m_83ca93c0();
            if (this.m_b6f0782c()) {
               this.f_0417440c = false;
               this.m_b8ae9ef2();
               if (ScreenRegistry.Chat.isOpen()) {
                  C0114.bootstrap<"call",0,1>(1);
               }
            } else if (!this.f_0417440c) {
               this.f_0417440c = true;
               MinecraftKeyBind.USE_ITEM.setPressed(false);
            }
         } else {
            MinecraftKeyBind.USE_ITEM.setPressed(false);
            super.m_7b565b67();
         }

         return this;
      }
   }

   protected void m_b8ae9ef2() {
      MinecraftKeyBind.USE_ITEM.setPressed(this.f_32ef1cfe = true);
   }

   private boolean m_b6f0782c() {
      BlockSwingResult var1 = C0114.bootstrap<"call",0,1>().getHitBlock();
      return var1 == null || !(var1.getBlock() instanceof InteractableBlock) && !this.f_de55e104;
   }
}
