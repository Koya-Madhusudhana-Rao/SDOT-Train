import java.util.Scanner;

class LongestHappyPrefix {

    public static String longestPrefix(String s) {
        int n = s.length();
        int[] lps = computeLPS(s);

        // The length of the longest happy prefix is given by lps[n - 1]
        int lengthOfHappyPrefix = lps[n - 1];

        // Return the substring up to the length of the longest happy prefix
        return s.substring(0, lengthOfHappyPrefix);
    }

    private static int[] computeLPS(String pattern) {
        int len = pattern.length();
        int[] lps = new int[len];

        int lenOfPrefix = 0;
        int i = 1;

        while (i < len) {
            if (pattern.charAt(i) == pattern.charAt(lenOfPrefix)) {
                lenOfPrefix++;
                lps[i] = lenOfPrefix;
                i++;
            } else {
                if (lenOfPrefix != 0) {
                    lenOfPrefix = lps[lenOfPrefix - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Enter the String:");
        String str = sc.next();

        String result = longestPrefix(str);

        System.out.println(result);
    }
}