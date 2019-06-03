package xavier.just_dust;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xavier.just_dust.proxy.CommonProxy;

@Mod(modid = JustDust.MODID, name = JustDust.MOD_NAME, version = JustDust.VERSION)
public class JustDust {

    public static final String MODID = "just_dust";
    public static final String MOD_NAME = "Just Dust";
    public static final String VERSION = "2.0.0-R";

    @SidedProxy(clientSide = "xavier.just_dust.proxy.ClientProxy", serverSide = "xavier.just_dust.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static JustDust instance;

    @EventHandler
    public  void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        proxy.registerRenderers();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
