package me.deftware.aristois.recovered;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.EntityType;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.animals.WolfEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.math.vector.Vector3d;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;

public interface C0062 {
   default boolean m_51ce03a5() {
      return false;
   }

   default boolean m_e606d819() {
      return true;
   }

   default boolean m_e0f7c666() {
      return false;
   }

   default boolean m_297cfef6() {
      return false;
   }

   default boolean m_275ab222() {
      return false;
   }

   default float m_796256b9() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      return var1 != null && var1.isCreative() ? 5.0F : 4.5F;
   }

   default float m_b9b6635c() {
      return 360.0F;
   }

   default C0102<C0062.anonymousthis> m_430587bc() {
      return new C0102<>(C0062.anonymousthis.f_aaf1bb04);
   }

   default C0102<C0063> m_0098dd70() {
      return new C0102<>(C0063.f_0c3cee95);
   }

   default boolean m_f4c8f1db(MainEntityPlayer var1, LivingEntity var2) {
      if (var2.distanceToEntity(var1) > this.m_796256b9()) {
         return false;
      } else if (!var2.isAlive() || var2.isSelf() || !this.m_430587bc().m_284992ec().m_97a0a4cb(var2)) {
         return false;
      } else if (var2.isInvisible() && !this.m_297cfef6()) {
         return false;
      } else if (this.m_b9b6635c() < 360.0F && var1.getAngleToClientRotation(var2) > this.m_b9b6635c() / 2.0F) {
         return false;
      } else if (!this.m_e606d819() && !this.m_9c2d8d03(var1, var2)) {
         return false;
      } else if (var2 instanceof EntityPlayer) {
         EntityPlayer var5 = (EntityPlayer)var2;
         if (var5.isSleeping() && !this.m_51ce03a5()) {
            return false;
         } else {
            Optional var4 = C0247.m_ee0ef813().stream().filter(var1x -> var1x.m_3d3a8736().equalsIgnoreCase(var5.getUsername())).findAny();
            return var4.isPresent() && !this.m_275ab222() ? false : !var5.getUsername().equalsIgnoreCase(var1.getUsername());
         }
      } else {
         if (var2 instanceof WolfEntity) {
            WolfEntity var3 = (WolfEntity)var2;
            if (var3.isPlayerOwned(var1)) {
               return false;
            }
         }

         return !this.m_e0f7c666() || this.m_cb83d681(var2);
      }
   }

   default Predicate<LivingEntity> m_c8fd13b8() {
      return var0 -> true;
   }

   default boolean m_9c2d8d03(MainEntityPlayer var1, LivingEntity var2) {
      Vector3d var3 = var1.getEyesPos();
      double var4 = (double)var1.distanceToEntity(var2);
      float[] var6 = C0218.m_9a6f1709(var3, var2.getBoundingBox().getCenter());
      Vector3d var7 = C0218.m_b07d9977(var6);
      Vector3d var8 = var3.add(var7.getX() * var4, var7.getY() * var4, var7.getZ() * var4);
      Entity var9 = C0212.m_a89ff977(var3, var8, var7, var1, (float)var4);
      return var9 != null && var9.getEntityId() == var2.getEntityId();
   }

   default boolean m_cb83d681(LivingEntity var1) {
      return var1.isHostile()
         || var1.instanceOf(EntityType.ENTITY_PHANTOM)
         || var1.instanceOf(EntityType.ENTITY_SLIME)
         || var1.instanceOf(EntityType.ENTITY_MAGMA_CUBE);
   }

   default Stream<LivingEntity> m_1613711b(MainEntityPlayer var1) {
      return ClientWorld.getClientWorld()
         .getLoadedEntities()
         .filter(var0 -> var0 instanceof LivingEntity)
         .map(var0 -> (LivingEntity)var0)
         .filter(this.m_c8fd13b8())
         .filter(var2 -> this.m_f4c8f1db(var1, var2));
   }

   default Optional<LivingEntity> m_c8468b40(MainEntityPlayer var1) {
      return this.m_0098dd70().m_284992ec().m_9d947410(this.m_1613711b(var1));
   }

   public static enum anonymousthis implements C0102.anonymousthis {
      f_a9cae9b2(var0 -> var0 instanceof LivingEntity && !(var0 instanceof EntityPlayer), C0264.m_593ecbab(), C0264.m_17d51275()),
      f_f610906e(var0 -> var0 instanceof EntityPlayer, C0264.m_d1f7b79f(), C0264.m_a29090eb()),
      f_aaf1bb04(var0 -> var0 instanceof LivingEntity, C0264.m_91e95cb4(), C0264.m_1616e137());

      private final Function<Entity, Boolean> f_1c4f11c7;
      private final String[] f_192d4d4b;
      private final String f_9e6ea3e6;

      private anonymousthis(Function<Entity, Boolean> var3, String var4, String... var5) {
         this.f_192d4d4b = var5;
         this.f_1c4f11c7 = var3;
         this.f_9e6ea3e6 = var4;
      }

      @Override
      public String toString() {
         return this.f_9e6ea3e6;
      }

      public boolean m_97a0a4cb(Entity var1) {
         return this.f_1c4f11c7.apply(var1);
      }

      @Override
      public String[] m_8e56a473() {
         return this.f_192d4d4b;
      }
   }
}
