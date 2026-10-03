package me.deftware.aristois.recovered;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.BiFunction;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface C0098 {
   String value();

   boolean display() default true;

   String[] description() default {};

   boolean triggerPostChanged() default false;

   C0096 number() default @C0096;

   C0101 protocol() default @C0101;

   C0097 dialog() default @C0097;

   boolean keybind() default false;

   int id() default -1;

   Class<? extends BiFunction<String, String, String>> textProcessor() default C0098.anonymouscatch.class;

   public static class anonymouscatch implements BiFunction<String, String, String> {
      public anonymouscatch() {
      }

      public String m_8319a509(String var1, String var2) {
         return null;
      }
   }
}
