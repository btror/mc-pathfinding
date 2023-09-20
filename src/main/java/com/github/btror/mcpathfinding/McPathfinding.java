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
                false,
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
                false,
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
                false,
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
                false,
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
                false,
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
            boolean tightParticleSpawning,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                tightParticleSpawning,
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
            boolean tightParticleSpawning,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
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
                false,
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
            boolean tightParticleSpawning,
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
                tightParticleSpawning,
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
            Particle particle,
            boolean tightParticleSpawning) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
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
            boolean tightParticleSpawning,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
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
            boolean tightParticleSpawning,
            boolean diagonalMovement,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
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
                false,
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
            Particle particle,
            boolean tightParticleSpawning) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                tightParticleSpawning,
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
            boolean tightParticleSpawning,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
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
                false,
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
            boolean tightParticleSpawning,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                tightParticleSpawning,
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
                false,
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
            boolean tightParticleSpawning,
            boolean diagonalMovement) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                tightParticleSpawning,
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
                false,
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
            boolean tightParticleSpawning,
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
                tightParticleSpawning,
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
            Particle particle,
            boolean tightParticleSpawning) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
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
            boolean tightParticleSpawning,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
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
            boolean tightParticleSpawning,
            boolean diagonalMovement,
            long delay,
            long period) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
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
            boolean tightParticleSpawning,
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
                tightParticleSpawning,
                algorithm,
                diagonalMovement,
                delay,
                period).start();
    }
}
