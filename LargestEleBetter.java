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

public class LargestEleBetter {
    static int findLargest(int arr[]) {
        int largest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String args[]) {
        int arr[] = {2, 5, 1, 3, 0};
        System.out.println("The largest elem is " + findLargest(arr));
    }
}


// TC -> O(N)
// Sc -> O(1)
