/*
 * Find the Largest element in an array
Problem Statement: Given an array, we have to find the largest element
 in the array.

 Input: arr[] = {8,10,5,7,9};
Output: 10
Explanation: 10 is the largest element in the array.

1. Sorting: 
Intution behind this is to sort the array in ascending order, hence the largest element will be the last index of the arraky

Approach:
1. Sort the arr
2. print the size of the arr - 1)th index


Before sorting: arr[] = {2,5,1,3,0};

After sorting: arr[] = {0,1,2,3,5};

Hence answer : arr[sizeofthearray-1] =5
 * 
 */

import java.util.*;

public class LargestEle {
    static int sort(int arr[]) {
        Arrays.sort(arr);
        return arr[arr.length - 1]; // last element
    }

    public static void main(String args[]) {
        int arr[] = {2, 5, 1, 3, 0};
        System.out.println("The largest elem is " + sort(arr));
    }
}


// TC -> for sorting o(logn)
// TC -> O(logN * N), N coz after sorting again it needs to go to the last ele to return largest element
// SC -> O(N)