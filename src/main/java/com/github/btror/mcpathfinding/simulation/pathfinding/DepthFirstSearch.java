package com.github.btror.mcpathfinding.simulation.pathfinding;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.Node;

import java.util.Stack;

public class DepthFirstSearch extends Simulation {

    private Stack<Node> stack;

    public DepthFirstSearch() {
        stack = new Stack<>();
    }

    public DepthFirstSearch(int[][][] simulationSnapshot, int[] simulationStart, int[] simulationTarget) {
        super(simulationSnapshot, simulationStart, simulationTarget);
        stack = new Stack<>();
    }

    @Override
    public void start() {
        nodeCurrent = new Node(
                simulationStart[0],
                simulationStart[1],
                simulationStart[2],
                0);
        nodeTarget = new Node(
                simulationTarget[0],
                simulationTarget[1],
                simulationTarget[2],
                0);
        nodeSnapshot[simulationStart[0]][simulationStart[1]][simulationStart[2]] = nodeCurrent;
        nodeSnapshot[simulationTarget[0]][simulationTarget[1]][simulationTarget[2]] = nodeTarget;

        stack.push(nodeCurrent);
    }

    @Override
    public void calculateNeighborValues() {
        if (stack.isEmpty()) {
            // If the stack is empty, the search is complete
            return;
        }

        Node currentNode = stack.pop();
        int row = currentNode.getRow();
        int col = currentNode.getCol();
        int zNum = currentNode.getZ();

        // Explore all neighbors (including diagonals if allowed)
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                for (int z = -1; z <= 1; z++) {
                    if (r == 0 && c == 0 && z == 0) continue; // Skip the current node

                    int newRow = row + r;
                    int newCol = col + c;
                    int newZ = zNum + z;

                    // Check if the neighbor is within bounds
                    if (isValid(newRow, newCol, newZ)) {
                        Node neighbor = nodeSnapshot[newRow][newCol][newZ];
                        if (neighbor.getType() == 0 && !closedList.contains(neighbor)) {
                            neighbor.setParent(currentNode);
                            stack.push(neighbor);
                            simulationSnapshot[newRow][newCol][newZ] = 2;
                        }
                    }
                }
            }
        }
    }
}
