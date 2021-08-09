import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class BedrockRezeptPlugin extends JavaPlugin {

	public void onEnable() {
		ItemStack blume = new ItemStack(Material.BEDROCK);
		ShapelessRecipe blumeRezept = new ShapelessRecipe(blume);
		blumeRezept.addIngredient(Material.OAK_PLANKS);
		this.getServer().addRecipe(blumeRezept);
	}

	public void onDisable() {
	}
}
