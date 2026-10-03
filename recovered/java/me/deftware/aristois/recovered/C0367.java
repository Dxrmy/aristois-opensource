package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventBlockBreakingCooldown;
import me.deftware.client.framework.event.events.EventDisconnected;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.network.packets.CPacketDig;
import me.deftware.client.framework.network.packets.CPacketDig.IDigAction;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;

@C0421
public class C0367 extends AbstractMod {
   private static final C0219<Block> f_5c60f829 = new C0219<>(Block.class, C0252.bootstrap<"get",51539607602>());
   @C0098("Blocks")
   private static final GuiScreen f_6533e59a = C0114.bootstrap<"call",0,1>(null, f_5c60f829);
   @C0098(
      value = "Range",
      number = @C0096(
         max = 5.0
      )
   )
   private double f_8f2a18cc = 4.5;
   @C0098("Nuke all blocks")
   private boolean f_725bc76c = true;
   @C0098(
      value = "Auto disable",
      description = {"Automatically disable nuker if you get disconnected"}
   )
   private boolean f_5881e5ff = true;
   @C0098(
      value = "Y-Limit",
      description = {"Only nuke blocks above a set Y limit"}
   )
   private boolean f_b584bc7e = false;
   @C0098(
      value = "Y-Level",
      number = @C0096(
         min = -64.0,
         max = 320.0
      )
   )
   private int f_ab41eb60 = 60;

   public C0367() {
      super(C0252.bootstrap<"get",51539607600>(), C0290.f_faada303, C0252.bootstrap<"get",51539607601>());
   }

   @EventHandler
   public void m_487ff8f4(EventDisconnected var1) {
      if (this.f_5881e5ff) {
         this.toggle();
      }
   }

   @EventHandler
   public void m_8e68a541(EventBlockBreakingCooldown var1) {
      var1.setCooldown(0);
   }

   @EventHandler
   public void m_63b305e5(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (C0114.bootstrap<"call",2,1>() != null) {
         for (int var3 = (int)(-this.f_8f2a18cc); (double)var3 <= this.f_8f2a18cc; var3++) {
            for (int var4 = (int)this.f_8f2a18cc; (double)var4 >= -this.f_8f2a18cc; var4--) {
               for (int var5 = (int)(-this.f_8f2a18cc); (double)var5 <= this.f_8f2a18cc; var5++) {
                  int var6 = (int)(var2.getPosX() + (double)var3);
                  int var7 = (int)(var2.getPosY() + (double)var4);
                  int var8 = (int)(var2.getPosZ() + (double)var5);
                  if (!this.f_b584bc7e || var7 >= this.f_ab41eb60) {
                     DoubleBlockPosition var9 = new DoubleBlockPosition((double)var6, (double)var7, (double)var8);
                     Block var10 = C0114.bootstrap<"call",2,1>()._getBlockFromPosition(var9);
                     if (f_5c60f829.contains(var10) || this.f_725bc76c) {
                        new CPacketDig(IDigAction.START_DESTROY_BLOCK, var9, EnumFacing.DOWN).sendPacket();
                        new CPacketDig(IDigAction.STOP_DESTROY_BLOCK, var9, EnumFacing.DOWN).sendPacket();
                     }
                  }
               }
            }
         }
      }
   }

   public static C0219<Block> m_82a33306() {
      return f_5c60f829;
   }

   public static GuiScreen m_6b886a0c() {
      return f_6533e59a;
   }
}
