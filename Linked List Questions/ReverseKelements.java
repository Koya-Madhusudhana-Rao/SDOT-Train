import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = next;
    }
}


public class ReverseKelements {
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy;

        while (current != null) {
            current = reverseNextK(current, k);
        }

        return dummy.next;
    }

    private static Node reverseNextK(Node current, int k) {
        Node next = current;
        for (int i = 0; i < k; i++) {
            if (next == null || next.next == null) {
                return null; // Not enough nodes to reverse
            }
            next = next.next;
        }

        Node prev = null;
        Node tail = current.next;
        Node temp = current.next;

        for (int i = 0; i < k; i++) {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        current.next = prev;
        tail.next = temp;

        return tail;
    }

    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the linked list (space-separated):");
        String[] elements = scanner.nextLine().split(" ");

        Node head = null;
        Node tail = null;

        for (String element : elements) {
            int val = Integer.parseInt(element);
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        // Reverse the linked list in groups of k
        head = reverseKGroup(head, k);

        System.out.println("Reversed Linked List:");
        display(head);
    }
}
