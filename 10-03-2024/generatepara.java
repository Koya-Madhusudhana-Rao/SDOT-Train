// GENERATE PARENTHESIS
// Given a positive integer n, write a function to generate all combinations of well-formed parentheses. The goal is to generate all possible combinations of parentheses such that they are balanced.

// A well-formed parentheses string is defined as follows:

// The empty string is well-formed.
// If "X" is a well-formed parentheses string, then "(X)" is also well-formed.
// If "X" and "Y" are well-formed parentheses strings, then "XY" is also well-formed.
// Input
// Enter the value of n
// Output
// Combinations of well-formed parentheses for n
// Example
// Input:

// 3
// Output:

// ((()))
// (()())
// (())()
// ()(())
// ()()()



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, n, "", result);
        return result;
    }

    private static void generateParenthesisHelper(int left, int right, String current, List<String> result) {
        // Base case: if both left and right are zero, add the current combination to the result
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        // Add left parenthesis if there are remaining left parentheses
        if (left > 0) {
            generateParenthesisHelper(left - 1, right, current + "(", result);
        }

        // Add right parenthesis if there are remaining right parentheses and it's valid
        if (right > left) {
            generateParenthesisHelper(left, right - 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        List<String> result = generateParenthesis(n);

        //System.out.println("Combinations of well-formed parentheses for n:");
        for (String combination : result) {
            System.out.println(combination);
        }
    }
}