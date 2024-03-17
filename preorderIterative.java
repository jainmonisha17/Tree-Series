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

public class preorderIterative {

    public static ArrayList<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> preOrder = new ArrayList<Integer>();

        if(root == null) {
            return preOrder;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode topNode = stack.peek();
            preOrder.add(topNode.val);
            stack.pop();

            if(topNode.right != null) {
                stack.push(topNode.right);
            }
            if(topNode.left != null) {
                stack.push(topNode.left);
            }
        }
        return preOrder;
    }
   
   public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(8);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.right.right.left = new TreeNode(9);
    root.right.right.right = new TreeNode(10);

    ArrayList<Integer> preOrder = new ArrayList<>();
    preOrder = preOrderTraversal(root);
    
    System.out.println("The preorder traversal is : ");

    for(int i = 0; i < preOrder.size(); i++) {
        System.out.print(preOrder.get(i) + " ");
    }
   } 
}


