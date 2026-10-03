package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.nio.charset.StandardCharsets;
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
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934693>())
                     .then(
                        C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934600>())
                           .then(
                              ((RequiredArgumentBuilder)C0114.bootstrap<"call",1,1>(
                                       C0252.bootstrap<"get",8589934694>(), new C0007<>(C0025.anonymousimplements.class)
                                    )
                                    .then(
                                       C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934695>(), C0114.bootstrap<"call",2,1>())
                                          .executes(
                                             var1 -> {
                                                C0114.bootstrap<"call",0,1>(
                                                   () -> this.m_a3c87950(
                                                         (String)var1.getArgument(C0252.bootstrap<"get",8589934695>(), String.class),
                                                         (C0025.anonymousimplements)var1.getArgument(
                                                            C0252.bootstrap<"get",8589934694>(), C0025.anonymousimplements.class
                                                         )
                                                      )
                                                );
                                                return 1;
                                             }
                                          )
                                    ))
                                 .executes(var1 -> {
                                    this.m_e696fdec(
                                       (C0025.anonymousimplements)var1.getArgument(C0252.bootstrap<"get",8589934694>(), C0025.anonymousimplements.class)
                                    );
                                    return 1;
                                 })
                           )
                     ))
                  .then(
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934696>())
                        .executes(
                           var0 -> {
                              C0114.bootstrap<"call",3,1>(
                                 C0114.bootstrap<"call",2,1>(
                                    C0252.bootstrap<"get",8589934706>(), new Object[]{C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>().size())}
                                 )
                              );
                              return 1;
                           }
                        )
                  ))
               .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934631>()).executes(var0 -> {
                  C0114.bootstrap<"call",6,1>(null);
                  return 1;
               }))
         );
   }

   private void m_e696fdec(C0025.anonymousimplements var1) {
      Optional var2 = new C0216(C0252.bootstrap<"get",8589934697>(), C0252.bootstrap<"get",8589934698>(), C0252.bootstrap<"get",8589934699>()).m_b8b58442();
      if (var2.isPresent()) {
         Path var3 = (Path)var2.get();

         try {
            List var4 = C0114.bootstrap<"call",0,1>(var3, StandardCharsets.UTF_8);
            this.m_8a5ed8ff(var4, var1);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }
   }

   private void m_a3c87950(String var1, C0025.anonymousimplements var2) {
      C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934700>());
      C0140 var3 = new C0139(var1).m_244f5552();
      if (var3.m_9781181b()) {
         this.m_8a5ed8ff(var3.m_f463879e(), var2);
      } else {
         C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934701>() + var3.m_c74e1657());
         System.err.println(var3.m_f463879e());
      }
   }

   private void m_8a5ed8ff(List<String> var1, final C0025.anonymousimplements var2) {
      C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",8589934702>(), new Object[]{C0114.bootstrap<"call",3,1>(var1.size())}));
      ArrayList var3 = new ArrayList();

      for (String var5 : var1) {
         String[] var6 = var5.split(C0252.bootstrap<"get",70>());
         final String var7 = var6[0];
         if (var7.matches(C0252.bootstrap<"get",8589934703>())) {
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
                  return C0114.bootstrap<"call",0,1>(var2.name().substring(C0252.bootstrap<"get",8589934690>().length()));
               }
            });
         }
      }

      if (!var3.isEmpty()) {
         C0114.bootstrap<"call",5,1>().clear();
         C0114.bootstrap<"call",5,1>().addAll(var3);
         C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",8589934704>(), new Object[]{C0114.bootstrap<"call",3,1>(var3.size())}));
      } else {
         C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934705>());
      }
   }

   private static enum anonymousimplements {
      f_4a72c94e,
      f_80e7c293;

      private anonymousimplements() {
      }
   }
}
