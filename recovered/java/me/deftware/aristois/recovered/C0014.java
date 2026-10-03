package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.command.EMCModCommand;
import me.deftware.client.framework.message.Message;

public class C0014 implements Runnable {
   public static final C0014 f_def608a1 = new C0014();
   public static final DynamicCommandExceptionType f_319020fa = new DynamicCommandExceptionType(
      var0 -> Message.of(C0264.m_bdbd5e40() + var0 + C0264.m_c04d8f6e())
   );

   public C0014() {
   }

   public C0014 m_1da4980c(Class<? extends EMCModCommand> var1) {
      try {
         if (C0095.m_22ad6203(var1)) {
            CommandRegister.registerCommand((EMCModCommand)var1.newInstance());
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return this;
   }

   public void m_65236224(final String var1, final Runnable var2) {
      CommandRegister.registerCommand(new EMCModCommand() {
         public CommandBuilder<?> getCommandBuilder() {
            return new CommandBuilder().set((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(var1).executes(var1xx -> {
               var2.run();
               return 1;
            }));
         }
      });
   }

   @Override
   public void run() {
      this.m_1da4980c(C0027.class);
      this.m_1da4980c(C0015.class);
      this.m_1da4980c(C0043.class);
      this.m_1da4980c(C0035.class);
      this.m_1da4980c(C0033.class);
      this.m_1da4980c(C0022.class);
      this.m_1da4980c(C0038.class);
      this.m_1da4980c(C0019.class);
      this.m_1da4980c(C0031.class);
      this.m_1da4980c(C0020.class);
      this.m_1da4980c(C0024.class);
      this.m_1da4980c(C0037.class);
      this.m_1da4980c(C0032.class);
      this.m_1da4980c(C0042.class);
      this.m_1da4980c(C0016.class);
      this.m_1da4980c(C0036.class);
      this.m_1da4980c(C0028.class);
      this.m_1da4980c(C0040.class);
      this.m_1da4980c(C0026.class);
      this.m_1da4980c(C0017.class);
      this.m_1da4980c(C0030.class);
      this.m_1da4980c(C0039.class);
      this.m_1da4980c(C0041.class);
      this.m_1da4980c(C0018.class);
      this.m_1da4980c(C0021.class);
      this.m_1da4980c(C0029.class);
      this.m_1da4980c(C0025.class);
      this.m_1da4980c(C0452.class);
      this.m_1da4980c(C0034.class);
   }
}
