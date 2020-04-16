package at.chaotistin.dragonquestcraft.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class PlatypunkModel extends EntityModel<PlatypunkEntity> {
    private final RendererModel body;
    private final RendererModel tail;
    private final RendererModel head;
    private final RendererModel beak;
    private final RendererModel beak_low;
    private final RendererModel hair;
    private final RendererModel arm_right;
    private final RendererModel arm_left;
    private final RendererModel leg_right;
    private final RendererModel leg_left;

    public PlatypunkModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 18.5F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 0, -6.0F, -6.5F, -6.0F, 12, 11, 12, 0.0F, false));

        tail = new RendererModel(this);
        tail.setRotationPoint(0.0F, 3.5F, 6.0F);
        body.addChild(tail);
        tail.cubeList.add(new ModelBox(tail, 26, 26, -1.0F, -1.0F, -1.0F, 2, 2, 14, 0.0F, false));
        tail.cubeList.add(new ModelBox(tail, 26, 26, -1.0F, -1.0F, -1.0F, 2, 2, 14, 0.0F, false));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 9.0F, 0.0F);
        head.cubeList.add(new ModelBox(head, 0, 23, -5.0F, -3.0F, -6.0F, 10, 6, 10, 0.0F, false));

        beak = new RendererModel(this);
        beak.setRotationPoint(0.0F, 13.0F, 0.0F);
        head.addChild(beak);
        beak.cubeList.add(new ModelBox(beak, 26, 42, -4.0F, -11.0F, -11.0F, 8, 3, 5, 0.0F, false));
        beak.cubeList.add(new ModelBox(beak, 48, 10, -2.0F, -13.0F, -9.0F, 4, 2, 3, 0.0F, false));

        beak_low = new RendererModel(this);
        beak_low.setRotationPoint(0.0F, 0.0F, 0.0F);
        beak.addChild(beak_low);
        beak_low.cubeList.add(new ModelBox(beak_low, 44, 19, -4.0F, -8.0F, -10.0F, 8, 1, 4, 0.0F, false));

        hair = new RendererModel(this);
        hair.setRotationPoint(0.0F, -5.0F, 0.0F);
        head.addChild(hair);
        hair.cubeList.add(new ModelBox(hair, 44, 44, -1.0F, -2.0F, -4.0F, 2, 4, 8, 0.0F, false));

        arm_right = new RendererModel(this);
        arm_right.setRotationPoint(-6.0F, 16.5F, -3.5F);
        setRotationAngle(arm_right, 0.0F, -0.9599F, -0.8727F);
        arm_right.cubeList.add(new ModelBox(arm_right, 44, 30, -7.0F, -1.5F, -1.5F, 8, 3, 3, 0.0F, false));

        arm_left = new RendererModel(this);
        arm_left.setRotationPoint(6.0F, 16.5F, -3.5F);
        setRotationAngle(arm_left, 0.0F, 0.8727F, 0.8727F);
        arm_left.cubeList.add(new ModelBox(arm_left, 44, 24, -1.0F, -1.5F, -1.5F, 8, 3, 3, 0.0F, false));

        leg_right = new RendererModel(this);
        leg_right.setRotationPoint(-5.0F, 23.0F, -2.0F);
        leg_right.cubeList.add(new ModelBox(leg_right, 0, 39, -3.0F, -1.0F, -6.0F, 5, 2, 8, 0.0F, false));

        leg_left = new RendererModel(this);
        leg_left.setRotationPoint(5.0F, 23.0F, -2.0F);
        leg_left.cubeList.add(new ModelBox(leg_left, 36, 0, -2.0F, -1.0F, -6.0F, 5, 2, 8, 0.0F, false));


        //super.bipedHead = head;
        //super.bipedBody = body;
        //super.bipedLeftArm = arm_left;
        //super.bipedRightArm = arm_right;
        //super.bipedLeftLeg = leg_left;
        //super.bipedRightLeg = leg_right;

    }

    public void setLivingAnimations(PlatypunkEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

        if (entityIn.isSitting()) {
            setRotationAngle(leg_left, 0.0F, -0.8727F, 0.0F);
            setRotationAngle(arm_left, -0.5236F, 2.269F, -0.6981F);
            setRotationAngle(leg_right, 0.0F, 0.8727F, 0.0F);
            setRotationAngle(arm_right, -0.5236F, -2.2689F, 0.6981F);
        }
        else{
            setRotationAngle(leg_left, 0.0F, 0F, 0.0F);
            setRotationAngle(arm_left, 0.0F, 0.8727F, 0.8727F);
            setRotationAngle(arm_right, 0.0F, -0.9599F, -0.8727F);
            setRotationAngle(leg_right, 0F, 0F, 0F);
        }
    }

    @Override
    public void render(PlatypunkEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        body.render(f5);
        head.render(f5);
        arm_right.render(f5);
        arm_left.render(f5);
        leg_right.render(f5);
        leg_left.render(f5);
    }

    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(PlatypunkEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.main.rotateAngleX = ((float)Math.PI / 2F);
        this.leg_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.arm_left.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount;
        this.arm_right.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
    }


    public RendererModel getHead() {
        return this.head;
    }
}
