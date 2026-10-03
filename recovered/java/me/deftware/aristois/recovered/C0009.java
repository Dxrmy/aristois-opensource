package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;

public interface C0009<T> extends ArgumentType<T> {
   default <V> V m_25ee9493(CommandContext<?> var1, Class<V> var2, String var3) {
      try {
         return (V)var1.getArgument(var3, var2);
      } catch (Throwable var5) {
         return (V)var1.getChild().getArgument(var3, var2);
      }
   }
}
