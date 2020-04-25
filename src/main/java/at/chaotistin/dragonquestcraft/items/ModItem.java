package at.chaotistin.dragonquestcraft.items;

import at.chaotistin.dragonquestcraft.setup.ModSetup;
import net.minecraft.item.Item;

public class ModItem extends Item {
    public ModItem() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(null));
        setRegistryName("moditem");
    }
}
