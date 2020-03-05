package com.program.arrays;

/**
 * Program to right rotate the elements of an array. input array = {1, 2, 3, 4, 5 }, n = no. of elements to rotate. if
 * n=1; output = {5,1,2,3,4}
 * 
 * @author MALLIKARJUN
 *
 */
public class RotateArrayElelemts {
    
    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4, 5 };
        
        int n = 2; // no. of elements to rotate
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " "); // print original array
        }
        System.out.println();
        // Rotate Right
        for (int i = 0; i < n; i++) {
            int j, last;
            last = array[array.length - 1];
            
            for (j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = last;
        }
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " "); // print rotated array
        }
        
        // Rotate Left
        for (int i = 0; i < n; i++) {
            int j, first;
            first = array[0];
            
            for (j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = first;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " "); // print rotated array
        }
    }
    
}
