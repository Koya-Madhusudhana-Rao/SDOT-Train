import java.util.Scanner;

public class ReverseLinkedListInGroups {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node reverseInGroups(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;

        // Count the number of nodes in the current group
        Node temp = head;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // Reverse the nodes in the current group
        if (count == k) {
            while (count > 0 && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count--;
            }

            // Recursive call for the next group
            if (next != null) {
                head.next = reverseInGroups(next, k);
            }

            return prev;
        } else {
            // If there are fewer than k nodes remaining, no reversal is needed
            return head;
        }
    }

    private static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the linked list (space-separated):");
        String[] elements = scanner.nextLine().split(" ");

        Node head = null;
        Node tail = null;

        for (String element : elements) {
            int data = Integer.parseInt(element);
            Node newNode = new Node(data);
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
        head = reverseInGroups(head, k);

        System.out.println("Reversed Linked List:");
        display(head);
    }
}
