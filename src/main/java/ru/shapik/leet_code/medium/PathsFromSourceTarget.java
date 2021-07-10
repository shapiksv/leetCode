package ru.shapik.leet_code.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class PathsFromSourceTarget {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};

        PathsFromSourceTarget pathsFromSourceTarget = new PathsFromSourceTarget();
        pathsFromSourceTarget.allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int length = graph.length;

        NodeGraph[] arrayNode = new NodeGraph[length];
        NodeGraph firstNode;
        firstNode = new NodeGraph(0, graph[0].length);
        arrayNode[0] = firstNode;

        for (int i = 1; i < length; i++) {
            arrayNode[i] = new NodeGraph(i, graph[i].length);
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                NodeGraph nodeGraphs = arrayNode[i];
                nodeGraphs.arrayNodes[j] = arrayNode[graph[i][j]];
                System.out.println();
            }
        }
        Map<Integer, String> mapGraph = new HashMap<>();
        mapGraph.put(0, "");
        Integer stop = length - 1;
        bypass(firstNode, mapGraph, 0, stop);
        System.out.println(mapGraph.size());
        List<List<Integer>> request = new ArrayList<>();
        mapGraph.keySet().forEach(kay -> {
            String way = mapGraph.get(kay);
            if (way.contains(String.valueOf(stop))) {
                String[] chars = way.split(",");
                List<Integer> integerList = new ArrayList<>();
                for (int i = 0; i < chars.length; i++) {
                    integerList.add(Integer.parseInt(chars[i]));

                }
               request.add(integerList);
            }
        });

        return request;
    }

    private void bypass(NodeGraph currentNode, Map<Integer, String> mapGraph, Integer currentKey, Integer stop) {
        if (mapGraph.get(currentKey).contains(String.valueOf(currentNode.num)) || (!mapGraph.get(currentKey).isBlank() && currentNode.num == 0)) return;

        String value = mapGraph.get(currentKey);
        if (!mapGraph.get(currentKey).isBlank()) value = value.concat("," + currentNode.num);
        else value = value.concat("" + currentNode.num);

        if (currentNode.num.equals(stop)) {
            mapGraph.put(currentKey, value);
            return;
        }

        for (int i = 0; i < currentNode.arrayNodes.length; i++) {
            if (i == 0) {
                mapGraph.put(currentKey, value);
                bypass(currentNode.arrayNodes[i], mapGraph, currentKey, stop);
            } else {
                Integer newKey = mapGraph.size() + 1;
                mapGraph.put(newKey, value);
                bypass(currentNode.arrayNodes[i], mapGraph, newKey, stop);
            }
        }

    }

    class NodeGraph {
        Integer num;
        NodeGraph[] arrayNodes;

        NodeGraph(int num, int size) {
            this.num = num;
            this.arrayNodes = new NodeGraph[size];
        }
    }


}
