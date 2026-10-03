package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.network.packets.CPacketPlayerUseBlock;
import me.deftware.client.framework.util.minecraft.BlockSwingResult;
import me.deftware.client.framework.world.ClientWorld;
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
   private double f_c94c4434 = 800.0;
   @C0098(
      value = "Cache",
      description = {"Chest cache in seconds"},
      number = @C0096(
         min = 5.0,
         max = 60.0
      )
   )
   private int f_ea6c94da = 30;
   @C0098(
      value = "Range",
      description = {"Distance from a chest to render its content"}
   )
   private double f_b8fb63b6 = 15.0;
   @C0098(
      value = "Mouse over",
      description = {"Require the crosshair to be over chests to peek in"}
   )
   private boolean f_01f815f8 = false;
   @C0098(
      value = "Empty Chests",
      description = {"Render tag over empty chests"}
   )
   private boolean f_a079cd49 = true;
   @C0098(
      value = "Index Time",
      description = {"Time to index a chest"},
      number = @C0096(
         min = 10.0,
         max = 1000.0
      )
   )
   private double f_55dd9c4f = (this.f_c94c4434 - 200.0) / 2.0;
   private final Map<Long, C0351.anonymousconst> f_adcdd707 = new ConcurrentHashMap<>();
   private boolean f_c84b8dd2 = false;
   private ContainerScreen f_e2b32634;
   private C0351.anonymousconst f_8a629856;
   private long f_b7c043dd;
   private long f_67c5cd44;
   private final C0292 f_885cf207 = C0289.m_c3a8b502(C0292.class);

   public C0351() {
      super(C0260.m_56242a84(), C0290.f_99d080af, C0260.m_9e27f038());
   }

   @Override
   public void onDisable() {
      this.f_adcdd707.clear();
      this.f_8a629856 = null;
      this.f_c84b8dd2 = false;
      this.f_e2b32634 = null;
   }

   @EventHandler
   private void m_270a7d18(EventWorldLoad var1) {
      this.onDisable();
   }

   @Override
   public String getDisplayMode() {
      return String.valueOf(this.f_adcdd707.size());
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      if (this.f_8a629856 == null && (double)this.f_b7c043dd + this.f_c94c4434 < (double)System.currentTimeMillis()) {
         this.f_adcdd707.entrySet().removeIf(var0 -> var0.getValue().m_efa7610e());
         if (this.f_01f815f8) {
            BlockSwingResult var3 = Minecraft.getMinecraftGame().getHitBlock();
            if (var3 != null && var3.getBlock() instanceof StorageBlock && !this.f_adcdd707.containsKey(var3.getBlockPosition().asLong())) {
               this.m_996786ee(var3.getBlockPosition(), var3);
            }
         } else {
            Optional var6 = ClientWorld.getClientWorld()
               .getLoadedTileEntities()
               .filter(var0 -> var0 instanceof ChestEntity || var0 instanceof BarrelEntity || var0 instanceof ShulkerEntity)
               .filter(var1x -> (double)var1x.distanceTo(var2) <= 4.5)
               .filter(var1x -> !this.f_adcdd707.containsKey(var1x.getBlockPosition().asLong()))
               .findFirst();
            if (var6.isPresent()) {
               BlockPosition var4 = ((TileEntity)var6.get()).getBlockPosition();
               BlockSwingResult var5 = new BlockSwingResult(new Vector3d(var4), EnumFacing.NORTH, var4, false);
               this.m_996786ee(var4, var5);
            }
         }
      } else if (this.f_8a629856 != null && this.f_e2b32634 != null) {
         System.out.println(C0260.m_af41331f());
         this.f_8a629856.m_b157145d(this.f_e2b32634.getContainerInventory());
         if (this.f_c84b8dd2 && (double)this.f_67c5cd44 + this.f_55dd9c4f < (double)System.currentTimeMillis()) {
            var2.closeHandledScreen();
         }
      }
   }

   private void m_996786ee(BlockPosition var1, BlockSwingResult var2) {
      this.f_b7c043dd = System.currentTimeMillis();
      this.f_8a629856 = new C0351.anonymousconst(var1);
      this.f_c84b8dd2 = true;
      this.f_adcdd707.putIfAbsent(var1.asLong(), this.f_8a629856);
      new CPacketPlayerUseBlock(var2).sendPacket();
   }

   @EventHandler
   public void m_3d02ae86(EventGuiContainerClose var1) {
      this.f_8a629856 = null;
      this.f_c84b8dd2 = false;
      this.f_e2b32634 = null;
   }

   @EventHandler
   private void m_65c92cfe(EventScreen var1) {
      MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
      if (var1.getScreen() instanceof ContainerScreen && var2 != null) {
         this.f_e2b32634 = (ContainerScreen)var1.getScreen();
         if (var1.getType() == Type.Setup && !this.f_e2b32634.isPlayerInventory()) {
            this.f_67c5cd44 = System.currentTimeMillis();
            if (this.f_8a629856 == null) {
               BlockSwingResult var3 = Minecraft.getMinecraftGame().getHitBlock();
               if (var3 != null && var3.getBlock() instanceof StorageBlock) {
                  BlockPosition var4 = var3.getBlockPosition();
                  long var5 = var4.asLong();
                  if (!this.f_adcdd707.containsKey(var5)) {
                     this.f_adcdd707.put(var5, this.f_8a629856 = new C0351.anonymousconst(var4));
                  } else {
                     this.f_8a629856 = this.f_adcdd707.get(var5);
                  }
               }
            }

            if (this.f_8a629856 != null && this.f_c84b8dd2) {
               Minecraft.getMinecraftGame().openScreen(null);
            }
         }
      }
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      Entity var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getCameraEntity());
      BlockSwingResult var3 = Minecraft.getMinecraftGame().getHitBlock();

      for (C0351.anonymousconst var5 : this.f_adcdd707.values()) {
         if (var5.m_97a0a4cb(var2)
            && (!this.f_01f815f8 || var3 != null && var3.getBlockPosition().equals(var5.m_c5f6973a()))
            && (this.f_a079cd49 || !var5.m_e991ec61().isEmpty())) {
            var5.m_b3f462a2(var2);
         }
      }
   }

   public Map<Long, C0351.anonymousconst> m_ca0e7b66() {
      return this.f_adcdd707;
   }

   private class anonymousconst {
      private long f_9380c1b8;
      private BlockPosition f_1aeacb97;
      private final BoundingBox f_c1e2ddf2;
      private final List<ItemStack> f_7797aa95 = new ArrayList<>();

      public anonymousconst(BlockPosition var2) {
         this.f_1aeacb97 = var2;
         Block var3 = ClientWorld.getClientWorld()._getBlockFromPosition(var2);
         if (var3 instanceof StorageBlock) {
            this.f_c1e2ddf2 = ((StorageBlock)var3).getBoundingBox(var3.getLocationBlockState());
         } else {
            this.f_c1e2ddf2 = var2.getBoundingBox();
         }
      }

      public void m_b157145d(Inventory var1) {
         this.f_9380c1b8 = System.currentTimeMillis();
         this.f_7797aa95.clear();

         for (int var2 = 0; var2 < var1.getSize(); var2++) {
            ItemStack var3 = var1.getStackInSlot(var2);
            if (!var3.isEmpty()) {
               this.f_7797aa95.add(var3);
            }
         }
      }

      public boolean m_efa7610e() {
         return (double)this.f_9380c1b8 + (double)C0351.this.f_ea6c94da * 1000.0 < (double)System.currentTimeMillis();
      }

      public boolean m_97a0a4cb(Entity var1) {
         return (double)this.f_1aeacb97.distanceTo(var1.getBlockPosition()) <= C0351.this.f_b8fb63b6;
      }

      public void m_b3f462a2(Entity var1) {
         double var2 = this.f_c1e2ddf2.getCenter().getX() - Minecraft.getMinecraftGame().getCamera()._getRenderPosX();
         double var4 = this.f_1aeacb97.getY() + 1.5 - Minecraft.getMinecraftGame().getCamera()._getRenderPosY();
         double var6 = this.f_c1e2ddf2.getCenter().getZ() - Minecraft.getMinecraftGame().getCamera()._getRenderPosZ();
         float var8 = this.f_1aeacb97.distanceTo(var1.getBlockPosition());
         C0351.this.f_885cf207.f_06392c14.addAll(this.f_7797aa95);
         C0351.this.f_885cf207
            .m_f1e14be8(
               var2,
               var4,
               var6,
               var8,
               Message.of(String.format(C0260.m_df6e621c(), this.f_7797aa95.size())).style(Appearance.of(DefaultColors.WHITE)),
               var1,
               null,
               0
            );
      }

      public long m_9d4d8e71() {
         return this.f_9380c1b8;
      }

      public BlockPosition m_c5f6973a() {
         return this.f_1aeacb97;
      }

      public BoundingBox m_8da8fd66() {
         return this.f_c1e2ddf2;
      }

      public List<ItemStack> m_e991ec61() {
         return this.f_7797aa95;
      }
   }
}
