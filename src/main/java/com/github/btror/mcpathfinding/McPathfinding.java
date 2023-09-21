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

    public static void astarSearch(
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
                10,
                0);
    }

    public static void astarSearch(
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
                10,
                0);
    }

    public static void astarSearch(
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
                period,
                0);
    }

    public static void astarSearch(
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
                period,
                0);
    }

    public static void astarSearch(
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
                10,
                0);
    }

    public static void astarSearch(
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
                10,
                0);
    }

    public static void astarSearch(
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
                10,
                0);
    }

    public static void astarSearch(
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
                period,
                0);
    }

    public static void astarSearch(
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
                period,
                0);
    }

    public static void astarSearch(
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
                10,
                0);
    }

    public static void astarSearch(
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
                period,
                0);
    }

    public static void astarSearch(
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
                period,
                0);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                false,
                "beam",
                false,
                0,
                10,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                false,
                "beam",
                false,
                0,
                10,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            long delay,
            long period,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                false,
                "beam",
                false,
                delay,
                period,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            long delay,
            long period,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                false,
                "beam",
                false,
                delay,
                period,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            boolean diagonalMovement,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                false,
                "beam",
                diagonalMovement,
                0,
                10,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            boolean tightParticleSpawning,
            boolean diagonalMovement,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                tightParticleSpawning,
                "beam",
                diagonalMovement,
                0,
                10,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            boolean tightParticleSpawning,
            boolean diagonalMovement,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
                "beam",
                diagonalMovement,
                0,
                10,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            boolean diagonalMovement,
            long delay,
            long period,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                null,
                false,
                "beam",
                diagonalMovement,
                delay,
                period,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Particle particle,
            boolean tightParticleSpawning,
            boolean diagonalMovement,
            long delay,
            long period,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                null,
                particle,
                tightParticleSpawning,
                "beam",
                diagonalMovement,
                delay,
                period,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            boolean tightParticleSpawning,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
                "beam",
                false,
                0,
                10,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            boolean tightParticleSpawning,
            long delay,
            long period,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
                "beam",
                false,
                delay,
                period,
                beamWidth);
    }

    public static void beamSearch(
            JavaPlugin plugin,
            Location[][][] snapshot,
            Location startLocation,
            Location targetLocation,
            Material material,
            Particle particle,
            boolean tightParticleSpawning,
            boolean diagonalMovement,
            long delay,
            long period,
            int beamWidth) {
        search(
                plugin,
                snapshot,
                startLocation,
                targetLocation,
                material,
                particle,
                tightParticleSpawning,
                "beam",
                diagonalMovement,
                delay,
                period,
                beamWidth);
    }


    public static void breadthFirstSearch(
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
                "bfs",
                false,
                0,
                10,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                false,
                0,
                10,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                false,
                delay,
                period,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                false,
                delay,
                period,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                diagonalMovement,
                delay,
                period,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                diagonalMovement,
                delay,
                period,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                false,
                0,
                10,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                false,
                delay,
                period,
                0);
    }

    public static void breadthFirstSearch(
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
                "bfs",
                diagonalMovement,
                delay,
                period,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                false,
                0,
                10,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                false,
                0,
                10,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                false,
                delay,
                period,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                false,
                delay,
                period,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                diagonalMovement,
                delay,
                period,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                diagonalMovement,
                delay,
                period,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                false,
                0,
                10,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                false,
                delay,
                period,
                0);
    }

    public static void depthFirstSearch(
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
                "dfs",
                diagonalMovement,
                delay,
                period,
                0);
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
                10,
                0);
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
                10,
                0);
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
                10,
                0);
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
                period,
                0);
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
                period,
                0);
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
                10,
                0);
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
                10,
                0);
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
                period,
                0);
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
                period,
                0);
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
                10,
                0);
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
                period,
                0);
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
                period,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                false,
                0,
                10,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                false,
                0,
                10,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                false,
                delay,
                period,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                false,
                delay,
                period,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                diagonalMovement,
                0,
                10,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                diagonalMovement,
                delay,
                period,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                diagonalMovement,
                delay,
                period,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                false,
                0,
                10,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                false,
                delay,
                period,
                0);
    }

    public static void uniformCostSearch(
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
                "ucs",
                diagonalMovement,
                delay,
                period,
                0);
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
            long period,
            int beamWidth) {
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
                period,
                beamWidth).start();
    }
}
