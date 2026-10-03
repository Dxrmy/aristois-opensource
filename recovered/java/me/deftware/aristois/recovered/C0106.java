package me.deftware.aristois.recovered;

import java.util.EnumSet;
import java.util.function.Supplier;

public class C0106<T> implements C0105<T>, Supplier<T> {
   private T f_67249887;
   private Supplier<Boolean> f_67170b41 = () -> C0114.bootstrap<"call",1,1>(true);

   public C0106(T var1) {
      this.f_67249887 = (T)var1;
   }

   @SafeVarargs
   public final <E extends Enum<E>> C0106<T> m_10caee7d(C0102<E> var1, E... var2) {
      EnumSet var3 = C0114.bootstrap<"call",0,1>(var2[0], var2);
      this.f_67170b41 = () -> C0114.bootstrap<"call",1,1>(var3.contains(var1.m_e2691446()));
      return this;
   }

   @SafeVarargs
   public final <E extends Enum<E>> C0106<T> m_6da46a9c(C0102<E> var1, E... var2) {
      EnumSet var3 = C0114.bootstrap<"call",0,1>(var2[0], var2);
      this.f_67170b41 = () -> C0114.bootstrap<"call",1,1>(!var3.contains(var1.m_e2691446()));
      return this;
   }

   public T m_95af3326() {
      return this.f_67249887;
   }

   @Override
   public T get() {
      return this.f_67249887;
   }

   public void m_98ca55f1(Object var1) {
      this.f_67249887 = (T)var1;
   }

   public boolean m_4d9b139b() {
      return true;
   }

   public boolean m_fa0ec311() {
      return this.f_67170b41.get();
   }
}
