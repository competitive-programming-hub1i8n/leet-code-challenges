package org.example.implementations;

import java.util.Arrays;

public class N_121_BestTimeBuySellStock {
    public static void main(String[] args) {
        N_121_BestTimeBuySellStock sellStock = new N_121_BestTimeBuySellStock();
        System.out.println(sellStock.maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(sellStock.maxProfit(new int[]{7,6,4,3,1})); // 0
    }

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
