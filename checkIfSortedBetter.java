/* 

When we say the array is sorted in ascending order?

if the previous element is smaller than or equal to the current element we can say two elements are sorted
Edge cases: if N == 0 or N == 1 return True
Edge case 2: True if the whole array is traversed successfully
*/

public class checkIfSortedBetter {
 public static boolean isSorted(int arr[]) {
    int n = arr.length;
    
    for(int i = 1; i < n; i++) {
        if(arr[i] < arr[i - 1]) {
            return false;
        }
    }
    return true;
 }   

 public static void main(String args[]) {
    int arr[] = {1, 2, 3, 4, 5, 5, 55};

    System.out.println(isSorted(arr));
 }
}

// TC -> O(N)
// SC -> O(1)