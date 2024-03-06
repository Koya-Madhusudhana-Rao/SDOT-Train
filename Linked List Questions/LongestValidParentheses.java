import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize the stack with -1 as a base

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // Update the base if the stack becomes empty
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string containing '(' and ')': ");
        String input = scanner.next();

        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int result = longestValidParentheses.longestValidParentheses(input);

        System.out.println("Length of the longest valid parentheses substring: " + result);
    }
}
