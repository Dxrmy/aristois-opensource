package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;

public abstract class C0086 extends C0082 {
   private List<C0086.anonymousdefault> f_66e6f817;
   @C0098(
      value = "Primary",
      id = 15,
      description = {"The primary color"}
   )
   private Color f_65866f2c = Color.white;
   @C0098(
      value = "Secondary",
      id = 17,
      description = {"The secondary color"}
   )
   private Color f_b654b8a2 = this.f_65866f2c.darker();
   @C0098(
      value = "RGB",
      id = 16
   )
   protected boolean f_676ae6d0 = true;
   private boolean f_f30d0951 = false;
   private final C0084 f_58904714 = new C0083(33L);

   public C0086(String var1, C0087 var2, String... var3) {
      super(var1, var2, var3);
   }

   protected abstract Stream<C0086.anonymousdefault> m_cb07f77b();

   @Override
   public void m_083b6d08() {
      this.f_66e6f817 = this.m_cb07f77b().filter(C0086.anonymousdefault::m_efa7610e).peek(var1 -> {
         if (!this.f_676ae6d0) {
            var1.m_3c9b65c8(this.f_65866f2c, this.f_b654b8a2);
         }
      }).collect(Collectors.toList());
      this.f_f30d0951 = false;
      this.m_4edf5543(this.m_a7c622af());
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() >= 15) {
         if (var1.id() == 15) {
            this.f_b654b8a2 = this.f_65866f2c.darker();
         }

         this.m_083b6d08();
      } else {
         super.onSettingUpdate(var1);
      }
   }

   @Override
   public double m_a005efae() {
      return (double)(C0074.m_d996e5c5().getFontHeight() * this.m_ed46fa58().size());
   }

   @Override
   public double m_b199d4ff() {
      return this.m_ed46fa58().stream().mapToDouble(C0086.anonymousdefault::m_4388ac29).max().orElse(0.0);
   }

   @Override
   protected void m_4edf5543(C0087 var1) {
      if (this.m_a7c622af().m_51ce03a5() && !this.f_f30d0951 || !this.m_a7c622af().m_51ce03a5() && this.f_f30d0951) {
         this.f_f30d0951 = this.m_a7c622af().m_51ce03a5();
         Collections.reverse(this.f_66e6f817);
      }
   }

   @Override
   public void m_a172f6fe(double var1, double var3) {
      double var5 = this.m_b199d4ff();
      boolean var7 = this.f_58904714.m_efa7610e();
      int var8 = 0;

      for (int var9 = 1; var8 < this.m_ed46fa58().size(); var8++) {
         C0086.anonymousdefault var10 = this.m_ed46fa58().get(var8);
         var10.m_51ce03a5();
         if (this.f_676ae6d0 && var7) {
            var10.m_3c9b65c8(Color.getHSBColor(C0045.f_8f480fc4.m_796256b9() + 0.05F * (float)(var9++), 1.0F, 1.0F));
         }

         double var11 = var1;
         if (this.m_a7c622af().m_e0f7c666()) {
            var11 = var1 + var5 - var10.m_4388ac29();
         }

         C0074.m_d996e5c5().drawString(var11, var3, var10.m_5d92f796());
         var3 += (double)C0074.m_d996e5c5().getFontHeight();
      }
   }

   public List<C0086.anonymousdefault> m_ed46fa58() {
      return this.f_66e6f817;
   }

   public static class anonymousdefault {
      private Message f_67f78631;
      private C0084 f_1ba6104c = new C0083(10L);
      private boolean f_5fca5c32 = true;
      private String f_ceda3223 = C0265.m_afb31f66();
      private Supplier<Object>[] f_f9b9042a;
      private C0086.anonymousthis[] f_fa266609;
      private double f_0b7f6c21 = 0.0;

      public anonymousdefault() {
      }

      public final C0086.anonymousdefault m_42140133(String... var1) {
         Builder var2 = new Builder();
         this.f_fa266609 = new C0086.anonymousthis[(int)Arrays.stream(var1).filter(var0 -> var0.startsWith(C0265.m_c254a253())).count()];
         int var3 = 0;

         for (int var4 = 0; var3 < var1.length; var3++) {
            String var5 = var1[var3];
            if (var5.startsWith(C0265.m_c254a253())) {
               this.f_fa266609[var4++] = new C0086.anonymousthis(var5, var3 == 0 ? 0 : var3 + 1);
            }

            if (var3 != var1.length - 1) {
               var5 = var5 + C0257.m_593ecbab();
            }

            var2.append(var5);
         }

         this.f_67f78631 = var2.build();
         this.f_0b7f6c21 = (double)C0074.m_d996e5c5().getStringWidth(this.f_67f78631);
         return this;
      }

      public C0086.anonymousdefault m_b4a5d70c(Supplier<Object>... var1) {
         if (var1.length != this.f_fa266609.length) {
            throw new RuntimeException(C0265.m_3d3a8736() + this.f_fa266609.length + C0265.m_94acbdac() + var1.length);
         } else {
            this.f_f9b9042a = var1;
            return this;
         }
      }

      public C0086.anonymousdefault m_586decf3(C0084 var1) {
         this.f_1ba6104c = var1;
         return this;
      }

      public C0086.anonymousdefault m_be6f6998(Object var1) {
         this.f_ceda3223 = var1.toString();
         return this;
      }

      public double m_4388ac29() {
         return this.f_0b7f6c21;
      }

      public void m_b728afce() {
         this.f_0b7f6c21 = (double)C0074.m_d996e5c5().getStringWidth(this.f_67f78631);
      }

      public C0086.anonymousdefault m_3c9b65c8(final Color... var1) {
         final AtomicReference var2 = new AtomicReference<>(var1[0]);
         this.f_67f78631 = this.f_67f78631.mutate(new C0197.anonymousthis() {
            @Override
            protected Optional<Message> m_ec723980(int var1x, Appearance var2x, String var3) {
               Color var4;
               if (var1x < var1.length) {
                  var4 = (Color)var2.updateAndGet(var2xxx -> var1[var1x]);
               } else {
                  var4 = (Color)var2.updateAndGet(Color::darker);
               }

               var2x = var2x.color(FormattingColor.ofRGB(var4.getRGB()));
               return Optional.of(Message.of(var3).style(var2x));
            }
         });
         return this;
      }

      public boolean m_51ce03a5() {
         this.m_b728afce();
         if (this.f_f9b9042a != null && this.f_1ba6104c.m_efa7610e()) {
            for (int var1 = 0; var1 < this.f_fa266609.length; var1++) {
               final C0086.anonymousthis var2 = this.f_fa266609[var1];

               final String var3;
               try {
                  Supplier var4 = this.f_f9b9042a[var1];
                  var3 = var2.m_f8704d9c(var4.get());
               } catch (Exception var5) {
                  var3 = this.f_ceda3223;
               }

               this.f_67f78631 = this.f_67f78631.mutate(new C0197.anonymousthis() {
                  @Override
                  protected Optional<Message> m_ec723980(int var1, Appearance var2x, String var3x) {
                     return var1 == var2.m_79bbc2da() ? Optional.of(Message.of(var3).style(var2x)) : Optional.of(Message.of(var3x).style(var2x));
                  }
               });
            }

            return true;
         } else {
            return false;
         }
      }

      public void m_8d564dc2(Message var1) {
         this.f_67f78631 = var1;
      }

      public void m_75d5e394(C0084 var1) {
         this.f_1ba6104c = var1;
      }

      public void m_d6ac7420(boolean var1) {
         this.f_5fca5c32 = var1;
      }

      public void m_256015fc(String var1) {
         this.f_ceda3223 = var1;
      }

      public void m_be6a2ee6(Supplier<Object>[] var1) {
         this.f_f9b9042a = var1;
      }

      public void m_62a83b13(C0086.anonymousthis[] var1) {
         this.f_fa266609 = var1;
      }

      public void m_4b04f920(double var1) {
         this.f_0b7f6c21 = var1;
      }

      public Message m_5d92f796() {
         return this.f_67f78631;
      }

      public C0084 m_c896e224() {
         return this.f_1ba6104c;
      }

      public boolean m_efa7610e() {
         return this.f_5fca5c32;
      }

      public String m_b251ca51() {
         return this.f_ceda3223;
      }

      public Supplier<Object>[] m_aae81479() {
         return this.f_f9b9042a;
      }

      public C0086.anonymousthis[] m_e4ed114a() {
         return this.f_fa266609;
      }

      public double m_b2213d56() {
         return this.f_0b7f6c21;
      }
   }

   private static class anonymousthis {
      private final String f_91d665f6;
      private final int f_6e209614;

      public String m_f8704d9c(Object var1) {
         return !this.f_91d665f6.equalsIgnoreCase(C0267.m_5b2d5cb2()) ? String.format(this.f_91d665f6, var1) : var1.toString();
      }

      public String m_8d7dbe31() {
         return this.f_91d665f6;
      }

      public int m_79bbc2da() {
         return this.f_6e209614;
      }

      public anonymousthis(String var1, int var2) {
         this.f_91d665f6 = var1;
         this.f_6e209614 = var2;
      }
   }
}
