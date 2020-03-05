package com.program.arrays;

import java.util.Arrays;

/**
 * You have a sorted array of integers. Write a function that returns a sorted array containing the squares of those
 * integers.
 * 
 * Input array length = 1<=N<=1000, <br>
 * Element -10000<=array[i]<=10000
 * 
 * - Input array will be sorted. <br>
 * - Output array will be sorted
 * 
 * Examples
 * 
 * [-7, -3, -1, 4, 8, 12] -> [1, 9, 16, 49, 64, 144]<br>
 * [1, 2, 3] -> [1, 4, 9]<br>
 * [-3, -2, -1] -> [1, 4, 9]<br>
 * [] -> INVALID INPUT
 * 
 * @author MALLIKARJUN
 *
 */
public class SortedSquaredArray {
    /**
     * Does square and sort.
     * 
     * Complexity = O(NlogN)
     * 
     * @param array
     * @return
     */
    static int[] sortedSquaredArray(int[] array) {
        int[] output = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            output[i] = array[i] * array[i];
        }
        // sorting as the -ve numbers become +ve and will nt be sorted though input array is sorted
        Arrays.sort(output);
        return output;
    }
    
    /**
     * Does square with sort.
     * 
     * Complexity = O(n)
     * 
     * @param array
     * @return
     */
    static int[] getSortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        
        for (int i = array.length - 1; i >= 0; i--) {
            if (Math.abs(array[left]) > array[right]) {
                result[i] = array[left] * array[left];
                left++;
            } else {
                result[i] = array[right] * array[right];
                right--;
            }
        }
        return result;
        
        // 1 iteration
        // i = 5;
        // result = [0, 0, 0, 0, 0, 144]
        // left = 0
        // right = 4
        
        // 2 iteration
        // i = 4;
        // result = [0, 0, 0, 0, 64, 144]
        // left = 0
        // right = 3
        
        // 3 iteration
        // i = 3
        // result = [0, 0, 0, 49, 64, 144]
        // left = 1
        // right = 3
        
        // 4 iteration
        // i = 2
        // result = [0, 0, 16, 49, 64, 144]
        // left = 1
        // right = 2
        
        // 5 iteration
        // i = 1
        // result = [0, 9, 16, 49, 64, 144]
        // left = 2
        // right = 2
        
        // 6 iteration
        // i = 0
        // result = [1, 9, 16, 49, 64, 144]
        // left = 3
        // right = 2
    }
    
    public static void main(String[] args) {
        int[] array = { -7, -3, -1, 4, 8, 12 };
        int[] output = getSortedSquaredArray(array);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
        
    }
}
