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
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import me.deftware.client.framework.command.argument.ArgumentExceptionFunction;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.item.IItem;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.registry.Identifiable;
import me.deftware.client.framework.registry.ItemRegistry;
import me.deftware.client.framework.registry.RegistryMan;

public class C0008 implements ArgumentType<IItem> {
   private static final DynamicCommandExceptionType f_b3a378bc = new DynamicCommandExceptionType(
      var0 -> new ArgumentExceptionFunction(String.format(C0264.m_9bf0a29a(), var0))
   );

   public C0008() {
   }

   public IItem m_c65ec442(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readUnquotedString();
      IItem var3 = RegistryMan.find(var2);
      if (var3 != null) {
         return var3;
      } else {
         throw f_b3a378bc.create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      Stream.<ListItem>concat(ItemRegistry.INSTANCE.stream(), BlockRegistry.INSTANCE.stream())
         .filter(var1x -> ((Identifiable)var1x).getIdentifierKey().toLowerCase().startsWith(var2.getRemaining().toLowerCase(Locale.ROOT)))
         .forEach(var1x -> var2.suggest(((Identifiable)var1x).getIdentifierKey()));
      return var2.buildFuture();
   }

   public Collection<String> getExamples() {
      return Arrays.asList(C0264.m_114677c2(), C0264.m_fac478b2());
   }
}
