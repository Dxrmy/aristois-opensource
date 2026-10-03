package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;

public class C0043 extends C0001 {
   public C0043() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901910>())
               .then(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901911>(), new C0004(false)).executes(var0 -> {
                  AbstractMod var1 = (AbstractMod)var0.getArgument(C0252.bootstrap<"get",12884901911>(), AbstractMod.class);
                  C0114.bootstrap<"call",0,1>().runOnRenderThread(() -> C0114.bootstrap<"call",0,1>().openScreen(new C0190(var1.getKeybind(), null)));
                  return 1;
               }))
         );
   }
}
