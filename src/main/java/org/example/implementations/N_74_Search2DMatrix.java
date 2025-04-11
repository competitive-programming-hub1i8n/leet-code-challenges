package org.example.implementations;

public class N_74_Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int pointerEndRange = matrix[i].length - 1;
            if (matrix[i][pointerEndRange] >= target) {
                return binarySearch(matrix[i], target) != -1;
            }
        }
        return false;
    }

    public static int binarySearch(int[] nums, int target){
        int p1 = 0;
        int p2 = nums.length - 1;
        int mid;
        while(p1 <= p2){
            mid = p1 + (p2 - p1) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target < nums[mid]){
                p2 = mid - 1;
            }else {
                p1 = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] aux = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 3;
        System.out.println(searchMatrix(aux, target));

        int[][] aux2 = {
                {1}
        };
        int target2 = 1;
        System.out.println(searchMatrix(aux, target));
    }
}
