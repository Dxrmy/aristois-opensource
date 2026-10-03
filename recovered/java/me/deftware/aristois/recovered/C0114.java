package me.deftware.aristois.recovered;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles.Lookup;

public static class C0114 {
   private static Object[] a = new Object[1];

   public static CallSite bootstrap(Lookup var0, String var1, MethodType var2, long var3, int var5) {
      int var6 = (int)((var3 & -4294967296L) >>> 32);
      int var7 = (int)(var3 & 4294967295L);
      return ((C0115)a[var6]).m_6e26e261(var0, var2, var7, var5);
   }

   static {
      a[0] = new C0115$anonymous0();
   }
}
