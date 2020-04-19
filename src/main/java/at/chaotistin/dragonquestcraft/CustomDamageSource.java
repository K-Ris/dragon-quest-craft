package at.chaotistin.dragonquestcraft;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class CustomDamageSource extends DamageSource {
    public CustomDamageSource(String damageTypeIn) {
        super(damageTypeIn);
    }

    public static final DamageSource BREEDING_MSG = (new DamageSource("breedingmsg")).setDamageBypassesArmor().setDamageAllowedInCreativeMode();

    @Override
    public ITextComponent getDeathMessage(LivingEntity entityLivingBaseIn) {
        LivingEntity livingentity = entityLivingBaseIn.getAttackingEntity();
        String s = "death.attack.dragonquestcraft." + this.damageType;
        String s1 = s + ".player";
        return livingentity != null ? new TranslationTextComponent(s1, entityLivingBaseIn.getDisplayName(), livingentity.getDisplayName()) : new TranslationTextComponent(s, entityLivingBaseIn.getDisplayName());
    }
}
