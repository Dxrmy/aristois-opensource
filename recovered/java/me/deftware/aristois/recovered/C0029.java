package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Stream;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;

public class C0029 extends C0001 {
   public static final Path f_54e4fabc = C0114.bootstrap<"call",1,1>(
      C0114.bootstrap<"call",0,1>()._getGameDir().getAbsolutePath(),
      new String[]{
         C0252.bootstrap<"get",4294967320>(), C0252.bootstrap<"get",4294967321>(), C0252.bootstrap<"get",8589934618>(), C0252.bootstrap<"get",8589934619>()
      }
   );

   public C0029() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(
                              C0252.bootstrap<"get",8589934595>()
                           )
                           .then(
                              C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934596>())
                                 .executes(
                                    var0 -> {
                                       Optional var1 = new C0216(
                                             C0252.bootstrap<"get",8589934616>(), C0252.bootstrap<"get",8589934605>(), C0252.bootstrap<"get",8589934606>()
                                          )
                                          .m_c534f7d0();
                                       if (var1.isPresent()) {
                                          Path var2 = (Path)var1.get();
                                          C0114.bootstrap<"call",0,1>(var2);
                                          C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934617>() + var2.getFileName().toString());
                                       }

                                       return 1;
                                    }
                                 )
                           ))
                        .then(
                           C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934597>())
                              .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934598>(), C0114.bootstrap<"call",1,1>()).executes(var0 -> {
                                 String var1 = C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934598>());
                                 Path var2 = f_54e4fabc.resolve(var1 + C0252.bootstrap<"get",8589934594>());
                                 C0114.bootstrap<"call",1,1>(var2);
                                 C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934615>() + var1);
                                 return 1;
                              }))
                        ))
                     .then(
                        C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934599>())
                           .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934598>(), C0114.bootstrap<"call",3,1>(f_54e4fabc)).executes(var0 -> {
                              String var1 = C0114.bootstrap<"call",0,1>(var0, C0252.bootstrap<"get",8589934598>());
                              Path var2 = f_54e4fabc.resolve(var1 + C0252.bootstrap<"get",8589934594>());

                              try {
                                 C0114.bootstrap<"call",1,1>(var2);
                                 C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934613>() + var1);
                              } catch (Exception var4) {
                                 var4.printStackTrace();
                                 C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",8589934614>() + var4.getMessage());
                              }

                              return 1;
                           }))
                     ))
                  .then(
                     ((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934600>())
                              .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934601>()).executes(var0 -> {
                                 JsonObject var1 = new JsonObject();
                                 var1.addProperty(C0242.anonymousthis.f_c0b80100.toString(), C0114.bootstrap<"call",0,1>(true));
                                 var1.addProperty(
                                    C0242.anonymousthis.f_bd825dfe.toString(),
                                    C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>().getMeta().getVersion())
                                 );
                                 var1.addProperty(C0252.bootstrap<"get",8589934610>(), C0114.bootstrap<"call",0,1>(true));
                                 var1.addProperty(C0252.bootstrap<"get",8589934611>(), C0114.bootstrap<"call",0,1>(true));
                                 C0114.bootstrap<"call",3,1>(var1);
                                 C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",8589934612>());
                                 return 1;
                              })))
                           .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934598>(), C0114.bootstrap<"call",4,1>(f_54e4fabc)).executes(var0 -> {
                              JsonObject var1 = (JsonObject)var0.getArgument(C0252.bootstrap<"get",8589934598>(), JsonObject.class);
                              C0114.bootstrap<"call",0,1>(var1);
                              C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934609>());
                              return 1;
                           })))
                        .executes(
                           var0 -> {
                              Optional var1 = new C0216(
                                    C0252.bootstrap<"get",8589934604>(), C0252.bootstrap<"get",8589934605>(), C0252.bootstrap<"get",8589934606>()
                                 )
                                 .m_b8b58442();
                              if (var1.isPresent()) {
                                 Path var2 = (Path)var1.get();

                                 try (BufferedReader var3 = C0114.bootstrap<"call",0,1>(var2)) {
                                    C0114.bootstrap<"call",1,1>((JsonObject)new Gson().fromJson(var3, JsonObject.class));
                                    C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934607>() + var2.getFileName().toString());
                                 } catch (Exception var16) {
                                    var16.printStackTrace();
                                    C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",8589934608>() + var16.getMessage());
                                 }
                              }

                              return 1;
                           }
                        )
                  ))
               .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934602>()).executes(var0 -> {
                  C0114.bootstrap<"call",3,1>(f_54e4fabc.toUri().toString());
                  return 1;
               }))
         )
         .registerAlias(C0252.bootstrap<"get",8589934603>());
   }

   private static void m_957a1c2d(Path var0) {
      for (AbstractMod var2 : C0289.f_c22b8d7e.m_dace8a1f().values()) {
         var2.save();
      }

      C0114.bootstrap<"call",0,1>().save();

      try (BufferedWriter var15 = C0114.bootstrap<"call",1,1>(var0, new OpenOption[0])) {
         var15.write(C0114.bootstrap<"call",0,1>().getConfig().toString());
      } catch (Exception var14) {
         var14.printStackTrace();
      }
   }

   public static void m_8c9c1389(JsonObject var0) {
      C0289.f_c22b8d7e.m_bfe8f4c0();
      C0114.bootstrap<"call",0,1>().setConfig(var0);

      for (AbstractMod var2 : C0289.f_c22b8d7e.m_dace8a1f().values()) {
         try {
            for (C0094 var4 : var2.getFields()) {
               var4.m_4e85e8f7();
            }

            var2.initCore();
            var2.load();
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

      ((C0431)C0114.bootstrap<"call",2,1>(C0431.class)).m_22d90200().clear();
      ((C0297)C0114.bootstrap<"call",2,1>(C0297.class)).m_84627c09(new C0203<>(C0433::new));
   }

   static {
      if (!C0114.bootstrap<"call",2,1>(f_54e4fabc, new LinkOption[0])) {
         try {
            C0114.bootstrap<"call",3,1>(f_54e4fabc, new FileAttribute[0]);
         } catch (Exception var1) {
            var1.printStackTrace();
         }
      }
   }

   public static class anonymouscatch<T> implements ArgumentType<T> {
      private final Path f_86b920cb;
      private final Function<String, T> f_c1f25afb;

      public anonymouscatch(Path var1, Function<String, T> var2) {
         this.f_86b920cb = var1;
         this.f_c1f25afb = var2;
      }

      public T parse(StringReader var1) throws CommandSyntaxException {
         String var2 = var1.getRemaining();
         var1.setCursor(var1.getTotalLength());
         Object var3 = this.f_c1f25afb.apply(var2);
         if (var3 != null) {
            return (T)var3;
         } else {
            throw C0014.f_0f364a0c.create(var2);
         }
      }

      public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
         try (Stream var3 = C0114.bootstrap<"call",0,1>(this.f_86b920cb, new FileVisitOption[0])) {
            var3.filter(var0 -> C0114.bootstrap<"call",0,1>(var0, new LinkOption[0]))
               .map(var0 -> C0114.bootstrap<"call",0,1>(var0.getFileName().toString()))
               .filter(var1x -> var1x.startsWith(var2.getRemaining()))
               .forEach(var2::suggest);
         } catch (Exception var16) {
            var16.printStackTrace();
         }

         return var2.buildFuture();
      }

      public static C0029.anonymouscatch<String> m_074c6062(Path var0) {
         return new C0029.anonymouscatch<>(var0, var0x -> var0x);
      }

      public static C0029.anonymouscatch<JsonObject> m_40b170e0(Path var0) {
         return new C0029.anonymouscatch<>(var0, var1 -> {
            Path var2 = var0.resolve(var1 + C0252.bootstrap<"get",8589934594>());
            if (C0114.bootstrap<"call",0,1>(var2, new LinkOption[0])) {
               try (BufferedReader var3 = C0114.bootstrap<"call",1,1>(var2)) {
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
