// TRAPPING RAIN WATER
// Given with n non-negative integers representing an elevation map 
// where the width of each bar is 1, we need to compute how much water it is able to trap after raining.
// Input
// Enter the elevation map elements separated by spaces
// Output
// Print the Amount of water trapped 
// Example
// Input:

// 3 0 2 0 4
// Output:

// 7


/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
    public static int maxWater(int[] arr, int n){
        //int n = arr.length;
        int result = 0;
        for(int i=1; i<n; i++){
            int left = arr[i];
            for(int j=0; j<i; j++){
                left = Math.max(left, arr[j]);
            } 
            int right = arr[i];
            for(int j=i+1; j<n; j++){
                right = Math.max(right, arr[j]);

            }

            result = result + (Math.min(left, right)-arr[i]);
        }
        return result;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc  = new Scanner(System.in);
        String[] elements = sc.nextLine().split(" ");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }
        int n = arr.length;
        System.out.println(maxWater(arr, n));


	}
}