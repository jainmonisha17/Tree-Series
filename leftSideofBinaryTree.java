import java.util.*;

public class leftSideofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        leftSideofBinaryTree solution = new leftSideofBinaryTree();
        List<Integer> result = solution.leftSideView(root);

        // Output the bottom view of the binary tree
        System.out.println("The left side view of the binary tree:");
        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }

    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftSideFunction(root, result, 0);
        return result;
    }

    public void leftSideFunction(TreeNode currentNode, List<Integer> result, int level) {
        if (currentNode == null) {
            return;
        }

        if (level == result.size()) {
            result.add(currentNode.val);
        }

        leftSideFunction(currentNode.left, result, level + 1);
        leftSideFunction(currentNode.right, result, level + 1);
    }
}
