package ru.shapik.leet_code.data.weightGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public Prims(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }
    public void addWeightUndirectedEdge (int firstIndex, int secondIndex, int weight) {
        WeightedNode first = nodeList.get(firstIndex);
        WeightedNode second = nodeList.get(secondIndex);
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
    }

    public void prims(WeightedNode node) {
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).distance = Integer.MAX_VALUE;
        }

        node.distance = 0;
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbor : currentNode.neighbors) {
                if (queue.contains(neighbor) && neighbor.distance> currentNode.weightMap.get(neighbor)) {
                    neighbor.distance = currentNode.weightMap.get(neighbor);
                    neighbor.parent = currentNode;
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        int cost = 0;
        for ( WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node: " + nodeToCheck + " , kay: " + nodeToCheck.distance + " , Parent: " + nodeToCheck.parent);
            cost += nodeToCheck.distance;
        }
        System.out.println("Total cost: " + cost);
    }
}
