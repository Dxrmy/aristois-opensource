package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class C0089 {
   private final JsonObject f_fc4aeb5c;
   private final File f_611e5ac0;

   public C0089() throws Exception {
      this(
         C0114.bootstrap<"call",2,1>(
               C0114.bootstrap<"call",0,1>()._getGameDir().getAbsolutePath(),
               new String[]{
                  C0252.bootstrap<"get",12884901977>(),
                  C0114.bootstrap<"call",1,1>() + C0252.bootstrap<"get",12884901978>(),
                  C0114.bootstrap<"call",1,1>() + C0252.bootstrap<"get",12884901979>()
               }
            )
            .toFile()
      );
   }

   public C0089(File var1) throws Exception {
      this.f_611e5ac0 = var1;

      try (InputStreamReader var2 = new InputStreamReader(new FileInputStream(var1))) {
         this.f_fc4aeb5c = (JsonObject)new Gson().fromJson(var2, JsonObject.class);
      }
   }

   public JsonObject m_3b67f137() {
      return this.f_fc4aeb5c;
   }

   public JsonArray m_f452fb43() {
      return this.f_fc4aeb5c.getAsJsonArray(C0252.bootstrap<"get",4294967320>());
   }

   public boolean m_2d04db88(String var1) {
      for (JsonElement var3 : this.m_f452fb43()) {
         if (var3.getAsJsonObject().get(C0252.bootstrap<"get",12884901951>()).getAsString().equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }

   public void m_c6a6bad9(String var1, String var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty(C0252.bootstrap<"get",12884901951>(), var1);
      var3.addProperty(C0252.bootstrap<"get",8589934695>(), var2);
      this.m_f452fb43().add(var3);
   }

   public void m_71d0d167() {
      try {
         C0114.bootstrap<"call",0,1>(this.f_fc4aeb5c, this.f_611e5ac0);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
