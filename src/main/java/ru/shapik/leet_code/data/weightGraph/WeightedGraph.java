package ru.shapik.leet_code.data.weightGraph;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void pathPrint(WeightedNode node) {
        if (node.parent != node) {
            pathPrint(node.parent);
        }
        System.out.println(node.name + " ");
    }

    // Algorithm DIJkastra
    public void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbor : currentNode.neighbors) {
                 if (queue.contains(neighbor)) {
                     if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                         neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                         neighbor.parent = currentNode;
                         queue.add(neighbor);
                     }
                 }
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node " + nodeToCheck + " , distance: " + nodeToCheck.distance + " Parent: " + nodeToCheck.parent);
            pathPrint(nodeToCheck);
        }
        System.out.println();
    }

    public void addWeightedEdge(int i , int j, int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, d);
    }

    // Algorithm bellman Ford
    public void bellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            for (WeightedNode currentNode : nodeList) {
                for (WeightedNode neighbor : currentNode.neighbors) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
                        neighbor.parent = currentNode;
                    }
                }
            }
        }
        System.out.println("Checking for Negative Cycle..");
        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neighbor : currentNode.neighbors) {
                if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex name: " + neighbor.name);
                    System.out.println("Old cost: " + neighbor.distance);
                    int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);
                    System.out.println("New cost: " + newDistance);
                    return;
                }
            }
        }
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node " + nodeToCheck + " , distance: " + nodeToCheck.distance + " Parent: " + nodeToCheck.parent);
            pathPrint(nodeToCheck);
        }
        System.out.println();
    }

    // Floyd Warshall
    public void floydWarshall() {
        int size = nodeList.size();
        int[][] V = new int[size][size];
        for (int i = 0; i < size; i++) {
            WeightedNode first = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);
                if (i == j) {
                    V[i][j] = 0;
                } else if (first.weightMap.containsKey(second)) {
                    V[i][j] = first.weightMap.get(second);
                } else {
                    V[i][j] = Integer.MAX_VALUE/10;
                }
            }
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (V[i][j] > V[i][k] + V[k][j])
                    V[i][j] =  V[i][k] + V[k][j];
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print("Printinag distance list for node " + nodeList.get(i) + ":");
            for (int j = 0; j < size; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));

        WeightedGraph newGraph = new WeightedGraph(nodeList);
        newGraph.addWeightedEdge(0,1,2);
        newGraph.addWeightedEdge(0,2,5);
        newGraph.addWeightedEdge(1,2,6);
        newGraph.addWeightedEdge(1,3,1);
        newGraph.addWeightedEdge(1,4,3);
        newGraph.addWeightedEdge(2,5,8);
        newGraph.addWeightedEdge(2,4,4);
        newGraph.addWeightedEdge(4,6,9);
        newGraph.addWeightedEdge(5,6,7);
    }


}
