package me.deftware.aristois.recovered;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class C0095 {
   public C0095() {
   }

   public static boolean m_cf020782(Object var0) {
      boolean var1 = true;
      C0101 var2 = (C0101)C0114.bootstrap<"call",0,1>(C0101.class, var0);
      if (var2 != null) {
         if (var2.minimumProtocol() != C0213.f_a2082a49) {
            var1 = C0114.bootstrap<"call",1,1>() >= var2.minimumProtocol().m_f3975c5a();
         }

         if (var2.maximumProtocol() != C0213.f_a2082a49 && var1) {
            var1 = C0114.bootstrap<"call",1,1>() <= var2.maximumProtocol().m_f3975c5a();
         }
      }

      return var1;
   }

   public static <T extends Annotation> T m_e06ff265(Class<T> var0, Object var1) {
      if (var1.getClass() == Field.class) {
         return ((Field)var1).isAnnotationPresent(var0) ? ((Field)var1).getAnnotation(var0) : null;
      } else {
         return ((Class)var1).isAnnotationPresent(var0) ? ((Class)var1).getAnnotation(var0) : null;
      }
   }
}
