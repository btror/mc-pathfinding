package com.github.btror.mcpathfinding.simulation.pathfinding;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.Node;
import com.github.btror.mcpathfinding.simulation.util.NodeComparator;

import java.util.ArrayList;

public class BeamSearch extends Simulation {

    public BeamSearch() {
    }

    public BeamSearch(int[][][] simulationSnapshot, int[] simulationStart, int[] simulationTarget) {
        super(simulationSnapshot, simulationStart, simulationTarget);
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

        for (int i = 0; i < simulationSnapshot.length; i++) {
            for (int j = 0; j < simulationSnapshot[i].length; j++) {
                for (int k = 0; k < simulationSnapshot[i][j].length; k++) {
                    if (simulationSnapshot[i][j][k] == 0) {
                        Node node = new Node(i, j, k, 0);
                        nodeSnapshot[i][j][k] = node;
                    }
                    if (simulationSnapshot[i][j][k] == 1) {
                        Node node = new Node(i, j, k, 1);
                        nodeSnapshot[i][j][k] = node;
                    }
                }
            }
        }

        int h = calculateH(nodeCurrent);
        nodeCurrent.setH(h);

        nodeStart = nodeCurrent;
        openList.add(nodeCurrent);
    }

    @Override
    public void calculateNeighborValues() {
        int row = nodeCurrent.getRow();
        int col = nodeCurrent.getCol();
        int zNum = nodeCurrent.getZ();

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
                            int h = calculateH(neighbor);
                            if (h < neighbor.getH()) {
                                neighbor.setParent(nodeCurrent);
                                neighbor.setH(h);
                                openList.add(neighbor);
                                simulationSnapshot[newRow][newCol][newZ] = 2;
                            }
                        }
                    }
                }
            }
        }

        // Keep only the top beamWidth nodes in the open list
        ArrayList<Node> tempList = new ArrayList<>(openList);
        openList.clear();
        tempList.sort(new NodeComparator()); // Use your NodeComparator for sorting
        for (int i = 0; i < Math.min(beamWidth, tempList.size()); i++) {
            openList.add(tempList.get(i));
        }
    }
}
