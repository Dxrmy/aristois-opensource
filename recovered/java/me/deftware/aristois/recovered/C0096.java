package me.deftware.aristois.recovered;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface C0096 {
   double min() default 1.0;

   double max() default 20.0;

   boolean percentage() default false;
}
