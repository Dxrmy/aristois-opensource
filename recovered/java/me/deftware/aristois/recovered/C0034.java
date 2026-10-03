package me.deftware.aristois.recovered;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message.Builder;

public class C0034 extends C0001 {
   public static final String f_14ce7973 = C0252.bootstrap<"get",4294967407>();
   public static final String f_b78672b6 = C0252.bootstrap<"get",4294967401>();

   public C0034() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .addCommand(
            C0252.bootstrap<"get",4294967400>(),
            var0 -> {
               C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",98>());
               C0114.bootstrap<"call",4,1>(
                  () -> {
                     try {
                        C0034.anonymouscatch var0x = C0114.bootstrap<"call",0,1>();
                        C0114.bootstrap<"call",2,1>(
                           new Builder()
                              .append(C0252.bootstrap<"get",4294967404>(), C0114.bootstrap<"call",1,1>(2, DefaultColors.GRAY))
                              .append(var0x.f_01555690, C0114.bootstrap<"call",1,1>(2, DefaultColors.AQUA))
                              .append(C0252.bootstrap<"get",4294967405>(), C0114.bootstrap<"call",1,1>(2, DefaultColors.GRAY))
                              .append(var0x.f_e7819685.f_4c178740, C0114.bootstrap<"call",1,1>(2, DefaultColors.RED))
                              .build()
                        );
                     } catch (Exception var1) {
                        var1.printStackTrace();
                        C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",4294967406>());
                     }
                  }
               );
            }
         );
   }

   public static C0034.anonymouscatch m_05625aff() throws Exception {
      if (!C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967401>(), C0114.bootstrap<"call",0,1>())) {
         throw new Exception(C0252.bootstrap<"get",63>());
      } else {
         JsonObject var0 = new JsonObject();
         var0.addProperty(C0252.bootstrap<"get",94>(), C0114.bootstrap<"call",2,1>());
         C0140 var1 = new C0139(C0252.bootstrap<"get",4294967402>())
            .m_4404daa7(C0139.anonymousdefault.f_3523c07a)
            .m_c40b048b(C0139.anonymousthis.f_06ff8b73)
            .m_b0cb481e(var0)
            .m_244f5552();
         if (!var1.m_9781181b()) {
            throw new Exception(C0252.bootstrap<"get",4294967403>());
         } else {
            return var1.m_13e100fc(C0034.anonymouscatch.class);
         }
      }
   }

   static class anonymouscatch {
      @SerializedName("code")
      public String f_01555690;
      @SerializedName("expires")
      public C0034$catch$const f_e7819685;

      public anonymouscatch() {
      }
   }
}
