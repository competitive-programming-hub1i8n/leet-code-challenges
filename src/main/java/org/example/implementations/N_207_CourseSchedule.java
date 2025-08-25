package org.example.implementations;

import java.util.*;

public class N_207_CourseSchedule {
    public static void main(String[] args) {
        N_207_CourseSchedule  obj = new N_207_CourseSchedule();
        System.out.println(obj.canFinish(2, new int[][]{{1, 0}})); // true
        System.out.println(obj.canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return topologicalSort(numCourses, prerequisites);
    }

    static boolean topologicalSort(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        int[] indegree = new int[V];

        // Calculate indegree of each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }

        // Queue to store vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[V];
        int index = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            result[index++] = node;

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // Check for cycle
        return index == V;
    }
}
