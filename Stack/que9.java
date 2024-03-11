// NUMBER OF ISLANDS
// You are given a 2D matrix grid of size n * m. 
// You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island.
//  Two islands are considered to be distinct if and only if one island is not equal to another (rotated or reflected islands are not euqal).
// Input
// The first line contains  integers value of N rows.
// The first line contains  integers value of M columns.
// Next N line contains M boolean values where 1 denotes land and 0 denotes water.
// Output
// Print total number of distinct islands.
// Example
// Input:

// 3
// 4
// 1 0 1 0
// 1 1 0 0
// 0 0 1 1
// Output:

// 3


//9


/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class islands{
    static int countislands(int[][] arr){
        Set<Set<String>> distinctIslands = new HashSet<>();

        for(int i =0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] ==1){
                    Set<String> island = new HashSet<>();
                    ExploreIsalnds(arr,i,j,i,j,island);
                    distinctIslands.add(island);
                    
                }
            }
        }

        return distinctIslands.size();

    }

    static void ExploreIsalnds(int[][] arr,int i,int j,int baseI,int baseJ, Set<String> island){
        if(i<0 || i>=arr.length || j<0||j>=arr[0].length || arr[i][j] !=1){
            return ;
        }

        arr[i][j] = 0;
        island.add((i - baseI) + "," + (j - baseJ));
        ExploreIsalnds(arr,i+1,j,baseI,baseJ,island);
        ExploreIsalnds(arr,i-1,j,baseI,baseJ,island);
        ExploreIsalnds(arr,i,j+1,baseI,baseJ,island);
        ExploreIsalnds(arr,i,j-1,baseI,baseJ,island);
    }
}

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
                
            }
           
        }
        islands land = new islands();
        int result = land.countislands(arr);
        System.out.println(result);

	}
}