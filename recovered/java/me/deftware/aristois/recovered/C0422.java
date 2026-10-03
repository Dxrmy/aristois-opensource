package me.deftware.aristois.recovered;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface C0422 {
   int value() default -1;

   int modifier() default 0;

   boolean pinned() default true;
}
