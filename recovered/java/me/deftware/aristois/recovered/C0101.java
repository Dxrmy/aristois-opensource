package me.deftware.aristois.recovered;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface C0101 {
   C0213 minimumProtocol() default C0213.CURRENT;

   C0213 maximumProtocol() default C0213.CURRENT;
}
