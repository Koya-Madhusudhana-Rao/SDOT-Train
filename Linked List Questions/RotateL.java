import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // Find the length of the linked list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Adjust k to avoid unnecessary rotations
        k = k % length;
        if (k == 0) {
            return head; // No need to rotate if k is a multiple of the length
        }

        // Find the new tail and head after rotation
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Perform the rotation
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the linked list values (enter -1 to stop):");
        int val = scanner.nextInt();
        ListNode head = new ListNode(val);
        ListNode current = head;

        while ((val = scanner.nextInt()) != -1) {
            current.next = new ListNode(val);
            current = current.next;
        }

        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        RotateLinkedList rotateLinkedList = new RotateLinkedList();
        ListNode rotatedHead = rotateLinkedList.rotateRight(head, k);

        System.out.println("Linked list after rotation:");
        while (rotatedHead != null) {
            System.out.print(rotatedHead.val + " ");
            rotatedHead = rotatedHead.next;
        }
    }
}
