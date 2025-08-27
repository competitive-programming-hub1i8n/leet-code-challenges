package org.example.implementations;

public class N_3000_MaximumAreaLongestDiagonalRectangle {
    public static void main(String[] args) {
        N_3000_MaximumAreaLongestDiagonalRectangle solution = new N_3000_MaximumAreaLongestDiagonalRectangle();
        int[][] dimensions = {{9, 3}, {8, 6}};
        System.out.println(solution.areaOfMaxDiagonal(dimensions));

    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiagonal = 0;
        for (int[] dim : dimensions) {
            int length = dim[0];
            int width = dim[1];
            int diagonal = length * length + width * width;
            int area = length * width;
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return  maxArea;
    }
}
