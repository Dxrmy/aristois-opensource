package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;

public interface C0067 {
   void m_352d0b9e(RenderStack<?> var1, int var2, int var3, int var4);

   default void m_97f09f9d(RenderStack<?> var1, int var2) {
      Entity var3 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getCameraEntity());
      this.m_352d0b9e(var1, var3.getChunkX(), var3.getChunkZ(), var2);
   }

   void m_e764c4eb(Iterable<C0066> var1);

   void m_842fae32(Runnable var1);

   boolean m_1a0730f0(BlockPosition var1);

   default boolean m_efa7610e() {
      return this.m_79bbc2da() == 0;
   }

   void m_41e83f88();

   int m_79bbc2da();
}
