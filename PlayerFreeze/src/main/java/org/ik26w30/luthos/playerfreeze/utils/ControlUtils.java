package org.ik26w30.luthos.playerfreeze.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.ik26w30.luthos.playerfreeze.config.MessageConfig;

public class ControlUtils {

    public void targetFreezeModule(Player player){
        MessageConfig message = new MessageConfig();
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-freezed-message-one")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-freezed-message-two")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-freezed-message-three")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-freezed-message-four")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-freezed-message-five")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-freezed-message-six")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-freezed-message-seven")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-freezed-message-eight")));
        player.getInventory().clear();
        player.setWalkSpeed(0.0F);
        player.setFlySpeed(0.0F);
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 999,999));
    }

    public void targetUnFreezeModule(Player player) {
        MessageConfig message = new MessageConfig();
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-unfreezed-message-one")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-unfreezed-message-two")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-unfreezed-message-three")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-unfreezed-message-four")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-unfreezed-message-five")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-unfreezed-message-six")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-unfreezed-message-seven")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getYaml().getString("cheater.target-unfreezed-message-eight")));
        player.setWalkSpeed(0.3F);
        player.setFlySpeed(0.3F);
        player.getActivePotionEffects().clear();
    }
}
