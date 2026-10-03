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
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;
import me.deftware.client.framework.item.enchantment.Enchantment;
import me.deftware.client.framework.registry.EnchantmentRegistry;

public class C0002 implements ArgumentType<Enchantment> {
   private static final DynamicCommandExceptionType f_468e244e = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(String.format(C0264.m_a55b07ff(), var0))
   );

   public C0002() {
   }

   public Enchantment m_2b62972d(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      Optional var3 = EnchantmentRegistry.INSTANCE.stream().filter(var1x -> var1x.getIdentifierKey().equalsIgnoreCase(var2)).findFirst();
      if (var3.isPresent()) {
         return (Enchantment)var3.get();
      } else {
         throw f_468e244e.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      EnchantmentRegistry.INSTANCE
         .stream()
         .filter(var1x -> var1x.getIdentifierKey().toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT)))
         .forEach(var1x -> var2.suggest(var1x.getIdentifierKey()));
      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return Arrays.asList(C0264.m_11f0c704(), C0264.m_19faa493());
   }
}
