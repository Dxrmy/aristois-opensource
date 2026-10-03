package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.command.types.AbstractPagedOutputCommand;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0019 extends AbstractPagedOutputCommand {
   public C0019() {
      super(
         C0252.bootstrap<"get",4294967408>(),
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967409>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GREEN))
      );
   }

   public List<Message> list() {
      return C0289.f_c22b8d7e
         .m_ea73e1f0()
         .filter(var0 -> var0.getKeybind().m_6978c604() != -1)
         .map(
            var0 -> C0114.bootstrap<"call",0,1>(var0.m_5aac041f() + C0252.bootstrap<"get",4294967410>() + var0.getKeybind())
                  .style(C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
         )
         .collect(C0114.bootstrap<"call",0,1>());
   }
}
