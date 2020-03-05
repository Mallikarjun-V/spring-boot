package com.program.arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0, 1, 2, 3, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2, 3])
 * 
 * You are given a target value to search. if found in the array return its index, otherwise return -1. You may assume
 * no duplicate exist in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n)
 * 
 * Example
 * 
 * input = [4, 5, 6, 7, 0, 1, 2], target = 0
 * 
 * output = 4
 * 
 * @author MALLIKARJUN
 *
 */
public class SearchInRotatedSortedArray {
    
    static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            } else {
                right = midpoint;
            }
        }
        
        int start = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }
        
        while (left <= right) {// binary search
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] == target) {
                return midpoint;
            } else if (nums[midpoint] < target) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int search = 0;
        int foundIndex = search(nums, search);
        System.out.println(foundIndex);
        
    }
}
