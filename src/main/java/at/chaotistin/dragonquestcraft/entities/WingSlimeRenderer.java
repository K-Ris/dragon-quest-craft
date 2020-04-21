package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class WingSlimeRenderer extends MobRenderer<WingSlimeEntity, WingSlimeModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/wingslime.png");
    //private static final ResourceLocation TEXTURE_TAMED = new ResourceLocation(Main.MODID, "textures/entity/blueslime.png");

    public WingSlimeRenderer(EntityRendererManager manager) {
        super(manager, new WingSlimeModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(WingSlimeEntity entity) {
        return TEXTURE;
    }
}
