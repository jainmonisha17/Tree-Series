
import java.util.*;
public class Panagram1 {

    public boolean checkIfPanagram(String sentence) {
        String lowerCasedSentence = sentence.toLowerCase();
        char[] charArray = lowerCasedSentence.toCharArray();
        Set<Character> mySet = new HashSet<>();
        for(char currChar: charArray) {
            if(Character.isLetter(currChar)) {
                mySet.add(currChar);
            }
        }
        return mySet.size() == 26;

    }
    
    public static void main(String[] args) {
        Panagram1 obj = new Panagram1();
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
}

// We can use a HashSet to check if the given sentence is a pangram or not. The HashSet will be used to store all the unique characters in the sentence. The algorithm works as follows:

// Converts the sentence to lowercase.
// Iterate over each character of the sentence using a loop.
// Add each character to the HashSet.
// After looping through all characters, compare the size of the HashSet with 26 (total number of alphabets). If the size of the HashSet is equal to 26, it means the sentence contains all the alphabets and is a pangram, so the function will return true. Otherwise, it will return false.
// Time Complexity
// Iterating Over Characters: The main operation in the code is iterating over each character in the input string. If the length of the input string is n, this iteration occurs n times.

// Set Operations: For each character, the code performs a constant-time operation—adding the character to a HashSet if it's a letter. The time complexity for adding an element to a HashSet is typically .

// Overall Time Complexity: Considering the iteration over n characters and constant-time set operations, the total time complexity is , where n is the length of the sentence.

// Space Complexity
// HashSet Storage: The HashSet seen is used to store the distinct characters encountered in the sentence. In the worst-case scenario, it will store all 26 letters of the alphabet.

// Constant Size Set: Regardless of the input sentence length, the HashSet can only grow up to a size of 26. This is because it only stores distinct English alphabet letters.

// Overall Space Complexity: Given the HashSet's maximum size is constant (at most 26 characters), the space complexity is , meaning it is constant.

// Conclusion
// Time Complexity: , where n is the length of the input string.
// Space Complexity:  (constant space, independent of input string length).