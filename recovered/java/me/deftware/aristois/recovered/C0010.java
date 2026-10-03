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

   public String m_c302d5a4(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.getRemaining();
      var1.setCursor(var1.getTotalLength());
      return var2;
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      C0094 var3 = this.m_25ee9493(var1, C0094.class, C0264.m_d0da63e8());
      if (var3.m_c70eae42()) {
         C0102 var4 = (C0102)var3.m_50ca8f08();
         var4.m_cb07f77b().filter(var1x -> var1x.toLowerCase().startsWith(var2.getRemaining().toLowerCase())).forEach(var2::suggest);
      } else {
         var3.m_a4e51be1().m_44a89f72(var2);
      }

      return var2.buildFuture();
   }
}
