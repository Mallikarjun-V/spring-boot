package com.interview.question;

/**
 * Program to print numbers from 1 o 100 without looping.
 * 
 * @author MALLIKARJUN
 *
 */
public class PrintOneToHundredWithoutLooping {
    
    private static void print(int n) {
        if (n > 0) {
            System.out.println(n);
            print(n - 1);
        }
    }
    
    public static void main(String[] args) {
        print(100);
    }
    
}
