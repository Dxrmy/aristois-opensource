package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.helper.GlStateHelper;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.camera.entity.CameraEntityMan;
import me.deftware.client.framework.render.gl.GLX;
import me.deftware.client.framework.util.types.Pair;
import me.deftware.client.framework.world.ClientWorld;

public class C0292 extends AbstractMod {
   @C0098(
      value = "Chests",
      description = {"Draws a nametag above chests with the distance to them"}
   )
   private boolean f_2a74b365 = false;
   @C0098(
      value = "Inventory",
      description = {"Show the held inventory of players"}
   )
   private boolean f_91d384f3 = true;
   @C0098(
      value = "Dropped",
      description = {"Show dropped items"}
   )
   private boolean f_d902c258 = false;
   @C0098(
      value = "Entities",
      description = {"Show entities"}
   )
   public boolean f_de4af376 = false;
   @C0098(
      value = "Players",
      description = {"Show players"}
   )
   private boolean f_89b3f8d0 = true;
   @C0098(
      value = "Enchants",
      description = {"Show enchants"}
   )
   private boolean f_705739e7 = true;
   @C0098(
      value = "Pet owners",
      description = {"Show usernames of pet owners"}
   )
   private boolean f_0a34b36f = false;
   @C0098(
      value = "Max range",
      description = {"Max render distance"},
      number = @C0096(
         min = 5.0,
         max = 120.0
      )
   )
   private int f_e84861e1 = 80;
   @C0098(
      value = "Percentage",
      description = {"Show health percentage instead of exact"}
   )
   private boolean f_48dfc2da = false;
   @C0098(
      value = "Size",
      description = {"The nametag size"},
      number = @C0096(
         max = 2.0
      )
   )
   private float f_2571daaa = 1.0F;
   @C0098(
      value = "Starting height",
      description = {"The height at which to begin rendering enchants"},
      number = @C0096(
         min = -10.0,
         max = 10.0
      )
   )
   private float f_5fc2de5b = -5.0F;
   @C0098(
      value = "Enchant scale",
      description = {"The scale at which enchants are rendered in"},
      number = @C0096(
         min = 0.2800000011920929,
         max = 2.0
      )
   )
   private float f_bb799b6e = 0.28F;
   private final C0294 f_750bf74a = new C0294();
   private final double f_56fab826 = 17.0;
   private final double f_aefd4545 = 10.0;
   public final List<ItemStack> f_06392c14 = new ArrayList<>();
   private final QuadRenderStack f_9cd7e0e4 = new QuadRenderStack();

   public C0292() {
      super(C0263.m_65d43991(), C0290.f_3210deb7, C0263.m_c6614274());
   }

   @Override
   public void onPostLoad() {
      this.f_750bf74a.m_d881d3e3(this.f_bb799b6e);
      this.f_750bf74a.m_35bea3d9(this.f_5fc2de5b);
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      this.onPostLoad();
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      Entity var2 = Minecraft.getMinecraftGame()._getCameraEntity();
      if (ClientWorld.getClientWorld() != null && var2 != null) {
         MainEntityPlayer var3 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
         C0351 var4 = C0289.m_c3a8b502(C0351.class);
         if (this.f_2a74b365) {
            ClientWorld.getClientWorld()
               .getLoadedTileEntities()
               .filter(var2x -> var2x.distanceTo(var2) <= (float)this.f_e84861e1)
               .filter(var0 -> var0 instanceof StorageEntity)
               .filter(var0 -> var0 instanceof ChestEntity || var0 instanceof BarrelEntity || var0 instanceof ShulkerEntity)
               .filter(var1x -> !var4.isEnabled() || !var4.m_ca0e7b66().containsKey(var1x.getBlockPosition().asLong()))
               .forEach(var2x -> this.m_ab05c854((StorageEntity)var2x, var2));
         }

         ClientWorld.getClientWorld()
            .getLoadedEntities()
            .filter(var2x -> var2x.distanceToEntity(var2) <= (float)this.f_e84861e1)
            .filter(var0 -> !(var0 instanceof WaterEntity))
            .filter(var0 -> CameraEntityMan.isActive() ? !CameraEntityMan.isCameraEntity(var0) : !var0.isSelf())
            .filter(var1x -> !var3.isRiding() || var3.getVehicle().getEntityId() != var1x.getEntityId())
            .filter(var1x -> {
               if (var1x instanceof EntityPlayer && this.f_89b3f8d0) {
                  return true;
               } else {
                  return var1x instanceof ItemEntity && this.f_d902c258 ? true : var1x instanceof LivingEntity && this.f_de4af376;
               }
            })
            .forEach(var3x -> this.m_9792de99(var3x, var1, var2));
      }
   }

   @EventHandler
   public void m_5f87f201(EventNametagRender var1) {
      boolean var2 = var1.getEntity() instanceof EntityPlayer;
      var1.setCanceled(var2 && this.f_89b3f8d0 || !var2 && this.f_de4af376);
   }

   public static FormattingColor m_c2d0f13d(StorageEntity var0) {
      return var0 instanceof ChestEntity && ((ChestEntity)var0).isTrapped()
         ? DefaultColors.RED
         : (
            var0 instanceof ChestEntity && ((ChestEntity)var0).isEnderChest()
               ? DefaultColors.BLUE
               : (var0 instanceof ChestEntity ? DefaultColors.YELLOW : (var0 instanceof BarrelEntity ? DefaultColors.GRAY : DefaultColors.LIGHT_PURPLE))
         );
   }

   public void m_5e10679a(BlockPosition var1, Entity var2, Message var3) {
      float var4 = var1.distanceTo(var2.getBlockPosition());
      this.m_f1e14be8(
         var1.getX() - Minecraft.getMinecraftGame().getCamera()._getRenderPosX() + 0.5,
         var1.getY() + 1.0 + 1.5 - Minecraft.getMinecraftGame().getCamera()._getRenderPosY(),
         var1.getZ() - Minecraft.getMinecraftGame().getCamera()._getRenderPosZ() + 0.5,
         var4,
         var3,
         var2,
         null,
         0
      );
   }

   public void m_26b1e5f1(C0244 var1, Entity var2) {
      BlockPosition var3 = var1.m_e8f7735c();
      float var4 = var3.distanceTo(var2.getBlockPosition());
      Builder var5 = new Builder().append(var1.m_c688f8ca()).append(String.format(C0259.m_44418b5d(), var4), Appearance.of(DefaultColors.WHITE));
      this.m_f1e14be8(
         var1.m_e8f7735c().getX() - Minecraft.getMinecraftGame().getCamera()._getRenderPosX() + 0.5,
         var1.m_e8f7735c().getY() + 1.5 - Minecraft.getMinecraftGame().getCamera()._getRenderPosY(),
         var1.m_e8f7735c().getZ() - Minecraft.getMinecraftGame().getCamera()._getRenderPosZ() + 0.5,
         var4,
         var5.build(),
         var2,
         null,
         var1.m_8b15b5f4()
      );
   }

   public void m_ab05c854(StorageEntity var1, Entity var2) {
      float var3 = var1.distanceTo(var2);
      String var4 = var1.getClassName();
      if (var1 instanceof ChestEntity) {
         if (((ChestEntity)var1).isTrapped()) {
            var4 = C0259.m_813e3509() + var4;
         } else if (((ChestEntity)var1).isEnderChest()) {
            var4 = C0259.m_3855be80() + var4;
         }

         if (((ChestEntity)var1).isDouble()) {
            var4 = C0259.m_a9247108() + var4;
         }
      }

      Builder var5 = new Builder()
         .append(var4, Appearance.of(m_c2d0f13d(var1)))
         .append(String.format(C0259.m_44418b5d(), var3), Appearance.of(DefaultColors.WHITE));
      this.m_f1e14be8(
         var1.getBoundingBox().getCenter().getX() - Minecraft.getMinecraftGame().getCamera()._getRenderPosX(),
         var1.getBlockPosition().getY() + 1.5 - Minecraft.getMinecraftGame().getCamera()._getRenderPosY(),
         var1.getBoundingBox().getCenter().getZ() - Minecraft.getMinecraftGame().getCamera()._getRenderPosZ(),
         var3,
         var5.build(),
         var2,
         null,
         0
      );
   }

   public void m_9792de99(Entity var1, EventRender3D var2, Entity var3) {
      double var4 = var1.getLastTickPosX()
         + (var1.getPosX() - var1.getLastTickPosX()) * (double)var2.getPartialTicks()
         - Minecraft.getMinecraftGame().getCamera()._getRenderPosX();
      double var6 = var1.getLastTickPosY()
         + (var1.getPosY() - var1.getLastTickPosY()) * (double)var2.getPartialTicks()
         - Minecraft.getMinecraftGame().getCamera()._getRenderPosY()
         + (double)var1.getHeight()
         + 0.5;
      double var8 = var1.getLastTickPosZ()
         + (var1.getPosZ() - var1.getLastTickPosZ()) * (double)var2.getPartialTicks()
         - Minecraft.getMinecraftGame().getCamera()._getRenderPosZ();
      Builder var10 = new Builder();
      if (var1 instanceof EntityPlayer) {
         var10.append(
            String.format(C0259.m_4626ac74(), ((EntityPlayer)var1).isCreative() ? C0259.m_c688f8ca() : C0261.m_ec4ef19a()), Appearance.of(DefaultColors.WHITE)
         );
      }

      var10.append(var1.getName(), Appearance.of(DefaultColors.WHITE));
      if (var1 instanceof LivingEntity) {
         float var11 = ((LivingEntity)var1).getHealth();
         float var12 = ((LivingEntity)var1).getHealthPercentage();
         DefaultColors var13 = var12 > 75.0F
            ? DefaultColors.GREEN
            : (var12 > 50.0F ? DefaultColors.GOLD : (var12 > 25.0F ? DefaultColors.YELLOW : DefaultColors.RED));
         var10.append(String.format(C0259.m_35cdaa1a(), this.f_48dfc2da ? var12 : var11, this.f_48dfc2da ? C0265.m_c254a253() : ""), Appearance.of(var13));
         if (this.f_0a34b36f && var1 instanceof OwnedEntity) {
         }
      }

      if (this.f_91d384f3) {
         this.f_06392c14.add(var1.getEntityHeldItem(false));
         this.f_06392c14.add(var1.getEntityHeldItem(true));
         this.f_06392c14.addAll(var1.getArmourInventory());
         this.f_06392c14.removeIf(ItemStack::isEmpty);
         Collections.reverse(this.f_06392c14);
      }

      if (this.f_705739e7) {
         this.m_9d61cee5(var4, var6, var8, var3.distanceToEntity(var1), var10.build(), var3, var1, 0);
      } else {
         this.m_f1e14be8(var4, var6, var8, var3.distanceToEntity(var1), var10.build(), var3, var1, 0);
      }
   }

   public void m_9d61cee5(double var1, double var3, double var5, float var7, Message var8, Entity var9, Entity var10, int var11) {
      int var12 = Math.round(this.f_bb799b6e * 57.0F - 16.0F);
      double var13 = -1.5;
      double var15 = (double)FontRenderer.getStringWidth(var8) / 2.0;
      double var17 = 0.0;
      if (!this.f_06392c14.isEmpty()) {
         int var19 = 0;
         byte var20 = 0;
         int var21 = -1;

         for (ItemStack var23 : this.f_06392c14) {
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
               (((double)this.f_06392c14.size() > 10.0 ? 10.0 : (double)this.f_06392c14.size()) - (double)var19) * 17.0
                  + (double)var19 * (17.0 + (double)var12)
            )
            / 2.0;
         var13 = -20.0;
         if ((double)this.f_06392c14.size() > 10.0) {
            int var25 = this.f_06392c14.size();

            while (var25 > 9) {
               var25 /= 10;
            }

            if (var25 * 10 != this.f_06392c14.size() || var25 == 1) {
               var25++;
            }

            var13 *= (double)var25;
         }

         if (var15 < var17) {
            var15 = var17;
         }
      }

      float var24 = -(this.f_2571daaa / 100.0F) * (var7 / 2.5F <= 1.5F ? 2.0F : var7 / 2.5F);
      GLX.INSTANCE.push();
      GlStateHelper.enableBlend();
      GlStateHelper.disableTexture2D();
      GlStateHelper.tryBlendFuncSeparate(770, 771, 1, 0);
      GLX.INSTANCE.translate(var1, var3, var5);
      GLX.INSTANCE.scale(var24, var24, var24);
      GLX.INSTANCE.rotate(-Minecraft.getMinecraftGame().getCamera()._getRotationYaw(), 0.0F, 1.0F, 0.0F);
      GLX.INSTANCE.rotate(Minecraft.getMinecraftGame().getCamera()._getRotationPitch(), 1.0F, 0.0F, 0.0F);
      this.m_7b2b2bee(var15, var13);
      this.m_a172f6fe(var15, var13);
      GlStateHelper.enableTexture2D();
      if (!this.f_06392c14.isEmpty()) {
         this.m_9aa22aba(this.f_06392c14, var12, (int)var17);
      }

      this.f_06392c14.clear();
      ItemStack.setRenderZLevel(0.0F);
      FontRenderer.drawString(var8, -(FontRenderer.getStringWidth(var8) / 2), 0, var11);
      GLX.INSTANCE.pop();
   }

   public void m_f1e14be8(double var1, double var3, double var5, float var7, Message var8, Entity var9, Entity var10, int var11) {
      double var12 = -1.5;
      double var14 = (double)FontRenderer.getStringWidth(var8) / 2.0;
      double var16 = 0.0;
      if (!this.f_06392c14.isEmpty()) {
         var16 = ((double)this.f_06392c14.size() > 10.0 ? 10.0 : (double)this.f_06392c14.size()) * 17.0 / 2.0;
         var12 = -20.0;
         if ((double)this.f_06392c14.size() > 10.0) {
            int var18 = this.f_06392c14.size();

            while (var18 > 9) {
               var18 /= 10;
            }

            if (var18 * 10 != this.f_06392c14.size() || var18 == 1) {
               var18++;
            }

            var12 *= (double)var18;
         }

         if (var14 < var16) {
            var14 = var16;
         }
      }

      float var20 = -(this.f_2571daaa / 100.0F) * (var7 / 2.5F <= 1.5F ? 2.0F : var7 / 2.5F);
      GLX.INSTANCE.push();
      GlStateHelper.enableBlend();
      GlStateHelper.disableTexture2D();
      GlStateHelper.tryBlendFuncSeparate(770, 771, 1, 0);
      GLX.INSTANCE.translate(var1, var3, var5);
      GLX.INSTANCE.scale(var20, var20, var20);
      GLX.INSTANCE.rotate(-Minecraft.getMinecraftGame().getCamera()._getRotationYaw(), 0.0F, 1.0F, 0.0F);
      GLX.INSTANCE.rotate(Minecraft.getMinecraftGame().getCamera()._getRotationPitch(), 1.0F, 0.0F, 0.0F);
      this.m_7b2b2bee(var14, var12);
      this.m_a172f6fe(var14, var12);
      GlStateHelper.enableTexture2D();
      if (!this.f_06392c14.isEmpty()) {
         this.m_1793329a(this.f_06392c14);
      }

      this.f_06392c14.clear();
      ItemStack.setRenderZLevel(0.0F);
      FontRenderer.drawString(var8, -(FontRenderer.getStringWidth(var8) / 2), 0, var11);
      GLX.INSTANCE.pop();
   }

   private void m_9aa22aba(List<ItemStack> var1, int var2, int var3) {
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

         this.f_750bf74a.m_9e369680((int)var8, (int)var4, var12, new Pair(true, false));
         var8 += 17.0;
         if (var13) {
            var10 = var2;
         }
      }
   }

   private void m_1793329a(List<ItemStack> var1) {
      double var2 = -18.0;
      double var4 = 0.0;
      double var6 = 0.0;
      double var8 = -(((double)var1.size() > 10.0 ? 10.0 : (double)var1.size()) * 17.0 / 2.0);

      for (ItemStack var11 : var1) {
         if (var4 == 10.0) {
            var4 = 0.0;
            double var12 = Math.min((double)var1.size() - var6, 10.0);
            var8 = -(var12 * 17.0 / 2.0);
            var2 -= 17.0;
         }

         this.f_750bf74a.m_ad57b8bb((int)var8, (int)var2, var11, (BiConsumer<ItemStack, Integer>)null);
         var8 += 17.0;
         var4++;
         var6++;
      }
   }

   private void m_7b2b2bee(double var1, double var3) {
      this.f_9cd7e0e4.begin(3);
      this.f_9cd7e0e4.glColor(Color.black);
      this.f_9cd7e0e4.vertex(-var1 - 2.0, var3, -0.6).next();
      this.f_9cd7e0e4.vertex(-var1 - 2.0, 8.8, -0.6).next();
      this.f_9cd7e0e4.vertex(-var1 - 2.0, 8.8, -0.6).next();
      this.f_9cd7e0e4.vertex(var1 + 2.0, 8.8, -0.6).next();
      this.f_9cd7e0e4.vertex(var1 + 2.0, 8.8, -0.6).next();
      this.f_9cd7e0e4.vertex(var1 + 2.0, var3, -0.6).next();
      this.f_9cd7e0e4.vertex(var1 + 2.0, var3, -0.6).next();
      this.f_9cd7e0e4.vertex(-var1 - 2.0, var3, -0.6).next();
      this.f_9cd7e0e4.end();
   }

   private void m_a172f6fe(double var1, double var3) {
      this.f_9cd7e0e4.begin();
      this.f_9cd7e0e4.glColor(Color.black, 63.75F);
      this.f_9cd7e0e4.vertex(-var1 - 2.0, var3, -0.6).next();
      this.f_9cd7e0e4.vertex(-var1 - 2.0, 8.8, -0.6).next();
      this.f_9cd7e0e4.vertex(var1 + 2.0, 8.8, -0.6).next();
      this.f_9cd7e0e4.vertex(var1 + 2.0, var3, -0.6).next();
      this.f_9cd7e0e4.end();
   }
}
