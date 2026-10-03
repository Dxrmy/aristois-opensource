package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
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

   public void m_a6a1e820(JsonWriter var1, Block var2) throws IOException {
      var1.name(C0266.m_c04d8f6e());
      var1.value(var2.getIdentifierKey());
   }

   public Block m_4427975c(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return (Block)BlockRegistry.INSTANCE.find(var1.nextString()).orElseThrow(() -> new IOException(C0266.m_2dc36b02() + var2));
   }

   @Override
   public List<Class<? extends Block>> m_350b5ae0() {
      return Arrays.asList(Block.class, InteractableBlock.class, CropBlock.class, ChestBlock.class, ShulkerBlock.class, StorageBlock.class);
   }
}
