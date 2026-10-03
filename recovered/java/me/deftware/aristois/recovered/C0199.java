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
   private final HashMap<Class<?>, Block> f_af4b1728 = new HashMap<>();

   public C0199(String var1) {
      super(Block.class, var1);
      this.m_509a8955(ChestEntity.class, C0266.m_96ba50d4());
      this.m_509a8955(C0199.anonymousimplements.class, C0265.m_96ba50d4());
      this.m_509a8955(C0199.anonymouscatch.class, C0265.m_88726494());
      this.m_509a8955(BarrelEntity.class, C0265.m_27479cfa());
      this.m_509a8955(HopperEntity.class, C0256.m_56c1229f());
      this.m_509a8955(ShulkerEntity.class, C0256.m_0d6ae39b());
   }

   public void m_509a8955(Class<?> var1, String var2) {
      Optional var3 = BlockRegistry.INSTANCE.find(var2);
      var3.ifPresent(var2x -> {
         Block var10000 = this.f_af4b1728.put(var1, var2x);
      });
   }

   public Class<?> m_39a4c05b(StorageEntity var1) {
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

   public boolean m_8a2535a2(StorageEntity var1) {
      Class var2 = this.m_39a4c05b(var1);
      return this.f_af4b1728.containsKey(var2) ? this.contains(this.f_af4b1728.get(var2)) : false;
   }

   public HashMap<Class<?>, Block> m_fa23cd75() {
      return this.f_af4b1728;
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
