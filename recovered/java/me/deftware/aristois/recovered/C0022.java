package me.deftware.aristois.recovered;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.List;
import java.util.stream.Collectors;
import me.deftware.client.framework.command.CommandBuilder;
import me.deftware.client.framework.command.types.AbstractPagedOutputCommand;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0022 extends AbstractPagedOutputCommand {
   public C0022() {
      super(C0253.m_e9914bd3(), Message.of(C0253.m_8631f87f()).style(Appearance.of(DefaultColors.GREEN)));
   }

   public C0005 m_9fb7fd90() {
      return new C0005(new C0005.anonymouscatch() {
         @Override
         public int m_79bbc2da() {
            return C0247.m_ee0ef813().size();
         }

         @Override
         public String m_5fe4c734(int var1) {
            return C0247.m_ee0ef813().get(var1).m_3d3a8736();
         }
      });
   }

   public List<Message> list() {
      return C0247.m_ee0ef813().stream().map(var0 -> Message.of(var0.m_3d3a8736()).style(Appearance.of(DefaultColors.GRAY))).collect(Collectors.toList());
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder()
         .set(
            (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_818e6498())
                     .then(
                        LiteralArgumentBuilder.literal(C0253.m_56d4c1c7())
                           .then(RequiredArgumentBuilder.argument(C0257.m_85cd13b4(), StringArgumentType.string()).executes(var1 -> {
                              this.m_e9e19dbb(true, StringArgumentType.getString(var1, C0257.m_85cd13b4()));
                              return 1;
                           }))
                     ))
                  .then(
                     ((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0257.m_0223faff())
                           .then(RequiredArgumentBuilder.argument(C0257.m_85cd13b4(), this.m_9fb7fd90()).executes(var1 -> {
                              this.m_e9e19dbb(false, (String)var1.getArgument(C0257.m_85cd13b4(), String.class));
                              return 1;
                           })))
                        .then(LiteralArgumentBuilder.literal(C0253.m_d32ebe65()).executes(var0 -> {
                           C0064.m_13c9ffeb().m_ee04ba1b(C0253.m_022da1b4()).m_1058ed9a();
                           C0247.m_ee0ef813().clear();
                           return 1;
                        }))
                  ))
               .then(
                  ((LiteralArgumentBuilder)LiteralArgumentBuilder.literal(C0253.m_afb31f66())
                        .then(
                           RequiredArgumentBuilder.argument(C0253.m_c254a253(), IntegerArgumentType.integer(-1))
                              .executes(var1 -> this.onExecute(IntegerArgumentType.getInteger(var1, C0253.m_c254a253())))
                        ))
                     .executes(var1 -> this.onExecute(0))
               )
         );
   }

   public void m_e9e19dbb(boolean var1, String var2) {
      C0247 var3 = new C0247();
      var3.m_a11708c5(var2);
      if (var1) {
         C0247.m_ee0ef813().add(var3);
         C0064.m_13c9ffeb().m_ecf8e7ae(C0253.m_3d3a8736(), var2).m_1058ed9a();
      } else {
         C0247.m_ee0ef813().remove(var3);
         C0064.m_13c9ffeb().m_ecf8e7ae(C0253.m_94acbdac(), var2).m_1058ed9a();
      }
   }
}
