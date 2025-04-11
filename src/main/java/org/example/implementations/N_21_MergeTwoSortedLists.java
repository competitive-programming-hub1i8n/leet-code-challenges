package org.example.implementations;

import java.util.Arrays;

public class N_21_MergeTwoSortedLists {
    public static int[] mergeTwoLists(int[] nums1, int[] nums2) {
        int lenNums1=  nums1.length;
        nums1 = Arrays.copyOf(nums1, nums1.length + nums2.length);

        return sorted(nums1, lenNums1, nums2, nums2.length);
    }

    public static int[] sorted(int[] list1, int m, int[] list2, int n) {
        int pointerOne = m+n-1;
        int pointerTwo = m-1;
        int pointerThree = n-1;

        while (pointerOne >= 0 && pointerTwo >= 0 && pointerThree >= 0){
            if (list2[pointerThree] > list1[pointerTwo]){
                list1[pointerOne] = list2[pointerThree];
                pointerOne--;
                pointerThree--;
            } else if (list2[pointerThree] < list1[pointerTwo]) {
                list1[pointerOne] = list1[pointerTwo];
                pointerOne--;
                pointerTwo--;
            } else if (list2[pointerThree] == list1[pointerTwo]) {
                list1[pointerOne] = list1[pointerThree];
                pointerOne--;
                pointerTwo--;
            }
        }
        list1[pointerOne] = list2[pointerThree];
        return list1;
    }

    public static void main(String[] args) {
        int[] list1 = {1,2,4};
        int[] list2 = {1,3,4};
        System.out.println(Arrays.toString(mergeTwoLists(list1,  list2)));
    }
}
