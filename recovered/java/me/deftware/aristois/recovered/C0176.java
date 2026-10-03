package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import com.mojang.brigadier.arguments.ArgumentType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.world.block.Block;

public class C0176<T extends ListItem> extends C0150 {
   private final List<C0176.anonymousconst> f_502684ce = new ArrayList<>();
   protected String f_390eff5e = C0252.bootstrap<"get",21474836558>();
   protected String f_a718e34f = C0252.bootstrap<"get",21474836558>();
   protected C0157 f_d6facf5f;
   protected int f_9688bf44 = 250;
   protected C0154 f_6f2d1b06;
   protected final Class<T> f_82bc9ca0;

   public C0176(C0174<T> var1, Class<T> var2) {
      super(var1);
      this.f_82bc9ca0 = var2;
   }

   public List<T> m_07c29cf3() {
      return ((C0174)this.parent).m_8ae54c80();
   }

   protected void m_3c3121cd() {
      this.addCenteredText(C0114.bootstrap<"call",0,1>() / 2, 30, C0114.bootstrap<"call",1,1>(this.f_390eff5e));
      this.m_40e5fe88(new C0163[]{this.m_de151c43()});
      this.m_0d1c3de6();
   }

   protected void m_0d1c3de6() {
      byte var1 = 115;
      short var2 = 250;
      this.m_40e5fe88(
         new C0163[]{
            new C0155(C0114.bootstrap<"call",0,1>() / 2, C0114.bootstrap<"call",1,1>() - 50, (float)var2, (float)var1, this)
               .m_5d3ed1f2(
                  this.f_6f2d1b06 = this.m_f1ec1cf1(0, 0, (float)var1, C0114.bootstrap<"call",2,1>(this.f_a718e34f), this::m_7cbabcd2)
                     .m_dc08502f(this::m_d663cad8),
                  this.m_f1ec1cf1(0, 0, (float)var1, C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",17179869310>()), this::goBack)
               )
         }
      );
   }

   protected boolean m_d663cad8() {
      return this.m_355930d7(
         this.f_502684ce
            .stream()
            .filter(var0 -> !var0.m_10a86a32())
            .map(C0176.anonymousconst::m_5e98bf61)
            .filter(var0 -> var0 instanceof C0157)
            .map(C0157.class::cast)
            .toArray(C0157[]::new)
      );
   }

   protected C0156 m_de151c43() {
      return new C0156((double)((float)C0114.bootstrap<"call",0,1>() / 2.0F - (float)this.f_9688bf44 / 2.0F), 60.0, this)
         .m_a411e7ce(this.m_6e4a873b(this.f_82bc9ca0, null))
         .m_8391599b(20.0F);
   }

   protected ArgumentType<?> m_9a9a4e2e() {
      if (C0114.bootstrap<"call",0,1>() < 393) {
         return null;
      } else if (Block.class.isAssignableFrom(this.f_82bc9ca0)) {
         return new C0003();
      } else {
         return Item.class.isAssignableFrom(this.f_82bc9ca0) ? new C0008() : null;
      }
   }

   protected T m_30f8de54(T var1) {
      if (this.f_502684ce.isEmpty()) {
         throw new RuntimeException(C0252.bootstrap<"get",21474836562>());
      } else {
         try {
            for (C0176.anonymousconst var3 : this.f_502684ce) {
               String var4 = var3.m_5e98bf61().toString();
               if (var3.m_339e5156() == C0249.class) {
                  C0249 var5 = var3.m_3a22ca3f(var1);
                  var5.m_990e4d32(var4);
               } else {
                  var3.m_2a927f22(var1, var4);
               }
            }

            return (T)var1;
         } catch (Exception var6) {
            return null;
         }
      }
   }

   protected void m_7cbabcd2() {
      try {
         ListItem var1 = this.m_30f8de54(this.f_82bc9ca0.getDeclaredConstructor().newInstance());
         if (var1 != null) {
            this.m_6197e575((T)var1);
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   protected void m_6197e575(T var1) {
      this.m_07c29cf3().add((T)var1);
      this.goBack();
   }

   public C0163[] m_6e4a873b(Class<T> var1, T var2) {
      this.f_502684ce.clear();

      for (Field var5 : C0114.bootstrap<"call",2,1>(var1)) {
         try {
            if (var5.isAnnotationPresent(SerializedName.class)) {
               C0176.anonymousconst var6 = new C0176.anonymousconst(var5);
               if (var6.m_b353a507() && var6.m_4dae28fc()) {
                  var6.m_1a75daea(this, var2, this.f_9688bf44, this.m_9a9a4e2e());
                  this.f_502684ce.add(var6);
               }
            }
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }

      return this.f_502684ce.stream().map(C0176.anonymousconst::m_5e98bf61).toArray(C0163[]::new);
   }

   @Target({ElementType.FIELD})
   @Retention(RetentionPolicy.RUNTIME)
   public @interface anonymousclass {
      boolean visible() default true;

      boolean optional() default false;
   }

   private static class anonymousconst {
      private final Field f_981b390c;
      private String f_cbf608c9;
      private boolean f_2639d96f = true;
      private boolean f_02ce1831;
      private C0163 f_8ca9f91a;

      public anonymousconst(Field var1) {
         this.f_981b390c = var1;
         this.f_cbf608c9 = ((SerializedName)var1.getAnnotation((Class<T>)SerializedName.class)).value();
         this.f_cbf608c9 = this.f_cbf608c9.substring(0, 1).toUpperCase() + this.f_cbf608c9.substring(1);
         if (var1.isAnnotationPresent(C0176.anonymousclass.class)) {
            C0176.anonymousclass var2 = var1.getAnnotation(C0176.anonymousclass.class);
            this.f_2639d96f = var2.visible();
            this.f_02ce1831 = var2.optional();
         }
      }

      public Class<?> m_339e5156() {
         return this.f_981b390c.getType();
      }

      public boolean m_b353a507() {
         return this.f_981b390c.getType() == String.class || this.f_981b390c.getType() == C0249.class || this.f_981b390c.getType() == boolean.class;
      }

      public void m_2a927f22(Object var1, Object var2) throws Exception {
         this.f_981b390c.set(var1, var2);
      }

      public <T> T m_3a22ca3f(Object var1) throws Exception {
         return (T)this.f_981b390c.get(var1);
      }

      public void m_1a75daea(C0150 var1, Object var2, int var3, ArgumentType<?> var4) throws Exception {
         Message var5 = C0114.bootstrap<"call",0,1>(this.f_cbf608c9 + (this.f_02ce1831 ? C0252.bootstrap<"get",21474836561>() : ""));
         Object var6 = var2 != null ? this.f_981b390c.get(var2) : null;
         if (this.m_339e5156() == String.class || this.m_339e5156() == C0249.class) {
            this.f_8ca9f91a = var1.m_96a83982(0, 0, var3, var5, var4);
            ((C0157)this.f_8ca9f91a).m_00c3febe()._setMaxLength(999);
            if (this.f_981b390c.getType() == C0249.class) {
               ((C0157)this.f_8ca9f91a).m_00c3febe()._setPasswordMode(true);
            }

            if (var6 != null) {
               ((C0157)this.f_8ca9f91a).m_63ef8c45(var6.toString());
            }
         } else if (this.m_339e5156() == boolean.class) {
            this.f_8ca9f91a = new C0152(0, 0, 20, 20, var6 != null && (Boolean)var6);
            ((C0152)this.f_8ca9f91a).m_044b304a(var5);
         }
      }

      public boolean m_4dae28fc() {
         return this.f_2639d96f;
      }

      public boolean m_10a86a32() {
         return this.f_02ce1831;
      }

      public C0163 m_5e98bf61() {
         return this.f_8ca9f91a;
      }
   }
}
