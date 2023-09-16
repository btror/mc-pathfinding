package com.github.btror.mcpathfinding.simulation.pathfinding;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.Node;

public class AStar extends Simulation {

    public AStar() {
    }

    public AStar(int[][][] simulationSnapshot, int[] simulationStart, int[] simulationTarget) {
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

        int g = calculateG(nodeCurrent);
        nodeCurrent.setG(g);

        int h = calculateH(nodeCurrent);
        nodeCurrent.setH(h);

        nodeCurrent.setF();
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

        /*
         * bottom layer (z - 1)
         */

        // bottom
        if (zNum - 1 > -1 && nodeSnapshot[row][col][zNum - 1].getType() == 0
                && !closedList.contains(nodeSnapshot[row][col][zNum - 1])) {
            Node[][][] grid = nodeSnapshot;
            grid[row][col][zNum - 1].setParent(nodeCurrent);
            int g = calculateG(grid[row][col][zNum - 1]);
            grid[row][col][zNum - 1].setG(g);
            int h = calculateH(grid[row][col][zNum - 1]);
            grid[row][col][zNum - 1].setH(h);
            grid[row][col][zNum - 1].setF();
            nodeSnapshot = grid;
            openList.add(grid[row][col][zNum - 1]);
            simulationSnapshot[row][col][zNum - 1] = 2;
        }
        if (this.diagonalMovement) {
            // bottom right
            if (zNum - 1 > -1 && col + 1 < nodeSnapshot.length && nodeSnapshot[row][col + 1][zNum - 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row][col + 1][zNum - 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row][col + 1][zNum - 1].setParent(nodeCurrent);
                int g = calculateG(grid[row][col + 1][zNum - 1]);
                grid[row][col + 1][zNum - 1].setG(g);
                int h = calculateH(grid[row][col + 1][zNum - 1]);
                grid[row][col + 1][zNum - 1].setH(h);
                grid[row][col + 1][zNum - 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row][col + 1][zNum - 1]);
                simulationSnapshot[row][col + 1][zNum - 1] = 2;
            }
            // bottom front-right
            if (zNum - 1 > -1 && col + 1 < nodeSnapshot.length && row - 1 > -1
                    && nodeSnapshot[row - 1][col + 1][zNum - 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row - 1][col + 1][zNum - 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row - 1][col + 1][zNum - 1].setParent(nodeCurrent);
                int g = calculateG(grid[row - 1][col + 1][zNum - 1]);
                grid[row - 1][col + 1][zNum - 1].setG(g);
                int h = calculateH(grid[row - 1][col + 1][zNum - 1]);
                grid[row - 1][col + 1][zNum - 1].setH(h);
                grid[row - 1][col + 1][zNum - 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row - 1][col + 1][zNum - 1]);
                simulationSnapshot[row - 1][col + 1][zNum - 1] = 2;
            }
            // bottom front
            if (zNum - 1 > -1 && row - 1 > -1 && nodeSnapshot[row - 1][col][zNum - 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row - 1][col][zNum - 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row - 1][col][zNum - 1].setParent(nodeCurrent);
                int g = calculateG(grid[row - 1][col][zNum - 1]);
                grid[row - 1][col][zNum - 1].setG(g);
                int h = calculateH(grid[row - 1][col][zNum - 1]);
                grid[row - 1][col][zNum - 1].setH(h);
                grid[row - 1][col][zNum - 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row - 1][col][zNum - 1]);
                simulationSnapshot[row - 1][col][zNum - 1] = 2;
            }
            // bottom front-left
            if (zNum - 1 > -1 && col - 1 > -1 && row - 1 > -1 && nodeSnapshot[row - 1][col - 1][zNum - 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row - 1][col - 1][zNum - 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row - 1][col - 1][zNum - 1].setParent(nodeCurrent);
                int g = calculateG(grid[row - 1][col - 1][zNum - 1]);
                grid[row - 1][col - 1][zNum - 1].setG(g);
                int h = calculateH(grid[row - 1][col - 1][zNum - 1]);
                grid[row - 1][col - 1][zNum - 1].setH(h);
                grid[row - 1][col - 1][zNum - 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row - 1][col - 1][zNum - 1]);
                simulationSnapshot[row - 1][col - 1][zNum - 1] = 2;
            }
            // bottom left
            if (zNum - 1 > -1 && col - 1 > -1 && nodeSnapshot[row][col - 1][zNum - 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row][col - 1][zNum - 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row][col - 1][zNum - 1].setParent(nodeCurrent);
                int g = calculateG(grid[row][col - 1][zNum - 1]);
                grid[row][col - 1][zNum - 1].setG(g);
                int h = calculateH(grid[row][col - 1][zNum - 1]);
                grid[row][col - 1][zNum - 1].setH(h);
                grid[row][col - 1][zNum - 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row][col - 1][zNum - 1]);
                simulationSnapshot[row][col - 1][zNum - 1] = 2;
            }
            // bottom back-left
            if (zNum - 1 > -1 && col - 1 > -1 && row + 1 < nodeSnapshot.length
                    && nodeSnapshot[row + 1][col - 1][zNum - 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row + 1][col - 1][zNum - 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row + 1][col - 1][zNum - 1].setParent(nodeCurrent);
                int g = calculateG(grid[row + 1][col - 1][zNum - 1]);
                grid[row + 1][col - 1][zNum - 1].setG(g);
                int h = calculateH(grid[row + 1][col - 1][zNum - 1]);
                grid[row + 1][col - 1][zNum - 1].setH(h);
                grid[row + 1][col - 1][zNum - 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row + 1][col - 1][zNum - 1]);
                simulationSnapshot[row + 1][col - 1][zNum - 1] = 2;
            }
            // bottom back
            if (zNum - 1 > -1 && row + 1 < nodeSnapshot.length && nodeSnapshot[row + 1][col][zNum - 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row + 1][col][zNum - 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row + 1][col][zNum - 1].setParent(nodeCurrent);
                int g = calculateG(grid[row + 1][col][zNum - 1]);
                grid[row + 1][col][zNum - 1].setG(g);
                int h = calculateH(grid[row + 1][col][zNum - 1]);
                grid[row + 1][col][zNum - 1].setH(h);
                grid[row + 1][col][zNum - 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row + 1][col][zNum - 1]);
                simulationSnapshot[row + 1][col][zNum - 1] = 2;
            }
            // bottom back-right
            if (zNum - 1 > -1 && col + 1 < nodeSnapshot.length && row + 1 < nodeSnapshot.length
                    && nodeSnapshot[row + 1][col + 1][zNum - 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row + 1][col + 1][zNum - 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row + 1][col + 1][zNum - 1].setParent(nodeCurrent);
                int g = calculateG(grid[row + 1][col + 1][zNum - 1]);
                grid[row + 1][col + 1][zNum - 1].setG(g);
                int h = calculateH(grid[row + 1][col + 1][zNum - 1]);
                grid[row + 1][col + 1][zNum - 1].setH(h);
                grid[row + 1][col + 1][zNum - 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row + 1][col + 1][zNum - 1]);
                simulationSnapshot[row + 1][col + 1][zNum - 1] = 2;
            }
        }

        /*
         * middle layer (z - 1)
         */

        // middle right
        if (col + 1 < nodeSnapshot.length && nodeSnapshot[row][col + 1][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row][col + 1][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row][col + 1][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row][col + 1][zNum]);
            grid[row][col + 1][zNum].setG(g);
            int h = calculateH(grid[row][col + 1][zNum]);
            grid[row][col + 1][zNum].setH(h);
            grid[row][col + 1][zNum].setF();
            nodeSnapshot = grid;
            openList.add(grid[row][col + 1][zNum]);
            simulationSnapshot[row][col + 1][zNum] = 2;
        }
        // middle front-right
        if (this.diagonalMovement && col + 1 < nodeSnapshot.length && row - 1 > -1
                && nodeSnapshot[row - 1][col + 1][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row - 1][col + 1][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row - 1][col + 1][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row - 1][col + 1][zNum]);
            grid[row - 1][col + 1][zNum].setG(g);
            int h = calculateH(grid[row - 1][col + 1][zNum]);
            grid[row - 1][col + 1][zNum].setH(h);
            grid[row - 1][col + 1][zNum].setF();
            nodeSnapshot = grid;
            openList.add(grid[row - 1][col + 1][zNum]);
            simulationSnapshot[row - 1][col + 1][zNum] = 2;
        }
        // middle front
        if (row - 1 > -1 && nodeSnapshot[row - 1][col][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row - 1][col][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row - 1][col][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row - 1][col][zNum]);
            grid[row - 1][col][zNum].setG(g);
            int h = calculateH(grid[row - 1][col][zNum]);
            grid[row - 1][col][zNum].setH(h);
            grid[row - 1][col][zNum].setF();
            nodeSnapshot = grid;
            openList.add(grid[row - 1][col][zNum]);
            simulationSnapshot[row - 1][col][zNum] = 2;
        }
        // middle front-left
        if (this.diagonalMovement && col - 1 > -1 && row - 1 > -1 && nodeSnapshot[row - 1][col - 1][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row - 1][col - 1][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row - 1][col - 1][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row - 1][col - 1][zNum]);
            grid[row - 1][col - 1][zNum].setG(g);
            int h = calculateH(grid[row - 1][col - 1][zNum]);
            grid[row - 1][col - 1][zNum].setH(h);
            grid[row - 1][col - 1][zNum].setF();
            nodeSnapshot = grid;
            openList.add(grid[row - 1][col - 1][zNum]);
            simulationSnapshot[row - 1][col - 1][zNum] = 2;
        }
        // middle left
        if (col - 1 > -1 && nodeSnapshot[row][col - 1][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row][col - 1][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row][col - 1][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row][col - 1][zNum]);
            grid[row][col - 1][zNum].setG(g);
            int h = calculateH(grid[row][col - 1][zNum]);
            grid[row][col - 1][zNum].setH(h);
            grid[row][col - 1][zNum].setF();
            nodeSnapshot = grid;
            openList.add(grid[row][col - 1][zNum]);
            simulationSnapshot[row][col - 1][zNum] = 2;
        }
        // middle back-left
        if (this.diagonalMovement && col - 1 > -1 && row + 1 < nodeSnapshot.length
                && nodeSnapshot[row + 1][col - 1][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row + 1][col - 1][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row + 1][col - 1][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row + 1][col - 1][zNum]);
            grid[row + 1][col - 1][zNum].setG(g);
            int h = calculateH(grid[row + 1][col - 1][zNum]);
            grid[row + 1][col - 1][zNum].setH(h);
            grid[row + 1][col - 1][zNum].setF();
            nodeSnapshot = grid;
            openList.add(grid[row + 1][col - 1][zNum]);
            simulationSnapshot[row + 1][col - 1][zNum] = 2;
        }
        // middle back
        if (row + 1 < nodeSnapshot.length && nodeSnapshot[row + 1][col][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row + 1][col][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row + 1][col][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row + 1][col][zNum]);
            grid[row + 1][col][zNum].setG(g);
            int h = calculateH(grid[row + 1][col][zNum]);
            grid[row + 1][col][zNum].setH(h);
            grid[row + 1][col][zNum].setF();
            nodeSnapshot = grid;
            openList.add(grid[row + 1][col][zNum]);
            simulationSnapshot[row + 1][col][zNum] = 2;
        }
        // middle back-right
        if (this.diagonalMovement && col + 1 < nodeSnapshot.length && row + 1 < nodeSnapshot.length
                && nodeSnapshot[row + 1][col + 1][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row + 1][col + 1][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row + 1][col + 1][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row + 1][col + 1][zNum]);
            grid[row + 1][col + 1][zNum].setG(g);
            int h = calculateH(grid[row + 1][col + 1][zNum]);
            grid[row + 1][col + 1][zNum].setH(h);
            grid[row + 1][col + 1][zNum].setF();
            nodeSnapshot = grid;
            openList.add(grid[row + 1][col + 1][zNum]);
            simulationSnapshot[row + 1][col + 1][zNum] = 2;
        }

        /*
         * top layer (z + 1)
         */

        // top
        if (zNum + 1 < nodeSnapshot.length && nodeSnapshot[row][col][zNum + 1].getType() == 0
                && !closedList.contains(nodeSnapshot[row][col][zNum + 1])) {
            Node[][][] grid = nodeSnapshot;
            grid[row][col][zNum + 1].setParent(nodeCurrent);
            int g = calculateG(grid[row][col][zNum + 1]);
            grid[row][col][zNum + 1].setG(g);
            int h = calculateH(grid[row][col][zNum + 1]);
            grid[row][col][zNum + 1].setH(h);
            grid[row][col][zNum + 1].setF();
            nodeSnapshot = grid;
            openList.add(grid[row][col][zNum + 1]);
            simulationSnapshot[row][col][zNum + 1] = 2;
        }
        if (this.diagonalMovement) {
            // top right
            if (zNum + 1 < nodeSnapshot.length && col + 1 < nodeSnapshot.length
                    && nodeSnapshot[row][col + 1][zNum + 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row][col + 1][zNum + 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row][col + 1][zNum + 1].setParent(nodeCurrent);
                int g = calculateG(grid[row][col + 1][zNum + 1]);
                grid[row][col + 1][zNum + 1].setG(g);
                int h = calculateH(grid[row][col + 1][zNum + 1]);
                grid[row][col + 1][zNum + 1].setH(h);
                grid[row][col + 1][zNum + 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row][col + 1][zNum + 1]);
                simulationSnapshot[row][col + 1][zNum + 1] = 2;
            }
            // top front-right
            if (zNum + 1 < nodeSnapshot.length && col + 1 < nodeSnapshot.length && row - 1 > -1
                    && nodeSnapshot[row - 1][col + 1][zNum + 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row - 1][col + 1][zNum + 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row - 1][col + 1][zNum + 1].setParent(nodeCurrent);
                int g = calculateG(grid[row - 1][col + 1][zNum + 1]);
                grid[row - 1][col + 1][zNum + 1].setG(g);
                int h = calculateH(grid[row - 1][col + 1][zNum + 1]);
                grid[row - 1][col + 1][zNum + 1].setH(h);
                grid[row - 1][col + 1][zNum + 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row - 1][col + 1][zNum + 1]);
                simulationSnapshot[row - 1][col + 1][zNum + 1] = 2;
            }
            // top front
            if (zNum + 1 < nodeSnapshot.length && row - 1 > -1 && nodeSnapshot[row - 1][col][zNum + 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row - 1][col][zNum + 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row - 1][col][zNum + 1].setParent(nodeCurrent);
                int g = calculateG(grid[row - 1][col][zNum + 1]);
                grid[row - 1][col][zNum + 1].setG(g);
                int h = calculateH(grid[row - 1][col][zNum + 1]);
                grid[row - 1][col][zNum + 1].setH(h);
                grid[row - 1][col][zNum + 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row - 1][col][zNum + 1]);
                simulationSnapshot[row - 1][col][zNum + 1] = 2;
            }
            // top front-left
            if (zNum + 1 < nodeSnapshot.length && col - 1 > -1 && row - 1 > -1
                    && nodeSnapshot[row - 1][col - 1][zNum + 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row - 1][col - 1][zNum + 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row - 1][col - 1][zNum + 1].setParent(nodeCurrent);
                int g = calculateG(grid[row - 1][col - 1][zNum + 1]);
                grid[row - 1][col - 1][zNum + 1].setG(g);
                int h = calculateH(grid[row - 1][col - 1][zNum + 1]);
                grid[row - 1][col - 1][zNum + 1].setH(h);
                grid[row - 1][col - 1][zNum + 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row - 1][col - 1][zNum + 1]);
                simulationSnapshot[row - 1][col - 1][zNum + 1] = 2;
            }
            // top left
            if (zNum + 1 < nodeSnapshot.length && col - 1 > -1 && nodeSnapshot[row][col - 1][zNum + 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row][col - 1][zNum + 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row][col - 1][zNum + 1].setParent(nodeCurrent);
                int g = calculateG(grid[row][col - 1][zNum + 1]);
                grid[row][col - 1][zNum + 1].setG(g);
                int h = calculateH(grid[row][col - 1][zNum + 1]);
                grid[row][col - 1][zNum + 1].setH(h);
                grid[row][col - 1][zNum + 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row][col - 1][zNum + 1]);
                simulationSnapshot[row][col - 1][zNum + 1] = 2;
            }
            // top back-left
            if (zNum + 1 < nodeSnapshot.length && col - 1 > -1 && row + 1 < nodeSnapshot.length
                    && nodeSnapshot[row + 1][col - 1][zNum + 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row + 1][col - 1][zNum + 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row + 1][col - 1][zNum + 1].setParent(nodeCurrent);
                int g = calculateG(grid[row + 1][col - 1][zNum + 1]);
                grid[row + 1][col - 1][zNum + 1].setG(g);
                int h = calculateH(grid[row + 1][col - 1][zNum + 1]);
                grid[row + 1][col - 1][zNum + 1].setH(h);
                grid[row + 1][col - 1][zNum + 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row + 1][col - 1][zNum + 1]);
                simulationSnapshot[row + 1][col - 1][zNum + 1] = 2;
            }
            // top back
            if (zNum + 1 < nodeSnapshot.length && row + 1 < nodeSnapshot.length
                    && nodeSnapshot[row + 1][col][zNum + 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row + 1][col][zNum + 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row + 1][col][zNum + 1].setParent(nodeCurrent);
                int g = calculateG(grid[row + 1][col][zNum + 1]);
                grid[row + 1][col][zNum + 1].setG(g);
                int h = calculateH(grid[row + 1][col][zNum + 1]);
                grid[row + 1][col][zNum + 1].setH(h);
                grid[row + 1][col][zNum + 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row + 1][col][zNum + 1]);
                simulationSnapshot[row + 1][col][zNum + 1] = 2;
            }
            // top back-right
            if (zNum + 1 < nodeSnapshot.length && col + 1 < nodeSnapshot.length && row + 1 < nodeSnapshot.length
                    && nodeSnapshot[row + 1][col + 1][zNum + 1].getType() == 0
                    && !closedList.contains(nodeSnapshot[row + 1][col + 1][zNum + 1])) {
                Node[][][] grid = nodeSnapshot;
                grid[row + 1][col + 1][zNum + 1].setParent(nodeCurrent);
                int g = calculateG(grid[row + 1][col + 1][zNum + 1]);
                grid[row + 1][col + 1][zNum + 1].setG(g);
                int h = calculateH(grid[row + 1][col + 1][zNum + 1]);
                grid[row + 1][col + 1][zNum + 1].setH(h);
                grid[row + 1][col + 1][zNum + 1].setF();
                nodeSnapshot = grid;
                openList.add(grid[row + 1][col + 1][zNum + 1]);
                simulationSnapshot[row + 1][col + 1][zNum + 1] = 2;
            }
        }
    }
}
