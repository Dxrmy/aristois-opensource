package me.deftware.aristois.recovered;

import java.util.HashMap;
import me.deftware.client.framework.message.Message;

public class C0160 extends C0154 {
   private int f_ea049fbb = -1;
   private int f_3867d020 = -1;
   private boolean f_80d6e71c = false;
   private boolean f_24d28288 = false;
   private final HashMap<Integer, Integer> f_b3db0065 = C0114.bootstrap<"call",2,1>(
      new Integer[]{
         C0114.bootstrap<"call",1,1>(342),
         C0114.bootstrap<"call",1,1>(4),
         C0114.bootstrap<"call",1,1>(346),
         C0114.bootstrap<"call",1,1>(4),
         C0114.bootstrap<"call",1,1>(340),
         C0114.bootstrap<"call",1,1>(1),
         C0114.bootstrap<"call",1,1>(344),
         C0114.bootstrap<"call",1,1>(1),
         C0114.bootstrap<"call",1,1>(341),
         C0114.bootstrap<"call",1,1>(2),
         C0114.bootstrap<"call",1,1>(345),
         C0114.bootstrap<"call",1,1>(2)
      }
   );

   public C0160(int var1, int var2, int var3, int var4) {
      super(var1, var2, var3, var4, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803861>()));
   }

   public void m_7a9b0e8d(boolean var1) {
      this.f_24d28288 = var1;
      this.m_8ed45a10().setComponentLabel(this.m_9fbe65e7());
   }

   public C0160 m_84cbfc35(int var1) {
      this.f_ea049fbb = this.f_3867d020 = var1;
      this.m_8ed45a10().setComponentLabel(this.m_9fbe65e7());
      return this;
   }

   private Message m_9fbe65e7() {
      return C0114.bootstrap<"call",1,1>(
         this.f_80d6e71c
            ? C0252.bootstrap<"get",25769803862>() + (this.f_24d28288 ? C0252.bootstrap<"get",25769803863>() : C0252.bootstrap<"get",25769803864>())
            : (
               this.f_ea049fbb == -1
                  ? C0252.bootstrap<"get",12884901917>() + (this.f_24d28288 ? C0252.bootstrap<"get",25769803863>() : C0252.bootstrap<"get",25769803865>())
                  : C0114.bootstrap<"call",0,1>(this.f_3867d020)
            )
      );
   }

   public boolean m_38fb8507(int var1, int var2, int var3) {
      if (this.f_80d6e71c) {
         this.f_80d6e71c = false;
         this.f_3867d020 = var1;
         this.f_ea049fbb = this.f_24d28288 ? this.f_b3db0065.getOrDefault(C0114.bootstrap<"call",0,1>(var1), C0114.bootstrap<"call",0,1>(-1)) : var1;
         this.m_8ed45a10().setComponentLabel(this.m_9fbe65e7());
         return true;
      } else {
         return false;
      }
   }

   public boolean m_18293c2c(double var1, double var3, int var5) {
      this.m_38fb8507(var5, 1, 0);
      return false;
   }

   public boolean m_085761e7(int var1) {
      this.f_80d6e71c = !this.f_80d6e71c;
      this.m_8ed45a10().setComponentLabel(this.m_9fbe65e7());
      return true;
   }

   public int m_12ad4521() {
      return this.f_ea049fbb;
   }

   public int m_51155580() {
      return this.f_3867d020;
   }

   public boolean m_fd997280() {
      return this.f_80d6e71c;
   }

   public boolean m_5fc8bfb5() {
      return this.f_24d28288;
   }

   public HashMap<Integer, Integer> m_7ef47516() {
      return this.f_b3db0065;
   }
}
