
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class LCAofBT {
    public static void main(String[] args) {
        LCAofBT obj = new LCAofBT();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Define the nodes for which w3e want to find the LCA
        TreeNode x = root.left;
        TreeNode y = root.left.right.right;

        // Find LCA
        TreeNode lca = obj.LCA(root, x, y);

        // output the value of the lca
        System.out.println("Lowest Common Ancestor of " + x.val + " and " + y.val + " is: " + lca.val);
    }

    public TreeNode LCA(TreeNode root, TreeNode x, TreeNode y) {
        if(root == null || root == x || root == y) {
            return root;
        }

        TreeNode left = LCA(root.left, x, y);
        TreeNode right = LCA(root.right, x, y);

        if(left == null) {    // if it doesn't find x or y node at left it will return null from left and return right node from right
            return right;
        } else if(right == null) {
            return left;
        } else {
            return root;
        }
    }
}