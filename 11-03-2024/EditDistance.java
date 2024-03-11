// EDIT DISTANCE
// Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2. 
// The possible operations are permitted:
// Insert a character at any position of the string.
// Remove any character from the string.
// Replace any character from the string with any other character.
// Input
// Input consists of two lines, strings s1 and s2
// Output
// Print the minimum number of operations required to convert s1 to s2.
// Example
// Input:

// horse
// ros
// Output:

// 3
import java.util.Scanner;

class StringConversion {
    public static int minOperations(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a DP array to store the minimum number of operations
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If one of the strings is empty, minimum operations would be the length of the other string
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                }
                // If the characters at current positions are equal, no operation needed
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If characters are different, find the minimum among replace, insert, and delete
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        // Return the minimum number of operations required to convert s1 to s2
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input strings s1 and s2
        String s1 = scanner.next();
        String s2 = scanner.next();

        // Calculate and print the minimum number of operations required
        System.out.println(minOperations(s1, s2));

        scanner.close();
    }
}