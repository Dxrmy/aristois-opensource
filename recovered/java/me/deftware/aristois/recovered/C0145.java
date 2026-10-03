package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0145 extends C0144 {
   @SerializedName("ip")
   private String f_af64646a;
   @SerializedName("port")
   private String f_61108198;
   @SerializedName("protocols")
   private List<String> f_46046f05;
   @SerializedName("anonymityLevel")
   private String f_e19dd3ca;
   @SerializedName("country")
   private String f_d69c7c89;
   @SerializedName("city")
   private String f_4ec37255;
   @SerializedName("speed")
   private int f_e8e18030;

   public C0145() {
   }

   public String getUsername() {
      return null;
   }

   public String getPassword() {
      return null;
   }

   public String getAddress() {
      return this.f_af64646a + C0252.bootstrap<"get",25769803903>() + this.f_61108198;
   }

   public int getVersion() {
      return this.f_46046f05.get(0).endsWith(C0252.bootstrap<"get",34359738395>()) ? 5 : 4;
   }

   protected Message[] m_62b20e4e() {
      return new Message[]{
         C0114.bootstrap<"call",1,1>(
               C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",51539607649>(), new Object[]{this.m_7f30252d(this.f_4ec37255, 30), this.f_d69c7c89})
            )
            .style(C0114.bootstrap<"call",2,1>(this.m_0c3db78a())),
         new Builder()
            .append(this.f_af64646a + C0252.bootstrap<"get",12884902010>(), C0114.bootstrap<"call",2,1>(DefaultColors.GRAY))
            .append(this.f_e8e18030 + C0252.bootstrap<"get",51539607650>(), C0114.bootstrap<"call",2,1>(this.m_22feacf5(this.f_e8e18030)))
            .build()
      };
   }

   private String m_7f30252d(String var1, int var2) {
      return var1 != null && var1.length() > var2 ? var1.substring(0, var2) + C0252.bootstrap<"get",21474836598>() : var1;
   }
}
