package ru.shapik.leet_code.data.Graph.list;

import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;
    public ArrayList<GraphNode> neighbors;
    public GraphNode parent;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        neighbors = new ArrayList<>();
    }
}
