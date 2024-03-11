// LOWEST COMMON ANCESTOR OF BST
// Given the root node of a tree, whose nodes have their values in the range of integers. 
// You are given two nodes x, y from the tree. You have to print the lowest common ancestor of these nodes.

// Lowest common ancestor of two nodes x, y in a tree or directed acyclic graph is the 
// lowest node that has both nodes x, y as its descendants.
// Your task is to complete the function findLCA which receives the root of the tree, x, y as its parameters 
// and returns the LCA of these values.
// Input Format:

// The first line contains the values of the nodes of the tree in the level order form.
// The second line contains two integers separated by space which denotes the nodes x and y.
// Output Format:

// Print the LCA of the given nodes in a single line.
// Input
// 1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
// 7 5
// Output
// 1
// EXPLANATION
// The root of the tree is the deepest node which contains both the nodes 7 and 5 as its descendants, hence 1 is the answer.





//6


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

    // Function to find the lowest common ancestor of two nodes
    public TreeNode findLCA(TreeNode node, int x, int y) {
        if (node == null)
            return null;

        if (node.val == x || node.val == y)
            return node;

        TreeNode leftLCA = findLCA(node.left, x, y);
        TreeNode rightLCA = findLCA(node.right, x, y);

        if (leftLCA != null && rightLCA != null)
            return node;

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nodes = input.split(" ");

        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("-1")) {
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

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        BinaryTree binaryTree = new BinaryTree(treeNodes[0]);
        TreeNode lca = binaryTree.findLCA(treeNodes[0], x, y);
        System.out.println(lca.val);
    }
}