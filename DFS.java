import java.util.*;

public class DFS {

    public static void dfs(int current, boolean visited[], ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfs) {
        visited[current] = true;
        dfs.add(current);

        for(int it: adjList.get(current)) {
            if(visited[it] == false) {
                dfs(it, visited, adjList, dfs);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adjList) {
        boolean visited[] = new boolean[v];
        visited[0] = true;
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(0, visited, adjList, dfs);

        return dfs;
    }



    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
        adjList.get(4).add(2);

        DFS obj = new DFS();
        ArrayList<Integer> ans = obj.dfsOfGraph(5, adjList);
        int n = ans.size();
        for(int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
    
}
