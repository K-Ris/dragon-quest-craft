package at.chaotistin.dragonquestcraft.entities;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class PickyModel extends EntityModel<PickyEntity> {
    private final RendererModel body;
    private final RendererModel tail;
    private final RendererModel head;
    private final RendererModel beak;
    private final RendererModel neck;
    private final RendererModel hair;
    private final RendererModel leg_left;
    private final RendererModel talon_right;
    private final RendererModel talon_left;
    private final RendererModel leg_right;
    private final RendererModel wing_left;
    private final RendererModel wing_right;

    public PickyModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new RendererModel(this);
        body.setRotationPoint(4.0F, 16.0F, -2.0F);
        body.cubeList.add(new ModelBox(body, 0, 0, -10.0F, -10.0F, 0.0F, 12, 11, 12, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 30, -9.0F, -9.0F, -7.0F, 10, 9, 7, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 34, 37, -9.0F, -9.0F, 12.0F, 10, 9, 2, 0.0F, false));

        tail = new RendererModel(this);
        tail.setRotationPoint(-3.0F, -4.0F, 12.0F);
        setRotationAngle(tail, 0.3491F, 0.0F, 0.0F);
        body.addChild(tail);
        tail.cubeList.add(new ModelBox(tail, 26, 0, -7.0F, 0.342F, 0.9397F, 12, 0, 10, 0.0F, false));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 11.1667F, -7.0F);
        head.cubeList.add(new ModelBox(head, 43, 18, -3.0F, -3.1667F, -7.0F, 6, 7, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 44, 48, -1.0F, -0.1667F, -10.0F, 2, 2, 3, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 9, -1.0F, 1.8333F, -9.0F, 2, 1, 2, 0.0F, false));

        beak = new RendererModel(this);
        beak.setRotationPoint(0.0F, 0.3333F, -9.5F);
        setRotationAngle(beak, -0.6109F, 0.0F, 0.0F);
        head.addChild(beak);
        beak.cubeList.add(new ModelBox(beak, 6, 0, -1.0F, -0.5F, -0.5F, 2, 3, 1, 0.0F, false));

        neck = new RendererModel(this);
        neck.setRotationPoint(1.0F, -4.1667F, -3.1667F);
        setRotationAngle(neck, 0.1745F, 0.0F, 0.0F);
        head.addChild(neck);
        neck.cubeList.add(new ModelBox(neck, 48, 14, -4.0F, 0.0F, -0.8333F, 6, 1, 3, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 27, 30, -5.0F, 0.0F, 2.1667F, 8, 1, 6, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 0, 46, -4.0F, 0.0F, 8.1667F, 6, 1, 5, 0.0F, false));

        hair = new RendererModel(this);
        hair.setRotationPoint(0.0F, -2.1667F, -2.5F);
        setRotationAngle(hair, 0.3491F, 0.0F, 0.0F);
        head.addChild(hair);
        hair.cubeList.add(new ModelBox(hair, 0, 3, 0.0F, -6.5634F, -1.6953F, 0, 7, 20, 0.0F, false));

        leg_left = new RendererModel(this);
        leg_left.setRotationPoint(3.1429F, 17.5714F, 3.0F);
        leg_left.cubeList.add(new ModelBox(leg_left, 57, 43, -0.1429F, -1.5714F, -3.0F, 3, 4, 5, 0.0F, false));
        leg_left.cubeList.add(new ModelBox(leg_left, 60, 0, -0.1429F, 2.4286F, -1.0F, 2, 3, 2, 0.0F, false));
        leg_left.cubeList.add(new ModelBox(leg_left, 53, 30, -0.1429F, 5.4286F, -2.0F, 3, 1, 3, 0.0F, false));
        leg_left.cubeList.add(new ModelBox(leg_left, 19, 62, 1.8571F, 5.4286F, -5.0F, 1, 1, 3, 0.0F, false));
        leg_left.cubeList.add(new ModelBox(leg_left, 60, 18, -0.1429F, 5.4286F, -5.0F, 1, 1, 3, 0.0F, false));


        leg_right = new RendererModel(this);
        leg_right.setRotationPoint(-3.1429F, 17.5714F, 3.0F);
        leg_right.cubeList.add(new ModelBox(leg_right, 55, 5, -2.8571F, -1.5714F, -3.0F, 3, 4, 5, 0.0F, false));
        leg_right.cubeList.add(new ModelBox(leg_right, 14, 60, -1.8571F, 2.4286F, -1.0F, 2, 3, 2, 0.0F, false));
        leg_right.cubeList.add(new ModelBox(leg_right, 8, 52, -2.8571F, 5.4286F, -2.0F, 3, 1, 3, 0.0F, false));
        leg_right.cubeList.add(new ModelBox(leg_right, 60, 60, -2.8571F, 5.4286F, -5.0F, 1, 1, 3, 0.0F, false));
        leg_right.cubeList.add(new ModelBox(leg_right, 30, 48, -0.8571F, 5.4286F, -5.0F, 1, 1, 3, 0.0F, false));

        talon_right = new RendererModel(this);
        talon_right.setRotationPoint(-2.3571F, 5.9286F, 0.5F);
        setRotationAngle(talon_right, 0.0F, -0.7854F, 0.0F);
        leg_right.addChild(talon_right);
        talon_right.cubeList.add(new ModelBox(talon_right, 36, 10, -3.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F, false));

        talon_left = new RendererModel(this);
        talon_left.setRotationPoint(-0.3571F, 5.9286F, 0.5F);
        setRotationAngle(talon_left, 0.0F, 0.9599F, 0.0F);
        leg_right.addChild(talon_left);
        talon_left.cubeList.add(new ModelBox(talon_left, 44, 10, 0.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F, false));


        wing_left = new RendererModel(this);
        wing_left.setRotationPoint(6.0F, 9.0F, -2.0F);
        wing_left.cubeList.add(new ModelBox(wing_left, 35, 48, -1.0F, -1.0F, -3.0F, 2, 10, 5, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 0, 52, 0.0F, 1.0F, 2.0F, 1, 8, 6, 0.0F, false));
        wing_left.cubeList.add(new ModelBox(wing_left, 0, 0, 0.0F, 4.0F, 8.0F, 1, 5, 4, 0.0F, false));

        wing_right = new RendererModel(this);
        wing_right.setRotationPoint(-6.0F, 9.0F, -2.0F);
        wing_right.cubeList.add(new ModelBox(wing_right, 21, 47, -1.0F, -1.0F, -3.0F, 2, 10, 5, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 49, 49, -1.0F, 1.0F, 2.0F, 1, 8, 6, 0.0F, false));
        wing_right.cubeList.add(new ModelBox(wing_right, 58, 34, -1.0F, 5.0F, 8.0F, 1, 4, 3, 0.0F, false));
    }

    @Override
    public void render(PickyEntity entity, float f0, float f1, float f2, float f3, float f4, float f5) {
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
            wing_left.render(f5);
            wing_right.render(f5);
        }


    }
    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(PickyEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.main.rotateAngleX = ((float)Math.PI / 2F);
        this.wing_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.wing_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
