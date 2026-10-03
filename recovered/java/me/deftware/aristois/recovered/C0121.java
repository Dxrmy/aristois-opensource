package me.deftware.aristois.recovered;

import java.util.List;
import java.util.function.Function;

public enum C0121 implements C0102.anonymousthis {
   f_56c93dc6(C0266.m_9bf0a29a()),
   f_b664d6a2(C0266.m_65c7e6e6()),
   f_59a9163f(C0266.m_03430357());

   private final String[] f_f3c00fba;

   private C0121(String... var3) {
      this.f_f3c00fba = var3;
   }

   public <T> boolean m_d65a9459(T var1, List<T> var2) {
      return this.m_26101566(var1, var2::contains);
   }

   public <T> boolean m_26101566(T var1, Function<T, Boolean> var2) {
      if (this == f_b664d6a2) {
         return (Boolean)var2.apply(var1);
      } else {
         return this == f_59a9163f ? !(Boolean)var2.apply(var1) : true;
      }
   }

   @Override
   public String[] m_8e56a473() {
      return this.f_f3c00fba;
   }
}
