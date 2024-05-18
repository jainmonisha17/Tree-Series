import java.util.*;

public class reverseString {
    
    public String reverseString(String s) {
        Stack<Character> myStack = new Stack<>();

        for(char c: s.toCharArray()) {
            myStack.push(c);
        }

        StringBuilder myStringBuilder = new StringBuilder();

        while(!myStack.isEmpty()) {
            myStringBuilder.append(myStack.pop());
        }


        return myStringBuilder.toString();
    }

    public static void main(String[] args) {
        reverseString rs = new reverseString();

        // Test cases
        System.out.println(rs.reverseString("Hello, World!")); // Output: "!dlroW ,olleH"
        System.out.println(rs.reverseString("OpenAI")); // Output: "IAnepO"
        System.out.println(rs.reverseString("Stacks are fun!")); // Output: "!nuf era skcatS"
    }
}

// "Hello World!"
// myStack -> ['H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd']
// myStringBuilder -> myStack.pop
// myStringBuilder -> ["dlroW olleH"]
// myStringBuilder to string
// "dlroW olleH"

// Time Complexity: O(N), where n is the length of the input string. This is because we iterate through the string only once to push all characters into the stack and then another time to pop all the characters out of the stack. O(2 * N) => O(N)
// Space Complexity: O(N), where n is the length of the input string, This is because we use a stack to hold all characters of the stirng.