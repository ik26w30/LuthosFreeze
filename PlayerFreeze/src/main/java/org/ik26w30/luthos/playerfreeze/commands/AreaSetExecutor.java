package org.ik26w30.luthos.playerfreeze.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ik26w30.luthos.playerfreeze.config.AreaConfig;

import java.util.ArrayList;
import java.util.List;

public class AreaSetExecutor implements CommandExecutor {
    private final List<String> positionList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cHi!");
            return true;
        }

        if (!(sender.hasPermission("areacontrol.admin"))) {
            sender.sendMessage("§cYou don't have permissions to execute this command!");
            return true;
        }

        if (args.length == 1) {
            String positionName = args[0];
                if(!positionList.contains(args[0])){
                    positionList.add(args[0]);
                    sender.sendMessage("§cArea succesfully setted");

                    World world = ((Player) sender).getWorld();

                    double x = ((Player) sender).getLocation().getX();
                    double y = ((Player) sender).getLocation().getY();
                    double z = ((Player) sender).getLocation().getZ();

                    Location location = new Location(world, x, y, z);

                    AreaConfig config = new AreaConfig();
                    config.getYaml().set(args[0] + ".name", args[0]);
                    config.getYaml().set(args[0] + ".world-name", world.getName());
                    config.getYaml().set(args[0] + ".getX", location.getX());
                    config.getYaml().set(args[0] + ".getY", location.getY());
                    config.getYaml().set(args[0] + ".getZ", location.getZ());
                    config.saveFile();

                }else {
                    sender.sendMessage("§cArea already exist");
                    return true;
                }

            }else {
                sender.sendMessage("§cError: use /areacontrol [area-name]");
                return true;
            }
        return false;
    }
}
