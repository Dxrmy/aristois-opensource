package me.deftware.aristois.recovered;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.List;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.types.AbstractPagedOutputCommand;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0022 extends AbstractPagedOutputCommand {
   public C0022() {
      super(
         C0252.bootstrap<"get",8589934626>(),
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934627>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GREEN))
      );
   }

   public C0005 m_59352df7() {
      return new C0005(new C0005.anonymouscatch() {
         public int m_cffb6940() {
            return C0114.bootstrap<"call",0,1>().size();
         }

         public String m_79d160f0(int var1) {
            return ((C0247)C0114.bootstrap<"call",0,1>().get(var1)).m_cd751ed2();
         }
      });
   }

   public List<Message> list() {
      return C0114.bootstrap<"call",0,1>()
         .stream()
         .map(var0 -> C0114.bootstrap<"call",2,1>(var0.m_cd751ed2()).style(C0114.bootstrap<"call",3,1>(DefaultColors.GRAY)))
         .collect(C0114.bootstrap<"call",1,1>());
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934628>())
                     .then(
                        C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934629>())
                           .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",94>(), C0114.bootstrap<"call",1,1>()).executes(var1 -> {
                              this.m_cd6a20ff(true, C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",94>()));
                              return 1;
                           }))
                     ))
                  .then(
                     ((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",101>())
                           .then(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",94>(), this.m_59352df7()).executes(var1 -> {
                              this.m_cd6a20ff(false, (String)var1.getArgument(C0252.bootstrap<"get",94>(), String.class));
                              return 1;
                           })))
                        .then(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934630>()).executes(var0 -> {
                           C0114.bootstrap<"call",0,1>().m_77a7bc18(C0252.bootstrap<"get",8589934635>()).m_66e721c0();
                           C0114.bootstrap<"call",1,1>().clear();
                           return 1;
                        }))
                  ))
               .then(
                  ((LiteralArgumentBuilder)C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934631>())
                        .then(
                           C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",8589934632>(), C0114.bootstrap<"call",3,1>(-1))
                              .executes(var1 -> this.onExecute(C0114.bootstrap<"call",0,1>(var1, C0252.bootstrap<"get",8589934632>())))
                        ))
                     .executes(var1 -> this.onExecute(0))
               )
         );
   }

   public void m_cd6a20ff(boolean var1, String var2) {
      C0247 var3 = new C0247();
      var3.m_bc6e3984(var2);
      if (var1) {
         C0114.bootstrap<"call",0,1>().add(var3);
         C0114.bootstrap<"call",1,1>().m_5de8d0b8(C0252.bootstrap<"get",8589934633>(), var2).m_66e721c0();
      } else {
         C0114.bootstrap<"call",0,1>().remove(var3);
         C0114.bootstrap<"call",1,1>().m_5de8d0b8(C0252.bootstrap<"get",8589934634>(), var2).m_66e721c0();
      }
   }
}
