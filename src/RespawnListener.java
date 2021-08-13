import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener extends MasterListener {
	@EventHandler
	public void onEvent(PlayerRespawnEvent event){
		this.schneebaelleGeben(event);
	}
}