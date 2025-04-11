package org.example.implementations;

import java.util.Arrays;
import java.util.Random;

public class N_977_SquaresSortedArray {
    public static int[] sortedSquares(int[] nums) {
        // se elevara al cuadrado cada elemento del array
        nums = squares(nums, nums.length - 1);
        // se ordenara el array
        QuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static int[] squares(int[] nums, int len) {
        if (len == -1) {
            return nums;
        }else {
            nums[len] = nums[len] * nums[len];
            return squares(nums, len - 1);
        }
    }

    public static void QuickSort(int[] A, int inicio, int fin){
        int pivot = A[inicio];
        int i = inicio;
        int j = fin;
        while (i<j) {
            while (A[i] <= pivot & i<j)
                i++;
            while (A[j] > pivot)
                j--;
            if (i<j) {
                int aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[inicio] = A[j];
        A[j] = pivot;
        if(j-1 > inicio)
            QuickSort(A, inicio, j-1);
        if(fin > j+1)
            QuickSort(A, j+1, fin);
    }

    static int[] createList(int n, int downLimit, int upLimit){
        int[] nums = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(downLimit) - upLimit; // Genera números entre -104 y 104
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = createList((int)Math.pow(10, 4), (int)Math.pow(10, 4), 100);

        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
