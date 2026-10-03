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
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.block.Block;

public class C0003 implements ArgumentType<Block> {
   private static final DynamicCommandExceptionType f_c6d8f5f0 = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967377>(), new Object[]{var0}))
   );
   private final boolean f_336baf6b;

   public C0003(boolean var1) {
      this.f_336baf6b = var1;
   }

   public C0003() {
      this(false);
   }

   public Block m_9cc05aa9(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      Optional var3 = BlockRegistry.INSTANCE.find(var2);
      if (var3.isPresent()) {
         return (Block)var3.get();
      } else {
         throw f_c6d8f5f0.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      BlockRegistry.INSTANCE
         .stream()
         .map(var1x -> this.f_336baf6b ? var1x.getName().string() : var1x.getIdentifierKey())
         .filter(var1x -> var1x.toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT)))
         .forEach(var2::suggest);
      if (this.f_336baf6b) {
         var2.suggest(C0252.bootstrap<"get",4294967374>());
      }

      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return C0114.bootstrap<"call",0,1>(new String[]{C0252.bootstrap<"get",4294967375>(), C0252.bootstrap<"get",4294967376>()});
   }
}
