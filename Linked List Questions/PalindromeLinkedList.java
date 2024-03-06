import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Empty list or single element is a palindrome
        }

        // Find the middle of the list using the two-pointer approach
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode reversedSecondHalf = reverseList(slow);

        // Compare the reversed second half with the first half
        while (reversedSecondHalf != null) {
            if (head.val != reversedSecondHalf.val) {
                return false; // The list is not a palindrome
            }
            head = head.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true; // The list is a palindrome
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the linked list: ");
        int size = scanner.nextInt();

        System.out.print("Enter the elements of the linked list: ");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 1; i < size; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println("Is the linked list a palindrome? " + palindromeLinkedList.isPalindrome(head));
    }
}
 
