package at.chaotistin.dragonquestcraft.setup;

import at.chaotistin.dragonquestcraft.Main;
import at.chaotistin.dragonquestcraft.items.ModItem;
import at.chaotistin.dragonquestcraft.registries.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModSetup {
    public static ItemGroup itemGroup = new ItemGroup(Main.MODID){
        @Override
        public ItemStack createIcon(){
            return new ItemStack(ModItems.MODITEM);
        }
    };

    public void init(){
    }
}
