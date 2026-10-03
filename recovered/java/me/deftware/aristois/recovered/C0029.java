package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Stream;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.minecraft.Minecraft;
import org.apache.commons.io.FilenameUtils;

public class C0029 extends C0001 {
   public static final Path f_f6b71c95 = Paths.get(
      Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath(), C0264.m_2e834348(), C0264.m_e07cee76(), C0253.m_7b0db73e(), C0253.m_056a389d()
   );

   public C0029() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(
                              C0253.m_a9247108()
                           )
                           .then(LiteralArgumentBuilder.literal(C0253.m_4626ac74()).executes(var0 -> {
                              Optional var1 = new C0216(C0253.m_2e834348(), C0253.m_15ef1a0d(), C0253.m_9793dfe2()).m_cb9b9d68();
                              if (var1.isPresent()) {
                                 Path var2 = (Path)var1.get();
                                 m_ed882a62(var2);
                                 m_a11708c5(C0253.m_e07cee76() + var2.getFileName().toString());
                              }

                              return 1;
                           })))
                        .then(
                           LiteralArgumentBuilder.literal(C0253.m_c688f8ca())
                              .then(RequiredArgumentBuilder.argument(C0253.m_35cdaa1a(), StringArgumentType.greedyString()).executes(var0 -> {
                                 String var1 = StringArgumentType.getString(var0, C0253.m_35cdaa1a());
                                 Path var2 = f_f6b71c95.resolve(var1 + C0253.m_3855be80());
                                 m_ed882a62(var2);
                                 m_a11708c5(C0253.m_79bfaec2() + var1);
                                 return 1;
                              }))
                        ))
                     .then(
                        LiteralArgumentBuilder.literal(C0253.m_624b40d8())
                           .then(RequiredArgumentBuilder.argument(C0253.m_35cdaa1a(), C0029.anonymouscatch.m_59b5eb1c(f_f6b71c95)).executes(var0 -> {
                              String var1 = StringArgumentType.getString(var0, C0253.m_35cdaa1a());
                              Path var2 = f_f6b71c95.resolve(var1 + C0253.m_3855be80());

                              try {
                                 Files.delete(var2);
                                 m_a11708c5(C0253.m_b886ae1c() + var1);
                              } catch (Exception var4) {
                                 var4.printStackTrace();
                                 error(C0253.m_bec91365() + var4.getMessage());
                              }

                              return 1;
                           }))
                     ))
                  .then(
                     ((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_8d7dbe31())
                              .then(LiteralArgumentBuilder.literal(C0253.m_1d87ef21()).executes(var0 -> {
                                 JsonObject var1 = new JsonObject();
                                 var1.addProperty(C0242.anonymousthis.f_5710e889.toString(), true);
                                 var1.addProperty(C0242.anonymousthis.f_3f4a7a8b.toString(), Main.getInstance().getMeta().getVersion());
                                 var1.addProperty(C0253.m_cf4f91f1(), true);
                                 var1.addProperty(C0253.m_b251ca51(), true);
                                 m_dd3aed60(var1);
                                 m_a11708c5(C0253.m_b48a8bc4());
                                 return 1;
                              })))
                           .then(RequiredArgumentBuilder.argument(C0253.m_35cdaa1a(), C0029.anonymouscatch.m_b6440c66(f_f6b71c95)).executes(var0 -> {
                              JsonObject var1 = (JsonObject)var0.getArgument(C0253.m_35cdaa1a(), JsonObject.class);
                              m_dd3aed60(var1);
                              m_a11708c5(C0253.m_18204724());
                              return 1;
                           })))
                        .executes(var0 -> {
                           Optional var1 = new C0216(C0253.m_8ced16bd(), C0253.m_15ef1a0d(), C0253.m_9793dfe2()).m_2684dcf7();
                           if (var1.isPresent()) {
                              Path var2 = (Path)var1.get();

                              try (BufferedReader var3 = Files.newBufferedReader(var2)) {
                                 m_dd3aed60((JsonObject)new Gson().fromJson(var3, JsonObject.class));
                                 m_a11708c5(C0253.m_1635bc47() + var2.getFileName().toString());
                              } catch (Exception var16) {
                                 var16.printStackTrace();
                                 error(C0253.m_d597c122() + var16.getMessage());
                              }
                           }

                           return 1;
                        })
                  ))
               .then(LiteralArgumentBuilder.literal(C0253.m_c42f1c7e()).executes(var0 -> {
                  Keyboard.openLink(f_f6b71c95.toUri().toString());
                  return 1;
               }))
         )
         .registerAlias(C0253.m_6f1f396d());
   }

   private static void m_ed882a62(Path var0) {
      for (AbstractMod var2 : C0289.f_85a7343f.m_4cdd6a26().values()) {
         var2.save();
      }

      Main.getConfig().save();

      try (BufferedWriter var15 = Files.newBufferedWriter(var0)) {
         var15.write(Main.getConfig().getConfig().toString());
      } catch (Exception var14) {
         var14.printStackTrace();
      }
   }

   public static void m_dd3aed60(JsonObject var0) {
      C0289.f_85a7343f.m_d3f1300b();
      Main.getConfig().setConfig(var0);

      for (AbstractMod var2 : C0289.f_85a7343f.m_4cdd6a26().values()) {
         try {
            for (C0094 var4 : var2.getFields()) {
               var4.m_6fc98322();
            }

            var2.initCore();
            var2.load();
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

      C0289.m_c3a8b502(C0431.class).m_98dc1191().clear();
      C0289.m_c3a8b502(C0297.class).m_99d6594e(new C0203<>(C0433::new));
   }

   static {
      if (!Files.exists(f_f6b71c95)) {
         try {
            Files.createDirectories(f_f6b71c95);
         } catch (Exception var1) {
            var1.printStackTrace();
         }
      }
   }

   public static class anonymouscatch<T> implements ArgumentType<T> {
      private final Path f_991cf315;
      private final Function<String, T> f_33c75e22;

      public anonymouscatch(Path var1, Function<String, T> var2) {
         this.f_991cf315 = var1;
         this.f_33c75e22 = var2;
      }

      public T parse(StringReader var1) throws CommandSyntaxException {
         String var2 = var1.getRemaining();
         var1.setCursor(var1.getTotalLength());
         Object var3 = this.f_33c75e22.apply(var2);
         if (var3 != null) {
            return (T)var3;
         } else {
            throw C0014.f_319020fa.create(var2);
         }
      }

      public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
         try (Stream var3 = Files.walk(this.f_991cf315)) {
            var3.filter(var0 -> Files.isRegularFile(var0))
               .map(var0 -> FilenameUtils.removeExtension(var0.getFileName().toString()))
               .filter(var1x -> var1x.startsWith(var2.getRemaining()))
               .forEach(var2::suggest);
         } catch (Exception var16) {
            var16.printStackTrace();
         }

         return var2.buildFuture();
      }

      public static C0029.anonymouscatch<String> m_59b5eb1c(Path var0) {
         return new C0029.anonymouscatch<>(var0, var0x -> var0x);
      }

      public static C0029.anonymouscatch<JsonObject> m_b6440c66(Path var0) {
         return new C0029.anonymouscatch<>(var0, var1 -> {
            Path var2 = var0.resolve(var1 + C0253.m_3855be80());
            if (Files.exists(var2)) {
               try (BufferedReader var3 = Files.newBufferedReader(var2)) {
                  return (JsonObject)new Gson().fromJson(var3, JsonObject.class);
               } catch (Exception var17) {
                  var17.printStackTrace();
               }
            }

            return null;
         });
      }
   }
}
