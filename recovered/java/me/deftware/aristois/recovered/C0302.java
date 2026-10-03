package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.EndCrystalEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.item.types.ArmourItem;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.EnumFacing;

@C0421
public class C0302 extends C0307<C0302> {
   @C0098(
      value = "Max range",
      description = {"Max range you must be within from an aura to attack it"},
      number = @C0096(
         max = 6.0
      )
   )
   private float f_e70c48d6 = 4.0F;
   @C0098(
      value = "Attack Delay",
      description = {"Delay between attacking multiple end crystals, in milliseconds"},
      number = @C0096(
         min = 0.0,
         max = 5000.0
      )
   )
   private int f_5d017bec = 500;
   @C0098(
      value = "Place Delay",
      description = {"Delay between placing end crystals, in milliseconds"},
      number = @C0096(
         min = 0.0,
         max = 5000.0
      )
   )
   private int f_88aa3b14 = 300;
   @C0098(
      value = "Min health",
      description = {"Min health after explosion"},
      number = @C0096(
         min = 0.0,
         max = 20.0
      )
   )
   private float f_043c0ccd = 10.0F;
   @C0098(
      value = "Max crystals",
      description = {"Max amount of end crystals that can be placed"},
      number = @C0096(
         max = 10.0
      )
   )
   private int f_33c46dcf = 3;
   @C0098(
      value = "Place",
      description = {"Automatically place end crystals"}
   )
   private boolean f_160d1ca3 = true;
   @C0098(
      value = "Attack",
      description = {"Automatically attack placed end crystals"}
   )
   private boolean f_de9d4971 = true;
   @C0098(
      value = "Overlay",
      description = {"Show where it will place end crystals"}
   )
   private boolean f_d7c97be1 = true;
   @C0098(
      value = "Player Range",
      description = {"Player detection range"}
   )
   private float f_2d3da689 = 15.0F;
   private long f_1723e347 = System.currentTimeMillis();
   private final CubeRenderStack f_c4c4699a = new CubeRenderStack();
   private C0283<C0283.anonymousconst> f_d5a54a4f;

   public C0302() {
      super(C0263.m_023b99d9(), C0290.f_4b7b2d37, C0263.m_733bff3d());
   }

   @Override
   protected C0062 m_87bbe7cf() {
      return new C0059() {
         @Override
         public C0102<C0063> m_0098dd70() {
            return C0302.this.f_a15fb4a4;
         }

         @Override
         public Predicate<LivingEntity> m_c8fd13b8() {
            return C0302.this.m_c93f572c(super.m_c8fd13b8());
         }

         @Override
         public float m_796256b9() {
            return C0302.this.f_2d3da689;
         }
      };
   }

   @Override
   public void onEnable() {
      if (ClientWorld.getClientWorld() != null && Minecraft.getMinecraftGame()._getPlayer() != null) {
         this.f_d5a54a4f = new C0283<>(
            var1 -> {
               DoubleBlockPosition var2 = (DoubleBlockPosition)var1.m_82942af9().offset(0.5, 1.0, 0.5);
               return var1.m_268de4b2().equals(C0071.f_ab96dc62)
                     || var1.m_268de4b2().equals(C0071.f_95072491)
                        && Minecraft.getMinecraftGame()._getPlayer().getBlockPosition().distanceTo(var2) <= this.f_e70c48d6
                  ? ClientWorld.getClientWorld()._getBlockFromPosition(var2).isAir() && !m_1c39af64(var1.m_82942af9())
                  : false;
            },
            (int)this.f_e70c48d6
         );
         this.f_d5a54a4f.m_d0dcca5b();
      } else {
         this.toggle();
      }
   }

   @Override
   public void onDisable() {
      if (this.f_d5a54a4f != null) {
         this.f_d5a54a4f.m_49509d4b();
         this.f_d5a54a4f = null;
      }
   }

   private boolean m_4ab440d1(float var1, MainEntityPlayer var2) {
      Optional var3 = ClientWorld.getClientWorld()
         .getLoadedEntities()
         .filter(var0 -> var0 instanceof EntityPlayer)
         .filter(var0 -> !var0.isSelf())
         .filter(var2x -> var2x.distanceToEntity(var2) < var1)
         .findAny();
      return var3.isPresent();
   }

   private int m_94f128e6(float var1, MainEntityPlayer var2) {
      return (int)ClientWorld.getClientWorld()
         .getLoadedEntities()
         .filter(var2x -> var2.distanceToEntity(var2x) <= var1)
         .filter(var0 -> var0 instanceof EndCrystalEntity)
         .count();
   }

   private static boolean m_1c39af64(BlockPosition var0) {
      Optional var1 = ClientWorld.getClientWorld()
         .getLoadedEntities()
         .filter(var0x -> var0x instanceof EndCrystalEntity)
         .filter(
            var1x -> Math.floor(var1x.getPosX()) == var0.getX()
                  && Math.floor(var1x.getPosZ()) == var0.getZ()
                  && var1x.getPosY() > var0.getY()
                  && var1x.getPosY() < var0.getY() + 3.0
         )
         .findAny();
      return var1.isPresent();
   }

   private float m_bf61c67f(MainEntityPlayer var1, EndCrystalEntity var2) {
      if (var1.isCreative()) {
         return 0.0F;
      } else {
         double var3 = (double)var1.distanceToEntity(var2);
         float var5 = 0.0F;
         if (var3 < 12.0) {
            double var6 = (double)var2.getEntityDamage(var1);
            double var8 = (1.0 - var3 / 12.0) * var6;
            double var10 = (var8 * var8 + var8) / 2.0 * 7.0 * 12.0 + 1.0;
            var5 = var10 < 0.0 ? 0.0F : this.m_a88311e1(this.m_9036e749((float)var10));
         }

         return var5;
      }
   }

   private float m_da7a0468(MainEntityPlayer var1, BlockPosition var2) {
      if (var1.isCreative()) {
         return 0.0F;
      } else {
         double var3 = (double)var1.getBlockPosition().distanceTo(var2);
         float var5 = 0.0F;
         if (var3 < 12.0) {
            double var6 = (double)EndCrystalEntity.getExplosionExposure(var2, var1);
            double var8 = (1.0 - var3 / 12.0) * var6;
            double var10 = (var8 * var8 + var8) / 2.0 * 7.0 * 12.0 + 1.0;
            var5 = var10 < 0.0 ? 0.0F : this.m_a88311e1(this.m_9036e749((float)var10));
         }

         return var5;
      }
   }

   private float m_9036e749(float var1) {
      if (ClientWorld.getClientWorld()._getDifficulty() == 0) {
         return 0.0F;
      } else if (ClientWorld.getClientWorld()._getDifficulty() == 1) {
         return Math.min(var1 / 2.0F + 1.0F, var1);
      } else {
         return ClientWorld.getClientWorld()._getDifficulty() == 2 ? var1 * 3.0F / 2.0F : var1;
      }
   }

   private float m_a88311e1(float var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      float var3 = 0.0F;
      float var4 = 0.0F;
      float var5 = 0.0F;

      for (ItemStack var7 : var2.getArmourInventory()) {
         float var8 = 0.0F;
         if (var7.getItem() instanceof ArmourItem) {
            var5 += ((ArmourItem)var7.getItem()).getToughness();
            var8 = (float)((ArmourItem)var7.getItem()).getDamageReduceAmount();
         }

         var4 += (float)var7.getStackProtectionAmount() - var8;
         var3 += var8;
      }

      float var10 = 2.0F + var5 / 4.0F;
      float var11 = Math.min(Math.max(var3 * 0.2F, var3 - var1 / var10), 20.0F);
      var1 *= 1.0F - var11 / 25.0F;
      float var12 = Math.min(Math.max(0.0F, var4), 20.0F);
      return var1 * (1.0F - var12 / 25.0F);
   }

   private void m_637f813e(MainEntityPlayer var1, C0283.anonymousconst var2) {
      boolean var3 = true;
      int var4 = -1;
      if (!var1.getInventory().getHeldItem(false).getItem().equals(C0070.f_2752002b)) {
         int var5 = var1.getInventory().findItem(C0070.f_2752002b);
         if (var5 != -1 && var5 < 9) {
            var4 = var1.getInventory().getCurrentItem();
            var1.getInventory().setCurrentItem(var5);
         }

         var3 = var5 != -1 && var5 < 9;
      }

      if (var3 && var1.processRightClickBlock(var2.m_82942af9(), EnumFacing.UP, var2.m_82942af9().getVector())) {
         var1.swingArmClientSide();
      }

      if (var4 != -1) {
      }
   }

   @Override
   public void onPostLoad() {
      this.m_0e389a72();
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      boolean var3 = this.m_4ab440d1(this.f_2d3da689, var2);
      if (this.f_160d1ca3
         && var3
         && var2.getHealth() >= this.f_043c0ccd
         && this.f_d5a54a4f.m_8b15b5f4() > 0
         && this.f_1723e347 + (long)this.f_88aa3b14 < System.currentTimeMillis()
         && this.m_94f128e6(this.f_2d3da689, var2) < this.f_33c46dcf) {
         this.f_1723e347 = System.currentTimeMillis();
         Optional var4 = this.f_9ac547b8.m_c8468b40(var2);
         if (var4.isPresent()) {
            BlockPosition var5 = ((LivingEntity)var4.get()).getBlockPosition();
            Optional var6 = this.f_d5a54a4f
               .m_918b7b9e()
               .filter(var2x -> Math.max(var2.getHealth() - this.m_da7a0468(var2, var2x.m_82942af9().offset(0.5, 1.0, 0.5)), 0.0F) >= this.f_043c0ccd)
               .filter(var1x -> var1x.m_82942af9().offset(0.5, 1.0, 0.5).distanceTo(var5) >= 1.0F)
               .min((var1x, var2x) -> Float.compare(var1x.m_82942af9().distanceTo(var5), var2x.m_82942af9().distanceTo(var5)));
            var6.ifPresent(var2x -> this.m_637f813e(var2, var2x));
         }
      }

      if (this.f_de9d4971 && var3 && this.f_3f4fa077 + (long)this.f_5d017bec < System.currentTimeMillis()) {
         Optional var7 = ClientWorld.getClientWorld()
            .getLoadedEntities()
            .filter(var0 -> var0 instanceof EndCrystalEntity)
            .filter(var2x -> var2.distanceToEntity(var2x) <= this.f_e70c48d6)
            .filter(var2x -> Math.max(var2.getHealth() - this.m_bf61c67f(var2, (EndCrystalEntity)var2x), 0.0F) >= this.f_043c0ccd)
            .findFirst();
         if (var7.isPresent()) {
            double var8 = (double)this.m_bf61c67f(var2, (EndCrystalEntity)var7.get());
            if (var2.getHealth() >= this.f_043c0ccd) {
               this.m_06f12a65(var2, (Entity)var7.get());
            }
         }
      }
   }

   @EventHandler
   private void m_c738343e(EventRender3D var1) {
      MainEntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
      boolean var3 = this.m_4ab440d1(this.f_2d3da689, var2);
      if (this.f_d7c97be1 && this.f_d5a54a4f.m_8b15b5f4() > 0 && this.m_94f128e6(this.f_2d3da689, var2) < this.f_33c46dcf) {
         ((CubeRenderStack)this.f_c4c4699a.begin(true).glColor(var3 ? Color.green : Color.pink, 180.0F)).lineWidth(2.0F);
         this.f_d5a54a4f
            .m_918b7b9e()
            .filter(var2x -> Math.max(var2.getHealth() - this.m_da7a0468(var2, var2x.m_82942af9().offset(0.5, 1.0, 0.5)), 0.0F) >= this.f_043c0ccd)
            .forEach(var1x -> this.f_c4c4699a.draw(var1x.m_82942af9().getBoundingBox()));
         this.f_c4c4699a.end();
      }
   }
}
