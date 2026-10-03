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
import java.util.stream.Collectors;

public class C0140 {
   public static final Gson f_ff6bbba6 = C0198.m_cde2d310().create();
   public static final BiConsumer<C0140, InputStream> f_0a098466 = (var0, var1) -> {
      try (BufferedReader var2 = new BufferedReader(new InputStreamReader(var1))) {
         var0.m_1793329a(var2.lines().collect(Collectors.toList()));
      } catch (Exception var15) {
         var0.m_256015fc(C0255.m_65c7e6e6() + var15.getMessage());
         var0.m_46938bdb(500);
      }
   };
   private int f_ddf2abf7;
   private List<String> f_616514a5 = new ArrayList<>();
   private BiConsumer<C0140, InputStream> f_b84b3a25 = f_0a098466;

   public <T> T m_3ccb9922(Class<T> var1) {
      return (T)f_ff6bbba6.fromJson(this.m_e07cee76(), var1);
   }

   public JsonObject m_f7ec0040() {
      return this.m_3ccb9922(JsonObject.class);
   }

   public boolean m_9362a920() {
      return this.f_ddf2abf7 / 100 == 2;
   }

   public C0140 m_7978999d(File var1) {
      this.f_b84b3a25 = (var2, var3) -> {
         try (FileOutputStream var4 = new FileOutputStream(var1)) {
            byte[] var7 = new byte[4096];

            int var6;
            while ((var6 = var3.read(var7)) != -1) {
               var4.write(var7, 0, var6);
            }

            this.m_256015fc(C0255.m_9bf0a29a() + var1.getName());
         } catch (Exception var18) {
            this.m_256015fc(C0255.m_85cd13b4() + var18.getMessage());
            this.m_46938bdb(500);
            if (var1.exists() && !var1.delete()) {
               var1.deleteOnExit();
            }
         }
      };
      return this;
   }

   public void m_a457177c(HttpURLConnection var1) throws Exception {
      this.f_ddf2abf7 = var1.getResponseCode();
      if (this.f_ddf2abf7 == 204) {
         this.m_256015fc(C0255.m_1b17f04f());
      } else {
         try (InputStream var2 = this.m_9362a920() ? var1.getInputStream() : var1.getErrorStream()) {
            if (this.f_ddf2abf7 == 200) {
               this.f_b84b3a25.accept(this, var2);
            } else {
               f_0a098466.accept(this, var2);
            }
         }
      }
   }

   public String m_e07cee76() {
      return String.join(C0257.m_593ecbab(), this.f_616514a5);
   }

   public void m_1793329a(List<String> var1) {
      this.f_616514a5 = var1;
   }

   public void m_256015fc(String var1) {
      this.f_616514a5.add(var1);
   }

   public C0140() {
   }

   public int m_36ffc578() {
      return this.f_ddf2abf7;
   }

   public List<String> m_e991ec61() {
      return this.f_616514a5;
   }

   public BiConsumer<C0140, InputStream> m_2aed7b0d() {
      return this.f_b84b3a25;
   }

   public void m_46938bdb(int var1) {
      this.f_ddf2abf7 = var1;
   }

   public void m_ee5d3d0f(BiConsumer<C0140, InputStream> var1) {
      this.f_b84b3a25 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof C0140)) {
         return false;
      } else {
         C0140 var2 = (C0140)var1;
         if (!var2.m_22ad6203(this)) {
            return false;
         } else if (this.m_36ffc578() != var2.m_36ffc578()) {
            return false;
         } else {
            List var3 = this.m_e991ec61();
            List var4 = var2.m_e991ec61();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               BiConsumer var5 = this.m_2aed7b0d();
               BiConsumer var6 = var2.m_2aed7b0d();
               return var5 == null ? var6 == null : var5.equals(var6);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean m_22ad6203(Object var1) {
      return var1 instanceof C0140;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + this.m_36ffc578();
      List var3 = this.m_e991ec61();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      BiConsumer var4 = this.m_2aed7b0d();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   @Override
   public String toString() {
      return C0255.m_bcef2112() + this.m_36ffc578() + C0255.m_114677c2() + this.m_e991ec61() + C0255.m_fac478b2() + this.m_2aed7b0d() + C0257.m_9e27f038();
   }
}
