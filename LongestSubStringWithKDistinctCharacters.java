import java.util.*;

public class LongestSubStringWithKDistinctCharacters {
    public int findLength(String str, int k) {

        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }

        int start = 0;
        int maxLength = 0;

        HashMap<Character, Integer> myHashMap = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {

            //myHashMap.put(str.charAt(end), myHashMap.getOrDefault(str.charAt(end), 0) + 1);
            char endChar = Character.toLowerCase(str.charAt(end));
            myHashMap.put(endChar, myHashMap.getOrDefault(endChar, 0) + 1);
            

            // shrink the sliding window, until we are left with 'k' disnct characters, in
            // the frequency map

            while (myHashMap.size() > k) { //shrink the window
                // myHashMap.put(str.charAt(start), myHashMap.get(str.charAt(start)) - 1);
                char startChar = Character.toLowerCase(str.charAt(start));
                myHashMap.put(startChar, myHashMap.get(startChar) - 1);

                if (myHashMap.get(startChar) == 0) {
                    myHashMap.remove(startChar);
                }

                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1); // window length end - start + 1
        }
        return maxLength;
    }
    
    public int findLengthFormatted(String str, int k) {
        int length = str.length();
        if (str == null || length == 0 || length < k) {
            throw new IllegalArgumentException();
        }
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> myHashMap = new TreeMap<>();

        for (int end = 0; end < str.length(); end++) {
            char endChar = Character.toLowerCase(str.charAt(end));
            myHashMap.put(endChar, myHashMap.getOrDefault(endChar, 0) + 1);
            while (myHashMap.size() > k) { //shrink the window
                char startChar = Character.toLowerCase(str.charAt(start));
                myHashMap.put(startChar, myHashMap.get(startChar) - 1);
                if (myHashMap.get(startChar) == 0) {
                    myHashMap.remove(startChar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1); // window length end - start + 1
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStringWithKDistinctCharacters sol = new LongestSubStringWithKDistinctCharacters();

        System.out.println("Length of the longest substring: " + sol.findLength("Araaci ", 2)); // 4
        System.out.println("Length of the longest substring: " + sol.findLength("CBbebi ", 3)); // 5
    }

}
