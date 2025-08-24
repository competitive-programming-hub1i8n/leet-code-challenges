package org.example.implementations;

import java.util.PriorityQueue;

public class N_2558_TakeGiftsFromTheRichestPile {
    public static void main(String[] args) {
        N_2558_TakeGiftsFromTheRichestPile obj = new N_2558_TakeGiftsFromTheRichestPile();
        System.out.println(obj.pickGifts(new int[]{25,64,9,4,100}, 4)); // 29
        System.out.println(obj.pickGifts(new int[]{1,1,1,1}, 4)); // 4
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((g1, g2) -> Integer.compare(g2, g1)); // Max-Heap

        for (int gift : gifts) {
            pq.offer(gift);
        }

        while (!pq.isEmpty() && k-- > 0) {
            int richest = pq.poll();
            int newGift = (int) sqrtNewton(richest);
            pq.offer(newGift);
        }

        return pq.stream().mapToLong(Integer::longValue).sum();
    }

    public static double sqrtNewton(double S) {
        double x = S;
        double tolerance = 1e-10;
        while (Math.abs(x - S / x) > tolerance * x) {
            x = 0.5 * (x + S / x);
        }
        return x;
    }

}
