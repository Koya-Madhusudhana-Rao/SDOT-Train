import java.util.Scanner;
import java.util.Stack;

public class BasicCalculator {

    public static int calculate(String expression) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        char operator = '+';

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                operand = operand * 10 + Character.getNumericValue(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                performOperation(stack, operand, operator);
                operand = 0;
                operator = ch;
            }
        }

        performOperation(stack, operand, operator);

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private static void performOperation(Stack<Integer> stack, int operand, char operator) {
        switch (operator) {
            case '+':
                stack.push(operand);
                break;
            case '-':
                stack.push(-operand);
                break;
            case '*':
                stack.push(stack.pop() * operand);
                break;
            case '/':
                stack.push(stack.pop() / operand);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the arithmetic expression:");
        String expression = scanner.nextLine();

        int result = calculate(expression);

        System.out.println("Result of the arithmetic expression:");
        System.out.println(result);
    }
}
