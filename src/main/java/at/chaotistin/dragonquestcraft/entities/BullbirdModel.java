package at.chaotistin.dragonquestcraft.entities;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class BullbirdModel extends EntityModel<BullBirdEntity> {
    private final RendererModel body;
    private final RendererModel tail;
    private final RendererModel head;
    private final RendererModel horn_left;
    private final RendererModel horn_right;
    private final RendererModel beak_low;
    private final RendererModel leg_left;
    private final RendererModel foot_left;
    private final RendererModel leg_right;
    private final RendererModel foot_right;
    private final RendererModel wing_right;
    private final RendererModel wing_left;

    public BullbirdModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new RendererModel(this);
        body.setRotationPoint(-0.0714F, 11.3571F, 5.3571F);
        body.cubeList.add(new ModelBox(body, 40, 43, -7.9286F, -10.3571F, 8.6429F, 16, 15, 4, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 50, 0, -6.9286F, -9.3571F, 12.6429F, 14, 13, 3, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 0, -8.9286F, -12.3571F, 0.6429F, 17, 18, 8, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 26, -7.9286F, -10.3571F, -5.3571F, 16, 15, 6, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 44, 20, -5.9286F, -8.3571F, -11.3571F, 12, 14, 6, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 30, 62, -4.9286F, -7.3571F, -15.3571F, 10, 12, 4, 0.0F, false));

        tail = new RendererModel(this);
        tail.setRotationPoint(-0.9286F, -5.3571F, 15.3929F);
        setRotationAngle(tail, -0.9599F, 0.0F, 0.0F);
        body.addChild(tail);
        tail.cubeList.add(new ModelBox(tail, 70, 70, -1.0F, -1.0F, 0.25F, 2, 2, 10, 0.0F, false));
        tail.cubeList.add(new ModelBox(tail, 53, 80, -2.0F, -2.0F, 10.25F, 4, 4, 5, 0.0F, false));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 9.0F, -10.1429F);
        head.cubeList.add(new ModelBox(head, 0, 47, -4.0F, -6.0F, -8.8571F, 8, 9, 9, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 74, 16, -5.0F, -3.0F, -9.8571F, 10, 5, 4, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 73, 55, -2.0F, -3.0F, -16.8571F, 4, 5, 7, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -2.0F, -18.8571F, 2, 5, 2, 0.0F, false));

        horn_left = new RendererModel(this);
        horn_left.setRotationPoint(4.0F, -5.5F, -3.6071F);
        setRotationAngle(horn_left, 0.0F, 0.0F, 0.5236F);
        head.addChild(horn_left);
        horn_left.cubeList.add(new ModelBox(horn_left, 0, 90, -1.0F, -3.5F, -1.25F, 2, 4, 3, 0.0F, false));
        horn_left.cubeList.add(new ModelBox(horn_left, 82, 82, -1.0F, -5.5F, -5.25F, 2, 2, 6, 0.0F, false));

        horn_right = new RendererModel(this);
        horn_right.setRotationPoint(-4.0F, -5.5F, -3.6071F);
        setRotationAngle(horn_right, 0.0F, 0.0F, -0.5236F);
        head.addChild(horn_right);
        horn_right.cubeList.add(new ModelBox(horn_right, 53, 89, -1.0F, -3.5F, -1.25F, 2, 4, 3, 0.0F, false));
        horn_right.cubeList.add(new ModelBox(horn_right, 14, 65, -1.0F, -5.5F, -5.25F, 2, 2, 6, 0.0F, false));

        beak_low = new RendererModel(this);
        beak_low.setRotationPoint(0.0F, 3.0F, -8.8571F);
        head.addChild(beak_low);
        beak_low.cubeList.add(new ModelBox(beak_low, 72, 32, -2.0F, -1.0F, -7.0F, 4, 2, 8, 0.0F, false));

        leg_left = new RendererModel(this);
        leg_left.setRotationPoint(9.0F, 10.0F, 8.0F);
        setRotationAngle(leg_left, 0.4363F, 0.0F, 0.0F);
        leg_left.cubeList.add(new ModelBox(leg_left, 0, 65, -1.0F, -6.0F, -2.0F, 3, 10, 8, 0.0F, false));
        leg_left.cubeList.add(new ModelBox(leg_left, 35, 78, -1.0F, -3.0F, 1.0F, 4, 10, 5, 0.0F, false));

        foot_left = new RendererModel(this);
        foot_left.setRotationPoint(0.75F, 7.25F, 4.25F);
        setRotationAngle(foot_left, -0.6109F, 0.0F, 0.0F);
        leg_left.addChild(foot_left);
        foot_left.cubeList.add(new ModelBox(foot_left, 84, 67, -1.75F, -0.25F, -1.25F, 3, 6, 3, 0.0F, false));
        foot_left.cubeList.add(new ModelBox(foot_left, 0, 83, -1.75F, 5.75F, -2.25F, 4, 3, 4, 0.0F, false));

        leg_right = new RendererModel(this);
        leg_right.setRotationPoint(-9.0F, 10.0F, 8.0F);
        setRotationAngle(leg_right, 0.4363F, 0.0F, 0.0F);
        leg_right.cubeList.add(new ModelBox(leg_right, 58, 62, -2.0F, -6.0F, -2.0F, 3, 10, 8, 0.0F, false));
        leg_right.cubeList.add(new ModelBox(leg_right, 17, 78, -3.0F, -3.0F, 1.0F, 4, 10, 5, 0.0F, false));

        foot_right = new RendererModel(this);
        foot_right.setRotationPoint(-0.75F, 7.25F, 4.25F);
        setRotationAngle(foot_right, -0.6109F, 0.0F, 0.0F);
        leg_right.addChild(foot_right);
        foot_right.cubeList.add(new ModelBox(foot_right, 25, 47, -1.25F, -0.25F, -1.25F, 3, 6, 3, 0.0F, false));
        foot_right.cubeList.add(new ModelBox(foot_right, 80, 25, -2.25F, 5.75F, -2.25F, 4, 3, 4, 0.0F, false));

        wing_right = new RendererModel(this);
        wing_right.setRotationPoint(-5.8333F, 5.5F, -3.3333F);
        setRotationAngle(wing_right, 0.3491F, -0.5236F, -0.7854F);
        wing_right.cubeList.add(new ModelBox(wing_right, 88, 51, -3.1667F, -1.5F, -1.6667F, 3, 4, 3, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 84, 6, -8.1667F, -1.5F, -1.6667F, 5, 3, 3, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 64, 82, -10.1667F, -1.5F, -0.6667F, 2, 2, 7, 0.0F, false));

        wing_left = new RendererModel(this);
        wing_left.setRotationPoint(5.8333F, 5.5F, -3.3333F);
        setRotationAngle(wing_left, 0.3491F, 0.5236F, 0.7854F);
        wing_left.cubeList.add(new ModelBox(wing_left, 88, 32, 0.1667F, -1.5F, -1.6667F, 3, 4, 3, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 84, 0, 3.1667F, -1.5F, -1.6667F, 5, 3, 3, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 80, 42, 8.1667F, -1.5F, -0.6667F, 2, 2, 7, 0.0F, false));
    }

    @Override
    public void render(BullBirdEntity entity, float f0, float f1, float f2, float f3, float f4, float f5) {
        if(this.isChild){
            float f = 2.0F;
            GlStateManager.pushMatrix();
            GlStateManager.translatef(0.0F, 5.0F * f5, 6.0F * f5);
            this.head.render(f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scalef(0.5F, 0.5F, 0.5F);
            GlStateManager.translatef(0.0F, 24.0F * f5, 0.0F);
            this.body.render(f5);
            leg_left.render(f5);
            leg_right.render(f5);
            wing_right.render(f5);
            wing_left.render(f5);
            GlStateManager.popMatrix();
        }else{
            body.render(f5);
            head.render(f5);
            leg_left.render(f5);
            leg_right.render(f5);
            wing_right.render(f5);
            wing_left.render(f5);
        }

    }
    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }

    public void setLivingAnimations(BullBirdEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

        if (entityIn.isSitting()) {
            setRotationAngle(body, -0.1745F, 0.0F, 0.0F);
            setRotationAngle(leg_left, 0.0F, -0.8727F, 0.0F);
            setRotationAngle(wing_left, 0.3491F, -0.3491F, 1.309F);
            setRotationAngle(leg_right, 0.0F, 0.8727F, 0.0F);
            setRotationAngle(wing_right, 0.3491F, 0.3491F, -1.309F);
        }
        else{
            setRotationAngle(body, 0.0F, 0.0F, 0.0F);
            setRotationAngle(leg_left, 0.0F, 0F, 0.0F);
            setRotationAngle(wing_left, 0.0F, 0.8727F, 0.8727F);
            setRotationAngle(wing_right, 0.0F, -0.9599F, -0.8727F);
            setRotationAngle(leg_right, 0F, 0F, 0F);
        }
    }

    @Override
    public void setRotationAngles(BullBirdEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.main.rotateAngleX = ((float)Math.PI / 2F);
        this.wing_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.wing_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
