package org.example.implementations;

import java.util.*;

public class N_310_MinimumHeightTrees {
    public static void main(String[] args) {
        N_310_MinimumHeightTrees  obj = new N_310_MinimumHeightTrees();
        System.out.println(obj.findMinHeightTrees(4, new int[][]{{1,0}, {1,2},{1,3}}));
        System.out.println(obj.findMinHeightTrees(6, new int[][]{{3,0}, {3,1},{3,2}, {3,4}, {5,4}}));
        System.out.println(obj.findMinHeightTrees(1, new int[][]{}));

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) return List.of(0);
        List<Set<Integer>> graph = new ArrayList<>();
        int[] grades = new int[n];
        for (int i = 0; i < n; i++) graph.add(new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            grades[edge[0]]++;
            grades[edge[1]]++;
        }

        return bfs(graph, n, grades);

    }

    public List<Integer> bfs(List<Set<Integer>> graph, int n,  int[] grades) {
        List<Integer> res = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (graph.get(i).size() == 1)
                q.offer(i);
        }

        int nodesLength = n;
        while (nodesLength > 2){
            int currNodesLength = q.size();
            nodesLength -= currNodesLength;
            while (currNodesLength > 0 && !q.isEmpty()){
                int currNode = q.poll();
                for (int node : graph.get(currNode)){
                    grades[node]--;
                    if (grades[node] == 1){
                        q.offer(node);
                    }
                }
                currNodesLength--;
            }
        }

        while (!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }
}
