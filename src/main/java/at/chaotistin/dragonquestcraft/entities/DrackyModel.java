package at.chaotistin.dragonquestcraft.entities;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DrackyModel extends EntityModel<DrackyEntity> {
    private final RendererModel body;
    private final RendererModel antena_right;
    private final RendererModel antena_left;
    private final RendererModel tail;
    private final RendererModel bone;
    private final RendererModel bone2;
    private final RendererModel wing_right;
    private final RendererModel wing_left;
    private final RendererModel leg_right;
    private final RendererModel leg_left;

    public DrackyModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 16.4286F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 0, -6.0F, -9.4286F, -6.0F, 12, 12, 12, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 30, 30, -5.0F, 2.5714F, -5.0F, 10, 1, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 24, -5.0F, -11.4286F, -5.0F, 10, 2, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 36, -4.0F, -12.4286F, -4.0F, 8, 1, 8, 0.0F, false));

        antena_right = new RendererModel(this);
        antena_right.setRotationPoint(-4.0F, -12.4286F, -1.0F);
        setRotationAngle(antena_right, 0.3491F, 0.0F, -0.6109F);
        body.addChild(antena_right);
        antena_right.cubeList.add(new ModelBox(antena_right, 36, 0, -1.0F, -4.0F, -1.0F, 2, 6, 2, 0.0F, false));

        antena_left = new RendererModel(this);
        antena_left.setRotationPoint(4.0F, -12.4286F, -1.0F);
        setRotationAngle(antena_left, 0.3491F, 0.0F, 0.6109F);
        body.addChild(antena_left);
        antena_left.cubeList.add(new ModelBox(antena_left, 0, 36, -1.0F, -4.0F, -1.0F, 2, 6, 2, 0.0F, false));

        tail = new RendererModel(this);
        tail.setRotationPoint(0.0F, 0.5714F, 6.0F);
        setRotationAngle(tail, 0.3491F, 0.0F, 0.0F);
        body.addChild(tail);
        tail.cubeList.add(new ModelBox(tail, 0, 45, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));

        bone = new RendererModel(this);
        bone.setRotationPoint(0.0F, 0.0F, 5.0F);
        setRotationAngle(bone, 0.6109F, 0.0F, 0.0F);
        tail.addChild(bone);
        bone.cubeList.add(new ModelBox(bone, 42, 42, -1.0F, -1.0F, 1.0F, 2, 2, 6, 0.0F, false));

        bone2 = new RendererModel(this);
        bone2.setRotationPoint(0.0F, 0.0F, 6.0F);
        setRotationAngle(bone2, -0.6981F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 26, 41, -1.0F, -1.0F, 1.0F, 2, 2, 6, 0.0F, false));

        wing_right = new RendererModel(this);
        wing_right.setRotationPoint(-6.0F, 12.25F, 0.5F);
        wing_right.cubeList.add(new ModelBox(wing_right, 30, 25, -4.0F, -4.25F, -0.5F, 4, 8, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 16, 49, -9.0F, -5.25F, -0.5F, 5, 8, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 36, 50, -12.0F, -3.25F, -0.5F, 3, 7, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 44, 50, -14.0F, -2.25F, -0.5F, 2, 7, 1, 0.0F, false));

        wing_left = new RendererModel(this);
        wing_left.setRotationPoint(6.0F, 12.25F, 0.5F);
        wing_left.cubeList.add(new ModelBox(wing_left, 0, 24, 0.0F, -4.25F, -0.5F, 4, 8, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 0, 0, 4.0F, -5.25F, -0.5F, 5, 8, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 28, 49, 9.0F, -3.25F, -0.5F, 3, 7, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 24, 36, 12.0F, -2.25F, -0.5F, 2, 7, 1, 0.0F, false));

        leg_right = new RendererModel(this);
        leg_right.setRotationPoint(-2.0F, 20.0F, -1.0F);
        leg_right.cubeList.add(new ModelBox(leg_right, 40, 26, -2.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, false));
        leg_right.cubeList.add(new ModelBox(leg_right, 39, 15, -3.0F, 2.0F, -5.0F, 3, 2, 9, 0.0F, false));

        leg_left = new RendererModel(this);
        leg_left.setRotationPoint(2.0F, 21.0F, -1.0F);
        leg_left.cubeList.add(new ModelBox(leg_left, 30, 36, 0.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F, false));
        leg_left.cubeList.add(new ModelBox(leg_left, 36, 0, 0.0F, 1.0F, -5.0F, 3, 2, 9, 0.0F, false));
    }

    @Override
    public void render(DrackyEntity entity, float f0, float f1, float f2, float f3, float f4, float f5) {
        if(this.isChild){
            float f = 2.0F;
            GlStateManager.pushMatrix();
            GlStateManager.scalef(0.8F, 0.8F, 0.8F);
            GlStateManager.translatef(0.0F, 8.0F * f5, 2.0F * f5);
            body.render(f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scalef(0.5F, 0.5F, 0.5F);
            GlStateManager.translatef(0.0F, 24.0F * f5, 0.0F);

            wing_right.render(f5);
            wing_left.render(f5);
            leg_right.render(f5);
            leg_left.render(f5);
            GlStateManager.popMatrix();
        }
        else{
            body.render(f5);
            wing_right.render(f5);
            wing_left.render(f5);
            leg_right.render(f5);
            leg_left.render(f5);
        }
    }

    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }

    @Override
    public void setLivingAnimations(DrackyEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

        if (entityIn.isSitting()) {
            setRotationAngle(leg_left, 0.0F, 0F, 0.0F);
            setRotationAngle(wing_left, 0.0F, 0.8727F, 0.8727F);
            setRotationAngle(wing_right, 0.0F, -0.9599F, -0.8727F);
            setRotationAngle(leg_right, 0F, 0F, 0F);
        }
        else if(entityIn.isFlying()){
            setRotationAngle(leg_left, 0.0F, -0F, 0.0F);
            setRotationAngle(wing_left, 6F, 2.269F, -0.6981F);
            setRotationAngle(leg_right, 0.0F, 0F, 0.0F);
            setRotationAngle(wing_right, -6F, -2.2689F, 0.6981F);
        }
        else{
            setRotationAngle(leg_left, 0.0F, -0.8727F, 0.0F);
            setRotationAngle(wing_left, -0.5236F, 2.269F, -0.6981F);
            setRotationAngle(leg_right, 0.0F, 0.8727F, 0.0F);
            setRotationAngle(wing_right, -0.5236F, -2.2689F, 0.6981F);

        }
    }

    @Override
    public void setRotationAngles(DrackyEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.body.rotateAngleX = headPitch * ((float)Math.PI / 300f);
        //this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 300f);
        //this.main.rotateAngleX = ((float)Math.PI / 2F);
        this.leg_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.wing_left.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount;
        this.wing_right.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount);
    }

    public RendererModel getHead() {
        return this.body;
    }
}
