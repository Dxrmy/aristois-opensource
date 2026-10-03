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

   private static Collection<Field> m_2e2c9919(Class<?> var0) {
      HashMap var1 = new HashMap();

      while (var0 != null) {
         for (Field var5 : var0.getDeclaredFields()) {
            if (var5.isAnnotationPresent(C0098.class) && C0114.bootstrap<"call",0,1>(var5)) {
               C0098 var6 = var5.getAnnotation(C0098.class);
               String var7 = var6.value().toLowerCase();
               if (var1.containsKey(var7)) {
                  throw new RuntimeException(C0252.bootstrap<"get",12884901986>() + var6.value());
               }

               var5.setAccessible(true);
               var1.put(var7, var5);
            }
         }

         var0 = var0.getSuperclass();
      }

      return var1.values();
   }

   public static List<C0094<?>> m_0c53b9f2(Object var0) {
      ArrayList var1 = new ArrayList();

      for (Field var3 : C0114.bootstrap<"call",1,1>(var0.getClass())) {
         try {
            Class var4 = C0114.bootstrap<"call",2,1>(var3, var0);
            C0112 var5 = C0088.f_748211cf.m_68585728(var4).orElseThrow(() -> new RuntimeException(C0252.bootstrap<"get",12884901987>() + var4));
            C0094 var6 = var5.m_4a9e8100(var3, var0);
            var1.add(var6);
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }

      return var1;
   }

   private static <T extends AbstractMod> void m_6f177f0e(T var0, C0204<C0094<?>> var1) {
      var0.getFields().stream().filter(C0094::m_4cebb9f7).filter(var0x -> !var0x.m_d1f323bd()).forEach(var1x -> {
         try {
            var1.m_d63b5d76(var1x);
         } catch (Throwable var3) {
            var3.printStackTrace();
         }
      });
   }

   public static <T extends AbstractMod> void m_03614e5a(T var0) {
      C0114.bootstrap<"call",3,1>(var0, var1 -> {
         String var2 = var1.m_087ac7a8();
         JsonElement var3 = var1.m_fb21cd76().m_ef56e17c(var1);
         var0.getModProps().add(var2, var3);
      });
   }

   public static <T extends AbstractMod> void m_3e2b7ec9(T var0) {
      C0114.bootstrap<"call",0,1>(var0, var1 -> {
         String var2 = var1.m_087ac7a8();
         if (var0.getModProps().has(var2)) {
            JsonElement var3 = var0.getModProps().get(var2);
            var1.m_fb21cd76().m_b653ae1c(var3, var1, var0);
         } else if (var1.m_85532ff5() && var0.isEnabled()) {
            var1.m_dfb23874(var1.m_48b16e97(), true);
         }
      });
   }
}
