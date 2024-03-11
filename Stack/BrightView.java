// BINARY RIGHT SIDE VIEW
// You are given a root pointer to the root of binary tree. You have to print the right view of the tree from top to bottom.

// Note The right view of a tree is the set of nodes that are visible from the right side.

// You need to complete the given function. The input and printing of output will be handled by the driver code.

// Input
// The first line contains the number of test cases. The second line contains a string giving array representation of a tree, if the root has no children give N in input.

// Output
// For each test case print the right view of the binary tree.

// Example
// Input: 1 1 2 3

// Output: 1 3



// 1

import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BrightView{
	public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0){
            String treeString = sc.nextLine().trim();
            TreeNode root = buildTree(treeString);

            printRightView(root);
            System.out.println();
        }
	}

    public static TreeNode buildTree(String treeString){
        if(treeString.equals("N")){
            return null;
        }

        String[] nodes = treeString.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        for(int i = 1; i < nodes.length; i += 2){
            TreeNode parent = queue.poll();

            if(!nodes[i].equals("N")){
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.left);
            }
            if(i + 1 < nodes.length && !nodes[i + 1].equals("N")){
                parent.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                queue.offer(parent.right);
            }
        }
        return root;
    }

    public static void printRightView(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == size - 1){
                    System.out.println(node.val + " ");
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
    }
}