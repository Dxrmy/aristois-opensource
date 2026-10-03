package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0064 {
   private final Appearance f_39e2ade4;
   private List<Message> f_1d5ed69b;
   private Message f_3d7b00dc;

   private C0064(Appearance var1) {
      this.f_39e2ade4 = var1;
   }

   public C0064 m_d574e88d(Message var1) {
      this.f_3d7b00dc = var1.style(this.f_39e2ade4);
      return this;
   }

   public C0064 m_2c2620fc(String var1) {
      return this.m_d574e88d(Message.of(var1));
   }

   public C0064 m_f41992de(Message... var1) {
      this.f_1d5ed69b = Arrays.asList(var1);
      return this;
   }

   public C0064 m_ee04ba1b(String... var1) {
      Message[] var2 = new Message[var1.length];

      for (int var3 = 0; var3 < var1.length; var3++) {
         var2[var3] = Message.of(var1[var3]);
      }

      return this.m_f41992de(var2);
   }

   public C0064 m_ecf8e7ae(String var1, Object... var2) {
      if (this.f_1d5ed69b == null) {
         this.f_1d5ed69b = new ArrayList<>();
      }

      this.f_1d5ed69b.add(Message.of(String.format(var1, var2)));
      return this;
   }

   public void m_1058ed9a() {
      C0269.f_44d31626.m_dfae9307(new C0287(this.f_3d7b00dc, this.f_1d5ed69b.toArray(new Message[0])).m_6a1b300a()).m_547191bb();
   }

   public void m_b728afce() {
      for (Message var2 : this.f_1d5ed69b) {
         C0001.m_3ce42128(C0264.m_5fa6dd07()).append(var2, this.f_39e2ade4).build().print();
      }
   }

   public void m_0e265701() {
   }

   public static C0064 m_13c9ffeb() {
      return new C0064(Appearance.of(DefaultColors.GRAY)).m_2c2620fc(C0264.m_35cdaa1a());
   }

   public static C0064 m_7853c016() {
      return new C0064(Appearance.of(DefaultColors.YELLOW)).m_2c2620fc(C0255.m_65d43991());
   }

   public static C0064 m_b79f2e94() {
      return new C0064(Appearance.of(2, DefaultColors.RED)).m_2c2620fc(C0255.m_a5b24d28());
   }
}
