package com.program.arrays;

/**
 * Given a string determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Example:
 * 
 * input: "A man , a plan, a canal: Panama", ouput: true
 * 
 * input: "race a car", output: false
 * 
 * @author MALLIKARJUN
 *
 */
public class PalindromeString {
    
    static boolean isPalindrome(String s) {
        String fixed_string = "";
        // remove the special characters & spaces
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                fixed_string += c;
            }
        }
        
        fixed_string = fixed_string.toLowerCase();
        
        int a_pointer = 0;
        int b_pointer = fixed_string.length() - 1;
        while (a_pointer <= b_pointer) {
            if (fixed_string.charAt(a_pointer) != fixed_string.charAt(b_pointer)) {
                return false;
            }
            a_pointer++;
            b_pointer--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String input = "A man , a plan, a canal: Panama";
        System.out.println(isPalindrome(input));
    }
}
