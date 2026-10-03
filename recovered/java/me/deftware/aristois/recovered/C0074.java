package me.deftware.aristois.recovered;

import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.minecraft.GameSetting;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0074 extends EventListener {
   private static final FontRenderStack f_01229118 = (FontRenderStack)new FontRenderStack(C0231.f_b126585b).setScaled(false);
   public static final C0074 f_d3f3801b = new C0074();
   private final ConcurrentHashMap<C0087, C0075[]> f_b876c3d0 = new ConcurrentHashMap<>();

   public C0074() {
   }

   public void m_d6ac7420(boolean var1) {
      this.f_b876c3d0.clear();

      for (C0087 var5 : C0087.values()) {
         this.f_b876c3d0.put(var5, C0289.f_85a7343f.m_918b7b9e().filter(var0 -> var0 instanceof C0075).map(C0075.class::cast).peek(var1x -> {
            if (var1) {
               var1x.m_083b6d08();
            }
         }).filter(var1x -> var1x.m_a7c622af() == var5).sorted(Comparator.comparingInt(C0075::m_36ffc578)).toArray(C0075[]::new));
      }
   }

   @EventHandler
   public void m_270a7d18(EventWorldLoad var1) {
      this.m_d6ac7420(true);
   }

   @EventHandler
   public void m_5d3a4d80(EventMatrixRender var1) {
      if (!C0289.m_c3a8b502(C0297.class).m_275ab222()) {
         f_01229118.begin();

         for (C0087 var3 : this.f_b876c3d0.keySet()) {
            if (!var3.m_89e0519f() || !(Boolean)GameSetting.DEBUG_INFO.get()) {
               var3.m_9fb2cb0e(this.f_b876c3d0.get(var3));
            }
         }

         f_01229118.end();
      }
   }

   public static FontRenderStack m_d996e5c5() {
      return f_01229118;
   }

   public ConcurrentHashMap<C0087, C0075[]> m_b87e9d34() {
      return this.f_b876c3d0;
   }
}
