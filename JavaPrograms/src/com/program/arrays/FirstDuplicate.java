package com.program.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array that contains only numbers in the range from 1 to a.length, find the first duplicate number for which
 * the second occurrence has the minimal index. In other words if there are more than 1 duplicate numbers, retuen the
 * number of which the second occurrence has a smaller index than the second index of the other numbers does, If there
 * are no such elements, return -1. <br>
 * Example: [2, 1, 3, 5, 3, 2] -> result = 3
 * 
 * @author MALLIKARJUN
 *
 */
public class FirstDuplicate {
    
    /**
     * Finds value of minimum second duplicate index <br>
     * Complexity = O(N2) = n square
     * 
     * @param a
     * @return
     */
    static int firstDuplicate(int[] a) {
        int minSecondIndex = a.length; // Minimum index of second duplicate value
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    minSecondIndex = Math.min(minSecondIndex, j);
                }
            }
        }
        if (minSecondIndex == a.length) {
            return -1;
        }
        return a[minSecondIndex];
    }
    
    /**
     * Finds the first duplicate value <br>
     * 
     * Complexity = O(N) with space in HashSet
     * 
     * @param a
     * @return
     */
    static int findFirstDuplicate(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i])) {// found first duplicate
                return a[i];
            } else {
                set.add(a[i]);
            }
        }
        return -1;
    }
    
    /**
     * Finds the first duplicate value <br>
     * 
     * Complexity = O(N)
     * 
     * Updates current element (value -1) index value to -ve, if the same value appears, then the (value -1) index value
     * will be < 0.
     * 
     * @param a
     * @return
     */
    static int getFirstDuplicate(int[] a) {
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            if (a[Math.abs(a[i]) - 1] < 0) {
                return Math.abs(a[i]);
            } else {
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
            }
            System.out.println(Arrays.toString(a));
        }
        return -1;
        
        // 1 iteraction -> [2, -1, 3, 5, 3, 2]
        // 2 iteraction -> [-2, -1, 3, 5, 3, 2]
        // 3 iteraction -> [-2, -1, -3, 5, 3, 2]
        // 4 iteraction -> [-2, -1, -3, 5, -3, 2]
        // result = 3
    }
    
    public static void main(String[] args) {
        int[] input = { 2, 1, 3, 5, 3, 2 };
        int result = getFirstDuplicate(input);
        System.out.println(result);
    }
    
}
