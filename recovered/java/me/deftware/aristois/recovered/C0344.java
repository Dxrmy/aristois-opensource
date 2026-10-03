package me.deftware.aristois.recovered;

import java.math.BigInteger;
import java.security.SecureRandom;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.network.packets.CPacketChatMessage;

@C0421
public class C0344 extends AbstractMod {
   private SecureRandom f_3695fb89 = new SecureRandom();
   @C0098("Message")
   private String f_97136e28 = C0252.bootstrap<"get",47244640269>();
   @C0098(
      value = "Message interval",
      description = {"Delay to wait between messages"},
      number = @C0096(
         min = 1.0,
         max = 500.0
      )
   )
   private float f_6752d720 = 8.0F;
   @C0098("Interval")
   private C0102<C0344.anonymousconst> f_046f741a = new C0102<>(C0344.anonymousconst.f_285850a4);
   @C0098(
      value = "Anti Anti-Spam",
      description = {"Prevent anti-spam plugins from blocking you by appending a random string to your message"}
   )
   private boolean f_e00b7523 = true;
   @C0098("Anti-Spam Length")
   private int f_4b5ae833 = 16;
   private long f_b9fa49ac = 0L;

   public C0344() {
      super(C0252.bootstrap<"get",47244640267>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640268>());
   }

   @EventHandler
   private void m_b3af099c(EventUpdate var1) {
      long var2 = C0114.bootstrap<"call",0,1>() - this.f_b9fa49ac;
      if ((float)var2 >= (float)this.f_046f741a.m_e2691446().m_d313f0ad() * this.f_6752d720) {
         this.f_b9fa49ac = C0114.bootstrap<"call",0,1>();
         if (!C0114.bootstrap<"call",1,1>(this.f_97136e28)) {
            StringBuilder var4 = new StringBuilder(this.f_97136e28);
            if (this.f_e00b7523) {
               String var5 = new BigInteger(130, this.f_3695fb89).toString(this.f_4b5ae833);
               var4.append(C0252.bootstrap<"get",47244640270>()).append(var5).append(C0252.bootstrap<"get",47244640271>());
            }

            new CPacketChatMessage(var4.toString()).sendPacket();
         }
      }
   }

   private static enum anonymousconst {
      f_bf3ed6a5(1L),
      f_285850a4(1000L),
      f_3ffe28f3(60000L);

      private final long f_e7b3e17b;

      public long m_d313f0ad() {
         return this.f_e7b3e17b;
      }

      private anonymousconst(long var3) {
         this.f_e7b3e17b = var3;
      }
   }
}
