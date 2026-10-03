package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.command.types.AbstractPagedOutputCommand;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0018 extends AbstractPagedOutputCommand {
   public C0018() {
      super(
         C0252.bootstrap<"get",8589934682>(),
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934683>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GREEN))
      );
      this.chunkSize = 10;
   }

   public List<Message> list() {
      return C0289.f_c22b8d7e.m_ea73e1f0().map(var0 -> {
         Message var1 = C0114.bootstrap<"call",0,1>(var0.m_5aac041f() + C0252.bootstrap<"get",4294967410>() + var0.getCategory().name());
         Message var2 = C0114.bootstrap<"call",0,1>(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967393>(), var0.getDescription()));
         var1.style(C0114.bootstrap<"call",2,1>(DefaultColors.GRAY).withTextHoverEvent(var2));
         return var1;
      }).collect(C0114.bootstrap<"call",0,1>());
   }
}
