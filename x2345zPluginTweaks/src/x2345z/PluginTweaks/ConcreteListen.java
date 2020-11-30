package x2345z.PluginTweaks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ConcreteListen implements Listener {

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {

		Item itemdropped = event.getItemDrop();
		String name = itemdropped.getItemStack().getType().name();

		if (itemdropped.getItemStack().getType().name().contains("CONCRETE_POWDER")) {

			int counter = 0;
			new BukkitRunnable() {
				@Override
				public void run() {

					if (itemdropped.getLocation().getBlock().getType() == Material.WATER) {
						itemdropped.getItemStack().setType(Material.getMaterial(name.substring(0, name.length() - 7)));
						cancel();
					} else if (counter > 100) {
						Bukkit.broadcastMessage("fuq this im out");
						cancel();
					}

				}

			}.runTaskTimer(PluginTweaksMain.plugin, 1, 1);

		}

	}

}
