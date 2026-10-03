package me.deftware.aristois.recovered;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.deftware.aristois.modules.AbstractMod;

@Retention(RetentionPolicy.RUNTIME)
public @interface C0100 {
   Class<? extends AbstractMod>[] value();
}
