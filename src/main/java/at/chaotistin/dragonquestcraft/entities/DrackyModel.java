package at.chaotistin.dragonquestcraft.entities;

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
    public void render(DrackyEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        body.render(f5);
        wing_right.render(f5);
        wing_left.render(f5);
        leg_right.render(f5);
        leg_left.render(f5);
    }
    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }

    public void setLivingAnimations(DrackyEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        this.func_217160_a(func_217158_a(entityIn));
    }

    private void func_217162_a(DrackyModel.State p_217162_1_, int p_217162_2_, float p_217162_3_, float p_217162_4_, float p_217162_5_, float p_217162_6_, float p_217162_7_) {
        this.body.rotateAngleX = p_217162_7_ * ((float)Math.PI / 180F);
        this.body.rotateAngleY = p_217162_6_ * ((float)Math.PI / 180F);
        this.body.rotateAngleZ = 0.0F;
        this.body.rotationPointX = 0.0F;
        this.body.rotationPointX = 0.0F;
        this.tail.rotationPointX = 0.0F;
        this.wing_right.rotationPointX = -1.5F;
        this.wing_left.rotationPointX = 1.5F;
        switch(p_217162_1_) {
            case SITTING:
                break;
            case PARTY:
                float f = MathHelper.cos((float)p_217162_2_);
                float f1 = MathHelper.sin((float)p_217162_2_);
                this.body.rotationPointX = f;
                this.body.rotationPointY = 15.69F + f1;
                this.body.rotateAngleX = 0.0F;
                this.body.rotateAngleY = 0.0F;
                this.body.rotateAngleZ = MathHelper.sin((float)p_217162_2_) * 0.4F;
                this.body.rotationPointX = f;
                this.body.rotationPointY = 16.5F + f1;
                this.wing_left.rotateAngleZ = -0.0873F - p_217162_5_;
                this.wing_left.rotationPointX = 1.5F + f;
                this.wing_left.rotationPointY = 16.94F + f1;
                this.wing_right.rotateAngleZ = 0.0873F + p_217162_5_;
                this.wing_right.rotationPointX = -1.5F + f;
                this.wing_right.rotationPointY = 16.94F + f1;
                this.tail.rotationPointX = f;
                this.tail.rotationPointY = 21.07F + f1;
                break;
            case STANDING:
                this.leg_left.rotateAngleX += MathHelper.cos(p_217162_3_ * 0.6662F) * 1.4F * p_217162_4_;
                this.wing_right.rotateAngleX += MathHelper.cos(p_217162_3_ * 0.6662F + (float)Math.PI) * 1.4F * p_217162_4_;
            case FLYING:
            case ON_SHOULDER:
            default:
                float f2 = p_217162_5_ * 0.3F;
                this.body.rotationPointY = 15.69F + f2;
                this.tail.rotateAngleX = 1.015F + MathHelper.cos(p_217162_3_ * 0.6662F) * 0.3F * p_217162_4_;
                this.tail.rotationPointY = 21.07F + f2;
                this.body.rotationPointY = 16.5F + f2;
                this.wing_left.rotateAngleZ = -0.0873F - p_217162_5_;
                this.wing_left.rotationPointY = 16.94F + f2;
                this.wing_right.rotateAngleZ = 0.0873F + p_217162_5_;
                this.wing_right.rotationPointY = 16.94F + f2;
                this.leg_left.rotationPointY = 22.0F + f2;
                this.wing_right.rotationPointY = 22.0F + f2;
        }

    }

    private void func_217159_a(float p_217159_1_) {
        this.body.render(p_217159_1_);
        this.wing_left.render(p_217159_1_);
        this.wing_right.render(p_217159_1_);
        this.tail.render(p_217159_1_);
        this.body.render(p_217159_1_);
        this.leg_left.render(p_217159_1_);
        this.leg_right.render(p_217159_1_);
    }

    private void func_217160_a(DrackyModel.State p_217160_1_) {
        //this.feather.rotateAngleX = -0.2214F;
        this.body.rotateAngleX = 0.4937F;
        this.wing_left.rotateAngleX = -0.6981F;
        this.wing_left.rotateAngleY = -(float)Math.PI;
        this.wing_right.rotateAngleX = -0.6981F;
        this.wing_right.rotateAngleY = -(float)Math.PI;
        this.leg_left.rotateAngleX = -0.0299F;
        this.wing_right.rotateAngleX = -0.0299F;
        this.leg_left.rotationPointY = 22.0F;
        this.wing_right.rotationPointY = 22.0F;
        this.leg_left.rotateAngleZ = 0.0F;
        this.wing_right.rotateAngleZ = 0.0F;
        switch(p_217160_1_) {
            case SITTING:
                float f = 1.9F;
                this.body.rotationPointY = 17.59F;
                this.tail.rotateAngleX = 1.5388988F;
                this.tail.rotationPointY = 22.97F;
                this.body.rotationPointY = 18.4F;
                this.wing_left.rotateAngleZ = -0.0873F;
                this.wing_left.rotationPointY = 18.84F;
                this.wing_right.rotateAngleZ = 0.0873F;
                this.wing_right.rotationPointY = 18.84F;
                ++this.leg_left.rotationPointY;
                ++this.wing_right.rotationPointY;
                ++this.leg_left.rotateAngleX;
                ++this.wing_right.rotateAngleX;
                break;
            case PARTY:
                this.leg_left.rotateAngleZ = -0.34906584F;
                this.wing_right.rotateAngleZ = 0.34906584F;
            case STANDING:
            case ON_SHOULDER:
            default:
                break;
            case FLYING:
                this.leg_left.rotateAngleX += 0.6981317F;
                this.wing_right.rotateAngleX += 0.6981317F;
        }

    }

    private static DrackyModel.State func_217158_a(DrackyEntity p_217158_0_) {
        if (p_217158_0_.isSitting()) {
            return DrackyModel.State.SITTING;
        } else {
            return p_217158_0_.isFlying() ? DrackyModel.State.FLYING : DrackyModel.State.STANDING;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static enum State {
        FLYING,
        STANDING,
        SITTING,
        PARTY,
        ON_SHOULDER;
    }
}
