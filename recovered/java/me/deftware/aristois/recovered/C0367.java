package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockBreakingCooldown;
import me.deftware.client.framework.event.events.EventDisconnected;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketDig;
import me.deftware.client.framework.network.packets.CPacketDig.IDigAction;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;

@C0421
public class C0367 extends AbstractMod {
   private static final C0219<Block> f_2d03ddd0 = new C0219<>(Block.class, C0255.m_a33fab52());
   @C0098("Blocks")
   private static final GuiScreen f_48f26795 = C0217.m_20baf8c9(null, f_2d03ddd0);
   @C0098(
      value = "Range",
      number = @C0096(
         max = 5.0
      )
   )
   private double f_1c0246fa = 4.5;
   @C0098("Nuke all blocks")
   private boolean f_00291dc7 = true;
   @C0098(
      value = "Auto disable",
      description = {"Automatically disable nuker if you get disconnected"}
   )
   private boolean f_08a92fc8 = true;
   @C0098(
      value = "Y-Limit",
      description = {"Only nuke blocks above a set Y limit"}
   )
   private boolean f_0617ab4d = false;
   @C0098(
      value = "Y-Level",
      number = @C0096(
         min = -64.0,
         max = 320.0
      )
   )
   private int f_18957fc4 = 60;

   public C0367() {
      super(C0255.m_7f74d855(), C0290.f_516f3c47, C0255.m_b89b7876());
   }

   @EventHandler
   public void m_e87e680b(EventDisconnected var1) {
      if (this.f_08a92fc8) {
         this.toggle();
      }
   }

   @EventHandler
   public void m_dfc5de8c(EventBlockBreakingCooldown var1) {
      var1.setCooldown(0);
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (ClientWorld.getClientWorld() != null) {
         for (int var3 = (int)(-this.f_1c0246fa); (double)var3 <= this.f_1c0246fa; var3++) {
            for (int var4 = (int)this.f_1c0246fa; (double)var4 >= -this.f_1c0246fa; var4--) {
               for (int var5 = (int)(-this.f_1c0246fa); (double)var5 <= this.f_1c0246fa; var5++) {
                  int var6 = (int)(var2.getPosX() + (double)var3);
                  int var7 = (int)(var2.getPosY() + (double)var4);
                  int var8 = (int)(var2.getPosZ() + (double)var5);
                  if (!this.f_0617ab4d || var7 >= this.f_18957fc4) {
                     DoubleBlockPosition var9 = new DoubleBlockPosition((double)var6, (double)var7, (double)var8);
                     Block var10 = ClientWorld.getClientWorld()._getBlockFromPosition(var9);
                     if (f_2d03ddd0.contains(var10) || this.f_00291dc7) {
                        new CPacketDig(IDigAction.START_DESTROY_BLOCK, var9, EnumFacing.DOWN).sendPacket();
                        new CPacketDig(IDigAction.STOP_DESTROY_BLOCK, var9, EnumFacing.DOWN).sendPacket();
                     }
                  }
               }
            }
         }
      }
   }

   public static C0219<Block> m_d63c8634() {
      return f_2d03ddd0;
   }

   public static GuiScreen m_921ecdb2() {
      return f_48f26795;
   }
}
