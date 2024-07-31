import java.util.*;

public class LeadersOptimal {

    public static ArrayList<Integer> printLeaders(int arr[]) {
        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();

        int max = arr[n - 1]; // add element not index not n only arr[n - 1]
        ans.add(arr[n - 1]);

        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int arr[]=  {10, 22, 12, 3, 0, 6};

        ArrayList<Integer> solution = printLeaders(arr);

        Collections.sort(solution, Collections.reverseOrder());

        for(int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i) + "  ");
        }
    }    
}
