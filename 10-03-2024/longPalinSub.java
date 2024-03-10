// LONGEST PALINDROMIC SUBSTRING
// Given a string, we have to find the longest palindromic substring.
// (substring is a sequence of characters that is contiguous within a string.
//  For example, the string “Interviewbit”, “er”, “view”, “bit”,…etc are substrings, 
// but not “tr” as both these characters are not continuous. 
// Whereas palindrome is a word that reads the same backward as forwards. Examples include abba, zzzz, xyyx).
// Input
// Enter the string without any space.
// Output
// Print the Palindrome as a string.
// Example
// Input:

// babad
// Output:

// bab

import java.util.Scanner;

class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int n = s.length();

        if (n == 0) {
            return "";
        }

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;

        // All characters are palindrome of length 1
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        // Check for sub-string of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for sub-string of length greater than 2
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i < n - len + 1; ++i) {
                int j = i + len - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Enter the string without any space:");
        String str = sc.next();

        String result = longestPalindrome(str);

        System.out.println(result);
    }
}