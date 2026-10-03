package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;
import me.deftware.client.framework.message.Message;

public class C0011 implements C0009<C0094<?>> {
   private static final DynamicCommandExceptionType f_771e46af = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(String.format(C0264.m_bcef2112(), var0))
   );
   private AbstractMod f_9a4b424d;

   public C0011() {
   }

   public C0094<?> m_81a1dc05(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      if (this.f_9a4b424d != null) {
         Optional var3 = this.f_9a4b424d.getFields().stream().filter(var1x -> var1x.m_c254a253().equalsIgnoreCase(var2)).findFirst();
         if (var3.isPresent()) {
            return (C0094<?>)var3.get();
         }
      }

      throw f_771e46af.create(var2);
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      (this.f_9a4b424d = this.m_25ee9493(var1, AbstractMod.class, C0264.m_0425f2ec()))
         .getFields()
         .stream()
         .filter(var1x -> var1x.m_c254a253().startsWith(var2.getRemaining().toLowerCase()))
         .forEach(var1x -> var2.suggest(var1x.m_c254a253(), Message.of(C0264.m_1b17f04f() + var1x)));
      return var2.buildFuture();
   }
}
