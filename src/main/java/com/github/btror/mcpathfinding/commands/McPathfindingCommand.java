package com.github.btror.mcpathfinding.commands;

import com.github.btror.mcpathfinding.McPathfinding;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public record McPathfindingCommand(McPathfinding plugin) implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        try {
            Location[][][] snapshot = new Location[10][10][10];

            Location snapshotSpawnLocation = new Location(
                    player.getLocation().getWorld(),
                    player.getLocation().getX() + 3,
                    player.getLocation().getY(),
                    player.getLocation().getZ() + 3);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 10; k++) {
                        snapshot[i][j][k] = new Location(
                                snapshotSpawnLocation.getWorld(),
                                snapshotSpawnLocation.getX() + i,
                                snapshotSpawnLocation.getY() + j,
                                snapshotSpawnLocation.getZ() + k);
                    }
                }
            }

            Location snapshotStartLocation = snapshot[(int) (Math.random() * 9 + 0)][(int) (Math.random() * 9
                    + 0)][(int) (Math.random() * 9 + 0)];
            Location snapshotTargetLocation = snapshot[(int) (Math.random() * 9 + 0)][(int) (Math.random() * 9
                    + 0)][(int) (Math.random() * 9 + 0)];

            plugin.astar(snapshot, snapshotStartLocation, snapshotTargetLocation, 0, 10);

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "/mcpathfinding");
        }

        return false;
    }
}
