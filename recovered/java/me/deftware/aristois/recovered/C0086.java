package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Stream;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public abstract class C0086 extends C0082 {
   private List<C0086.anonymousdefault> f_3eab1ebe;
   @C0098(
      value = "Primary",
      id = 15,
      description = {"The primary color"}
   )
   private Color f_2f22c43c = Color.white;
   @C0098(
      value = "Secondary",
      id = 17,
      description = {"The secondary color"}
   )
   private Color f_ca158ed6 = this.f_2f22c43c.darker();
   @C0098(
      value = "RGB",
      id = 16
   )
   protected boolean f_cfd1329f = true;
   private boolean f_ae35af6b = false;
   private final C0084 f_e6c9b0d6 = new C0083(33L);

   public C0086(String var1, C0087 var2, String... var3) {
      super(var1, var2, var3);
   }

   protected abstract Stream<C0086.anonymousdefault> m_c5c18f53();

   public void m_998ee231() {
      this.f_3eab1ebe = this.m_c5c18f53().filter(C0086.anonymousdefault::m_30050e57).peek(var1 -> {
         if (!this.f_cfd1329f) {
            var1.m_6d175449(this.f_2f22c43c, this.f_ca158ed6);
         }
      }).collect(C0114.bootstrap<"call",0,1>());
      this.f_ae35af6b = false;
      this.m_2a04d669(this.m_0d26c07d());
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() >= 15) {
         if (var1.id() == 15) {
            this.f_ca158ed6 = this.f_2f22c43c.darker();
         }

         this.m_998ee231();
      } else {
         super.onSettingUpdate(var1);
      }
   }

   public double m_072087cb() {
      return (double)(C0114.bootstrap<"call",0,1>().getFontHeight() * this.m_79e0d788().size());
   }

   public double m_c89e8139() {
      return this.m_79e0d788().stream().mapToDouble(C0086.anonymousdefault::m_7c2d1617).max().orElse(0.0);
   }

   protected void m_2a04d669(C0087 var1) {
      if (this.m_0d26c07d().m_69611f66() && !this.f_ae35af6b || !this.m_0d26c07d().m_69611f66() && this.f_ae35af6b) {
         this.f_ae35af6b = this.m_0d26c07d().m_69611f66();
         C0114.bootstrap<"call",0,1>(this.f_3eab1ebe);
      }
   }

   public void m_7ce99631(double var1, double var3) {
      double var5 = this.m_c89e8139();
      boolean var7 = this.f_e6c9b0d6.m_80f25673();
      int var8 = 0;

      for (int var9 = 1; var8 < this.m_79e0d788().size(); var8++) {
         C0086.anonymousdefault var10 = this.m_79e0d788().get(var8);
         var10.m_320bbec2();
         if (this.f_cfd1329f && var7) {
            var10.m_6d175449(C0114.bootstrap<"call",1,1>(C0045.f_d228694b.m_8db20abd() + 0.05F * (float)(var9++), 1.0F, 1.0F));
         }

         double var11 = var1;
         if (this.m_0d26c07d().m_ac24d544()) {
            var11 = var1 + var5 - var10.m_7c2d1617();
         }

         C0114.bootstrap<"call",2,1>().drawString(var11, var3, var10.m_fee75816());
         var3 += (double)C0114.bootstrap<"call",2,1>().getFontHeight();
      }
   }

   public List<C0086.anonymousdefault> m_79e0d788() {
      return this.f_3eab1ebe;
   }

   public static class anonymousdefault {
      private Message f_1325cb75;
      private C0084 f_07c67d40 = new C0083(10L);
      private boolean f_f472b40b = true;
      private String f_a5fc6d59 = C0252.bootstrap<"get",30064771111>();
      private Supplier<Object>[] f_72224270;
      private C0086.anonymousthis[] f_efd80e81;
      private double f_e4b02910 = 0.0;

      public anonymousdefault() {
      }

      public final C0086.anonymousdefault m_25e003cb(String... var1) {
         Builder var2 = new Builder();
         this.f_efd80e81 = new C0086.anonymousthis[(int)C0114.bootstrap<"call",0,1>(var1)
            .filter(var0 -> var0.startsWith(C0252.bootstrap<"get",30064771112>()))
            .count()];
         int var3 = 0;

         for (int var4 = 0; var3 < var1.length; var3++) {
            String var5 = var1[var3];
            if (var5.startsWith(C0252.bootstrap<"get",30064771112>())) {
               this.f_efd80e81[var4++] = new C0086.anonymousthis(var5, var3 == 0 ? 0 : var3 + 1);
            }

            if (var3 != var1.length - 1) {
               var5 = var5 + C0252.bootstrap<"get",70>();
            }

            var2.append(var5);
         }

         this.f_1325cb75 = var2.build();
         this.f_e4b02910 = (double)C0114.bootstrap<"call",1,1>().getStringWidth(this.f_1325cb75);
         return this;
      }

      public C0086.anonymousdefault m_a514188a(Supplier<Object>... var1) {
         if (var1.length != this.f_efd80e81.length) {
            throw new RuntimeException(C0252.bootstrap<"get",30064771113>() + this.f_efd80e81.length + C0252.bootstrap<"get",30064771114>() + var1.length);
         } else {
            this.f_72224270 = var1;
            return this;
         }
      }

      public C0086.anonymousdefault m_1870ffef(C0084 var1) {
         this.f_07c67d40 = var1;
         return this;
      }

      public C0086.anonymousdefault m_5d91a6a3(Object var1) {
         this.f_a5fc6d59 = var1.toString();
         return this;
      }

      public double m_7c2d1617() {
         return this.f_e4b02910;
      }

      public void m_44909575() {
         this.f_e4b02910 = (double)C0114.bootstrap<"call",0,1>().getStringWidth(this.f_1325cb75);
      }

      public C0086.anonymousdefault m_6d175449(final Color... var1) {
         final AtomicReference var2 = new AtomicReference<>(var1[0]);
         this.f_1325cb75 = this.f_1325cb75.mutate(new C0197.anonymousthis() {
            protected Optional<Message> m_79484d48(int var1x, Appearance var2x, String var3) {
               Color var4;
               if (var1x < var1.length) {
                  var4 = (Color)var2.updateAndGet(var2xxx -> var1[var1x]);
               } else {
                  var4 = (Color)var2.updateAndGet(Color::darker);
               }

               var2x = var2x.color(C0114.bootstrap<"call",0,1>(var4.getRGB()));
               return C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var3).style(var2x));
            }
         });
         return this;
      }

      public boolean m_320bbec2() {
         this.m_44909575();
         if (this.f_72224270 != null && this.f_07c67d40.m_80f25673()) {
            for (int var1 = 0; var1 < this.f_efd80e81.length; var1++) {
               final C0086.anonymousthis var2 = this.f_efd80e81[var1];

               final String var3;
               try {
                  Supplier var4 = this.f_72224270[var1];
                  var3 = var2.m_2e879029(var4.get());
               } catch (Exception var5) {
                  var3 = this.f_a5fc6d59;
               }

               this.f_1325cb75 = this.f_1325cb75
                  .mutate(
                     new C0197.anonymousthis() {
                        protected Optional<Message> m_1af913a4(int var1, Appearance var2x, String var3x) {
                           return var1 == var2.m_914b0bb7()
                              ? C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var3).style(var2x))
                              : C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var3x).style(var2x));
                        }
                     }
                  );
            }

            return true;
         } else {
            return false;
         }
      }

      public void m_4e2ae724(Message var1) {
         this.f_1325cb75 = var1;
      }

      public void m_9dd00648(C0084 var1) {
         this.f_07c67d40 = var1;
      }

      public void m_da0b61a1(boolean var1) {
         this.f_f472b40b = var1;
      }

      public void m_d2a10b23(String var1) {
         this.f_a5fc6d59 = var1;
      }

      public void m_781e0df5(Supplier<Object>[] var1) {
         this.f_72224270 = var1;
      }

      public void m_e065fa8f(C0086.anonymousthis[] var1) {
         this.f_efd80e81 = var1;
      }

      public void m_8d6a04c4(double var1) {
         this.f_e4b02910 = var1;
      }

      public Message m_fee75816() {
         return this.f_1325cb75;
      }

      public C0084 m_41ea11b2() {
         return this.f_07c67d40;
      }

      public boolean m_30050e57() {
         return this.f_f472b40b;
      }

      public String m_eeb3a978() {
         return this.f_a5fc6d59;
      }

      public Supplier<Object>[] m_b7c77c13() {
         return this.f_72224270;
      }

      public C0086.anonymousthis[] m_36c9c139() {
         return this.f_efd80e81;
      }

      public double m_9391a763() {
         return this.f_e4b02910;
      }
   }

   private static class anonymousthis {
      private final String f_710a4e6b;
      private final int f_548cbd65;

      public String m_2e879029(Object var1) {
         return !this.f_710a4e6b.equalsIgnoreCase(C0252.bootstrap<"get",25769803897>())
            ? C0114.bootstrap<"call",0,1>(this.f_710a4e6b, new Object[]{var1})
            : var1.toString();
      }

      public String m_3d96bcdc() {
         return this.f_710a4e6b;
      }

      public int m_914b0bb7() {
         return this.f_548cbd65;
      }

      public anonymousthis(String var1, int var2) {
         this.f_710a4e6b = var1;
         this.f_548cbd65 = var2;
      }
   }
}
