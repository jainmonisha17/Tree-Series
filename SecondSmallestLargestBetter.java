import java.util.*;

public class SecondSmallestLargestBetter {
    private static void getElemnts(int[] arr, int n) {
        // Edge cases

        if(n == 0 || n == 1) {
            System.out.print(-1);
            System.out.print("");
            System.out.print(-1);
            System.out.print("\n");
        }

        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            small = Math.min(small, arr[i]);
            large = Math.max(large, arr[i]);
        }

        for(int i = 0; i < n; i++) {
            if()
        }
    }
}
