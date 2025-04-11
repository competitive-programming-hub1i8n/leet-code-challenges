package org.example.implementations;

import java.util.Arrays;

public class N_2934_MinimumOperationsMaximizeLastElementsArrays {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int max1= findMaxNumber(nums1);
        int max2= findMaxNumber(nums2);
        System.out.println(max1);
        System.out.println(max2);

        if(nums1[n-1] == max1 && nums2[n-1] == max2) return 0;

        int answer = 0;

        for(int i = n -1; i >= 0; i--){
            max1= findMaxNumber(nums1);
            max2= findMaxNumber(nums2);
            if(nums1[n-1] == max1 && nums2[n-1] == max2) {
                break;
            }
            else if(nums1[i] <= max2 || nums2[i] <= max1){
                int aux = nums2[i];
                nums2[i] = nums1[i];
                nums1[i] = aux;
                answer++;
            }
            else{
                return -1;
            }
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        if (nums1[n - 1] != max1 || nums2[n - 1] != max2) {
            return -1;
        }

        return answer;
    }

    static int findMaxNumber(int ...nums){
        int max = 0;
        for(int value : nums){
            max = Math.max(max, value);
        }
        return max;
    }
}
