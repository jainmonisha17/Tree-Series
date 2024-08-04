import java.util.*;

public class RotateElementsToLeftRecursion {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        RotateLeftByKRecursion(arr, k);
        int n = arr.length;

        System.out.println("After Rotating the k elemnts to the left the array looks like this: ");

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + "  ");
            System.out.print(" ");
        }
    }

    public static void RotateLeftByKRecursion(int[] arr, int k) {
        int n = arr.length;
        //1. Reverse first k elements
            Reverse(arr, 0, k - 1);

        //2. Reverse last 'n - k' elements
            Reverse(arr, k, n - 1);
        //3. Reverse the whole array
            Reverse(arr, 0, n - 1);

    }

    public static void Reverse(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
