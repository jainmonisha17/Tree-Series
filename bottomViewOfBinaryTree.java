import java.util.*;


public class bottomViewOfBinaryTree {

    public static void main(String[] args) {
        TreeNodee root = new TreeNodee(1);
        root.left = new TreeNodee(2);
        root.right = new TreeNodee(3);
        root.left.left = new TreeNodee(4);
        root.left.right = new TreeNodee(5);
        root.right.left = new TreeNodee(6);
        root.right.right = new TreeNodee(7);
        root.right.left.right = new TreeNodee(8);

        bottomViewOfBinaryTree solution = new bottomViewOfBinaryTree();
        ArrayList<Integer> result = solution.bottomView(root);
        
        // Output the bottom view of the binary tree
        System.out.println("Bottom view of the binary tree:");
        for(Integer val : result) {
            System.out.print(val + " ");
        }
    }

    // function to return a list containing the bottom view of the given binary tree
    public static ArrayList<Integer> bottomView(TreeNodee root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;   // empty one
        }

        // TreeMap to store th bottom view nodes with horizantal distance as a key
        TreeMap<Integer, Integer> myMap = new TreeMap<>();   // Map -> vertical, node.val

        // queue for level order traversal
        Queue<TreeNodee> queue = new LinkedList<>();

        // Initialize the horizantal distance of root as 0 and add it to the queue
        root.horizantalDist = 0;
        queue.add(root);

        // level order traversal to calculate horizanal distance of each node

        while(!queue.isEmpty()) {
            TreeNodee currentNode = queue.remove();
            int horizantalDist = currentNode.horizantalDist;

            myMap.put(horizantalDist, currentNode.val);

            if(currentNode.left != null) {
                currentNode.left.horizantalDist = horizantalDist - 1;
                queue.add(currentNode.left);
            }

            if(currentNode.right != null) {
                currentNode.right.horizantalDist = horizantalDist + 1;
                queue.add(currentNode.right);
            }
        }
 
        // traverse the treemap and add the nodes to the answer list
        for(Map.Entry<Integer, Integer> entry: myMap.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}

class TreeNodee {
    int val;
    int horizantalDist;
    TreeNodee left;
    TreeNodee right;

    // constructore to initiliza the treeNodee
    public TreeNodee(int val) {
        this.val = val;
        horizantalDist = Integer.MAX_VALUE;   // 99999
        this.left = null;
        this.right = null;
    }
}


//                                1
//                          2            3
//                     4         5 6           7
//                                       8

// 4 2 6 8 7 



