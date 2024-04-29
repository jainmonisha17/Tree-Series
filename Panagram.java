
// A panagram is a sentence where every letter of teh English alphavet appears atleast once
// Given a string sentence containtin English Letters (Lower or Upper case), return 'true' if sentence is a panagram or false otherwise
// NOTE: The given sentence might contain other charactesr like digits or spaces, your solution should handle these too.

// Example 1:

// Input: sentence = "TheQuickBrownFoxJumpsOverTheLazyDog"
// Output: true
// Explanation: The sentence contains at least one occurrence of every letter of the English alphabet either in lower or upper case.
// Example 2:

// Input: sentence = "This is not a pangram"
// Output: false
// Explanation: The sentence doesn't contain at least one occurrence of every letter of the English alphabet.
// Constraints:

// 1 <= sentence.length <= 1000
// sentence consists of lowercase English letters.

import java.util.*;

public class Panagram {


    public static void main(String[] args) {
        Panagram obj = new Panagram();
        System.out.println(obj.checkIfPanagram("TheQuickBrownFoxJumpsOverTheLazyDog"));
        // Test case 2: "This is not a pangram"
        // Expected output: false
        System.out.println(obj.checkIfPanagram("This is not a pangram"));

        // Test case 3: "abcdef ghijkl mnopqr stuvwxyz"
        // Expected output: true
        System.out.println(obj.checkIfPanagram("abcdef ghijkl mnopqr stuvwxyz"));

        // Test case 4: ""
        // Expected output: false
        System.out.println(obj.checkIfPanagram(""));

        // Test case 5: "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        // Expected output: true
        System.out.println(obj.checkIfPanagram("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));

    }

    public boolean checkIfPanagram(String sentence) {
        // 1. convert the given sentence to lower case
        // 2. convert lower cased sentence to char array
        // 3. Iterate over each character

        // 1. Convert the given sentence to lower case
        String lowerCaseSentence = sentence.toLowerCase();

        // 2. convert lower cased sentence to char array
        char[] charArray = lowerCaseSentence.toCharArray();

        // Initialize a hashset to store unique letters
        HashSet<Character> mySet = new HashSet<>();

        // Iterate over hashset to store unique letters
        for(char currChar: charArray) {
            if(Character.isLetter(currChar)) {
                mySet.add(currChar);
            }
        } 

        // Return true if set size is 26 (total number of alphabets)
        return mySet.size() == 26;
    }
}
