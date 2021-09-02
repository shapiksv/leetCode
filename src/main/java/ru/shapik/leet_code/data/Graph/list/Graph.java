package ru.shapik.leet_code.data.Graph.list;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> graphNodes;

    public Graph(ArrayList<GraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = graphNodes.get(i);
        GraphNode second = graphNodes.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            System.out.println(currentNode.name);
            currentNode.isVisited = true;
            node.neighbors.forEach(neighbor -> {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            });
        }
    }

    public void bfs() {
        for (GraphNode node : graphNodes) {
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
            for (GraphNode neighbor: currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    neighbor.isVisited = true;
                    stack.push(neighbor);
                }
            }
        }
    }

    public void depthVisit() {
        for (GraphNode node: graphNodes) {
            if (!node.isVisited) {
                depthVisit(node);
            }
        }
    }

    public void addDirectedEdge(int from, int to) {
        graphNodes.get(from).neighbors.add(graphNodes.get(to));
    }

    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : node.neighbors) {
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

    public void clearVisited() {
        graphNodes.forEach(node -> node.isVisited = false);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < graphNodes.size(); i++) {
            s.append(graphNodes.get(i).name + ": ");
            for (int j =0; j < graphNodes.get(i).neighbors.size(); j++) {
                if (j == graphNodes.get(i).neighbors.size()-1 ) {
                    s.append((graphNodes.get(i).neighbors.get(j).name) );
                } else {
                    s.append((graphNodes.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void pathPrint(GraphNode node) {
        if (node.parent != node) {
            pathPrint(node.parent);
        }
        System.out.println(node.name + " ");
    }

    public void BFSForSSSPP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            System.out.println(currentNode.name);
            currentNode.isVisited = true;
            System.out.println("Printing path for node " + currentNode.name);
            pathPrint(node);
            System.out.println();
            node.neighbors.forEach(neighbor -> {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            });
        }
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(new GraphNode("A", 0));
        graphNodes.add(new GraphNode("B", 1));
        graphNodes.add(new GraphNode("C", 2));
        graphNodes.add(new GraphNode("D", 3));
        graphNodes.add(new GraphNode("E", 4));

        Graph graph = new Graph(graphNodes);

        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);
        graph.addUndirectedEdge(1, 4);
//        graph.bfs();
//        graph.clearVisited();
//        System.out.println();
//        graph.depthVisit();
//        graph.clearVisited();
        graph.BFSForSSSPP(graph.graphNodes.get(0));

//        graphNodes.add(new GraphNode("F", 5));
//        graphNodes.add(new GraphNode("G", 6));
//        graphNodes.add(new GraphNode("H", 7));
//        graph.addDirectedEdge(0, 2);
//        graph.addDirectedEdge(2, 4);
//        graph.addDirectedEdge(4, 7);
//        graph.addDirectedEdge(4, 5);
//        graph.addDirectedEdge(5, 6);
//        graph.addDirectedEdge(1, 2);
//        graph.addDirectedEdge(1, 3);
//        graph.addDirectedEdge(3, 5);
//        System.out.println(graph.toString());

        graph.topologicalSort();
;
    }
}
