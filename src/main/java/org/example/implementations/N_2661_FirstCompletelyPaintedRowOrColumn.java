package org.example.implementations;

import java.util.Hashtable;

public class N_2661_FirstCompletelyPaintedRowOrColumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int ans = -1;
        int numRows = mat.length;
        int numCols = mat[0].length;

        Hashtable<Integer, Cell> numToPos = new Hashtable<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int val = mat[i][j];
                if (!numToPos.containsKey(val)) {
                    numToPos.put(val, new Cell(i, j, val));
                }

            }
        }
        for (int val : arr){
            //Cell cell = new Cell()
        }

        return ans;
    }

    private static class Cell{
        int row;
        int col;
        int val;

        public Cell(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,4},
                {2,3}
        };

        int[] arr = {1,3,4,2};
        N_2661_FirstCompletelyPaintedRowOrColumn column = new N_2661_FirstCompletelyPaintedRowOrColumn();
        System.out.println(column.firstCompleteIndex(arr, mat));
    }
}
