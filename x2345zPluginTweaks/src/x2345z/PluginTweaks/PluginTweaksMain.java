package x2345z.PluginTweaks;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

// Ideas for new cool stuff
// chest organizer (use a book and quill to specify organization?!?!)
// block replace(offhand functionality possibly)

public class PluginTweaksMain extends JavaPlugin {
	public static PluginTweaksMain plugin;
	public static FileConfiguration config;

	@Override
	public void onEnable() {
		config = this.getConfig();
		plugin = this;

		config.addDefault("RightClickToHarvest", true);
		config.addDefault("EasyConcrete", true);
		config.addDefault("RightClickVines", true);
		config.options().copyDefaults(true);
		saveConfig();

		if (config.getBoolean("RightClickToHarvest")) {
			getServer().getPluginManager().registerEvents(new CropListen(), this);
		}
		if (config.getBoolean("EasyConcrete")) {
			getServer().getPluginManager().registerEvents(new ConcreteListen(), this);
		}
		
		//getServer().getPluginManager().registerEvents(new BlockReplaceListen(), this);
		
		
		

	}

	@Override
	public void onDisable() {

	}

}
