package x2345z.PluginTweaks;

import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class BlockReplaceListen implements Listener{

	public void replaceCriteria(PlayerInteractEvent event) {
		if(event.getHand() == EquipmentSlot.OFF_HAND && event.getAction() == Action.LEFT_CLICK_BLOCK && event.getPlayer().isSneaking()) {
			Block target = event.getClickedBlock();
			
			
			target.breakNaturally();
			target.setType(event.getItem().getType());
			target.setBlockData(target.getBlockData());
			
			event.getItem().setAmount(event.getItem().getAmount()-1);
			  
		}
		 
		 
	}
	
}
