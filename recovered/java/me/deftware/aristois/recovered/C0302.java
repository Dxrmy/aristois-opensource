package me.deftware.aristois.recovered;

import java.awt.Color;
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
import me.deftware.client.framework.render.batching.CubeRenderStack;
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
   private float f_9b8475bc = 4.0F;
   @C0098(
      value = "Attack Delay",
      description = {"Delay between attacking multiple end crystals, in milliseconds"},
      number = @C0096(
         min = 0.0,
         max = 5000.0
      )
   )
   private int f_6de434c0 = 500;
   @C0098(
      value = "Place Delay",
      description = {"Delay between placing end crystals, in milliseconds"},
      number = @C0096(
         min = 0.0,
         max = 5000.0
      )
   )
   private int f_b782d218 = 300;
   @C0098(
      value = "Min health",
      description = {"Min health after explosion"},
      number = @C0096(
         min = 0.0,
         max = 20.0
      )
   )
   private float f_cb7db8a0 = 10.0F;
   @C0098(
      value = "Max crystals",
      description = {"Max amount of end crystals that can be placed"},
      number = @C0096(
         max = 10.0
      )
   )
   private int f_bcde9689 = 3;
   @C0098(
      value = "Place",
      description = {"Automatically place end crystals"}
   )
   private boolean f_ae770281 = true;
   @C0098(
      value = "Attack",
      description = {"Automatically attack placed end crystals"}
   )
   private boolean f_d42b1bb6 = true;
   @C0098(
      value = "Overlay",
      description = {"Show where it will place end crystals"}
   )
   private boolean f_523ec117 = true;
   @C0098(
      value = "Player Range",
      description = {"Player detection range"}
   )
   private float f_700d6e3c = 15.0F;
   private long f_b38cda0b = C0114.bootstrap<"call",0,1>();
   private final CubeRenderStack f_373faeeb = new CubeRenderStack();
   private C0283<C0283.anonymousconst> f_719b11e1;

   public C0302() {
      super(C0252.bootstrap<"get",38654705778>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705779>());
   }

   protected C0062 m_d7f6e325() {
      return new C0059() {
         public C0102<C0063> m_2e9f6e99() {
            return C0302.this.f_0c381e92;
         }

         public Predicate<LivingEntity> m_2b6cd211() {
            return C0114.bootstrap<"call",0,1>(C0302.this, super.m_4dabd50c());
         }

         public float m_964b5c7f() {
            return C0114.bootstrap<"call",0,1>(C0302.this);
         }
      };
   }

   @Override
   public void onEnable() {
      if (C0114.bootstrap<"call",0,1>() != null && C0114.bootstrap<"call",1,1>()._getPlayer() != null) {
         this.f_719b11e1 = new C0283<>(
            var1 -> {
               DoubleBlockPosition var2 = (DoubleBlockPosition)var1.m_8ac0e23f().offset(0.5, 1.0, 0.5);
               return var1.m_5d9fe07a().equals(C0071.f_5c7ed30b)
                     || var1.m_5d9fe07a().equals(C0071.f_c7c6621d)
                        && C0114.bootstrap<"call",1,1>()._getPlayer().getBlockPosition().distanceTo(var2) <= this.f_9b8475bc
                  ? C0114.bootstrap<"call",0,1>()._getBlockFromPosition(var2).isAir() && !C0114.bootstrap<"call",5,1>(var1.m_8ac0e23f())
                  : false;
            },
            (int)this.f_9b8475bc
         );
         this.f_719b11e1.m_83bbff4e();
      } else {
         this.toggle();
      }
   }

   @Override
   public void onDisable() {
      if (this.f_719b11e1 != null) {
         this.f_719b11e1.m_a02817c2();
         this.f_719b11e1 = null;
      }
   }

   private boolean m_6a9e5347(float var1, MainEntityPlayer var2) {
      Optional var3 = C0114.bootstrap<"call",0,1>()
         .getLoadedEntities()
         .filter(var0 -> var0 instanceof EntityPlayer)
         .filter(var0 -> !var0.isSelf())
         .filter(var2x -> var2x.distanceToEntity(var2) < var1)
         .findAny();
      return var3.isPresent();
   }

   private int m_d20e0c15(float var1, MainEntityPlayer var2) {
      return (int)C0114.bootstrap<"call",0,1>()
         .getLoadedEntities()
         .filter(var2x -> var2.distanceToEntity(var2x) <= var1)
         .filter(var0 -> var0 instanceof EndCrystalEntity)
         .count();
   }

   private static boolean m_1cd58f55(BlockPosition var0) {
      Optional var1 = C0114.bootstrap<"call",0,1>()
         .getLoadedEntities()
         .filter(var0x -> var0x instanceof EndCrystalEntity)
         .filter(
            var1x -> C0114.bootstrap<"call",7,1>(var1x.getPosX()) == var0.getX()
                  && C0114.bootstrap<"call",7,1>(var1x.getPosZ()) == var0.getZ()
                  && var1x.getPosY() > var0.getY()
                  && var1x.getPosY() < var0.getY() + 3.0
         )
         .findAny();
      return var1.isPresent();
   }

   private float m_c1a7881a(MainEntityPlayer var1, EndCrystalEntity var2) {
      if (var1.isCreative()) {
         return 0.0F;
      } else {
         double var3 = (double)var1.distanceToEntity(var2);
         float var5 = 0.0F;
         if (var3 < 12.0) {
            double var6 = (double)var2.getEntityDamage(var1);
            double var8 = (1.0 - var3 / 12.0) * var6;
            double var10 = (var8 * var8 + var8) / 2.0 * 7.0 * 12.0 + 1.0;
            var5 = var10 < 0.0 ? 0.0F : this.m_197d1d67(this.m_a7c1cd94((float)var10));
         }

         return var5;
      }
   }

   private float m_54002003(MainEntityPlayer var1, BlockPosition var2) {
      if (var1.isCreative()) {
         return 0.0F;
      } else {
         double var3 = (double)var1.getBlockPosition().distanceTo(var2);
         float var5 = 0.0F;
         if (var3 < 12.0) {
            double var6 = (double)C0114.bootstrap<"call",1,1>(var2, var1);
            double var8 = (1.0 - var3 / 12.0) * var6;
            double var10 = (var8 * var8 + var8) / 2.0 * 7.0 * 12.0 + 1.0;
            var5 = var10 < 0.0 ? 0.0F : this.m_197d1d67(this.m_a7c1cd94((float)var10));
         }

         return var5;
      }
   }

   private float m_a7c1cd94(float var1) {
      if (C0114.bootstrap<"call",0,1>()._getDifficulty() == 0) {
         return 0.0F;
      } else if (C0114.bootstrap<"call",0,1>()._getDifficulty() == 1) {
         return C0114.bootstrap<"call",2,1>(var1 / 2.0F + 1.0F, var1);
      } else {
         return C0114.bootstrap<"call",0,1>()._getDifficulty() == 2 ? var1 * 3.0F / 2.0F : var1;
      }
   }

   private float m_197d1d67(float var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()._getPlayer());
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
      float var11 = C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(var3 * 0.2F, var3 - var1 / var10), 20.0F);
      var1 *= 1.0F - var11 / 25.0F;
      float var12 = C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(0.0F, var4), 20.0F);
      return var1 * (1.0F - var12 / 25.0F);
   }

   private void m_5b952390(MainEntityPlayer var1, C0283.anonymousconst var2) {
      boolean var3 = true;
      int var4 = -1;
      if (!var1.getInventory().getHeldItem(false).getItem().equals(C0070.f_9a9c57fb)) {
         int var5 = var1.getInventory().findItem(C0070.f_9a9c57fb);
         if (var5 != -1 && var5 < 9) {
            var4 = var1.getInventory().getCurrentItem();
            var1.getInventory().setCurrentItem(var5);
         }

         var3 = var5 != -1 && var5 < 9;
      }

      if (var3 && var1.processRightClickBlock(var2.m_8ac0e23f(), EnumFacing.UP, var2.m_8ac0e23f().getVector())) {
         var1.swingArmClientSide();
      }

      if (var4 != -1) {
      }
   }

   @Override
   public void onPostLoad() {
      this.m_231a0568();
   }

   @EventHandler
   private void m_2c8573e2(EventUpdate var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>()._getPlayer());
      boolean var3 = this.m_6a9e5347(this.f_700d6e3c, var2);
      if (this.f_ae770281
         && var3
         && var2.getHealth() >= this.f_cb7db8a0
         && this.f_719b11e1.m_61639eef() > 0
         && this.f_b38cda0b + (long)this.f_b782d218 < C0114.bootstrap<"call",5,1>()
         && this.m_d20e0c15(this.f_700d6e3c, var2) < this.f_bcde9689) {
         this.f_b38cda0b = C0114.bootstrap<"call",5,1>();
         Optional var4 = this.f_2c0bf7b8.m_ebb8b79c(var2);
         if (var4.isPresent()) {
            BlockPosition var5 = ((LivingEntity)var4.get()).getBlockPosition();
            Optional var6 = this.f_719b11e1
               .m_730fe145()
               .filter(
                  var2x -> C0114.bootstrap<"call",0,1>(var2.getHealth() - this.m_54002003(var2, var2x.m_8ac0e23f().offset(0.5, 1.0, 0.5)), 0.0F)
                        >= this.f_cb7db8a0
               )
               .filter(var1x -> var1x.m_8ac0e23f().offset(0.5, 1.0, 0.5).distanceTo(var5) >= 1.0F)
               .min((var1x, var2x) -> C0114.bootstrap<"call",6,1>(var1x.m_8ac0e23f().distanceTo(var5), var2x.m_8ac0e23f().distanceTo(var5)));
            var6.ifPresent(var2x -> this.m_5b952390(var2, var2x));
         }
      }

      if (this.f_d42b1bb6 && var3 && this.f_3d37b190 + (long)this.f_6de434c0 < C0114.bootstrap<"call",5,1>()) {
         Optional var7 = C0114.bootstrap<"call",0,1>()
            .getLoadedEntities()
            .filter(var0 -> var0 instanceof EndCrystalEntity)
            .filter(var2x -> var2.distanceToEntity(var2x) <= this.f_9b8475bc)
            .filter(var2x -> C0114.bootstrap<"call",0,1>(var2.getHealth() - this.m_c1a7881a(var2, (EndCrystalEntity)var2x), 0.0F) >= this.f_cb7db8a0)
            .findFirst();
         if (var7.isPresent()) {
            double var8 = (double)this.m_c1a7881a(var2, (EndCrystalEntity)var7.get());
            if (var2.getHealth() >= this.f_cb7db8a0) {
               this.m_9f25af61(var2, (Entity)var7.get());
            }
         }
      }
   }

   @EventHandler
   private void m_23ee2520(EventRender3D var1) {
      MainEntityPlayer var2 = (MainEntityPlayer)C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>()._getPlayer());
      boolean var3 = this.m_6a9e5347(this.f_700d6e3c, var2);
      if (this.f_523ec117 && this.f_719b11e1.m_61639eef() > 0 && this.m_d20e0c15(this.f_700d6e3c, var2) < this.f_bcde9689) {
         ((CubeRenderStack)this.f_373faeeb.begin(true).glColor(var3 ? Color.green : Color.pink, 180.0F)).lineWidth(2.0F);
         this.f_719b11e1
            .m_730fe145()
            .filter(
               var2x -> C0114.bootstrap<"call",3,1>(var2.getHealth() - this.m_54002003(var2, var2x.m_8ac0e23f().offset(0.5, 1.0, 0.5)), 0.0F)
                     >= this.f_cb7db8a0
            )
            .forEach(var1x -> this.f_373faeeb.draw(var1x.m_8ac0e23f().getBoundingBox()));
         this.f_373faeeb.end();
      }
   }
}
