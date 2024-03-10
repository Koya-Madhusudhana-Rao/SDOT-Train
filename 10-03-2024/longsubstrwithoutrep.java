// LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
// You are given a string s. Your task is to find the length of the longest substring that contains each character at most once.
// A substring is a contiguous sequence of characters within a string.
// Input
// Enter the String without any space
// Output
// Return the length as integer
// Example
// Input:

// xyzxyzyy
// Output:

// 3


import java.util.HashMap;
import java.util.Scanner;

class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;

        // HashMap to store the last index of each character in the string
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the substring, update the start index
            if (lastIndexMap.containsKey(currentChar)) {
                start = Math.max(start, lastIndexMap.get(currentChar) + 1);
            }

            // Update the last index of the current character
            lastIndexMap.put(currentChar, end);

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Enter the String without any space:");
        String str = sc.next();

        int result = lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}