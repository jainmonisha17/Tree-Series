import java.util.*;

public class FourSumBetter {
    
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        HashSet<List<Integer>> quadrapletSet = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                HashSet<Long> mySet = new HashSet<>();
                // to get an arr ele between j and k and hashset
                // shd become empty 
                for(int k = j + 1; k < n; k++) {

                    long sum = arr[i] + arr[j];
                    sum += arr[k];
                    
                    long fourth = target - sum;

                    if (mySet.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        quadrapletSet.add(temp);
                    }
                    mySet.add((long) arr[k]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(quadrapletSet);
        return ans;
    }

     public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
