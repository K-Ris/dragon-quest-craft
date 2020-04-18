package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class BullBirdRenderer extends MobRenderer<BullBirdEntity, BullbirdModel> {
    //private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/bullbird-wild.png");
    private static final ResourceLocation TEXTURE_TAMED = new ResourceLocation(Main.MODID, "textures/entity/bullbird.png");

    public BullBirdRenderer(EntityRendererManager manager) {
        super(manager, new BullbirdModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(BullBirdEntity entity) {
        return TEXTURE_TAMED;
    }
}
