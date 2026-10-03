package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

public class C0132 implements C0131<Color> {
   public C0132() {
   }

   public void m_57ab774c(JsonWriter var1, Color var2) throws IOException {
      var1.name(C0252.bootstrap<"get",12884901913>());
      var1.value((long)var2.getRGB());
      var1.name(C0252.bootstrap<"get",12884901993>());
      var1.value(0.0);
   }

   public Color m_d5622c4a(JsonReader var1) throws IOException {
      var1.nextName();
      Color var2 = new Color(var1.nextInt(), true);

      while (var1.hasNext()) {
         String var3 = var1.nextName();
         if (var3.equalsIgnoreCase(C0252.bootstrap<"get",12884901993>())) {
            var1.nextDouble();
         }

         if (var3.equalsIgnoreCase(C0252.bootstrap<"get",12884901994>()) || var3.equalsIgnoreCase(C0252.bootstrap<"get",12884901995>())) {
            var1.beginArray();
            var1.nextDouble();
            var1.nextDouble();
            var1.nextDouble();
            var1.endArray();
         }
      }

      return var2;
   }

   public List<Class<? extends Color>> m_1c20f07b() {
      return C0114.bootstrap<"call",0,1>(Color.class);
   }
}
