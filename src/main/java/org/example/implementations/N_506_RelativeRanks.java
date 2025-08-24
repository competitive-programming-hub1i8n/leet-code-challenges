package org.example.implementations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N_506_RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (int i = 0; i < score.length; i++) {
            priorityQueue.offer(new int[]{i, score[i]});
        }
        String[] ranks = new String[score.length];
        int rank = 0;
        while (!priorityQueue.isEmpty()) {
            int[] pair = priorityQueue.poll();
            int idx = pair[0];
            if (rank == 0){
                ranks[idx] = "Gold Medal";
            }else if (rank == 1){
                ranks[idx] = "Silver Medal";
            }else if (rank == 2){
                ranks[idx] = "Bronze Medal";
            }else {
                ranks[idx] = String.valueOf(rank + 1);
            }
            rank++;
        }
        return ranks;
    }

    public static void main(String[] args) {
        N_506_RelativeRanks obj = new N_506_RelativeRanks();
        System.out.println(Arrays.toString(obj.findRelativeRanks(new int[]{5,4,3,2,1})));
        //System.out.println(Arrays.toString(obj.findRelativeRanks(new int[]{10,3,8,9,4})));
    }
}
