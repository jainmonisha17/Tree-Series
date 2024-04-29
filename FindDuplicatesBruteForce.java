import java.util.*;

class FindDuplicatesBruteForce {
    public static boolean findDuplicates(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
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
    

// Time Complexity: It's O(N ^ 2) because we need to compare each element with every other element present in the array of size N
// Space complexity: It's O(1), because we need only few variables to store the indices.
