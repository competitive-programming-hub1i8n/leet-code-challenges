package org.example.implementations;

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][] res = spiralMatrixII.generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}
