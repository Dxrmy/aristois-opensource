package me.deftware.aristois.recovered;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatReceive;
import me.deftware.client.framework.helper.Logger;
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.message.Message;

public class C0355 extends AbstractMod {
   @C0098(
      value = "Name",
      description = {"Name to replace yours with in chat"}
   )
   private String f_e67d985b = C0260.m_c688f8ca();
   private static final Logger f_07ecf97e = new Logger(C0260.m_022da1b4());

   public C0355() {
      super(C0260.m_3d3a8736(), C0290.f_99d080af, C0260.m_94acbdac());
   }

   @EventHandler
   public void m_f84326ec(EventChatReceive var1) {
      Message var2 = var1.getMessage().mutate((var1x, var2x) -> {
         Message var3x = Message.of(var2x.replace(SessionHelper.getPlayerUsername(), this.f_e67d985b)).style(var1x);
         return Optional.of(var3x);
      });
      var1.setMessage(var2);
      if (C0213.f_c4662ff3.m_efa7610e()) {
         C0355.anonymousconst var3 = new C0355.anonymousconst();
         UUID var4 = var3.m_c1fb2b7f(var1);
         UUID var5 = C0217.m_edf212e5(SessionHelper.getPlayerUUID());
         if (var4.equals(var5)) {
            var3.m_e13822db(var1, Message.of(this.f_e67d985b));
         }
      }
   }

   public static class anonymousclass<T> {
      private Class<T> f_48d38c66;
      private Map<String, Method> f_663041e0 = new HashMap<>();

      public anonymousclass(Class<T> var1) {
         this.f_48d38c66 = var1;
      }

      public <E> E m_b9a36cef(T var1, String var2, Object... var3) {
         try {
            Method var4 = this.f_663041e0.get(var2);
            Object var5 = var4.invoke(var1, var3);
            if (var5 != null) {
               return (E)var5;
            }
         } catch (Exception var6) {
            C0355.f_07ecf97e.error(C0260.m_afb31f66(), new Object[]{var2, this.f_48d38c66.getSimpleName(), var6});
         }

         return null;
      }

      public void m_f2131a68(String var1, Class<?>... var2) {
         try {
            Method var3 = this.f_48d38c66.getMethod(var1, var2);
            this.f_663041e0.put(var1, var3);
         } catch (Exception var4) {
            C0355.f_07ecf97e.error(C0260.m_c254a253(), new Object[]{var1, this.f_48d38c66.getSimpleName(), var4});
         }
      }
   }

   public static class anonymousconst extends C0355.anonymousclass<EventChatReceive> {
      public anonymousconst() {
         super(EventChatReceive.class);
         this.m_f2131a68(C0260.m_56d4c1c7(), new Class[0]);
         this.m_f2131a68(C0260.m_d32ebe65(), new Class[]{Message.class});
      }

      public UUID m_c1fb2b7f(EventChatReceive var1) {
         return this.m_b9a36cef(var1, C0260.m_56d4c1c7(), new Object[0]);
      }

      public void m_e13822db(EventChatReceive var1, Message var2) {
         this.m_b9a36cef(var1, C0260.m_d32ebe65(), new Object[]{var2});
      }
   }
}
