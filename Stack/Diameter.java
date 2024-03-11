// DIAMETER OF BINARY TREE
// Given a root of a binary tree, write a function to get the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// Input
// You are given a string s which describes the nodes of the binary tree. (The first element corresponds to the root, the second is the left child of the root and so on). In the function, you are provided with the root of the binary tree.

// Output
// Return the diameter of the binary tree.

// Example
// Input: 8 2 1 3 N N 5

// Output: 5



//2 


import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    // Function to find the diameter of the binary tree
    public int diameterOfBinaryTree() {
        if (root == null)
            return 0;
        return diameterOfBinaryTree(root);
    }

    private int diameterOfBinaryTree(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int leftDiameter = diameterOfBinaryTree(node.left);
        int rightDiameter = diameterOfBinaryTree(node.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nodes = input.split(" ");

        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("N")) {
                treeNodes[i] = new TreeNode(Integer.parseInt(nodes[i]));
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            if (treeNodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < nodes.length)
                    treeNodes[i].left = treeNodes[leftIndex];
                if (rightIndex < nodes.length)
                    treeNodes[i].right = treeNodes[rightIndex];
            }
        }

        BinaryTree binaryTree = new BinaryTree(treeNodes[0]);
        System.out.println(binaryTree.diameterOfBinaryTree());
    }
}