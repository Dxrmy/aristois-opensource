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
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.block.Block;

public class C0003 implements ArgumentType<Block> {
   private static final DynamicCommandExceptionType f_cbc9748a = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(String.format(C0264.m_812ab029(), var0))
   );
   private final boolean f_cbd8b64c;

   public C0003(boolean var1) {
      this.f_cbd8b64c = var1;
   }

   public C0003() {
      this(false);
   }

   public Block m_7b76df40(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      Optional var3 = BlockRegistry.INSTANCE.find(var2);
      if (var3.isPresent()) {
         return (Block)var3.get();
      } else {
         throw f_cbc9748a.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      BlockRegistry.INSTANCE
         .stream()
         .map(var1x -> this.f_cbd8b64c ? var1x.getName().string() : var1x.getIdentifierKey())
         .filter(var1x -> var1x.toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT)))
         .forEach(var2::suggest);
      if (this.f_cbd8b64c) {
         var2.suggest(C0264.m_6dc2a812());
      }

      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return Arrays.asList(C0264.m_e7934778(), C0264.m_d0e43f69());
   }
}
