//0-1 KNAPSACK ALGORITHM
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
    static int knapSack(int W, int wt[], int val[], int n) 
	{ 
		// Making and initializing dp array 
		int[] dp = new int[W + 1]; 

		for (int i = 1; i < n + 1; i++) { 
			for (int w = W; w >= 0; w--) { 

				if (wt[i - 1] <= w) 

					// Finding the maximum value 
					dp[w] 
						= Math.max(dp[w], dp[w - wt[i - 1]] 
											+ val[i - 1]); 
			} 
		} 
		// Returning the maximum value of knapsack 
		return dp[W]; 
	} 
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int W = sc.nextInt();
	    int weight[] = new int[n];
	    for(int i=0; i<n; i++){
		    weight[i] = sc.nextInt();
		}
		int profit[] = new int[n];
        for(int i=0; i<n; i++){
		    profit[i] = sc.nextInt();
		}
		System.out.print(knapSack(W, weight, profit, n)); 
	}
}

// Input:

// 3 5
// 1 2 3
// 1 5 3
// Output:

// 8