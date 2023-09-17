package com.github.btror.mcpathfinding;

import com.github.btror.mcpathfinding.animation.Animation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
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

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                "astar",
                false,
                0,
                10);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                "astar",
                false,
                0,
                10);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                "astar",
                false,
                delay,
                period);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                "astar",
                false,
                delay,
                period);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                "astar",
                diagonalMovement,
                0,
                10);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                "astar",
                diagonalMovement,
                0,
                10);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                "astar",
                diagonalMovement,
                0,
                10);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            boolean diagonalMovement,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                "astar",
                diagonalMovement,
                delay,
                period);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            boolean diagonalMovement,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                "astar",
                diagonalMovement,
                delay,
                period);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                "astar",
                false,
                0,
                10);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                "astar",
                false,
                delay,
                period);
    }

    public static void astar(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            boolean diagonalMovement,
            int delay,
            int period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                "astar",
                diagonalMovement,
                delay,
                period);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                "gbfs",
                false,
                0,
                10);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                "gbfs",
                false,
                0,
                10);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                "gbfs",
                diagonalMovement,
                0,
                10);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                "gbfs",
                false,
                delay,
                period);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                "gbfs",
                false,
                delay,
                period);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                "gbfs",
                diagonalMovement,
                0,
                10);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                "gbfs",
                diagonalMovement,
                0,
                10);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            boolean diagonalMovement,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                "gbfs",
                diagonalMovement,
                delay,
                period);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            boolean diagonalMovement,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                "gbfs",
                diagonalMovement,
                delay,
                period);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                "gbfs",
                false,
                0,
                10);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                "gbfs",
                false,
                delay,
                period);
    }

    public static void greedyBestFirstSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            boolean diagonalMovement,
            int delay,
            int period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                "gbfs",
                diagonalMovement,
                delay,
                period);
    }

    public static void search(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            String algorithm,
            boolean diagonalMovement,
            long delay,
            long period) {
        new Animation(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                algorithm,
                diagonalMovement,
                delay,
                period).start();
    }
}
