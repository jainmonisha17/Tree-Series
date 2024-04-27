import java.util.*;

public class NumOfProvincesOrNumOfComponents {
    
    public static void dfs(int current, ArrayList<ArrayList<Integer>> adjList, int visited[]) {
        visited[current] = 1;

        for(Integer it: adjList.get(current)) {
            if(visited[it] == 0) {
                dfs(it, adjList, visited);
            }
        }
    }


    public static int numProvinces(ArrayList<ArrayList<Integer>> adjMatrix, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        // initialize the adjacency list
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        // to change adjMatrix to adjList

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                // self nodes are not considered

                if(adjMatrix.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        // to count no of diff componets
        int visited[] = new int[V];
        int count = 0;
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<ArrayList<Integer>>();
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(0).add(0, 1);
        adjMatrix.get(0).add(1, 0);
        adjMatrix.get(0).add(2, 1);
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(1).add(0, 0);
        adjMatrix.get(1).add(1, 1);
        adjMatrix.get(1).add(2, 0);
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(2).add(0, 1);
        adjMatrix.get(2).add(1, 0);
        adjMatrix.get(2).add(2, 1);

        NumOfProvincesOrNumOfComponents obj = new NumOfProvincesOrNumOfComponents();
        System.out.println("Number of provinces are: ");
        System.out.println(obj.numProvinces(adjMatrix, 3));
    }
}


// Time Complexity: O(N) + O(V+2E), Where O(N) is for outer loop and inner loop runs in total a single DFS over entire graph, and we know DFS takes a time of O(V+2E). 

// Space Complexity: O(N) + O(N),Space for recursion stack space and visited array.


    