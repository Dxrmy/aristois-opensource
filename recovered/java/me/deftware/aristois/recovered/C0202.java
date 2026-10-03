package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventUpdate;

public class C0202 extends EventListener {
   public static final C0202 f_75b1ba31 = new C0202();
   private final List<Runnable> f_81d65b20 = new ArrayList<>();

   public C0202() {
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      this.f_81d65b20.removeIf(var0 -> {
         if (var0 instanceof C0202.anonymousdefault) {
            C0202.anonymousdefault var1x = (C0202.anonymousdefault)var0;
            if (var1x.m_51ce03a5() || var1x.m_7054c744() + 2000L < System.currentTimeMillis()) {
               var0.run();
               return true;
            }
         } else {
            var0.run();
         }

         return false;
      });
   }

   public <T> void m_35a6ad75(Supplier<T> var1, Consumer<T> var2) {
      C0202.anonymousboolean var3 = new C0202.anonymousboolean(var1, var2);
      this.f_81d65b20.add(var3);
   }

   public void m_fde31326(Number var1, Supplier<Number> var2, Runnable var3) {
      this.m_6bcead93(var1, var2, (var0, var1x) -> var0.floatValue() < var1x.floatValue(), var3);
   }

   public <T> void m_577cf1b9(T var1, Supplier<T> var2, Runnable var3) {
      this.m_6bcead93(var1, var2, (var0, var1x) -> var0 != var1x, var3);
   }

   public <T> void m_6bcead93(final T var1, final Supplier<T> var2, final BiPredicate<T, T> var3, final Runnable var4) {
      this.f_81d65b20.add(new C0202.anonymousdefault<T>() {
         @Override
         public void run() {
            var4.run();
         }

         @Override
         public long m_7054c744() {
            return System.currentTimeMillis();
         }

         @Override
         public T m_b252dc95() {
            return (T)var1;
         }

         @Override
         public T m_298196c7() {
            return (T)var2.get();
         }

         @Override
         public boolean m_51ce03a5() {
            return var3.test(this.m_b252dc95(), this.m_298196c7());
         }
      });
   }

   private static class anonymousboolean<T> implements Runnable {
      private T f_58d3aa6b;
      private final Supplier<T> f_a71d0649;
      private final Consumer<T> f_85c86900;

      @Override
      public void run() {
         Object var1 = this.f_a71d0649.get();
         if (this.f_58d3aa6b != var1) {
            this.f_58d3aa6b = (T)var1;
            this.f_85c86900.accept((T)var1);
         }
      }

      public anonymousboolean(Supplier<T> var1, Consumer<T> var2) {
         this.f_a71d0649 = var1;
         this.f_85c86900 = var2;
      }
   }

   private interface anonymousdefault<T> extends Runnable {
      long m_7054c744();

      T m_b252dc95();

      T m_298196c7();

      boolean m_51ce03a5();
   }
}
