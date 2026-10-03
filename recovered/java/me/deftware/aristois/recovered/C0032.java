package me.deftware.aristois.recovered;

import me.deftware.client.framework.command.CommandBuilder;

public class C0032 extends C0001 {
   public C0032() {
   }

   public CommandBuilder<?> getCommandBuilder() {
      return new CommandBuilder().addCommand(C0252.bootstrap<"get",8589934715>(), var0 -> {
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8589934716>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934717>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934718>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934719>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934720>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934721>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901888>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901889>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901890>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901891>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901892>());
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901893>());
         C0114.bootstrap<"call",2,1>().putPrimitive(C0252.bootstrap<"get",12884901894>(), true);
         C0114.bootstrap<"call",2,1>().save();
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12884901895>());
      });
   }
}
