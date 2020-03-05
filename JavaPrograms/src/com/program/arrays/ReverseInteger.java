package com.program.arrays;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example
 *
 * input: 123, output: 321
 * 
 * input: -123, output -321
 * 
 * Note: Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range [-2^31, -2^31-1]. For the purpose of this problem, assume your function returns 0 when the reversed integer
 * overflows.
 * 
 * @author MALLIKARJUN
 * 
 */
public class ReverseInteger {
    static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int reminder = x % 10;
            reversed = (reversed * 10) + reminder;
            x = x / 10;
            
            // boundary limits
            if (reversed > Integer.MAX_VALUE / 10 || reversed == Integer.MAX_VALUE / 10 && reminder > 7) {
                return 0;
            } else if (reversed < Integer.MIN_VALUE / 10 || reversed == Integer.MIN_VALUE / 10 && reminder < -8) {
                return 0;
            }
            // boundary limits
        }
        return reversed;
    }
    
    public static void main(String[] args) {
        int input = 123;
        System.out.println(reverse(input));
    }
    
}
