package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.InteractableBlock;
import me.deftware.client.framework.world.block.types.ChestBlock;
import me.deftware.client.framework.world.block.types.CropBlock;
import me.deftware.client.framework.world.block.types.ShulkerBlock;
import me.deftware.client.framework.world.block.types.StorageBlock;

public class C0123 implements C0131<Block> {
   public C0123() {
   }

   public void m_3c1141d9(JsonWriter var1, Block var2) throws IOException {
      var1.name(C0252.bootstrap<"get",12884901991>());
      var1.value(var2.getIdentifierKey());
   }

   public Block m_12f2534f(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return (Block)BlockRegistry.INSTANCE.find(var1.nextString()).orElseThrow(() -> new IOException(C0252.bootstrap<"get",12884901992>() + var2));
   }

   public List<Class<? extends Block>> m_a3feba4f() {
      return C0114.bootstrap<"call",0,1>(
         new Class[]{Block.class, InteractableBlock.class, CropBlock.class, ChestBlock.class, ShulkerBlock.class, StorageBlock.class}
      );
   }
}
