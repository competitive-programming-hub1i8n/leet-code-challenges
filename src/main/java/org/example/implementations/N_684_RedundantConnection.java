package org.example.implementations;

import java.util.Arrays;

public class N_684_RedundantConnection {
    public static void main(String[] args) {
        N_684_RedundantConnection  obj = new N_684_RedundantConnection();
        // System.out.println(Arrays.toString(obj.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(obj.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        Dsu dsu = new Dsu(n); // {0}, {1}, {2}, {3}, {4}
        for(int[] edge : edges){
            if(!dsu.union(edge[0] - 1,edge[1] - 1)){
                return new int[]{edge[0], edge[1]};
            }
        }
        return edges[edges.length - 1];
    }

    static class Dsu{
        int[] parent;
        int[] rank;

        public Dsu(int n ){
            parent = new int[n]; // [0, 1, 2, 3, 4]
            rank = new int[n]; // [0, 0, 0, 0, 0]
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        // parent = [0, 0, 2, 3, 4]
        // rank   = [1, 0, 0, 0, 0]
        boolean union(int x, int y){ // 0, 1
            int px = find(x); // 0
            int py = find(y); // 1
            if (px == py)
                return false;
            if (rank[px] < rank[py])
                parent[px] = py;
            else if (rank[px] > rank[py])
                parent[py] = px;
            else{
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }
}
