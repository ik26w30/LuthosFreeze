package org.ik26w30.luthos.playerfreeze.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.ik26w30.luthos.playerfreeze.PlayerFreeze;

import java.io.File;
import java.io.IOException;

public class MessageConfig {
    public File file = new File(PlayerFreeze.getInstance().getDataFolder(), "messages.yml");
    public FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public void setupConfig(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public FileConfiguration getYaml(){
        return config;
    }

    public void saveFile(){
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadFile(){
        config = YamlConfiguration.loadConfiguration(file);
    }
}
