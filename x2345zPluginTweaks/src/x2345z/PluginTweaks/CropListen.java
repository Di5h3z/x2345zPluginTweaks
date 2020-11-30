package x2345z.PluginTweaks;

import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CropListen implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getBlockData() instanceof Ageable
				&& ((Ageable) event.getClickedBlock().getBlockData())
						.getAge() == ((Ageable) event.getClickedBlock().getBlockData()).getMaximumAge()
				&& event.getClickedBlock().getType() != Material.BAMBOO) {

			Material origtype = event.getClickedBlock().getType();

			event.getClickedBlock().breakNaturally();
			event.getClickedBlock().setType(origtype);
			Ageable crop = (Ageable) event.getClickedBlock().getBlockData();
			crop.setAge(0);
			event.getClickedBlock().setBlockData(crop);

		}

		else if (PluginTweaksMain.config.getBoolean("RightClickVines") && event.getAction() == Action.RIGHT_CLICK_BLOCK
				&& event.getPlayer().getInventory().getItemInMainHand().getType() == Material.SHEARS
				&& event.getClickedBlock().getType() == Material.VINE) {

			event.getClickedBlock().breakNaturally(event.getPlayer().getInventory().getItemInMainHand());

		}

	}

}