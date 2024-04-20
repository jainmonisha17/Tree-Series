import java.util.*;

public class FindDuplicatesSorting {

    public boolean findDuplicates(int[] nums) {
        Arrays.sort(nums); // sort the array
        // use the loop to compare each element with its next element

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindDuplicatesSorting obj = new FindDuplicatesSorting();
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

// Time complexity: O(N * log N), where N is the number of elements in the array nums.
// This is because sorting the array takes O(N * logN) time

// Space complexity: O(1) or O(n), depending on the sorting algorithm used. If an in-place sorting algorithm is used. the space complexity will be O(1).
// if sorting algorithm creates a new array is used, the sc will be O(N), 'N' is the no of elements in the array.

// Another approach is to sort the array first and then check for duplicates.

// We'll sort the array and then iterate through it, comparing each element with the next one.

// If any two elements are the same, we'll return true. If we've gone through the entire array and haven't found any duplicates, we'll return false.
