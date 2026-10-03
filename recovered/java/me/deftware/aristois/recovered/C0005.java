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
   private final DynamicCommandExceptionType f_dc401339 = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967390>(), new Object[]{var0}))
   );
   private final C0005.anonymouscatch f_9c8eb304;

   public C0005(C0005.anonymouscatch var1) {
      this.f_9c8eb304 = var1;
   }

   public String m_52a16803(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();

      for (int var3 = 0; var3 < this.f_9c8eb304.m_9489acef(); var3++) {
         String var4 = this.f_9c8eb304.m_ea6093ce(var3);
         if (var4.equalsIgnoreCase(var2)) {
            return var4;
         }
      }

      throw this.f_dc401339.create(var2);
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      for (int var3 = 0; var3 < this.f_9c8eb304.m_9489acef(); var3++) {
         String var4 = this.f_9c8eb304.m_ea6093ce(var3);
         if (var4.toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT))) {
            var2.suggest(var4);
         }
      }

      return var2.buildFuture();
   }

   public interface anonymouscatch {
      int m_9489acef();

      String m_ea6093ce(int var1);
   }
}
