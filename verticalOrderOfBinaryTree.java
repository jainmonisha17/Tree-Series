/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Tuple {
        TreeNode root;
        int row;
        int col;
        public Tuple(TreeNode _root, int _row, int _col) {
            root = _root;
            row = _row;
            col = _col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.root;
            int x = tuple.col;
            int y = tuple.row;

            if(!map.containsKey(y)) {
                map.put(y, new TreeMap<>());
            }

            if(!map.get(y).containsKey(x)) {
                map.get(y).put(x, new PriorityQueue<>());
            }

            map.get(y).get(x).offer(root.val);


            if(root.left != null) {
                q.offer(new Tuple(root.left, y - 1, x + 1));
            }

            if(root.right != null) {
                q.offer(new Tuple(root.right, y + 1, x + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()) {
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()) {
                while(!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
