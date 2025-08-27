package org.example.implementations;

import java.util.*;

public class N_886_PossibleBipartition {
    public static void main(String[] args) {
        N_886_PossibleBipartition  obj = new N_886_PossibleBipartition();
        System.out.println(obj.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(obj.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        DSU dsu = new DSU(2 * n + 5);

        for(int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            dsu.union(u, v + n);
            dsu.union(v, u + n);
        }

        for(int x = 1; x <= n; x++){
            if (dsu.find(x) == dsu.find(x+n)) return false;
        }
        return true;
    }

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]); // path compression
            return parent[x];
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;

            if (rank[a] < rank[b]) parent[a] = b;
            else if (rank[a] > rank[b]) parent[b] = a;
            else {
                parent[b] = a;
                rank[a]++;
            }
        }
    }

}
