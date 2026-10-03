package me.deftware.aristois.recovered;

import com.google.gson.JsonObject;
import me.deftware.client.framework.helper.SessionHelper;

public class C0138 {
   public C0138() {
   }

   public static boolean m_bc0226ab(String var0, String var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty(C0257.m_a19a564f(), SessionHelper.getAccessToken());
      var2.addProperty(C0264.m_022da1b4(), var1.replaceAll(C0264.m_18204724(), ""));
      var2.addProperty(C0264.m_6e2d03c3(), var0);
      C0140 var3 = new C0139(C0264.m_760db7bb()).m_5bfd94bd(C0139.anonymousdefault.f_3ced4cdc).m_6e76d0fa(var2).m_0017133f();
      return var3.m_36ffc578() == 204;
   }
}
