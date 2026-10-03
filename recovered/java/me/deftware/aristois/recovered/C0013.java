package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;
import me.deftware.client.framework.entity.EntityCapsule;
import me.deftware.client.framework.registry.EntityRegistry;

public class C0013 implements ArgumentType<EntityCapsule> {
   private final DynamicCommandExceptionType f_8161bf5d = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(String.format(C0264.m_e8fd0250(), var0))
   );

   public C0013() {
   }

   public EntityCapsule m_a642c151(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      Optional var3 = EntityRegistry.INSTANCE
         .stream()
         .filter(var1x -> var1x.getName().string().replace(C0257.m_593ecbab(), C0264.m_16315846()).equalsIgnoreCase(var2))
         .findFirst();
      if (var3.isPresent()) {
         return (EntityCapsule)var3.get();
      } else {
         throw this.f_8161bf5d.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = var2.getRemaining().toLowerCase(Locale.ROOT);
      EntityRegistry.INSTANCE.stream().forEach(var2x -> {
         String var3x = var2x.getName().string().replace(C0257.m_593ecbab(), C0264.m_16315846());
         if (var3x.toLowerCase().startsWith(var3)) {
            var2.suggest(var3x);
         }
      });
      return var2.buildFuture();
   }
}
