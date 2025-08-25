package org.example.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class N_1971_FindIfPathExistsInGraph {
    public static void main(String[] args) {
        N_1971_FindIfPathExistsInGraph obj = new N_1971_FindIfPathExistsInGraph();
        System.out.println(obj.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2)); // true
        System.out.println(obj.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5)); // false
        System.out.println(obj.validPath(10, new int[][]{{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}}, 7, 5));

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);

        boolean[] visited = new boolean[n];
        visited[source] = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(source);
        while (!pq.isEmpty()) {
            int node = pq.poll();
            if (node == destination) return true;
            for(int v :  graph.get(node)) {
                if(!visited[v]) {
                    visited[v] = true;
                    pq.offer(v);
                }
            }
        }
        return false;
    }
}
