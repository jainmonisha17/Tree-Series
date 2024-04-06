
import java.util.*;




public class rootToNodePathofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);

        ArrayList<Integer> arr = new ArrayList<>();
        boolean res = rootToNodePath(root, arr, 7);
        System.out.print("The path is: ");
        for(int it: arr) {
            System.out.print(it + " ");
        }
    }

    public static boolean rootToNodePath(TreeNode root, ArrayList<Integer> arr, int nodeValtoFind) {
        // if root is null -> there is no path -> return false
        if(root == null) {
            return false;
        }

        // push the node's value to the arr
        arr.add(root.val);

        // if it is the required node -> return true
        if(root.val == nodeValtoFind) {
            return true;
        }

        // else check whether the required node lies in the left subtree or in 
        // the right subtree of the current node if it does'nt return false

        if(rootToNodePath(root.left, arr, nodeValtoFind) || rootToNodePath(root.right, arr, nodeValtoFind)) {
            return true;
        }
        
        // else requied node does'nt lie either in the left or right subtree of the current node
        // Thus, remove current node's value from
        // the arr and return false
        arr.remove(arr.size() - 1);
        return false;
    } 
}
