package at.chaotistin.dragonquestcraft.setup;

import at.chaotistin.dragonquestcraft.Main;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModSetup {
    public static ItemGroup itemGroup = new ItemGroup(Main.MODID){
        @Override
        public ItemStack createIcon(){
            return new ItemStack(Items.BOOK);
        }
    };

    public void init(){
    }
}
