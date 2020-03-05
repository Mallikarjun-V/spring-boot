package com.program.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the array, and it should return false if
 * every element is distinct.
 * 
 * Example 1
 * 
 * input = [1,2,3,1], output = true
 * 
 * 
 * Example 2
 * 
 * input = [1,2,3,4], output = false
 * 
 * Example 3
 * 
 * input = []1,1,1,3,3,4,3,2,4,2], output = true
 * 
 * @author MALLIKARJUN
 *
 */
public class ContainsDuplicate {
    /**
     * Complexity = O()
     * @param nums
     * @return
     */
    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numbers.contains(nums[i])) {
                return true;
            } else {
                numbers.add(nums[i]);
            }
        }
        return false;
    }
    
    static boolean doesContainsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            if(nums[i] == nums[i +1]) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(input));
    }
}
