package me.deftware.aristois.recovered;

import java.math.BigInteger;
import java.security.SecureRandom;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.network.packets.CPacketChatMessage;
import org.apache.commons.lang3.StringUtils;

@C0421
public class C0344 extends AbstractMod {
   private SecureRandom f_b13d3ec0 = new SecureRandom();
   @C0098("Message")
   private String f_7deb1c64 = C0260.m_15ef1a0d();
   @C0098(
      value = "Message interval",
      description = {"Delay to wait between messages"},
      number = @C0096(
         min = 1.0,
         max = 500.0
      )
   )
   private float f_b84ea93d = 8.0F;
   @C0098("Interval")
   private C0102<C0344.anonymousconst> f_4a771daf = new C0102<>(C0344.anonymousconst.f_196efe6c);
   @C0098(
      value = "Anti Anti-Spam",
      description = {"Prevent anti-spam plugins from blocking you by appending a random string to your message"}
   )
   private boolean f_ca01d2fd = true;
   @C0098("Anti-Spam Length")
   private int f_c8acc988 = 16;
   private long f_9756638e = 0L;

   public C0344() {
      super(C0260.m_6f1f396d(), C0290.f_99d080af, C0260.m_8ced16bd());
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      long var2 = System.currentTimeMillis() - this.f_9756638e;
      if ((float)var2 >= (float)this.f_4a771daf.m_284992ec().m_7054c744() * this.f_b84ea93d) {
         this.f_9756638e = System.currentTimeMillis();
         if (!StringUtils.isEmpty(this.f_7deb1c64)) {
            StringBuilder var4 = new StringBuilder(this.f_7deb1c64);
            if (this.f_ca01d2fd) {
               String var5 = new BigInteger(130, this.f_b13d3ec0).toString(this.f_c8acc988);
               var4.append(C0260.m_9793dfe2()).append(var5).append(C0260.m_1635bc47());
            }

            new CPacketChatMessage(var4.toString()).sendPacket();
         }
      }
   }

   private static enum anonymousconst {
      f_0af3747e(1L),
      f_196efe6c(1000L),
      f_32571de9(60000L);

      private final long f_faec803a;

      public long m_7054c744() {
         return this.f_faec803a;
      }

      private anonymousconst(long var3) {
         this.f_faec803a = var3;
      }
   }
}
