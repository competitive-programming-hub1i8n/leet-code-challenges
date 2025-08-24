package org.example.weekly_contest_462;

import java.util.Arrays;

public class Q1_FlipSquareSubmatrixVertically {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = y; i < y + k; i++) {
            int indexX = x; // 1
            int indexY = (x + k ) - 1; // 3
            while (indexX < indexY){
                int aux = grid[indexX][i]; // 1, 0; 13
                grid[indexX][i] = grid[indexY][i];
                grid[indexY][i] = aux;
                indexX++;
                indexY--;
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return grid;
    }

    public static void main(String[] args) {
        Q1_FlipSquareSubmatrixVertically obj = new Q1_FlipSquareSubmatrixVertically();
        int[][] grid = new int[][]{
                {1,2,3,4},
                {13,14,15,8},
                {9,10,11,12},
                {5,6,7,16}
        };
        obj.reverseSubmatrix(grid, 1, 0, 3);

        int[][] grid2 = new int[][]{
                {3,4,2,3},
                {2,3,4,2}
        };
        obj.reverseSubmatrix(grid2, 0, 2, 2);
    }

}
