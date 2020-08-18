package me.com.myth;

import rcore.plugin.RPlugin;

public class Main extends RPlugin {

	private static Main instance;

	public Main() {
		super("MythMito", "eMatheux");
	}

	@Override
	public void onPreStart() {

	}

	@Override
	public void onStart() {
		instance = this;
		loadConfig();
		setListener(new MitoListener());
		registerCommand(new MitoAdminCommand());
		registerCommand(new MitoCommand());
	}

	@Override
	public void onStop() {

	}

	public void loadConfig() {
		getConfig().options().copyDefaults(false);
		this.saveDefaultConfig();
	}

	public static Main getInstance() {
		return instance;
	}

}
