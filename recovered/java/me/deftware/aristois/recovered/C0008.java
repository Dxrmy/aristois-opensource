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
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;
import me.deftware.client.framework.item.IItem;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.registry.Identifiable;
import me.deftware.client.framework.registry.ItemRegistry;

public class C0008 implements ArgumentType<IItem> {
   private static final DynamicCommandExceptionType f_a26afa62 = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967389>(), new Object[]{var0}))
   );

   public C0008() {
   }

   public IItem m_50d59960(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      IItem var3 = C0114.bootstrap<"call",0,1>(var2);
      if (var3 != null) {
         return var3;
      } else {
         throw f_a26afa62.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      C0114.bootstrap<"call",0,1>(ItemRegistry.INSTANCE.stream(), BlockRegistry.INSTANCE.stream())
         .filter(var1x -> ((Identifiable)var1x).getIdentifierKey().toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT)))
         .forEach(var1x -> var2.suggest(((Identifiable)var1x).getIdentifierKey()));
      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return C0114.bootstrap<"call",0,1>(new String[]{C0252.bootstrap<"get",4294967387>(), C0252.bootstrap<"get",4294967388>()});
   }
}
