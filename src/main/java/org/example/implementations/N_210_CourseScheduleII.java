package org.example.implementations;

import java.util.*;

public class N_210_CourseScheduleII {
    public static void main(String[] args) {
        N_210_CourseScheduleII scheduleII  = new N_210_CourseScheduleII();

        System.out.println(Arrays.toString(scheduleII.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(scheduleII.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(scheduleII.findOrder(1, new int[][]{})));
        System.out.println(Arrays.toString(scheduleII.findOrder(2, new int[][]{{0, 1}, {1, 0}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge :  prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }

        return topoSortDFS(graph, numCourses);
    }

    public static int[] topoSortDFS(List<List<Integer>> graph, int n){
        int[] deg = new int[n];
        for (int u= 0; u < n; u++){
            for (int v : graph.get(u)){
                deg[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int u = 0; u < n; u++){
            if (deg[u] == 0){
                q.offer(u);
            }
        }
        int[] order = new int[n];
        int index = 0;
        while (!q.isEmpty()){
            int u = q.poll();
            order[index++] = u;
            for (int v : graph.get(u)){
                if(--deg[v] == 0)
                    q.offer(v);
            }
        }
        if (index != n){
            return new int[0];
        }
        return order;
    }
}
