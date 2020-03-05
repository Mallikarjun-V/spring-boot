package com.program.arrays;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * you may assume all the characters consist of printable ascii characters.
 * 
 * Example
 * 
 * input: ["h", "e", "l", "l", "o"], output: ["o", "l", "l", "e", "h"]
 * 
 * input: ["h", "a", "n", "n", "a", "h"], output: ["h", "a", "n", "n", "a", "h"]
 * 
 * @author MALLIKARJUN
 *
 */
public class ReverseString {
    static char[] reverse(char[] s) {
        int a_pointer = 0;
        int b_pointer = s.length - 1;
        while (a_pointer <= b_pointer) {
            char temp = s[a_pointer];
            s[a_pointer] = s[b_pointer];
            s[b_pointer] = temp;
            a_pointer++;
            b_pointer--;
        }
        return s;
    }
    
    public static void main(String[] args) {
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        char[] result = reverse(input);
        System.out.println(Arrays.toString(result));
    }
}
