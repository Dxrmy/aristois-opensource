package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class C0007<T extends Enum<T>> implements ArgumentType<T> {
   private final T[] f_d4f381f3;

   public C0007(Class<T> var1) {
      this.f_d4f381f3 = (T[])var1.getEnumConstants();
   }

   public T m_f5125636(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      return Arrays.<T>stream(this.f_d4f381f3)
         .filter(var1x -> var1x.name().equalsIgnoreCase(var2))
         .findFirst()
         .orElseThrow(() -> C0014.f_319020fa.create(var2));
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      Arrays.<Enum>stream(this.f_d4f381f3)
         .map(Enum::name)
         .filter(var1x -> var1x.toLowerCase().startsWith(var2.getRemaining().toLowerCase()))
         .forEach(var2::suggest);
      return var2.buildFuture();
   }
}
