/*
Check if an Array is Sorted

Problem Statement: Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, Else return False.

Example 2:
Input: N = 5, array[] = {5,4,6,7,8}
Output: False.
Explanation: The given array is Not sorted i.e Every element in the array is not smaller than or equal to its next values, So the answer is False.

Here element 5 is not smaller than or equal to its future elements.



*/
// Brute Force:
/*
taking i and j
1. we will start with the element at the Oth index, and will compare it with all of its future elements that are present in the array
2. If at any point of time we find element is smaller that or equal to all of its future elemens we will move to the next index/elements until the whole array is traversed.
3. If any current element is greater than its future elements, will simply retur falsee.
4. Edge cases: iff size is zero or one (N == 0 or N == 1) and the entire arr is traversed successfully then we will simply return True.
*/ 

class Solution {
     static boolean isSorted(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
     }

        
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 4, 5, 4};
        System.out.println(isSorted(arr));
    }
}


// TC -> O(N^2) using i and j
// SC -> O(1)
































