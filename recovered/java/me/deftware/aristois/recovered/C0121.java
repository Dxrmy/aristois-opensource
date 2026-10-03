package me.deftware.aristois.recovered;

import java.util.List;
import java.util.function.Function;

public enum C0121 implements C0102.anonymousthis {
   f_46c8b4fe(C0252.bootstrap<"get",12884901981>()),
   f_72159bd4(C0252.bootstrap<"get",12884901983>()),
   f_16945b62(C0252.bootstrap<"get",12884901985>());

   private final String[] f_595c8518;

   private C0121(String... var3) {
      this.f_595c8518 = var3;
   }

   public <T> boolean m_be55acd0(T var1, List<T> var2) {
      return this.m_4644494d(var1, var2::contains);
   }

   public <T> boolean m_4644494d(T var1, Function<T, Boolean> var2) {
      if (this == f_72159bd4) {
         return (Boolean)var2.apply(var1);
      } else {
         return this == f_16945b62 ? !(Boolean)var2.apply(var1) : true;
      }
   }

   public String[] m_dcec9c9d() {
      return this.f_595c8518;
   }
}
