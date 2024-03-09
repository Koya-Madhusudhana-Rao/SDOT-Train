import java.util.Stack;
import java.util.Scanner;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void push(int x) {
        stack1.push(x);
    }

    int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1; // Queue is empty
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        QueueUsingStacks queue = new QueueUsingStacks();

        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            switch (queryType) {
                case 1:
                    int x = scanner.nextInt();
                    queue.push(x);
                    break;
                case 2:
                    int dequeuedValue = queue.pop();
                    System.out.print(dequeuedValue + " ");
                    break;
            }
        }

        scanner.close();
        
    }
}
