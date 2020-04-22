package at.chaotistin.dragonquestcraft.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class TonguellaModel extends EntityModel<TonguellaEntity> {
    private final RendererModel body;
    private final RendererModel head;
    private final RendererModel tongue;
    private final RendererModel tail;
    private final RendererModel arm_right;
    private final RendererModel hand_right;
    private final RendererModel arm_left;
    private final RendererModel hand_left;
    private final RendererModel leg_right;
    private final RendererModel leg_left;

    public TonguellaModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 13.6F, -0.1F);
        body.cubeList.add(new ModelBox(body, 44, 0, -7.0F, 9.4F, -4.9F, 14, 1, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 0, -8.0F, 2.4F, -5.9F, 16, 7, 12, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 40, 41, -7.0F, -2.6F, -4.9F, 14, 5, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 19, -8.0F, -8.6F, -5.9F, 16, 6, 12, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 37, -7.0F, -11.6F, -5.9F, 14, 3, 11, 0.0F, false));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 8.0F, -6.5F);
        head.cubeList.add(new ModelBox(head, 49, 12, -6.0F, -5.0F, -5.5F, 12, 8, 7, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 41, 6.0F, -2.0F, -5.5F, 2, 3, 2, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 39, 39, -8.0F, -2.0F, -5.5F, 2, 3, 2, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 19, -2.0F, -2.0F, -7.5F, 4, 2, 2, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 44, 5, -5.0F, -8.0F, -2.5F, 2, 3, 2, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 44, 0, 3.0F, -8.0F, -2.5F, 2, 3, 2, 0.0F, false));

        tongue = new RendererModel(this);
        tongue.setRotationPoint(0.0F, 2.0F, -6.0F);
        head.addChild(tongue);
        tongue.cubeList.add(new ModelBox(tongue, 0, 0, -2.0F, -1.0F, -0.5F, 4, 10, 1, 0.0F, false));

        tail = new RendererModel(this);
        tail.setRotationPoint(0.0F, 21.6667F, 4.6667F);
        tail.cubeList.add(new ModelBox(tail, 0, 51, -3.0F, -3.6667F, 0.3333F, 6, 6, 8, 0.0F, false));
        tail.cubeList.add(new ModelBox(tail, 56, 27, -2.0F, -2.6667F, 8.3333F, 4, 5, 8, 0.0F, false));
        tail.cubeList.add(new ModelBox(tail, 52, 66, -1.0F, -0.6667F, 16.3333F, 2, 3, 6, 0.0F, false));

        arm_right = new RendererModel(this);
        arm_right.setRotationPoint(-7.5F, 8.5F, 0.5F);
        setRotationAngle(arm_right, 0.0F, 0.0F, -0.3491F);
        arm_right.cubeList.add(new ModelBox(arm_right, 56, 56, -9.5F, -2.5F, -2.5F, 9, 5, 5, 0.0F, false));

        hand_right = new RendererModel(this);
        hand_right.setRotationPoint(-9.0F, 0.866F, 0.0F);
        setRotationAngle(hand_right, 0.0F, 0.0F, -0.9599F);
        arm_right.addChild(hand_right);
        hand_right.cubeList.add(new ModelBox(hand_right, 65, 72, -6.0F, -1.5F, -1.5F, 6, 3, 3, 0.0F, false));
        hand_right.cubeList.add(new ModelBox(hand_right, 0, 37, -8.0F, -0.5F, -1.5F, 2, 1, 3, 0.0F, false));

        arm_left = new RendererModel(this);
        arm_left.setRotationPoint(8.5F, 8.5F, 0.5F);
        setRotationAngle(arm_left, 0.0F, 0.0F, 0.3491F);
        arm_left.cubeList.add(new ModelBox(arm_left, 28, 56, -0.5F, -2.5F, -2.5F, 9, 5, 5, 0.0F, false));

        hand_left = new RendererModel(this);
        hand_left.setRotationPoint(8.5F, 0.0F, 0.0F);
        setRotationAngle(hand_left, 0.0F, 0.0F, 0.9599F);
        arm_left.addChild(hand_left);
        hand_left.cubeList.add(new ModelBox(hand_left, 62, 66, 0.0F, -1.5F, -1.5F, 6, 3, 3, 0.0F, false));
        hand_left.cubeList.add(new ModelBox(hand_left, 0, 24, 6.0F, -0.5F, -1.5F, 2, 1, 3, 0.0F, false));

        leg_right = new RendererModel(this);
        leg_right.setRotationPoint(-7.5F, 23.0F, -2.0F);
        leg_right.cubeList.add(new ModelBox(leg_right, 26, 66, -2.5F, -1.0F, -7.0F, 5, 2, 8, 0.0F, false));

        leg_left = new RendererModel(this);
        leg_left.setRotationPoint(7.5F, 23.0F, -2.0F);
        leg_left.cubeList.add(new ModelBox(leg_left, 0, 65, -2.5F, -1.0F, -7.0F, 5, 2, 8, 0.0F, false));
    }

    @Override
    public void render(TonguellaEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        body.render(f5);
        head.render(f5);
        tail.render(f5);
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
    public void setRotationAngles(TonguellaEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.main.rotateAngleX = ((float)Math.PI / 2F);
        this.leg_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.arm_left.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount;
        this.arm_right.rotateAngleZ = (MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount)*(-1);
    }


    public RendererModel getHead() {
        return this.head;
    }

    public void setLivingAnimations(TonguellaEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

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
}
