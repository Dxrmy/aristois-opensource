package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.function.Supplier;
import me.deftware.client.framework.entity.block.StorageEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.shader.EntityShader;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.types.ShulkerBlock;
import me.deftware.client.framework.world.block.types.StorageBlock;

public class C0318 extends C0319<Block> {
   private C0199 f_e19a668b = new C0199(C0252.bootstrap<"get",47244640367>());
   @C0098(
      value = "Distance",
      description = {"Maximum distance to render ESP"},
      number = @C0096(
         min = 2.0,
         max = 32.0
      )
   )
   private C0106<Integer> f_f1bd879a = new C0106<>(C0114.bootstrap<"call",0,1>(4)).m_6da46a9c(this.f_0e27f3f9, C0319.anonymousabstract.f_37020a22);
   @C0098(
      value = "Line thickness",
      description = {"Thickness of the BoundaryBox line thickness"},
      number = @C0096(
         max = 8.0
      )
   )
   private C0106<Integer> f_0ce82547 = new C0106<>(C0114.bootstrap<"call",0,1>(2)).m_10caee7d(this.f_0e27f3f9, C0319.anonymousabstract.f_5ab2c155);
   @C0098(
      value = "Blocks",
      description = {"Blocks to render"}
   )
   private final GuiScreen f_b7c22509 = new C0196(
      null,
      this.f_e19a668b,
      new C0206<>(
         BlockRegistry.INSTANCE,
         var0 -> var0 instanceof ShulkerBlock ? var0.getIdentifierKey().endsWith(C0252.bootstrap<"get",47244640369>()) : var0 instanceof StorageBlock
      ),
      C0252.bootstrap<"get",47244640368>(),
      var0 -> var0.getName().string()
   );
   @C0098("Render")
   private C0102<C0318.anonymousnew> f_36eee12f = new C0102<>(C0318.anonymousnew.f_91ad8430);
   private final CubeRenderStack f_d293ed5d = new CubeRenderStack();
   private final C0068 f_0d7f9217 = new C0068();

   public C0318() {
      super(C0252.bootstrap<"get",47244640365>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640366>());
      this.f_0e27f3f9.m_8725a94b(C0319.anonymousabstract.f_d569a437);
      this.f_687f5c98 = new C0319.anonymousnew<Block>() {
         public Supplier<EntityShader> m_16974f09() {
            return C0114.bootstrap<"call",0,1>()::m_c183731a;
         }

         public Class<Block> m_b249c894() {
            return Block.class;
         }

         public boolean m_0de8e568(Block var1) {
            return true;
         }
      };
      this.f_0d7f9217.m_7674d8f0(this::m_aafc96b1);
   }

   @EventHandler
   public void m_20530579(EventRender3D var1) {
      if (C0114.bootstrap<"call",0,1>() != null && !this.m_26f3e3ef()) {
         C0114.bootstrap<"call",1,1>();
         ((CubeRenderStack)this.f_d293ed5d.glColor(Color.orange, 60.0F)).begin();
         this.f_0d7f9217.m_77f3f922(this.f_d293ed5d, this.f_f1bd879a.get());
         this.f_d293ed5d.end();
         C0114.bootstrap<"call",2,1>();
      }
   }

   private void m_aafc96b1() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (this.isEnabled() && !this.m_26f3e3ef() && C0114.bootstrap<"call",1,1>() != null && var1 != null) {
         ArrayList var2 = new ArrayList();
         ArrayList var3 = new ArrayList();
         C0114.bootstrap<"call",1,1>()
            .getLoadedTileEntities()
            .filter(var0 -> var0 instanceof StorageEntity)
            .filter(var1x -> this.f_e19a668b.m_7847beb9((StorageEntity)var1x) || this.f_36eee12f.m_e2691446() == C0318.anonymousnew.f_91ad8430)
            .map(StorageEntity.class::cast)
            .forEach(var2x -> {
               var2.add(new C0066(var2x.getBlockPosition(), var2x.getBlock()));
               var3.add(var2x.getBlockPosition());
            });
         this.f_0d7f9217.m_ce447e8d((var1x, var2x) -> var3.contains(var2x));
         this.f_0d7f9217.m_093e3f96(var3);
         this.f_0d7f9217.m_7d4bb95a(var2);
      }
   }

   public static enum anonymousnew {
      f_91ad8430,
      f_0dd382ed;

      private anonymousnew() {
      }
   }
}
