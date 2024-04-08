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

public class rootToNodePathofBinaryTree1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);

        ArrayList<Integer> arr = new ArrayList<>();
        boolean result = rootToNodePath(root, arr, 7);
        System.out.println("The path from root to node is: ");
        for (int it : arr) {
            System.out.print(it + " ");
        }

    }
}

    public static boolean rootToNodePath(TreeNode root, ArrayList<Integer> arr, int nodeValToFind) {
        // if root is null -> there is no path -> return false
        if(root == null) {
            return false;
        }

        // push the node's value to th arr
        arr.add(root.val);

        // if it is the required node -> return true
        if(root.val == nodeValToFind) {
            return true;
        }

        // else check wheateher the required node lies in the left subtree or in 
        // the right subtree of the current node if it does'nt return false

        if(rootToNodePath(root.left, arr, nodeValToFind) || rootToNodePath(root.right, arr, nodeValToFind)) {
            return true;
        }

        // else required node does'nt lie either in the left or right subtree of the current node
        // thus, remove current node's value from
        // the arr and return false

        arr.remove(arr.size() - 1);       // last element from the arr
        return false;
    }

