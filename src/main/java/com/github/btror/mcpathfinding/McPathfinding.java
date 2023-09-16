package com.github.btror.mcpathfinding;

import com.github.btror.mcpathfinding.animation.Animation;
import com.github.btror.mcpathfinding.commands.McPathfindingCommand;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class McPathfinding extends JavaPlugin {

        @Override
        public void onEnable() {
                getLogger().info("mc-pathfinding enabled...");

                McPathfindingCommand command = new McPathfindingCommand(this);
                Objects.requireNonNull(getCommand("mcpathfinding")).setExecutor(command);
                getServer().getPluginManager().registerEvents(command, this);
        }

        @Override
        public void onDisable() {
                getLogger().info("mc-pathfinding disabled...");
        }

        public void astar(
                        Location[][][] snapshot,
                        Location startLocation,
                        Location targetLocation) {
                astar(
                                snapshot,
                                startLocation,
                                targetLocation,
                                0,
                                1);
        }

        public void astar(
                        Location[][][] snapshot,
                        Location startLocation,
                        Location targetLocation,
                        long delay,
                        long period) {
                new Animation(
                                this,
                                snapshot,
                                startLocation,
                                targetLocation,
                                "astar",
                                false,
                                delay,
                                period).start();
        }

        public void astar(
                        Location[][][] snapshot,
                        Location startLocation,
                        Location targetLocation,
                        boolean diagonalMovement) {
                astar(
                                snapshot,
                                startLocation,
                                targetLocation,
                                diagonalMovement,
                                0,
                                1);
        }

        public void astar(
                        Location[][][] snapshot,
                        Location startLocation,
                        Location targetLocation,
                        boolean diagonalMovement,
                        long delay,
                        long period) {
                new Animation(
                                this,
                                snapshot,
                                startLocation,
                                targetLocation,
                                "astar",
                                diagonalMovement,
                                delay,
                                period).start();
        }

        public void greedyBestFirstSearch(
                        Location[][][] snapshot,
                        Location startLocation,
                        Location targetLocation) {
                greedyBestFirstSearch(
                                snapshot,
                                startLocation,
                                targetLocation,
                                0,
                                1);
        }

        public void greedyBestFirstSearch(
                        Location[][][] snapshot,
                        Location startLocation,
                        Location targetLocation,
                        long delay,
                        long period) {
                new Animation(
                                this,
                                snapshot,
                                startLocation,
                                targetLocation,
                                "gbfs",
                                false,
                                delay,
                                period).start();
        }

        public void greedyBestFirstSearch(
                        Location[][][] snapshot,
                        Location startLocation,
                        Location targetLocation,
                        boolean diagonalMovement) {
                new Animation(
                                this,
                                snapshot,
                                startLocation,
                                targetLocation,
                                "gbfs",
                                diagonalMovement,
                                0,
                                1).start();
        }

        public void greedyBestFirstSearch(
                        Location[][][] snapshot,
                        Location startLocation,
                        Location targetLocation,
                        boolean diagonalMovement,
                        long delay,
                        long period) {
                new Animation(
                                this,
                                snapshot,
                                startLocation,
                                targetLocation,
                                "gbfs",
                                diagonalMovement,
                                delay,
                                period).start();
        }
}
