package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class PlatypunkRenderer extends MobRenderer<PlatypunkEntity, PlatypunkModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/platypunk-wild.png");
    private static final ResourceLocation TEXTURE_TAMED = new ResourceLocation(Main.MODID, "textures/entity/platypunk.png");

    public PlatypunkRenderer(EntityRendererManager manager) {
        super(manager, new PlatypunkModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(PlatypunkEntity entity) {
        if (entity.isTamed()) {
            return TEXTURE_TAMED;
        } else {
            return TEXTURE;
        }
    }
}
