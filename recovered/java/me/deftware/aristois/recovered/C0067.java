package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.render.batching.RenderStack;

public interface C0067 {
   void m_061489e5(RenderStack<?> var1, int var2, int var3, int var4);

   default void m_3c929f1b(RenderStack<?> var1, int var2) {
      Entity var3 = (Entity)C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>()._getCameraEntity());
      this.m_061489e5(var1, var3.getChunkX(), var3.getChunkZ(), var2);
   }

   void m_7903b390(Iterable<C0066> var1);

   void m_6dd98092(Runnable var1);

   boolean m_cdab654c(BlockPosition var1);

   default boolean m_3d3e34e7() {
      return this.m_986c122a() == 0;
   }

   void m_1e959a07();

   int m_986c122a();
}
