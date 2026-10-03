package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.block.BarrelEntity;
import me.deftware.client.framework.entity.block.ChestEntity;
import me.deftware.client.framework.entity.block.ShulkerEntity;
import me.deftware.client.framework.entity.block.TileEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventGuiContainerClose;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.inventory.Inventory;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.math.box.BoundingBox;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.network.packets.CPacketPlayerUseBlock;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.types.StorageBlock;

public class C0351 extends AbstractMod {
   @C0098(
      value = "Speed",
      description = {"Delay between indexing each chest", "in milliseconds"},
      number = @C0096(
         min = 10.0,
         max = 2000.0
      )
   )
   private double f_11bf638e = 800.0;
   @C0098(
      value = "Cache",
      description = {"Chest cache in seconds"},
      number = @C0096(
         min = 5.0,
         max = 60.0
      )
   )
   private int f_5a76065d = 30;
   @C0098(
      value = "Range",
      description = {"Distance from a chest to render its content"}
   )
   private double f_9ddfee58 = 15.0;
   @C0098(
      value = "Mouse over",
      description = {"Require the crosshair to be over chests to peek in"}
   )
   private boolean f_6c9fd5ac = false;
   @C0098(
      value = "Empty Chests",
      description = {"Render tag over empty chests"}
   )
   private boolean f_7346cc30 = true;
   @C0098(
      value = "Index Time",
      description = {"Time to index a chest"},
      number = @C0096(
         min = 10.0,
         max = 1000.0
      )
   )
   private double f_58df0e81 = (this.f_11bf638e - 200.0) / 2.0;
   private final Map<Long, C0351.anonymousconst> f_84a0eac2 = new ConcurrentHashMap<>();
   private boolean f_4bbb802c = false;
   private ContainerScreen f_a0e627d6;
   private C0351.anonymousconst f_e38aacdd;
   private long f_18bc3da6;
   private long f_7ce7c528;
   private final C0292 f_b0f53ab1 = (C0292)C0114.bootstrap<"call",0,1>(C0292.class);

   public C0351() {
      super(C0252.bootstrap<"get",47244640314>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640315>());
   }

   @Override
   public void onDisable() {
      this.f_84a0eac2.clear();
      this.f_e38aacdd = null;
      this.f_4bbb802c = false;
      this.f_a0e627d6 = null;
   }

   @EventHandler
   private void m_051d5c4e(EventWorldLoad var1) {
      this.onDisable();
   }

   @Override
   public String getDisplayMode() {
      return C0114.bootstrap<"call",0,1>(this.f_84a0eac2.size());
   }

   @EventHandler
   public void m_4811b466(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
      if (this.f_e38aacdd == null && (double)this.f_18bc3da6 + this.f_11bf638e < (double)C0114.bootstrap<"call",2,1>()) {
         this.f_84a0eac2.entrySet().removeIf(var0 -> var0.getValue().m_ba5f5068());
         if (this.f_6c9fd5ac) {
            BlockSwingResult var3 = C0114.bootstrap<"call",0,1>().getHitBlock();
            if (var3 != null
               && var3.getBlock() instanceof StorageBlock
               && !this.f_84a0eac2.containsKey(C0114.bootstrap<"call",3,1>(var3.getBlockPosition().asLong()))) {
               this.m_bb2890e9(var3.getBlockPosition(), var3);
            }
         } else {
            Optional var6 = C0114.bootstrap<"call",4,1>()
               .getLoadedTileEntities()
               .filter(var0 -> var0 instanceof ChestEntity || var0 instanceof BarrelEntity || var0 instanceof ShulkerEntity)
               .filter(var1x -> (double)var1x.distanceTo(var2) <= 4.5)
               .filter(var1x -> !this.f_84a0eac2.containsKey(C0114.bootstrap<"call",3,1>(var1x.getBlockPosition().asLong())))
               .findFirst();
            if (var6.isPresent()) {
               BlockPosition var4 = ((TileEntity)var6.get()).getBlockPosition();
               BlockSwingResult var5 = new BlockSwingResult(new Vector3d(var4), EnumFacing.NORTH, var4, false);
               this.m_bb2890e9(var4, var5);
            }
         }
      } else if (this.f_e38aacdd != null && this.f_a0e627d6 != null) {
         System.out.println(C0252.bootstrap<"get",47244640316>());
         this.f_e38aacdd.m_9bc91cb0(this.f_a0e627d6.getContainerInventory());
         if (this.f_4bbb802c && (double)this.f_7ce7c528 + this.f_58df0e81 < (double)C0114.bootstrap<"call",2,1>()) {
            var2.closeHandledScreen();
         }
      }
   }

   private void m_bb2890e9(BlockPosition var1, BlockSwingResult var2) {
      this.f_18bc3da6 = C0114.bootstrap<"call",2,1>();
      this.f_e38aacdd = new C0351.anonymousconst(var1);
      this.f_4bbb802c = true;
      this.f_84a0eac2.putIfAbsent(C0114.bootstrap<"call",3,1>(var1.asLong()), this.f_e38aacdd);
      new CPacketPlayerUseBlock(var2).sendPacket();
   }

   @EventHandler
   public void m_c6e06078(EventGuiContainerClose var1) {
      this.f_e38aacdd = null;
      this.f_4bbb802c = false;
      this.f_a0e627d6 = null;
   }

   @EventHandler
   private void m_1ec862e8(EventScreen var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1.getScreen() instanceof ContainerScreen && var2 != null) {
         this.f_a0e627d6 = (ContainerScreen)var1.getScreen();
         if (var1.getType() == Type.Setup && !this.f_a0e627d6.isPlayerInventory()) {
            this.f_7ce7c528 = C0114.bootstrap<"call",2,1>();
            if (this.f_e38aacdd == null) {
               BlockSwingResult var3 = C0114.bootstrap<"call",0,1>().getHitBlock();
               if (var3 != null && var3.getBlock() instanceof StorageBlock) {
                  BlockPosition var4 = var3.getBlockPosition();
                  long var5 = var4.asLong();
                  if (!this.f_84a0eac2.containsKey(C0114.bootstrap<"call",3,1>(var5))) {
                     this.f_84a0eac2.put(C0114.bootstrap<"call",3,1>(var5), this.f_e38aacdd = new C0351.anonymousconst(var4));
                  } else {
                     this.f_e38aacdd = this.f_84a0eac2.get(C0114.bootstrap<"call",3,1>(var5));
                  }
               }
            }

            if (this.f_e38aacdd != null && this.f_4bbb802c) {
               C0114.bootstrap<"call",0,1>().openScreen(null);
            }
         }
      }
   }

   @EventHandler
   public void m_cd4d6682(EventRender3D var1) {
      Entity var2 = (Entity)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getCameraEntity());
      BlockSwingResult var3 = C0114.bootstrap<"call",0,1>().getHitBlock();

      for (C0351.anonymousconst var5 : this.f_84a0eac2.values()) {
         if (var5.m_7e30d9ee(var2)
            && (!this.f_6c9fd5ac || var3 != null && var3.getBlockPosition().equals(var5.m_ddc271e9()))
            && (this.f_7346cc30 || !var5.m_b27250ec().isEmpty())) {
            var5.m_3148f8c0(var2);
         }
      }
   }

   public Map<Long, C0351.anonymousconst> m_bb663d14() {
      return this.f_84a0eac2;
   }

   private class anonymousconst {
      private long f_14579629;
      private BlockPosition f_e4df7a21;
      private final BoundingBox f_24aa85af;
      private final List<ItemStack> f_842b4dab = new ArrayList<>();

      public anonymousconst(BlockPosition var2) {
         this.f_e4df7a21 = var2;
         Block var3 = C0114.bootstrap<"call",0,1>()._getBlockFromPosition(var2);
         if (var3 instanceof StorageBlock) {
            this.f_24aa85af = ((StorageBlock)var3).getBoundingBox(var3.getLocationBlockState());
         } else {
            this.f_24aa85af = var2.getBoundingBox();
         }
      }

      public void m_9bc91cb0(Inventory var1) {
         this.f_14579629 = C0114.bootstrap<"call",0,1>();
         this.f_842b4dab.clear();

         for (int var2 = 0; var2 < var1.getSize(); var2++) {
            ItemStack var3 = var1.getStackInSlot(var2);
            if (!var3.isEmpty()) {
               this.f_842b4dab.add(var3);
            }
         }
      }

      public boolean m_ba5f5068() {
         return (double)this.f_14579629 + (double)C0114.bootstrap<"call",1,1>(C0351.this) * 1000.0 < (double)C0114.bootstrap<"call",0,1>();
      }

      public boolean m_7e30d9ee(Entity var1) {
         return (double)this.f_e4df7a21.distanceTo(var1.getBlockPosition()) <= C0114.bootstrap<"call",2,1>(C0351.this);
      }

      public void m_3148f8c0(Entity var1) {
         double var2 = this.f_24aa85af.getCenter().getX() - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosX();
         double var4 = this.f_e4df7a21.getY() + 1.5 - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosY();
         double var6 = this.f_24aa85af.getCenter().getZ() - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosZ();
         float var8 = this.f_e4df7a21.distanceTo(var1.getBlockPosition());
         C0114.bootstrap<"call",1,1>(C0351.this).f_1e328b96.addAll(this.f_842b4dab);
         C0114.bootstrap<"call",1,1>(C0351.this)
            .m_60b3b482(
               var2,
               var4,
               var6,
               var8,
               C0114.bootstrap<"call",4,1>(
                     C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",47244640313>(), new Object[]{C0114.bootstrap<"call",2,1>(this.f_842b4dab.size())})
                  )
                  .style(C0114.bootstrap<"call",5,1>(DefaultColors.WHITE)),
               var1,
               null,
               0
            );
      }

      public long m_f75f879b() {
         return this.f_14579629;
      }

      public BlockPosition m_ddc271e9() {
         return this.f_e4df7a21;
      }

      public BoundingBox m_7931a0a7() {
         return this.f_24aa85af;
      }

      public List<ItemStack> m_b27250ec() {
         return this.f_842b4dab;
      }
   }
}
