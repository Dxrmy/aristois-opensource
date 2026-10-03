package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.InteractableBlock;

public class C0372 extends AbstractMod {
   @C0098(
      value = "Overlay",
      description = {"Render block overlay"}
   )
   private boolean f_28bbc8ea = true;
   private final CubeRenderStack f_883a1936 = new CubeRenderStack();
   private final List<C0372.anonymousconst> f_456ac203 = new ArrayList<>();

   public C0372() {
      super(C0259.m_56cd5284(), C0290.f_829d9b20, C0259.m_62895921());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      EntityInventory var3 = var2.getInventory();
      if (ClientWorld.getClientWorld() != null && !var2.isSneaking()) {
         BlockPosition var4 = this.m_678057ba(var2.getBlockPosition()).offset(0.0, -1.0, 0.0);
         this.f_456ac203.clear();
         EntityHand var5 = C0217.m_cd81d441(var3, var0 -> var0 instanceof BlockItem && !(var0.getAsBlock() instanceof InteractableBlock));
         if (var5 != EntityHand.None) {
            this.m_03709c71(this.m_13f01fe4(var2), var4);
         }

         for (C0372.anonymousconst var7 : this.f_456ac203) {
            Block var8 = ClientWorld.getClientWorld()._getBlockFromPosition(var7.m_82942af9());
            Block var9 = ClientWorld.getClientWorld()._getBlockFromPosition(var7.m_82942af9().offset(0.0, 1.0, 0.0));
            if (var8.isAir() || var8.isLiquid() && var9.isAir() || this.m_d553f392(var8)) {
               var7.m_9f14d795(var2, var5);
            }
         }
      }
   }

   private boolean m_d553f392(Block var1) {
      return var1.getIdentifierKey().toLowerCase().contains(C0259.m_ec4ef19a());
   }

   private C0215 m_13f01fe4(MainEntityPlayer var1) {
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

      return C0215.m_923238c5(var3);
   }

   private void m_03709c71(C0215 var1, BlockPosition var2) {
      if (var1 == C0215.f_91e62fdd || var1 == C0215.f_7a64b3de || var1 == C0215.f_3c4a1b12) {
         byte var4 = 0;
         if (var1 == C0215.f_7a64b3de) {
            var4 = 1;
            this.f_456ac203.add(new C0372.anonymousconst(var2.offset((double)1, 0.0, 0.0), EnumFacing.EAST));
         } else if (var1 == C0215.f_3c4a1b12) {
            var4 = -1;
            this.f_456ac203.add(new C0372.anonymousconst(var2.offset((double)-1, 0.0, 0.0), EnumFacing.WEST));
         }

         this.f_456ac203.add(new C0372.anonymousconst(var2.offset((double)var4, 0.0, 1.0), EnumFacing.NORTH));
      } else if (var1 == C0215.f_6eb9252e || var1 == C0215.f_57482be4 || var1 == C0215.f_acfe15ce) {
         byte var3 = 0;
         if (var1 == C0215.f_57482be4) {
            var3 = 1;
            this.f_456ac203.add(new C0372.anonymousconst(var2.offset((double)1, 0.0, -1.0), EnumFacing.EAST));
         } else if (var1 == C0215.f_acfe15ce) {
            var3 = -1;
            this.f_456ac203.add(new C0372.anonymousconst(var2.offset((double)-1, 0.0, -1.0), EnumFacing.WEST));
         }

         this.f_456ac203
            .add(
               new C0372.anonymousconst(
                  var2.offset((double)var3, 0.0, var1 == C0215.f_6eb9252e ? -1.0 : 0.0), var1 == C0215.f_6eb9252e ? EnumFacing.SOUTH : EnumFacing.NORTH
               )
            );
      } else if (var1 == C0215.f_08ddf818 || var1 == C0215.f_980a027c) {
         this.f_456ac203
            .add(
               new C0372.anonymousconst(
                  var2.offset(var1 == C0215.f_08ddf818 ? 1.0 : -1.0, 0.0, 0.0), var1 == C0215.f_08ddf818 ? EnumFacing.WEST : EnumFacing.EAST
               )
            );
      }
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      if (this.f_456ac203 != null && this.f_28bbc8ea) {
         ((CubeRenderStack)this.f_883a1936.begin(true).glColor(Color.yellow, 180.0F)).lineWidth(2.0F);

         for (C0372.anonymousconst var3 : this.f_456ac203) {
            this.f_883a1936.draw(var3.m_82942af9().getBoundingBox());
         }

         this.f_883a1936.end();
      }
   }

   private BlockPosition m_678057ba(BlockPosition var1) {
      return new DoubleBlockPosition(Math.floor(var1.getX()), Math.floor(var1.getY()), Math.floor(var1.getZ()));
   }

   private static class anonymousconst {
      private BlockPosition f_5001b304;
      private EnumFacing f_4b244998;

      public void m_9f14d795(MainEntityPlayer var1, EntityHand var2) {
         if (var1.processRightClickBlock(this.m_82942af9(), this.m_d065284e(), this.m_82942af9().getVector(), var2)) {
            var1.swingArmClientSide(var2);
         }
      }

      public BlockPosition m_82942af9() {
         return this.f_5001b304;
      }

      public EnumFacing m_d065284e() {
         return this.f_4b244998;
      }

      public void m_2405ca7d(BlockPosition var1) {
         this.f_5001b304 = var1;
      }

      public void m_ee85a5a1(EnumFacing var1) {
         this.f_4b244998 = var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof C0372.anonymousconst)) {
            return false;
         } else {
            C0372.anonymousconst var2 = (C0372.anonymousconst)var1;
            if (!var2.m_22ad6203(this)) {
               return false;
            } else {
               BlockPosition var3 = this.m_82942af9();
               BlockPosition var4 = var2.m_82942af9();
               if (var3 == null ? var4 == null : var3.equals(var4)) {
                  EnumFacing var5 = this.m_d065284e();
                  EnumFacing var6 = var2.m_d065284e();
                  return var5 == null ? var6 == null : var5.equals(var6);
               } else {
                  return false;
               }
            }
         }
      }

      protected boolean m_22ad6203(Object var1) {
         return var1 instanceof C0372.anonymousconst;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         BlockPosition var3 = this.m_82942af9();
         var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
         EnumFacing var4 = this.m_d065284e();
         return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      }

      @Override
      public String toString() {
         return C0259.m_f599ae93() + this.m_82942af9() + C0259.m_5b2d5cb2() + this.m_d065284e() + C0257.m_9e27f038();
      }

      public anonymousconst(BlockPosition var1, EnumFacing var2) {
         this.f_5001b304 = var1;
         this.f_4b244998 = var2;
      }
   }
}
