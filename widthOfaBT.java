                            
import java.util.LinkedList;
import java.util.Queue;

// TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Solution {
    // Function widthOfBinaryTree to find the
    // maximum width of the Binary Tree
    public int widthOfBinaryTree(TreeNode root) {
        // If the root is null,
        // the width is zero
        if (root == null) {
            return 0;
        }

        // Initialize a variable 'ans'
        // to store the maximum width
        int ans = 0;

        // Create a queue to perform level-order
        // traversal, where each element is a pair
        // of TreeNode and its position in the level
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        // Push the root node and its
        // position (0) into the queue
        q.add(new Pair<>(root, 0));

        // Perform level-order traversal
        while (!q.isEmpty()) {
            // Get the number of
            // nodes at the current level
            int size = q.size();
            // Get the position of the front
            // node in the current level
            int mmin = q.peek().getValue();

            // Store the first and last positions
            // of nodes in the current level
            int first, last;

            // Process each node
            // in the current level
            for (int i = 0; i < size; i++) {
                // Calculate current position relative
                // to the minimum position in the level
                int cur_id = q.peek().getValue() - mmin;
                // Get the current node
                TreeNode node = q.peek().getKey();
                // Poll the front node from the queue
                q.poll();

                // If this is the first node in the level,
                // update the 'first' variable
                if (i == 0) {
                    first = cur_id;
                }

                // If this is the last node in the level,
                // update the 'last' variable
                if (i == size - 1) {
                    last = cur_id;
                }

                // Enqueue the left child of the
                // current node with its position
                if (node.left != null) {
                    q.add(new Pair<>(node.left, cur_id * 2 + 1));
                }

                // Enqueue the right child of the
                // current node with its position
                if (node.right != null) {
                    q.add(new Pair<>(node.right, cur_id * 2 + 2));
                }
            }

            // Update the maximum width by calculating
            // the difference between the first and last
            // positions, and adding 1
            ans = Math.max(ans, last - first + 1);
        }

        // Return the maximum
        // width of the binary tree
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution sol = new Solution();

        int maxWidth = sol.widthOfBinaryTree(root);

        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }
}



Algorithm / Intuition
To determine the maximum width of a tree, an effective strategy would be to assign and identify indexes for the leftmost and rightmost nodes at each level. Using these indexes, we can calculate the width for each level by subtracting the index of the leftmost node from that of the rightmost node.


Start by assigning an index to the root node as 0. For each level, the left child gets an index equal to 2 * parent index, and the right child gets an index equal to 2 * parent index + 1. Using a level order traversal, we use the leftmost and rightmost nodes at each level and using their indices, get the width at that level. Keep track of the maximum width encountered during the traversal. Whenever a wider level is found, update the maximum width.


Algorithm:

Step 1:Initialize a variable `ans` to store the maximum width. If the root is null, return 0 as the width of an empty tree is zero.
Step 2: Create a queue to perform level-order traversal and each element of this queue would be a pair containing a node and its vertical index. Push the root node and its position (initially 0) into the queue.
Step 3: While the queue is not empty, perform the following steps:
Get the number of nodes at the current level (size).
Get the position of the front node in the current level which is the leftmost minimum index at that level.
Initialize variables first and last to store the first and last positions of nodes in the current level.
Step 4: Backtracking: For each node in the current level:
Calculate the current position relative to the minimum position in the level.
Get the current node (node) from the front of the queue.
If this is the first node in the level, update the first variable.
If this is the last node in the level, update the last variable.
Enqueue the left child of the current node with index: 2 x current index - 1.
Enqueue the right child of the current node with index: 2 x current index + 1.
Step 5: Update the maximum width (ans) by calculating the difference between the first and last positions, and adding 1.
Step 6: Repeat the level-order traversal until all levels are processed. The final value of `ans` represents the maximum width of the binary tree, return it.
