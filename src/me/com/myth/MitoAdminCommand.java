package me.com.myth;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import rcore.command.RCommand;

public class MitoAdminCommand extends RCommand {

	@Override
	public boolean canConsolePerform() {
		return false;
	}

	@Override
	public List<String> getAliases() {
		return null;
	}

	@Override
	public String getCommand() {
		return "mitoadmin";
	}

	@Override
	public List<Object> getDescription() {
		return null;
	}

	@Override
	public int getHelpPageSize() {
		return 0;
	}

	@Override
	public List<Object> getHelpPages() {
		return null;
	}

	@Override
	public String getNextHelpPageCommand() {
		return null;
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String getPreviousHelpPageCommand() {
		return null;
	}

	@Override
	public void perform() {

		if (this.asPlayer().hasPermission("mito.admin")) {
			switch (argsLength()) {
			case 0:
				this.asPlayer().sendMessage("§cUtilize: /mitoadmin setar (jogador)");
				break;
			case 1:
				this.asPlayer().sendMessage("§cUtilize: /mitoadmin setar (jogador)");
				break;
			case 2:
				if (getArgs()[0].equalsIgnoreCase("setar")) {
					String target = getArgs()[1];
					Player ALVO = Bukkit.getPlayer(target);
					
					if(ALVO == null) {
						this.asPlayer().sendMessage("§cJogador não foi encontrado.");
						break;
					}
					
					Main.getInstance().getConfig().set("Mito", ALVO.getName());
					Main.getInstance().saveConfig();
					ALVO.getWorld().strikeLightning(ALVO.getLocation());
					for(Player on : Bukkit.getOnlinePlayers()) {
						on.sendMessage(new String[] { "", "§eMITO", "§f O jogador §e" + ALVO.getName() + " §fse tornou o mais novo mito do servidor." } );
						on.getWorld().strikeLightning(on.getLocation());
					}
				}
			}
		} else {
			this.asPlayer().sendMessage(new String[] { "", "§c§LEI! §cVocê não possui permissão.", "" });
		}

	}

	@Override
	public List<String> tabComplete() {
		return null;
	}

}
