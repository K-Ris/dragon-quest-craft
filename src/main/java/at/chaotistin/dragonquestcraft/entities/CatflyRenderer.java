package at.chaotistin.dragonquestcraft.entities;

import at.chaotistin.dragonquestcraft.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class CatflyRenderer extends MobRenderer<CatflyEntity, CatflyModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/catfly.png");

    public CatflyRenderer(EntityRendererManager manager) {
        super(manager, new CatflyModel(), 0.5f); //0.5f = shadow size
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(CatflyEntity entity) {
        return TEXTURE;
    }
}
