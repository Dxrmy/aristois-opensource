package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.EntityHand;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.inventory.EntityInventory;
import me.deftware.client.framework.item.types.BlockItem;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.InteractableBlock;

public class C0372 extends AbstractMod {
   @C0098(
      value = "Overlay",
      description = {"Render block overlay"}
   )
   private boolean f_12e2fc68 = true;
   private final CubeRenderStack f_60e8d56f = new CubeRenderStack();
   private final List<C0372.anonymousconst> f_3ebda934 = new ArrayList<>();

   public C0372() {
      super(C0252.bootstrap<"get",42949673082>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673083>());
   }

   @EventHandler
   public void m_99d7413f(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      EntityInventory var3 = var2.getInventory();
      if (C0114.bootstrap<"call",2,1>() != null && !var2.isSneaking()) {
         BlockPosition var4 = this.m_82ac943c(var2.getBlockPosition()).offset(0.0, -1.0, 0.0);
         this.f_3ebda934.clear();
         EntityHand var5 = C0114.bootstrap<"call",3,1>(var3, var0 -> var0 instanceof BlockItem && !(var0.getAsBlock() instanceof InteractableBlock));
         if (var5 != EntityHand.None) {
            this.m_40537a52(this.m_aa74fa88(var2), var4);
         }

         for (C0372.anonymousconst var7 : this.f_3ebda934) {
            Block var8 = C0114.bootstrap<"call",2,1>()._getBlockFromPosition(var7.m_67e29aee());
            Block var9 = C0114.bootstrap<"call",2,1>()._getBlockFromPosition(var7.m_67e29aee().offset(0.0, 1.0, 0.0));
            if (var8.isAir() || var8.isLiquid() && var9.isAir() || this.m_f271bed2(var8)) {
               var7.m_5fd5960a(var2, var5);
            }
         }
      }
   }

   private boolean m_f271bed2(Block var1) {
      return var1.getIdentifierKey().toLowerCase().contains(C0252.bootstrap<"get",42949673084>());
   }

   private C0215 m_aa74fa88(MainEntityPlayer var1) {
      float var2 = 0.0F;
      if (MinecraftKeyBind.RIGHT.isHeld()) {
         var2 = 90.0F;
      } else if (MinecraftKeyBind.LEFT.isHeld()) {
         var2 = -90.0F;
      } else if (MinecraftKeyBind.BACK.isHeld()) {
         var2 = 180.0F;
      }

      float var3 = (var1.getRotationYaw() + var2 + 90.0F) % 360.0F;
      if (var3 < 0.0F) {
         var3 += 360.0F;
      }

      return C0114.bootstrap<"call",4,1>(var3);
   }

   private void m_40537a52(C0215 var1, BlockPosition var2) {
      if (var1 == C0215.f_664159a0 || var1 == C0215.f_7ed71fd2 || var1 == C0215.f_2b6ebab8) {
         byte var4 = 0;
         if (var1 == C0215.f_7ed71fd2) {
            var4 = 1;
            this.f_3ebda934.add(new C0372.anonymousconst(var2.offset((double)1, 0.0, 0.0), EnumFacing.EAST));
         } else if (var1 == C0215.f_2b6ebab8) {
            var4 = -1;
            this.f_3ebda934.add(new C0372.anonymousconst(var2.offset((double)-1, 0.0, 0.0), EnumFacing.WEST));
         }

         this.f_3ebda934.add(new C0372.anonymousconst(var2.offset((double)var4, 0.0, 1.0), EnumFacing.NORTH));
      } else if (var1 == C0215.f_0e18c9b2 || var1 == C0215.f_f26fb985 || var1 == C0215.f_a3529769) {
         byte var3 = 0;
         if (var1 == C0215.f_f26fb985) {
            var3 = 1;
            this.f_3ebda934.add(new C0372.anonymousconst(var2.offset((double)1, 0.0, -1.0), EnumFacing.EAST));
         } else if (var1 == C0215.f_a3529769) {
            var3 = -1;
            this.f_3ebda934.add(new C0372.anonymousconst(var2.offset((double)-1, 0.0, -1.0), EnumFacing.WEST));
         }

         this.f_3ebda934
            .add(
               new C0372.anonymousconst(
                  var2.offset((double)var3, 0.0, var1 == C0215.f_0e18c9b2 ? -1.0 : 0.0), var1 == C0215.f_0e18c9b2 ? EnumFacing.SOUTH : EnumFacing.NORTH
               )
            );
      } else if (var1 == C0215.f_c4e10650 || var1 == C0215.f_1538e231) {
         this.f_3ebda934
            .add(
               new C0372.anonymousconst(
                  var2.offset(var1 == C0215.f_c4e10650 ? 1.0 : -1.0, 0.0, 0.0), var1 == C0215.f_c4e10650 ? EnumFacing.WEST : EnumFacing.EAST
               )
            );
      }
   }

   @EventHandler
   public void m_7fe04127(EventRender3D var1) {
      if (this.f_3ebda934 != null && this.f_12e2fc68) {
         ((CubeRenderStack)this.f_60e8d56f.begin(true).glColor(Color.yellow, 180.0F)).lineWidth(2.0F);

         for (C0372.anonymousconst var3 : this.f_3ebda934) {
            this.f_60e8d56f.draw(var3.m_67e29aee().getBoundingBox());
         }

         this.f_60e8d56f.end();
      }
   }

   private BlockPosition m_82ac943c(BlockPosition var1) {
      return new DoubleBlockPosition(
         C0114.bootstrap<"call",5,1>(var1.getX()), C0114.bootstrap<"call",5,1>(var1.getY()), C0114.bootstrap<"call",5,1>(var1.getZ())
      );
   }

   private static class anonymousconst {
      private BlockPosition f_725ae086;
      private EnumFacing f_3d7d3190;

      public void m_5fd5960a(MainEntityPlayer var1, EntityHand var2) {
         if (var1.processRightClickBlock(this.m_67e29aee(), this.m_bf6137b1(), this.m_67e29aee().getVector(), var2)) {
            var1.swingArmClientSide(var2);
         }
      }

      public BlockPosition m_67e29aee() {
         return this.f_725ae086;
      }

      public EnumFacing m_bf6137b1() {
         return this.f_3d7d3190;
      }

      public void m_c71e4ebf(BlockPosition var1) {
         this.f_725ae086 = var1;
      }

      public void m_daaf8841(EnumFacing var1) {
         this.f_3d7d3190 = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0372.anonymousconst)) {
            return false;
         } else {
            C0372.anonymousconst var2 = (C0372.anonymousconst)var1;
            if (!var2.m_17168322(this)) {
               return false;
            } else {
               BlockPosition var3 = this.m_67e29aee();
               BlockPosition var4 = var2.m_67e29aee();
               if (var3 == null ? var4 == null : var3.equals(var4)) {
                  EnumFacing var5 = this.m_bf6137b1();
                  EnumFacing var6 = var2.m_bf6137b1();
                  return var5 == null ? var6 == null : var5.equals(var6);
               } else {
                  return false;
               }
            }
         }
      }

      protected boolean m_17168322(Object var1) {
         return var1 instanceof C0372.anonymousconst;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         BlockPosition var3 = this.m_67e29aee();
         var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
         EnumFacing var4 = this.m_bf6137b1();
         return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      }

      @Override
      public String toString() {
         return C0252.bootstrap<"get",42949673080>()
            + this.m_67e29aee()
            + C0252.bootstrap<"get",42949673081>()
            + this.m_bf6137b1()
            + C0252.bootstrap<"get",59>();
      }

      public anonymousconst(BlockPosition var1, EnumFacing var2) {
         this.f_725ae086 = var1;
         this.f_3d7d3190 = var2;
      }
   }
}
