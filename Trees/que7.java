// VALIDATE BINARY SEARCH TREE
// Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree) or not. 
// If yes, print true, print false otherwise. A binary search tree (BST) is a binary tree data structure which
//  has the following properties.

// • The left subtree of a node contains only nodes with data less than the node’s data.

// • The right subtree of a node contains only nodes with data greater than the node’s data.

// • Both the left and right subtrees must also be binary search trees.
// Input
// The first line contains an Integer 't', which denotes the number of test cases or queries to be run. Then the test cases follow.
// The first line of input contains the elements of the tree in the level order form separated by a single space.
// If any node does not have a left or right child, take -1 in its place.
// Output
// For each test case, print true if the binary tree is a BST, else print false.

// Output for every test case will be denoted in a separate line.
// Example
// Input:

// 1
// 3 1 5 -1 2 -1 -1 -1 -1
// Output:

// true


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