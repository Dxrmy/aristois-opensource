package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.client.framework.command.CommandBuilder;

public class C0028 extends C0001 {
   public C0028() {
   }

   public C0005 m_909ff768() {
      return new C0005(new C0005.anonymouscatch() {
         public int m_1381141f() {
            return C0114.bootstrap<"call",0,1>().size();
         }

         public String m_9eeb2109(int var1) {
            return ((C0250)C0114.bootstrap<"call",0,1>().get(var1)).m_84e98a9f();
         }
      });
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934636>())
                     .then(
                        C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934629>())
                           .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",94>(), C0114.bootstrap<"call",1,1>()).executes(var1 -> {
                              this.m_ae21e997(true, C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",94>()));
                              return 1;
                           }))
                     ))
                  .then(
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",101>())
                        .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",94>(), this.m_909ff768()).executes(var1 -> {
                           this.m_ae21e997(false, C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",94>()));
                           return 1;
                        }))
                  ))
               .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934631>()).executes(var0 -> {
                  C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934639>());
                  C0114.bootstrap<"call",0,1>().forEach(var0x -> C0114.bootstrap<"call",2,1>(var0x.m_84e98a9f()));
                  return 1;
               }))
         );
   }

   public void m_ae21e997(boolean var1, String var2) {
      C0250 var3 = new C0250();
      var3.m_323c653d(var2);
      if (var1) {
         C0114.bootstrap<"call",0,1>().add(var3);
         C0114.bootstrap<"call",1,1>().m_5de8d0b8(C0252.bootstrap<"get",8589934637>(), var2).m_66e721c0();
      } else {
         C0114.bootstrap<"call",0,1>().remove(var3);
         C0114.bootstrap<"call",1,1>().m_5de8d0b8(C0252.bootstrap<"get",8589934638>(), var2).m_66e721c0();
      }
   }
}
