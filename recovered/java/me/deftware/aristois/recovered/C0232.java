package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.render.batching.QuadRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import org.lwjgl.opengl.GL11;

public class C0232 {
   protected final RenderStack<?> f_b8f6ccc2;
   private final boolean f_385b9d47;

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
      this.f_385b9d47 = var1;
      this.f_b8f6ccc2 = var2;
   }

   public C0232 m_3327f4f8() {
      GL11.glClear(1024);
      GL11.glEnable(2960);
      GL11.glColorMask(false, false, false, false);
      GL11.glDepthMask(false);
      GL11.glStencilFunc(519, 1, 255);
      GL11.glStencilOp(7680, 7680, 7681);
      GL11.glStencilMask(255);
      this.f_b8f6ccc2.glColor(Color.white);
      if (this.f_385b9d47) {
         this.f_b8f6ccc2.begin();
      }

      return this;
   }

   public C0232 m_382cb6e3(C0165 var1) {
      if (this.f_b8f6ccc2 instanceof QuadRenderStack) {
         var1.m_4bc1a596((QuadRenderStack)this.f_b8f6ccc2);
      }

      return this;
   }

   public C0232 m_80099ca4() {
      this.f_b8f6ccc2.end();
      GL11.glColorMask(true, true, true, true);
      GL11.glDepthMask(true);
      GL11.glStencilFunc(514, 1, 255);
      return this;
   }

   public void m_0e265701() {
      GL11.glDisable(2960);
   }

   public RenderStack<?> m_2ee7cdf6() {
      return this.f_b8f6ccc2;
   }
}
