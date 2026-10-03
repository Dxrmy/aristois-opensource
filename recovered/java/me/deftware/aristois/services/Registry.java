package me.deftware.aristois.services;

import java.util.Arrays;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.aristois.recovered.C0091;
import me.deftware.aristois.recovered.C0217;
import me.deftware.aristois.recovered.C0289;
import me.deftware.aristois.recovered.C0290;
import me.deftware.aristois.services.types.CraftPresenceService;
import me.deftware.aristois.services.types.SeedCrackerService;
import me.deftware.aristois.services.types.baritone.BaritoneService;

public enum Registry implements Runnable {
   CraftPresence(CraftPresenceService.class),
   SeedCracker(SeedCrackerService.class),
   Baritone(BaritoneService.class);

   private final Class<? extends Runnable> clazz;
   private final Service data;
   private Object object;

   private Registry(Class<? extends Runnable> clazz) {
      if (clazz.isAnnotationPresent(Service.class)) {
         this.data = clazz.getAnnotation(Service.class);
         this.clazz = clazz;
      } else {
         throw new RuntimeException("Invalid service!");
      }
   }

   @Override
   public void run() {
      try {
         if (!this.isAnyClassPresent(this.data.value())) {
            throw new Exception("Service class not found");
         }

         if (!this.canRunOnOS(this.data.os())) {
            throw new Exception("Unsupported OS!");
         }

         this.object = this.clazz.getDeclaredConstructor().newInstance();
         if (this.data.module()) {
            this.register();
         }

         ((Runnable)this.object).run();
      } catch (Throwable var2) {
      }
   }

   private void register() {
      AbstractMod mod = new AbstractMod(this.data.name(), C0290.f_2847ec1c, this.data.description());
      C0289.f_85a7343f.m_1a101045(this.clazz, mod, C0091.m_7dd37260(this.object));
      mod.setSettingOnlyMod(true);
   }

   private boolean isAnyClassPresent(String[] classes) {
      for (String clazz : classes) {
         try {
            Class<?> serviceClass = Class.forName(clazz);
            return true;
         } catch (Throwable var7) {
         }
      }

      return false;
   }

   private boolean canRunOnOS(C0217.anonymousdefault os) {
      if (os != C0217.anonymousdefault.f_ca235988) {
         return os != C0217.anonymousdefault.f_0edc9299 ? os == C0217.f_99fecb28 : os == C0217.f_99fecb28 && C0217.m_efa7610e();
      } else {
         return true;
      }
   }

   public String getName() {
      return this.data.name();
   }

   public boolean isAvailable() {
      return this.object != null;
   }

   public <T> T getService() {
      return (T)this.object;
   }

   public static int size() {
      return (int)Arrays.stream(values()).filter(Registry::isAvailable).count();
   }

   public Class<? extends Runnable> getClazz() {
      return this.clazz;
   }

   public Service getData() {
      return this.data;
   }
}
