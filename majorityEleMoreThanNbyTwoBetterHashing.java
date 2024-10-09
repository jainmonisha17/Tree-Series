import java.util.*;
import java.util.Map.Entry;


public class majorityEleMoreThanNbyTwoBetterHashing {

    public static int majorityEle(int[] arr) {

        int n = arr.length;

        HashMap<Integer, Integer> myMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int value = myMap.getOrDefault(arr[i], 0);

            myMap.put(arr[i], value + 1);
        }

        // searching for majority element

        for(Entry<Integer, Integer> it: myMap.entrySet()) {
            if(it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }


        return -1;
    }


     public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityEle(arr);
        System.out.println("The majority ele is:  " + ans);
    }
}
