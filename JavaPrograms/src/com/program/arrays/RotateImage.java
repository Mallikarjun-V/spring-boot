package com.program.arrays;

/**
 * You are given a n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise) Example for
 * input <br>
 * 1 2 3
 * 
 * 4 5 6
 * 
 * 7 8 9
 * 
 * Result
 * 
 * 7 4 1
 * 
 * 8 5 2
 * 
 * 9 6 3
 * 
 * @author MALLIKARJUN
 *
 */
public class RotateImage {
    
    static int[][] rotateImage(int[][] matrix) {
        int N = matrix.length;
        
        // Step 1 - Transpose Matrix (turn rows to columns) -> swap(array[i][j], array[j][i])
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        print(matrix);
        // Step 2 - Flip Horizontally -> swap(array[i][j], array[i][N-1-j]
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = temp;
            }
        }
        return matrix;
    }
    
    public static void main(String[] args) {
        // [[1,2,3],
        // [4,5,6],
        // [7,8,9]]
        int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] result = rotateImage(input);
        print(result);
    }
    
    static void print(int[][] matrix) {
        // Loop through all rows
        for (int i = 0; i < matrix.length; i++) { // this equals to the row in our matrix.
            // Loop through all elements of current row
            for (int j = 0; j < matrix[i].length; j++) { // this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // change line on console as row comes to end in the matrix.
        }
    }
    
}
