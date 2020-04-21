package at.chaotistin.dragonquestcraft.proxy;

import at.chaotistin.dragonquestcraft.entities.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy{
    @Override
    public void init() {
        RenderingRegistry.registerEntityRenderingHandler(PlatypunkEntity.class, PlatypunkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(DrackyEntity.class, DrackyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BlueSlimeEntity.class, BlueSlimeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BullBirdEntity.class, BullBirdRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(CatflyEntity.class, CatflyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(SpotSlimeEntity.class, SpotSlimeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(WingSlimeEntity.class, WingSlimeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(PickyEntity.class, PickyRenderer::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
