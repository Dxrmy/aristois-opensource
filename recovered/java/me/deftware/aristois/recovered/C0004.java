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
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;
import me.deftware.client.framework.message.Message;

public class C0004 implements ArgumentType<AbstractMod> {
   private final DynamicCommandExceptionType f_e562d3a3 = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(String.format(C0264.m_ec329d2e(), var0))
   );
   private final boolean f_afbd6448;

   private Stream<AbstractMod> m_7795e2db() {
      return C0289.f_85a7343f.m_918b7b9e().filter(var1 -> this.f_afbd6448 || !var1.isSettingOnlyMod());
   }

   public AbstractMod m_2597ac4c(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      Optional var3 = this.m_7795e2db().filter(var2x -> this.m_0c56c091(var2x).equalsIgnoreCase(var2)).findAny();
      if (var3.isPresent()) {
         return (AbstractMod)var3.get();
      } else {
         throw this.f_e562d3a3.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      this.m_7795e2db()
         .filter(var2x -> this.m_0c56c091(var2x).toLowerCase().startsWith(var2.getRemaining().toLowerCase()))
         .forEach(var2x -> var2.suggest(this.m_0c56c091(var2x), Message.of(String.join(C0264.m_03430357(), var2x.getDescription()))));
      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return Arrays.asList(C0264.m_65c7e6e6(), C0264.m_a19a564f());
   }

   private String m_0c56c091(AbstractMod var1) {
      return var1.m_6f1f396d();
   }

   public C0004(boolean var1) {
      this.f_afbd6448 = var1;
   }
}
