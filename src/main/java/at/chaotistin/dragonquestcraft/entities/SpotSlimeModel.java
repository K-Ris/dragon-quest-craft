package at.chaotistin.dragonquestcraft.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class SpotSlimeModel extends EntityModel<SpotSlimeEntity> {
    private final RendererModel body;
    private final RendererModel antena;
    private final RendererModel ear_left;
    private final RendererModel ear_right;

    public SpotSlimeModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 0, -9.0F, -10.0F, -9.0F, 18, 9, 18, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 45, -7.0F, -1.0F, -7.0F, 14, 1, 14, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 27, -8.0F, -12.0F, -8.0F, 16, 2, 16, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 42, 45, -5.0F, -14.0F, -5.0F, 10, 2, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 54, 0, -3.0F, -15.0F, -3.0F, 6, 1, 6, 0.0F, false));

        antena = new RendererModel(this);
        antena.setRotationPoint(0.0F, -14.5F, 0.0F);
        body.addChild(antena);
        antena.cubeList.add(new ModelBox(antena, 0, 0, -2.0F, -2.5F, -2.0F, 4, 3, 4, 0.0F, false));
        antena.cubeList.add(new ModelBox(antena, 0, 7, -1.0F, -5.5F, -1.0F, 2, 4, 2, 0.0F, false));

        ear_left = new RendererModel(this);
        ear_left.setRotationPoint(7.0F, -12.0F, 0.5F);
        setRotationAngle(ear_left, 0.0F, 0.0F, 0.6981F);
        body.addChild(ear_left);
        ear_left.cubeList.add(new ModelBox(ear_left, 48, 34, -1.0F, -1.0F, -2.5F, 10, 2, 5, 0.0F, false));

        ear_right = new RendererModel(this);
        ear_right.setRotationPoint(-7.0F, -12.0F, 0.5F);
        setRotationAngle(ear_right, 0.0F, 0.0F, -0.6981F);
        body.addChild(ear_right);
        ear_right.cubeList.add(new ModelBox(ear_right, 48, 27, -9.0F, -1.0F, -2.5F, 10, 2, 5, 0.0F, false));
    }

    @Override
    public void render(SpotSlimeEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        body.render(f5);
    }
    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
