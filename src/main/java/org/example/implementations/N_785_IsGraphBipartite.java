package org.example.implementations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N_785_IsGraphBipartite {
    public static void main(String[] args) {
        N_785_IsGraphBipartite  graph = new N_785_IsGraphBipartite();
        System.out.println(graph.isBipartite(new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}}));
        System.out.println(graph.isBipartite(new int[][]{{1,3}, {0,2}, {1,3}, {0,2}}));
        System.out.println(graph.isBipartite(new int[][]{
                {},
                {2,4,6},
                {1,4,8,9},
                {7,8},
                {1,2,8,9},
                {6,9},
                {1,5,7,8,9},
                {3,6,9},
                {2,3,4,6,9},
                {2,4,5,6,7,}
        }));
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i = 0; i < n; i++){
            if(colors[i] == -1){
                colors[i] = 0;
                q.offer(i);
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int edge :  graph[cur]){
                        if(colors[edge] == -1){
                            colors[edge] = 1 - colors[cur];
                            q.add(edge);
                        } else if (colors[edge] == colors[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
