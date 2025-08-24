package org.example.implementations;

public class N_704_BinarySearch {
    public static void main(String[] args) {
        N_704_BinarySearch obj = new N_704_BinarySearch();
        System.out.println(obj.search(new int[]{-1,0,3,5,9,12}, 9)); // 4
        System.out.println(obj.search(new int[]{-1,0,3,5,9,12}, 2)); // -1
        System.out.println(obj.search(new int[]{5}, 5)); // 0
        System.out.println(obj.search(new int[]{5}, 6)); // -1
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
