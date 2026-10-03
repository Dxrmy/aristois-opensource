package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import me.deftware.client.framework.command.CommandBuilder;

public class C0025 extends C0001 {
   public C0025() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_0223faff())
                     .then(
                        LiteralArgumentBuilder.literal(C0253.m_8d7dbe31())
                           .then(
                              ((RequiredArgumentBuilder)RequiredArgumentBuilder.argument(C0253.m_bdbd5e40(), new C0007<>(C0025.anonymousimplements.class))
                                    .then(
                                       RequiredArgumentBuilder.argument(C0253.m_c04d8f6e(), StringArgumentType.string())
                                          .executes(
                                             var1 -> {
                                                C0217.m_c162d659(
                                                   () -> this.m_55f8afbd(
                                                         (String)var1.getArgument(C0253.m_c04d8f6e(), String.class),
                                                         (C0025.anonymousimplements)var1.getArgument(C0253.m_bdbd5e40(), C0025.anonymousimplements.class)
                                                      )
                                                );
                                                return 1;
                                             }
                                          )
                                    ))
                                 .executes(var1 -> {
                                    this.m_6fbe1381((C0025.anonymousimplements)var1.getArgument(C0253.m_bdbd5e40(), C0025.anonymousimplements.class));
                                    return 1;
                                 })
                           )
                     ))
                  .then(LiteralArgumentBuilder.literal(C0253.m_2dc36b02()).executes(var0 -> {
                     m_a11708c5(String.format(C0253.m_023b99d9(), C0143.m_39057c01().size()));
                     return 1;
                  })))
               .then(LiteralArgumentBuilder.literal(C0253.m_afb31f66()).executes(var0 -> {
                  C0143.m_a4e18580(null);
                  return 1;
               }))
         );
   }

   private void m_6fbe1381(C0025.anonymousimplements var1) {
      Optional var2 = new C0216(C0253.m_4cbaf16f(), C0253.m_678c4ddb(), C0253.m_1672ac4d()).m_2684dcf7();
      if (var2.isPresent()) {
         Path var3 = (Path)var2.get();

         try {
            List var4 = Files.readAllLines(var3, StandardCharsets.UTF_8);
            this.m_f5adfb9c(var4, var1);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }
   }

   private void m_55f8afbd(String var1, C0025.anonymousimplements var2) {
      m_a11708c5(C0253.m_e9a52709());
      C0140 var3 = new C0139(var1).m_0017133f();
      if (var3.m_9362a920()) {
         this.m_f5adfb9c(var3.m_e991ec61(), var2);
      } else {
         error(C0253.m_37c08c9d() + var3.m_36ffc578());
         System.err.println(var3.m_e991ec61());
      }
   }

   private void m_f5adfb9c(List<String> var1, final C0025.anonymousimplements var2) {
      m_a11708c5(String.format(C0253.m_1472ab32(), var1.size()));
      ArrayList var3 = new ArrayList();

      for (String var5 : var1) {
         String[] var6 = var5.split(C0257.m_593ecbab());
         final String var7 = var6[0];
         if (var7.matches(C0253.m_a5b24d28())) {
            var3.add(new C0144() {
               public String getUsername() {
                  return null;
               }

               public String getPassword() {
                  return null;
               }

               public String getAddress() {
                  return var7;
               }

               public int getVersion() {
                  return Integer.parseInt(var2.name().substring(C0253.m_ec329d2e().length()));
               }
            });
         }
      }

      if (!var3.isEmpty()) {
         C0143.m_39057c01().clear();
         C0143.m_39057c01().addAll(var3);
         m_a11708c5(String.format(C0253.m_a9b6ecd9(), var3.size()));
      } else {
         error(C0253.m_09052c0b());
      }
   }

   private static enum anonymousimplements {
      f_81e2e4f8,
      f_f94b8454;

      private anonymousimplements() {
      }
   }
}
