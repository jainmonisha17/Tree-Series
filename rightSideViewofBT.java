import java.util.*;

public class rightSideViewofBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        rightSideViewofBT solution = new rightSideViewofBT();
        List<Integer> result = solution.rightSideView(root);

        // Output the bottom view of the binary tree
        System.out.println("The right side view of the binary tree:");
        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewFunction(root, result, 0);

        return result;
    }

    public void rightViewFunction(TreeNode currentNode, List<Integer> result, int level) {
        if (currentNode == null) {
            return;
        }

        if (level == result.size()) {
            result.add(currentNode.val);
        }

        rightViewFunction(currentNode.right, result, level + 1);
        rightViewFunction(currentNode.left, result, level + 1);
    }   
}

