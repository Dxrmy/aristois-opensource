package me.deftware.aristois.recovered;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import me.deftware.client.framework.event.Event;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.event.events.EventUpdate;

public final class C0269 extends EventListener {
   public static final C0269 f_13431579 = new C0269();
   private final CopyOnWriteArrayList<C0288<?>> f_c2846170 = new CopyOnWriteArrayList<>();
   private final Queue<C0288<?>> f_96401a02 = new ConcurrentLinkedQueue<>();
   private double f_d3883b55 = (double)C0114.bootstrap<"call",0,1>();
   private double f_496e3c6f = (double)C0114.bootstrap<"call",1,1>();

   public C0269() {
   }

   public <T extends C0288<T>> T m_71701f32(C0288<T> var1) {
      if (var1 instanceof C0270) {
         this.f_96401a02.add(var1);
      } else {
         this.f_c2846170.add(var1);
      }

      return (T)var1;
   }

   @EventHandler
   public void m_fbce0e93(EventUpdate var1) {
      this.m_b8d8c686(var2 -> this.m_c2c297e0(var2, var1));
   }

   @EventHandler
   public void m_a51c6c94(EventMatrixRender var1) {
      if (this.f_d3883b55 != (double)C0114.bootstrap<"call",0,1>() || this.f_496e3c6f != (double)C0114.bootstrap<"call",1,1>()) {
         this.f_d3883b55 = (double)C0114.bootstrap<"call",0,1>();
         this.f_496e3c6f = (double)C0114.bootstrap<"call",1,1>();
         this.f_c2846170.stream().filter(var0 -> var0 instanceof C0274).forEach(var0 -> ((C0274)var0).m_dcfaf3a4());
      }

      this.m_b8d8c686(var2 -> this.m_c2c297e0(var2, var1));
   }

   private void m_b8d8c686(Consumer<C0288<?>> var1) {
      if (!this.f_c2846170.isEmpty()) {
         this.f_c2846170.removeIf(var0 -> var0.m_4babc701() && var0.m_d0c3020f());
         this.f_c2846170.stream().filter(C0288::m_3494bce5).forEach(var1);
      }

      if (!this.f_96401a02.isEmpty()) {
         C0288 var2 = this.f_96401a02.peek();
         if (var2.m_3494bce5()) {
            var1.accept(var2);
            if (var2.m_4babc701() && var2.m_d0c3020f()) {
               this.f_96401a02.remove();
            }
         }
      }
   }

   private void m_c2c297e0(C0288<?> var1, Event var2) {
      if (!var1.m_4babc701()) {
         if (var2 instanceof EventUpdate) {
            var1.m_07cc3ee6();
         } else if (var2 instanceof EventMatrixRender && var1 instanceof C0274) {
            ((C0274)var1).m_dd9c08ed(((EventMatrixRender)var2).getPartialTicks());
         }
      } else {
         var1.m_ea5f0462();
      }
   }

   public CopyOnWriteArrayList<C0288<?>> m_970934e1() {
      return this.f_c2846170;
   }
}
