import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class OddEvenLinkedList {

    public static ListNode segregateOddEven(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenDummy = new ListNode(0);
        ListNode oddDummy = new ListNode(0);

        ListNode evenTail = evenDummy;
        ListNode oddTail = oddDummy;

        ListNode current = head;

        while (current != null) {
            if (current.val % 2 == 0) {
                evenTail.next = current;
                evenTail = evenTail.next;
            } else {
                oddTail.next = current;
                oddTail = oddTail.next;
            }
            current = current.next;
        }

        evenTail.next = oddDummy.next;
        oddTail.next = null;

        return evenDummy.next;
    }

    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the list elements in space-separated values:");
        String[] elements = scanner.nextLine().split(" ");

        ListNode head = null;
        ListNode tail = null;

        for (String element : elements) {
            int val = Integer.parseInt(element);
            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Segregate even and odd numbers in the linked list
        head = segregateOddEven(head);

        System.out.println("Modified Linked List:");
        display(head);
    }
}
