import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Main {
    public static Node add(Node a, int b) {
        Node n = new Node(b);
        if (a == null) {
            return n;
        } else {
            Node temp = a;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            return a;
        }
    }

    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int n = lists.length;

        // Continuously merge lists until only one list remains
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                lists[i] = mer(lists[i], lists[n - 1 - i]);
            }
            n = (n + 1) / 2;
        }

        return lists[0];
    }

    public static Node mer(Node a1, Node a2) {
        if (a1 == null) {
            return a2;
        } else if (a2 == null) {
            return a1;
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (a1 != null && a2 != null) {
            if (a1.data < a2.data) {
                tail.next = a1;
                a1 = a1.next;
            } else {
                tail.next = a2;
                a2 = a2.next;
            }
            tail = tail.next;
        }

        if (a1 != null) {
            tail.next = a1;
        }

        if (a2 != null) {
            tail.next = a2;
        }

        return dummy.next;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Node[] lists = new Node[k];

        // Input for k linked lists
        for (int i = 0; i < k; i++) {
            int size = sc.nextInt();
            Node list = null;
            for (int j = 0; j < size; j++) {
                list = add(list, sc.nextInt());
            }
            lists[i] = list;
        }

        Node mergedList = mergeKLists(lists);

        if (mergedList == null) {
            System.out.println("NULL");
        } else {
            while (mergedList != null) {
                System.out.print(mergedList.data + " ");
                mergedList = mergedList.next;
            }
        }
    }
}
