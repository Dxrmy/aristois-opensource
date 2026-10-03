package me.deftware.aristois.recovered;

import me.deftware.client.framework.command.CommandBuilder;

public class C0016 extends C0001 {
   public C0016() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().addCommand(C0252.bootstrap<"get",8589934655>(), var0 -> {
         C0114.bootstrap<"call",0,1>().m_77a7bc18(C0252.bootstrap<"get",98>()).m_66e721c0();
         C0114.bootstrap<"call",1,1>(() -> {
            try {
               C0034.anonymouscatch var0x = C0114.bootstrap<"call",2,1>();
               C0114.bootstrap<"call",0,1>().m_77a7bc18(C0252.bootstrap<"get",8589934656>()).m_66e721c0();
               C0114.bootstrap<"call",3,1>(C0146.f_c02c60c3.m_e3ec6b2f() + C0252.bootstrap<"get",8589934657>() + var0x.f_01555690);
            } catch (Exception var1) {
               var1.printStackTrace();
               C0114.bootstrap<"call",4,1>().m_77a7bc18(C0252.bootstrap<"get",8589934658>()).m_66e721c0();
            }
         });
      });
   }
}
