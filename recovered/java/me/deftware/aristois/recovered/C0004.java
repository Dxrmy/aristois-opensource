package me.deftware.aristois.recovered;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;

public class C0004 implements ArgumentType<AbstractMod> {
   private final DynamicCommandExceptionType f_2210c55a = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967394>(), new Object[]{var0}))
   );
   private final boolean f_d9095713;

   private Stream<AbstractMod> m_b5f2ab15() {
      return C0289.f_c22b8d7e.m_ea73e1f0().filter(var1 -> this.f_d9095713 || !var1.isSettingOnlyMod());
   }

   public AbstractMod m_8caf595a(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      Optional var3 = this.m_b5f2ab15().filter(var2x -> this.m_9fc3dc44(var2x).equalsIgnoreCase(var2)).findAny();
      if (var3.isPresent()) {
         return (AbstractMod)var3.get();
      } else {
         throw this.f_2210c55a.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      this.m_b5f2ab15()
         .filter(var2x -> this.m_9fc3dc44(var2x).toLowerCase().startsWith(var2.getRemaining().toLowerCase()))
         .forEach(
            var2x -> var2.suggest(
                  this.m_9fc3dc44(var2x), C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967393>(), var2x.getDescription()))
               )
         );
      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return C0114.bootstrap<"call",0,1>(new String[]{C0252.bootstrap<"get",4294967391>(), C0252.bootstrap<"get",4294967392>()});
   }

   private String m_9fc3dc44(AbstractMod var1) {
      return var1.m_5aac041f();
   }

   public C0004(boolean var1) {
      this.f_d9095713 = var1;
   }
}
