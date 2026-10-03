package me.deftware.aristois.recovered;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.config.Settings;
import org.apache.commons.lang3.StringUtils;

public class C0219<T> extends AbstractList<T> {
   private final Class<T> f_f56e9422;
   private final C0125 f_bfc89d79;
   protected List<T> f_2acc0bd9 = new CopyOnWriteArrayList<>();
   protected List<T> f_d4c21b24 = new ArrayList<>();
   private final String f_89af993d;
   private boolean f_97b23827;
   private final List<BiConsumer<T, Boolean>> f_a09fd544 = new ArrayList<>();

   public C0219(Class<T> var1, String var2) {
      this(var1, var2, true);
   }

   public C0219(Class<T> var1, String var2, boolean var3) {
      this.f_f56e9422 = var1;
      this.f_89af993d = var2;
      this.f_bfc89d79 = C0125.f_94eb86f7;
      this.f_97b23827 = var3;
      if (!StringUtils.isEmpty(var2)) {
         if (var3) {
            Main.getConfig().getShutdownQueue().add(this::m_fdb05c09);
         }

         this.m_a13a31bc();
      }
   }

   public C0219(Class<T> var1, String var2, JsonArray var3) {
      this(var1, var2);
      var3.forEach(var2x -> {
         try {
            this.f_d4c21b24.add((T)this.f_bfc89d79.m_b3b664ad(var2x, var1));
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      });
      if (this.isEmpty()) {
         this.f_2acc0bd9.addAll(this.f_d4c21b24);
      }
   }

   @SafeVarargs
   public C0219(Class<T> var1, String var2, T... var3) {
      this(var1, var2);
      this.f_d4c21b24.addAll(Arrays.asList((T[])var3));
      if (this.isEmpty()) {
         this.f_2acc0bd9.addAll(this.f_d4c21b24);
      }
   }

   @Override
   public T get(int var1) {
      return this.f_2acc0bd9.get(var1);
   }

   @Override
   public int size() {
      return this.f_2acc0bd9.size();
   }

   @Override
   public T remove(int var1) {
      Object var2 = this.f_2acc0bd9.remove(var1);
      this.m_cef1a7b6((T)var2, true);
      return (T)var2;
   }

   @Override
   public boolean remove(Object var1) {
      boolean var2 = this.f_2acc0bd9.remove(var1);
      if (var2) {
         this.m_cef1a7b6((T)var1, true);
      }

      return var2;
   }

   @Override
   public boolean add(T var1) {
      this.f_2acc0bd9.add((T)var1);
      this.m_cef1a7b6((T)var1, false);
      return true;
   }

   public boolean m_bf96552f(JsonElement var1) {
      try {
         Object var2 = this.f_bfc89d79.m_b3b664ad(var1, this.f_f56e9422);
         this.f_2acc0bd9.add((T)var2);
         this.m_cef1a7b6((T)var2, false);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return true;
   }

   @Override
   public void add(int var1, T var2) {
      this.f_2acc0bd9.add(var1, (T)var2);
      this.m_cef1a7b6((T)var2, false);
   }

   public void m_41e83f88() {
      this.clear();
      if (!this.f_d4c21b24.isEmpty()) {
         this.addAll(this.f_d4c21b24);
      }
   }

   @Override
   public boolean contains(Object var1) {
      boolean var2 = super.contains(var1);
      if (!var2) {
         for (Object var4 : this.f_2acc0bd9) {
            if (var4.equals(var1)) {
               return true;
            }
         }
      }

      return var2;
   }

   protected void m_cef1a7b6(T var1, boolean var2) {
      if (this.f_97b23827) {
         this.m_fdb05c09();
      }

      this.f_a09fd544.forEach(var2x -> var2x.accept((T)var1, var2));
   }

   public JsonArray m_d788a065() {
      JsonArray var1 = new JsonArray();
      this.f_2acc0bd9.forEach(var2 -> var1.add(this.f_bfc89d79.m_a7c6d791(var2, var2.getClass())));
      return var1;
   }

   public C0219<T> m_50cef0e3(JsonArray var1) {
      var1.forEach(var1x -> {
         try {
            this.add((T)this.f_bfc89d79.m_b3b664ad(var1x, this.m_5ce6615d()));
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      });
      return this;
   }

   public C0219<T> m_fdb05c09() {
      Main.getConfig().putArray(this.f_89af993d, this.m_d788a065());
      Main.getConfig().save();
      return this;
   }

   public C0219<T> m_a13a31bc() {
      if (Main.getConfig().hasKey(this.f_89af993d)) {
         this.m_50cef0e3(Main.getConfig().getArray(this.f_89af993d));
      }

      return this;
   }

   public Class<T> m_5ce6615d() {
      return this.f_f56e9422;
   }

   public C0125 m_b299a0a9() {
      return this.f_bfc89d79;
   }

   public List<T> m_93a86be0() {
      return this.f_2acc0bd9;
   }

   public List<T> m_a2a4e197() {
      return this.f_d4c21b24;
   }

   public String m_c42f1c7e() {
      return this.f_89af993d;
   }

   public boolean m_f0e7dcaa() {
      return this.f_97b23827;
   }

   public List<BiConsumer<T, Boolean>> m_8db15fc6() {
      return this.f_a09fd544;
   }

   public static class anonymousthis<T> extends C0219<T> {
      private final Path f_ecb44f20;

      public anonymousthis(Class<T> var1, String var2) {
         super(var1, null);
         this.f_ecb44f20 = Settings.configDir.resolve(var2);
         Runtime.getRuntime().addShutdownHook(new Thread(this::m_fdb05c09));
         this.m_a13a31bc();
      }

      @Override
      public C0219<T> m_fdb05c09() {
         try {
            C0198.m_cc641daf(this.m_d788a065(), this.f_ecb44f20.toFile());
         } catch (Exception var2) {
            var2.printStackTrace();
         }

         return this;
      }

      @Override
      public C0219<T> m_a13a31bc() {
         try {
            if (Files.exists(this.f_ecb44f20)) {
               JsonArray var1 = C0198.m_19d60999(this.f_ecb44f20, JsonArray.class);
               this.m_50cef0e3(var1);
            }
         } catch (Exception var2) {
            var2.printStackTrace();
         }

         return this;
      }
   }
}
