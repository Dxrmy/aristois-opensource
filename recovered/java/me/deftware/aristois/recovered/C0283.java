package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.block.Block;

public class C0283<T extends C0283.anonymousconst> extends C0285 {
   protected final List<T> f_0c75d6e7 = new CopyOnWriteArrayList<>();
   protected ScheduledFuture<?> f_5c3828cd;
   protected final Runnable f_af160a87;

   public C0283(Predicate<T> var1, int var2) {
      super(null);
      this.f_af160a87 = () -> {
         MainEntityPlayer var3 = Minecraft.getMinecraftGame()._getPlayer();
         if (var3 != null && var3.isAlive()) {
            this.f_0c75d6e7
               .removeIf(
                  var2xx -> var1.negate().test(this.m_68f4fcf9(var2xx.m_82942af9(), ClientWorld.getClientWorld()._getBlockFromPosition(var2xx.m_82942af9())))
               );

            for (C0283.anonymousconst var5 : this.m_f695ddd4(var1, var2, var3)) {
               if (!this.f_0c75d6e7.contains(var5)) {
                  this.f_0c75d6e7.add((T)var5);
               }
            }

            this.f_0c75d6e7.removeIf(var2xx -> var2xx.m_82942af9().getBoundingBox().squareDistanceTo(var3) > (float)var2);
         }
      };
   }

   @Override
   public C0285 m_49509d4b() {
      this.f_5c3828cd.cancel(true);
      return super.m_49509d4b();
   }

   @Override
   public C0285 m_d0dcca5b() {
      this.f_5c3828cd = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(this.f_af160a87, 0L, 50L, TimeUnit.MILLISECONDS);
      return super.m_d0dcca5b();
   }

   public Stream<T> m_918b7b9e() {
      return this.f_0c75d6e7.stream();
   }

   public int m_8b15b5f4() {
      return this.f_0c75d6e7.size();
   }

   private List<T> m_f695ddd4(Predicate<T> var1, int var2, MainEntityPlayer var3) {
      ArrayList var4 = new ArrayList();
      if (ClientWorld.getClientWorld() != null) {
         for (int var5 = -var2; var5 <= var2; var5++) {
            for (int var6 = var2; var6 >= -var2; var6--) {
               for (int var7 = -var2; var7 <= var2; var7++) {
                  int var8 = (int)(var3.getPosX() + (double)var5);
                  int var9 = (int)(var3.getPosY() + (double)var6);
                  int var10 = (int)(var3.getPosZ() + (double)var7);
                  DoubleBlockPosition var11 = new DoubleBlockPosition((double)var8, (double)var9, (double)var10);
                  Block var12 = ClientWorld.getClientWorld()._getBlockFromPosition(var11);
                  C0283.anonymousconst var13 = this.m_68f4fcf9(var11, var12);
                  if (var1.test(var13)) {
                     var4.add(var13);
                  }
               }
            }
         }
      }

      return var4;
   }

   protected T m_68f4fcf9(BlockPosition var1, Block var2) {
      return (T)(new C0283.anonymousconst(var1, var2));
   }

   public List<T> m_8db15fc6() {
      return this.f_0c75d6e7;
   }

   public static class anonymousconst {
      private final BlockPosition f_e7ad4317;
      private final Block f_f9cd4747;

      @Override
      public boolean equals(Object var1) {
         if (!(var1 instanceof C0283.anonymousconst)) {
            return false;
         } else {
            C0283.anonymousconst var2 = (C0283.anonymousconst)var1;
            return this.f_f9cd4747.equals(var2.f_f9cd4747)
               && var2.f_e7ad4317.getX() == this.f_e7ad4317.getX()
               && var2.f_e7ad4317.getY() == this.f_e7ad4317.getY()
               && var2.f_e7ad4317.getZ() == this.f_e7ad4317.getZ();
         }
      }

      public BlockPosition m_82942af9() {
         return this.f_e7ad4317;
      }

      public Block m_268de4b2() {
         return this.f_f9cd4747;
      }

      public anonymousconst(BlockPosition var1, Block var2) {
         this.f_e7ad4317 = var1;
         this.f_f9cd4747 = var2;
      }
   }
}
