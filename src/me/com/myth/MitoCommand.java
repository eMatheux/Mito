package me.com.myth;

import java.util.Arrays;
import java.util.List;

import rcore.command.RCommand;
import rcore.inventory.Inv;
import rcore.util.MakeItem;
import rcore.util.Sound;

public class MitoCommand extends RCommand {

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
		return "mito";
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

	public String getPreviousHelpPageCommand() {
		return null;
	}

	@Override
	public void perform() {

		switch (argsLength()) {
		case 0:
			if (Main.getInstance().getConfig().get("Mito") == null) {
				this.asPlayer().sendMessage("§cNão existe mito no servidor.");
				break;
			}
			String mito = Main.getInstance().getConfig().getString("Mito");
			Inv inv = new Inv(6 * 9, "Mito do servidor");
			inv.setItem(22, new MakeItem(mito).setName("§e§lMITO ATUAL")
					.setLore(Arrays.asList("§7Mito atual: §f" + mito, "", "")).build());
			inv.setCancelClick(true);
			playSound(Sound.BLOCK_CHEST_OPEN, 10.0f, 4.0f);
			inv.open(this.asPlayer());
			break;
		default:
			this.asPlayer().sendMessage("§cSem argumentos.");
		}
	}

	@Override
	public List<String> tabComplete() {
		return null;
	}

}
