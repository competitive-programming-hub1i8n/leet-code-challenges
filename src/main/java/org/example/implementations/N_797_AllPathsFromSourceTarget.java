package org.example.implementations;

import java.util.ArrayList;
import java.util.List;

public class N_797_AllPathsFromSourceTarget {
    public static void main(String[] args) {
        N_797_AllPathsFromSourceTarget sourceTarget =  new N_797_AllPathsFromSourceTarget();
        System.out.println(sourceTarget.allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        }));

        System.out.println(sourceTarget.allPathsSourceTarget(new int[][]{
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        }));

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] adj) {
        int n = adj.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int from = 0; from < n; from++) {
            for (int to : adj[from]) {
                graph.get(from).add(to);
            }
        }

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, n - 1, 0, path, allPaths);
        return allPaths;
    }

    public void dfs(List<List<Integer>> graph, int n, int src, List<Integer> path, List<List<Integer>> allPaths) {
        if (src == n){
            allPaths.add(new ArrayList<>(path));
        }

        for(int edge : graph.get(src)){
            path.add(edge);
            dfs(graph, n, edge, path, allPaths);
            path.removeLast();
        }
    }
}
