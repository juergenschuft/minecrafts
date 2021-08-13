import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener extends MasterListener {
    @EventHandler
    public void onEvent(PlayerJoinEvent event){
    	this.schneebaelleGeben(event);
    }
}