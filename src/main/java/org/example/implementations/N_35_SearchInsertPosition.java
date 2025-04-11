package org.example.implementations;

import java.util.Arrays;

public class N_35_SearchInsertPosition {
    public static void main(String[] args) {
        N_35_SearchInsertPosition position = new N_35_SearchInsertPosition();
        System.out.println(position.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(position.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(position.searchInsert(new int[]{1,3,5,6}, 7));


        //System.out.println(Arrays.toString(position.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(position.plusOne(new int[]{9})));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums[nums.length-1] < target)
            return nums.length;
        else if (nums[0] > target) {
            return 0;
        }
        else {
            int response;
            do {
                response = binarySearch(nums, target);
                target += 1;
            } while (response == -1);
            return response;
        }
    }

    private int binarySearch(int[] a, int number){
        int p1 = 0;
        int p2 = a.length-1;
        int mid;
        while (p1 <= p2){
            mid = p1 + (p2 - p1) / 2;
            if (a[mid] == number){
                return mid;
            } else if (a[mid] > number) {
                p2 = mid - 1;
            }else {
                p1 = mid + 1 ;
            }
        }
        return -1;
    }

    public int[] plusOne(int[] digits) {
        StringBuilder builder = new StringBuilder();
        for (int i: digits) {
            builder.append(i);
        }
        int aux = Integer.parseInt(String.join("", builder.toString()))+1;

        digits = Arrays.copyOf(digits, String.valueOf(aux).length());
        System.out.println(digits.length);
        for (int i = builder.length() -1 ; i >= 0 ; i--) {
            digits[i] = aux%10;
            aux /= 10;
        }
        return digits;
    }
}
