package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.block.BarrelEntity;
import me.deftware.client.framework.entity.block.ChestEntity;
import me.deftware.client.framework.entity.block.ShulkerEntity;
import me.deftware.client.framework.entity.block.StorageEntity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.OwnedEntity;
import me.deftware.client.framework.entity.types.animals.WaterEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.ItemEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventNametagRender;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.util.types.Pair;

public class C0292 extends AbstractMod {
   @C0098(
      value = "Chests",
      description = {"Draws a nametag above chests with the distance to them"}
   )
   private boolean f_e4b3c931 = false;
   @C0098(
      value = "Inventory",
      description = {"Show the held inventory of players"}
   )
   private boolean f_512a5d8e = true;
   @C0098(
      value = "Dropped",
      description = {"Show dropped items"}
   )
   private boolean f_bac5bcbd = false;
   @C0098(
      value = "Entities",
      description = {"Show entities"}
   )
   public boolean f_4719d731 = false;
   @C0098(
      value = "Players",
      description = {"Show players"}
   )
   private boolean f_a9693efc = true;
   @C0098(
      value = "Enchants",
      description = {"Show enchants"}
   )
   private boolean f_4c5ad13b = true;
   @C0098(
      value = "Pet owners",
      description = {"Show usernames of pet owners"}
   )
   private boolean f_d1f1849a = false;
   @C0098(
      value = "Max range",
      description = {"Max render distance"},
      number = @C0096(
         min = 5.0,
         max = 120.0
      )
   )
   private int f_20cd686e = 80;
   @C0098(
      value = "Percentage",
      description = {"Show health percentage instead of exact"}
   )
   private boolean f_c7928cf3 = false;
   @C0098(
      value = "Size",
      description = {"The nametag size"},
      number = @C0096(
         max = 2.0
      )
   )
   private float f_b19b7309 = 1.0F;
   @C0098(
      value = "Starting height",
      description = {"The height at which to begin rendering enchants"},
      number = @C0096(
         min = -10.0,
         max = 10.0
      )
   )
   private float f_5f556e88 = -5.0F;
   @C0098(
      value = "Enchant scale",
      description = {"The scale at which enchants are rendered in"},
      number = @C0096(
         min = 0.2800000011920929,
         max = 2.0
      )
   )
   private float f_9618c819 = 0.28F;
   private final C0294 f_ac9daadf = new C0294();
   private final double f_e43d97d4 = 17.0;
   private final double f_11efda62 = 10.0;
   public final List<ItemStack> f_1e328b96 = new ArrayList<>();
   private final QuadRenderStack f_dd27b9c1 = new QuadRenderStack();

   public C0292() {
      super(C0252.bootstrap<"get",38654705792>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",38654705793>());
   }

   @Override
   public void onPostLoad() {
      this.f_ac9daadf.m_2b39d85d(this.f_9618c819);
      this.f_ac9daadf.m_85d8cf80(this.f_5f556e88);
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      this.onPostLoad();
   }

   @EventHandler
   public void m_24020a2d(EventRender3D var1) {
      Entity var2 = C0114.bootstrap<"call",0,1>()._getCameraEntity();
      if (C0114.bootstrap<"call",1,1>() != null && var2 != null) {
         MainEntityPlayer var3 = (MainEntityPlayer)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",0,1>()._getPlayer());
         C0351 var4 = (C0351)C0114.bootstrap<"call",3,1>(C0351.class);
         if (this.f_e4b3c931) {
            C0114.bootstrap<"call",1,1>()
               .getLoadedTileEntities()
               .filter(var2x -> var2x.distanceTo(var2) <= (float)this.f_20cd686e)
               .filter(var0 -> var0 instanceof StorageEntity)
               .filter(var0 -> var0 instanceof ChestEntity || var0 instanceof BarrelEntity || var0 instanceof ShulkerEntity)
               .filter(var1x -> !var4.isEnabled() || !var4.m_bb663d14().containsKey(C0114.bootstrap<"call",19,1>(var1x.getBlockPosition().asLong())))
               .forEach(var2x -> this.m_0fef422d((StorageEntity)var2x, var2));
         }

         C0114.bootstrap<"call",1,1>()
            .getLoadedEntities()
            .filter(var2x -> var2x.distanceToEntity(var2) <= (float)this.f_20cd686e)
            .filter(var0 -> !(var0 instanceof WaterEntity))
            .filter(var0 -> C0114.bootstrap<"call",8,1>() ? !C0114.bootstrap<"call",9,1>(var0) : !var0.isSelf())
            .filter(var1x -> !var3.isRiding() || var3.getVehicle().getEntityId() != var1x.getEntityId())
            .filter(var1x -> {
               if (var1x instanceof EntityPlayer && this.f_a9693efc) {
                  return true;
               } else {
                  return var1x instanceof ItemEntity && this.f_bac5bcbd ? true : var1x instanceof LivingEntity && this.f_4719d731;
               }
            })
            .forEach(var3x -> this.m_38927d23(var3x, var1, var2));
      }
   }

   @EventHandler
   public void m_59ba3af7(EventNametagRender var1) {
      boolean var2 = var1.getEntity() instanceof EntityPlayer;
      var1.setCanceled(var2 && this.f_a9693efc || !var2 && this.f_4719d731);
   }

   public static FormattingColor m_617760ac(StorageEntity var0) {
      return var0 instanceof ChestEntity && ((ChestEntity)var0).isTrapped()
         ? DefaultColors.RED
         : (
            var0 instanceof ChestEntity && ((ChestEntity)var0).isEnderChest()
               ? DefaultColors.BLUE
               : (var0 instanceof ChestEntity ? DefaultColors.YELLOW : (var0 instanceof BarrelEntity ? DefaultColors.GRAY : DefaultColors.LIGHT_PURPLE))
         );
   }

   public void m_6ab167dd(BlockPosition var1, Entity var2, Message var3) {
      float var4 = var1.distanceTo(var2.getBlockPosition());
      this.m_60b3b482(
         var1.getX() - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosX() + 0.5,
         var1.getY() + 1.0 + 1.5 - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosY(),
         var1.getZ() - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosZ() + 0.5,
         var4,
         var3,
         var2,
         null,
         0
      );
   }

   public void m_79c7e6e7(C0244 var1, Entity var2) {
      BlockPosition var3 = var1.m_a2e39655();
      float var4 = var3.distanceTo(var2.getBlockPosition());
      Builder var5 = new Builder()
         .append(var1.m_efbf7bb8())
         .append(
            C0114.bootstrap<"call",5,1>(C0252.bootstrap<"get",42949672960>(), new Object[]{C0114.bootstrap<"call",4,1>(var4)}),
            C0114.bootstrap<"call",6,1>(DefaultColors.WHITE)
         );
      this.m_60b3b482(
         var1.m_a2e39655().getX() - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosX() + 0.5,
         var1.m_a2e39655().getY() + 1.5 - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosY(),
         var1.m_a2e39655().getZ() - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosZ() + 0.5,
         var4,
         var5.build(),
         var2,
         null,
         var1.m_d8367831()
      );
   }

   public void m_0fef422d(StorageEntity var1, Entity var2) {
      float var3 = var1.distanceTo(var2);
      String var4 = var1.getClassName();
      if (var1 instanceof ChestEntity) {
         if (((ChestEntity)var1).isTrapped()) {
            var4 = C0252.bootstrap<"get",42949672961>() + var4;
         } else if (((ChestEntity)var1).isEnderChest()) {
            var4 = C0252.bootstrap<"get",42949672962>() + var4;
         }

         if (((ChestEntity)var1).isDouble()) {
            var4 = C0252.bootstrap<"get",42949672963>() + var4;
         }
      }

      Builder var5 = new Builder()
         .append(var4, C0114.bootstrap<"call",6,1>(C0114.bootstrap<"call",7,1>(var1)))
         .append(
            C0114.bootstrap<"call",5,1>(C0252.bootstrap<"get",42949672960>(), new Object[]{C0114.bootstrap<"call",4,1>(var3)}),
            C0114.bootstrap<"call",6,1>(DefaultColors.WHITE)
         );
      this.m_60b3b482(
         var1.getBoundingBox().getCenter().getX() - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosX(),
         var1.getBlockPosition().getY() + 1.5 - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosY(),
         var1.getBoundingBox().getCenter().getZ() - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosZ(),
         var3,
         var5.build(),
         var2,
         null,
         0
      );
   }

   public void m_38927d23(Entity var1, EventRender3D var2, Entity var3) {
      double var4 = var1.getLastTickPosX()
         + (var1.getPosX() - var1.getLastTickPosX()) * (double)var2.getPartialTicks()
         - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosX();
      double var6 = var1.getLastTickPosY()
         + (var1.getPosY() - var1.getLastTickPosY()) * (double)var2.getPartialTicks()
         - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosY()
         + (double)var1.getHeight()
         + 0.5;
      double var8 = var1.getLastTickPosZ()
         + (var1.getPosZ() - var1.getLastTickPosZ()) * (double)var2.getPartialTicks()
         - C0114.bootstrap<"call",0,1>().getCamera()._getRenderPosZ();
      Builder var10 = new Builder();
      if (var1 instanceof EntityPlayer) {
         var10.append(
            C0114.bootstrap<"call",5,1>(
               C0252.bootstrap<"get",42949672964>(),
               new Object[]{((EntityPlayer)var1).isCreative() ? C0252.bootstrap<"get",42949672965>() : C0252.bootstrap<"get",17179869308>()}
            ),
            C0114.bootstrap<"call",6,1>(DefaultColors.WHITE)
         );
      }

      var10.append(var1.getName(), C0114.bootstrap<"call",6,1>(DefaultColors.WHITE));
      if (var1 instanceof LivingEntity) {
         float var11 = ((LivingEntity)var1).getHealth();
         float var12 = ((LivingEntity)var1).getHealthPercentage();
         DefaultColors var13 = var12 > 75.0F
            ? DefaultColors.GREEN
            : (var12 > 50.0F ? DefaultColors.GOLD : (var12 > 25.0F ? DefaultColors.YELLOW : DefaultColors.RED));
         var10.append(
            C0114.bootstrap<"call",5,1>(
               C0252.bootstrap<"get",42949672966>(),
               new Object[]{C0114.bootstrap<"call",4,1>(this.f_c7928cf3 ? var12 : var11), this.f_c7928cf3 ? C0252.bootstrap<"get",30064771112>() : ""}
            ),
            C0114.bootstrap<"call",6,1>(var13)
         );
         if (this.f_d1f1849a && var1 instanceof OwnedEntity) {
         }
      }

      if (this.f_512a5d8e) {
         this.f_1e328b96.add(var1.getEntityHeldItem(false));
         this.f_1e328b96.add(var1.getEntityHeldItem(true));
         this.f_1e328b96.addAll(var1.getArmourInventory());
         this.f_1e328b96.removeIf(ItemStack::isEmpty);
         C0114.bootstrap<"call",8,1>(this.f_1e328b96);
      }

      if (this.f_4c5ad13b) {
         this.m_189376ca(var4, var6, var8, var3.distanceToEntity(var1), var10.build(), var3, var1, 0);
      } else {
         this.m_60b3b482(var4, var6, var8, var3.distanceToEntity(var1), var10.build(), var3, var1, 0);
      }
   }

   public void m_189376ca(double var1, double var3, double var5, float var7, Message var8, Entity var9, Entity var10, int var11) {
      int var12 = C0114.bootstrap<"call",9,1>(this.f_9618c819 * 57.0F - 16.0F);
      double var13 = -1.5;
      double var15 = (double)C0114.bootstrap<"call",10,1>(var8) / 2.0;
      double var17 = 0.0;
      if (!this.f_1e328b96.isEmpty()) {
         int var19 = 0;
         byte var20 = 0;
         int var21 = -1;

         for (ItemStack var23 : this.f_1e328b96) {
            if ((double)(++var21) % 10.0 == 0.0) {
               if (var20 > var19) {
                  var19 = var20;
               }

               var20 = 0;
            }

            if (var23.getEnchantments().size() != 0) {
               var19++;
            }
         }

         var17 = (
               (((double)this.f_1e328b96.size() > 10.0 ? 10.0 : (double)this.f_1e328b96.size()) - (double)var19) * 17.0
                  + (double)var19 * (17.0 + (double)var12)
            )
            / 2.0;
         var13 = -20.0;
         if ((double)this.f_1e328b96.size() > 10.0) {
            int var25 = this.f_1e328b96.size();

            while (var25 > 9) {
               var25 /= 10;
            }

            if (var25 * 10 != this.f_1e328b96.size() || var25 == 1) {
               var25++;
            }

            var13 *= (double)var25;
         }

         if (var15 < var17) {
            var15 = var17;
         }
      }

      float var24 = -(this.f_b19b7309 / 100.0F) * (var7 / 2.5F <= 1.5F ? 2.0F : var7 / 2.5F);
      GLX.INSTANCE.push();
      C0114.bootstrap<"call",11,1>();
      C0114.bootstrap<"call",12,1>();
      C0114.bootstrap<"call",13,1>(770, 771, 1, 0);
      GLX.INSTANCE.translate(var1, var3, var5);
      GLX.INSTANCE.scale(var24, var24, var24);
      GLX.INSTANCE.rotate(-C0114.bootstrap<"call",0,1>().getCamera()._getRotationYaw(), 0.0F, 1.0F, 0.0F);
      GLX.INSTANCE.rotate(C0114.bootstrap<"call",0,1>().getCamera()._getRotationPitch(), 1.0F, 0.0F, 0.0F);
      this.m_6df4f000(var15, var13);
      this.m_51d1a4d1(var15, var13);
      C0114.bootstrap<"call",14,1>();
      if (!this.f_1e328b96.isEmpty()) {
         this.m_af371edc(this.f_1e328b96, var12, (int)var17);
      }

      this.f_1e328b96.clear();
      C0114.bootstrap<"call",15,1>(0.0F);
      C0114.bootstrap<"call",16,1>(var8, -(C0114.bootstrap<"call",10,1>(var8) / 2), 0, var11);
      GLX.INSTANCE.pop();
   }

   public void m_60b3b482(double var1, double var3, double var5, float var7, Message var8, Entity var9, Entity var10, int var11) {
      double var12 = -1.5;
      double var14 = (double)C0114.bootstrap<"call",0,1>(var8) / 2.0;
      double var16 = 0.0;
      if (!this.f_1e328b96.isEmpty()) {
         var16 = ((double)this.f_1e328b96.size() > 10.0 ? 10.0 : (double)this.f_1e328b96.size()) * 17.0 / 2.0;
         var12 = -20.0;
         if ((double)this.f_1e328b96.size() > 10.0) {
            int var18 = this.f_1e328b96.size();

            while (var18 > 9) {
               var18 /= 10;
            }

            if (var18 * 10 != this.f_1e328b96.size() || var18 == 1) {
               var18++;
            }

            var12 *= (double)var18;
         }

         if (var14 < var16) {
            var14 = var16;
         }
      }

      float var20 = -(this.f_b19b7309 / 100.0F) * (var7 / 2.5F <= 1.5F ? 2.0F : var7 / 2.5F);
      GLX.INSTANCE.push();
      C0114.bootstrap<"call",1,1>();
      C0114.bootstrap<"call",2,1>();
      C0114.bootstrap<"call",3,1>(770, 771, 1, 0);
      GLX.INSTANCE.translate(var1, var3, var5);
      GLX.INSTANCE.scale(var20, var20, var20);
      GLX.INSTANCE.rotate(-C0114.bootstrap<"call",4,1>().getCamera()._getRotationYaw(), 0.0F, 1.0F, 0.0F);
      GLX.INSTANCE.rotate(C0114.bootstrap<"call",4,1>().getCamera()._getRotationPitch(), 1.0F, 0.0F, 0.0F);
      this.m_6df4f000(var14, var12);
      this.m_51d1a4d1(var14, var12);
      C0114.bootstrap<"call",5,1>();
      if (!this.f_1e328b96.isEmpty()) {
         this.m_34bb5068(this.f_1e328b96);
      }

      this.f_1e328b96.clear();
      C0114.bootstrap<"call",6,1>(0.0F);
      C0114.bootstrap<"call",7,1>(var8, -(C0114.bootstrap<"call",0,1>(var8) / 2), 0, var11);
      GLX.INSTANCE.pop();
   }

   private void m_af371edc(List<ItemStack> var1, int var2, int var3) {
      double var4 = -1.0;
      double var6 = -1.0;
      double var8 = (double)(-var3);
      int var10 = 0;

      for (ItemStack var12 : var1) {
         if (++var6 % 10.0 == 0.0) {
            var8 = (double)(-var3);
            var4 -= 17.0;
         }

         boolean var13 = var12.getEnchantments().size() != 0;
         if (var13 && var10 > 0) {
            var8 += (double)var10;
         } else {
            var10 = (int)((double)var10 - 17.0);
         }

         this.f_ac9daadf.m_b84e05f2((int)var8, (int)var4, var12, new Pair(C0114.bootstrap<"call",17,1>(true), C0114.bootstrap<"call",17,1>(false)));
         var8 += 17.0;
         if (var13) {
            var10 = var2;
         }
      }
   }

   private void m_34bb5068(List<ItemStack> var1) {
      double var2 = -18.0;
      double var4 = 0.0;
      double var6 = 0.0;
      double var8 = -(((double)var1.size() > 10.0 ? 10.0 : (double)var1.size()) * 17.0 / 2.0);

      for (ItemStack var11 : var1) {
         if (var4 == 10.0) {
            var4 = 0.0;
            double var12 = C0114.bootstrap<"call",18,1>((double)var1.size() - var6, 10.0);
            var8 = -(var12 * 17.0 / 2.0);
            var2 -= 17.0;
         }

         this.f_ac9daadf.m_077c1e62((int)var8, (int)var2, var11, (BiConsumer<ItemStack, Integer>)null);
         var8 += 17.0;
         var4++;
         var6++;
      }
   }

   private void m_6df4f000(double var1, double var3) {
      this.f_dd27b9c1.begin(3);
      this.f_dd27b9c1.glColor(Color.black);
      this.f_dd27b9c1.vertex(-var1 - 2.0, var3, -0.6).next();
      this.f_dd27b9c1.vertex(-var1 - 2.0, 8.8, -0.6).next();
      this.f_dd27b9c1.vertex(-var1 - 2.0, 8.8, -0.6).next();
      this.f_dd27b9c1.vertex(var1 + 2.0, 8.8, -0.6).next();
      this.f_dd27b9c1.vertex(var1 + 2.0, 8.8, -0.6).next();
      this.f_dd27b9c1.vertex(var1 + 2.0, var3, -0.6).next();
      this.f_dd27b9c1.vertex(var1 + 2.0, var3, -0.6).next();
      this.f_dd27b9c1.vertex(-var1 - 2.0, var3, -0.6).next();
      this.f_dd27b9c1.end();
   }

   private void m_51d1a4d1(double var1, double var3) {
      this.f_dd27b9c1.begin();
      this.f_dd27b9c1.glColor(Color.black, 63.75F);
      this.f_dd27b9c1.vertex(-var1 - 2.0, var3, -0.6).next();
      this.f_dd27b9c1.vertex(-var1 - 2.0, 8.8, -0.6).next();
      this.f_dd27b9c1.vertex(var1 + 2.0, 8.8, -0.6).next();
      this.f_dd27b9c1.vertex(var1 + 2.0, var3, -0.6).next();
      this.f_dd27b9c1.end();
   }
}
