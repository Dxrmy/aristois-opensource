package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventCollideCheck;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.block.Block;

@C0421
public class C0338 extends AbstractMod {
   private static final C0219<Block> f_96e63027 = new C0219<>(
      Block.class,
      C0252.bootstrap<"get",47244640286>(),
      C0114.bootstrap<"call",0,1>(
            BlockRegistry.INSTANCE,
            new String[]{
               C0252.bootstrap<"get",12884901940>(),
               C0252.bootstrap<"get",30064771125>(),
               C0252.bootstrap<"get",30064771124>(),
               C0252.bootstrap<"get",47244640287>()
            }
         )
         .toArray(new Block[0])
   );
   @C0098(
      value = "Blocks",
      description = {"Select blocks to allow interaction with"}
   )
   private static final GuiScreen f_99b01cad = C0114.bootstrap<"call",1,1>(null, f_96e63027);
   private BlockPosition f_11521b5c;

   public C0338() {
      super(C0252.bootstrap<"get",47244640283>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640284>(), C0252.bootstrap<"get",47244640285>());
   }

   @EventHandler
   public void m_8e13c658(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      BlockSwingResult var3 = C0114.bootstrap<"call",0,1>().getHitBlock();
      if (var3 != null) {
         BlockPosition var4 = var3.getBlockPosition().offset(var2.getHorizontalFacing());
         Block var5 = C0114.bootstrap<"call",2,1>()._getBlockFromPosition(var4);
         if (f_96e63027.contains(var5)) {
            this.f_11521b5c = var3.getBlockPosition();
         }
      } else {
         this.f_11521b5c = null;
      }
   }

   @EventHandler
   public void m_abacdc83(EventCollideCheck var1) {
      if (this.f_11521b5c != null && this.m_bef2f0ef(var1.getPosition(), this.f_11521b5c, 1.0)) {
         var1.setCollidable(true);
      }
   }

   private boolean m_bef2f0ef(BlockPosition var1, BlockPosition var2, double var3) {
      return var1.getZ() == var2.getZ() && var1.getX() == var2.getX() ? C0114.bootstrap<"call",3,1>(var1.getY() - var2.getY()) <= var3 : false;
   }

   public static C0219<Block> m_00608538() {
      return f_96e63027;
   }

   public static GuiScreen m_7a0ca694() {
      return f_99b01cad;
   }
}
