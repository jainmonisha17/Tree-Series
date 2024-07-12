import java.util.*;

public class MajorityEleMoreThanNByTwoBrute {
    
    public static int majorityEle(int []v) {
        int n = v.length;

        for(int i = 0; i < n; i++) {
            int count = 0;

            for(int j = 0; j < n; j++) {
                if(v[j] == v[i]) {
                    count++;
                }
            }

            if(count > (n / 2)) 
                return;
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityEle(arr);
        System.out.println("The majority ele is:  " + ans);
    }
}

