import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;

        // Step 3: Merge the first and reversed second halves alternately
        mergeLists(head, secondHalf);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static void mergeLists(ListNode first, ListNode second) {
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
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

        System.out.println("Enter the elements of the linked list (space-separated):");
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

        // Reorder the linked list
        reorderList(head);

        System.out.println("Reordered Linked List:");
        display(head);
    }
}
