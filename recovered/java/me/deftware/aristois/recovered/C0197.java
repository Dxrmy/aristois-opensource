package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;

public class C0197 {
   public static final Message f_9607505d = Message.of("");
   public static final String f_8b0d0e49 = C0256.m_e8fd0250();
   public static final String f_f446f0c6 = Arrays.stream(DefaultColors.values())
      .map(var0 -> ((Character)var0.getCode().get()).toString())
      .collect(Collectors.joining());

   public C0197() {
   }

   public static Message m_2130da9b(String var0, String var1, Appearance var2) {
      if (!var0.contains(var1)) {
         return Message.of(var0).style(var2);
      } else {
         int var3 = 0;
         Builder var4 = new Builder();
         FormattingColor var5 = null;
         String var6 = C0267.m_a29090eb() + var1 + C0256.m_16315846() + C0256.m_e8fd0250() + f_f446f0c6 + C0256.m_d0da63e8();
         String[] var7 = var0.split(C0256.m_0425f2ec() + var6 + C0256.m_1b17f04f() + var6 + C0257.m_9e27f038());

         for (String var11 : var7) {
            if (var11.matches(var6)) {
               char var12 = var11.charAt(1);
               if (var12 == 'r') {
                  var3 = 0;
                  var5 = null;
               } else if (var12 >= 'k' && var12 <= 'o') {
                  int var13 = var12 - 'k';
                  var3 |= 1 << var13;
               } else {
                  var5 = (FormattingColor)DefaultColors.CODE_TO_RGB.get(var12);
               }
            } else {
               Appearance var14 = var2;
               if (var5 != null) {
                  var14 = var2.color(var5);
               }

               if (var3 > 0) {
                  var14 = var14.format(var3);
               }

               var4.append(var11, var14);
            }
         }

         return var4.build();
      }
   }

   public static Message m_683b6390(String var0, String var1) {
      return m_2130da9b(var0, var1, Appearance.empty());
   }

   public static Message m_3e1df413(Message var0, Function<String, Boolean> var1) {
      StringBuilder var2 = new StringBuilder();
      Builder var3 = new Builder(null);
      Optional var4 = var0.visit((var3x, var4x) -> {
         if ((Boolean)var1.apply(var2 + var4x)) {
            for (int var5 = 0; var5 < var4x.length(); var5++) {
               Object var6 = var4x.substring(0, var5);
               if ((Boolean)var1.apply(var2 + var6)) {
                  return Optional.of(Message.of(var6 + C0254.m_a004d745()).style(var3x));
               }
            }
         }

         var2.append(var4x);
         var3.append(Message.of(var4x).style(var3x));
         return Optional.empty();
      });
      var4.ifPresent(var3::append);
      return var3.build();
   }

   public static boolean m_6bc011d7(Message var0, String var1) {
      return var0.string().toLowerCase().contains(var1.toLowerCase());
   }

   public abstract static class anonymousthis implements BiFunction<Appearance, String, Optional<Message>> {
      private int f_8a2d7173 = 0;

      public anonymousthis() {
      }

      public Optional<Message> m_93c007fc(Appearance var1, String var2) {
         return this.m_ec723980(this.f_8a2d7173++, var1, var2);
      }

      protected abstract Optional<Message> m_ec723980(int var1, Appearance var2, String var3);
   }
}
