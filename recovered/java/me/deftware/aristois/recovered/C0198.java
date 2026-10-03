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
import java.nio.file.OpenOption;
import java.nio.file.Path;

public class C0198 {
   public C0198() {
   }

   public static GsonBuilder m_ab13aa72() {
      return new GsonBuilder()
         .setPrettyPrinting()
         .addDeserializationExclusionStrategy(C0114.bootstrap<"call",0,1>())
         .addSerializationExclusionStrategy(C0114.bootstrap<"call",0,1>());
   }

   public static ExclusionStrategy m_996dbc1d() {
      return new ExclusionStrategy() {
         public boolean shouldSkipClass(Class<?> var1) {
            return false;
         }

         public boolean shouldSkipField(FieldAttributes var1) {
            return var1.getAnnotation(SerializedName.class) == null;
         }
      };
   }

   public static void m_6efd6053(JsonElement var0, File var1) throws IOException {
      Gson var2 = new GsonBuilder().setPrettyPrinting().create();
      JsonParser var3 = new JsonParser();
      JsonElement var4 = var3.parse(var0.toString());
      String var5 = var2.toJson(var4);
      PrintWriter var6 = new PrintWriter(var1.getAbsolutePath(), C0252.bootstrap<"get",55834574931>());
      var6.println(var5);
      var6.close();
   }

   public static <T> T m_902a1dac(Path var0, Class<T> var1) throws IOException {
      Gson var2 = C0114.bootstrap<"call",1,1>().create();

      Object var7;
      try (
         InputStream var3 = C0114.bootstrap<"call",2,1>(var0, new OpenOption[0]);
         InputStreamReader var5 = new InputStreamReader(var3);
      ) {
         var7 = var2.fromJson(var5, var1);
      }

      return (T)var7;
   }
}
