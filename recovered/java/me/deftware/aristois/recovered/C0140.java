package me.deftware.aristois.recovered;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class C0140 {
   public static final Gson f_37d3281f = C0114.bootstrap<"call",0,1>().create();
   public static final BiConsumer<C0140, InputStream> f_200fe2a2 = (var0, var1) -> {
      try (BufferedReader var2 = new BufferedReader(new InputStreamReader(var1))) {
         var0.m_2a4d2195(var2.lines().collect(C0114.bootstrap<"call",0,1>()));
      } catch (Exception var15) {
         var0.m_ddacd97c(C0252.bootstrap<"get",51539607647>() + var15.getMessage());
         var0.m_802e3bf3(500);
      }
   };
   private int f_8b78ac44;
   private List<String> f_3aacfcbb = new ArrayList<>();
   private BiConsumer<C0140, InputStream> f_b38989d1 = f_200fe2a2;

   public <T> T m_13e100fc(Class<T> var1) {
      return (T)f_37d3281f.fromJson(this.m_6c2c384f(), var1);
   }

   public JsonObject m_fcc066b3() {
      return this.m_13e100fc(JsonObject.class);
   }

   public boolean m_9781181b() {
      return this.f_8b78ac44 / 100 == 2;
   }

   public C0140 m_f5dba2b6(File var1) {
      this.f_b38989d1 = (var2, var3) -> {
         try (FileOutputStream var4 = new FileOutputStream(var1)) {
            byte[] var7 = new byte[4096];

            int var6;
            while ((var6 = var3.read(var7)) != -1) {
               var4.write(var7, 0, var6);
            }

            this.m_ddacd97c(C0252.bootstrap<"get",51539607645>() + var1.getName());
         } catch (Exception var18) {
            this.m_ddacd97c(C0252.bootstrap<"get",51539607646>() + var18.getMessage());
            this.m_802e3bf3(500);
            if (var1.exists() && !var1.delete()) {
               var1.deleteOnExit();
            }
         }
      };
      return this;
   }

   public void m_cfcaf3a3(HttpURLConnection var1) throws Exception {
      this.f_8b78ac44 = var1.getResponseCode();
      if (this.f_8b78ac44 == 204) {
         this.m_ddacd97c(C0252.bootstrap<"get",51539607641>());
      } else {
         try (InputStream var2 = this.m_9781181b() ? var1.getInputStream() : var1.getErrorStream()) {
            if (this.f_8b78ac44 == 200) {
               this.f_b38989d1.accept(this, var2);
            } else {
               f_200fe2a2.accept(this, var2);
            }
         }
      }
   }

   public String m_6c2c384f() {
      return C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",70>(), this.f_3aacfcbb);
   }

   public void m_2a4d2195(List<String> var1) {
      this.f_3aacfcbb = var1;
   }

   public void m_ddacd97c(String var1) {
      this.f_3aacfcbb.add(var1);
   }

   public C0140() {
   }

   public int m_c74e1657() {
      return this.f_8b78ac44;
   }

   public List<String> m_f463879e() {
      return this.f_3aacfcbb;
   }

   public BiConsumer<C0140, InputStream> m_9d5dabfe() {
      return this.f_b38989d1;
   }

   public void m_802e3bf3(int var1) {
      this.f_8b78ac44 = var1;
   }

   public void m_e9ce8fc0(BiConsumer<C0140, InputStream> var1) {
      this.f_b38989d1 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0140)) {
         return false;
      } else {
         C0140 var2 = (C0140)var1;
         if (!var2.m_a498c095(this)) {
            return false;
         } else if (this.m_c74e1657() != var2.m_c74e1657()) {
            return false;
         } else {
            List var3 = this.m_f463879e();
            List var4 = var2.m_f463879e();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               BiConsumer var5 = this.m_9d5dabfe();
               BiConsumer var6 = var2.m_9d5dabfe();
               return var5 == null ? var6 == null : var5.equals(var6);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_a498c095(Object var1) {
      return var1 instanceof C0140;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + this.m_c74e1657();
      List var3 = this.m_f463879e();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      BiConsumer var4 = this.m_9d5dabfe();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   @Override
   public String toString() {
      return C0252.bootstrap<"get",51539607642>()
         + this.m_c74e1657()
         + C0252.bootstrap<"get",51539607643>()
         + this.m_f463879e()
         + C0252.bootstrap<"get",51539607644>()
         + this.m_9d5dabfe()
         + C0252.bootstrap<"get",59>();
   }
}
