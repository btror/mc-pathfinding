package com.github.btror.mcpathfinding.simulation.pathfinding;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.Node;

public class GreedyBestFirstSearch extends Simulation {

    public GreedyBestFirstSearch() {
    }

    public GreedyBestFirstSearch(int[][][] simulationSnapshot, int[] simulationStart, int[] simulationTarget) {
        super(simulationSnapshot, simulationStart, simulationTarget);
    }

    @Override
    public void start() {
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

        nodeCurrent = new Node(
                simulationStart[0],
                simulationStart[1],
                simulationStart[2],
                4);
        nodeTarget = new Node(
                simulationTarget[0],
                simulationTarget[1],
                simulationTarget[2],
                5);
        nodeSnapshot[simulationStart[0]][simulationStart[1]][simulationStart[2]] = nodeCurrent;
        nodeSnapshot[simulationTarget[0]][simulationTarget[1]][simulationTarget[2]] = nodeTarget;

        int h = calculateH(nodeCurrent);
        nodeCurrent.setH(h);

        nodeCurrent.setBfsF();
        nodeStart = nodeCurrent;
        openList.add(nodeCurrent);
    }

    /*
     * Mappings:
     *
     * row = -front/+back
     * col = -left/+right
     * zNum = -bottom/+top
     *
     * z - 1 = bottom, z + 1 = top
     * c - 1 = left, c + 1 = right
     * r - 1 = front, r + 1 = back
     */
    @Override
    public void calculateNeighborValues() {
        int row = nodeCurrent.getRow();
        int col = nodeCurrent.getCol();
        int zNum = nodeCurrent.getZ();

        // bottom
        if (validateNeighbor(row, col, zNum - 1, false, true)) {
            nodeSnapshot[row][col][zNum - 1].setBfsF();
            openList.add(nodeSnapshot[row][col][zNum - 1]);
            simulationSnapshot[row][col][zNum - 1] = 2;
        }
        if (this.diagonalMovement) {
            // bottom right
            if (validateNeighbor(row, col + 1, zNum - 1, false, true)) {
                nodeSnapshot[row][col + 1][zNum - 1].setBfsF();
                openList.add(nodeSnapshot[row][col + 1][zNum - 1]);
                simulationSnapshot[row][col + 1][zNum - 1] = 2;
            }
            // bottom front-right
            if (validateNeighbor(row - 1, col + 1, zNum - 1, false, true)) {
                nodeSnapshot[row - 1][col + 1][zNum - 1].setBfsF();
                openList.add(nodeSnapshot[row - 1][col + 1][zNum - 1]);
                simulationSnapshot[row - 1][col + 1][zNum - 1] = 2;
            }
            // bottom front
            if (validateNeighbor(row - 1, col, zNum - 1, false, true)) {
                nodeSnapshot[row - 1][col][zNum - 1].setBfsF();
                openList.add(nodeSnapshot[row - 1][col][zNum - 1]);
                simulationSnapshot[row - 1][col][zNum - 1] = 2;
            }
            // bottom front-left
            if (validateNeighbor(row - 1, col - 1, zNum - 1, false, true)) {
                nodeSnapshot[row - 1][col - 1][zNum - 1].setBfsF();
                openList.add(nodeSnapshot[row - 1][col - 1][zNum - 1]);
                simulationSnapshot[row - 1][col - 1][zNum - 1] = 2;
            }
            // bottom left
            if (validateNeighbor(row, col - 1, zNum - 1, false, true)) {
                nodeSnapshot[row][col - 1][zNum - 1].setBfsF();
                openList.add(nodeSnapshot[row][col - 1][zNum - 1]);
                simulationSnapshot[row][col - 1][zNum - 1] = 2;
            }
            // bottom back-left
            if (validateNeighbor(row + 1, col - 1, zNum - 1, false, true)) {
                nodeSnapshot[row + 1][col - 1][zNum - 1].setBfsF();
                openList.add(nodeSnapshot[row + 1][col - 1][zNum - 1]);
                simulationSnapshot[row + 1][col - 1][zNum - 1] = 2;
            }
            // bottom back
            if (validateNeighbor(row + 1, col, zNum - 1, false, true)) {
                nodeSnapshot[row + 1][col][zNum - 1].setBfsF();
                openList.add(nodeSnapshot[row + 1][col][zNum - 1]);
                simulationSnapshot[row + 1][col][zNum - 1] = 2;
            }
            // bottom back-right
            if (validateNeighbor(row + 1, col + 1, zNum - 1, false, true)) {
                nodeSnapshot[row + 1][col + 1][zNum - 1].setBfsF();
                openList.add(nodeSnapshot[row + 1][col + 1][zNum - 1]);
                simulationSnapshot[row + 1][col + 1][zNum - 1] = 2;
            }
        }
        // middle right
        if (validateNeighbor(row, col + 1, zNum, false, true)) {
            nodeSnapshot[row][col + 1][zNum].setBfsF();
            openList.add(nodeSnapshot[row][col + 1][zNum]);
            simulationSnapshot[row][col + 1][zNum] = 2;
        }
        // middle front-right
        if (this.diagonalMovement && validateNeighbor(row - 1, col + 1, zNum, false, true)) {
            nodeSnapshot[row - 1][col + 1][zNum].setBfsF();
            openList.add(nodeSnapshot[row - 1][col + 1][zNum]);
            simulationSnapshot[row - 1][col + 1][zNum] = 2;
        }
        // middle front
        if (validateNeighbor(row - 1, col, zNum, false, true)) {
            nodeSnapshot[row - 1][col][zNum].setBfsF();
            openList.add(nodeSnapshot[row - 1][col][zNum]);
            simulationSnapshot[row - 1][col][zNum] = 2;
        }
        // middle front-left
        if (this.diagonalMovement && validateNeighbor(row - 1, col - 1, zNum, false, true)) {
            nodeSnapshot[row - 1][col - 1][zNum].setBfsF();
            openList.add(nodeSnapshot[row - 1][col - 1][zNum]);
            simulationSnapshot[row - 1][col - 1][zNum] = 2;
        }
        // middle left
        if (validateNeighbor(row, col - 1, zNum, false, true)) {
            nodeSnapshot[row][col - 1][zNum].setBfsF();
            openList.add(nodeSnapshot[row][col - 1][zNum]);
            simulationSnapshot[row][col - 1][zNum] = 2;
        }
        // middle back-left
        if (this.diagonalMovement && validateNeighbor(row + 1, col - 1, zNum, false, true)) {
            nodeSnapshot[row + 1][col - 1][zNum].setBfsF();
            openList.add(nodeSnapshot[row + 1][col - 1][zNum]);
            simulationSnapshot[row + 1][col - 1][zNum] = 2;
        }
        // middle back
        if (validateNeighbor(row + 1, col, zNum, false, true)) {
            nodeSnapshot[row + 1][col][zNum].setBfsF();
            openList.add(nodeSnapshot[row + 1][col][zNum]);
            simulationSnapshot[row + 1][col][zNum] = 2;
        }
        // middle back-right
        if (this.diagonalMovement && validateNeighbor(row + 1, col + 1, zNum, false, true)) {
            nodeSnapshot[row + 1][col + 1][zNum].setBfsF();
            openList.add(nodeSnapshot[row + 1][col + 1][zNum]);
            simulationSnapshot[row + 1][col + 1][zNum] = 2;
        }
        // top
        if (validateNeighbor(row, col, zNum + 1, false, true)) {
            nodeSnapshot[row][col][zNum + 1].setBfsF();
            openList.add(nodeSnapshot[row][col][zNum + 1]);
            simulationSnapshot[row][col][zNum + 1] = 2;
        }
        if (this.diagonalMovement) {
            // top right
            if (validateNeighbor(row, col + 1, zNum + 1, false, true)) {
                nodeSnapshot[row][col + 1][zNum + 1].setBfsF();
                openList.add(nodeSnapshot[row][col + 1][zNum + 1]);
                simulationSnapshot[row][col + 1][zNum + 1] = 2;
            }
            // top front-right
            if (validateNeighbor(row - 1, col + 1, zNum + 1, false, true)) {
                nodeSnapshot[row - 1][col + 1][zNum + 1].setBfsF();
                openList.add(nodeSnapshot[row - 1][col + 1][zNum + 1]);
                simulationSnapshot[row - 1][col + 1][zNum + 1] = 2;
            }
            // top front
            if (validateNeighbor(row - 1, col, zNum + 1, false, true)) {
                nodeSnapshot[row - 1][col][zNum + 1].setBfsF();
                openList.add(nodeSnapshot[row - 1][col][zNum + 1]);
                simulationSnapshot[row - 1][col][zNum + 1] = 2;
            }
            // top front-left
            if (validateNeighbor(row - 1, col - 1, zNum + 1, false, true)) {
                nodeSnapshot[row - 1][col - 1][zNum + 1].setBfsF();
                openList.add(nodeSnapshot[row - 1][col - 1][zNum + 1]);
                simulationSnapshot[row - 1][col - 1][zNum + 1] = 2;
            }
            // top left
            if (validateNeighbor(row, col - 1, zNum + 1, false, true)) {
                nodeSnapshot[row][col - 1][zNum + 1].setBfsF();
                openList.add(nodeSnapshot[row][col - 1][zNum + 1]);
                simulationSnapshot[row][col - 1][zNum + 1] = 2;
            }
            // top back-left
            if (validateNeighbor(row + 1, col - 1, zNum + 1, false, true)) {
                nodeSnapshot[row + 1][col - 1][zNum + 1].setBfsF();
                openList.add(nodeSnapshot[row + 1][col - 1][zNum + 1]);
                simulationSnapshot[row + 1][col - 1][zNum + 1] = 2;
            }
            // top back
            if (validateNeighbor(row + 1, col, zNum + 1, false, true)) {
                nodeSnapshot[row + 1][col][zNum + 1].setBfsF();
                openList.add(nodeSnapshot[row + 1][col][zNum + 1]);
                simulationSnapshot[row + 1][col][zNum + 1] = 2;
            }
            // top back-right
            if (validateNeighbor(row + 1, col + 1, zNum + 1, false, true)) {
                nodeSnapshot[row + 1][col + 1][zNum + 1].setBfsF();
                openList.add(nodeSnapshot[row + 1][col + 1][zNum + 1]);
                simulationSnapshot[row + 1][col + 1][zNum + 1] = 2;
            }
        }
    }
}
