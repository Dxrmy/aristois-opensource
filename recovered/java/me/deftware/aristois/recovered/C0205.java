package me.deftware.aristois.recovered;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import me.deftware.client.framework.registry.IRegistry;

public class C0205<T> extends C0219<T> {
   private IRegistry<T, ?> f_80cdc1f0;
   protected String f_c4df149a = "";
   protected boolean f_09795f63 = false;
   protected Collection<T> f_82973d40;
   protected Function<T, String> f_cd24ae1c;

   public C0205(Class<T> var1, IRegistry<T, ?> var2, Function<T, String> var3) {
      super(var1, null, false);
      this.f_cd24ae1c = var3;
      this.f_80cdc1f0 = var2;
      this.m_37118aff();
   }

   public void m_37118aff() {
      this.m_93a86be0().clear();
      this.f_80cdc1f0
         .stream()
         .filter(var1 -> this.f_82973d40 != null && this.f_09795f63 ? this.f_82973d40.contains(var1) : true)
         .filter(var1 -> this.m_65ad83bf((T)var1, this.f_c4df149a))
         .forEach(var1 -> this.m_93a86be0().add((T)var1));
   }

   public synchronized void m_256015fc(String var1) {
      this.f_c4df149a = var1;
      this.m_37118aff();
   }

   public boolean m_65ad83bf(T var1, String var2) {
      String var3 = this.m_ed06f79f().apply((T)var1);
      return !var2.isEmpty() && !var3.isEmpty()
         ? var3.toLowerCase().replace(C0257.m_593ecbab(), "").contains(var2.toLowerCase().replace(C0257.m_593ecbab(), ""))
         : true;
   }

   public void m_ae795f13(IRegistry<T, ?> var1) {
      this.f_80cdc1f0 = var1;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_09795f63 = var1;
   }

   public void m_21736e90(Collection<T> var1) {
      this.f_82973d40 = var1;
   }

   public void m_b50f8578(Function<T, String> var1) {
      this.f_cd24ae1c = var1;
   }

   public IRegistry<T, ?> m_e95d4335() {
      return this.f_80cdc1f0;
   }

   public String m_c254a253() {
      return this.f_c4df149a;
   }

   public boolean m_5d86ac37() {
      return this.f_09795f63;
   }

   public Collection<T> m_6d074008() {
      return this.f_82973d40;
   }

   public Function<T, String> m_ed06f79f() {
      return this.f_cd24ae1c;
   }

   public static class anonymouscatch<T> extends C0205<T> {
      private final List<T> f_e27f9493;

      public anonymouscatch(Class<T> var1, List<T> var2, Function<T, String> var3) {
         super(var1, null, var3);
         this.f_e27f9493 = var2;
         this.m_37118aff();
      }

      @Override
      public void m_37118aff() {
         if (this.f_e27f9493 != null) {
            this.m_93a86be0().clear();
            this.f_e27f9493
               .stream()
               .filter(var1 -> this.f_82973d40 != null && this.f_09795f63 ? this.f_82973d40.contains(var1) : true)
               .filter(var1 -> this.m_65ad83bf((T)var1, this.f_c4df149a))
               .forEach(var1 -> this.m_93a86be0().add((T)var1));
         }
      }
   }
}
