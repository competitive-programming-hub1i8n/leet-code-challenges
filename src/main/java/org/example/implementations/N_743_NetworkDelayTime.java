package org.example.implementations;

import java.util.*;

public class N_743_NetworkDelayTime {
    static final int INF = 1_000_000_000;
    record Edge(int to, int weight){}
    public static void main(String[] args) {
        N_743_NetworkDelayTime delayTime = new N_743_NetworkDelayTime();
        System.out.println(delayTime.networkDelayTime(new int[][]{
                {2, 1, 2},
                {2, 3, 1},
                {3, 4, 1}
        }, 4, 2));
        System.out.println(delayTime.networkDelayTime(new int[][]{
                {1, 2, 1}
        }, 2, 1));
        System.out.println(delayTime.networkDelayTime(new int[][]{
                {1, 2, 1}
        }, 2, 2));
        System.out.println(delayTime.networkDelayTime(new int[][]{
                {1,2,1},
                {2,1,3}
        }, 2, 2));

        System.out.println(delayTime.networkDelayTime(new int[][]{
                {1,2,1},
                {2,3,2},
                {1,3,1}
        }, 3, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new Edge(to, weight));
        }
        boolean[] visited = new boolean[n + 1];
        int[] ans = dijkstra(graph, k, n, visited);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(visited));
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return Arrays.stream(ans).filter(i -> i != 0 && i != INF).max().orElse(-1);
    }

    public static int[] dijkstra(List<List<Edge>> graph, int start, int n,  boolean[] visited) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        visited[start] = true;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            for(Edge next : graph.get(curr.to)) {
                visited[next.to] = true;
                if(dist[curr.to] + next.weight < dist[next.to]) {
                    dist[next.to] = next.weight + dist[curr.to];
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
