import java.util.*;

public class topViewOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> boundaryTraversal;
        boundaryTraversal = topView(root);

        System.out.println("The boundary traversal is: ");

        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
    }

    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Map<Integer, Integer> myMap = new TreeMap<>();  // taking treeMap instead of hashmap coz we are inserting tree nodes into the treemap.
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        while(!queue.isEmpty()) {
            Pair current = queue.remove();
            int vertical = current.vertical;
            TreeNode currentNode = current.node;
            if(myMap.get(vertical) == null) {
                myMap.put(vertical, currentNode.val);
            }
            if(currentNode.left != null) {
                queue.add(new Pair(vertical - 1, currentNode.left));
            }
            if(currentNode.right != null) {
                queue.add(new Pair(vertical + 1 , currentNode.right));
            }
        }

        for(Map.Entry<Integer, Integer> entry: myMap.entrySet()) {  // its Map.Entry<Integer, Integer>
            ans.add(entry.getValue());
        }
        return ans;
    }
}

class Pair {
    int vertical;
    TreeNode node;

    Pair(int vertical, TreeNode node) {
        this.vertical = vertical;
        this.node = node;
    }
}
