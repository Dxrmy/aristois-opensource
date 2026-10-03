package me.deftware.aristois.recovered;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;
import me.deftware.client.framework.message.Message.Builder;

public class C0197 {
   public static final Message f_716a73fa = C0114.bootstrap<"call",0,1>("");
   public static final String f_ccf1faee = C0252.bootstrap<"get",55834574934>();
   public static final String f_4272109f = C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>())
      .map(var0 -> ((Character)var0.getCode().get()).toString())
      .collect(C0114.bootstrap<"call",3,1>());

   public C0197() {
   }

   public static Message m_0649f072(String var0, String var1, Appearance var2) {
      if (!var0.contains(var1)) {
         return C0114.bootstrap<"call",0,1>(var0).style(var2);
      } else {
         int var3 = 0;
         Builder var4 = new Builder();
         FormattingColor var5 = null;
         String var6 = C0252.bootstrap<"get",25769803850>()
            + var1
            + C0252.bootstrap<"get",55834574933>()
            + C0252.bootstrap<"get",55834574934>()
            + f_4272109f
            + C0252.bootstrap<"get",55834574935>();
         String[] var7 = var0.split(C0252.bootstrap<"get",55834574936>() + var6 + C0252.bootstrap<"get",55834574937>() + var6 + C0252.bootstrap<"get",59>());

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
                  var5 = (FormattingColor)DefaultColors.CODE_TO_RGB.get(C0114.bootstrap<"call",1,1>(var12));
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

   public static Message m_81541145(String var0, String var1) {
      return C0114.bootstrap<"call",3,1>(var0, var1, C0114.bootstrap<"call",2,1>());
   }

   public static Message m_b771ec29(Message var0, Function<String, Boolean> var1) {
      StringBuilder var2 = new StringBuilder();
      Builder var3 = new Builder(null);
      Optional var4 = var0.visit((var3x, var4x) -> {
         if ((Boolean)var1.apply(var2 + var4x)) {
            for (int var5 = 0; var5 < var4x.length(); var5++) {
               Object var6 = var4x.substring(0, var5);
               if ((Boolean)var1.apply(var2 + var6)) {
                  return C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",0,1>(var6 + C0252.bootstrap<"get",21474836598>()).style(var3x));
               }
            }
         }

         var2.append(var4x);
         var3.append(C0114.bootstrap<"call",0,1>(var4x).style(var3x));
         return C0114.bootstrap<"call",5,1>();
      });
      var4.ifPresent(var3::append);
      return var3.build();
   }

   public static boolean m_251f6470(Message var0, String var1) {
      return var0.string().toLowerCase().contains(var1.toLowerCase());
   }

   public abstract static class anonymousthis implements BiFunction<Appearance, String, Optional<Message>> {
      private int f_ceac3202 = 0;

      public anonymousthis() {
      }

      public Optional<Message> m_e5a14e8b(Appearance var1, String var2) {
         return this.m_f6cb6173(this.f_ceac3202++, var1, var2);
      }

      protected abstract Optional<Message> m_f6cb6173(int var1, Appearance var2, String var3);
   }
}
