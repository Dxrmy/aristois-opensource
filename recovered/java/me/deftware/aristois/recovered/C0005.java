package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;

public class C0005 implements ArgumentType<String> {
   private final DynamicCommandExceptionType f_09555926 = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(String.format(C0264.m_85cd13b4(), var0))
   );
   private final C0005.anonymouscatch f_be4a3c3a;

   public C0005(C0005.anonymouscatch var1) {
      this.f_be4a3c3a = var1;
   }

   public String m_c302d5a4(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();

      for (int var3 = 0; var3 < this.f_be4a3c3a.m_79bbc2da(); var3++) {
         String var4 = this.f_be4a3c3a.m_5fe4c734(var3);
         if (var4.equalsIgnoreCase(var2)) {
            return var4;
         }
      }

      throw this.f_09555926.create(var2);
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      for (int var3 = 0; var3 < this.f_be4a3c3a.m_79bbc2da(); var3++) {
         String var4 = this.f_be4a3c3a.m_5fe4c734(var3);
         if (var4.toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT))) {
            var2.suggest(var4);
         }
      }

      return var2.buildFuture();
   }

   public interface anonymouscatch {
      int m_79bbc2da();

      String m_5fe4c734(int var1);
   }
}
