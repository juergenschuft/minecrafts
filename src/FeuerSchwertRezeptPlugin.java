import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FeuerSchwertRezeptPlugin extends JavaPlugin {
	public class FeuerschwertListener implements Listener {
		@EventHandler
		public void onEvent(PlayerInteractEvent event) {
			ItemStack gegenstand = event.getItem();
			ItemMeta metaData = gegenstand.getItemMeta();

			if (metaData.getDisplayName().equals("Feuerschwert")) {
				Block block = event.getClickedBlock();
				Block blockH = block.getRelative(BlockFace.UP);
				blockH.setType(Material.FIRE);
				event.setCancelled(true);
			}
		}
	}

	public void onEnable() {
		ItemStack feuerschwert = new ItemStack(Material.IRON_SWORD);
		ItemMeta metaData = feuerschwert.getItemMeta();
		metaData.setDisplayName("Feuerschwert");
		feuerschwert.setItemMeta(metaData);
		feuerschwert.addUnsafeEnchantment(Enchantment.LUCK, 1);

		ShapelessRecipe feuerschwertRezept = new ShapelessRecipe(feuerschwert);
		feuerschwertRezept.addIngredient(Material.IRON_SWORD);
		feuerschwertRezept.addIngredient(Material.FLINT_AND_STEEL);
		this.getServer().addRecipe(feuerschwertRezept);

		PluginManager pluginManager = this.getServer().getPluginManager();
		FeuerschwertListener listener = new FeuerschwertListener();
		pluginManager.registerEvents(listener, this);
	}

	public void onDisable() {
	}
}
