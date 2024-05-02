public class LongestSubarrayWithOnesAfterReplacement {
    public int findLength(int[] arr, int k) {
        int length = arr.length;
        if (arr == null || length < k) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int start = 0;
        int end = 0;
        int maxLength = 0;
        int flipOnes = 0;

        while (end < length) {
            if (arr[end] == 1) {
                end++;
            } else {
                // if arr[end] == 0
                if (flipOnes < k) { // if it is zero, make one. So flip zero to one which is flipOnes
                    flipOnes++;
                    end++;
                } else {
                    while (flipOnes >= k) {
                        if (arr[start] == 0) {
                            flipOnes--;
                        }
                        start++;
                    }
                }
            }
            
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;

    }

    public static void main(String[] args) {
        LongestSubarrayWithOnesAfterReplacement sol = new LongestSubarrayWithOnesAfterReplacement();
        System.out.println(
                sol.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(
                sol.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
