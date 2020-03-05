package com.program.arrays;

import java.util.HashSet;

/**
 * You have two integer arrays a & b, and an integer target value v. Determine whether there is a pair of numbers, where
 * one number is taken from a and the other from b, that can be added together to a sum of v. Return true if such case
 * exists, otherwise return false.
 * 
 * Example
 * 
 * a = [1, 2, 3]
 * 
 * b = [10, 20, 30, 40]
 * 
 * v = 42, 40 + 2 = 42 -> result = true
 * 
 * Example
 * 
 * a = [0, 0, -5, 30212]
 * 
 * b = [-10, 40, -3, 9]
 * 
 * v = -8, -5 + -3 = -8 -> result = true
 * 
 * @author MALLIKARJUN
 *
 */
public class SumOfTwo {
    
    /**
     * 
     * Brute Force Solution.
     * 
     * Complexity = O(N2) -> N square
     * 
     * @param a
     * @param b
     * @param v
     * @return
     */
    static boolean sumOfTwo(int[] a, int[] b, int v) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] + b[j] == v) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Complexity = O(2N)
     * 
     * @param a
     * @param b
     * @param v
     * @return
     */
    static boolean findSumOfTwo(int[] a, int[] b, int v) {
        HashSet<Integer> differences = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int difference = v - a[i];
            differences.add(difference);
        }
        
        for (int i = 0; i < b.length; i++) {
            if (differences.contains(b[i])) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int[] b = { 10, 20, 30, 40 };
        int v = 42;
        
        boolean result = findSumOfTwo(a, b, v);
        System.out.println("result = " + result);
    }
    
}
