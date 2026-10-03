package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;

public class C0127 implements C0131<BlockPosition> {
   public C0127() {
   }

   public void m_b887c07b(JsonWriter var1, BlockPosition var2) throws IOException {
      this.m_1fd2af7b(var1, C0252.bootstrap<"get",12884902000>(), C0114.bootstrap<"call",0,1>(var2.getX()), JsonWriter::value);
      this.m_1fd2af7b(var1, C0252.bootstrap<"get",12884902001>(), C0114.bootstrap<"call",0,1>(var2.getY()), JsonWriter::value);
      this.m_1fd2af7b(var1, C0252.bootstrap<"get",12884902002>(), C0114.bootstrap<"call",0,1>(var2.getZ()), JsonWriter::value);
   }

   public BlockPosition m_ca4de55a(JsonReader var1) throws IOException {
      double var2 = (Double)this.m_53eeec21(var1, JsonReader::nextDouble);
      double var4 = (Double)this.m_53eeec21(var1, JsonReader::nextDouble);
      double var6 = (Double)this.m_53eeec21(var1, JsonReader::nextDouble);
      return new DoubleBlockPosition(var2, var4, var6);
   }

   public List<Class<? extends BlockPosition>> m_4b37ba81() {
      return C0114.bootstrap<"call",1,1>(BlockPosition.class);
   }
}
