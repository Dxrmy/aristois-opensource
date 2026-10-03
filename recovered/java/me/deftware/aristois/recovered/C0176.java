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
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.block.Block;

public class C0176<T extends ListItem> extends C0150 {
   private final List<C0176.anonymousconst> f_5c36729e = new ArrayList<>();
   protected String f_5422a71b = C0254.m_6dc2a812();
   protected String f_edfc67ab = C0254.m_6dc2a812();
   protected C0157 f_e80d78ff;
   protected int f_fba5d8e6 = 250;
   protected C0154 f_b8c39af3;
   protected final Class<T> f_62f64964;

   public C0176(C0174<T> var1, Class<T> var2) {
      super(var1);
      this.f_62f64964 = var2;
   }

   public List<T> m_39057c01() {
      return ((C0174)this.parent).m_a2a4e197();
   }

   @Override
   protected void m_1058ed9a() {
      this.addCenteredText(getScaledWidth() / 2, 30, Message.of(this.f_5422a71b));
      this.m_4f7d4126(new C0163[]{this.m_1d566344()});
      this.m_41e83f88();
   }

   protected void m_41e83f88() {
      byte var1 = 115;
      short var2 = 250;
      this.m_4f7d4126(
         new C0163[]{
            new C0155(getScaledWidth() / 2, getScaledHeight() - 50, (float)var2, (float)var1, this)
               .m_2ee4da8d(
                  this.f_b8c39af3 = this.m_79273652(0, 0, (float)var1, Message.of(this.f_edfc67ab), this::m_ae2c9744).m_798462fc(this::m_e0f7c666),
                  this.m_79273652(0, 0, (float)var1, Message.of(C0261.m_56c1229f()), this::goBack)
               )
         }
      );
   }

   protected boolean m_e0f7c666() {
      return this.m_8407423a(
         this.f_5c36729e
            .stream()
            .filter(var0 -> !var0.m_51ce03a5())
            .map(C0176.anonymousconst::m_688ca126)
            .filter(var0 -> var0 instanceof C0157)
            .map(C0157.class::cast)
            .toArray(C0157[]::new)
      );
   }

   protected C0156 m_1d566344() {
      return new C0156((double)((float)getScaledWidth() / 2.0F - (float)this.f_fba5d8e6 / 2.0F), 60.0, this)
         .m_482c862d(this.m_26cd5a7e(this.f_62f64964, null))
         .m_6da7ba87(20.0F);
   }

   protected ArgumentType<?> m_a4550b1c() {
      if (Minecraft.getMinecraftProtocolVersion() < 393) {
         return null;
      } else if (Block.class.isAssignableFrom(this.f_62f64964)) {
         return new C0003();
      } else {
         return Item.class.isAssignableFrom(this.f_62f64964) ? new C0008() : null;
      }
   }

   protected T m_8e694704(T var1) {
      if (this.f_5c36729e.isEmpty()) {
         throw new RuntimeException(C0254.m_11f0c704());
      } else {
         try {
            for (C0176.anonymousconst var3 : this.f_5c36729e) {
               String var4 = var3.m_688ca126().toString();
               if (var3.m_9ebc057e() == C0249.class) {
                  C0249 var5 = var3.m_8c218980(var1);
                  var5.m_8d32c72a(var4);
               } else {
                  var3.m_9e3f3b44(var1, var4);
               }
            }

            return (T)var1;
         } catch (Exception var6) {
            return null;
         }
      }
   }

   protected void m_ae2c9744() {
      try {
         ListItem var1 = this.m_8e694704(this.f_62f64964.getDeclaredConstructor().newInstance());
         if (var1 != null) {
            this.m_28f4b7eb((T)var1);
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   protected void m_28f4b7eb(T var1) {
      this.m_39057c01().add((T)var1);
      this.goBack();
   }

   public C0163[] m_26cd5a7e(Class<T> var1, T var2) {
      this.f_5c36729e.clear();

      for (Field var5 : C0217.m_dff4e28f(var1)) {
         try {
            if (var5.isAnnotationPresent(SerializedName.class)) {
               C0176.anonymousconst var6 = new C0176.anonymousconst(var5);
               if (var6.m_9362a920() && var6.m_89e0519f()) {
                  var6.m_48fb75af(this, var2, this.f_fba5d8e6, this.m_a4550b1c());
                  this.f_5c36729e.add(var6);
               }
            }
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }

      return this.f_5c36729e.stream().map(C0176.anonymousconst::m_688ca126).toArray(C0163[]::new);
   }

   @Target({ElementType.FIELD})
   @Retention(RetentionPolicy.RUNTIME)
   public @interface anonymousclass {
      boolean visible() default true;

      boolean optional() default false;
   }

   private static class anonymousconst {
      private final Field f_a42ce0e1;
      private String f_f1ceebae;
      private boolean f_6a2a0e3b = true;
      private boolean f_680773b7;
      private C0163 f_15542c31;

      public anonymousconst(Field var1) {
         this.f_a42ce0e1 = var1;
         this.f_f1ceebae = ((SerializedName)var1.getAnnotation((Class<T>)SerializedName.class)).value();
         this.f_f1ceebae = this.f_f1ceebae.substring(0, 1).toUpperCase() + this.f_f1ceebae.substring(1);
         if (var1.isAnnotationPresent(C0176.anonymousclass.class)) {
            C0176.anonymousclass var2 = var1.getAnnotation(C0176.anonymousclass.class);
            this.f_6a2a0e3b = var2.visible();
            this.f_680773b7 = var2.optional();
         }
      }

      public Class<?> m_9ebc057e() {
         return this.f_a42ce0e1.getType();
      }

      public boolean m_9362a920() {
         return this.f_a42ce0e1.getType() == String.class || this.f_a42ce0e1.getType() == C0249.class || this.f_a42ce0e1.getType() == boolean.class;
      }

      public void m_9e3f3b44(Object var1, Object var2) throws Exception {
         this.f_a42ce0e1.set(var1, var2);
      }

      public <T> T m_8c218980(Object var1) throws Exception {
         return (T)this.f_a42ce0e1.get(var1);
      }

      public void m_48fb75af(C0150 var1, Object var2, int var3, ArgumentType<?> var4) throws Exception {
         Message var5 = Message.of(this.f_f1ceebae + (this.f_680773b7 ? C0254.m_812ab029() : ""));
         Object var6 = var2 != null ? this.f_a42ce0e1.get(var2) : null;
         if (this.m_9ebc057e() == String.class || this.m_9ebc057e() == C0249.class) {
            this.f_15542c31 = var1.m_79f4267e(0, 0, var3, var5, var4);
            ((C0157)this.f_15542c31).m_6909040f()._setMaxLength(999);
            if (this.f_a42ce0e1.getType() == C0249.class) {
               ((C0157)this.f_15542c31).m_6909040f()._setPasswordMode(true);
            }

            if (var6 != null) {
               ((C0157)this.f_15542c31).m_333019c8(var6.toString());
            }
         } else if (this.m_9ebc057e() == boolean.class) {
            this.f_15542c31 = new C0152(0, 0, 20, 20, var6 != null && (Boolean)var6);
            ((C0152)this.f_15542c31).m_8d564dc2(var5);
         }
      }

      public boolean m_89e0519f() {
         return this.f_6a2a0e3b;
      }

      public boolean m_51ce03a5() {
         return this.f_680773b7;
      }

      public C0163 m_688ca126() {
         return this.f_15542c31;
      }
   }
}
