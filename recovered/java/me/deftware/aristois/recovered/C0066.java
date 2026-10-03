package me.deftware.aristois.recovered;

import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.world.block.Block;

public class C0066 {
   public final BlockPosition f_2d141078;
   public final Block f_580c1967;

   public C0066(BlockPosition var1, Block var2) {
      this.f_2d141078 = var1;
      this.f_580c1967 = var2;
   }

   @Override
   public int hashCode() {
      return C0114.bootstrap<"call",2,1>(
         new Object[]{
            C0114.bootstrap<"call",0,1>(this.f_2d141078.getX()),
            C0114.bootstrap<"call",0,1>(this.f_2d141078.getY()),
            C0114.bootstrap<"call",0,1>(this.f_2d141078.getZ()),
            C0114.bootstrap<"call",1,1>(this.f_580c1967.getID())
         }
      );
   }

   public BlockPosition m_aed54967() {
      return this.f_2d141078;
   }

   public Block m_1dfdacd7() {
      return this.f_580c1967;
   }
}
