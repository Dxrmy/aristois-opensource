package me.deftware.aristois.recovered;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0095 {
   public C0095() {
   }

   public static boolean m_22ad6203(Object var0) {
      boolean var1 = true;
      C0101 var2 = m_0ec79f25(C0101.class, var0);
      if (var2 != null) {
         if (var2.minimumProtocol() != C0213.f_c90e7d2e) {
            var1 = Minecraft.getMinecraftProtocolVersion() >= var2.minimumProtocol().m_037208cc();
         }

         if (var2.maximumProtocol() != C0213.f_c90e7d2e && var1) {
            var1 = Minecraft.getMinecraftProtocolVersion() <= var2.maximumProtocol().m_037208cc();
         }
      }

      return var1;
   }

   public static <T extends Annotation> T m_0ec79f25(Class<T> var0, Object var1) {
      if (var1.getClass() == Field.class) {
         return ((Field)var1).isAnnotationPresent(var0) ? ((Field)var1).getAnnotation(var0) : null;
      } else {
         return ((Class)var1).isAnnotationPresent(var0) ? ((Class)var1).getAnnotation(var0) : null;
      }
   }
}
