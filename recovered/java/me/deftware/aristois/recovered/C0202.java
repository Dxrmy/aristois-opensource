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
   public static final C0202 f_b9f4c1a2 = new C0202();
   private final List<Runnable> f_ab945681 = new ArrayList<>();

   public C0202() {
   }

   @EventHandler
   private void m_fa105933(EventUpdate var1) {
      this.f_ab945681.removeIf(var0 -> {
         if (var0 instanceof C0202.anonymousdefault) {
            C0202.anonymousdefault var1x = (C0202.anonymousdefault)var0;
            if (var1x.m_1de11b6f() || var1x.m_559522cb() + 2000L < C0114.bootstrap<"call",0,1>()) {
               var0.run();
               return true;
            }
         } else {
            var0.run();
         }

         return false;
      });
   }

   public <T> void m_5a200d53(Supplier<T> var1, Consumer<T> var2) {
      C0202.anonymousboolean var3 = new C0202.anonymousboolean(var1, var2);
      this.f_ab945681.add(var3);
   }

   public void m_32fb977f(Number var1, Supplier<Number> var2, Runnable var3) {
      this.m_199daeec(var1, var2, (var0, var1x) -> var0.floatValue() < var1x.floatValue(), var3);
   }

   public <T> void m_321bc0f2(T var1, Supplier<T> var2, Runnable var3) {
      this.m_199daeec(var1, var2, (var0, var1x) -> var0 != var1x, var3);
   }

   public <T> void m_199daeec(final T var1, final Supplier<T> var2, final BiPredicate<T, T> var3, final Runnable var4) {
      this.f_ab945681.add(new C0202.anonymousdefault<T>() {
         @Override
         public void run() {
            var4.run();
         }

         public long m_ece9f622() {
            return C0114.bootstrap<"call",0,1>();
         }

         public T m_5a3179f1() {
            return (T)var1;
         }

         public T m_5b670dbd() {
            return (T)var2.get();
         }

         public boolean m_67526452() {
            return var3.test(this.m_5a3179f1(), this.m_5b670dbd());
         }
      });
   }

   private static class anonymousboolean<T> implements Runnable {
      private T f_580083da;
      private final Supplier<T> f_9c735078;
      private final Consumer<T> f_b1805c5d;

      @Override
      public void run() {
         Object var1 = this.f_9c735078.get();
         if (this.f_580083da != var1) {
            this.f_580083da = (T)var1;
            this.f_b1805c5d.accept((T)var1);
         }
      }

      public anonymousboolean(Supplier<T> var1, Consumer<T> var2) {
         this.f_9c735078 = var1;
         this.f_b1805c5d = var2;
      }
   }

   private interface anonymousdefault<T> extends Runnable {
      long m_559522cb();

      T m_e9b448dd();

      T m_62856137();

      boolean m_1de11b6f();
   }
}
