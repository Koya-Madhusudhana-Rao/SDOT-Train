// WILDCARD PATTERN MATCHING
// You are given a pattern string containing letters and wildcard characters. 
// The wildcard character * can match any sequence of characters (including an empty sequence), 
// and the wildcard character ? can match any single character. 
// Your task is to implement a function that determines whether a given input string matches the provided pattern.
// Return true if the pattern can be equated to the text otherwise, false. 

// Here are the rules for wildcard matching:
// The wildcard character * can match any sequence of characters (including an empty sequence).
// The wildcard character ? can match any single character.
// For example:
// The pattern "h*t" matches strings like "hat," "hot," "hut," etc.
// The pattern "c?t" matches strings like "cat," "cot," "cut," etc.
// The pattern "ab*d" matches strings like "abd," "abcd," "abbd," etc.
// Write a function isMatch(pattern: str, input_str: str) -> bool that returns True if the input string matches the pattern, and False otherwise.
// Input
// The input must be in Two lines.
// 1st Line, Enter the Text.
// 2nd Line, Enter the Wildcard Pattern.
// Output
// Return true if the pattern can be equated to the text otherwise, false. 
// Example
// Input:

// adceb
// *a*b
// Output:

// true
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
    static boolean strmatch(String str, String pattern,
							int n, int m)
	{
		if (m == 0)
			return (n == 0);
		boolean[][] lookup = new boolean[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++)
			Arrays.fill(lookup[i], false);
		lookup[0][0] = true;
		for (int j = 1; j <= m; j++)
			if (pattern.charAt(j - 1) == '*')
				lookup[0][j] = lookup[0][j - 1];
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (pattern.charAt(j - 1) == '*')
					lookup[i][j] = lookup[i][j - 1]
								|| lookup[i - 1][j];
				else if (pattern.charAt(j - 1) == '?'
						|| str.charAt(i - 1)
								== pattern.charAt(j - 1))
					lookup[i][j] = lookup[i - 1][j - 1];
				else
					lookup[i][j] = false;
			}
		}

		return lookup[n][m];
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String pattern = sc.nextLine();
		if (strmatch(str, pattern, str.length(),
					pattern.length()))
			System.out.println(true);
		else
			System.out.println(false);
	}
}