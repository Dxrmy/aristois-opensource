package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.List;
import me.deftware.client.framework.math.box.BoundingBox;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;

public class C0069 {
   private C0065[] f_19dbf55d;
   private final Color f_d1b711a1;
   private final C0066 f_019e8cf6;
   private final BoundingBox f_29d48c5e;

   public C0069(List<EnumFacing> var1, C0066 var2, Color var3) {
      this.m_1793329a(var1);
      this.f_019e8cf6 = var2;
      this.f_d1b711a1 = var3;
      this.f_29d48c5e = var2.f_5cbc6730.getBoundingBox();
   }

   public void m_1793329a(List<EnumFacing> var1) {
      this.f_19dbf55d = new C0065[var1.size()];

      for (int var2 = 0; var2 < var1.size(); var2++) {
         this.f_19dbf55d[var2] = C0068.f_976b17f3.get(var1.get(var2));
      }
   }

   public void m_41e9cd11(RenderStack<?> var1) {
      if (this.f_d1b711a1 != null) {
         var1.glColor(this.f_d1b711a1, 80.0F);
      }

      GameCamera var2 = Minecraft.getMinecraftGame().getCamera();
      this.f_29d48c5e.offset(-var2._getRenderPosX(), -var2._getRenderPosY(), -var2._getRenderPosZ());

      for (C0065 var6 : this.f_19dbf55d) {
         var6.m_bbeb4c33(this.f_29d48c5e, var1);
      }
   }

   public BlockPosition m_82942af9() {
      return this.f_019e8cf6.f_5cbc6730;
   }

   public Block m_268de4b2() {
      return this.f_019e8cf6.f_bc3f6e3b;
   }

   public int m_037208cc() {
      return this.f_19dbf55d.length;
   }

   @Override
   public boolean equals(Object var1) {
      return var1 instanceof C0069 ? ((C0069)var1).m_82942af9().equals(this.m_82942af9()) : false;
   }

   public C0065[] m_853dd53e() {
      return this.f_19dbf55d;
   }

   public Color m_d812cfb6() {
      return this.f_d1b711a1;
   }

   public C0066 m_f8f51e05() {
      return this.f_019e8cf6;
   }

   public BoundingBox m_be9e3e50() {
      return this.f_29d48c5e;
   }
}
