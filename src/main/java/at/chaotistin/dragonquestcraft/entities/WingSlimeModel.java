package at.chaotistin.dragonquestcraft.entities;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class WingSlimeModel extends EntityModel<WingSlimeEntity> {
    private final RendererModel body;
    private final RendererModel tentacles;
    private final RendererModel wing_right;
    private final RendererModel subwing_right;
    private final RendererModel wing_left;
    private final RendererModel subwing_left;

    public WingSlimeModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 13.3333F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 0, -7.0F, -3.3333F, -6.0F, 14, 7, 12, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 19, -6.0F, -5.3333F, -5.0F, 12, 2, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 31, -5.0F, 3.6667F, -4.0F, 10, 1, 8, 0.0F, false));

        tentacles = new RendererModel(this);
        tentacles.setRotationPoint(0.0F, 4.6667F, 2.0F);
        body.addChild(tentacles);
        tentacles.cubeList.add(new ModelBox(tentacles, 48, 19, -5.0F, 0.0F, 1.0F, 3, 6, 0, 0.0F, false));
        tentacles.cubeList.add(new ModelBox(tentacles, 46, 47, 2.0F, 0.0F, 0.0F, 3, 6, 0, 0.0F, false));
        tentacles.cubeList.add(new ModelBox(tentacles, 40, 47, -2.0F, 0.0F, -1.0F, 3, 6, 0, 0.0F, false));
        tentacles.cubeList.add(new ModelBox(tentacles, 28, 40, -3.0F, 0.0F, -3.0F, 3, 6, 0, 0.0F, false));
        tentacles.cubeList.add(new ModelBox(tentacles, 28, 31, 1.0F, 0.0F, -2.0F, 3, 6, 0, 0.0F, false));
        tentacles.cubeList.add(new ModelBox(tentacles, 0, 31, 3.0F, 0.0F, -4.0F, 3, 6, 0, 0.0F, false));
        tentacles.cubeList.add(new ModelBox(tentacles, 0, 19, -6.0F, 0.0F, -5.0F, 3, 6, 0, 0.0F, false));

        wing_right = new RendererModel(this);
        wing_right.setRotationPoint(-7.625F, 12.0F, 0.375F);
        wing_right.cubeList.add(new ModelBox(wing_right, 0, 40, -5.375F, -6.0F, -0.375F, 6, 10, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 40, 0, -10.375F, -7.0F, -0.375F, 5, 10, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 14, 40, -16.375F, -6.0F, -0.375F, 6, 8, 1, 0.0F, false));

        subwing_right = new RendererModel(this);
        subwing_right.setRotationPoint(1.125F, 3.5F, 2.125F);
        setRotationAngle(subwing_right, 0.0873F, -0.2618F, 0.6109F);
        wing_right.addChild(subwing_right);
        subwing_right.cubeList.add(new ModelBox(subwing_right, 28, 47, -3.5F, -1.5F, -0.5F, 5, 7, 1, 0.0F, false));

        wing_left = new RendererModel(this);
        wing_left.setRotationPoint(7.625F, 12.0F, 0.375F);
        wing_left.cubeList.add(new ModelBox(wing_left, 36, 36, -0.625F, -6.0F, -0.375F, 6, 10, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 0, 0, 5.375F, -7.0F, -0.375F, 5, 10, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 34, 19, 10.375F, -6.0F, -0.375F, 6, 8, 1, 0.0F, false));

        subwing_left = new RendererModel(this);
        subwing_left.setRotationPoint(-1.125F, 3.5F, 2.125F);
        setRotationAngle(subwing_left, 0.0873F, 0.2618F, -0.6109F);
        wing_left.addChild(subwing_left);
        subwing_left.cubeList.add(new ModelBox(subwing_left, 44, 28, -0.5F, -1.5F, -0.5F, 5, 7, 1, 0.0F, false));
    }

    @Override
    public void render(WingSlimeEntity entity, float f0, float f1, float f2, float f3, float f4, float f5) {
        if(this.isChild){
            float f = 2.0F;
            GlStateManager.pushMatrix();
            GlStateManager.scalef(0.5F, 0.5F, 0.5F);
            GlStateManager.translatef(0.0F, 24.0F * f5, 0.0F);
            body.render(f5);
            GlStateManager.popMatrix();
        }else{
            wing_right.render(f5);
            wing_left.render(f5);
            body.render(f5);
        }
    }
    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }


    @Override
    public void setLivingAnimations(WingSlimeEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

        if (entityIn.isSitting()) {
            setRotationAngle(wing_left, 0.0F, 0.8727F, 0.8727F);
            setRotationAngle(wing_right, 0.0F, -0.9599F, -0.8727F);
        }
        else if(entityIn.isFlying()){
            setRotationAngle(wing_left, 6F, 2.269F, -0.6981F);
            setRotationAngle(wing_right, -6F, -2.2689F, 0.6981F);
        }
        else{
            setRotationAngle(wing_left, -0.5236F, 2.269F, -0.6981F);
            setRotationAngle(wing_right, -0.5236F, -2.2689F, 0.6981F);

        }
    }

    @Override
    public void setRotationAngles(WingSlimeEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.body.rotateAngleX = headPitch * ((float)Math.PI / 300f);
        //this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 300f);
        //this.main.rotateAngleX = ((float)Math.PI / 2F);
        this.wing_left.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount;
        this.wing_right.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount);
    }

    public RendererModel getHead() {
        return this.body;
    }
}
