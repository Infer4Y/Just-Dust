package xavier.just_dust.common.events;


import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xavier.just_dust.common.items.tools.ItemSaw;

public class CancelToolBreakageEvent {
    @SubscribeEvent
    public void onPlayerDestroyItem(PlayerDestroyItemEvent event) {
        if (event.getOriginal().getItem() instanceof ItemSaw){
            event.setCanceled(true);
        }
    }
}
