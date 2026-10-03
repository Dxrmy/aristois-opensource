package me.deftware.aristois.recovered;

import me.deftware.client.framework.render.batching.RenderStack;

public class C0170 {
   private final C0170.anonymousthis f_bfa52464;

   public C0170(C0170.anonymousthis var1) {
      this.f_bfa52464 = var1;
   }

   public void m_1058ed9a() {
      if (this.f_bfa52464 != C0170.anonymousthis.f_d3168abd) {
         RenderStack.reloadCustomMatrix();
      }
   }

   public void m_b728afce() {
      if (this.f_bfa52464 != C0170.anonymousthis.f_d3168abd) {
         RenderStack.reloadMinecraftMatrix();
      }
   }

   public boolean m_89e0519f() {
      return this.f_bfa52464 == C0170.anonymousthis.f_8f6bc807;
   }

   public C0170.anonymousthis m_d8379fac() {
      return this.f_bfa52464;
   }

   public static enum anonymousthis {
      f_f2dd6320,
      f_d3168abd,
      f_8f6bc807;

      private anonymousthis() {
      }
   }
}
