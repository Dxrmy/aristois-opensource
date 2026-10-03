package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;

public class C0010 implements C0009<String> {
   public C0010() {
   }

   public String m_22f1fe0c(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.getRemaining();
      var1.setCursor(var1.getTotalLength());
      return var2;
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      C0094 var3 = (C0094)this.m_4e5684ba(var1, C0094.class, C0252.bootstrap<"get",4294967383>());
      if (var3.m_30ee2f8a()) {
         C0102 var4 = (C0102)var3.m_48b16e97();
         var4.m_e2c7ae30().filter(var1x -> var1x.toLowerCase().startsWith(var2.getRemaining().toLowerCase())).forEach(var2::suggest);
      } else {
         var3.m_fb21cd76().m_3c9d7daa(var2);
      }

      return var2.buildFuture();
   }
}
