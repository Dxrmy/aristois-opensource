package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.world.block.Block;

public class C0283<T extends C0283.anonymousconst> extends C0285 {
   protected final List<T> f_5365059f = new CopyOnWriteArrayList<>();
   protected ScheduledFuture<?> f_16ee172e;
   protected final Runnable f_85b5bea8;

   public C0283(Predicate<T> var1, int var2) {
      super(null);
      this.f_85b5bea8 = () -> {
         MainEntityPlayer var3 = C0114.bootstrap<"call",1,1>()._getPlayer();
         if (var3 != null && var3.isAlive()) {
            this.f_5365059f
               .removeIf(
                  var2xx -> var1.negate().test(this.m_e0deaf54(var2xx.m_8ac0e23f(), C0114.bootstrap<"call",0,1>()._getBlockFromPosition(var2xx.m_8ac0e23f())))
               );

            for (C0283.anonymousconst var5 : this.m_65b29eac(var1, var2, var3)) {
               if (!this.f_5365059f.contains(var5)) {
                  this.f_5365059f.add((T)var5);
               }
            }

            this.f_5365059f.removeIf(var2xx -> var2xx.m_8ac0e23f().getBoundingBox().squareDistanceTo(var3) > (float)var2);
         }
      };
   }

   public C0285 m_a02817c2() {
      this.f_16ee172e.cancel(true);
      return super.m_239622f4();
   }

   public C0285 m_83bbff4e() {
      this.f_16ee172e = C0114.bootstrap<"call",0,1>().scheduleAtFixedRate(this.f_85b5bea8, 0L, 50L, TimeUnit.MILLISECONDS);
      return super.m_cb933644();
   }

   public Stream<T> m_730fe145() {
      return this.f_5365059f.stream();
   }

   public int m_61639eef() {
      return this.f_5365059f.size();
   }

   private List<T> m_65b29eac(Predicate<T> var1, int var2, MainEntityPlayer var3) {
      ArrayList var4 = new ArrayList();
      if (C0114.bootstrap<"call",0,1>() != null) {
         for (int var5 = -var2; var5 <= var2; var5++) {
            for (int var6 = var2; var6 >= -var2; var6--) {
               for (int var7 = -var2; var7 <= var2; var7++) {
                  int var8 = (int)(var3.getPosX() + (double)var5);
                  int var9 = (int)(var3.getPosY() + (double)var6);
                  int var10 = (int)(var3.getPosZ() + (double)var7);
                  DoubleBlockPosition var11 = new DoubleBlockPosition((double)var8, (double)var9, (double)var10);
                  Block var12 = C0114.bootstrap<"call",0,1>()._getBlockFromPosition(var11);
                  C0283.anonymousconst var13 = this.m_e0deaf54(var11, var12);
                  if (var1.test(var13)) {
                     var4.add(var13);
                  }
               }
            }
         }
      }

      return var4;
   }

   protected T m_e0deaf54(BlockPosition var1, Block var2) {
      return (T)(new C0283.anonymousconst(var1, var2));
   }

   public List<T> m_fb3458b5() {
      return this.f_5365059f;
   }

   public static class anonymousconst {
      private final BlockPosition f_4f61da30;
      private final Block f_7ea62c9f;

      @Override
      public boolean equals(Object var1) {
         if (!(var1 instanceof C0283.anonymousconst)) {
            return false;
         } else {
            C0283.anonymousconst var2 = (C0283.anonymousconst)var1;
            return this.f_7ea62c9f.equals(var2.f_7ea62c9f)
               && var2.f_4f61da30.getX() == this.f_4f61da30.getX()
               && var2.f_4f61da30.getY() == this.f_4f61da30.getY()
               && var2.f_4f61da30.getZ() == this.f_4f61da30.getZ();
         }
      }

      public BlockPosition m_8ac0e23f() {
         return this.f_4f61da30;
      }

      public Block m_5d9fe07a() {
         return this.f_7ea62c9f;
      }

      public anonymousconst(BlockPosition var1, Block var2) {
         this.f_4f61da30 = var1;
         this.f_7ea62c9f = var2;
      }
   }
}
