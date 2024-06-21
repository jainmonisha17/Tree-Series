
/* 
Find Second Smallest and Second Largest Element in an array
Problem Statement: Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
Example 1:
Input: [1,2,4,7,7,5]
Output: Second Smallest : 2
	Second Largest : 5
Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2

Example 2:
Input: [1]
Output: Second Smallest : -1
	Second Largest : -1
Explanation: Since there is only one element in the array, it is the largest and smallest element present in the array. There is no second largest or second smallest element present.

*/


// Brute force (sorting)

// Approach:
// Sort the array in ascending order
// The ele present at the 2nd index is the second smallest
// the ele present at teh 2nd index from the end is the second largest

import java.util.*;

public class SecondSmallestSecondLargest {
    private static void getElment(int[] arr, int n) {
        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[n - 2];
        System.out.println("Second smallest " + small);
        System.out.println("Second largest " + large);
    } 

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        getElment(arr, n);
    }
}

// TC -> O(N log N), sort = log N and finding 2nd small and 2nd large N
// SC -> O(1)

