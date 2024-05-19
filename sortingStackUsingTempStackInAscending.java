import java.util.*;

public class sortingStackUsingTempStackInAscending {
    public Stack<Integer> sortStack(Stack<Integer> input) {
        // create temporary stack to hold sorted elements
        Stack<Integer> tempStack = new Stack<Integer>();

        // Iterate through the input stack until its empty
        while (!input.isEmpty()) {
            // pop the top element from the input stack
            int inputElement = input.pop();

            // compare the input element of the input
            // with the top element of the temporary stack
            // and move elements from temp stack to input stack
            // until the correct position is found

            while (!tempStack.isEmpty() && tempStack.peek() > inputElement) {
                input.push(tempStack.pop());
            }
            // else push the current element of input stack to temp stack in the corrected
            // sorted position
            tempStack.push(inputElement);
        }
        return tempStack;
    }

    public static void main(String[] args) {
        sortingStackUsingTempStackInAscending sol = new sortingStackUsingTempStackInAscending();

        // Create a new stack called 'input'
        Stack<Integer> input = new Stack<Integer>();

        // Add elements to the input stack
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // display the original input stack
        System.out.println("Input: " + input);

        // call the sort method to sort the input stack
        Stack<Integer> sortedOutput = sol.sortStack(input);

        // display the sorted output stack
        System.out.println("Sorted output: Temp Stack " + sortedOutput);
    }
}

// Time Complexity of the sort stack is O(N ^ 2), where n is the number of elements in the stack
// Coz, in worst case, for every element that we pop from the input stack, we might have to pop all the elements in the temporary stack
// and push them back to the original stack to find the correct place to insert the element. 
// Since we have to do this for all n elements. so N * N = N ^ 2

// Space complexity is O(n).
// Coz we use an additional temporary stack to sort the elements.
// In the worst case, this temporary stack could store all the elements of the original stack.
// Thus, SC is direcly proportational to the number of elements in the input stack, making it linear, O(N)

// The sc doest not count the input size itself(the input stack in this case), it only counts the extra space we use 
// related to the size of the input. If we were to count the input size as well, the total space used would be O(2*N), but since we drop the constant factor when expressing sc, so it remains O(N)