package me.deftware.aristois.recovered;

import java.util.List;
import java.util.stream.Collectors;
import me.deftware.client.framework.command.types.AbstractPagedOutputCommand;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0018 extends AbstractPagedOutputCommand {
   public C0018() {
      super(C0253.m_bcef2112(), Message.of(C0253.m_114677c2()).style(Appearance.of(DefaultColors.GREEN)));
      this.chunkSize = 10;
   }

   public List<Message> list() {
      return C0289.f_85a7343f.m_918b7b9e().map(var0 -> {
         Message var1 = Message.of(var0.m_6f1f396d() + C0264.m_023b99d9() + var0.getCategory().name());
         Message var2 = Message.of(String.join(C0264.m_03430357(), var0.getDescription()));
         var1.style(Appearance.of(DefaultColors.GRAY).withTextHoverEvent(var2));
         return var1;
      }).collect(Collectors.toList());
   }
}
