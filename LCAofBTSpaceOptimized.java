/*
    Time Complexity - O(N)
    Space Complexity - O(N)

    Where 'N' is the number of nodes in the Binary Tree.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    //    Finds the path from root to 'X' and return true if it exists.
    private static boolean getPath(TreeNode<Integer> root, List<Integer> path, int x)
    {
        if (root == null)
        {
            //    Tree doesn't have any node.
            return false;
        }

        //    Store the root node in the path
        path.add(root.data);

        //    Check if we reached to the destination node i.e. 'X'
        if (root.data == x)
        {
            //    'X' is found.
            return true;
        }

        //    Recur to find 'X' in the left subtree.
        if (getPath(root.left, path, x))
        {
            //    'X' exists in the left subtree.
            return true;
        }

        //    Recur to find 'X' in the right subtree.
        if (getPath(root.right, path, x))
        {
            //    'X' exists in the right subtree.
            return true;
        }

        //    Remove the root node because 'X' doesn't exists in the subtree rooted at "root".
        path.remove(path.size() - 1);

        return false;
    }


    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y)
    {
        //    To store the path from the root node to 'X' and 'Y'
        List<Integer> pathToX = new ArrayList<Integer>();
        List<Integer> pathToY = new ArrayList<Integer>();

        //    Get the path from the root node to node 'X'
        getPath(root, pathToX, x);

        //    Get the path from the root node to node 'Y'
        getPath(root, pathToY, y);

        int index;

        //    Iterate while elements in the lists are equal.
        for (index = 0; index < Math.min(pathToX.size(), pathToY.size()); index++)
        {
            if (pathToX.get(index) != pathToY.get(index))
            {
                //    Elements are not same.
                break;
            }
        }

        //    Return the LCA.
        return pathToX.get(index - 1);
    }
}



Naive Approach
The basic idea of this approach is to list down all the ancestors of the given nodes. And then, we will choose the common ancestor from the two lists which is farthest from the root of the tree.

 

Consider the binary tree as shown in the above figure, where we are trying to find the LCA of X and Y. Let us try to find the path from the root node to X and Y respectively and store the nodes present in the path in two separate lists pathToX and pathToY. Observe that the first few nodes(here nodes in yellow colour)  in the lists will be the same which are common ancestors of node X and Y.  Now, we need a common ancestor which is farthest from the root node. It is quite clear from the above image that the last common node in the lists will be the LCA.

 

Consider the following steps to describe the approach explained above:

Initialise two empty lists pathToX and pathToY to store the nodes in the path from the root node to ‘X’ and ‘Y’ respectively.
Perform a pre-order traversal to find the nodes in the path from the root node to X and store it in the pathToX such that the first element in the list is the root node.
Similarly, perform a pre-order traversal to find the nodes in the path from the root node to ‘Y’ and store it in the pathToY such that the first element in the list is the root node.
Now, start iterating from the front of the lists while the elements are equal.
The last equal element will be the LCA of X and Y.
Time Complexity
O(N), Where N is the number of nodes in the given binary tree.

 

Since we are doing two pre-order traversals and in the worst case (Skewed Trees), all nodes of the given tree can be present in the path when ‘X’ and ‘Y’ are very close to the leaf node of the binary tree. And each one can take O(N) time. So the overall time complexity will be O(N).

Space Complexity
O(N), Where N is the number of nodes in the given binary tree.

 

Since we are storing the paths in a list and in the worst case (Skewed Trees), all nodes of the given tree can be present in the list when ‘X’ will be the root node and ‘Y’ will be the leaf node of the binary tree. So the overall space complexity will be O(N).
