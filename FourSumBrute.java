import java.util.*;



public class FourSumBrute {

    public static List<List<Integer>> fourSum(int[] arr, int target) {
    int n = arr.length;
    HashSet<List<Integer>> mySet = new HashSet<>();

    // checking for all possibilites

    for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
            for(int k = j + 1; k < n; k++) {
                for(int l = k + 1; l < n; l++) {

                    // taking bigger data type 
                    // to avoid integer overflow

                    long sum = (long)arr[i] + arr[j];
                    sum += arr[k];
                    sum += arr[l];

                    if(sum == target) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        temp.sort(null);
                        mySet.add(temp);
                    }
                }
            }
        }
    }


    List<List<Integer>> ans = new ArrayList<>(mySet);
    return ans;
}

     public static void main(String[] args) {
        int[] arr = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSum(arr, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
