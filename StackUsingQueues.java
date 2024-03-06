import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    void push(int x) {
        queue1.add(x);
    }

    int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return -1; // Stack is empty
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int poppedValue = queue1.poll();

        // Swap the names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        StackUsingQueues stack = new StackUsingQueues();

        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            switch (queryType) {
                case 1:
                    int x = scanner.nextInt();
                    stack.push(x);
                    break;
                case 2:
                    int poppedValue = stack.pop();
                    System.out.print(poppedValue + " ");
                    break;
            }
        }

        scanner.close();
    }
}
