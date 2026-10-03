package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.List;
import me.deftware.client.framework.math.box.BoundingBox;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.camera.GameCamera;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.client.framework.world.block.Block;

public class C0069 {
   private C0065[] f_d2b4b701;
   private final Color f_d5270edd;
   private final C0066 f_8b0b0703;
   private final BoundingBox f_819c09eb;

   public C0069(List<EnumFacing> var1, C0066 var2, Color var3) {
      this.m_9c6233fb(var1);
      this.f_8b0b0703 = var2;
      this.f_d5270edd = var3;
      this.f_819c09eb = var2.f_2d141078.getBoundingBox();
   }

   public void m_9c6233fb(List<EnumFacing> var1) {
      this.f_d2b4b701 = new C0065[var1.size()];

      for (int var2 = 0; var2 < var1.size(); var2++) {
         this.f_d2b4b701[var2] = C0068.f_0f817432.get(var1.get(var2));
      }
   }

   public void m_380bf3b4(RenderStack<?> var1) {
      if (this.f_d5270edd != null) {
         var1.glColor(this.f_d5270edd, 80.0F);
      }

      GameCamera var2 = C0114.bootstrap<"call",0,1>().getCamera();
      this.f_819c09eb.offset(-var2._getRenderPosX(), -var2._getRenderPosY(), -var2._getRenderPosZ());

      for (C0065 var6 : this.f_d2b4b701) {
         var6.m_40338c2b(this.f_819c09eb, var1);
      }
   }

   public BlockPosition m_02522bed() {
      return this.f_8b0b0703.f_2d141078;
   }

   public Block m_69395525() {
      return this.f_8b0b0703.f_580c1967;
   }

   public int m_4dd25bbd() {
      return this.f_d2b4b701.length;
   }

   @Override
   public boolean equals(Object var1) {
      return var1 instanceof C0069 ? ((C0069)var1).m_02522bed().equals(this.m_02522bed()) : false;
   }

   public C0065[] m_2d806e53() {
      return this.f_d2b4b701;
   }

   public Color m_b097395b() {
      return this.f_d5270edd;
   }

   public C0066 m_002398fa() {
      return this.f_8b0b0703;
   }

   public BoundingBox m_d4cc25e2() {
      return this.f_819c09eb;
   }
}
