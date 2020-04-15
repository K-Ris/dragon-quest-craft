package at.chaotistin.dragonquestcraft.proxy;

import at.chaotistin.dragonquestcraft.entities.DrackyEntity;
import at.chaotistin.dragonquestcraft.entities.DrackyRenderer;
import at.chaotistin.dragonquestcraft.entities.PlatypunkEntity;
import at.chaotistin.dragonquestcraft.entities.PlatypunkRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy{
    @Override
    public void init() {
        RenderingRegistry.registerEntityRenderingHandler(PlatypunkEntity.class, PlatypunkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(DrackyEntity.class, DrackyRenderer::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
