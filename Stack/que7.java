//7


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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String[] nodeStr = sc.nextLine().trim().split("\\s+");
            TreeNode root = buildTree(nodeStr);
            boolean isBST = isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.println(isBST);
        }
    }

    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode parent = queue.poll();

            if (!nodes[i].equals("-1")) {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.left);
            }

            if (i + 1 < nodes.length && !nodes[i + 1].equals("-1")) {
                parent.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                queue.offer(parent.right);
            }
        }

        return root;
    }

    public static boolean isBinarySearchTree(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return true;
        }

        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }

        return isBinarySearchTree(root.left, minVal, root.val) &&
               isBinarySearchTree(root.right, root.val, maxVal);
    }
}