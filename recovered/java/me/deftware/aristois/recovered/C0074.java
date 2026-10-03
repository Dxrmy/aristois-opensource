package me.deftware.aristois.recovered;

import java.util.concurrent.ConcurrentHashMap;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventMatrixRender;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.minecraft.GameSetting;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0074 extends EventListener {
   private static final FontRenderStack f_386a6d0b = (FontRenderStack)new FontRenderStack(C0231.f_9c96dbc0).setScaled(false);
   public static final C0074 f_c9f3a771 = new C0074();
   private final ConcurrentHashMap<C0087, C0075[]> f_8239e7ce = new ConcurrentHashMap<>();

   public C0074() {
   }

   public void m_2244f384(boolean var1) {
      this.f_8239e7ce.clear();

      for (C0087 var5 : C0114.bootstrap<"call",0,1>()) {
         this.f_8239e7ce.put(var5, C0289.f_c22b8d7e.m_ea73e1f0().filter(var0 -> var0 instanceof C0075).map(C0075.class::cast).peek(var1x -> {
            if (var1) {
               var1x.m_90da69be();
            }
         }).filter(var1x -> var1x.m_a1d8aae5() == var5).sorted(C0114.bootstrap<"call",1,1>(C0075::m_d6a53a66)).toArray(C0075[]::new));
      }
   }

   @EventHandler
   public void m_e4886f57(EventWorldLoad var1) {
      this.m_2244f384(true);
   }

   @EventHandler
   public void m_8db7cdb1(EventMatrixRender var1) {
      if (!((C0297)C0114.bootstrap<"call",2,1>(C0297.class)).m_7458b21f()) {
         f_386a6d0b.begin();

         for (C0087 var3 : this.f_8239e7ce.keySet()) {
            if (!var3.m_45dc3fbf() || !(Boolean)GameSetting.DEBUG_INFO.get()) {
               var3.m_7feef65d(this.f_8239e7ce.get(var3));
            }
         }

         f_386a6d0b.end();
      }
   }

   public static FontRenderStack m_96268ae2() {
      return f_386a6d0b;
   }

   public ConcurrentHashMap<C0087, C0075[]> m_73966da3() {
      return this.f_8239e7ce;
   }
}
