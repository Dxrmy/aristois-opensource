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

public class C0012 implements ArgumentType<C0244> {
   private final DynamicCommandExceptionType f_daeec2ef = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967397>(), new Object[]{var0}))
   );

   public C0012() {
   }

   public C0244 m_10eee806(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();

      for (C0244 var4 : C0114.bootstrap<"call",0,1>()) {
         if (var4.m_efbf7bb8().equalsIgnoreCase(var2)) {
            return var4;
         }
      }

      throw this.f_daeec2ef.create(var2);
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      for (C0244 var4 : C0114.bootstrap<"call",0,1>()) {
         if (var4.m_efbf7bb8().toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT))) {
            var2.suggest(var4.m_efbf7bb8());
         }
      }

      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return C0114.bootstrap<"call",0,1>(new String[]{C0252.bootstrap<"get",4294967395>(), C0252.bootstrap<"get",4294967396>()});
   }
}
