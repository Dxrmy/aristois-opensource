package me.deftware.aristois.recovered;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.concurrent.CompletableFuture;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message.Builder;

public class C0034 extends C0001 {
   public static final String f_58a2a114 = C0264.m_a5b24d28();
   public static final String f_e94bd1d2 = C0264.m_4cbaf16f();

   public C0034() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .addCommand(
            C0264.m_2dc36b02(),
            var0 -> {
               print(C0257.m_ec329d2e());
               CompletableFuture.runAsync(
                  () -> {
                     try {
                        C0034.anonymouscatch var0x = m_48333368();
                        print(
                           new Builder()
                              .append(C0264.m_e9a52709(), Appearance.of(2, DefaultColors.GRAY))
                              .append(var0x.f_85b673d8, Appearance.of(2, DefaultColors.AQUA))
                              .append(C0264.m_37c08c9d(), Appearance.of(2, DefaultColors.GRAY))
                              .append(var0x.f_9508a4da.f_f3275c0b, Appearance.of(2, DefaultColors.RED))
                              .build()
                        );
                     } catch (Exception var1) {
                        var1.printStackTrace();
                        error(C0264.m_1472ab32());
                     }
                  }
               );
            }
         );
   }

   public static C0034.anonymouscatch m_48333368() throws Exception {
      if (!C0138.m_bc0226ab(C0264.m_4cbaf16f(), SessionHelper.getPlayerUUID())) {
         throw new Exception(C0257.m_15737526());
      } else {
         JsonObject var0 = new JsonObject();
         var0.addProperty(C0257.m_85cd13b4(), SessionHelper.getPlayerUsername());
         C0140 var1 = new C0139(C0264.m_678c4ddb())
            .m_5bfd94bd(C0139.anonymousdefault.f_3ced4cdc)
            .m_e794b2f5(C0139.anonymousthis.f_a9e237e2)
            .m_6e76d0fa(var0)
            .m_0017133f();
         if (!var1.m_9362a920()) {
            throw new Exception(C0264.m_1672ac4d());
         } else {
            return var1.m_3ccb9922(C0034.anonymouscatch.class);
         }
      }
   }

   static class anonymouscatch {
      @SerializedName("code")
      public String f_85b673d8;
      @SerializedName("expires")
      public C0034$catch$const f_9508a4da;

      public anonymouscatch() {
      }
   }
}
