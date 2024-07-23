import java.util.*;

public class UnionOf2SortedArraysHashMap {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};

        ArrayList<Integer> union = findUnion(arr1, arr2);
        System.out.println("Union of arr1 and arr2 is ");

        for(int i = 0; i < union.size(); i++) {
            System.out.print(i + "   ");
        }
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<Integer>();

        for(int i = 0; i < n1; i++) {
            myHashMap.put(arr1[i], myHashMap.getOrDefault(arr1[i], 0) + 1);
        }

        for(int i = 0; i < n2; i++) {
            myHashMap.put(arr2[i], myHashMap.getOrDefault(arr2[i], 0) + 1);
        }

        for(int it: myHashMap.keySet()) {
            union.add(it);
        }
        return union;
    }
}

//TC -> O(n1 + n2)log(n1+n2)
// Inserting a key in hashmap takes logN times and storing in a hashmap takes n1+ n2.
// At max it stores n1 + n2 elements(where there are no common elements in arr1, arr2 both are distinct)

// SC -> If union arraylist is considered O(1)

// Using HashMap also takes the same time, On average insertion in unordered_map takes O(1) time but sorting the union vector takes O((m+n)log(m+n))  time. Because at max union vector can have m+n elements.
// O(1) for unordered hashmap


// TC -> O(n1logn) for set.add(arr1[i])
// O(n2logn) for set.add(arr2[i])
// O(n1 + n2) union 

// SC -> O(n1 + n2) -> external setfor putting n1 & n2
// SC -> O(n1 + n2) to return the set