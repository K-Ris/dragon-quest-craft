package at.chaotistin.dragonquestcraft;

import at.chaotistin.dragonquestcraft.items.spawneggs.BlueslimeEggItem;
import at.chaotistin.dragonquestcraft.items.spawneggs.DrackyEggItem;
import at.chaotistin.dragonquestcraft.items.spawneggs.PlatypunkEggItem;
import at.chaotistin.dragonquestcraft.proxy.ClientProxy;
import at.chaotistin.dragonquestcraft.proxy.IProxy;
import at.chaotistin.dragonquestcraft.proxy.ServerProxy;
import at.chaotistin.dragonquestcraft.registries.MobEntities;
import at.chaotistin.dragonquestcraft.registries.SoundsHandler;
import at.chaotistin.dragonquestcraft.setup.ModSetup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("dragonquestcraft")
public class Main
{
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static final String MODID = "dragonquestcraft";

    public static ModSetup setup = new ModSetup();
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        setup.init();
        proxy.init();
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onSoundsRegistry(final RegistryEvent.Register<SoundEvent> event){
            SoundsHandler.registerSounds();
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(ModSetup.itemGroup);
            event.getRegistry().register(new PlatypunkEggItem());
            event.getRegistry().register(new DrackyEggItem());
            event.getRegistry().register(new BlueslimeEggItem());

            MobEntities.registerEntityWorldSpawns();
        }
        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().register(MobEntities.PLATYPUNK);
            event.getRegistry().register(MobEntities.DRACKY);
            event.getRegistry().register(MobEntities.BLUESLIME);
            event.getRegistry().register(MobEntities.BULLBIRD);
        }
    }
}
