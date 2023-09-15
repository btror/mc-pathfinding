package com.github.btror.mcpathfinding;

import com.github.btror.mcpathfinding.animation.Animation;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class McPathfinding extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("mc-pathfinding enabled...");
    }

    @Override
    public void onDisable() {
        getLogger().info("mc-pathfinding disabled...");
    }

    public void astar(Location[][][] snapshot, Location startLocation, Location targetLocation) {
        new Animation(this, snapshot, startLocation, targetLocation, "astar").start();
    }

    public void greedyBestFirstSearch(Location[][][] snapshot, Location startLocation, Location targetLocation) {
        new Animation(this, snapshot, startLocation, targetLocation, "gbfs").start();
    }
}
