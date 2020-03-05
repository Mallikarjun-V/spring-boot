package com.program.arrays;

import java.util.Arrays;

/**
 * Given an array of numbers and a value, find the largest sub-array of consecutive numbers within the array for which
 * the sum of all elements within that sub-array is equal to that value.
 * 
 * Example
 * 
 * input = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], sum = 15
 * 
 * output = [1, 5]
 * 
 * 
 * Example
 * 
 * input = [1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10], sum = 15
 * 
 * output = [1, 8]
 * 
 * 
 * @author MALLIKARJUN
 *
 */
public class LongestSubArrayBySum {
    
    /**
     * Complexity = O(N2) -> N square
     * 
     * @param array
     * @param sum
     * @return
     */
    static int[] longestSubArrayBySum(int[] array, int sum) {
        int[] output = new int[2];
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            boolean foundSum = false;
            for (int j = 0; j < array.length; j++) {
                currentSum = currentSum + array[j];
                if (currentSum == sum) {
                    output[1] = j + 1;
                    foundSum = true;
                    break;
                }
            }
            if (foundSum) {
                output[0] = i + 1;
            }
        }
        return output;
    }
    
    /**
     * In the worst case scenario here, the right pointer moves until the last element (n iterations) and then the left
     * pointer moves until the last element (n iterations). This would be O(2n)~O(n).
     * 
     * Complexity = O(2n)~O(n)
     * 
     * @param array
     * @return
     */
    static int[] findLongestSubArrayBySum(int[] arr, int s) {
        int[] result = new int[] { -1 };
        
        int sum = 0;
        int right = 0;
        int left = 0;
        
        while (right < arr.length) {
            sum += arr[right];
            while (left < right && sum > s) {
                sum -= arr[left++];
            }
            if (sum == s && (result.length == 1 || result[1] - result[0] < right - left)) {
                result = new int[] { left + 1, right + 1 };
            }
            right++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10 };
        int sum = 15;
        int[] result = findLongestSubArrayBySum(input, sum);
        System.out.println(Arrays.toString(result));
    }
}
