// NUMBER OF LONGEST INCREASING SUBSEQUENCES
// A Longest Increasing Subsequence (LIS) is a subsequence of a given sequence of numbers (not necessarily contiguous)
//  in which the elements are in strictly increasing order. 

// In other words, the Longest Increasing Subsequence problem asks for the length of the longest 
// subsequence such that all elements of the subsequence are sorted in ascending order.
// Input
// Enter the elements of the sequence separated by commas
// Output
// Print the Length of Longest Increasing Subsequence
// Example
// Input:

// 10,22,9,33,21,50,41,60,80
// Output:

// 6
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       String[] elements = input.split(",");
       int[] arr = new int[elements.length];
       for(int i=0; i<elements.length; i++){
           arr[i] = Integer.parseInt(elements[i]);
       }
       int max = arr[0];
       int count = 1;
       int index = 1;
       for(int i=0; i<arr.length-1; i++){
           if(arr[i]<arr[i+1]){
               count++;
           }
       }
       
       int[] result = new int[count];
       result[0] = arr[0];
       for(int i=0; i<arr.length-1; i++){
           if(arr[i]<arr[i+1]){
               max = arr[i+1];
               
               result[index] = max;
               index++;
           }
       }
       
       
    //   for(int i=0; i<result.length; i++){
           
       
    //         System.out.println(result[i]);
    //   }
       System.out.println(result.length);

	}
}

// Input:

// 10,22,9,33,21,50,41,60,80
// Output:

// 6