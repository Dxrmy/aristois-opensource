package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0145 extends C0144 {
   @SerializedName("ip")
   private String f_13722055;
   @SerializedName("port")
   private String f_691a110d;
   @SerializedName("protocols")
   private List<String> f_315c43ae;
   @SerializedName("anonymityLevel")
   private String f_a5672ed2;
   @SerializedName("country")
   private String f_33bc5233;
   @SerializedName("city")
   private String f_19c7864b;
   @SerializedName("speed")
   private int f_de8b419e;

   public C0145() {
   }

   public String getUsername() {
      return null;
   }

   public String getPassword() {
      return null;
   }

   public String getAddress() {
      return this.f_13722055 + C0267.m_0d6ae39b() + this.f_691a110d;
   }

   public int getVersion() {
      return this.f_315c43ae.get(0).endsWith(C0262.m_056a389d()) ? 5 : 4;
   }

   @Override
   protected Message[] m_91be39c9() {
      return new Message[]{
         Message.of(String.format(C0255.m_03430357(), this.m_efa63665(this.f_19c7864b, 30), this.f_33bc5233)).style(Appearance.of(this.m_43cd70a2())),
         new Builder()
            .append(this.f_13722055 + C0266.m_56cd5284(), Appearance.of(DefaultColors.GRAY))
            .append(this.f_de8b419e + C0255.m_ec329d2e(), Appearance.of(this.m_4de4a42d(this.f_de8b419e)))
            .build()
      };
   }

   private String m_efa63665(String var1, int var2) {
      return var1 != null && var1.length() > var2 ? var1.substring(0, var2) + C0254.m_a004d745() : var1;
   }
}
