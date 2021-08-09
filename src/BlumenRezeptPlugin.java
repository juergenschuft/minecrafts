import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class BlumenRezeptPlugin extends JavaPlugin {

	public void onEnable() {
		ItemStack blume = new ItemStack(Material.LEGACY_RED_ROSE);
		ShapelessRecipe blumeRezept = new ShapelessRecipe(blume);
		blumeRezept.addIngredient(Material.EGG);
		this.getServer().addRecipe(blumeRezept);
	}

	public void onDisable() {
	}
}
