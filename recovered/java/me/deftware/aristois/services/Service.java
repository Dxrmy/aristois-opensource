package me.deftware.aristois.services;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.deftware.aristois.recovered.C0217;

@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
   String[] value();

   String name() default "Unknown";

   String[] description() default {"Service"};

   String[] source() default {"Unknown"};

   C0217.anonymousdefault os() default C0217.anonymousdefault.All;

   boolean preRun() default false;

   boolean module() default false;
}
