package me.deftware.aristois.recovered;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.registry.IRegistry;

public class C0205<T> extends C0219<T> {
   private IRegistry<T, ?> f_29e3593a;
   protected String f_0463c2a9 = "";
   protected boolean f_f118532e = false;
   protected Collection<T> f_34a16115;
   protected Function<T, String> f_e5753bb7;

   public C0205(Class<T> var1, IRegistry<T, ?> var2, Function<T, String> var3) {
      super(var1, null, false);
      this.f_e5753bb7 = var3;
      this.f_29e3593a = var2;
      this.m_252ea052();
   }

   public void m_252ea052() {
      this.m_445245ba().clear();
      this.f_29e3593a
         .stream()
         .filter(var1 -> this.f_34a16115 != null && this.f_f118532e ? this.f_34a16115.contains(var1) : true)
         .filter(var1 -> this.m_ce2e2ca4((T)var1, this.f_0463c2a9))
         .forEach(var1 -> this.m_445245ba().add(var1));
   }

   public synchronized void m_f6813196(String var1) {
      this.f_0463c2a9 = var1;
      this.m_252ea052();
   }

   public boolean m_ce2e2ca4(T var1, String var2) {
      String var3 = this.m_a9d2b92c().apply((T)var1);
      return !var2.isEmpty() && !var3.isEmpty()
         ? var3.toLowerCase().replace(C0252.bootstrap<"get",70>(), "").contains(var2.toLowerCase().replace(C0252.bootstrap<"get",70>(), ""))
         : true;
   }

   public void m_030469ce(IRegistry<T, ?> var1) {
      this.f_29e3593a = var1;
   }

   public void m_a457816d(boolean var1) {
      this.f_f118532e = var1;
   }

   public void m_af068cf6(Collection<T> var1) {
      this.f_34a16115 = var1;
   }

   public void m_88b3b62c(Function<T, String> var1) {
      this.f_e5753bb7 = var1;
   }

   public IRegistry<T, ?> m_a4f46478() {
      return this.f_29e3593a;
   }

   public String m_48fa952e() {
      return this.f_0463c2a9;
   }

   public boolean m_841de62f() {
      return this.f_f118532e;
   }

   public Collection<T> m_0f5d5285() {
      return this.f_34a16115;
   }

   public Function<T, String> m_a9d2b92c() {
      return this.f_e5753bb7;
   }

   public static class anonymouscatch<T> extends C0205<T> {
      private final List<T> f_68efccfd;

      public anonymouscatch(Class<T> var1, List<T> var2, Function<T, String> var3) {
         super(var1, null, var3);
         this.f_68efccfd = var2;
         this.m_558bb004();
      }

      public void m_558bb004() {
         if (this.f_68efccfd != null) {
            this.m_3a478d20().clear();
            this.f_68efccfd
               .stream()
               .filter(var1 -> this.f_fb473269 != null && this.f_64077543 ? this.f_fb473269.contains(var1) : true)
               .filter(var1 -> this.m_5a7831a8(var1, this.f_abf11688))
               .forEach(var1 -> this.m_3a478d20().add(var1));
         }
      }
   }
}
