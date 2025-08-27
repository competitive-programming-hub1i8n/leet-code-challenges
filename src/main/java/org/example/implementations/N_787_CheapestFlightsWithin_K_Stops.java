package org.example.implementations;

import java.util.*;

public class N_787_CheapestFlightsWithin_K_Stops {

    public static void main(String[] args) {
        N_787_CheapestFlightsWithin_K_Stops k_stops =  new N_787_CheapestFlightsWithin_K_Stops();
        System.out.println(k_stops.findCheapestPrice(4, new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        }, 0, 3, 1));

        System.out.println(k_stops.findCheapestPrice(4, new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        }, 0, 2, 1));

        System.out.println(k_stops.findCheapestPrice(4, new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        }, 0, 2, 0));
    }
    static final int INF = 1_000_000_000;
    record Edge(int to, int weight){}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : flights) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new Edge(to, weight));
        }
        Queue<Edge> pq = new LinkedList<>();
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        pq.offer(new Edge(src, 0));
        while (!pq.isEmpty() && k-- >= 0) {
            int size = pq.size();
            while (size-- > 0) {
                Edge curr = pq.poll();
                assert curr != null;
                for (Edge next : graph.get(curr.to)) {
                    if (curr.weight + next.weight >= cost[next.to] ) {
                        continue;
                    }
                    cost[next.to] =  curr.weight + next.weight;
                    pq.offer(new Edge(next.to, next.weight));
                }
            }
        }


        return cost[dst] == INF ? -1 : cost[dst];
    }
}
