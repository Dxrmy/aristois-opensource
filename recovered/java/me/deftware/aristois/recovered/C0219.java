package me.deftware.aristois.recovered;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import me.deftware.client.framework.config.Settings;

public class C0219<T> extends AbstractList<T> {
   private final Class<T> f_65349cff;
   private final C0125 f_772a07ff;
   protected List<T> f_cf4e182c = new CopyOnWriteArrayList<>();
   protected List<T> f_f0c082a8 = new ArrayList<>();
   private final String f_1209411e;
   private boolean f_155cf561;
   private final List<BiConsumer<T, Boolean>> f_57582165 = new ArrayList<>();

   public C0219(Class<T> var1, String var2) {
      this(var1, var2, true);
   }

   public C0219(Class<T> var1, String var2, boolean var3) {
      this.f_65349cff = var1;
      this.f_1209411e = var2;
      this.f_772a07ff = C0125.f_70947d4f;
      this.f_155cf561 = var3;
      if (!C0114.bootstrap<"call",0,1>(var2)) {
         if (var3) {
            C0114.bootstrap<"call",1,1>().getShutdownQueue().add(this::m_3e4b2992);
         }

         this.m_6e45c8fa();
      }
   }

   public C0219(Class<T> var1, String var2, JsonArray var3) {
      this(var1, var2);
      var3.forEach(var2x -> {
         try {
            this.f_f0c082a8.add((T)this.f_772a07ff.m_5f630fc1(var2x, var1));
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      });
      if (this.isEmpty()) {
         this.f_cf4e182c.addAll(this.f_f0c082a8);
      }
   }

   @SafeVarargs
   public C0219(Class<T> var1, String var2, T... var3) {
      this(var1, var2);
      this.f_f0c082a8.addAll(C0114.bootstrap<"call",2,1>(var3));
      if (this.isEmpty()) {
         this.f_cf4e182c.addAll(this.f_f0c082a8);
      }
   }

   @Override
   public T get(int var1) {
      return this.f_cf4e182c.get(var1);
   }

   @Override
   public int size() {
      return this.f_cf4e182c.size();
   }

   @Override
   public T remove(int var1) {
      Object var2 = this.f_cf4e182c.remove(var1);
      this.m_2bf95354((T)var2, true);
      return (T)var2;
   }

   @Override
   public boolean remove(Object var1) {
      boolean var2 = this.f_cf4e182c.remove(var1);
      if (var2) {
         this.m_2bf95354((T)var1, true);
      }

      return var2;
   }

   @Override
   public boolean add(T var1) {
      this.f_cf4e182c.add((T)var1);
      this.m_2bf95354((T)var1, false);
      return true;
   }

   public boolean m_b6097a55(JsonElement var1) {
      try {
         Object var2 = this.f_772a07ff.m_5f630fc1(var1, this.f_65349cff);
         this.f_cf4e182c.add((T)var2);
         this.m_2bf95354((T)var2, false);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return true;
   }

   @Override
   public void add(int var1, T var2) {
      this.f_cf4e182c.add(var1, (T)var2);
      this.m_2bf95354((T)var2, false);
   }

   public void m_62c96cfe() {
      this.clear();
      if (!this.f_f0c082a8.isEmpty()) {
         this.addAll(this.f_f0c082a8);
      }
   }

   @Override
   public boolean contains(Object var1) {
      boolean var2 = super.contains(var1);
      if (!var2) {
         for (Object var4 : this.f_cf4e182c) {
            if (var4.equals(var1)) {
               return true;
            }
         }
      }

      return var2;
   }

   protected void m_2bf95354(T var1, boolean var2) {
      if (this.f_155cf561) {
         this.m_3e4b2992();
      }

      this.f_57582165.forEach(var2x -> var2x.accept((T)var1, C0114.bootstrap<"call",0,1>(var2)));
   }

   public JsonArray m_61dde10c() {
      JsonArray var1 = new JsonArray();
      this.f_cf4e182c.forEach(var2 -> var1.add(this.f_772a07ff.m_77b61bf9(var2, var2.getClass())));
      return var1;
   }

   public C0219<T> m_073bf4dd(JsonArray var1) {
      var1.forEach(var1x -> {
         try {
            this.add((T)this.f_772a07ff.m_5f630fc1(var1x, this.m_87bd75a8()));
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      });
      return this;
   }

   public C0219<T> m_3e4b2992() {
      C0114.bootstrap<"call",0,1>().putArray(this.f_1209411e, this.m_61dde10c());
      C0114.bootstrap<"call",0,1>().save();
      return this;
   }

   public C0219<T> m_6e45c8fa() {
      if (C0114.bootstrap<"call",0,1>().hasKey(this.f_1209411e)) {
         this.m_073bf4dd(C0114.bootstrap<"call",0,1>().getArray(this.f_1209411e));
      }

      return this;
   }

   public Class<T> m_87bd75a8() {
      return this.f_65349cff;
   }

   public C0125 m_65eff211() {
      return this.f_772a07ff;
   }

   public List<T> m_99e6aa32() {
      return this.f_cf4e182c;
   }

   public List<T> m_c831055d() {
      return this.f_f0c082a8;
   }

   public String m_749720b1() {
      return this.f_1209411e;
   }

   public boolean m_d8176196() {
      return this.f_155cf561;
   }

   public List<BiConsumer<T, Boolean>> m_f76e85c9() {
      return this.f_57582165;
   }

   public static class anonymousthis<T> extends C0219<T> {
      private final Path f_ec526712;

      public anonymousthis(Class<T> var1, String var2) {
         super(var1, null);
         this.f_ec526712 = Settings.configDir.resolve(var2);
         C0114.bootstrap<"call",0,1>().addShutdownHook(new Thread(this::m_f6b94184));
         this.m_04bb6667();
      }

      public C0219<T> m_f6b94184() {
         try {
            C0114.bootstrap<"call",0,1>(this.m_d0827ccc(), this.f_ec526712.toFile());
         } catch (Exception var2) {
            var2.printStackTrace();
         }

         return this;
      }

      public C0219<T> m_04bb6667() {
         try {
            if (C0114.bootstrap<"call",0,1>(this.f_ec526712, new LinkOption[0])) {
               JsonArray var1 = (JsonArray)C0114.bootstrap<"call",1,1>(this.f_ec526712, JsonArray.class);
               this.m_7a26db7a(var1);
            }
         } catch (Exception var2) {
            var2.printStackTrace();
         }

         return this;
      }
   }
}
