package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class BlueSlimeRenderer extends MobRenderer<BlueSlimeEntity, BlueSlimeModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/blueslime-wild.png");
    private static final ResourceLocation TEXTURE_TAMED = new ResourceLocation(Main.MODID, "textures/entity/blueslime.png");

    public BlueSlimeRenderer(EntityRendererManager manager) {
        super(manager, new BlueSlimeModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(BlueSlimeEntity entity) {
        if (entity.isTamed()) {
            return TEXTURE_TAMED;
        } else {
            return TEXTURE;
        }
    }
}
