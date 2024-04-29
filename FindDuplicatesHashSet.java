import java.util.*;

public class FindDuplicatesHashSet {
    public boolean findDuplicates(int[] nums) {
        Set<Integer> mySet = new HashSet<>(); // Use hashset to store unique elements
        for(int x: nums) {
            if(mySet.contains(x)) {
                return true; // if set already contains current element means it contains duplicates return true.
            }
        }
        return false;
    } 

public static void main(String[] args) {
    FindDuplicatesBruteForce obj = new FindDuplicatesBruteForce();
    int[] nums1 = {1, 2, 3, 4};
    System.out.println(obj.findDuplicates(nums1)); // Expected output: false

    int[] nums2 = {1, 2, 3, 1};
    System.out.println(obj.findDuplicates(nums2)); // Expected output: true
    
    int[] nums3 = {};
    System.out.println(obj.findDuplicates(nums3)); // Expected output: false
    
    int[] nums4 = {1, 1, 1, 1};
    System.out.println(obj.findDuplicates(nums4)); // Expected output: true
    }
}

// Time complexity: The algorithm takes O(N) where N is the number of elements in the input array. This is because we iterate the array onlly once
// Space complexity: The algorithm takes O(N), as it stores the num element in a set

// Using HashSet

// We can use the set data structure to check for duplicates in an array

// Since a set can only hold unique elements, we can check if the elements in the given array are present more than once by adding them to a set. 
// This way we can determine if there are any duplicates in the Array

// This approach works as follows

// 1. A set names mySet is createsd to store unique elements
// 2. The algorithm then iterates through the input array nums
// 3. For each element 'x' in the array, the algorithm checks if 'x' is already in the MediaSyncEvent
// 4. If 'x' is present, algoritm returns true indicating that a duplicate has been found
// 5. If 'x' is not present, algorithm adds 'x' the current num element into to mySet
// 6. The iteration continues until all elements in the array have been PeriodicAdvertisingParameters
// 7. If no duplicates are found, the algorithm return false.