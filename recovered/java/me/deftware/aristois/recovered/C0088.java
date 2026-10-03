package me.deftware.aristois.recovered;

import com.google.common.collect.Lists;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import me.deftware.client.framework.gui.GuiScreen;

public class C0088 {
   public static final C0088 f_3316b995 = new C0088();
   private final List<C0112<?>> f_d8fac7d9 = Lists.newArrayList(
      new C0112[]{
         new C0110(), new C0118(), new C0109(), new C0108(), new C0120(), new C0116(), new C0113(), new C0111(), new C0107(), new C0119(), new C0117()
      }
   );
   private final List<C0131<?>> f_71c041a2 = Lists.newArrayList(
      new C0131[]{new C0132(), new C0123(), new C0124(), new C0129(), new C0128(), new C0127(), new C0126(), new C0130(), new C0122()}
   );

   private C0088() {
      for (C0112 var2 : this.f_d8fac7d9) {
         C0131 var3 = var2.m_99099edb();
         if (var3 != null) {
            this.f_71c041a2.add(var3);
         }
      }
   }

   public <T> void m_f05a6806(C0131<T> var1) {
      this.f_71c041a2.add(var1);
   }

   public <T> void m_3857490e(C0112<T> var1) {
      this.f_d8fac7d9.add(var1);
   }

   public Optional<C0112<?>> m_1c7dea1e(Class<?> var1) {
      return this.f_d8fac7d9.stream().filter(var1x -> var1x.m_210285cc(var1)).findFirst();
   }

   public static Class<?> m_128fcd20(Field var0, Object var1) throws Exception {
      Class var2 = var0.getType();
      if (m_b74c7673(var2, C0105.class)) {
         C0105 var3 = (C0105)var0.get(var1);
         var2 = var3.m_50ca8f08().getClass();
         if (var3.m_50ca8f08() instanceof GuiScreen) {
            var2 = GuiScreen.class;
         }
      }

      return var2;
   }

   public static boolean m_b74c7673(Class<?> var0, Class<?> var1) {
      return Arrays.asList(var0.getInterfaces()).contains(var1);
   }

   public List<C0112<?>> m_350b5ae0() {
      return this.f_d8fac7d9;
   }

   public List<C0131<?>> m_ed46fa58() {
      return this.f_71c041a2;
   }
}
