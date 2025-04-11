package org.example.implementations;

public class N_33SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int mid;
        while(p1 <= p2){
            mid = p1 + (p2 - p1) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] >= nums[p1] ){ //&& nums[p1] < nums[p2]
                 if( target >= nums[p1] && target < nums[mid])
                    p2 = mid - 1;
                 else
                    p1 = mid + 1;
            }else{
                if( target <= nums[p2] && target > nums[mid])
                    p1 = mid + 1;
                else
                    p2 = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int target, expected, actual;

        int[] nums = {5,1,3};
        System.out.println(nums.length);
         target = 3;
         expected = 2;
        actual = N_33SearchInRotatedSortedArray.search(nums, target);
        System.out.println(expected + " == " + actual);

    }
}
//} else if (nums[p1] == target) {
//                return p1;
//            } else if (nums[p2] == target) {
//                return p2;
//            } else if (mid+1 < nums.length && nums[mid+1] == target) {
//                    return mid + 1;
//            } else if (mid-1 >= 0 && nums[mid-1] == target) {
//                 return mid - 1;