package me.deftware.aristois.recovered;

import java.util.List;
import java.util.stream.Collectors;
import me.deftware.client.framework.command.types.AbstractPagedOutputCommand;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0019 extends AbstractPagedOutputCommand {
   public C0019() {
      super(C0264.m_a9b6ecd9(), Message.of(C0264.m_09052c0b()).style(Appearance.of(DefaultColors.GREEN)));
   }

   public List<Message> list() {
      return C0289.f_85a7343f
         .m_918b7b9e()
         .filter(var0 -> var0.getKeybind().m_36ffc578() != -1)
         .map(var0 -> Message.of(var0.m_6f1f396d() + C0264.m_023b99d9() + var0.getKeybind()).style(Appearance.of(DefaultColors.GRAY)))
         .collect(Collectors.toList());
   }
}
