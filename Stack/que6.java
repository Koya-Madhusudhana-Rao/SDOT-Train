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