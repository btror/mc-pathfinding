package com.github.btror.mcpathfinding.simulation.util;

public class Node {
    private final int row;
    private final int col;
    private final int z;
    private int f;
    private int g = 0;
    private int h;
    private final int type;
    private Node parent;

    public Node(int r, int c, int z, int t) {
        this.row = r;
        this.col = c;
        this.z = z;
        this.type = t;
        this.parent = null;
    }

    public void setAStarSearchF() {
        f = g + h;
    }

    public void setBfsF() {
        f = h;
    }

    public void setBeamSearchF() {
        f = h;
    }

    public void setUcsF() {
        f = g;
    }

    public void setG(int value) {
        g = value;
    }

    public void setH(int value) {
        h = value;
    }

    public int getF() {
        return f;
    }

    public int getH() {
        return h;
    }

    public int getG() {
        return g;
    }

    public int getType() {
        return type;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node n) {
        parent = n;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getZ() {
        return z;
    }

    public boolean equals(Object in) {
        Node n = (Node) in;
        return row == n.getRow() && col == n.getCol() && z == n.getZ();
    }
}