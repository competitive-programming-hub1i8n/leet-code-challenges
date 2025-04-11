package org.example.implementations;

public class N_2319_CheckIfMatrixIsX_Matrix {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        return validateDiagonal(grid, n) && validateOther(grid, n);
    }

    static boolean validateDiagonal(int[][] grid, int n){
        int i = 0;
        int j = 0;
        int k = n - 1;

        while(i < n && j < n){
            if(grid[i][j] == 0 || grid[i][k-j] == 0){
                return false;
            }
            i++;
            j++;
        }

        return true;
    }

    static boolean validateOther(int[][] grid, int n){
        int k = n-1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (i != j && (i + j) != (n - 1) && grid[i][j] != 0) {
                    return false;
                }
                if(grid[i][j] == 0 || grid[i][k-j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
