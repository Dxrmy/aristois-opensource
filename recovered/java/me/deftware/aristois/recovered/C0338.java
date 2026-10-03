package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventCollideCheck;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.block.Block;

@C0421
public class C0338 extends AbstractMod {
   private static final C0219<Block> f_e8af281a = new C0219<>(
      Block.class,
      C0260.m_28b2c020(),
      C0207.m_2290cbf8(BlockRegistry.INSTANCE, C0266.m_96ba50d4(), C0265.m_88726494(), C0265.m_96ba50d4(), C0260.m_45aaaba8()).toArray(new Block[0])
   );
   @C0098(
      value = "Blocks",
      description = {"Select blocks to allow interaction with"}
   )
   private static final GuiScreen f_3607440b = C0217.m_20baf8c9(null, f_e8af281a);
   private BlockPosition f_f138c82d;

   public C0338() {
      super(C0260.m_056a389d(), C0290.f_99d080af, C0260.m_5fa6dd07(), C0260.m_5f1ab561());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      BlockSwingResult var3 = Minecraft.getMinecraftGame().getHitBlock();
      if (var3 != null) {
         BlockPosition var4 = var3.getBlockPosition().offset(var2.getHorizontalFacing());
         Block var5 = ClientWorld.getClientWorld()._getBlockFromPosition(var4);
         if (f_e8af281a.contains(var5)) {
            this.f_f138c82d = var3.getBlockPosition();
         }
      } else {
         this.f_f138c82d = null;
      }
   }

   @EventHandler
   public void m_644a68d2(EventCollideCheck var1) {
      if (this.f_f138c82d != null && this.m_d0e03f0b(var1.getPosition(), this.f_f138c82d, 1.0)) {
         var1.setCollidable(true);
      }
   }

   private boolean m_d0e03f0b(BlockPosition var1, BlockPosition var2, double var3) {
      return var1.getZ() == var2.getZ() && var1.getX() == var2.getX() ? Math.abs(var1.getY() - var2.getY()) <= var3 : false;
   }

   public static C0219<Block> m_d63c8634() {
      return f_e8af281a;
   }

   public static GuiScreen m_921ecdb2() {
      return f_3607440b;
   }
}
