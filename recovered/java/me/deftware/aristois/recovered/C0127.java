package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;

public class C0127 implements C0131<BlockPosition> {
   public C0127() {
   }

   public void m_7103b8e0(JsonWriter var1, BlockPosition var2) throws IOException {
      this.m_591bd658(var1, C0266.m_a9b6ecd9(), Double.valueOf(var2.getX()), JsonWriter::value);
      this.m_591bd658(var1, C0266.m_09052c0b(), Double.valueOf(var2.getY()), JsonWriter::value);
      this.m_591bd658(var1, C0266.m_023b99d9(), Double.valueOf(var2.getZ()), JsonWriter::value);
   }

   public BlockPosition m_595251a1(JsonReader var1) throws IOException {
      double var2 = this.<Double>m_17c69234(var1, JsonReader::nextDouble);
      double var4 = this.<Double>m_17c69234(var1, JsonReader::nextDouble);
      double var6 = this.<Double>m_17c69234(var1, JsonReader::nextDouble);
      return new DoubleBlockPosition(var2, var4, var6);
   }

   @Override
   public List<Class<? extends BlockPosition>> m_350b5ae0() {
      return Collections.singletonList(BlockPosition.class);
   }
}
