package org.ik26w30.luthos.playerfreeze.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ik26w30.luthos.playerfreeze.config.AreaConfig;
import org.ik26w30.luthos.playerfreeze.utils.ControlUtils;

import java.util.ArrayList;
import java.util.List;

public class ControlCommand implements CommandExecutor {
    private final List<String> playerFreezed = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cYou are console!");
            return true;
        }

        if(!(sender.hasPermission("freeze.staff"))){
            sender.sendMessage("§cYou don't have permissions to execute this command!");
            return true;
        }

        if(args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null){
                if(target != sender){
                    if(!(target.hasPermission("freeze.bypass"))){
                        if(!playerFreezed.contains(args[0])){
                            playerFreezed.add(args[0]);
                            sender.sendMessage("§cPlayer succesfully freezed");

                            Bukkit
                                    .getOnlinePlayers()
                                    .stream()
                                    .filter(player -> player.hasPermission("freeze.message"))
                                    .forEach(player -> player.sendMessage("§cPlayer " + target.getName() + " has freezed by " + sender.getName()));

                            ControlUtils control = new ControlUtils();
                            control.targetFreezeModule(target);

                            AreaConfig area = new AreaConfig();
                            World world = ((Player) sender).getWorld();

                            double x1 = area.getYaml().getDouble("area.getX");
                            double y1 = area.getYaml().getDouble("area.getY");
                            double z1 = area.getYaml().getDouble("area.getZ");

                            Location location = new Location(world, x1, y1, z1);

                            ((Player) sender).teleport(location);
                            target.teleport(location);

                        }else {
                            playerFreezed.remove(args[0]);
                            sender.sendMessage("§cPlayer unfreezed");
                            ControlUtils control = new ControlUtils();
                            control.targetUnFreezeModule(target);

                            Bukkit
                                    .getOnlinePlayers()
                                    .stream()
                                    .filter(player -> player.hasPermission("unfreeze.message"))
                                    .forEach(player -> player.sendMessage("§cPlayer " + target.getName() + " has unfreezed by " + sender.getName()));


                            return true;
                        }
                    }else {
                        sender.sendMessage("§cYou can't freeze this player!");
                        return true;
                    }
                }else {
                    sender.sendMessage("§cYou can't freeze yourself");
                    return true;
                }
            }else {
                sender.sendMessage("§cError: cheater to freeze not found");
                return true;
            }
        }else {
            sender.sendMessage("§cError: use /freeze <other player>");
            return true;
        }

        return false;
    }
}
