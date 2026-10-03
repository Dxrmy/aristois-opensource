package me.deftware.aristois.recovered;

import java.util.Objects;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.world.block.Block;

public class C0066 {
   public final BlockPosition f_5cbc6730;
   public final Block f_bc3f6e3b;

   public C0066(BlockPosition var1, Block var2) {
      this.f_5cbc6730 = var1;
      this.f_bc3f6e3b = var2;
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.f_5cbc6730.getX(), this.f_5cbc6730.getY(), this.f_5cbc6730.getZ(), this.f_bc3f6e3b.getID());
   }

   public BlockPosition m_82942af9() {
      return this.f_5cbc6730;
   }

   public Block m_268de4b2() {
      return this.f_bc3f6e3b;
   }
}
