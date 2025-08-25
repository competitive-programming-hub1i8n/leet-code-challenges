package org.example.implementations;

import java.util.Arrays;

public class N_997_FindTheTownJudge {
    public static void main(String[] args) {
        N_997_FindTheTownJudge obj = new N_997_FindTheTownJudge();
        System.out.println(obj.findJudge(2, new int[][]{{1,2}})); // 2
        System.out.println(obj.findJudge(3, new int[][]{{1,3},{2,3}})); // 3
        System.out.println(obj.findJudge(3, new int[][]{{1,3},{2,3},{3,1}})); // -1
        System.out.println(obj.findJudge(3, new int[][]{{1,2},{2,3}})); // -1
        System.out.println(obj.findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}})); // 3
    }

    public int findJudge(int n, int[][] trust) {
        int[] onEntry = new int[n + 1];
        int[] onExit = new int[n + 1];
        for (int[] item : trust) {
            Node node = new Node(item[0], item[1]);
            onExit[node.u]++;
            onEntry[node.v]++;
        }
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            if (onEntry[i] == n -1 && onExit[i] == 0){
                answer = i;
            }
        }
        return answer;
    }

    record Node(int u, int v){}
}
