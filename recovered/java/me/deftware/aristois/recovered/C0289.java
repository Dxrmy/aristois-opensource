package me.deftware.aristois.recovered;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.modules.AbstractMod;

public class C0289 implements Runnable {
   public static final C0289 f_c22b8d7e = new C0289();
   private String f_c27fe56c = "";
   private final Map<Class<?>, AbstractMod> f_ef831007 = new ConcurrentHashMap<>();

   public C0289() {
   }

   public int m_9e9fad2c() {
      return this.f_ef831007.size();
   }

   public void m_31a49508() {
      this.f_ef831007.clear();
   }

   public Stream<AbstractMod> m_ea73e1f0() {
      return this.f_ef831007.values().stream();
   }

   public static <T extends AbstractMod> T m_ded43506(Class<T> var0) {
      if (!f_c22b8d7e.f_ef831007.containsKey(var0)) {
         throw new RuntimeException(C0252.bootstrap<"get",51539607611>() + var0.getSimpleName());
      } else {
         return (T)f_c22b8d7e.f_ef831007.get(var0);
      }
   }

   public static <T extends AbstractMod> boolean m_c716a1b3(Class<T> var0) {
      AbstractMod var1 = C0114.bootstrap<"call",0,1>(var0);
      return var1 == null ? false : var1.isEnabled();
   }

   public static boolean m_e50f9180(Class<? extends AbstractMod> var0) {
      return f_c22b8d7e.f_ef831007.containsKey(var0);
   }

   public static <T extends AbstractMod> void m_3b970d5d(Class<T> var0, Consumer<T> var1) {
      if (C0114.bootstrap<"call",0,1>(var0) && C0114.bootstrap<"call",1,1>(var0)) {
         var1.accept(C0114.bootstrap<"call",2,1>(var0));
      }
   }

   public static <T extends AbstractMod> void m_f39f399c(Class<T> var0, Runnable var1) {
      boolean var2 = C0114.bootstrap<"call",1,1>(var0);
      if (var2) {
         C0114.bootstrap<"call",2,1>(var0).toggle();
      }

      var1.run();
      if (var2) {
         C0114.bootstrap<"call",2,1>(var0).toggle();
      }
   }

   @SafeVarargs
   public final void m_bfe8f4c0(Class<? extends AbstractMod>... var1) {
      List var2 = C0114.bootstrap<"call",3,1>(var1);
      this.m_ea73e1f0().filter(var1x -> !var2.contains(var1x.getClass())).filter(AbstractMod::isEnabled).forEach(AbstractMod::toggle);
   }

   public void m_6c8ca60d(C0307<?> var1) {
      this.m_ea73e1f0()
         .filter(var1x -> var1x instanceof C0307 && var1x != var1)
         .filter(var0 -> !(var0 instanceof C0302))
         .filter(AbstractMod::isEnabled)
         .forEach(AbstractMod::toggle);
   }

   @SafeVarargs
   public final void m_3409fa8f(Class<? extends AbstractMod>... var1) {
      for (Class var5 : var1) {
         if (this.f_ef831007.containsKey(var5)) {
            throw new RuntimeException(C0252.bootstrap<"get",51539607612>() + var5.getSimpleName());
         }

         try {
            if (C0114.bootstrap<"call",1,1>(var5)) {
               AbstractMod var6 = (AbstractMod)var5.getDeclaredConstructor().newInstance();
               this.m_86afdc4a(var5, var6, C0114.bootstrap<"call",2,1>(var6));
            } else {
               System.out.println(C0252.bootstrap<"get",51539607613>() + var5.getName() + C0252.bootstrap<"get",51539607614>());
            }
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }
   }

   public final void m_86afdc4a(Class<?> var1, AbstractMod var2, List<C0094<?>> var3) {
      this.f_ef831007.put(var1, var2);
      var2.getFields().addAll(var3);
      var2.load();
      if (var2.isEnabled()) {
         var2.onEnable();
      }

      var2.onPostLoad();
   }

   @Override
   public void run() {
      this.m_3409fa8f(C0408.class);
      this.m_3409fa8f(C0405.class);
      this.m_3409fa8f(C0410.class);
      this.m_3409fa8f(C0413.class);
      this.m_3409fa8f(C0409.class);
      this.m_3409fa8f(C0399.class);
      this.m_3409fa8f(C0400.class);
      this.m_3409fa8f(C0402.class);
      this.m_3409fa8f(C0404.class);
      this.m_3409fa8f(C0412.class);
      this.m_3409fa8f(C0401.class);
      this.m_3409fa8f(C0403.class);
      this.m_3409fa8f(C0415.class);
      this.m_3409fa8f(C0407.class);
      this.m_3409fa8f(C0411.class);
      this.m_3409fa8f(C0406.class);
      this.m_3409fa8f(C0414.class);
      this.m_3409fa8f(C0416.class);
      this.m_3409fa8f(C0302.class);
      this.m_3409fa8f(C0309.class);
      this.m_3409fa8f(C0298.class);
      this.m_3409fa8f(C0304.class);
      this.m_3409fa8f(C0303.class);
      this.m_3409fa8f(C0306.class);
      this.m_3409fa8f(C0310.class);
      this.m_3409fa8f(C0311.class);
      this.m_3409fa8f(C0308.class);
      this.m_3409fa8f(C0305.class);
      this.m_3409fa8f(C0417.class);
      this.m_3409fa8f(C0300.class);
      this.m_3409fa8f(C0299.class);
      this.m_3409fa8f(C0293.class);
      this.m_3409fa8f(C0291.class);
      this.m_3409fa8f(C0322.class);
      this.m_3409fa8f(C0418.class);
      this.m_3409fa8f(C0419.class);
      this.m_3409fa8f(C0431.class);
      this.m_3409fa8f(C0386.class);
      this.m_3409fa8f(C0380.class);
      this.m_3409fa8f(C0381.class);
      this.m_3409fa8f(C0385.class);
      this.m_3409fa8f(C0377.class);
      this.m_3409fa8f(C0391.class);
      this.m_3409fa8f(C0371.class);
      this.m_3409fa8f(C0375.class);
      this.m_3409fa8f(C0376.class);
      this.m_3409fa8f(C0373.class);
      this.m_3409fa8f(C0397.class);
      this.m_3409fa8f(C0378.class);
      this.m_3409fa8f(C0379.class);
      this.m_3409fa8f(C0395.class);
      this.m_3409fa8f(C0382.class);
      this.m_3409fa8f(C0370.class);
      this.m_3409fa8f(C0374.class);
      this.m_3409fa8f(C0393.class);
      this.m_3409fa8f(C0372.class);
      this.m_3409fa8f(C0398.class);
      this.m_3409fa8f(C0396.class);
      this.m_3409fa8f(C0383.class);
      this.m_3409fa8f(C0389.class);
      this.m_3409fa8f(C0392.class);
      this.m_3409fa8f(C0394.class);
      this.m_3409fa8f(C0388.class);
      this.m_3409fa8f(C0390.class);
      this.m_3409fa8f(C0387.class);
      this.m_3409fa8f(C0384.class);
      this.m_3409fa8f(C0340.class);
      this.m_3409fa8f(C0348.class);
      this.m_3409fa8f(C0347.class);
      this.m_3409fa8f(C0344.class);
      this.m_3409fa8f(C0349.class);
      this.m_3409fa8f(C0341.class);
      this.m_3409fa8f(C0354.class);
      this.m_3409fa8f(C0338.class);
      this.m_3409fa8f(C0339.class);
      this.m_3409fa8f(C0355.class);
      this.m_3409fa8f(C0350.class);
      this.m_3409fa8f(C0353.class);
      this.m_3409fa8f(C0346.class);
      this.m_3409fa8f(C0356.class);
      this.m_3409fa8f(C0343.class);
      this.m_3409fa8f(C0345.class);
      this.m_3409fa8f(C0352.class);
      this.m_3409fa8f(C0342.class);
      this.m_3409fa8f(C0314.class);
      this.m_3409fa8f(C0315.class);
      this.m_3409fa8f(C0292.class);
      this.m_3409fa8f(C0323.class);
      this.m_3409fa8f(C0318.class);
      this.m_3409fa8f(C0324.class);
      this.m_3409fa8f(C0316.class);
      this.m_3409fa8f(C0317.class);
      this.m_3409fa8f(C0312.class);
      this.m_3409fa8f(C0330.class);
      this.m_3409fa8f(C0320.class);
      this.m_3409fa8f(C0321.class);
      this.m_3409fa8f(C0325.class);
      this.m_3409fa8f(C0337.class);
      this.m_3409fa8f(C0329.class);
      this.m_3409fa8f(C0333.class);
      this.m_3409fa8f(C0313.class);
      this.m_3409fa8f(C0334.class);
      this.m_3409fa8f(C0335.class);
      this.m_3409fa8f(C0327.class);
      this.m_3409fa8f(C0326.class);
      this.m_3409fa8f(C0332.class);
      this.m_3409fa8f(C0331.class);
      this.m_3409fa8f(C0328.class);
      this.m_3409fa8f(C0336.class);
      this.m_3409fa8f(C0351.class);
      this.m_3409fa8f(C0361.class);
      this.m_3409fa8f(C0365.class);
      this.m_3409fa8f(C0367.class);
      this.m_3409fa8f(C0363.class);
      this.m_3409fa8f(C0362.class);
      this.m_3409fa8f(C0364.class);
      this.m_3409fa8f(C0359.class);
      this.m_3409fa8f(C0357.class);
      this.m_3409fa8f(C0360.class);
      this.m_3409fa8f(C0366.class);
      this.m_3409fa8f(C0358.class);
      this.m_3409fa8f(C0368.class);
      this.m_3409fa8f(C0369.class);
      this.m_3409fa8f(C0076.class);
      this.m_3409fa8f(C0077.class);
      this.m_3409fa8f(C0081.class);
      this.m_3409fa8f(C0079.class);
      this.m_3409fa8f(C0078.class);
      if (!C0241.f_7826e715) {
         this.m_3409fa8f(C0080.class);
      }
   }

   public void m_33356f33() {
      try {
         Main.class.getClassLoader().loadClass(this.f_c27fe56c).getDeclaredConstructor().newInstance();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      if (!C0114.bootstrap<"call",0,1>(C0080.class)) {
         this.m_3409fa8f(C0080.class);
      }
   }

   public void m_a33c5216(String var1) {
      this.f_c27fe56c = var1;
   }

   public Map<Class<?>, AbstractMod> m_dace8a1f() {
      return this.f_ef831007;
   }
}
