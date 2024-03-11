// SUM ROOT TO LEAF NODES
// Given a binary tree, where every node value is a Digit from 1-9. Find the sum of all the numbers which are formed from root to leaf paths.

// For example, consider the following Binary Tree. 
// 63525N4NN74
// There are 4 leaves, hence 4 root to leaf paths:

//    Path                      Number

//   6->3->2                     632

//   6->3->5->7                 6357

//   6->3->5->4                 6354

//   6->5>4                      654   

// Answer = 632 + 6357 + 6354 + 654 = 13997
// Example
// Input:

// 123456789
// Output:

// 2895


//4


class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

class SumRootToLeafNumbers {
    private static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private static int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return sumNumbersHelper(node.left, currentSum) + sumNumbersHelper(node.right, currentSum);
    }

    public static void main(String[] args) {
        // Sample Input
        String input = "123456789";
        char[] nodes = input.toCharArray();

        // Build the tree
        TreeNode root = buildTree(nodes, 0);

        // Find the sum of root to leaf numbers
        int result = sumNumbers(root);

        System.out.println(result);
    }

    private static TreeNode buildTree(char[] nodes, int index) {
        TreeNode root = null;
        if (index < nodes.length) {
            root = new TreeNode(Character.getNumericValue(nodes[index]));
            root.left = buildTree(nodes, 2 * index + 1);
            root.right = buildTree(nodes, 2 * index + 2);
        }
        return root;
    }
}