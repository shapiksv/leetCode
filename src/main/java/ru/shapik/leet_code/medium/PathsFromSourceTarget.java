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

        Map<Integer, String> mapGraph = new HashMap<>();
        mapGraph.put(0, "");

        Integer stop = graph.length - 1;
        bypass(graph, 0, mapGraph, 0, stop);

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

    private void bypass(int[][] graph, Integer position, Map<Integer, String> mapGraph, Integer currentKey, Integer stop) {
        if (mapGraph.get(currentKey).contains(String.valueOf(position)) || (!mapGraph.get(currentKey).isBlank() && position == 0)) return;

        String value = mapGraph.get(currentKey);
        if (!mapGraph.get(currentKey).isBlank()) value = value.concat("," + position);
        else value = value.concat("" + position);

        if (position.equals(stop)) {
            mapGraph.put(currentKey, value);
            return;
        }

        for (int i = 0; i < graph[position].length; i++) {
            if (i == 0) {
                mapGraph.put(currentKey, value);
                bypass(graph, graph[position][i], mapGraph, currentKey, stop);
            } else {
                Integer newKey = mapGraph.size() + 1;
                mapGraph.put(newKey, value);
                bypass(graph, graph[position][i], mapGraph, newKey, stop);
            }
        }

    }
}
