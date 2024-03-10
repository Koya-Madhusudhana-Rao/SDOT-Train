// SPIRAL MATRIX
// Print a given matrix in spiral form.

// Given a 2D array, print it in spiral form. Refer the following examples.
// Input
// In First Line, Enter the number of rows
// In Second Line, Enter the number of columns
// In Third Line, Enter the matrix elements
// Output
// Print the Spiral elements
// Example
// Input:

// 3
// 3
// 1 2 3
// 4 5 6
// 7 8 9
// Output:

// 1 2 3 6 9 8 7 4 5





/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
import java.util.Scanner;

class Main {

    public static void printSpiral(int[][] matrix, int rows, int cols) {
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;          
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
    
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
            
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

       
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        
        printSpiral(matrix, rows, cols);

        scanner.close();
    }
}


// Output:

// 1 2 3 6 9 8 7 4 5