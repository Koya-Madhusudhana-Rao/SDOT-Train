// SHORTEST PALINDROME
// Given a string, find the shortest palindrome that can be obtained by adding characters in front of it.
// Input
// Enter the String without any space.
// Output
// Print the shortest palindrome in String.
// Example
// Input:

// race
// Output:

// ecarace


/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
     public static boolean isPalindrome(String str) {
        int l = 0;
        int h = str.length() - 1;

        while (l <= h) {
            if (str.charAt(l) != str.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
       Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String dummy = "";

        int n = str.length();
        for (int i = n - 1; i >= (n - 1) / 2; i--) {
            dummy = dummy + str.charAt(i);
        }

        if (isPalindrome(str)) {
            System.out.println(str );
        } else {
            System.out.println(dummy+str);
        }
	}
}

// race
// Output:

// ecarace