import java.util.*;

public class LeadersInArr {

    public static ArrayList<Integer> printLeaders(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            boolean leader = true;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if(leader) {
                ans.add(arr[i]);
            }
        }    
        return ans;
    }


    public static void main(String[] args) {
        int arr[] = {10, 22, 12, 3, 0, 6};

        ArrayList<Integer> solution = printLeaders(arr);

        for(int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i) + "  ");
        }
    }
}

