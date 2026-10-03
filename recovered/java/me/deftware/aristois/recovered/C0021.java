package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import me.deftware.aristois.services.Registry;
import me.deftware.client.framework.command.types.AbstractPagedOutputCommand;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0021 extends AbstractPagedOutputCommand {
   public C0021() {
      super(C0266.m_b48a8bc4(), Message.of(C0266.m_b886ae1c()));
   }

   public List<Message> list() {
      return Arrays.stream(Registry.values())
         .filter(Registry::isAvailable)
         .map(var0 -> Message.of(var0.getName()).style(Appearance.of(DefaultColors.GRAY)))
         .collect(Collectors.toList());
   }
}
