package me.deftware.aristois.recovered;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventChatReceive;
import me.deftware.client.framework.helper.Logger;
import me.deftware.client.framework.message.Message;

public class C0355 extends AbstractMod {
   @C0098(
      value = "Name",
      description = {"Name to replace yours with in chat"}
   )
   private String f_c05c840e = C0252.bootstrap<"get",47244640261>();
   private static final Logger f_9ada6b4f = new Logger(C0252.bootstrap<"get",47244640299>());

   public C0355() {
      super(C0252.bootstrap<"get",47244640297>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640298>());
   }

   @EventHandler
   public void m_d4a9c87f(EventChatReceive var1) {
      Message var2 = var1.getMessage().mutate((var1x, var2x) -> {
         Message var3x = C0114.bootstrap<"call",2,1>(var2x.replace(C0114.bootstrap<"call",3,1>(), this.f_c05c840e)).style(var1x);
         return C0114.bootstrap<"call",4,1>(var3x);
      });
      var1.setMessage(var2);
      if (C0213.f_35143dd3.m_093ae25a()) {
         C0355.anonymousconst var3 = new C0355.anonymousconst();
         UUID var4 = var3.m_55d6fc3d(var1);
         UUID var5 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>());
         if (var4.equals(var5)) {
            var3.m_de063455(var1, C0114.bootstrap<"call",2,1>(this.f_c05c840e));
         }
      }
   }

   public static class anonymousclass<T> {
      private Class<T> f_60256535;
      private Map<String, Method> f_95925c0d = new HashMap<>();

      public anonymousclass(Class<T> var1) {
         this.f_60256535 = var1;
      }

      public <E> E m_919459dd(T var1, String var2, Object... var3) {
         try {
            Method var4 = this.f_95925c0d.get(var2);
            Object var5 = var4.invoke(var1, var3);
            if (var5 != null) {
               return (E)var5;
            }
         } catch (Exception var6) {
            C0114.bootstrap<"call",0,1>().error(C0252.bootstrap<"get",47244640295>(), new Object[]{var2, this.f_60256535.getSimpleName(), var6});
         }

         return null;
      }

      public void m_d09d3146(String var1, Class<?>... var2) {
         try {
            Method var3 = this.f_60256535.getMethod(var1, var2);
            this.f_95925c0d.put(var1, var3);
         } catch (Exception var4) {
            C0114.bootstrap<"call",0,1>().error(C0252.bootstrap<"get",47244640296>(), new Object[]{var1, this.f_60256535.getSimpleName(), var4});
         }
      }
   }

   public static class anonymousconst extends C0355.anonymousclass<EventChatReceive> {
      public anonymousconst() {
         super(EventChatReceive.class);
         this.m_63367ca3(C0252.bootstrap<"get",47244640293>(), new Class[0]);
         this.m_63367ca3(C0252.bootstrap<"get",47244640294>(), new Class[]{Message.class});
      }

      public UUID m_55d6fc3d(EventChatReceive var1) {
         return (UUID)this.m_f85dd6f2(var1, C0252.bootstrap<"get",47244640293>(), new Object[0]);
      }

      public void m_de063455(EventChatReceive var1, Message var2) {
         this.m_f85dd6f2(var1, C0252.bootstrap<"get",47244640294>(), new Object[]{var2});
      }
   }
}
