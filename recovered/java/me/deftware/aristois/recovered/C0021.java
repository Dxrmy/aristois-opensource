package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.aristois.services.Registry;
import me.deftware.client.framework.command.types.AbstractPagedOutputCommand;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0021 extends AbstractPagedOutputCommand {
   public C0021() {
      super(C0252.bootstrap<"get",12884901908>(), C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901909>()));
   }

   public List<Message> list() {
      return C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>())
         .filter(Registry::isAvailable)
         .map(var0 -> C0114.bootstrap<"call",0,1>(var0.getName()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GRAY)))
         .collect(C0114.bootstrap<"call",2,1>());
   }
}
