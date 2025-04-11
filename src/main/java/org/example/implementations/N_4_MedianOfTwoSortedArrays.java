package org.example.implementations;

import java.util.Arrays;

public class N_4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] joinedList = joinLists(nums1, nums2);
        if (joinedList.length % 2 == 0){
            int mid = joinedList.length / 2;
            return (joinedList[mid] + joinedList[mid - 1]) / 2.0;
        }
        return joinedList[joinedList.length / 2];
    }

    public static int[] joinLists(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, result, 0, nums1.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = new N_4_MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(median);

    }
}
