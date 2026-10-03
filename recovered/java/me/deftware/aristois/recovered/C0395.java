package me.deftware.aristois.recovered;

import java.util.List;
import java.util.function.Predicate;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventPacketSend;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.global.types.BlockProperty;
import me.deftware.client.framework.input.MinecraftKeyBind;
import me.deftware.client.framework.main.bootstrap.Bootstrap;
import me.deftware.client.framework.math.box.BoundingBox;
import me.deftware.client.framework.math.box.DoubleBoundingBox;
import me.deftware.client.framework.math.box.VoxelShape;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.network.packets.CPacketPlayer;
import me.deftware.client.framework.world.block.Block;

public class C0395 extends AbstractMod {
   private static final List<Block> f_982e3966 = C0114.bootstrap<"call",0,1>(new Block[]{C0071.f_6f1d2d8d, C0071.f_10cf7abf});
   @C0098("Mode")
   private C0102<C0395.anonymousconst> f_76f559ba = new C0102<>(C0395.anonymousconst.f_270003fa);
   private boolean f_09e5acdb;

   public C0395() {
      super(C0252.bootstrap<"get",42949673059>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673060>());
      this.setMode(this.f_76f559ba);
   }

   @EventHandler
   public void m_ebf9d5ae(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (this.f_76f559ba.m_e2691446() == C0395.anonymousconst.f_270003fa) {
         f_982e3966.forEach(
            var0 -> ((BlockProperty)Bootstrap.blockProperties.get(var0.getID())).setVoxelShape(MinecraftKeyBind.SNEAK.isPressed() ? null : VoxelShape.SOLID)
         );
      } else if (this.f_76f559ba.m_e2691446() == C0395.anonymousconst.f_e3a4dcdb) {
         if (var2.getVehicle() != null && var2.getVehicle().isInLiquid()) {
            var2.getVehicle().setVelocity(var2.getVehicle().getVelocity().add(0.0, 0.056, 0.0));
         } else if (var2.isInLiquid()) {
            var2.setVelocity(var2.getVelocity().set(0.0, 1.0E-9, 0.0));
         }
      } else if (this.f_76f559ba.m_e2691446() == C0395.anonymousconst.f_28ae1d9c) {
         BlockPosition var3 = var2.getBlockPosition().offset(0.0, -1.0, 0.0);
         if (!var2.isOnGround() && C0114.bootstrap<"call",2,1>()._getBlockFromPosition(var3).isLiquid() || var2.isInLiquid()) {
            var2.setVelocity(var2.getVelocity().getX() * 0.99999, var2.getVelocity().getY() * 0.0, var2.getVelocity().getZ() * 0.99999);
            if (var2.isCollidedHorizontally()) {
               var2.setVelocity(var2.getVelocity().set(0.0, (var2.getPosY() - var2.getPosY() - 1.0) / 8.0, 0.0));
            }

            var2.setVelocity(var2.getVelocity().set(0.0, var2.getFallDistance() >= 4.0F ? -0.004 : 0.09, 0.0));
         }

         if (var2.getHurtTime() != 0) {
            var2.setOnGround(false);
         }
      }
   }

   @EventHandler
   public void m_bbc5df82(EventPacketSend var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var2 != null && this.f_76f559ba.m_e2691446() == C0395.anonymousconst.f_28ae1d9c && var1.getIPacket() instanceof CPacketPlayer) {
         CPacketPlayer var3 = (CPacketPlayer)var1.getIPacket();
         if (this.m_52e00048(
            new DoubleBoundingBox(
               var2.getBoundingBox().getMaxX(),
               var2.getBoundingBox().getMaxY(),
               var2.getBoundingBox().getMaxZ(),
               var2.getBoundingBox().getMinX(),
               var2.getBoundingBox().getMinY() - 0.01,
               var2.getBoundingBox().getMinZ()
            ),
            Block::isLiquid,
            var2
         )) {
            this.f_09e5acdb = !this.f_09e5acdb;
            if (this.f_09e5acdb) {
               var3.setY(0.001);
            }

            var1.setPacket(var3);
         }
      }
   }

   @Override
   public void onDisable() {
      f_982e3966.forEach(var0 -> {
         BlockProperty var10000 = (BlockProperty)Bootstrap.blockProperties.remove(var0.getID());
      });
   }

   @Override
   public void onEnable() {
      f_982e3966.forEach(var0 -> Bootstrap.blockProperties.register(new BlockProperty(var0).setVoxelShape(VoxelShape.SOLID)));
   }

   public boolean m_52e00048(BoundingBox var1, Predicate<Block> var2, EntityPlayer var3) {
      for (double var4 = C0114.bootstrap<"call",3,1>(var3.getBoundingBox().getMinX());
         var4 <= C0114.bootstrap<"call",3,1>(var3.getBoundingBox().getMaxX()) + 1.0;
         var4++
      ) {
         for (double var6 = C0114.bootstrap<"call",3,1>(var3.getBoundingBox().getMinZ());
            var6 <= C0114.bootstrap<"call",3,1>(var3.getBoundingBox().getMaxZ()) + 1.0;
            var6++
         ) {
            Block var8 = C0114.bootstrap<"call",2,1>()._getBlockFromPosition(new DoubleBlockPosition(var4, var1.getMinY(), var6));
            if (!var2.test(var8)) {
               return false;
            }
         }
      }

      return true;
   }

   private static enum anonymousconst {
      f_270003fa,
      f_28ae1d9c,
      f_e3a4dcdb;

      private anonymousconst() {
      }
   }
}
