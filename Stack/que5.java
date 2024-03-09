//5


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Main {
    static TreeNode prev;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String treeString = scanner.nextLine().trim();
        TreeNode root = buildTree(treeString);

        flatten(root);
        printLinkedList(root);
    }

    public static TreeNode buildTree(String treeString) {
        if (treeString.equals("N")) {
            return null;
        }

        String[] nodes = treeString.split("\\s+");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode parent = queue.poll();

            if (!nodes[index].equals("N")) {
                parent.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(parent.left);
            }
            index++;

            if (index < nodes.length && !nodes[index].equals("N")) {
                parent.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(parent.right);
            }
            index++;
        }

        return root;
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void printLinkedList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
}