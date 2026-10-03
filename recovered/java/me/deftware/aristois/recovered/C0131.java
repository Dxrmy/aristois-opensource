package me.deftware.aristois.recovered;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

public interface C0131<T> {
   void m_ce373d59(JsonWriter var1, T var2) throws IOException;

   T m_f6beba4b(JsonReader var1) throws IOException;

   List<Class<? extends T>> m_7c29270c();

   default <E> E m_a748c4cd(JsonReader var1, C0131.anonymousgoto<JsonReader, E> var2) throws IOException {
      var1.nextName();
      return (E)var2.m_a48f0dcf(var1);
   }

   default <E> void m_72ac210a(JsonWriter var1, String var2, E var3, C0131.anonymousimplements<JsonWriter, E> var4) throws IOException {
      var1.name(var2);
      var4.m_a3701bb5(var1, var3);
   }

   default TypeAdapter<T> m_526c0d89() {
      return new TypeAdapter<T>() {
         public void write(JsonWriter var1, T var2) throws IOException {
            var1.beginObject();
            C0131.this.m_ce373d59(var1, var2);
            var1.endObject();
         }

         public T read(JsonReader var1) throws IOException {
            var1.beginObject();
            Object var2 = C0131.this.m_f6beba4b(var1);
            var1.endObject();
            return (T)var2;
         }
      };
   }

   @FunctionalInterface
   public interface anonymousgoto<T, R> {
      R m_a48f0dcf(T var1) throws IOException;
   }

   @FunctionalInterface
   public interface anonymousimplements<T, U> {
      void m_a3701bb5(T var1, U var2) throws IOException;
   }
}
