package org.example.implementations;

import java.util.Arrays;

public class N_3459_LengthOfLongestV_ShapedDiagonalSegment {
    public static void main(String[] args) {
        N_3459_LengthOfLongestV_ShapedDiagonalSegment diagonalSegment = new N_3459_LengthOfLongestV_ShapedDiagonalSegment();
        int ans = diagonalSegment.lenOfVDiagonal(new int[][]{
                {2, 2, 1, 2, 2},
                {2, 0, 2, 2, 0},
                {2, 0, 1, 1, 0},
                {1, 0, 2, 2, 2},
                {2, 0, 0, 2, 2}
        });

        System.out.println(ans);

        ans = diagonalSegment.lenOfVDiagonal(new int[][]{
                {2,2,2,2,2},
                {2,0,2,2,0},
                {2,0,1,1,0},
                {1,0,2,2,2},
                {2,0,0,2,2}
        });
        System.out.println(ans);
    }

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = new int[][]{
                {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
        };
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    for (int k = 0; k < 4; k++) {
                        ans = Math.max(ans, dfs(grid,dirs, k, i, j, n, m, 2, false));
                    }
                }
            }

        }

        return ans;

    }

    public static int getExpected(int val) {
        return val == 2 ? 0 : 2;
    }

    public static int dfs(int[][] grid, int[][] dirs, int dir, int x, int y, int n, int m, int expected, boolean turned) {
        int best = 1;
        int nextX = x + dirs[dir][0], nextY = y + dirs[dir][1];
        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == expected) {
            best = Math.max(best, 1 + dfs(grid, dirs, dir, nextX, nextY, n, m, getExpected(expected), turned));
        }
        if (!turned){
            int newDir = (dir + 1) % 4;
            nextX = x + dirs[dir][0];
            nextY = y + dirs[dir][1];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == expected) {
                best = Math.max(best, 1 + dfs(grid, dirs, newDir, nextX, nextY, n, m, getExpected(expected), true));
            }
        }
        return best;
    }
}
