package org.example.implementations;

import java.util.*;
/**
 * @Name: Two Out of Three
 * @Number: 2032
 * @Url: <a href="https://leetcode.com/problems/two-out-of-three/description">go to challenge</a>
 */
public class N_2032_TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        convertToSet(nums1, freq);
        convertToSet(nums2, freq);
        convertToSet(nums3, freq);

        List<Integer> answer = new ArrayList<>();
        for(int key : freq.keySet()){
            if(freq.get(key) >= 2){
                answer.add(key);
            }
        }

        return answer;
    }

    void convertToSet(int[] nums, HashMap<Integer, Integer> map){
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }

        for(int n: set){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

    }

    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

            /** Since we have 3 arrays of numbers,
             * we need 3 boolean arrays.
             *  Here is the length of the longest
             *  array that can reach the length of the array */
            boolean[] b1 = new boolean[101];
            boolean[] b2 = new boolean[101];
            boolean[] b3 = new boolean[101];

            /** where values of the boolean array
             * at the corresponding index are changed to true */
            for (int num : nums1) b1[num] = true;

            for (int num : nums2) b2[num] = true;

            for (int num : nums3) b3[num] = true;

            List<Integer> res = new ArrayList<>();


            for (int i = 1; i <= 100; i++){
                if((b1[i] || b2[i]) && (b2[i] || b3[i]) && (b3[i] || b1[i]))
                    res.add(i);
            }
            return res;

        }
    }
}

