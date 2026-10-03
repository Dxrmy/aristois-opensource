package me.deftware.aristois.recovered;

import java.util.EnumSet;
import java.util.function.Supplier;

public class C0106<T> implements C0105<T>, Supplier<T> {
   private T f_0ecdad4a;
   private Supplier<Boolean> f_c357080b = () -> true;

   public C0106(T var1) {
      this.f_0ecdad4a = (T)var1;
   }

   @SafeVarargs
   public final <E extends Enum<E>> C0106<T> m_2d6ca2bd(C0102<E> var1, E... var2) {
      EnumSet var3 = EnumSet.of((E)var2[0], (E[])var2);
      this.f_c357080b = () -> var3.contains(var1.m_284992ec());
      return this;
   }

   @SafeVarargs
   public final <E extends Enum<E>> C0106<T> m_cb9291a5(C0102<E> var1, E... var2) {
      EnumSet var3 = EnumSet.of((E)var2[0], (E[])var2);
      this.f_c357080b = () -> !var3.contains(var1.m_284992ec());
      return this;
   }

   @Override
   public T m_50ca8f08() {
      return this.f_0ecdad4a;
   }

   @Override
   public T get() {
      return this.f_0ecdad4a;
   }

   @Override
   public void m_a32b61ee(Object var1) {
      this.f_0ecdad4a = (T)var1;
   }

   @Override
   public boolean m_e0f7c666() {
      return true;
   }

   @Override
   public boolean m_9362a920() {
      return this.f_c357080b.get();
   }
}
