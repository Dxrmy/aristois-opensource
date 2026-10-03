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
import me.deftware.client.framework.gui.GuiScreen;

public final class C0269 extends EventListener {
   public static final C0269 f_44d31626 = new C0269();
   private final CopyOnWriteArrayList<C0288<?>> f_4434b327 = new CopyOnWriteArrayList<>();
   private final Queue<C0288<?>> f_3cf6055b = new ConcurrentLinkedQueue<>();
   private double f_b44dce3a = (double)GuiScreen.getDisplayWidth();
   private double f_7d9dcf90 = (double)GuiScreen.getDisplayHeight();

   public C0269() {
   }

   public <T extends C0288<T>> T m_dfae9307(C0288<T> var1) {
      if (var1 instanceof C0270) {
         this.f_3cf6055b.add(var1);
      } else {
         this.f_4434b327.add(var1);
      }

      return (T)var1;
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      this.m_ed2a80e1(var2 -> this.m_7e3b34d9(var2, var1));
   }

   @EventHandler
   public void m_5d3a4d80(EventMatrixRender var1) {
      if (this.f_b44dce3a != (double)GuiScreen.getDisplayWidth() || this.f_7d9dcf90 != (double)GuiScreen.getDisplayHeight()) {
         this.f_b44dce3a = (double)GuiScreen.getDisplayWidth();
         this.f_7d9dcf90 = (double)GuiScreen.getDisplayHeight();
         this.f_4434b327.stream().filter(var0 -> var0 instanceof C0274).forEach(var0 -> ((C0274)var0).m_547191bb());
      }

      this.m_ed2a80e1(var2 -> this.m_7e3b34d9(var2, var1));
   }

   private void m_ed2a80e1(Consumer<C0288<?>> var1) {
      if (!this.f_4434b327.isEmpty()) {
         this.f_4434b327.removeIf(var0 -> var0.m_f7b07982() && var0.m_f21a055b());
         this.f_4434b327.stream().filter(C0288::m_9362a920).forEach(var1);
      }

      if (!this.f_3cf6055b.isEmpty()) {
         C0288 var2 = this.f_3cf6055b.peek();
         if (var2.m_9362a920()) {
            var1.accept(var2);
            if (var2.m_f7b07982() && var2.m_f21a055b()) {
               this.f_3cf6055b.remove();
            }
         }
      }
   }

   private void m_7e3b34d9(C0288<?> var1, Event var2) {
      if (!var1.m_f7b07982()) {
         if (var2 instanceof EventUpdate) {
            var1.m_ac6eac3b();
         } else if (var2 instanceof EventMatrixRender && var1 instanceof C0274) {
            ((C0274)var1).m_eb5193b3(((EventMatrixRender)var2).getPartialTicks());
         }
      } else {
         var1.m_41e83f88();
      }
   }

   public CopyOnWriteArrayList<C0288<?>> m_94a15833() {
      return this.f_4434b327;
   }
}
