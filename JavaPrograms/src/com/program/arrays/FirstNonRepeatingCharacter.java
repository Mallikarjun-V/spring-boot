package com.program.arrays;

import java.util.HashMap;

/**
 * Given a string consisting for English small letters, find and return the first instance of a non-repeating character
 * in it. If there is no such character return '_'.
 * 
 * Example For s = "abacabd", the output should be firstNonRepeatingCharacter 'c'.
 * 
 * @author MALLIKARJUN
 *
 */
public class FirstNonRepeatingCharacter {
    /**
     * Complexity = O(N2) -> N square
     * 
     * @param s
     * @return
     */
    static char firstNonRepeatingCharacter(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean foundDuplicate = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (i != j)) {
                    foundDuplicate = true;
                    break;
                }
            }
            if (!foundDuplicate) {
                return s.charAt(i);
            }
        }
        return '_';
    }
    
    /**
     * Complexity = O(2N)
     * 
     * @param s
     * @return
     */
    static char findFirstNonDuplicate(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return '_';
    }
    
    /**
     * Complexity = O(N)
     * 
     * @param s
     * @return
     */
    static char findFirstNonRepeatingCharacter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return '_';
    }
    
    public static void main(String[] args) {
        String input = "aaabccccdeeef";
        char result = findFirstNonRepeatingCharacter(input);
        System.out.println(result);
    }
}
