package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0089 {
   private final JsonObject f_26135113;
   private final File f_8f4bb7c0;

   public C0089() throws Exception {
      this(
         Paths.get(
               Minecraft.getMinecraftGame()._getGameDir().getAbsolutePath(),
               C0266.m_1b17f04f(),
               Minecraft.getMinecraftVersion() + C0266.m_bcef2112(),
               Minecraft.getMinecraftVersion() + C0266.m_114677c2()
            )
            .toFile()
      );
   }

   public C0089(File var1) throws Exception {
      this.f_8f4bb7c0 = var1;

      try (InputStreamReader var2 = new InputStreamReader(new FileInputStream(var1))) {
         this.f_26135113 = (JsonObject)new Gson().fromJson(var2, JsonObject.class);
      }
   }

   public JsonObject m_f7ec0040() {
      return this.f_26135113;
   }

   public JsonArray m_e40a2c80() {
      return this.f_26135113.getAsJsonArray(C0264.m_2e834348());
   }

   public boolean m_828a75ae(String var1) {
      for (JsonElement var3 : this.m_e40a2c80()) {
         if (var3.getAsJsonObject().get(C0266.m_15737526()).getAsString().equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }

   public void m_e5f08f7c(String var1, String var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty(C0266.m_15737526(), var1);
      var3.addProperty(C0253.m_c04d8f6e(), var2);
      this.m_e40a2c80().add(var3);
   }

   public void m_0e265701() {
      try {
         C0198.m_cc641daf(this.f_26135113, this.f_8f4bb7c0);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
