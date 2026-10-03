package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;

public class C0012 implements ArgumentType<C0244> {
   private final DynamicCommandExceptionType f_89bfbc7c = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(String.format(C0264.m_0223faff(), var0))
   );

   public C0012() {
   }

   public C0244 m_ac6c9aac(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();

      for (C0244 var4 : C0244.m_a492b2a7()) {
         if (var4.m_c688f8ca().equalsIgnoreCase(var2)) {
            return var4;
         }
      }

      throw this.f_89bfbc7c.create(var2);
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      for (C0244 var4 : C0244.m_a492b2a7()) {
         if (var4.m_c688f8ca().toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT))) {
            var2.suggest(var4.m_c688f8ca());
         }
      }

      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return Arrays.asList(C0264.m_edf5fb69(), C0264.m_8ccfdf29());
   }
}
