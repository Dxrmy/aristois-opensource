package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import me.deftware.aristois.modules.AbstractMod;

public final class C0091 {
   public C0091() {
   }

   private static Collection<Field> m_d0e8a3a7(Class<?> var0) {
      HashMap var1 = new HashMap();

      while (var0 != null) {
         for (Field var5 : var0.getDeclaredFields()) {
            if (var5.isAnnotationPresent(C0098.class) && C0095.m_22ad6203(var5)) {
               C0098 var6 = var5.getAnnotation(C0098.class);
               String var7 = var6.value().toLowerCase();
               if (var1.containsKey(var7)) {
                  throw new RuntimeException(C0266.m_ec329d2e() + var6.value());
               }

               var5.setAccessible(true);
               var1.put(var7, var5);
            }
         }

         var0 = var0.getSuperclass();
      }

      return var1.values();
   }

   public static List<C0094<?>> m_7dd37260(Object var0) {
      ArrayList var1 = new ArrayList();

      for (Field var3 : m_d0e8a3a7(var0.getClass())) {
         try {
            Class var4 = C0088.m_128fcd20(var3, var0);
            C0112 var5 = C0088.f_3316b995.m_1c7dea1e(var4).orElseThrow(() -> new RuntimeException(C0266.m_edf5fb69() + var4));
            C0094 var6 = var5.m_6ba94131(var3, var0);
            var1.add(var6);
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }

      return var1;
   }

   private static <T extends AbstractMod> void m_605933ce(T var0, C0204<C0094<?>> var1) {
      var0.getFields().stream().filter(C0094::m_e0f7c666).filter(var0x -> !var0x.m_e606d819()).forEach(var1x -> {
         try {
            var1.m_360c09fa(var1x);
         } catch (Throwable var3) {
            var3.printStackTrace();
         }
      });
   }

   public static <T extends AbstractMod> void m_5e69f832(T var0) {
      m_605933ce(var0, var1 -> {
         String var2 = var1.m_c254a253();
         JsonElement var3 = var1.m_a4e51be1().m_695e59d3(var1);
         var0.getModProps().add(var2, var3);
      });
   }

   public static <T extends AbstractMod> void m_6fea6797(T var0) {
      m_605933ce(var0, var1 -> {
         String var2 = var1.m_c254a253();
         if (var0.getModProps().has(var2)) {
            JsonElement var3 = var0.getModProps().get(var2);
            var1.m_a4e51be1().m_6588d9db(var3, var1, var0);
         } else if (var1.m_89e0519f() && var0.isEnabled()) {
            var1.m_9660fce8(var1.m_50ca8f08(), true);
         }
      });
   }
}
