package ru.shapik.leet_code.data.Graph.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> graphNodes = new ArrayList<>();
    int[][] adjacencyMatrix;


    public Graph (ArrayList<GraphNode> graphNodes) {
        this.graphNodes = graphNodes;
        this.adjacencyMatrix = new int[graphNodes.size()][graphNodes.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    private ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        for (int i = 1; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[node.index][i] == 1) {
                neighbors.add(graphNodes.get(i));
            }
        }
        return neighbors;
    }

    public void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            System.out.println(currentNode.name);
            currentNode.isVisited = true;
            getNeighbors(currentNode).forEach(neighbor -> {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            });
        }
    }

    public void bfs() {
        for(GraphNode node: graphNodes) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    public void depthVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            System.out.println(currentNode.name);
            currentNode.isVisited = true;
            getNeighbors(currentNode).forEach(neighbor -> {
                if (!neighbor.isVisited) {
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            });
        }
    }

    public void depthVisit() {
        for(GraphNode node: graphNodes) {
            if (!node.isVisited) {
                depthVisit(node);
            }
        }
    }

    public void addDirectedEdge(int from, int to) {
        adjacencyMatrix[from][to] = 1;
    }

    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : getNeighbors(node)) {
            if (!neighbor.isVisited) {
                topologicalVisit(neighbor, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : graphNodes) {
            if (!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(new GraphNode("A", 0));
        graphNodes.add(new GraphNode("B", 1));
        graphNodes.add(new GraphNode("C", 2));
        graphNodes.add(new GraphNode("D", 3));
        graphNodes.add(new GraphNode("E", 4));
        graphNodes.add(new GraphNode("F", 5));
        graphNodes.add(new GraphNode("G", 6));
        graphNodes.add(new GraphNode("H", 7));

        Graph graph = new Graph(graphNodes);

//        graph.addUndirectedEdge(0, 1);
//        graph.addUndirectedEdge(0, 3);
//        graph.addUndirectedEdge(0, 2);
//        graph.addUndirectedEdge(2, 3);
//        graph.addUndirectedEdge(3, 4);
//        graph.addUndirectedEdge(1, 4);
//        graph.bfs();
//        graph.graphNodes.forEach(node -> node.isVisited = false);
//        System.out.println();
//        graph.depthVisit();

        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(4, 7);
        graph.addDirectedEdge(4, 5);
        graph.addDirectedEdge(5, 6);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(3, 5);
//        System.out.println(graph.toString());

        graph.topologicalSort();

    }
}
