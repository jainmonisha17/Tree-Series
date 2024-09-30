
public class MoveZerosBetterSolution {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int[] ans = moveZeros(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(ans[i]);
        }
        System.out.println(" ");
    }


    public static int[] moveZeros(int[] arr) {
        int j = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }

        if(j == -1) {
            return arr;
        }

        for(int i = j + 1; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
}

// TC -> we have used 2 for loops one for finding zero and assigning j to zero 
// other one is for putting i next to j -> i = j + 1 
// but we are only traversing the array once

// TC -> O(N) 

// SC -> O(1) we are not using any extra space to solve this move all zeros to the end problem.
