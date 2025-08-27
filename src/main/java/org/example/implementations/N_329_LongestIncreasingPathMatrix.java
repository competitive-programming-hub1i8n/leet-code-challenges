package org.example.implementations;

import java.util.Arrays;

public class N_329_LongestIncreasingPathMatrix {
    public static void main(String[] args) {
        N_329_LongestIncreasingPathMatrix  obj = new N_329_LongestIncreasingPathMatrix();
        int ans = obj.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        });
        System.out.println(ans);

    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, dp, dirs, i, j, m, n));
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return res;
    }

    public static int dfs(int[][] matrix,  int[][] dp, int[][] dirs, int x, int y, int m, int n) {
        if (dp[x][y] != 0) return dp[x][y];
        int best = 1;
        for(int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && matrix[nextX][nextY] > matrix[x][y]) {
                best = Math.max(best, 1 + dfs(matrix, dp, dirs, nextX, nextY, m, n));
            }
        }
        dp[x][y] = best;
        return best;
    }
}
