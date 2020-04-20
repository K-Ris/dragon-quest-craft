package at.chaotistin.dragonquestcraft.entities;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class CatflyModel extends EntityModel<CatflyEntity> {
    private final RendererModel body;
    private final RendererModel tail;
    private final RendererModel tail2;
    private final RendererModel tail3;
    private final RendererModel head;
    private final RendererModel mouth_lower;
    private final RendererModel ear_left;
    private final RendererModel ear_right;
    private final RendererModel wing_right;
    private final RendererModel wing_left;
    private final RendererModel leg_right;
    private final RendererModel foot_right;
    private final RendererModel leg_left;
    private final RendererModel foot_left;

    public CatflyModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 18.6667F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 0, -6.0F, -3.6667F, -4.0F, 12, 9, 8, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 31, -5.0F, -8.6667F, -3.0F, 10, 5, 6, 0.0F, false));

        tail = new RendererModel(this);
        tail.setRotationPoint(0.0F, 4.8333F, 3.25F);
        setRotationAngle(tail, 0.4363F, 0.0F, 0.0F);
        body.addChild(tail);
        tail.cubeList.add(new ModelBox(tail, 41, 2, -1.0F, -1.5F, 0.75F, 2, 2, 5, 0.0F, false));

        tail2 = new RendererModel(this);
        tail2.setRotationPoint(0.0F, 0.0F, 6.5F);
        setRotationAngle(tail2, 0.3491F, 0.0F, 0.0F);
        tail.addChild(tail2);
        tail2.cubeList.add(new ModelBox(tail2, 38, 23, -1.0F, -1.5F, -0.75F, 2, 2, 5, 0.0F, false));

        tail3 = new RendererModel(this);
        tail3.setRotationPoint(0.0F, -0.5F, 4.75F);
        setRotationAngle(tail3, -0.4363F, 0.0F, 0.0F);
        tail2.addChild(tail3);
        tail3.cubeList.add(new ModelBox(tail3, 32, 0, -1.0F, -1.0F, -0.5F, 2, 2, 5, 0.0F, false));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 12.9375F, -1.375F);
        head.cubeList.add(new ModelBox(head, 0, 17, -6.0F, -9.9375F, -2.625F, 12, 7, 7, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 45, 45, -2.0F, -5.9375F, -5.625F, 4, 2, 3, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 7, -2.0F, -3.9375F, -5.625F, 4, 1, 0, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 46, 9, -4.0F, -13.9375F, 0.375F, 8, 4, 0, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 31, -9.0F, -6.9375F, -0.625F, 3, 4, 0, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 17, 6.0F, -6.9375F, -0.625F, 3, 4, 0, 0.0F, false));

        mouth_lower = new RendererModel(this);
        mouth_lower.setRotationPoint(0.0F, -3.4375F, -2.125F);
        setRotationAngle(mouth_lower, 0.6109F, 0.0F, 0.0F);
        head.addChild(mouth_lower);
        mouth_lower.cubeList.add(new ModelBox(mouth_lower, 45, 40, -2.0F, -0.5F, -3.5F, 4, 1, 3, 0.0F, false));

        ear_left = new RendererModel(this);
        ear_left.setRotationPoint(6.0F, -7.9375F, 1.875F);
        setRotationAngle(ear_left, 0.0F, 0.0F, 0.4363F);
        head.addChild(ear_left);
        ear_left.cubeList.add(new ModelBox(ear_left, 32, 43, -1.0F, -1.0F, -1.5F, 5, 2, 3, 0.0F, false));

        ear_right = new RendererModel(this);
        ear_right.setRotationPoint(-5.0F, -8.9375F, 1.875F);
        setRotationAngle(ear_right, 0.0F, 0.0F, -0.5236F);
        head.addChild(ear_right);
        ear_right.cubeList.add(new ModelBox(ear_right, 43, 30, -5.0F, -1.0F, -1.5F, 5, 2, 3, 0.0F, false));

        wing_right = new RendererModel(this);
        wing_right.setRotationPoint(-6.05F, 10.55F, 0.25F);
        wing_right.cubeList.add(new ModelBox(wing_right, 12, 47, -3.95F, -2.55F, -0.25F, 5, 5, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 0, 53, -6.95F, -6.55F, -0.25F, 3, 8, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 51, 13, -9.95F, -7.55F, -0.25F, 3, 8, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 47, 23, -9.95F, -10.55F, -1.25F, 3, 3, 2, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 38, 23, -6.95F, -10.55F, -0.25F, 2, 3, 0, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 0, 35, -9.95F, -12.55F, -0.25F, 3, 2, 0, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 32, 0, -11.95F, -10.55F, -0.25F, 2, 3, 0, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 48, 50, -12.95F, -6.55F, -0.25F, 3, 8, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 14, 53, -14.95F, -5.55F, -0.25F, 2, 9, 1, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 4, 0, -15.95F, -4.55F, -0.25F, 1, 6, 1, 0.0F, false));

        wing_left = new RendererModel(this);
        wing_left.setRotationPoint(6.05F, 10.55F, 0.25F);
        wing_left.cubeList.add(new ModelBox(wing_left, 0, 47, -1.05F, -2.55F, -0.25F, 5, 5, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 40, 50, 3.95F, -6.55F, -0.25F, 3, 8, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 32, 48, 6.95F, -7.55F, -0.25F, 3, 8, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 26, 31, 6.95F, -10.55F, -1.25F, 3, 3, 2, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 31, 20, 4.95F, -10.55F, -0.25F, 2, 3, 0, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 0, 21, 6.95F, -12.55F, -0.25F, 3, 2, 0, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 31, 17, 9.95F, -10.55F, -0.25F, 2, 3, 0, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 24, 47, 9.95F, -6.55F, -0.25F, 3, 8, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 8, 53, 12.95F, -5.55F, -0.25F, 2, 9, 1, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 0, 0, 14.95F, -4.55F, -0.25F, 1, 6, 1, 0.0F, false));

        leg_right = new RendererModel(this);
        leg_right.setRotationPoint(-3.75F, 22.0F, -0.25F);
        setRotationAngle(leg_right, 0.2618F, 0.0F, 0.0F);
        leg_right.cubeList.add(new ModelBox(leg_right, 35, 12, -5.25F, -5.0F, -2.75F, 3, 6, 5, 0.0F, false));

        foot_right = new RendererModel(this);
        foot_right.setRotationPoint(-4.25F, -0.5F, -3.75F);
        setRotationAngle(foot_right, 0.0F, 0.0F, 0.7854F);
        leg_right.addChild(foot_right);
        foot_right.cubeList.add(new ModelBox(foot_right, 16, 42, -5.0F, -1.5F, -1.0F, 6, 3, 2, 0.0F, false));

        leg_left = new RendererModel(this);
        leg_left.setRotationPoint(3.75F, 22.0F, -0.25F);
        setRotationAngle(leg_left, 0.2618F, 0.0F, 0.0F);
        leg_left.cubeList.add(new ModelBox(leg_left, 32, 32, 2.25F, -5.0F, -2.75F, 3, 6, 5, 0.0F, false));

        foot_left = new RendererModel(this);
        foot_left.setRotationPoint(4.25F, -0.5F, -3.75F);
        setRotationAngle(foot_left, 0.0F, 0.0F, -0.7854F);
        leg_left.addChild(foot_left);
        foot_left.cubeList.add(new ModelBox(foot_left, 0, 42, -1.0F, -1.5F, -1.0F, 6, 3, 2, 0.0F, false));
    }

    @Override
    public void render(CatflyEntity entity, float f0, float f1, float f2, float f3, float f4, float f5) {
        if(this.isChild){
            float f = 2.0F;
            GlStateManager.pushMatrix();
            GlStateManager.scalef(0.9F, 0.9F, 0.9F);
            GlStateManager.translatef(0.0F, 9.0F * f5, 2.0F * f5);
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
    public void setLivingAnimations(CatflyEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

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
    public void setRotationAngles(CatflyEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 300f);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 300f);
        //this.main.rotateAngleX = ((float)Math.PI / 2F);
        this.leg_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.wing_left.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount;
        this.wing_right.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount);
    }
}
