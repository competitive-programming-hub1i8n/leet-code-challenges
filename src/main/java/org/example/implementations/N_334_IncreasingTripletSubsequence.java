package org.example.implementations;

public class N_334_IncreasingTripletSubsequence {
    public static void main(String[] args) {
        N_334_IncreasingTripletSubsequence obj = new N_334_IncreasingTripletSubsequence();
        /*System.out.println(obj.increasingTriplet(new int[]{1,2,3,4,5})); // true
        System.out.println(obj.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
        System.out.println(obj.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})); // true
        System.out.println(obj.increasingTriplet(new int[]{1, 2})); // false*/
        System.out.println(obj.increasingTriplet2(new int[]{20,100,10,12,5,13})); // true

    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] < nums[i+1] && nums[i+1] < nums[i+2]) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n <= min1) min1 = n;
            else if(n <= min2) min2 = n;
            else return true;
        }
        return false;
    }
}
