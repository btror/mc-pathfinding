package com.github.btror.mcpathfinding.simulation;

import com.github.btror.mcpathfinding.simulation.pathfinding.*;

public class SimulationFactory {

    public static Simulation getSimulation(String algorithm) {
        return switch (algorithm.toUpperCase()) {
            case "ASTAR", "A-STAR", "A*" -> new AStarSearch();
            case "BEAM", "BEAM SEARCH", "BEAM-SEARCH" -> new BeamSearch();
            case "GREEDY BEST FIRST SEARCH", "GREEDY-BEST-FIRST-SEARCH", "GREEDY BFS", "GREEDY-BFS", "GBFS" ->
                new GreedyBestFirstSearch();
            default -> null;
        };
    }
}
