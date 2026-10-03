package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;
import me.deftware.client.framework.item.enchantment.Enchantment;
import me.deftware.client.framework.registry.EnchantmentRegistry;

public class C0002 implements ArgumentType<Enchantment> {
   private static final DynamicCommandExceptionType f_3525b833 = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967380>(), new Object[]{var0}))
   );

   public C0002() {
   }

   public Enchantment m_b8e65af7(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      Optional var3 = EnchantmentRegistry.INSTANCE.stream().filter(var1x -> var1x.getIdentifierKey().equalsIgnoreCase(var2)).findFirst();
      if (var3.isPresent()) {
         return (Enchantment)var3.get();
      } else {
         throw f_3525b833.create(var2);
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
      return C0114.bootstrap<"call",0,1>(new String[]{C0252.bootstrap<"get",4294967378>(), C0252.bootstrap<"get",4294967379>()});
   }
}
