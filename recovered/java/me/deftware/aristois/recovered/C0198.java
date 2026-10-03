package me.deftware.aristois.recovered;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class C0198 {
   public C0198() {
   }

   public static GsonBuilder m_cde2d310() {
      return new GsonBuilder().setPrettyPrinting().addDeserializationExclusionStrategy(m_ee8519bd()).addSerializationExclusionStrategy(m_ee8519bd());
   }

   public static ExclusionStrategy m_ee8519bd() {
      return new ExclusionStrategy() {
         public boolean shouldSkipClass(Class<?> var1) {
            return false;
         }

         public boolean shouldSkipField(FieldAttributes var1) {
            return var1.getAnnotation(SerializedName.class) == null;
         }
      };
   }

   public static void m_cc641daf(JsonElement var0, File var1) throws IOException {
      Gson var2 = new GsonBuilder().setPrettyPrinting().create();
      JsonParser var3 = new JsonParser();
      JsonElement var4 = var3.parse(var0.toString());
      String var5 = var2.toJson(var4);
      PrintWriter var6 = new PrintWriter(var1.getAbsolutePath(), C0256.m_19faa493());
      var6.println(var5);
      var6.close();
   }

   public static <T> T m_19d60999(Path var0, Class<T> var1) throws IOException {
      Gson var2 = m_cde2d310().create();

      Object var7;
      try (
         InputStream var3 = Files.newInputStream(var0);
         InputStreamReader var5 = new InputStreamReader(var3);
      ) {
         var7 = var2.fromJson(var5, var1);
      }

      return (T)var7;
   }
}
