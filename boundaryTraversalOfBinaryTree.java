import java.util.*;

public class boundaryTraversalOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        ArrayList<Integer> boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The boundary traversal is: ");

        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
    }

    public static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    public static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode current = root.left;
        while (current != null) {
            if (isLeaf(current) == false) {
                ans.add(current.val);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    public static void addRightBoundary(TreeNode root, ArrayList<Integer> ans) {
        Stack<Integer> stack = new Stack();
        TreeNode currentRight = root.right;
        // stack.add(currentRight.val);
        while (currentRight != null) {
            // TreeNode currentRight = root.right;
             //stack.add(currentRight.val);
            if (isLeaf(currentRight) == false) {
                stack.add(currentRight.val);
            }
            if (currentRight.right != null) {
                currentRight = currentRight.right;
            } else {
                currentRight = currentRight.left;
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            int temp = stack.pop();
            // int right = currentRight.val;
            
            ans.add(temp);
        }
    }

    // PRE-ORDER Traversal -> root, left, right
    public static void addLeaves(TreeNode root, ArrayList<Integer> ans) {
        if (isLeaf(root)) { // 4
            ans.add(root.val);
            return;
        }
        if (root.left != null) { // 4's left
            addLeaves(root.left, ans);
        } // 4's right
        if (root.right != null) {
            addLeaves(root.right, ans);
        }
    }

    public static ArrayList<Integer> printBoundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        if (isLeaf(root) == false) {
            ans.add(root.val);
        }

        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

}
