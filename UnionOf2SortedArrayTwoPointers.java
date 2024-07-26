import java.util.*;

public class UnionOf2SortedArrayTwoPointers {
    public static void main(String[] args) {
      
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};

        ArrayList<Integer> ans = findUnion(arr1, arr2);
        System.out.println("Union of arr1 and arr2 is: "); 
        for(int i = 0; i < ans.size(); i++) {
            System.out.print(i + "   ");
        }
    }

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while(i < n && j < m) {
            if(arr1[i] <= arr2[j]) { // case 1 & 2
                if(union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;

            } else {
                if(union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        while(i < n) {
            if(union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
                i++;
            }
        }
        
        while(j < m) {
            if(union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
                j++;
            }
        }
        return union;
    }
}

// Take 2pointerse i, j both at 0th index of arr1 and arr2
// create empty Arraylist name it as union 
// union is nothing but distinct elements of both arr1 and arr2
// 3 cases in using 2 pointers i and j
// arr1[i] == arr2[i]
// arr1[i] < arr2[i]
// arr1[i] > arr2[i]
// return union

// Tc-> O(n + m) i runs for n times and j runs for m times
// SC -> O(n + m) for returning union arraylist