package me.deftware.aristois.recovered;

import com.google.gson.JsonObject;

public class C0138 {
   public C0138() {
   }

   public static boolean m_3ef43cde(String var0, String var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty(C0252.bootstrap<"get",96>(), C0114.bootstrap<"call",0,1>());
      var2.addProperty(C0252.bootstrap<"get",4294967339>(), var1.replaceAll(C0252.bootstrap<"get",4294967313>(), ""));
      var2.addProperty(C0252.bootstrap<"get",4294967340>(), var0);
      C0140 var3 = new C0139(C0252.bootstrap<"get",4294967341>()).m_4404daa7(C0139.anonymousdefault.f_3523c07a).m_b0cb481e(var2).m_244f5552();
      return var3.m_c74e1657() == 204;
   }
}
