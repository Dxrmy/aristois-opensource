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

public class C0011 implements C0009<C0094<?>> {
   private static final DynamicCommandExceptionType f_74a96ffd = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967386>(), new Object[]{var0}))
   );
   private AbstractMod f_21bace51;

   public C0011() {
   }

   public C0094<?> m_6083be70(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      if (this.f_21bace51 != null) {
         Optional var3 = this.f_21bace51.getFields().stream().filter(var1x -> var1x.m_087ac7a8().equalsIgnoreCase(var2)).findFirst();
         if (var3.isPresent()) {
            return (C0094<?>)var3.get();
         }
      }

      throw f_74a96ffd.create(var2);
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      (this.f_21bace51 = (AbstractMod)this.m_3949531c(var1, AbstractMod.class, C0252.bootstrap<"get",4294967384>()))
         .getFields()
         .stream()
         .filter(var1x -> var1x.m_087ac7a8().startsWith(var2.getRemaining().toLowerCase()))
         .forEach(var1x -> var2.suggest(var1x.m_087ac7a8(), C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967385>() + var1x)));
      return var2.buildFuture();
   }
}
