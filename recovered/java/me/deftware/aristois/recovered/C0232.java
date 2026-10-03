package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;

public class C0232 {
   protected final RenderStack<?> f_81770589;
   private final boolean f_7110ed55;

   public C0232() {
      this(true, new QuadRenderStack());
   }

   public C0232(boolean var1) {
      this(var1, new QuadRenderStack());
   }

   public C0232(RenderStack<?> var1) {
      this(true, var1);
   }

   public C0232(boolean var1, RenderStack<?> var2) {
      this.f_7110ed55 = var1;
      this.f_81770589 = var2;
   }

   public C0232 m_0396ff8d() {
      C0114.bootstrap<"call",0,1>(1024);
      C0114.bootstrap<"call",1,1>(2960);
      C0114.bootstrap<"call",2,1>(false, false, false, false);
      C0114.bootstrap<"call",3,1>(false);
      C0114.bootstrap<"call",4,1>(519, 1, 255);
      C0114.bootstrap<"call",5,1>(7680, 7680, 7681);
      C0114.bootstrap<"call",6,1>(255);
      this.f_81770589.glColor(Color.white);
      if (this.f_7110ed55) {
         this.f_81770589.begin();
      }

      return this;
   }

   public C0232 m_315ef949(C0165 var1) {
      if (this.f_81770589 instanceof QuadRenderStack) {
         var1.m_79e11f68((QuadRenderStack)this.f_81770589);
      }

      return this;
   }

   public C0232 m_31bf50f2() {
      this.f_81770589.end();
      C0114.bootstrap<"call",0,1>(true, true, true, true);
      C0114.bootstrap<"call",1,1>(true);
      C0114.bootstrap<"call",2,1>(514, 1, 255);
      return this;
   }

   public void m_e56713e3() {
      C0114.bootstrap<"call",0,1>(2960);
   }

   public RenderStack<?> m_ac55c0f8() {
      return this.f_81770589;
   }
}
