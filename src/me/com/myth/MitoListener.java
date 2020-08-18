package me.com.myth;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class MitoListener implements Listener {

	@EventHandler
	public void morrer(PlayerDeathEvent e) {

		if (e.getEntity().getKiller() instanceof Player) {
			Player killer = e.getEntity().getKiller();
			if (Main.getInstance().getConfig().getString("Mito").contains(e.getEntity().getName())) {
				Main.getInstance().getConfig().set("Mito", killer.getName());
				Main.getInstance().saveConfig();
				killer.getWorld().strikeLightning(killer.getLocation());
				for (Player on : Bukkit.getOnlinePlayers()) {
					on.sendMessage(new String[] { "", "§eMITO",
							"§f O jogador §e" + killer.getName() + " §fse tornou o mais novo mito do servidor." });
					on.getWorld().strikeLightning(on.getLocation());
				}
			}
		}
	}
}
