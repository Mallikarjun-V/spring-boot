package com.program.arrays;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n>1, return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i]
 * 
 * Example
 * 
 * input = [1, 2, 3, 4]
 * 
 * output = [24, 12, 8, 6]
 * 
 * @author MALLIKARJUN
 *
 */
public class ProductOfArrayExceptSelf {
    
    /**
     * Complexity = O(3N) with spaces - leftProducts, rightProducts
     * 
     * @param nums
     * @return
     */
    static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] leftProducts = new int[N];
        int[] rightProducts = new int[N];
        int[] output = new int[N];
        
        leftProducts[0] = 1;
        rightProducts[N - 1] = 1;
        
        for (int i = 1; i < N; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }
        
        for (int i = N - 2; i >= 0; i--) {
            rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
        }
        
        for (int i = 0; i < N; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }
        
        System.out.println(Arrays.toString(leftProducts));
        System.out.println(Arrays.toString(rightProducts));
        
        return output;
    }
    
    /**
     * Complexity = O(2N)
     * 
     * @param nums
     * @return
     */
    static int[] findProductExceptSelf(int[] nums) {
        int N = nums.length;
        int[] output = new int[N];
        
        output[0] = 1;
        
        for (int i = 1; i < N; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }
        
        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            output[i] = output[i] * R;
            R = R * nums[i];
        }
        return output;
    }
    
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(nums));
        int[] output = productExceptSelf(nums);
        System.out.println(Arrays.toString(output));
    }
}
