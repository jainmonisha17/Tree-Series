Problem Description
In this problem, we are provided with the root of a binary tree where each node has a value within the range [0, 25]. These values represent the letters 'a' to 'z'. The task is to find the lexicographically smallest string that starts at a leaf of the tree and ends at the root. A leaf is defined as a node with no children. In terms of string comparison, a shorter prefix of a string is considered lexicographically smaller.

Intuition
The problem is essentially asking us to find the lexicographically smallest path from a leaf node to the root. Since the lexicographically smaller string could be due to a shorter length, we should aim to find shorter paths first.

We can solve this problem using a Depth-First Search (DFS) approach that will explore all paths from the root to the leaves and keep track of the lexicographically smallest path found at any point. Here's how we can proceed:

Traverse the tree starting from the root node and going down towards the leaves using DFS.
As we traverse, construct the string representing the path from the current leaf to the root by appending characters corresponding to node values at each step.
When a leaf node is reached, we reverse the constructed string (as we want it from leaf to root, but we are moving from root to leaf) and compare it with the currently found lexicographically smallest string. If it’s smaller, we update the smallest string.
After the DFS is completed, we will have the lexicographically smallest string from any leaf to the root.
A crucial detail is to handle the string comparison efficiently. Using Python's built-in string comparison, we can directly compare the strings using the min function. It's also important to note that we need to reverse the constructed path only once when we reach a leaf to avoid unnecessary computation.

Learn more about Tree, Depth-First Search and Binary Tree patterns.

Not Sure What to Study? Take the 2-min Quiz to Find Your Missing Piece：
Which of the following is equvalent to O(3*2^n + n^3 + n!+ log n)?

O(2^n)
O(n^3)
O(n!)
O(log n)
I don’t know
Solution Approach
The solution approach involves a Depth-First Search (DFS) algorithm that traverses the binary tree and efficiently constructs strings from leaves to root. During traversal, it keeps track of the smallest string found. Here's the detailed implementation described in steps:

Character Conversion: Since node values are integers in the range [0, 25], the first step is to convert the node values into characters. This is done by adding the node value to the ASCII value of 'a', which is done using chr(ord('a') + root.val).

DFS Function (dfs): A recursive function dfs is defined, which takes the root node and the current path as arguments. The path argument is a list that stores the characters from the root to the current node. This function is responsible for DFS traversal and updates the smallest string.

Base Case: The base case for the DFS is when the root is None. In this case, the function returns without performing any action.

Path Construction: When the root is not None, the corresponding character for the node value is appended to the path. If the root is a leaf (both root.left and root.right are None), the complete path from the root to this leaf is evaluated for lexicographical order.

Leaf String Reversal and Comparison: Upon reaching a leaf node, the path is reversed to make the string start at the leaf and end at the root, and the lexicographically smallest string ans is updated by comparing the current string with the existing smallest string using min(ans, ''.join(reversed(path))).

DFS Recursion: The function then recursively calls itself for the left and right children of the current node if they exist, enabling traversal of the entire tree.

Backtracking: After exploring both subtrees (left and right) from the current node, it's important to remove the current node's character from the path. This is to backtrack and ensure that when moving to a different branch, the path is correctly maintained - hence path.pop() is used.

Global Smallest String (ans): A variable ans is initialized to a string value higher than any possible value from the tree (the ASCII value of 'z' plus one), and it's defined as nonlocal within the dfs function to allow updating its value across recursive calls.

The specified approach takes advantage of the recursive nature of DFS to explore all paths from the root to leaf nodes and employs backtracking to efficiently update the paths during traversal. Additionally, Python's concise syntax and string comparison capabilities are leveraged to keep the implementation clean and readable.

Algorithm Complexity: The time complexity is O(N * M), where N represents the number of nodes in the tree and M is the maximum depth of the tree, since we need to compare strings of length M for each leaf node. The space complexity is O(M), which is required for the recursion stack and the path list in the worst case when the tree is skewed.

Discover Your Strengths and Weaknesses: Take Our 2-Minute Quiz to Tailor Your Study Plan:
What are the two properties the problem needs to have for dynamic programming to be applicable? (Select 2)

Optimal substructure
Overlapping subproblems
Non-overlapping subproblems
Constant time subproblems
Example Walkthrough
Let's walk through a small example to illustrate the solution approach. Consider a binary tree structured like this, where each node's value represents a character ('a' to 'z'):

   b
  / \
 a   d
    / \
   c   e
This tree can be represented as the following with numerical values [0, 25] (where 'a' = 0, 'b' = 1, ..., 'z' = 25):

   1
  / \
 0   3
    / \
   2   4
We want to find the lexicographically smallest string from a leaf to the root.

Step 1: Initializing the smallest string ans as "{" (ASCII value just above 'z') to ensure any valid path is smaller than ans initially.

Step 2: We start DFS from the root node 'b' ('b' has a numerical value of 1).

Step 3: The dfs function is called with the root node 'b'. We add 'b' to the current path.

Step 4: The root node has two children. The dfs function is recursively called on the left child 'a'.

Step 5: Now at node 'a'. It is a leaf node, so we reverse the current path which gives us "ab". We compare it with ans and update ans to "ab" as it is lexicographically smaller.

Step 6: Backtracking occurs, and we remove 'a' from the path and return to the root node 'b'.

Step 7: Next, the dfs is recursively called on the right child 'd'.

Step 8: At node 'd', we continue the process by moving to its left child 'c', which is also a leaf. The path here is "bdc". Reversed, we get "cdb". This string is not smaller than "ab", so ans remains "ab".

Step 9: We backtrack again and go to the right child 'e', encountering the path "bde". When reversed, we get "edb". Again, this is not smaller than "ab".

Step 10: DFS completes after we have visited all leaf nodes. ans is "ab", which is the lexicographically smallest string from leaf to root.

Thus, the lexicographically smallest string from a leaf to the root is "ab".

Not Sure What to Study? Take the 2-min Quiz：
Which of these properties could exist for a graph but not a tree?

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private StringBuilder currentPath; // StringBuilder to store the current path from leaf to root.
    private String smallestPath; // String to keep track of the smallest path encountered.

    public String smallestFromLeaf(TreeNode root) {
        currentPath = new StringBuilder();
        // Initialize the smallest path with a string value greater than any possible leaf path.
        smallestPath = String.valueOf((char) ('z' + 1));
        // Start the depth-first search from the root.
        depthFirstSearch(root);
        // Return the smallest path from leaf to root.
        return smallestPath;
    }

    private void depthFirstSearch(TreeNode node) {
        if (node != null) {
            // Prepend the character representation of the current node's value to the path.
            currentPath.append((char) ('a' + node.val));
          
            // Check if it's a leaf node.
            if (node.left == null && node.right == null) {
                // Reverse the path to get the leaf to root string.
                String leafToRootPath = currentPath.reverse().toString();
              
                // Update the smallest path if the current path is smaller.
                if (leafToRootPath.compareTo(smallestPath) < 0) {
                    smallestPath = leafToRootPath;
                }
              
                // Reverse the path back to maintain the root to leaf order.
                currentPath.reverse();
            }
          
            // Continue the depth-first search to the left subtree.
            depthFirstSearch(node.left);
            // Continue the depth-first search to the right subtree.
            depthFirstSearch(node.right);
          
            // Backtrack: remove the last character representing the current node's value.
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
}
