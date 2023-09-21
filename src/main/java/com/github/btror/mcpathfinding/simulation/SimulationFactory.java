package com.github.btror.mcpathfinding.simulation;

import com.github.btror.mcpathfinding.simulation.pathfinding.*;

public class SimulationFactory {

    public static Simulation getSimulation(String algorithm) {
        return switch (algorithm.toUpperCase()) {
            case "ASTAR", "A-STAR", "A*" -> new AStarSearch();
            case "BEAM", "BEAM SEARCH", "BEAM-SEARCH" -> new BeamSearch();
            case "BREADTH FIRST SEARCH", "BREADTH-FIRST SEARCH", "BREADTH-FIRST-SEARCH", "BFS" -> new BreadthFirstSearch();
            case "DEPTH FIRST SEARCH", "DEPTH-FIRST SEARCH", "DEPTH-FIRST-SEARCH", "DFS" -> new DepthFirstSearch();
            case "DIJKSTRA" -> new DijkstraSearch();
            case "GREEDY BEST FIRST SEARCH", "GREEDY-BEST-FIRST-SEARCH", "GREEDY BFS", "GREEDY-BFS", "GBFS" -> new GreedyBestFirstSearch();
            case "UNIFORM COST SEARCH", "UNIFORM-COST SEARCH", "UNIFORM-COST-SEARCH", "UNIFORM-CS", "UCS" -> new UniformCostSearch();
            default -> null;
        };
    }
}
