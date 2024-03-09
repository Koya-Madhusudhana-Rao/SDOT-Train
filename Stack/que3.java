//3


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // Input string representing array representation of the tree
        TreeNode root = buildTree(input);
        zigzagLevelOrder(root);
        scanner.close();
    }

    public static TreeNode buildTree(String input) {
        if (input.equals("N")) {
            return null;
        }

        String[] nodes = input.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();
            String leftVal = nodes[index++];
            if (!leftVal.equals("N")) {
                current.left = new TreeNode(Integer.parseInt(leftVal));
                queue.offer(current.left);
            }

            if (index < nodes.length) {
                String rightVal = nodes[index++];
                if (!rightVal.equals("N")) {
                    current.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    public static void zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                System.out.print(node.val + " ");

                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }

            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                System.out.print(node.val + " ");

                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
        }
    }
}