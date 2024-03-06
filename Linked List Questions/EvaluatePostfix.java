import java.util.Scanner;
import java.util.Stack;

class EvaluatePostfixExpression {

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix.split("\\s+")) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        System.out.println("Invalid token: " + token);
                        return -1;
                }
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the postfix expression (Space-separated values):");
        String postfix = scanner.nextLine();

        int result = evaluatePostfix(postfix);

        System.out.println("Result of the postfix expression:");
        System.out.println(result);
    }
}
