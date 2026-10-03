package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0043 extends C0001 {
   public C0043() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0266.m_bec91365())
               .then(RequiredArgumentBuilder.argument(C0266.m_79bfaec2(), new C0004(false)).executes(var0 -> {
                  AbstractMod var1 = (AbstractMod)var0.getArgument(C0266.m_79bfaec2(), AbstractMod.class);
                  Minecraft.getMinecraftGame().runOnRenderThread(() -> Minecraft.getMinecraftGame().openScreen(new C0190(var1.getKeybind(), null)));
                  return 1;
               }))
         );
   }
}
