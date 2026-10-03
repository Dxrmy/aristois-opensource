package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.EMCModCommand;

public class C0014 implements Runnable {
   public static final C0014 f_70e27a90 = new C0014();
   public static final DynamicCommandExceptionType f_0f364a0c = new DynamicCommandExceptionType(
      var0 -> C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967398>() + var0 + C0252.bootstrap<"get",4294967399>())
   );

   public C0014() {
   }

   public C0014 m_e04d25fd(Class<? extends EMCModCommand> var1) {
      try {
         if (C0114.bootstrap<"call",0,1>(var1)) {
            C0114.bootstrap<"call",1,1>((EMCModCommand)var1.newInstance());
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return this;
   }

   public void m_4c507275(final String var1, final Runnable var2) {
      C0114.bootstrap<"call",1,1>(new EMCModCommand() {
         public CommandBuilder<?> getCommandBuilder() {
            return new CommandBuilder().set((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(var1).executes(var1xx -> {
               var2.run();
               return 1;
            }));
         }
      });
   }

   @Override
   public void run() {
      this.m_e04d25fd(C0027.class);
      this.m_e04d25fd(C0015.class);
      this.m_e04d25fd(C0043.class);
      this.m_e04d25fd(C0035.class);
      this.m_e04d25fd(C0033.class);
      this.m_e04d25fd(C0022.class);
      this.m_e04d25fd(C0038.class);
      this.m_e04d25fd(C0019.class);
      this.m_e04d25fd(C0031.class);
      this.m_e04d25fd(C0020.class);
      this.m_e04d25fd(C0024.class);
      this.m_e04d25fd(C0037.class);
      this.m_e04d25fd(C0032.class);
      this.m_e04d25fd(C0042.class);
      this.m_e04d25fd(C0016.class);
      this.m_e04d25fd(C0036.class);
      this.m_e04d25fd(C0028.class);
      this.m_e04d25fd(C0040.class);
      this.m_e04d25fd(C0026.class);
      this.m_e04d25fd(C0017.class);
      this.m_e04d25fd(C0030.class);
      this.m_e04d25fd(C0039.class);
      this.m_e04d25fd(C0041.class);
      this.m_e04d25fd(C0018.class);
      this.m_e04d25fd(C0021.class);
      this.m_e04d25fd(C0029.class);
      this.m_e04d25fd(C0025.class);
      this.m_e04d25fd(C0452.class);
      this.m_e04d25fd(C0034.class);
   }
}
