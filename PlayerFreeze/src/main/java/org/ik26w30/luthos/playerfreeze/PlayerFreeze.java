package org.ik26w30.luthos.playerfreeze;

import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.luthos.playerfreeze.commands.AreaSetExecutor;
import org.ik26w30.luthos.playerfreeze.commands.ControlCommand;
import org.ik26w30.luthos.playerfreeze.config.AreaConfig;
import org.ik26w30.luthos.playerfreeze.config.MessageConfig;
import org.ik26w30.luthos.playerfreeze.listeners.MovementTarget;

public final class PlayerFreeze extends JavaPlugin {
    private static PlayerFreeze instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        registerControlCommands();
        registerSpawnAreaForControlCommands();
        registerAreaControlConfig();
        registerMessageConfig();
        registerListeners();
    }

    private void registerMessageConfig() {
        MessageConfig config = new MessageConfig();
        config.setupConfig();
        config.config.addDefault("Messages", "");
        config.config.options().copyDefaults(true);
        config.saveFile();
    }

    private void registerAreaControlConfig() {
        AreaConfig config = new AreaConfig();
        config.setupConfig();
        config.config.addDefault("Area", "");
        config.config.options().copyDefaults(true);
        config.saveFile();
    }

    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new MovementTarget(), this);
    }

    private void registerSpawnAreaForControlCommands() {
        this.getCommand("areacontrol").setExecutor(new AreaSetExecutor());
    }

    private void registerControlCommands() {
        this.getCommand("control").setExecutor(new ControlCommand());
    }

    public static PlayerFreeze getInstance(){
        if(instance == null){
            instance = new PlayerFreeze();
        }
        return instance;
    }

}
