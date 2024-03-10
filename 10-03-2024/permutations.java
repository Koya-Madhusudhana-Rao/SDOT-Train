// PERMUTATIONS
// Problem Statement: Generating Permutations using Backtracking

// Given a set of distinct integers, write a program to generate all possible permutations of the elements in the set.

// Input
// Enter the elements as a space-separated string
// Output
// Print the Permutations of the set.
// Example
// Input:

// 1 2 3
// Output:

// 1 2 3
// 1 3 2
// 2 1 3 
// 2 3 1
// 3 2 1
// 3 1 2


import java.util.*;

class Main {
    public static void permute(int[] arr, int l, int h) {
        if (l == h) {
            printArray(arr);
        } else {
            for (int i = l; i <= h; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, h);
                swap(arr, l, i);
            }
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter numbers separated by space: ");
        String input = sc.nextLine();
        String[] numbers = input.split("\\s+");
        
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        permute(arr, 0, arr.length - 1);
    }
}