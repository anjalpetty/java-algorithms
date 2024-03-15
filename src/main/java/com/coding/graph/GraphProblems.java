package com.coding.graph;

import java.util.*;

/*

 Graph Types
   1. directed
   2. undirected

   A ----> C
   |       |
   ⋁       ⋁
   B       E
   |
   ⋁
   D ----> F

 Traversal
   1. depth first (using stack)   - A, B, D, F, C, E
   2. breadth first (using queue) - A, B, C, D, E, F



 */

class Graph {

  private Map<Integer, List<Integer>> adj; // adjacency list

  public Graph() {
    adj = new HashMap<>();
  }

  public void addVertex(int vertex) {
    adj.putIfAbsent(vertex, new ArrayList<>());
  }

  public void addEdge(int src, int dest) {
    adj.get(src).add(dest);
  }

  public void dfs(int start) {
    boolean[] isVisited = new boolean[adj.size()];
//    dfsRecursive(start, isVisited);
    dfsIterative(start, isVisited);
  }

  void dfsRecursive(int current, boolean[] isVisited) {
    isVisited[current] = true;
    System.out.print(current + " ");

    for (int dest : adj.get(current)) {
      if (!isVisited[dest]) {
        dfsRecursive(dest, isVisited);
      }
    }
  }

  void dfsIterative(int start, boolean[] isVisited) {

    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      int current = stack.pop();
      if (!isVisited[current]) {
        isVisited[current] = true;
        System.out.print(current + " ");
        for (int dest: adj.get(current)) {
          if (!isVisited[dest]) {
            stack.push(dest);
          }
        }
      }
    }
  }

  public List<Integer> topologicalSort(int start) {
    LinkedList<Integer> result = new LinkedList<>();
    boolean[] isVisited = new boolean[adj.size()];
    topologicalSortRecursive(start, isVisited, result);
    return result;
  }

  private void topologicalSortRecursive(int current, boolean[] isVisited, LinkedList<Integer> result) {
    isVisited[current] = true;
    for (int dest : adj.get(current)) {
      if (!isVisited[dest])
        topologicalSortRecursive(dest, isVisited, result);
    }
    result.addFirst(current);
  }

  public void printMap() {
    for (Map.Entry<Integer, List<Integer>> entry: adj.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}

public class GraphProblems {

  public static void main(String[] args) {
    Graph graph = new Graph();

    /*
       0 ---> 2
       |      |
       ⋁      ⋁
       1      4
       |
       ⋁
       3 --> 5
     */
    graph.addVertex(0);
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    graph.addVertex(5);

    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(3, 5);
    graph.addEdge(2, 4);

    graph.printMap();
    graph.dfs(0);
  }

}
