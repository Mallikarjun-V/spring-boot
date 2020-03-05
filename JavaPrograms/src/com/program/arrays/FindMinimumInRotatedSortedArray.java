package com.program.arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0, 1, 2, 3, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2, 3])
 * 
 * Find the minimum element. You may assume no duplicate exists in the array.
 * 
 * Example 1
 * 
 * input = [3,4,5,1,2]
 * 
 * output = 1
 * 
 * Example 2
 * 
 * input = [4,5,6,7,0,1,2]
 * 
 * output = 0
 * 
 * @author MALLIKARJUN
 *
 */
public class FindMinimumInRotatedSortedArray {
    static int findMin(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left > right) {
            int midpoint = left + (right-left)/2;
            if(nums[midpoint])
        }
    }
}
