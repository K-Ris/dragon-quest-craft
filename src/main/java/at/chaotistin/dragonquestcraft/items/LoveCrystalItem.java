package at.chaotistin.dragonquestcraft.items;

import at.chaotistin.dragonquestcraft.setup.ModSetup;
import net.minecraft.item.Item;

public class LoveCrystalItem extends Item {

    public LoveCrystalItem() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(ModSetup.itemGroup));
        setRegistryName("lovecrystal");
    }
}
