Problem Description
In this LeetCode problem, we're given what is known as a tree in the context of graph theory. A tree is a type of graph where there is exactly one path between any two nodes, and, importantly, there are no cycles, meaning no path starts and ends at the same node unless the path is zero-length (does not move from the starting node).

We are provided with two inputs:

n: the number of nodes in the tree, where the nodes are labeled from 0 to n - 1, and
edges: an array of n - 1 edges with each edge given as a pair [a_i, b_i] representing an undirected connection between nodes a_i and b_i.
The task is to pick a node that, when used as the root, results in a tree of the minimum possible height. The height of a tree, in this case, is defined as the number of edges in the longest path from the chosen root to any leaf node (a leaf node is a node with no children).

We are asked not just to find the height but to return a list of the labels of all nodes that can serve as roots for such minimum height trees (MHTs). There can be more than one MHT and we need to list all of their root labels.

Intuition
The key insight for solving this problem is understanding that the root of an MHT will be near the center of the tree. If we pick a node on the periphery of the tree (like a leaf), the height will be larger because it takes more edges to reach the opposite side of the tree. The MHTs can be found by iteratively trimming the leaves until one or two nodes remain, which will be our answer.

The process is somewhat similar to peeling an onion; we remove the outer layer (leaves) one by one until we reach the core. Here's how it breaks down:

Identify all the leaf nodes (nodes with only one connection) in the tree.
Remove the leaf nodes from the tree, along with their edges, to expose a new layer of leaf nodes.
Repeat the process until one or two nodes remain. These nodes will be the roots of the MHTs.
Why one or two? Because if a tree has an odd number of nodes, there will be one center node, while a tree with an even number of nodes could have two central nodes.

The provided solution translates this approach into code. A breadth-first search (BFS) is employed for the trimming process. A queue is used to process and trim leaves level by level, and the degree of each node is tracked to easily identify the leaves. When only one or two nodes are left, we've found our roots for the MHTs.
The implementation uses a breadth-first search (BFS) to trim the leaves from the tree iteratively. Here are the steps in the implementation along with the relevant data structures and algorithms used:

Handle the special case for a single-node tree: If n == 1, the tree has only one node and no edges, so that node (labeled 0) is by definition the root of an MHT. The function returns a list containing just this node.

Prepare data structures:

A graph g is represented using a defaultdict(list). This provides an adjacency list representation where each node has a list of its adjacent nodes.
A list degree is created with the length of n initialized to 0, which will keep track of the number of edges connected to each node (i.e., the degree of the node).
Populate the graph and degree:

For each edge (a, b) in the edges list, add b to the adjacency list of a (i.e., g[a].append(b)) and vice versa because the graph is undirected. Increment the degree of both a and b since the edge contributes to the degree of each.
Initialize a queue with all leaf nodes:

A double-ended queue q (deque) is initialized with all nodes that have a degree of 1, which means they are leaves.
Process the tree using BFS to remove leaves:

While q is not empty meaning there are still leaves to remove, clear the list ans to prepare for a new set of leaves.
Iterate over the current size of q, representing the current level of leaves to remove. Use q.popleft() to remove and get the first leaf a.
Add a to the current answer list ans.
For each adjacent node b of a, decrease its degree in degree[b] as we're going to remove the edge (a, b). If b becomes a new leaf (degree of 1), add it to q for the next iteration.
Finish when central nodes are found:

When the while loop exits, ans will contain either one or two nodes, which will be the roots of the MHT(s). These are returned as the result.
This approach efficiently prunes the tree layer by layer until reaching the center, ensuring a time complexity that is linear with respect to the number of nodes and edges, and thus suitable for large trees.

n = 6, so we have nodes 0, 1, 2, 3, 4, 5.
edges = [[0, 3], [1, 3], [2, 3], [3, 4], [4, 5]].
The tree can be visualized as follows:

   0
   |
   3
 / | \
1  |  4
   |   \
   2    5
Following the solution approach:

Handle the special case for a single-node tree: Since n != 1, this step is skipped.

Prepare data structures:

We create a graph g and a list degree with n entries initialized to 0.
Populate the graph and degree:

g[0] will have [3], g[3] will have [0, 1, 2, 4], and so on.
The degree list will be [1, 1, 1, 4, 2, 1] after this step since nodes 0, 1, 2, 5 are connected to one node, 4 is connected to two nodes, and 3 is connected to four nodes.
Initialize a queue with all leaf nodes:

Our queue q will be initialized with [0, 1, 2, 5] as they have a degree of 1.
Process the tree using BFS to remove leaves:

In the first iteration, each node in q (0, 1, 2, 5) is a leaf and will be removed. When removing 0, the degree of 3 becomes 3. This is similarly done for 1, and 2. Lastly, removing 5 reduces the degree of 4 to 1, making it a leaf.
After the first iteration, our updated degree list is [0, 0, 0, 1, 1, 0] (we do not care about zeros as these are removed nodes). q is now updated to [4, 3] since these nodes have become leaves.
Finish when central nodes are found:

After the second iteration, removing 4 from the queue makes 3 have a degree of 0, which means it can no longer be reduced. We've found our central nodes, which in this case, is just one node, 3.
The final answer list, which is the root of the MHT, will be [3]. Therefore, node 3 can be chosen as the optimal root for the minimum height tree, resulting in a height of 2.

Solution Implementation
Python
Java
C++
TypeScript
import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // List for storing the result which are the root nodes of the MHTs
        List<Integer> minHeightTrees = new ArrayList<>();
      
        // Base case: when there's only one node, return it as the root
        if (n == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }
      
        // Initialize the adjacency list
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
      
        // Initialize the degree array to keep track of the degree of each node
        int[] degrees = new int[n];
      
        // Build the graph by populating the adjacency list and degree array
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
          
            adjacencyList[nodeA].add(nodeB);
            adjacencyList[nodeB].add(nodeA);
          
            degrees[nodeA]++;
            degrees[nodeB]++;
        }
      
        // Queue for holding the leaves nodes
        Queue<Integer> leavesQueue = new LinkedList<>();
      
        // Add initial leaves to queue - those are nodes with degree 1
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                leavesQueue.offer(i);
            }
        }
      
        // Process leaves until there are potentially 2 or less nodes left
        while (!leavesQueue.isEmpty()) {
            // Clear the previous result
            minHeightTrees.clear();
          
            // Number of leaves at the current level
            int leavesCount = leavesQueue.size();
          
            // Process each leaf node
            for (int i = 0; i < leavesCount; i++) {
                int leafNode = leavesQueue.poll();
              
                // Add the leaf node to the result
                minHeightTrees.add(leafNode);
              
                // Visit all neighboring nodes
                for (int neighbor : adjacencyList[leafNode]) {
                    // Decrease the degree as we are removing the leaf node
                    degrees[neighbor]--;
                    // If this makes the neighbor a new leaf, add it to queue
                    if (degrees[neighbor] == 1) {
                        leavesQueue.offer(neighbor);
                    }
                }
            }
        }
      
        // Returns the list of rooted trees with minimal height
        return minHeightTrees;
    }
}


Time Complexity
The time complexity of this algorithm is O(V + E), where V is the number of vertices (or nodes) and E is the number of edges. Here's the breakdown of the complexity:

Constructing the graph takes O(V + E) time, since we go through all edges and insert both the edge connections into the graph representation.
Initializing the degree array takes O(V) time.
Initializing the queue q with all leaves takes O(V) time in the worst case (when all nodes are leaves, except one or two).
The while loop processes each node once when it becomes a leaf, decrementing the degrees and potentially adding new leaves to the queue. Every edge is looked at exactly twice (once for each vertex it connects) over the entire runtime of the algorithm. So the complexity associated with this part is O(E).
Therefore, the loop and ensuing operations are bounded by the total number of edges, making the overall time complexity O(V + E) as, in graph algorithms, we commonly take the sum of vertices and edge processing times.
Space Complexity
The space complexity of this code is also O(V + E), explained as follows:

We are maintaining a graph representation (g) which stores a list of neighbors for each node, with worst-case space usage of O(E) if we consider memory for the adjacency list alone.
The degree array consumes O(V) space, storing the degree of each vertex.
The queue q can hold all vertices at most, so it consumes O(V) space.
The ans list, in the worst case, can hold all nodes, thus consuming O(V) space.
Considering all storage aspects, the space complexity sums up to O(V + E), accounting for both the space taken by the graph representation and the auxiliary data structures used throughout the algorithm.

