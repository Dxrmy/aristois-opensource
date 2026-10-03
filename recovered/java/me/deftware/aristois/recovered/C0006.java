package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.item.IItem;
import me.deftware.client.framework.registry.IRegistry;

public class C0006<T extends IItem> implements ArgumentType<T> {
   private final IRegistry<T, ?> f_beb47e8d;

   public C0006(IRegistry<T, ?> var1) {
      this.f_beb47e8d = var1;
   }

   public T m_c65ec442(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      Optional var3 = this.f_beb47e8d.stream().filter(var1x -> var1x.getIdentifierKey().equalsIgnoreCase(var2)).findAny();
      if (var3.isPresent()) {
         return (T)var3.get();
      } else {
         throw C0014.f_319020fa.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      this.f_beb47e8d
         .stream()
         .<String>map(IItem::getIdentifierKey)
         .filter(var1x -> var1x.toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT)))
         .forEach(var2::suggest);
      return var2.buildFuture();
   }
}
