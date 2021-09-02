package ru.shapik.leet_code.data.weightGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    public Kruskal(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightUndirectedEdge (int firstIndex, int secondIndex, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        WeightedNode first = edge.first;;
        WeightedNode second = edge.second;
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    public void kruskal() {
        DisjointSet.makeSet(nodeList);
        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
            @Override
            public int compare(UndirectedEdge o1, UndirectedEdge o2) {
                return o1.weight - o2.weight;
            }
        };

        Collections.sort(edgeList, comparator);
        int cost = 0;

        for (UndirectedEdge edge : edgeList) {
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;

            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
                DisjointSet.union(first, second);
                cost += edge.weight;
                System.out.println("Taken " + edge);
            }
        }

        System.out.println("\n Total cost of MST: " + cost);
    }

    public static void main(String[] args) {
        ArrayList<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A", 0));
        nodes.add(new WeightedNode("B", 1));
        nodes.add(new WeightedNode("C", 2));
        nodes.add(new WeightedNode("D", 3));
        nodes.add(new WeightedNode("E", 4));

        Kruskal kruskal = new Kruskal(nodes);
        kruskal.addWeightUndirectedEdge(0,1,5);
        kruskal.addWeightUndirectedEdge(0,2,13);
        kruskal.addWeightUndirectedEdge(0,4,15);
        kruskal.addWeightUndirectedEdge(1,2,10);
        kruskal.addWeightUndirectedEdge(1,3,9);
        kruskal.addWeightUndirectedEdge(2,3,6);
        kruskal.addWeightUndirectedEdge(2,4,20);

        System.out.println("RUNNING ALGORITM");
        kruskal.kruskal();
    }


}
