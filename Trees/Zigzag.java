// BINARY TREE ZIG ZAG LEVEL ORDER TRAVERSAL
// Given the root node of a tree, print its nodes in zig zag order,
//  i.e. print the first level left to right, next level right to left, third level left to right and so on.
// Note
// You need to complete the given function. The input and printing of output will be handled by the driver code.
// Input
// The first line of input contains a string represeting the nodes, N is to show null node.
// Output
// For each test case print the nodes of the tree in zig zag traversal.
// Example
// Input:

// 1 2 3 4 5 6 7
// Output:

// 1 3 2 4 5 6 7


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