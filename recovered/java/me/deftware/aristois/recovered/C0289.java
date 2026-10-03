package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.modules.AbstractMod;

public class C0289 implements Runnable {
   public static final C0289 f_85a7343f = new C0289();
   private String f_bab019ec = "";
   private final Map<Class<?>, AbstractMod> f_99d5fc28 = new ConcurrentHashMap<>();

   public C0289() {
   }

   public int m_5b3d3148() {
      return this.f_99d5fc28.size();
   }

   public void m_b728afce() {
      this.f_99d5fc28.clear();
   }

   public Stream<AbstractMod> m_918b7b9e() {
      return this.f_99d5fc28.values().stream();
   }

   public static <T extends AbstractMod> T m_c3a8b502(Class<T> var0) {
      if (!f_85a7343f.f_99d5fc28.containsKey(var0)) {
         throw new RuntimeException(C0255.m_9e27f038() + var0.getSimpleName());
      } else {
         return (T)f_85a7343f.f_99d5fc28.get(var0);
      }
   }

   public static <T extends AbstractMod> boolean m_5caae0c3(Class<T> var0) {
      AbstractMod var1 = m_c3a8b502(var0);
      return var1 == null ? false : var1.isEnabled();
   }

   public static boolean m_81a25567(Class<? extends AbstractMod> var0) {
      return f_85a7343f.f_99d5fc28.containsKey(var0);
   }

   public static <T extends AbstractMod> void m_24841a60(Class<T> var0, Consumer<T> var1) {
      if (m_81a25567(var0) && m_5caae0c3(var0)) {
         var1.accept(m_c3a8b502(var0));
      }
   }

   public static <T extends AbstractMod> void m_f76fd48e(Class<T> var0, Runnable var1) {
      boolean var2 = m_5caae0c3(var0);
      if (var2) {
         m_c3a8b502(var0).toggle();
      }

      var1.run();
      if (var2) {
         m_c3a8b502(var0).toggle();
      }
   }

   @SafeVarargs
   public final void m_d3f1300b(Class<? extends AbstractMod>... var1) {
      List var2 = Arrays.asList(var1);
      this.m_918b7b9e().filter(var1x -> !var2.contains(var1x.getClass())).filter(AbstractMod::isEnabled).forEach(AbstractMod::toggle);
   }

   public void m_7a6da287(C0307<?> var1) {
      this.m_918b7b9e()
         .filter(var1x -> var1x instanceof C0307 && var1x != var1)
         .filter(var0 -> !(var0 instanceof C0302))
         .filter(AbstractMod::isEnabled)
         .forEach(AbstractMod::toggle);
   }

   @SafeVarargs
   public final void m_41c999d6(Class<? extends AbstractMod>... var1) {
      for (Class var5 : var1) {
         if (this.f_99d5fc28.containsKey(var5)) {
            throw new RuntimeException(C0255.m_af41331f() + var5.getSimpleName());
         }

         try {
            if (C0095.m_22ad6203(var5)) {
               AbstractMod var6 = (AbstractMod)var5.getDeclaredConstructor().newInstance();
               this.m_1a101045(var5, var6, C0091.m_7dd37260(var6));
            } else {
               System.out.println(C0255.m_f257bcca() + var5.getName() + C0255.m_d9b37a36());
            }
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }
   }

   public final void m_1a101045(Class<?> var1, AbstractMod var2, List<C0094<?>> var3) {
      this.f_99d5fc28.put(var1, var2);
      var2.getFields().addAll(var3);
      var2.load();
      if (var2.isEnabled()) {
         var2.onEnable();
      }

      var2.onPostLoad();
   }

   @Override
   public void run() {
      this.m_41c999d6(C0408.class);
      this.m_41c999d6(C0405.class);
      this.m_41c999d6(C0410.class);
      this.m_41c999d6(C0413.class);
      this.m_41c999d6(C0409.class);
      this.m_41c999d6(C0399.class);
      this.m_41c999d6(C0400.class);
      this.m_41c999d6(C0402.class);
      this.m_41c999d6(C0404.class);
      this.m_41c999d6(C0412.class);
      this.m_41c999d6(C0401.class);
      this.m_41c999d6(C0403.class);
      this.m_41c999d6(C0415.class);
      this.m_41c999d6(C0407.class);
      this.m_41c999d6(C0411.class);
      this.m_41c999d6(C0406.class);
      this.m_41c999d6(C0414.class);
      this.m_41c999d6(C0416.class);
      this.m_41c999d6(C0302.class);
      this.m_41c999d6(C0309.class);
      this.m_41c999d6(C0298.class);
      this.m_41c999d6(C0304.class);
      this.m_41c999d6(C0303.class);
      this.m_41c999d6(C0306.class);
      this.m_41c999d6(C0310.class);
      this.m_41c999d6(C0311.class);
      this.m_41c999d6(C0308.class);
      this.m_41c999d6(C0305.class);
      this.m_41c999d6(C0417.class);
      this.m_41c999d6(C0300.class);
      this.m_41c999d6(C0299.class);
      this.m_41c999d6(C0293.class);
      this.m_41c999d6(C0291.class);
      this.m_41c999d6(C0322.class);
      this.m_41c999d6(C0418.class);
      this.m_41c999d6(C0419.class);
      this.m_41c999d6(C0431.class);
      this.m_41c999d6(C0386.class);
      this.m_41c999d6(C0380.class);
      this.m_41c999d6(C0381.class);
      this.m_41c999d6(C0385.class);
      this.m_41c999d6(C0377.class);
      this.m_41c999d6(C0391.class);
      this.m_41c999d6(C0371.class);
      this.m_41c999d6(C0375.class);
      this.m_41c999d6(C0376.class);
      this.m_41c999d6(C0373.class);
      this.m_41c999d6(C0397.class);
      this.m_41c999d6(C0378.class);
      this.m_41c999d6(C0379.class);
      this.m_41c999d6(C0395.class);
      this.m_41c999d6(C0382.class);
      this.m_41c999d6(C0370.class);
      this.m_41c999d6(C0374.class);
      this.m_41c999d6(C0393.class);
      this.m_41c999d6(C0372.class);
      this.m_41c999d6(C0398.class);
      this.m_41c999d6(C0396.class);
      this.m_41c999d6(C0383.class);
      this.m_41c999d6(C0389.class);
      this.m_41c999d6(C0392.class);
      this.m_41c999d6(C0394.class);
      this.m_41c999d6(C0388.class);
      this.m_41c999d6(C0390.class);
      this.m_41c999d6(C0387.class);
      this.m_41c999d6(C0384.class);
      this.m_41c999d6(C0340.class);
      this.m_41c999d6(C0348.class);
      this.m_41c999d6(C0347.class);
      this.m_41c999d6(C0344.class);
      this.m_41c999d6(C0349.class);
      this.m_41c999d6(C0341.class);
      this.m_41c999d6(C0354.class);
      this.m_41c999d6(C0338.class);
      this.m_41c999d6(C0339.class);
      this.m_41c999d6(C0355.class);
      this.m_41c999d6(C0350.class);
      this.m_41c999d6(C0353.class);
      this.m_41c999d6(C0346.class);
      this.m_41c999d6(C0356.class);
      this.m_41c999d6(C0343.class);
      this.m_41c999d6(C0345.class);
      this.m_41c999d6(C0352.class);
      this.m_41c999d6(C0342.class);
      this.m_41c999d6(C0314.class);
      this.m_41c999d6(C0315.class);
      this.m_41c999d6(C0292.class);
      this.m_41c999d6(C0323.class);
      this.m_41c999d6(C0318.class);
      this.m_41c999d6(C0324.class);
      this.m_41c999d6(C0316.class);
      this.m_41c999d6(C0317.class);
      this.m_41c999d6(C0312.class);
      this.m_41c999d6(C0330.class);
      this.m_41c999d6(C0320.class);
      this.m_41c999d6(C0321.class);
      this.m_41c999d6(C0325.class);
      this.m_41c999d6(C0337.class);
      this.m_41c999d6(C0329.class);
      this.m_41c999d6(C0333.class);
      this.m_41c999d6(C0313.class);
      this.m_41c999d6(C0334.class);
      this.m_41c999d6(C0335.class);
      this.m_41c999d6(C0327.class);
      this.m_41c999d6(C0326.class);
      this.m_41c999d6(C0332.class);
      this.m_41c999d6(C0331.class);
      this.m_41c999d6(C0328.class);
      this.m_41c999d6(C0336.class);
      this.m_41c999d6(C0351.class);
      this.m_41c999d6(C0361.class);
      this.m_41c999d6(C0365.class);
      this.m_41c999d6(C0367.class);
      this.m_41c999d6(C0363.class);
      this.m_41c999d6(C0362.class);
      this.m_41c999d6(C0364.class);
      this.m_41c999d6(C0359.class);
      this.m_41c999d6(C0357.class);
      this.m_41c999d6(C0360.class);
      this.m_41c999d6(C0366.class);
      this.m_41c999d6(C0358.class);
      this.m_41c999d6(C0368.class);
      this.m_41c999d6(C0369.class);
      this.m_41c999d6(C0076.class);
      this.m_41c999d6(C0077.class);
      this.m_41c999d6(C0081.class);
      this.m_41c999d6(C0079.class);
      this.m_41c999d6(C0078.class);
      if (!C0241.f_f6e3d33b) {
         this.m_41c999d6(C0080.class);
      }
   }

   public void m_41e83f88() {
      try {
         Main.class.getClassLoader().loadClass(this.f_bab019ec).getDeclaredConstructor().newInstance();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      if (!m_81a25567(C0080.class)) {
         this.m_41c999d6(C0080.class);
      }
   }

   public void m_256015fc(String var1) {
      this.f_bab019ec = var1;
   }

   public Map<Class<?>, AbstractMod> m_4cdd6a26() {
      return this.f_99d5fc28;
   }
}
