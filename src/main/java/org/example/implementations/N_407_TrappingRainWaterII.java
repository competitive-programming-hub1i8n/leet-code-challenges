package org.example.implementations;

import java.util.PriorityQueue;

public class N_407_TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        int[] dRow = {0,0,-1,1};
        int[] dCol = {-1,1,0,0};

        int numOfRows = heightMap.length;
        int numOfCols = heightMap[0].length;

        boolean[][] visited = new boolean[numOfRows][numOfCols];

        PriorityQueue<Cell> boundary = new PriorityQueue<>();
        for (int i = 0; i < numOfRows; i++) {
            boundary.offer(new Cell(heightMap[i][0], i, 0));
            boundary.offer(new Cell(heightMap[i][numOfCols -1], i, numOfCols - 1));
            visited[i][0] = visited[i][numOfCols-1] = true;
        }

        for (int i = 0; i < numOfCols; i++) {
            boundary.offer(new Cell(heightMap[0][i], 0, i));
            boundary.offer(new Cell(heightMap[numOfRows - 1][i], numOfRows - 1, i));
            visited[0][i] = visited[numOfRows - 1][i] = true;
        }

        while (!boundary.isEmpty()){
            Cell currentCell = boundary.poll();

            int currentRow = currentCell.row;
            int currentCol = currentCell.col;
            int minBoundaryHeight = currentCell.height;
            for (int i = 0; i < 4; i++) {
                int neighborRow = currentRow + dRow[i];
                int neighborCol = currentCol + dCol[i];
                if (isValidCell(neighborRow, neighborCol, numOfRows, numOfCols) && !visited[neighborRow][neighborCol]){
                    int neighborHeight = heightMap[neighborRow][neighborCol];
                    if (neighborHeight < minBoundaryHeight){
                        res += (minBoundaryHeight - neighborHeight);
                    }
                    boundary.offer(new Cell(Math.max(minBoundaryHeight, neighborHeight), neighborRow, neighborCol));
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }
        return res;
    }

    private static class Cell implements Comparable<Cell>{
        int height;
        int row;
        int col;

        public Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.height, o.height);
        }
    }

    private static boolean isValidCell(int row, int col, int numOfRows, int numOfCols){
        return row >= 0 && col >= 0 && row < numOfRows && col < numOfCols;
    }

    public static void main(String[] args) {
        N_407_TrappingRainWaterII waterII = new N_407_TrappingRainWaterII();
        int[][] heightMap = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        System.out.println(waterII.trapRainWater(heightMap));

        heightMap = new int[][]{
                {3,3,3,3,3},
                {3,2,2,2,3},
                {3,2,1,2,3},
                {3,2,2,2,3},
                {3,3,3,3,3}
        };
        System.out.println(waterII.trapRainWater(heightMap));
    }
}

/*
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // initialization
        int[][] vols = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vols[i][j] = heightMap[i][j];
            }
        }

        //spread
        boolean upt = true;
        boolean init = true;
        while (upt) {
            upt = false;
            // from left top
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j], Math.min(vols[i - 1][j], vols[i][j - 1]));
                    if (init || vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
            init = false;

            //from down right
            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j], Math.min(vols[i + 1][j], vols[i][j + 1]));
                    if (vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
        }

        // calculate result
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vols[i][j] > heightMap[i][j])
                    res += vols[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}
 */
