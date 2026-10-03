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

public interface C0062 {
   default boolean m_f4c410e4() {
      return false;
   }

   default boolean m_7cc778d2() {
      return true;
   }

   default boolean m_3a13d3c7() {
      return false;
   }

   default boolean m_45fcf02c() {
      return false;
   }

   default boolean m_2cde80e4() {
      return false;
   }

   default float m_b0df3e6f() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      return var1 != null && var1.isCreative() ? 5.0F : 4.5F;
   }

   default float m_ad62fc11() {
      return 360.0F;
   }

   default C0102<C0062.anonymousthis> m_6506456c() {
      return new C0102<>(C0062.anonymousthis.f_a322abf0);
   }

   default C0102<C0063> m_a31d3afb() {
      return new C0102<>(C0063.f_73d66f71);
   }

   default boolean m_7507811b(MainEntityPlayer var1, LivingEntity var2) {
      if (var2.distanceToEntity(var1) > this.m_b0df3e6f()) {
         return false;
      } else if (!var2.isAlive() || var2.isSelf() || !this.m_6506456c().m_e2691446().m_9b4e2d13(var2)) {
         return false;
      } else if (var2.isInvisible() && !this.m_45fcf02c()) {
         return false;
      } else if (this.m_ad62fc11() < 360.0F && var1.getAngleToClientRotation(var2) > this.m_ad62fc11() / 2.0F) {
         return false;
      } else if (!this.m_7cc778d2() && !this.m_12aa9c38(var1, var2)) {
         return false;
      } else if (var2 instanceof EntityPlayer) {
         EntityPlayer var5 = (EntityPlayer)var2;
         if (var5.isSleeping() && !this.m_f4c410e4()) {
            return false;
         } else {
            Optional var4 = C0114.bootstrap<"call",1,1>().stream().filter(var1x -> var1x.m_cd751ed2().equalsIgnoreCase(var5.getUsername())).findAny();
            return var4.isPresent() && !this.m_2cde80e4() ? false : !var5.getUsername().equalsIgnoreCase(var1.getUsername());
         }
      } else {
         if (var2 instanceof WolfEntity) {
            WolfEntity var3 = (WolfEntity)var2;
            if (var3.isPlayerOwned(var1)) {
               return false;
            }
         }

         return !this.m_3a13d3c7() || this.m_32faa4b7(var2);
      }
   }

   default Predicate<LivingEntity> m_3f02d942() {
      return var0 -> true;
   }

   default boolean m_12aa9c38(MainEntityPlayer var1, LivingEntity var2) {
      Vector3d var3 = var1.getEyesPos();
      double var4 = (double)var1.distanceToEntity(var2);
      float[] var6 = C0114.bootstrap<"call",0,1>(var3, var2.getBoundingBox().getCenter());
      Vector3d var7 = C0114.bootstrap<"call",1,1>(var6);
      Vector3d var8 = var3.add(var7.getX() * var4, var7.getY() * var4, var7.getZ() * var4);
      Entity var9 = C0114.bootstrap<"call",2,1>(var3, var8, var7, var1, (float)var4);
      return var9 != null && var9.getEntityId() == var2.getEntityId();
   }

   default boolean m_32faa4b7(LivingEntity var1) {
      return var1.isHostile()
         || var1.instanceOf(EntityType.ENTITY_PHANTOM)
         || var1.instanceOf(EntityType.ENTITY_SLIME)
         || var1.instanceOf(EntityType.ENTITY_MAGMA_CUBE);
   }

   default Stream<LivingEntity> m_d1b1f204(MainEntityPlayer var1) {
      return C0114.bootstrap<"call",2,1>()
         .getLoadedEntities()
         .filter(var0 -> var0 instanceof LivingEntity)
         .map(var0 -> (LivingEntity)var0)
         .filter(this.m_3f02d942())
         .filter(var2 -> this.m_7507811b(var1, var2));
   }

   default Optional<LivingEntity> m_ebb8b79c(MainEntityPlayer var1) {
      return this.m_a31d3afb().m_e2691446().m_195ac10f(this.m_d1b1f204(var1));
   }

   public static enum anonymousthis implements C0102.anonymousthis {
      f_8eb2001e(
         var0 -> C0114.bootstrap<"call",0,1>(var0 instanceof LivingEntity && !(var0 instanceof EntityPlayer)),
         C0252.bootstrap<"get",4294967366>(),
         C0252.bootstrap<"get",4294967367>()
      ),
      f_60d5e1de(var0 -> C0114.bootstrap<"call",0,1>(var0 instanceof EntityPlayer), C0252.bootstrap<"get",4294967369>(), C0252.bootstrap<"get",4294967370>()),
      f_a322abf0(var0 -> C0114.bootstrap<"call",0,1>(var0 instanceof LivingEntity), C0252.bootstrap<"get",4294967372>(), C0252.bootstrap<"get",4294967373>());

      private final Function<Entity, Boolean> f_4ca333c6;
      private final String[] f_ab12b75f;
      private final String f_575aff77;

      private anonymousthis(Function<Entity, Boolean> var3, String var4, String... var5) {
         this.f_ab12b75f = var5;
         this.f_4ca333c6 = var3;
         this.f_575aff77 = var4;
      }

      @Override
      public String toString() {
         return this.f_575aff77;
      }

      public boolean m_9b4e2d13(Entity var1) {
         return this.f_4ca333c6.apply(var1);
      }

      public String[] m_813eb965() {
         return this.f_ab12b75f;
      }
   }
}
