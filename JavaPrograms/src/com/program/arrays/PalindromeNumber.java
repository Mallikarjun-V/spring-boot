package com.program.arrays;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 
 * Example
 * 
 * input: 121
 * 
 * output: true
 * 
 * Example
 * 
 * input: -121
 * 
 * output: false
 * 
 * Explanations: from left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a
 * palindrome.
 * 
 * You could solve without converting the integer to a string.
 * 
 * @author MALLIKARJUN
 *
 */
public class PalindromeNumber {
    
    /**
     * By reversing integer by half and compare
     * 
     * @param x
     * @return
     */
    static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reversedInt = 0;
        while (x > reversedInt) {
            int reminder = x % 10;
            x /= 10;
            System.out.println(x);
            reversedInt = (reversedInt * 10) + reminder;
        }
        System.out.println(x);
        System.out.println(reversedInt);
        if (x == reversedInt || x == reversedInt / 10) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * By reversing integer and compare
     * 
     * @param x
     * @return
     */
    static boolean palindrome(int x) {
        if (x == 0) {
            return true;
        }
        
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        
        int sum = 0;
        int original = x;
        while (original > 0) {
            int reminder = original % 10;
            sum = (sum * 10) + reminder;
            original = original / 10;
        }
        if (x == sum) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        int input = -121;
        System.out.println(palindrome(input));
    }
}
