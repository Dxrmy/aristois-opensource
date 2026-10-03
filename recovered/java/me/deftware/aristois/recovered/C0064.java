package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.List;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0064 {
   private final Appearance f_5d961d17;
   private List<Message> f_69634c5e;
   private Message f_73e4b7e3;

   private C0064(Appearance var1) {
      this.f_5d961d17 = var1;
   }

   public C0064 m_2b06cee8(Message var1) {
      this.f_73e4b7e3 = var1.style(this.f_5d961d17);
      return this;
   }

   public C0064 m_6b4e8235(String var1) {
      return this.m_2b06cee8(C0114.bootstrap<"call",0,1>(var1));
   }

   public C0064 m_b7d6d46c(Message... var1) {
      this.f_69634c5e = C0114.bootstrap<"call",1,1>(var1);
      return this;
   }

   public C0064 m_77a7bc18(String... var1) {
      Message[] var2 = new Message[var1.length];

      for (int var3 = 0; var3 < var1.length; var3++) {
         var2[var3] = C0114.bootstrap<"call",0,1>(var1[var3]);
      }

      return this.m_b7d6d46c(var2);
   }

   public C0064 m_5de8d0b8(String var1, Object... var2) {
      if (this.f_69634c5e == null) {
         this.f_69634c5e = new ArrayList<>();
      }

      this.f_69634c5e.add(C0114.bootstrap<"call",0,1>(C0114.bootstrap<"call",2,1>(var1, var2)));
      return this;
   }

   public void m_66e721c0() {
      C0269.f_13431579.m_71701f32(new C0287(this.f_73e4b7e3, this.f_69634c5e.toArray(new Message[0])).m_48761c0f()).m_2246a05a();
   }

   public void m_9d59fbe9() {
      for (Message var2 : this.f_69634c5e) {
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967324>()).append(var2, this.f_5d961d17).build().print();
      }
   }

   public void m_f0402f6b() {
   }

   public static C0064 m_6b025fec() {
      return new C0064(C0114.bootstrap<"call",0,1>(DefaultColors.GRAY)).m_6b4e8235(C0252.bootstrap<"get",4294967302>());
   }

   public static C0064 m_243a7c19() {
      return new C0064(C0114.bootstrap<"call",0,1>(DefaultColors.YELLOW)).m_6b4e8235(C0252.bootstrap<"get",51539607680>());
   }

   public static C0064 m_c28a0024() {
      return new C0064(C0114.bootstrap<"call",0,1>(2, DefaultColors.RED)).m_6b4e8235(C0252.bootstrap<"get",51539607663>());
   }
}
