package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.function.Supplier;
import me.deftware.client.framework.entity.block.StorageEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3D;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.render.batching.CubeRenderStack;
import me.deftware.client.framework.render.batching.RenderStack;
import me.deftware.client.framework.render.shader.EntityShader;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.block.Block;
import me.deftware.client.framework.world.block.types.ShulkerBlock;
import me.deftware.client.framework.world.block.types.StorageBlock;

public class C0318 extends C0319<Block> {
   private C0199 f_e46c745f = new C0199(C0260.m_a5b24d28());
   @C0098(
      value = "Distance",
      description = {"Maximum distance to render ESP"},
      number = @C0096(
         min = 2.0,
         max = 32.0
      )
   )
   private C0106<Integer> f_1e8f5090 = new C0106<>(4).m_cb9291a5(this.f_e1d988aa, C0319.anonymousabstract.f_40f68e21);
   @C0098(
      value = "Line thickness",
      description = {"Thickness of the BoundaryBox line thickness"},
      number = @C0096(
         max = 8.0
      )
   )
   private C0106<Integer> f_ee961e57 = new C0106<>(2).m_2d6ca2bd(this.f_e1d988aa, C0319.anonymousabstract.f_cf065721);
   @C0098(
      value = "Blocks",
      description = {"Blocks to render"}
   )
   private final GuiScreen f_81d9cb82 = new C0196(
      null,
      this.f_e46c745f,
      new C0206<>(
         BlockRegistry.INSTANCE, var0 -> var0 instanceof ShulkerBlock ? var0.getIdentifierKey().endsWith(C0260.m_09052c0b()) : var0 instanceof StorageBlock
      ),
      C0260.m_a9b6ecd9(),
      var0 -> var0.getName().string()
   );
   @C0098("Render")
   private C0102<C0318.anonymousnew> f_2f34a568 = new C0102<>(C0318.anonymousnew.f_c87dfda6);
   private final CubeRenderStack f_fa52627b = new CubeRenderStack();
   private final C0068 f_d474cf5e = new C0068();

   public C0318() {
      super(C0260.m_37c08c9d(), C0290.f_3210deb7, C0260.m_1472ab32());
      this.f_e1d988aa.m_5b9845c3(C0319.anonymousabstract.f_e6ef46e1);
      this.f_c7894f51 = new C0319.anonymousnew<Block>() {
         @Override
         public Supplier<EntityShader> m_5219c421() {
            return C0242.m_fc1b642c()::m_644daa7e;
         }

         @Override
         public Class<Block> m_6305e767() {
            return Block.class;
         }

         public boolean m_d553f392(Block var1) {
            return true;
         }
      };
      this.f_d474cf5e.m_842fae32(this::m_58b14343);
   }

   @EventHandler
   public void m_c738343e(EventRender3D var1) {
      if (ClientWorld.getClientWorld() != null && !this.m_297cfef6()) {
         RenderStack.setupGl();
         ((CubeRenderStack)this.f_fa52627b.glColor(Color.orange, 60.0F)).begin();
         this.f_d474cf5e.m_97f09f9d(this.f_fa52627b, this.f_1e8f5090.get());
         this.f_fa52627b.end();
         RenderStack.restoreGl();
      }
   }

   private void m_58b14343() {
      MainEntityPlayer var1 = Minecraft.getMinecraftGame()._getPlayer();
      if (this.isEnabled() && !this.m_297cfef6() && ClientWorld.getClientWorld() != null && var1 != null) {
         ArrayList var2 = new ArrayList();
         ArrayList var3 = new ArrayList();
         ClientWorld.getClientWorld()
            .getLoadedTileEntities()
            .filter(var0 -> var0 instanceof StorageEntity)
            .filter(var1x -> this.f_e46c745f.m_8a2535a2((StorageEntity)var1x) || this.f_2f34a568.m_284992ec() == C0318.anonymousnew.f_c87dfda6)
            .map(StorageEntity.class::cast)
            .forEach(var2x -> {
               var2.add(new C0066(var2x.getBlockPosition(), var2x.getBlock()));
               var3.add(var2x.getBlockPosition());
            });
         this.f_d474cf5e.m_e4640d90((var1x, var2x) -> var3.contains(var2x));
         this.f_d474cf5e.m_21736e90(var3);
         this.f_d474cf5e.m_e764c4eb(var2);
      }
   }

   public static enum anonymousnew {
      f_c87dfda6,
      f_884c8646;

      private anonymousnew() {
      }
   }
}
