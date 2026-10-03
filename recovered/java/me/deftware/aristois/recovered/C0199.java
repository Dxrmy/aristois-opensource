package me.deftware.aristois.recovered;

import java.util.HashMap;
import java.util.Optional;
import me.deftware.client.framework.entity.block.BarrelEntity;
import me.deftware.client.framework.entity.block.ChestEntity;
import me.deftware.client.framework.entity.block.HopperEntity;
import me.deftware.client.framework.entity.block.ShulkerEntity;
import me.deftware.client.framework.entity.block.StorageEntity;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.block.Block;

public class C0199 extends C0219<Block> implements C0200<StorageEntity> {
   private final HashMap<Class<?>, Block> f_99fc8eff = new HashMap<>();

   public C0199(String var1) {
      super(Block.class, var1);
      this.m_24f91e97(ChestEntity.class, C0252.bootstrap<"get",12884901940>());
      this.m_24f91e97(C0199.anonymousimplements.class, C0252.bootstrap<"get",30064771124>());
      this.m_24f91e97(C0199.anonymouscatch.class, C0252.bootstrap<"get",30064771125>());
      this.m_24f91e97(BarrelEntity.class, C0252.bootstrap<"get",30064771126>());
      this.m_24f91e97(HopperEntity.class, C0252.bootstrap<"get",55834574974>());
      this.m_24f91e97(ShulkerEntity.class, C0252.bootstrap<"get",55834574975>());
   }

   public void m_24f91e97(Class<?> var1, String var2) {
      Optional var3 = BlockRegistry.INSTANCE.find(var2);
      var3.ifPresent(var2x -> {
         Block var10000 = this.f_99fc8eff.put(var1, var2x);
      });
   }

   public Class<?> m_fba803a1(StorageEntity var1) {
      if (var1 instanceof ChestEntity) {
         ChestEntity var2 = (ChestEntity)var1;
         if (var2.isTrapped()) {
            return C0199.anonymousimplements.class;
         }

         if (var2.isEnderChest()) {
            return C0199.anonymouscatch.class;
         }
      }

      return var1.getClass();
   }

   public boolean m_7847beb9(StorageEntity var1) {
      Class var2 = this.m_fba803a1(var1);
      return this.f_99fc8eff.containsKey(var2) ? this.contains(this.f_99fc8eff.get(var2)) : false;
   }

   public HashMap<Class<?>, Block> m_de35ecd5() {
      return this.f_99fc8eff;
   }

   public static class anonymouscatch {
      public anonymouscatch() {
      }
   }

   public static class anonymousimplements {
      public anonymousimplements() {
      }
   }
}
