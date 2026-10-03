package me.deftware.aristois.recovered;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface C0097 {
   String title() default "Select file";

   String description() default "All files";

   String[] filters() default {"*.*"};
}
